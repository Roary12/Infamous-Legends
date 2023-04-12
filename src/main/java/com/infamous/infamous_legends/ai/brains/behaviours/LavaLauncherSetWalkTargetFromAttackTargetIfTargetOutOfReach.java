package com.infamous.infamous_legends.ai.brains.behaviours;

import java.util.function.Function;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.entities.LavaLauncher;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;

public class LavaLauncherSetWalkTargetFromAttackTargetIfTargetOutOfReach extends Behavior<LavaLauncher> {
   private final Function<LavaLauncher, Float> speedModifier;

   public LavaLauncherSetWalkTargetFromAttackTargetIfTargetOutOfReach(float p_24026_) {
      this((p_147908_) -> {
         return p_24026_;
      });
   }

   public LavaLauncherSetWalkTargetFromAttackTargetIfTargetOutOfReach(Function<LavaLauncher, Float> p_147905_) {
      super(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.LOOK_TARGET, MemoryStatus.REGISTERED, MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryStatus.REGISTERED));
      this.speedModifier = p_147905_;
   }
   
   public int getStopDistance(LavaLauncher mob) {
	   return mob.getPiglinHealth() > 0 ? 30 : 0;
   }
   
   @Override
	protected boolean checkExtraStartConditions(ServerLevel p_22538_, LavaLauncher p_22539_) {
	    LivingEntity livingentity = p_22539_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get();
		return p_22539_.distanceTo(livingentity) > this.getStopDistance(p_22539_) && super.checkExtraStartConditions(p_22538_, p_22539_);
	}

   protected void start(ServerLevel p_24032_, LavaLauncher p_24033_, long p_24034_) {
      LivingEntity livingentity = p_24033_.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get();
      this.setWalkAndLookTarget(p_24033_, livingentity);
   }

   private void setWalkAndLookTarget(LavaLauncher p_24038_, LivingEntity p_24039_) {
      Brain<?> brain = p_24038_.getBrain();
      brain.setMemory(MemoryModuleType.LOOK_TARGET, new EntityTracker(p_24039_, true));
      WalkTarget walktarget = new WalkTarget(new EntityTracker(p_24039_, false), this.speedModifier.apply(p_24038_), p_24038_.hasLineOfSight(p_24039_) ? this.getStopDistance(p_24038_) : 0);
      brain.setMemory(MemoryModuleType.WALK_TARGET, walktarget);
   }

   private void clearWalkTarget(LivingEntity p_24036_) {
      p_24036_.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
   }
}