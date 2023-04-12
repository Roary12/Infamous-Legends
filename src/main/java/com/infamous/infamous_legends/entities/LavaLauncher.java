package com.infamous.infamous_legends.entities;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.LavaLauncherAi;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;
import com.mojang.serialization.Dynamic;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.hoglin.HoglinBase;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

public class LavaLauncher extends Monster implements Enemy, HoglinBase {
	
	private static final EntityDataAccessor<Integer> CLIENT_ATTACK_TARGET_ID = SynchedEntityData
			.defineId(LavaLauncher.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> PIGLIN_HEALTH = SynchedEntityData
			.defineId(LavaLauncher.class, EntityDataSerializers.FLOAT);
	   
	protected static final ImmutableList<? extends SensorType<? extends Sensor<? super LavaLauncher>>> SENSOR_TYPES = ImmutableList
			.of(SensorTypeInit.CUSTOM_NEAREST_LIVING_ENTITIES.get(), SensorTypeInit.CUSTOM_NEAREST_PLAYERS.get(), SensorTypeInit.LEGENDS_PIGLIN_SPECIFIC_SENSOR.get());
	protected static final ImmutableList<? extends MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.NEAREST_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER,
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
			MemoryModuleType.PATH, MemoryModuleType.ATTACK_TARGET, MemoryModuleType.ATTACK_COOLING_DOWN,
			MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.ANGRY_AT,
			MemoryModuleTypeInit.SHOOT_COOLING_DOWN.get());
	
	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 40;
	public final int attackAnimationActionPoint = 16;
	
	public AnimationState shootAnimationState = new AnimationState();
	public int shootAnimationTick;
	public final int shootAnimationLength = 75;
	public final int shootAnimationActionPoint = 19;

	public float piglinHeadXRot;
	public float piglinHeadYRot;
	
	public float piglinHeadTargetYRot;
	
	public int piglinHurtTime;
	public int piglinInvulnerableTime;
	public int piglinDeathTime;
	
	public LavaLauncherPiglin subEntity;
	
	public int piglinAmbientSoundTime;
	
	public LavaLauncher(EntityType<? extends LavaLauncher> p_34204_, Level p_34205_) {
		super(p_34204_, p_34205_);
		this.xpReward = 15;
		
		this.subEntity = new LavaLauncherPiglin(this);
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CLIENT_ATTACK_TARGET_ID, 0);
		this.entityData.define(PIGLIN_HEALTH, 20F);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag p_21484_) {
		super.addAdditionalSaveData(p_21484_);
		p_21484_.putFloat("PiglinHealth", this.getPiglinHealth());
		p_21484_.putInt("PiglinDeathTime", this.piglinDeathTime);
	}
	
	@Override
	public void readAdditionalSaveData(CompoundTag p_21450_) {
		super.readAdditionalSaveData(p_21450_);
		this.setPiglinHealth(p_21450_.getFloat("PiglinHealth"));
		this.piglinDeathTime = p_21450_.getInt("PiglinDeathTime");
	}
	
	   public void setClientAttackTarget(Entity target) {
		   if (target != null) {
			   this.entityData.set(CLIENT_ATTACK_TARGET_ID, target.getId());
		   } else {
			   this.entityData.set(CLIENT_ATTACK_TARGET_ID, 0);
		   }
	   }
	   
	   public LivingEntity getClientAttackTarget() {
		   return this.entityData.get(CLIENT_ATTACK_TARGET_ID) != 0 ? this.level.getEntity(this.entityData.get(CLIENT_ATTACK_TARGET_ID)) instanceof LivingEntity ? ((LivingEntity)this.level.getEntity(this.entityData.get(CLIENT_ATTACK_TARGET_ID))) : null : null;
	   }
	   
	   public void setPiglinHealth(float value) {
		   this.entityData.set(PIGLIN_HEALTH, value);
	   }
	   
	   public float getPiglinHealth() {
		   return this.entityData.get(PIGLIN_HEALTH);
	   }
	
	@Override
	public float getStepHeight() {
		return 1;
	}
	
	@Override
	public float getVoicePitch() {
		return super.getVoicePitch() * 0.3F;
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return true;
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
	      if (this.isAlive() && this.getPiglinHealth() > 0 && this.random.nextInt(1000) < this.piglinAmbientSoundTime++) {
	          this.resetPiglinAmbientSoundTime();
	          this.playPiglinAmbientSound();
	       }
	      
		if (this.getPiglinHealth() <= 0) {
	      ++this.piglinDeathTime;
	      if (this.piglinDeathTime == 20 && this.level.isClientSide) {
	          for(int i = 0; i < 20; ++i) {
	              double d0 = this.random.nextGaussian() * 0.02D;
	              double d1 = this.random.nextGaussian() * 0.02D;
	              double d2 = this.random.nextGaussian() * 0.02D;
	              this.level.addParticle(ParticleTypes.POOF, this.subEntity.getRandomX(1.0D), this.subEntity.getRandomY(), this.subEntity.getRandomZ(1.0D), d0, d1, d2);
	           }
	      }
		}
	      
		if (this.getDeltaMovement().horizontalDistanceSqr() > (double) 2.5000003E-7F && this.random.nextBoolean()) {
			this.level.addParticle(ParticleTypeInit.DUST.get(), this.getRandomX(0.5D), this.getY(), this.getRandomZ(0.5D), 0, 0, 0);
		}
	      
		if (this.piglinInvulnerableTime > 0) {
			this.piglinInvulnerableTime--;
		}
		
		if (this.piglinHurtTime > 0) {
			this.piglinHurtTime--;
		}
		
		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.attackAnimationTick <= 0 && this.attackAnimationState.isStarted()) {
			this.attackAnimationState.stop();
		}
		
		if (this.shootAnimationTick > 0) {
			this.shootAnimationTick--;
		}
		
		if (this.shootAnimationTick <= 0 && this.shootAnimationState.isStarted()) {
			this.shootAnimationState.stop();
		}
		
		if (this.getPiglinHealth() <= 0 && this.shootAnimationTick > 0) {
			this.shootAnimationTick = 0;
			this.shootAnimationState.stop();
		}
		
		this.updatePart();
	}
	
	public void playPiglinAmbientSound() {
		SoundEvent soundevent = this.getPiglinAmbientSound();
		if (soundevent != null) {
			this.subEntity.playSound(soundevent, 1.0F, MiscUtils.randomSoundPitch() * 1.4F);
		}

	}
	   
	public void resetPiglinAmbientSoundTime() {
		this.piglinAmbientSoundTime = -this.getAmbientSoundInterval();
	}
	
	protected void updatePart() {
		Vec3 partPos = PositionUtils.getOffsetPos(this, -1.25, 5, -1.75, this.yBodyRot);
		this.movePart(this.subEntity, partPos.x, partPos.y, partPos.z);
	}
	
    protected void movePart(LavaLauncherPiglin part, double dX, double dY, double dZ)
    {
    	Vec3 lastPos = new Vec3(part.getX(), part.getY(), part.getZ());

        part.setPos(dX, dY, dZ);

        part.xo = lastPos.x;
        part.yo = lastPos.y;
        part.zo = lastPos.z;
        part.xOld = lastPos.x;
        part.yOld = lastPos.y;
        part.zOld = lastPos.z;
    }
    
    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {    
        return new PartEntity<?>[]{this.subEntity};
    }
    
    @Override
    public void setId(int p_145769_1_) {
        super.setId(p_145769_1_);
        this.subEntity.setId(p_145769_1_ + 1);
    }
	
	@Override
	public void aiStep() {
		super.aiStep();
		
		if (this.getRandom().nextFloat() < 0.02F) {
			this.piglinHeadTargetYRot = -75 + this.random.nextInt(150);
		}
		
		if (!this.level.isClientSide) {
			if (this.getBrain().hasMemoryValue(MemoryModuleType.ATTACK_TARGET)){
				this.setClientAttackTarget(this.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get());
			} else {
				this.setClientAttackTarget(null);
			}
		}
		
		float targetHeadYRot = this.piglinHeadTargetYRot;
		float targetHeadXRot = 0;
		if (this.getClientAttackTarget() != null) {
			Vec3 headPos = PositionUtils.getOffsetPos(this, -1, 6, -1, this.yBodyRot);
			double d9 = headPos.x;
			double d1 = headPos.y;
			double d3 = headPos.z;
			double d4 = this.getClientAttackTarget().getX() - d9;
			double d5 = this.getClientAttackTarget().getEyeY() - d1;
			double d6 = this.getClientAttackTarget().getZ() - d3;
			double d7 = Math.sqrt(d4 * d4 + d6 * d6);
			float f = (float) (Mth.atan2(d6, d4) * (double) (180F / (float) Math.PI)) - 90.0F;
			float f1 = (float) (-(Mth.atan2(d5, d7) * (double) (180F / (float) Math.PI)));
			targetHeadXRot = f1;
			targetHeadYRot = Mth.wrapDegrees(f - this.yBodyRot);
		}
		if (this.shootAnimationTick > 0) {
			targetHeadXRot = 0;
			targetHeadYRot = 0;
		}
		this.piglinHeadXRot = this.rotlerp(this.piglinHeadXRot, Mth.clamp(targetHeadXRot, -this.getMaxHeadXRot(), this.getMaxHeadXRot()), 40.0F);
		this.piglinHeadYRot = this.rotlerp(this.piglinHeadYRot, Mth.clamp(targetHeadYRot, -this.getMaxHeadYRot(), this.getMaxHeadYRot()), 10.0F);
	}
	
	private float rotlerp(float p_31443_, float p_31444_, float p_31445_) {
	      float f = Mth.wrapDegrees(p_31444_ - p_31443_);
	      if (f > p_31445_) {
	         f = p_31445_;
	      }

	      if (f < -p_31445_) {
	         f = -p_31445_;
	      }

	      return p_31443_ + f;
	   }
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else if (p_219360_ == 11) {
			this.shootAnimationTick = this.shootAnimationLength;
			this.shootAnimationState.start(this.tickCount);
		} else if (p_219360_ == 9) {
			this.piglinHurtTime = 10;
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	@Override
	public boolean doHurtTarget(Entity p_21372_) {
		boolean flag = super.doHurtTarget(p_21372_);
		if (p_21372_ instanceof LivingEntity) {
			MiscUtils.disableShield(((LivingEntity)p_21372_), 100);
		}
		return flag;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).add(Attributes.ARMOR, 10.0D).add(Attributes.FOLLOW_RANGE, 40.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.25F).add(Attributes.KNOCKBACK_RESISTANCE, (double) 1F)
				.add(Attributes.ATTACK_KNOCKBACK, 2D).add(Attributes.ATTACK_DAMAGE, 15.0D);
	}

	public boolean canBeLeashed(Player p_34219_) {
		return !this.isLeashed();
	}

	protected void blockedByShield(LivingEntity p_34246_) {
		HoglinBase.throwTarget(this, p_34246_);
	}

	protected Brain.Provider<LavaLauncher> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return LavaLauncherAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<LavaLauncher> getBrain() {
		return (Brain<LavaLauncher>) super.getBrain();
	}

	protected void customServerAiStep() {
		this.level.getProfiler().push("lavaLauncherBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		LavaLauncherAi.updateActivity(this);
	}

	protected SoundEvent getAmbientSound() {
		if (this.level.isClientSide) {
			return null;
		} else {
			return this.brain.hasMemoryValue(MemoryModuleType.ATTACK_TARGET) ? SoundEvents.HOGLIN_ANGRY
					: SoundEvents.HOGLIN_AMBIENT;
		}
	}
	
	protected SoundEvent getPiglinAmbientSound() {
		if (this.level.isClientSide) {
			return null;
		} else {
			return this.brain.hasMemoryValue(MemoryModuleType.ATTACK_TARGET) ? SoundEvents.PIGLIN_BRUTE_ANGRY
					: SoundEvents.PIGLIN_BRUTE_AMBIENT;
		}
	}

	protected SoundEvent getHurtSound(DamageSource p_34244_) {
		return SoundEvents.HOGLIN_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.HOGLIN_DEATH;
	}

	protected void playStepSound(BlockPos p_34231_, BlockState p_34232_) {
		this.playSound(SoundEvents.HOGLIN_STEP, 1.25F, 1.0F);
	}

	public void playAngrySound() {
		this.playSound(SoundEvents.HOGLIN_ANGRY, 1.0F, this.getVoicePitch());
	}
	
	@Override
	protected float getSoundVolume() {
		return 2.0F;
	}

	@Override
	public int getAttackAnimationRemainingTicks() {
		return 0;
	}
}