package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.Pigmadillo;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.phys.Vec3;

public class PigmadilloRollAttack extends Behavior<Pigmadillo> {
   private final int cooldownBetweenAttacks;

   public PigmadilloRollAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleTypeInit.ROLL_COOLING_DOWN.get(), MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, Pigmadillo mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.attackAnimationTick <= 0;
   }

   protected void start(ServerLevel p_23524_, Pigmadillo p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
      
      p_23525_.playSound(SoundEvents.IRON_GOLEM_ATTACK, 2, 0.5F);
		
      p_23525_.rollAnimationTick = p_23525_.rollAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 11);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, Pigmadillo p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (p_22552_.rollAnimationTick > 85 && livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		if (p_22552_.rollAnimationTick == p_22552_.rollAnimationLength - 16) {
			p_22552_.playSound(SoundEvents.BONE_BLOCK_PLACE, 2, 0.5F);
		}
		
		if (p_22552_.rollAnimationTick == p_22552_.rollAnimationLength - 27) {
			p_22552_.playSound(SoundEvents.BONE_BLOCK_BREAK, 2, 0.5F);
		}
		
		if (p_22552_.rollAnimationTick == p_22552_.rollAnimationLength - 85) {
			p_22552_.playSound(SoundEvents.IRON_GOLEM_ATTACK, 2, 0.5F);
		}
		
		p_22552_.getNavigation().stop();
		
		if (p_22552_.rolling()) {
			p_22552_.setDeltaMovement(p_22552_.getDeltaMovement().add(PositionUtils.getOffsetMotion(p_22552_, 0, 0, p_22552_.isOnGround() ? 0.25 : 0.1, p_22552_.yBodyRot)));
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, Pigmadillo p_22546_, long p_22547_) {
		return p_22546_.rollAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, Pigmadillo p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleTypeInit.ROLL_COOLING_DOWN.get(), true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(Pigmadillo p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}