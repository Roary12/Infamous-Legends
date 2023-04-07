package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.WarpedBomberAi;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.interfaces.IHasCustomExplosion;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;
import com.mojang.serialization.Dynamic;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class WarpedBomber extends AbstractPiglin implements IHasCustomExplosion {

	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 7;
	public final int attackAnimationActionPoint = 1;
	
	protected static final ImmutableList<SensorType<? extends Sensor<? super WarpedBomber>>> SENSOR_TYPES = ImmutableList
			.of(SensorTypeInit.CUSTOM_NEAREST_LIVING_ENTITIES.get(), SensorTypeInit.CUSTOM_NEAREST_PLAYERS.get(), SensorType.NEAREST_ITEMS,
					SensorType.HURT_BY, SensorType.PIGLIN_BRUTE_SPECIFIC_SENSOR);
	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.NEAREST_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER,
			MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS,
			MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY,
			MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET,
			MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH,
			MemoryModuleType.ANGRY_AT, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.HOME);
	   
	public WarpedBomber(EntityType<? extends WarpedBomber> type, Level level) {
		super(type, level);		
		this.xpReward = 7;
	}
	
	@Override
	public float getVoicePitch() {
		return super.getVoicePitch() * 0.9F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 25.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.4F).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}
	
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_35058_, DifficultyInstance p_35059_,
			MobSpawnType p_35060_, @Nullable SpawnGroupData p_35061_, @Nullable CompoundTag p_35062_) {
		WarpedBomberAi.initMemories(this);
		return super.finalizeSpawn(p_35058_, p_35059_, p_35060_, p_35061_, p_35062_);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.level.isClientSide) {
			Vec3 velocity = this.getDeltaMovement();
			float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
			
			boolean shouldPlayRunAnimation = speed > 0.15 && this.attackAnimationTick <= 0;
			
			if (shouldPlayRunAnimation && this.random.nextInt(5) == 0) {
				Vec3 particlePos = PositionUtils.getOffsetPos(this, 0, this.getEyeHeight() + 1.25, -5 / 16.0F, this.yBodyRot);
				this.level.addParticle(ParticleTypeInit.SPARK.get(), particlePos.x, particlePos.y, particlePos.z, 0, 0.1, 0);
			}
		}
		
		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.level.isClientSide && this.attackAnimationTick <= 0) {
			this.attackAnimationState.stop();
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}

	protected Brain.Provider<WarpedBomber> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return WarpedBomberAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<WarpedBomber> getBrain() {
		return (Brain<WarpedBomber>) super.getBrain();
	}
	
	@Override
	public boolean doHurtTarget(Entity p_21372_) {
		boolean flag = super.doHurtTarget(p_21372_);
		if (flag && p_21372_ instanceof LivingEntity) {
			MiscUtils.disableShield(((LivingEntity)p_21372_), 60);
		}
		return flag;
	}
		   
	@Override
	protected boolean canHunt() {
		return false;
	}
	
    @Override
    public boolean canPickUpLoot() {
    	return false;
    }

	protected void customServerAiStep() {
		this.level.getProfiler().push("warpedBomberBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		WarpedBomberAi.updateActivity(this);
		WarpedBomberAi.maybePlayActivitySound(this);
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
				WarpedBomberAi.wasHurtBy(this, (LivingEntity) p_35055_.getEntity());
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
		this.playSound(SoundEvents.PIGLIN_BRUTE_STEP, 0.15F, 1.0F);
	}

	public void playAngrySound() {
		this.playSound(SoundEvents.PIGLIN_BRUTE_ANGRY, 1.0F, this.getVoicePitch());
	}

	protected void playConvertedSound() {
		this.playSound(SoundEvents.PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED, 1.0F, this.getVoicePitch());
	}
	
	@Override
	public boolean canHarmWithExplosion(Entity target) {
		return MiscUtils.piglinAllies(this, target) ? false : true;
	}
}
