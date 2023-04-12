package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.CobblestoneGolem;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.Vec3;

public class CobblestoneGolemMeleeAttackGoal extends Goal {

		public CobblestoneGolem mob;
		@Nullable
		public LivingEntity target;
		
		public int nextUseTime;

		public CobblestoneGolemMeleeAttackGoal(CobblestoneGolem mob) {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
			this.mob = mob;
			this.target = mob.getTarget();
		}

		@Override
		public boolean isInterruptable() {
			return false;
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public boolean canUse() {
			target = mob.getTarget();
			return target != null && mob.tickCount >= this.nextUseTime && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) <= 2 && animationsUseable() && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return !animationsUseable();
		}

		@Override
		public void start() {
			mob.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1, MiscUtils.randomSoundPitch() * 1.25F);
			mob.attackAnimationTick = mob.attackAnimationLength;
			mob.level.broadcastEntityEvent(mob, (byte) 4);
		}

		@Override
		public void tick() {
			target = mob.getTarget();

			mob.getNavigation().stop();
			
			if (target != null) {
				mob.lookAt(Anchor.EYES, target.position());
			}
			
			if (mob.attackAnimationTick == mob.attackAnimationActionPoint) {
				mob.playSound(SoundEvents.GOAT_RAM_IMPACT, 1, MiscUtils.randomSoundPitch() * 0.75F);
				Vec3 particlePos = PositionUtils.getOffsetPos(mob, 0, 0, 1, mob.yBodyRot);
				((ServerLevel)mob.level).sendParticles(ParticleTypeInit.DUST.get(), particlePos.x, particlePos.y, particlePos.z, 5, 0.2D, 0.2D, 0.2D, 0.0D);
			}
			
			if (target != null && mob.distanceTo(target) <= 3 && mob.attackAnimationTick == mob.attackAnimationActionPoint && mob.hasLineOfSight(target)) {
				mob.doHurtTarget(target);
				for (LivingEntity entity : mob.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forCombat(), mob, target.getBoundingBox().inflate(1, 0, 1))) {
					if (!MiscUtils.nonEnemy(mob, entity) && entity != target) {
						mob.doHurtTarget(entity);
					}
				}
			}
		}
		
		@Override
		public void stop() {
			super.stop();
			this.nextUseTime = mob.tickCount + 20;
		}

		public boolean animationsUseable() {
			return mob.attackAnimationTick <= 0;
		}

	}