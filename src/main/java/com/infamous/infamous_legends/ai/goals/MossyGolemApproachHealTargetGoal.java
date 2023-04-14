package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.entities.MossyGolem;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class MossyGolemApproachHealTargetGoal extends Goal {

	public MossyGolem mob;
	@Nullable
	public LivingEntity target;
	public double stopDistance;
	public double speedMultiplier;

	public MossyGolemApproachHealTargetGoal(MossyGolem mob, double stopDistance, double speedMultiplier) {
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP));
		this.mob = mob;
		this.target = mob.getHealTarget();
		this.stopDistance = stopDistance;
		this.speedMultiplier = speedMultiplier;
	}

	@Override
	public boolean isInterruptable() {
		return true;
	}

	@Override
	public boolean canUse() {
		target = mob.getHealTarget();
		if (target != null && mob.distanceTo(target) <= this.stopDistance) {
			mob.getNavigation().stop();
		}
		return target != null && !target.isRemoved() && !target.isDeadOrDying() && mob.distanceTo(target) > this.stopDistance && mob.hasLineOfSight(target);
	}
	
	@Override
	public boolean canContinueToUse() {
		return false;
	}

	@Override
	public void start() {
		mob.getNavigation().moveTo(target, this.speedMultiplier);
	}

}