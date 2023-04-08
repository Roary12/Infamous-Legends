package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.BlazeRunt;
import com.infamous.infamous_legends.entities.ThrownBlazeRod;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class BlazeRuntThrowAttack extends Behavior<BlazeRunt> {
   private final int cooldownBetweenAttacks;

   public BlazeRuntThrowAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, BlazeRunt mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.isHolding(Items.BLAZE_ROD) && mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 20;
   }

   protected void start(ServerLevel p_23524_, BlazeRunt p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      p_23525_.throwAnimationTick = p_23525_.throwAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, BlazeRunt p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();
		
		if (livingentity != null && p_22552_.throwAnimationTick == p_22552_.throwAnimationActionPoint && p_22552_.hasLineOfSight(livingentity)) {
			ThrownBlazeRod thrownBlazeRod = new ThrownBlazeRod(p_22551_, p_22552_);
		      double d0 = livingentity.getX() - p_22552_.getX();
		      double d1 = livingentity.getY(0.3333333333333333D) - thrownBlazeRod.getY();
		      double d2 = livingentity.getZ() - p_22552_.getZ();
		      double d3 = Math.sqrt(d0 * d0 + d2 * d2);
		      thrownBlazeRod.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.4F, 10);
		      p_22552_.playSound(SoundEvents.TRIDENT_THROW);
		      p_22551_.addFreshEntity(thrownBlazeRod);
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, BlazeRunt p_22546_, long p_22547_) {
		return p_22546_.throwAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, BlazeRunt p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(BlazeRunt p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}