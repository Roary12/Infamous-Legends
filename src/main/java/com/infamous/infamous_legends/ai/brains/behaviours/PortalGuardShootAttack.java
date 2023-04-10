package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.entities.PortalGuardWreckingBall;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.phys.Vec3;

public class PortalGuardShootAttack extends Behavior<PortalGuard> {
   private final int cooldownBetweenAttacks;

   public PortalGuardShootAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleTypeInit.SHOOT_COOLING_DOWN.get(), MemoryStatus.VALUE_ABSENT), 200, 200);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, PortalGuard mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 20 && mob.attackAnimationTick <= 0;
   }

   protected void start(ServerLevel p_23524_, PortalGuard p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      p_23525_.shootAnimationTick = p_23525_.shootAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 11);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, PortalGuard p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		if (livingentity != null && p_22552_.shootAnimationTick > p_22552_.shootAnimationActionPoint) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();
		
		if (livingentity != null && p_22552_.shootAnimationTick == p_22552_.shootAnimationActionPoint && p_22552_.hasLineOfSight(livingentity)) {
			Vec3 vec3 = PositionUtils.getOffsetPos(p_22552_, 1.5, 2.5, 2, p_22552_.yBodyRot);
			PortalGuardWreckingBall wreckingBall = new PortalGuardWreckingBall(p_22551_, p_22552_);
		      double d0 = livingentity.getX() - vec3.x;
		      double d1 = livingentity.getY(0.3333333333333333D) - vec3.y;
		      double d2 = livingentity.getZ() - vec3.z;
		      double d3 = Math.sqrt(d0 * d0 + d2 * d2);
		      wreckingBall.moveTo(vec3);
		      wreckingBall.shoot(d0, d1 + d3 * (double)0.25F, d2, 2.2F, 3);
		      p_22552_.playSound(SoundEvents.PISTON_EXTEND, 1.5F, MiscUtils.randomSoundPitch() * 0.75F);
		      p_22551_.addFreshEntity(wreckingBall);
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, PortalGuard p_22546_, long p_22547_) {
		return p_22546_.shootAnimationTick > 0 || p_22546_.playingIdleShootingAnimation || p_22546_.reelInBallAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, PortalGuard p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.playingIdleShootingAnimation = false;
		p_22548_.broadcastEntityEvent(p_22549_, (byte)10);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleTypeInit.SHOOT_COOLING_DOWN.get(), true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(PortalGuard p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}