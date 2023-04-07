package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class SporeMedicHealAllies extends Behavior<SporeMedic> {

   public SporeMedicHealAllies() {
      super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleTypeInit.HEAL_TARGET.get(), MemoryStatus.VALUE_PRESENT), 600, 600);
   }

   protected boolean checkExtraStartConditions(ServerLevel level, SporeMedic mob) {
      LivingEntity livingentity = this.getHealTarget(mob);
      return mob.hasLineOfSight(livingentity) && mob.distanceTo(livingentity) <= 4 && mob.hasLineOfSight(livingentity);
   }

   protected void start(ServerLevel p_23524_, SporeMedic p_23525_, long p_23526_) {
      LivingEntity livingentity = this.getHealTarget(p_23525_);
      BehaviorUtils.lookAtEntity(p_23525_, livingentity);
      p_23525_.getNavigation().stop();
		
      p_23525_.shooting = true;
      p_23524_.broadcastEntityEvent(p_23525_, (byte) 4);
   }
   
   @Override
	protected void tick(ServerLevel p_22551_, SporeMedic p_22552_, long p_22553_) {
		super.tick(p_22551_, p_22552_, p_22553_);
		
		LivingEntity livingentity = this.getHealTarget(p_22552_);
		
		if (livingentity != null) {
			BehaviorUtils.lookAtEntity(p_22552_, livingentity);
		}
		
		p_22552_.getNavigation().stop();
	}
   
   @Override
	protected boolean canStillUse(ServerLevel p_22545_, SporeMedic p_22546_, long p_22547_) {
		LivingEntity livingentity = this.getHealTarget(p_22546_);
		return p_22546_.shooting && this.getHealTarget(p_22546_) != null && p_22546_.distanceTo(livingentity) <= 5;
	}
   
   @Override
	protected void stop(ServerLevel p_22548_, SporeMedic p_22549_, long p_22550_) {
		super.stop(p_22548_, p_22549_, p_22550_);
		p_22549_.shooting = false;
		p_22548_.broadcastEntityEvent(p_22549_, (byte) 11);
	}

   private LivingEntity getHealTarget(SporeMedic p_23533_) {
      return p_23533_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get()).isPresent() ? p_23533_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get()).get() : null;
   }
}