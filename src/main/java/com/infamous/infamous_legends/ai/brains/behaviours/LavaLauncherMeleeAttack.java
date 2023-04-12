package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.Vec3;

public class LavaLauncherMeleeAttack extends Behavior<LavaLauncher> {
   private final int cooldownBetweenAttacks;

   public LavaLauncherMeleeAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, LavaLauncher mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 8 && this.distanceToY(mob, livingentity) <= 4 && mob.shootAnimationTick <= 0;
   }
   
	public float distanceToY(LavaLauncher mob, Entity target) {
		float f1 = (float) (mob.getY() - target.getY());
		return Mth.sqrt(f1 * f1);
	}

   protected void start(ServerLevel p_23524_, LavaLauncher p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
		
      p_23525_.playSound(SoundEvents.HOGLIN_ATTACK, 2, p_23525_.getVoicePitch());
		
      p_23525_.attackAnimationTick = p_23525_.attackAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, LavaLauncher p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		p_22552_.getNavigation().stop();
		
		if (p_22552_.attackAnimationTick == p_22552_.attackAnimationActionPoint) {
			p_22552_.playSound(SoundEvents.GENERIC_EXPLODE, 2, MiscUtils.randomSoundPitch() * 0.75F);
			ShakeCameraEvent.shake(p_22551_, 40, 0.1F, p_22552_.blockPosition(), 14);
			Vec3 particlePos = PositionUtils.getOffsetPos(p_22552_, 0, 0, 3.5, p_22552_.yBodyRot);
			p_22551_.sendParticles(ParticleTypeInit.DUST.get(), particlePos.x, particlePos.y, particlePos.z, 60, 1.5D, 0.2D, 1.5D, 0.0D);
		}
		
		if (livingentity != null && p_22552_.attackAnimationTick == p_22552_.attackAnimationActionPoint && p_22552_.distanceTo(livingentity) <= 10 && p_22552_.hasLineOfSight(livingentity)) {
			p_22552_.doHurtTarget(livingentity);
			for (LivingEntity entity : p_22551_.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), p_22552_, livingentity.getBoundingBox().inflate(4, 0, 4))) {
				if (!MiscUtils.piglinAllies(p_22552_, entity) && entity != livingentity) {
					p_22552_.doHurtTarget(entity);
				}
			}
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, LavaLauncher p_22546_, long p_22547_) {
		return p_22546_.attackAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, LavaLauncher p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_COOLING_DOWN, true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(LavaLauncher p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}