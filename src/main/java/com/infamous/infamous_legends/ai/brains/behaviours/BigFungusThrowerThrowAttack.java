package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.PiglinBomb;
import com.infamous.infamous_legends.entities.BigFungusThrower;
import com.infamous.infamous_legends.entities.ExplosiveFungus;
import com.infamous.infamous_legends.init.ItemInit;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.Vec3;

public class BigFungusThrowerThrowAttack extends Behavior<BigFungusThrower> {
   private final int cooldownBetweenAttacks;

   public BigFungusThrowerThrowAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, BigFungusThrower mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.isHolding(ItemInit.EXPLOSIVE_FUNGUS.get()) && mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 25;
   }

   protected void start(ServerLevel p_23524_, BigFungusThrower p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      p_23525_.throwAnimationTick = p_23525_.throwAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, BigFungusThrower p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();

		if (livingentity != null && p_22552_.throwAnimationTick == p_22552_.throwAnimationActionPoint) {
			ExplosiveFungus fungus = new ExplosiveFungus(p_22551_, p_22552_);
			Vec3 vec3 = livingentity.getDeltaMovement();
			double d0 = livingentity.getX() + vec3.x - p_22552_.getX();
			double d1 = livingentity.getEyeY() - (double) 1.1F - p_22552_.getY();
			double d2 = livingentity.getZ() + vec3.z - p_22552_.getZ();
			double d3 = Math.sqrt(d0 * d0 + d2 * d2);
			fungus.setXRot(fungus.getXRot() - -80.0F);
			fungus.shoot(d0, d1 + d3 * 0.4D, d2, 0.75F, 8.0F);
		    p_22552_.playSound(SoundEvents.SNOWBALL_THROW, 1.0F, 0.4F / (p_22552_.getRandom().nextFloat() * 0.4F + 0.8F));
		    p_22551_.addFreshEntity(fungus);
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, BigFungusThrower p_22546_, long p_22547_) {
		return p_22546_.throwAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, BigFungusThrower p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(BigFungusThrower p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}