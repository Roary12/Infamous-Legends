package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.SporeMedicAi;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.utils.PositionUtils;
import com.mojang.serialization.Dynamic;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

public class SporeMedic extends AbstractPiglin {

	public boolean shooting;
	
	protected static final ImmutableList<SensorType<? extends Sensor<? super SporeMedic>>> SENSOR_TYPES = ImmutableList
			.of(SensorTypeInit.CUSTOM_NEAREST_LIVING_ENTITIES.get(), SensorTypeInit.CUSTOM_NEAREST_PLAYERS.get(), SensorType.NEAREST_ITEMS,
					SensorType.HURT_BY, SensorTypeInit.SPORE_MEDIC_SPECIFIC_SENSOR.get());
	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.NEAREST_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER,
			MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS,
			MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY,
			MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET,
			MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH,
			MemoryModuleType.ANGRY_AT, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.HOME,
			MemoryModuleTypeInit.HEAL_TARGET.get());
	
	public SporeMedicHealingZone subEntity;
	   
	public SporeMedic(EntityType<? extends SporeMedic> type, Level level) {
		super(type, level);		
		this.xpReward = 5;
		
		this.subEntity = new SporeMedicHealingZone(this);
	}
	
	@Override
	public float getVoicePitch() {
		return super.getVoicePitch() * 1.35F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ARMOR, 3.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.325F);
	}
	
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_35058_, DifficultyInstance p_35059_,
			MobSpawnType p_35060_, @Nullable SpawnGroupData p_35061_, @Nullable CompoundTag p_35062_) {
		SporeMedicAi.initMemories(this);
		return super.finalizeSpawn(p_35058_, p_35059_, p_35060_, p_35061_, p_35062_);
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.shooting = true;
		} else if (p_219360_ == 11) {
			this.shooting = false;
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.level.isClientSide && this.shooting) {
			Vec3 particlePos = PositionUtils.getOffsetPos(this, Math.cos(SineWaveAnimationUtils.getTick(this) * (1 * 100)) * (1 * -0.6), 18 / 16.0F, 18 / 16.0F, this.yBodyRot);
			Vec3 particleMotion = PositionUtils.getOffsetMotion(this, this.random.nextGaussian() * 0.125, this.random.nextGaussian() * 0.125, 0.25, this.yBodyRot);
			this.level.addParticle(ParticleTypeInit.SPORE_CLOUD.get(), particlePos.x, particlePos.y, particlePos.z, particleMotion.x, particleMotion.y, particleMotion.z);
		}
		
		this.updatePart();
	}
	
	protected void updatePart() {
		Vec3 partPos = PositionUtils.getOffsetPos(this, 0, -1, 40 / 16.0F, this.yBodyRot);
		this.movePart(this.subEntity, partPos.x, partPos.y, partPos.z);
		this.subEntity.tickHealing();
	}
	
    protected void movePart(SporeMedicHealingZone part, double dX, double dY, double dZ)
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
    public boolean canPickUpLoot() {
    	return false;
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

	protected Brain.Provider<SporeMedic> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return SporeMedicAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<SporeMedic> getBrain() {
		return (Brain<SporeMedic>) super.getBrain();
	}
		   
	@Override
	protected boolean canHunt() {
		return false;
	}

	protected void customServerAiStep() {
		this.level.getProfiler().push("sporeMedicBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		SporeMedicAi.updateActivity(this);
		super.customServerAiStep();
	}
		   
	@Override
	public PiglinArmPose getArmPose() {
		return this.isAggressive() && this.isHoldingMeleeWeapon() ? PiglinArmPose.ATTACKING_WITH_MELEE_WEAPON
				: PiglinArmPose.DEFAULT;
	}

	@Override
	protected boolean isImmuneToZombification() {
		return true;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.PIGLIN_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource p_35072_) {
		return SoundEvents.PIGLIN_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.PIGLIN_DEATH;
	}

	protected void playStepSound(BlockPos p_35066_, BlockState p_35067_) {
		this.playSound(SoundEvents.PIGLIN_STEP, 0.15F, 1.0F);
	}


	protected void playConvertedSound() {
		this.playSound(SoundEvents.PIGLIN_CONVERTED_TO_ZOMBIFIED, 1.0F, this.getVoicePitch());
	}
	   
}
