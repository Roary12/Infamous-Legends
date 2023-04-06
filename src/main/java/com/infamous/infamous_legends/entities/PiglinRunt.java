package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.PiglinRuntAi;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class PiglinRunt extends AbstractPiglin {

	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 58;
	public final int attackAnimationActionPoint = 27;
	
	public boolean shouldPlayRunAnimation;
	public boolean shouldPlayWalkAnimation;
	public boolean shouldPlayIdleAnimation;
	
	public float runAnimationAmountMultiplier;
	public float walkAnimationAmountMultiplier;
	public float idleAnimationAmountMultiplier;
	
	public final float animationTransitionSpeed = 0.5F;
	
	protected static final ImmutableList<SensorType<? extends Sensor<? super PiglinRunt>>> SENSOR_TYPES = ImmutableList
			.of(SensorType.NEAREST_LIVING_ENTITIES, SensorTypeInit.CUSTOM_NEAREST_PLAYERS.get(), SensorType.NEAREST_ITEMS,
					SensorType.HURT_BY, SensorType.PIGLIN_BRUTE_SPECIFIC_SENSOR);
	protected static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
			MemoryModuleType.LOOK_TARGET, MemoryModuleType.DOORS_TO_CLOSE, MemoryModuleType.NEAREST_LIVING_ENTITIES,
			MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_PLAYER,
			MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ADULT_PIGLINS,
			MemoryModuleType.NEARBY_ADULT_PIGLINS, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY,
			MemoryModuleType.WALK_TARGET, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.ATTACK_TARGET,
			MemoryModuleType.ATTACK_COOLING_DOWN, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.PATH,
			MemoryModuleType.ANGRY_AT, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleType.HOME);
	   
	public PiglinRunt(EntityType<? extends PiglinRunt> type, Level level) {
		super(type, level);		
		this.xpReward = 5;
	}
	
	@Override
	public float getVoicePitch() {
		return super.getVoicePitch() * 1.5F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 17.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.35F).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.FOLLOW_RANGE, 17.5D);
	}
	
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_35058_, DifficultyInstance p_35059_,
			MobSpawnType p_35060_, @Nullable SpawnGroupData p_35061_, @Nullable CompoundTag p_35062_) {
		PiglinRuntAi.initMemories(this);
		this.populateDefaultEquipmentSlots(p_35058_.getRandom(), p_35059_);
		return super.finalizeSpawn(p_35058_, p_35059_, p_35060_, p_35061_, p_35062_);
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource p_219209_, DifficultyInstance p_219210_) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.PIGLIN_MACE.get()));
		this.setDropChance(EquipmentSlot.MAINHAND, 0.0F);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		this.tickAnimations();
		
		if (this.level.isClientSide) {			
		      if (this.shouldPlayRunAnimation && this.random.nextBoolean()) {
		          int i = Mth.floor(this.getX());
		          int j = Mth.floor(this.getY() - (double)0.2F);
		          int k = Mth.floor(this.getZ());
		          BlockPos pos = new BlockPos(i, j, k);
		          BlockState blockstate = this.level.getBlockState(pos);
		          if (!blockstate.isAir()) {
		             this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), 4.0D * ((double)this.random.nextFloat() - 0.5D), 0.5D, ((double)this.random.nextFloat() - 0.5D) * 4.0D);
		          }
		       }
		      
			if (this.shouldPlayWalkAnimation && this.random.nextInt(10) == 0) {
				Vec3 particlePos = PositionUtils.getOffsetPos(this, -0.5, 0, -0.5, this.yBodyRot);
				this.level.addParticle(ParticleTypeInit.DUST.get(), particlePos.x, particlePos.y, particlePos.z, 0, 0, 0);
			}
		}			
	}
	
	public void tickAnimations() {		
		Vec3 velocity = this.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		this.shouldPlayRunAnimation = speed > 0.1 && this.attackAnimationTick <= 0;
		
		this.shouldPlayWalkAnimation = !shouldPlayRunAnimation && speed > 0 && this.attackAnimationTick <= 0;
		
		this.shouldPlayIdleAnimation = !shouldPlayWalkAnimation && !shouldPlayRunAnimation && this.attackAnimationTick <= 0;			

		if (this.shouldPlayRunAnimation) {
			this.runAnimationAmountMultiplier = (float)Mth.lerp(this.animationTransitionSpeed, this.runAnimationAmountMultiplier, 1);
		} else {
			this.runAnimationAmountMultiplier = (float)Mth.lerp(this.animationTransitionSpeed, this.runAnimationAmountMultiplier, 0);
		}
		
		if (this.shouldPlayWalkAnimation) {
			this.walkAnimationAmountMultiplier = (float)Mth.lerp(this.animationTransitionSpeed, this.walkAnimationAmountMultiplier, 1);
		} else {
			this.walkAnimationAmountMultiplier = (float)Mth.lerp(this.animationTransitionSpeed, this.walkAnimationAmountMultiplier, 0);
		}
		
		if (this.shouldPlayIdleAnimation) {
			this.idleAnimationAmountMultiplier = (float)Mth.lerp(this.animationTransitionSpeed, this.idleAnimationAmountMultiplier, 1);
		} else {
			this.idleAnimationAmountMultiplier = (float)Mth.lerp(this.animationTransitionSpeed, this.idleAnimationAmountMultiplier, 0);
		}
		
		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.attackAnimationTick <= 0 && this.attackAnimationState.isStarted()) {
			this.attackAnimationState.stop();
			this.idleAnimationAmountMultiplier = 1;
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

	protected Brain.Provider<PiglinRunt> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return PiglinRuntAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<PiglinRunt> getBrain() {
		return (Brain<PiglinRunt>) super.getBrain();
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

	public boolean wantsToPickUp(ItemStack p_35078_) {
		return p_35078_.is(ItemInit.PIGLIN_MACE.get()) ? super.wantsToPickUp(p_35078_) : false;
	}

	protected void customServerAiStep() {
		this.level.getProfiler().push("piglinRuntBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		PiglinRuntAi.updateActivity(this);
		PiglinRuntAi.maybePlayActivitySound(this);
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
				PiglinRuntAi.wasHurtBy(this, (LivingEntity) p_35055_.getEntity());
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
	   
}
