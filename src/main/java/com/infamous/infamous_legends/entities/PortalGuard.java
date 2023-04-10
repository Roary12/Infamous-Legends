package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.PortalGuardAi;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.interfaces.IHasCustomExplosion;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;
import com.mojang.serialization.Dynamic;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinArmPose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class PortalGuard extends AbstractPiglin {

	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 45;
	public final int attackAnimationActionPoint = 23;
	
	public AnimationState shootAnimationState = new AnimationState();
	public int shootAnimationTick;
	public final int shootAnimationLength = 60;
	public final int shootAnimationActionPoint = 26;
	
	public AnimationState reelInBallAnimationState = new AnimationState();
	public int reelInBallAnimationTick;
	public final int reelInBallAnimationLength = 60;
	public final int reelInBallAnimationActionPoint = 11;
	
	public boolean playingIdleShootingAnimation;
	
	public int hasWreckingBallTime;
	
	protected static final ImmutableList<SensorType<? extends Sensor<? super PortalGuard>>> SENSOR_TYPES = ImmutableList
			.of(SensorTypeInit.CUSTOM_NEAREST_LIVING_ENTITIES.get(), SensorTypeInit.CUSTOM_NEAREST_PLAYERS.get(), SensorType.NEAREST_ITEMS,
					SensorType.HURT_BY, SensorTypeInit.LEGENDS_PIGLIN_SPECIFIC_SENSOR.get());
	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.NEAREST_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER,
			MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS,
			MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY,
			MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET,
			MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH,
			MemoryModuleType.ANGRY_AT, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.HOME, 
			MemoryModuleTypeInit.SHOOT_COOLING_DOWN.get());
	   
	public PortalGuard(EntityType<? extends PortalGuard> type, Level level) {
		super(type, level);		
		this.xpReward = 20;
	}
	
	@Override
	public float getStepHeight() {
		return 1.0F;
	}
	
	@Override
	public float getVoicePitch() {
		return super.getVoicePitch() * 0.45F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 150.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.275F).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.ATTACK_DAMAGE, 17.5D).add(Attributes.KNOCKBACK_RESISTANCE, 1D).add(Attributes.ARMOR, 12.5D);
	}
	
	@Override
	public boolean doHurtTarget(Entity p_21372_) {
		boolean flag = super.doHurtTarget(p_21372_);
		System.out.print("\r\n" + "hurting");
		if (p_21372_ instanceof LivingEntity) {
			System.out.print("\r\n" + "disabling shield");
			MiscUtils.disableShield(((LivingEntity)p_21372_), 120);
		}
		return flag;
	}
	
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_35058_, DifficultyInstance p_35059_,
			MobSpawnType p_35060_, @Nullable SpawnGroupData p_35061_, @Nullable CompoundTag p_35062_) {
		PortalGuardAi.initMemories(this);
		return super.finalizeSpawn(p_35058_, p_35059_, p_35060_, p_35061_, p_35062_);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		Vec3 velocity = this.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayIdleShootingAnimation = this.playingIdleShootingAnimation && this.attackAnimationTick <= 0 && this.shootAnimationTick <= 0 && this.reelInBallAnimationTick <= 0;
		
		boolean shouldPlayWalkAnimation = speed > 0 && !shouldPlayIdleShootingAnimation && this.attackAnimationTick <= 0 && this.shootAnimationTick <= 0 && this.reelInBallAnimationTick <= 0;
			
		if (shouldPlayWalkAnimation) {
			Vec3 particlePos = PositionUtils.getOffsetPos(this, 1.25, 0, -1.5, this.yBodyRot);
			if (this.random.nextInt(5) == 0) {
				this.level.addParticle(ParticleTypeInit.DUST.get(), particlePos.x, particlePos.y, particlePos.z, 0, 0, 0);
			}
			if (this.random.nextBoolean()) {
		         int i = Mth.floor(this.getX());
		         int j = Mth.floor(this.getY() - (double)0.2F);
		         int k = Mth.floor(this.getZ());
		         BlockPos pos = new BlockPos(i, j, k);
		         BlockState blockstate = this.level.getBlockState(pos);
		         if (!blockstate.isAir()) {
		            this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), 4.0D * ((double)this.random.nextFloat() - 0.5D), 0.5D, ((double)this.random.nextFloat() - 0.5D) * 4.0D);
		         }
			}
		}
		
		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.level.isClientSide && this.attackAnimationTick <= 0) {
			this.attackAnimationState.stop();
		}

		if (this.shootAnimationTick > 0) {
			this.shootAnimationTick--;
		}
		
		if (this.level.isClientSide && this.shootAnimationTick <= 0) {
			this.shootAnimationState.stop();
		}
		
		if (!this.level.isClientSide && this.shootAnimationTick == 1) {
			this.playingIdleShootingAnimation = true;
			this.level.broadcastEntityEvent(this, (byte)9);
		}
		
		if (this.reelInBallAnimationTick > 0) {
			this.reelInBallAnimationTick--;
		}
		
		if (this.level.isClientSide && this.reelInBallAnimationTick <= 0) {
			this.reelInBallAnimationState.stop();
		}
		
		if (this.hasWreckingBallTime > 0) {
			this.hasWreckingBallTime --;
		}
		
		if (!this.level.isClientSide && this.hasWreckingBallTime <= 0 && this.playingIdleShootingAnimation == true) {
			this.playingIdleShootingAnimation = false;
			this.level.broadcastEntityEvent(this, (byte)10);
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else if (p_219360_ == 11) {
			this.shootAnimationTick = this.shootAnimationLength;
			this.shootAnimationState.start(this.tickCount);
		} else if (p_219360_ == 8) {
			this.reelInBallAnimationTick = this.reelInBallAnimationLength;
			this.reelInBallAnimationState.start(this.tickCount);
		} else if (p_219360_ == 9) {
			this.playingIdleShootingAnimation = true;
		} else if (p_219360_ == 10) {
			this.playingIdleShootingAnimation = false;
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}

	protected Brain.Provider<PortalGuard> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return PortalGuardAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<PortalGuard> getBrain() {
		return (Brain<PortalGuard>) super.getBrain();
	}
		   
	@Override
	protected boolean canHunt() {
		return false;
	}

	public boolean wantsToPickUp(ItemStack p_35078_) {
		return false;
	}

	protected void customServerAiStep() {
		this.level.getProfiler().push("portalGuardBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		PortalGuardAi.updateActivity(this);
		PortalGuardAi.maybePlayActivitySound(this);
		super.customServerAiStep();
	}
	
	@Override
	public boolean isLeftHanded() {
		return false;
	}
		   
	@Override
	public PiglinArmPose getArmPose() {
		return this.isAggressive() && this.isHoldingMeleeWeapon() ? PiglinArmPose.ATTACKING_WITH_MELEE_WEAPON
				: PiglinArmPose.DEFAULT;
	}
	
	public boolean hurt(DamageSource p_35055_, float p_35056_) {
		boolean flag = super.hurt(p_35055_, p_35056_);
		if (this.level.isClientSide) {
			return false;
		} else {
			if (flag && p_35055_.getEntity() instanceof LivingEntity) {
				PortalGuardAi.wasHurtBy(this, (LivingEntity) p_35055_.getEntity());
			}

			return flag;
		}
	}

	@Override
	protected boolean isImmuneToZombification() {
		return true;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.PIGLIN_BRUTE_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource p_35072_) {
		return SoundEvents.PIGLIN_BRUTE_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.PIGLIN_BRUTE_DEATH;
	}

	protected void playStepSound(BlockPos p_35066_, BlockState p_35067_) {
		this.playSound(SoundEvents.PIGLIN_BRUTE_STEP, 1.0F, 1.0F);
	}

	public void playAngrySound() {
		this.playSound(SoundEvents.PIGLIN_BRUTE_ANGRY, 1.0F, this.getVoicePitch());
	}

	protected void playConvertedSound() {
		this.playSound(SoundEvents.PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED, 1.0F, this.getVoicePitch());
	}
}
