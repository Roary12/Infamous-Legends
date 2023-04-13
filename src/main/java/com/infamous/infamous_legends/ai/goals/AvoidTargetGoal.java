package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

public class AvoidTargetGoal extends Goal {
	public PathfinderMob mob;
	public LivingEntity target;
	public double startAvoidingRange;
	public double stopAvoidingDistance;
	public double avoidSpeed;
	public boolean avoidUnseenTarget;
	@Nullable
	protected Path path;
	
	public int runningFor;

	public AvoidTargetGoal(PathfinderMob mob, double startAvoidingRange, double stopAvoidingDistance, double avoidSpeed,
			boolean avoidUnseenTarget) {
	    this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		this.mob = mob;
		this.startAvoidingRange = startAvoidingRange;
		this.stopAvoidingDistance = stopAvoidingDistance;
		this.avoidSpeed = avoidSpeed;
		this.avoidUnseenTarget = avoidUnseenTarget;
	}

	@Override
	public boolean canUse() {
		this.target = mob.getTarget();
		if (this.target == null) {
			return false;
		} else {
			Vec3 vec3 = DefaultRandomPos.getPosAway(this.mob, Mth.ceil(stopAvoidingDistance), Mth.ceil(stopAvoidingDistance / 2), this.target.position());
			if (vec3 == null) {
				return false;
			} else if (this.target.distanceToSqr(vec3.x, vec3.y, vec3.z) < this.target.distanceToSqr(this.mob)) {
				return false;
			} else {
				this.path = mob.getNavigation().createPath(vec3.x, vec3.y, vec3.z, 0);
				return this.path != null && mob.distanceTo(target) <= startAvoidingRange
						&& (mob.hasLineOfSight(target) || avoidUnseenTarget);
			}
		}
	}

	@Override
	public boolean canContinueToUse() {
		return this.target != null && mob.distanceTo(target) < stopAvoidingDistance && !mob.getNavigation().isDone() && this.runningFor < 200;
	}

	@Override
	public void start() {
		super.start();
		this.runningFor = 0;
		mob.getNavigation().moveTo(this.path, this.avoidSpeed);
	}

	@Override
	public void tick() {
		super.tick();
		this.runningFor ++;
	}
	
	@Override
	public void stop() {
		super.stop();
		mob.getNavigation().stop();
	}
}