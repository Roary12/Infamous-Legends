package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class LookAtHealTarget extends Behavior<LivingEntity> {

	public LookAtHealTarget() {
		super(ImmutableMap.of(MemoryModuleTypeInit.HEAL_TARGET.get(), MemoryStatus.VALUE_PRESENT));
	}

	@Override
	protected void start(ServerLevel p_22540_, LivingEntity p_22541_, long p_22542_) {
	      BehaviorUtils.lookAtEntity(p_22541_, this.getHealTarget(p_22541_));
	}
	
	private LivingEntity getHealTarget(LivingEntity p_23533_) {
		return p_23533_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get()).isPresent()
				? p_23533_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get()).get()
				: null;
	}
}
