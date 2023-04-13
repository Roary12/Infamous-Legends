package com.infamous.infamous_legends.ai.brains.sensors;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.TagInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.NearestVisibleLivingEntities;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class LegendsPiglinSpecificSensor extends CustomSensor<LivingEntity> {
   public Set<MemoryModuleType<?>> requires() {
      return ImmutableSet.of(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleType.NEAREST_VISIBLE_NEMESIS, MemoryModuleTypeInit.NEARBY_ALLIES.get());
   }

   protected void doTick(ServerLevel p_26721_, LivingEntity p_26722_) {
      Brain<?> brain = p_26722_.getBrain();
      List<LivingEntity> list = Lists.newArrayList();
      NearestVisibleLivingEntities nearestvisiblelivingentities = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES).orElse(NearestVisibleLivingEntities.empty());
      Optional<Mob> optional = nearestvisiblelivingentities.findClosest((p_186155_) -> {
         return p_186155_.getType().is(TagInit.EntityTypes.LEGENDS_PIGLIN_NEMESES);
      }).map(Mob.class::cast);

      for(LivingEntity livingentity : brain.getMemory(MemoryModuleType.NEAREST_LIVING_ENTITIES).orElse(ImmutableList.of())) {
    	 if (livingentity.getType().is(TagInit.EntityTypes.PIGLIN_ALLIES) && !livingentity.isBaby()) {
            list.add(livingentity);
         }
      }

      brain.setMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS, optional);
      brain.setMemory(MemoryModuleTypeInit.NEARBY_ALLIES.get(), list);
   }
}