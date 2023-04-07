package com.infamous.infamous_legends.ai.brains.behaviours;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class LookAtAttackTarget extends Behavior<LivingEntity> {

	public LookAtAttackTarget() {
		super(ImmutableMap.of(MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT));
	}

	@Override
	protected void start(ServerLevel p_22540_, LivingEntity p_22541_, long p_22542_) {
	      BehaviorUtils.lookAtEntity(p_22541_, this.getAttackTarget(p_22541_));
	}
	
	private LivingEntity getAttackTarget(LivingEntity p_23533_) {
		return p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent()
				? p_23533_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get()
				: null;
	}
}
