package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.PlankGolem;
import com.infamous.infamous_legends.entities.PlankGolemBolt;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class PlankGolemShootAttackGoal extends Goal {

		public PlankGolem mob;
		@Nullable
		public LivingEntity target;
		
		public int nextUseTime;

		public PlankGolemShootAttackGoal(PlankGolem mob) {
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
			return target != null && mob.tickCount >= this.nextUseTime && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) <= 20 && animationsUseable() && mob.hasLineOfSight(target);
		}

		@Override
		public boolean canContinueToUse() {
			return !animationsUseable();
		}

		@Override
		public void start() {
			mob.shootAnimationTick = mob.shootAnimationLength;
			mob.level.broadcastEntityEvent(mob, (byte) 4);
		}

		@Override
		public void tick() {
			target = mob.getTarget();

			mob.getNavigation().stop();
			
			if (target != null) {
				mob.lookAt(Anchor.EYES, target.position());
			}
			
			if (target != null && mob.shootAnimationTick == mob.shootAnimationActionPoint && mob.hasLineOfSight(target)) {
				PlankGolemBolt bolt = new PlankGolemBolt(mob.level, mob);
				double d0 = target.getX() - mob.getX();
				double d1 = target.getY(0.3333333333333333D) - bolt.getY();
				double d2 = target.getZ() - mob.getZ();
				double d3 = Math.sqrt(d0 * d0 + d2 * d2);
				bolt.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 7);
				bolt.setType(mob.getPlankGolemType());
				mob.playSound(SoundEvents.DISPENSER_LAUNCH);
				mob.level.addFreshEntity(bolt);
			}
		}
		
		@Override
		public void stop() {
			super.stop();
			this.nextUseTime = mob.tickCount + 20;
		}

		public boolean animationsUseable() {
			return mob.shootAnimationTick <= 0;
		}

	}