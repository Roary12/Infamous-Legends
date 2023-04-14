package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;
import java.util.List;

import com.infamous.infamous_legends.entities.MossyGolem;
import com.infamous.infamous_legends.init.TagInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.AABB;

public class MossyGolemFindHealTargetGoal extends Goal {

	public MossyGolem mob;
	
	public LivingEntity target;
	
	public MossyGolemFindHealTargetGoal(MossyGolem mob) {
	    this.setFlags(EnumSet.of(Goal.Flag.TARGET));
		this.mob = mob;
	}
	
	@Override
	public boolean canUse() {
		if (!(mob.getHealTarget() == null || mob.getHealTarget().isDeadOrDying() || mob.getHealTarget().isRemoved())) {
			if (mob.getHealTarget() != null && mob.getHealTarget().getHealth() >= mob.getHealTarget().getMaxHealth()) {
				mob.setHealTarget(null);
			}
			return false;
		} else {
			this.findTarget();
			return target != null;
		}
	}
	
	@Override
	public boolean canContinueToUse() {
		return false;
	}
	
	public void findTarget() {
		List<LivingEntity> nearbyAllies = mob.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forNonCombat().selector((entity) -> {
			return MiscUtils.golemAllies(mob, entity);
		}), mob, this.getTargetSearchArea(mob.getAttributeValue(Attributes.FOLLOW_RANGE)));
		boolean shouldIgnoreMossyGolems = false;
		LivingEntity nearestMob = null;
		for (LivingEntity entity : nearbyAllies) {
			if (!(entity instanceof MossyGolem) && entity.getHealth() < entity.getMaxHealth()) {
				shouldIgnoreMossyGolems = true;
				break;
			}
		}
		
		for (LivingEntity entity : nearbyAllies) {
			if (!(shouldIgnoreMossyGolems == true && entity instanceof MossyGolem) && entity.getHealth() < entity.getMaxHealth()) {
				if (nearestMob == null || mob.distanceTo(entity) < mob.distanceTo(nearestMob)) {
					nearestMob = entity;
				}
			}
		}
		this.target = nearestMob;
	}
	
	@Override
	public void start() {
		this.mob.setHealTarget(target);
		super.start();
	}
	
	protected AABB getTargetSearchArea(double pTargetDistance) {
		return mob.getBoundingBox().inflate(pTargetDistance, 4.0D, pTargetDistance);
	}

}
