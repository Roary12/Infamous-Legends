package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.entities.MagmaCubeProjectile;
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
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.Vec3;

public class LavaLauncherShootAttack extends Behavior<LavaLauncher> {
   private final int cooldownBetweenAttacks;

   public LavaLauncherShootAttack(int p_23512_) {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleTypeInit.SHOOT_COOLING_DOWN.get(), MemoryStatus.VALUE_ABSENT), 600, 600);
      this.cooldownBetweenAttacks = p_23512_;
   }

   protected boolean checkExtraStartConditions(ServerLevel level, LavaLauncher mob) {
      LivingEntity livingentity = this.getAttackTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 30 && mob.distanceTo(livingentity) > 8 && mob.getPiglinHealth() > 0 && mob.attackAnimationTick <= 0;
   }

   protected void start(ServerLevel p_23524_, LavaLauncher p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getAttackTarget(p_23525_);
      p_23525_.lookAt(Anchor.EYES, livingentity.position());
      p_23525_.getNavigation().stop();
      
      p_23525_.subEntity.playSound(SoundEvents.MINECART_RIDING, 1.0F, MiscUtils.randomSoundPitch() * 0.75F);
      
      p_23525_.shootAnimationTick = p_23525_.shootAnimationLength;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 11);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, LavaLauncher p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getAttackTarget(p_22552_);
		
		if (livingentity != null) {
			p_22552_.lookAt(Anchor.EYES, livingentity.position());
		}
		
		if (p_22552_.tickCount % 5 == 0 && p_22552_.shootAnimationTick > p_22552_.shootAnimationLength - 50) {
		    p_22552_.subEntity.playSound(SoundEvents.PISTON_CONTRACT, 0.5F, MiscUtils.randomSoundPitch() * 0.75F);
		}
		
		p_22552_.getNavigation().stop();
		
		if (livingentity != null && p_22552_.shootAnimationTick == p_22552_.shootAnimationActionPoint) {
		      MagmaCubeProjectile magmaCube = new MagmaCubeProjectile(p_22551_, p_22552_);
		      Vec3 magmaCubePos = PositionUtils.getOffsetPos(p_22552_, 0.5, 6, 0, p_22552_.yBodyRot);
		      double d0 = livingentity.getX() - magmaCubePos.x;
		      double d1 = livingentity.getY(0.3333333333333333D) - magmaCubePos.y;
		      double d2 = livingentity.getZ() - magmaCubePos.z;
		      double d3 = Math.sqrt(d0 * d0 + d2 * d2);
		      magmaCube.moveTo(magmaCubePos);
		      magmaCube.shoot(d0, d1 + d3 * (double)0.15F, d2, 1.5F, 5);
		      magmaCube.blockInteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_22551_, p_22552_) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
		      p_22552_.playSound(SoundEvents.PISTON_CONTRACT, 2.0F, MiscUtils.randomSoundPitch() * 0.75F);
		      p_22552_.playSound(SoundEvents.MAGMA_CUBE_JUMP, 2.0F, MiscUtils.randomSoundPitch() * 0.75F);
		      p_22551_.addFreshEntity(magmaCube);
		}
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, LavaLauncher p_22546_, long p_22547_) {
		return p_22546_.shootAnimationTick > 0;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, LavaLauncher p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.getBrain().setMemoryWithExpiry(MemoryModuleTypeInit.SHOOT_COOLING_DOWN.get(), true, (long)this.cooldownBetweenAttacks);
	}

   private LivingEntity getAttackTarget(LavaLauncher p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get() : null;
   }
}