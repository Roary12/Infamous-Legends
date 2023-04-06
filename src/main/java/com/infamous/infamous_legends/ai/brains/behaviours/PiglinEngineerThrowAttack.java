package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.PiglinBomb;
import com.infamous.infamous_legends.entities.PiglinEngineer;
import com.infamous.infamous_legends.init.ItemInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.item.Items;

public class PiglinEngineerThrowAttack extends Behavior<PiglinEngineer> {
   private final int cooldownBetweenAttacks;

   public PiglinEngineerThrowAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, PiglinEngineer mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.isHolding(ItemInit.PIGLIN_BOMB.get()) && mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 15 && mob.hasLineOfSight(livingentity);
   }

   protected void start(ServerLevel p_23524_, PiglinEngineer p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      BehaviorUtils.lookAtEntity(p_23525_, livingentity);
      p_23525_.getNavigation().stop();
		
      p_23525_.throwAnimationTick = p_23525_.throwAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, PiglinEngineer p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			BehaviorUtils.lookAtEntity(p_22552_, livingentity);
		}
		
		p_22552_.getNavigation().stop();
		
		if (p_22552_.throwAnimationTick == 44) {
		    p_22552_.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F);
		}
		
		if (livingentity != null && p_22552_.throwAnimationTick == p_22552_.throwAnimationActionPoint) {
		      PiglinBomb bomb = new PiglinBomb(p_22551_, p_22552_);
		      double d0 = livingentity.getEyeY() - (double)1.1F;
		      double d1 = livingentity.getX() - p_22552_.getX();
		      double d2 = d0 - bomb.getY();
		      double d3 = livingentity.getZ() - p_22552_.getZ();
		      double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
		      bomb.shoot(d1 + (p_22552_.getRandom().nextGaussian() * 2.5), d2 + d4, d3 + (p_22552_.getRandom().nextGaussian() * 2.5), 1.0F, 3.0F);
		      p_22552_.playSound(SoundEvents.SNOWBALL_THROW, 1.0F, 0.4F / (p_22552_.getRandom().nextFloat() * 0.4F + 0.8F));
		      p_22551_.addFreshEntity(bomb);
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, PiglinEngineer p_22546_, long p_22547_) {
		return p_22546_.throwAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, PiglinEngineer p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(PiglinEngineer p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}