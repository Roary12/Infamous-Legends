package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.ai.goals.ApproachTargetGoal;
import com.infamous.infamous_legends.ai.goals.AvoidTargetGoal;
import com.infamous.infamous_legends.ai.goals.LookAtTargetGoal;
import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.TagInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.GolemRandomStrollInVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import com.infamous.infamous_legends.ai.goals.CobblestoneGolemMeleeAttackGoal;
import com.infamous.infamous_legends.ai.goals.GrindstoneGolemRollAttackGoal;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GrindstoneGolem extends AbstractGolem {

	public AnimationState rollAnimationState = new AnimationState();
	public int rollAnimationTick;
	public final int rollAnimationLength = 66;
	
	public GrindstoneGolem(EntityType<? extends GrindstoneGolem> type, Level level) {
		super(type, level);		
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new GrindstoneGolemRollAttackGoal(this));
		this.goalSelector.addGoal(1, new LookAtTargetGoal(this));
		this.goalSelector.addGoal(2, new ApproachTargetGoal(this, 6, 1.2, true));
		this.goalSelector.addGoal(3, new AvoidTargetGoal(this, 4, 8, 1.2, false));
		this.goalSelector.addGoal(4, new MoveBackToVillageGoal(this, 0.6D, false));
		this.goalSelector.addGoal(5, new GolemRandomStrollInVillageGoal(this, 0.6D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(3,
				new NearestAttackableTargetGoal<>(this, Mob.class, 10, false, false, (p_28879_) -> {
					return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper);
				}));
	}
	
	@Override
	public float getStepHeight() {
		return this.rolling() ? 1 : super.getStepHeight();
	}
	
	@Override
	public boolean canAttack(LivingEntity target) {
		if (target instanceof Player && this.getTeam() == null && target.getTeam() == null) {
			return false;
		} else {
			return super.canAttack(target);
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.rollAnimationTick = this.rollAnimationLength;
			this.rollAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.ARMOR, 3.0D).add(Attributes.MOVEMENT_SPEED, 0.275D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.25D).add(Attributes.FOLLOW_RANGE, 25.0D);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.level.isClientSide) {
			Vec3 velocity = this.getDeltaMovement();
			float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
			
			boolean shouldPlayRunAnimation = speed > 0.125 && this.rollAnimationTick <= 0;
			
			if (shouldPlayRunAnimation && this.random.nextBoolean()) {
				int i = Mth.floor(this.getX());
				int j = Mth.floor(this.getY() - (double) 0.2F);
				int k = Mth.floor(this.getZ());
				BlockPos pos = new BlockPos(i, j, k);
				BlockState blockstate = this.level.getBlockState(pos);
				if (!blockstate.isAir()) {
					this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos),
							this.getX() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(),
							this.getY() + 0.1D,
							this.getZ() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(),
							4.0D * ((double) this.random.nextFloat() - 0.5D), 0.5D,
							((double) this.random.nextFloat() - 0.5D) * 4.0D);
				}
			}
		}
		
		if (this.level.isClientSide && this.rolling() && this.random.nextBoolean()) {
			this.level.addParticle(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
		}
		
		if (this.rollAnimationTick > 0) {
			this.rollAnimationTick--;
		}
		
		if (this.rollAnimationTick <= 0 && this.rollAnimationState.isStarted()) {
			this.rollAnimationState.stop();
		}
		
		if (this.rolling()) {
			for (LivingEntity entity : this.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), this, getBoundingBox())) {
				if (!MiscUtils.nonEnemy(this, entity)) {
					entity.hurt(DamageSource.mobAttack(this), 3);
					double d0 = entity.getX() - this.getX();
					double d1 = entity.getZ() - this.getZ();
					double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
					entity.push(d0 / d2 * 1.0D, 0.3D, d1 / d2 * 1.0D);
				}
			}
		}
	}
	
	protected void playStepSound(BlockPos p_35066_, BlockState p_35067_) {
		if (!this.rolling()) {
			super.playStepSound(p_35066_, p_35067_);
		} else {
			this.playSound(SoundEvents.STONE_STEP, 0.75F, 0.75F);
		}
	}
	
	public boolean rolling() {
		return this.rollAnimationTick <= 48 && this.rollAnimationTick > 10; 
	}

	protected SoundEvent getHurtSound(DamageSource p_35498_) {
		return SoundEvents.STONE_HIT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.STONE_BREAK;
	}
	   
	protected int decreaseAirSupply(int p_28882_) {
		return p_28882_;
	}
}
