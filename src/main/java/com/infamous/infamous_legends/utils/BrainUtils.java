package com.infamous.infamous_legends.utils;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.infamous.infamous_legends.ai.brains.sensors.CustomSensor;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;

public class BrainUtils {

	public static void piglinMaybeRetaliate(LivingEntity p_34625_, LivingEntity p_34626_) {
		if (!MiscUtils.piglinAllies(p_34625_, p_34626_)) {
			if (!BehaviorUtils.isOtherTargetMuchFurtherAwayThanCurrentAttackTarget(p_34625_, p_34626_,
					4.0D)) {
				if (CustomSensor.isEntityAttackable(p_34625_, p_34626_)) {
					setAttackTarget(p_34625_, p_34626_);
					broadcastAttackTarget(p_34625_, p_34626_);
				}
			}
		}
	}

	public static void setAttackTarget(LivingEntity p_34630_, LivingEntity p_34631_) {
		p_34630_.getBrain().eraseMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
		p_34630_.getBrain().setMemoryWithExpiry(MemoryModuleType.ANGRY_AT, p_34631_.getUUID(), 600L);
		p_34630_.getBrain().setMemoryWithExpiry(MemoryModuleType.ATTACK_TARGET, p_34631_, 200L);
	}

	public static void broadcastAttackTarget(LivingEntity p_34635_, LivingEntity p_34636_) {
		getVisibleAllies(p_34635_).forEach((p_34574_) -> {
			setAttackTargetIfCloserThanCurrent(p_34574_, p_34636_);
		});
	}
	
	public static void setAttackTargetIfCloserThanCurrent(LivingEntity p_34640_, LivingEntity p_34641_) {
		Optional<LivingEntity> optional = p_34640_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET);
		LivingEntity livingentity = BehaviorUtils.getNearestTarget(p_34640_, optional, p_34641_);
		setAttackTarget(p_34640_, livingentity);
	}
	
	public static List<LivingEntity> getVisibleAllies(LivingEntity p_34628_) {
		List<LivingEntity> nearbyAllies = p_34628_.getBrain().getMemory(MemoryModuleTypeInit.NEARBY_ALLIES.get()).orElse(ImmutableList.of());
		List<LivingEntity> nearbyVisibleAllies = Lists.newArrayList();
		for (LivingEntity entity : nearbyAllies) {
			if (p_34628_.hasLineOfSight(entity)) {
				nearbyVisibleAllies.add(entity);
			}
		}
		return nearbyVisibleAllies;
	}
	
}
