package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.infamous.infamous_legends.ai.brains.PigmadilloAi;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
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
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinArmPose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Pigmadillo extends AbstractPiglin {

	public AnimationState attackAnimationState = new AnimationState();
	public int attackAnimationTick;
	public final int attackAnimationLength = 40;
	public final int attackAnimationActionPoint = 24;
	
	public AnimationState rollAnimationState = new AnimationState();
	public int rollAnimationTick;
	public final int rollAnimationLength = 125;
	
	public EntityDimensions rollingSize = EntityDimensions.scalable(2.5F, 2.5F);
	
	protected static final ImmutableList<SensorType<? extends Sensor<? super Pigmadillo>>> SENSOR_TYPES = ImmutableList
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
			MemoryModuleTypeInit.ROLL_COOLING_DOWN.get());
	   
	public Pigmadillo(EntityType<? extends Pigmadillo> type, Level level) {
		super(type, level);		
		this.xpReward = 15;
	}
	
	@Override
	public float getStepHeight() {
		return 1;
	}
	
	@Override
	public float getVoicePitch() {
		return super.getVoicePitch() * 0.25F;
	}
	
	@Override
	public EntityDimensions getDimensions(Pose p_21047_) {
		return this.rolling() ? this.rollingSize : super.getDimensions(p_21047_);
	}

	public void refreshDimensions() {
		double d0 = this.getX();
		double d1 = this.getY();
		double d2 = this.getZ();
		super.refreshDimensions();
		this.setPos(d0, d1, d2);
	}
	   
	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 75.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.35F).add(Attributes.ATTACK_DAMAGE, 15.0D).add(Attributes.ARMOR, 15.0D).add(Attributes.FOLLOW_RANGE, 30D).add(Attributes.KNOCKBACK_RESISTANCE, 1D);
	}
	
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_35058_, DifficultyInstance p_35059_,
			MobSpawnType p_35060_, @Nullable SpawnGroupData p_35061_, @Nullable CompoundTag p_35062_) {
		PigmadilloAi.initMemories(this);
		return super.finalizeSpawn(p_35058_, p_35059_, p_35060_, p_35061_, p_35062_);
	}
	
	@Override
	public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
		return this.rolling() ? false : super.causeFallDamage(p_147187_, p_147188_, p_147189_);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		this.refreshDimensions();
		
		if (this.level.isClientSide && this.rolling()) {
			this.level.addParticle(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
		}
		
		if (this.attackAnimationTick > 0) {
			this.attackAnimationTick--;
		}
		
		if (this.level.isClientSide && this.attackAnimationTick <= 0) {
			this.attackAnimationState.stop();
		}
		
		if (this.rollAnimationTick > 0) {
			this.rollAnimationTick--;
		}
		
		if (this.level.isClientSide && this.rollAnimationTick <= 0) {
			this.rollAnimationState.stop();
		}
		
		if (this.rolling()) {
			if (this.tickCount % 5 == 0 && this.horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this)) {
	            boolean flag = false;
	            AABB aabb = this.getBoundingBox().inflate(0.2D, 0, 0.2D);

	            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
	               BlockState blockstate = this.level.getBlockState(blockpos);
	               if (blockstate.canEntityDestroy(this.level, blockpos, this)) {
	                  flag = this.level.destroyBlock(blockpos, true, this) || flag;
	               }
	            }

	            if (!flag && this.onGround) {
	               this.jumpFromGround();
	            }
	         }
			
			for (LivingEntity entity : this.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), this, getBoundingBox())) {
				if (!MiscUtils.piglinAllies(this, entity)) {
					entity.hurt(DamageSource.mobAttack(this), 15);
					double d0 = entity.getX() - this.getX();
					double d1 = entity.getZ() - this.getZ();
					double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
					entity.push(d0 / d2 * 2.0D, 0.3D, d1 / d2 * 2.0D);
					MiscUtils.disableShield(entity, 60);
				}
			}
		}
	}
	
	public boolean rolling() {
		return this.rollAnimationTick <= 85 && this.rollAnimationTick > 25; 
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.attackAnimationTick = this.attackAnimationLength;
			this.attackAnimationState.start(this.tickCount);
		} else if (p_219360_ == 11) {
			this.rollAnimationTick = this.rollAnimationLength;
			this.rollAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}

	protected Brain.Provider<Pigmadillo> brainProvider() {
		return Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
	}

	protected Brain<?> makeBrain(Dynamic<?> p_35064_) {
		return PigmadilloAi.makeBrain(this, this.brainProvider().makeBrain(p_35064_));
	}

	public Brain<Pigmadillo> getBrain() {
		return (Brain<Pigmadillo>) super.getBrain();
	}
		   
	@Override
	protected boolean canHunt() {
		return false;
	}

	public boolean wantsToPickUp(ItemStack p_35078_) {
		return false;
	}

	protected void customServerAiStep() {
		this.level.getProfiler().push("pigmadilloBrain");
		this.getBrain().tick((ServerLevel) this.level, this);
		this.level.getProfiler().pop();
		PigmadilloAi.updateActivity(this);
		PigmadilloAi.maybePlayActivitySound(this);
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
		if (this.rolling()) {
			Entity entity = p_35055_.getDirectEntity();
			if (entity instanceof AbstractArrow) {
				return false;
			}
		}
		
		boolean flag = super.hurt(p_35055_, !p_35055_.isBypassArmor() && !p_35055_.isMagic() && p_35055_ != DamageSource.OUT_OF_WORLD && this.rolling() ? p_35056_ / 2 : p_35056_);
		if (this.level.isClientSide) {
			return false;
		} else {
			if (flag && p_35055_.getEntity() instanceof LivingEntity) {
				PigmadilloAi.wasHurtBy(this, (LivingEntity) p_35055_.getEntity());
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
		if (!this.rolling()) {
			this.playSound(SoundEvents.PIGLIN_BRUTE_STEP, 0.5F, 1.0F);
		} else {
			this.playSound(SoundEvents.BONE_BLOCK_STEP, 1.0F, 0.75F);
		}
	}

	public void playAngrySound() {
		this.playSound(SoundEvents.PIGLIN_BRUTE_ANGRY, 1.0F, this.getVoicePitch());
	}

	protected void playConvertedSound() {
		this.playSound(SoundEvents.PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED, 1.0F, this.getVoicePitch());
	}
	   
}
