package com.infamous.infamous_legends.ai.brains.sensors;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.TagInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.NearestVisibleLivingEntities;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class SporeMedicSpecificSensor extends CustomSensor<SporeMedic> {

   public Set<MemoryModuleType<?>> requires() {
      return ImmutableSet.of(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES, MemoryModuleTypeInit.HEAL_TARGET.get(), MemoryModuleType.NEARBY_ADULT_PIGLINS);
   }

   protected void doTick(ServerLevel level, SporeMedic entity) {
	      Brain<?> brain = entity.getBrain();
	      List<AbstractPiglin> piglins = Lists.newArrayList();
	      NearestVisibleLivingEntities nearestvisiblelivingentities = brain.getMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES).orElse(NearestVisibleLivingEntities.empty());
	      boolean dontHealMedics = nearestvisiblelivingentities.contains((target) -> {
	    	 return MiscUtils.piglinAllies(entity, target) && !(target instanceof SporeMedic) && target.getHealth() < target.getMaxHealth();
	      });
	      Optional<Mob> healTarget = nearestvisiblelivingentities.findClosest((p_186155_) -> {
	    	 boolean unhealableSporeMedic = dontHealMedics ? p_186155_ instanceof SporeMedic : false;
	         return MiscUtils.piglinAllies(entity, p_186155_) && !unhealableSporeMedic && p_186155_.getHealth() < p_186155_.getMaxHealth();
	      }).map(Mob.class::cast);
	      
	      Optional<Mob> nemeses = nearestvisiblelivingentities.findClosest((p_186155_) -> {
	          return p_186155_.getType().is(TagInit.EntityTypes.LEGENDS_PIGLIN_NEMESES);
	       }).map(Mob.class::cast);

	      for(LivingEntity livingentity : brain.getMemory(MemoryModuleType.NEAREST_LIVING_ENTITIES).orElse(ImmutableList.of())) {
	         if (livingentity instanceof AbstractPiglin && ((AbstractPiglin)livingentity).isAdult()) {
	        	 piglins.add((AbstractPiglin)livingentity);
	         }
	      }

	      brain.setMemory(MemoryModuleTypeInit.HEAL_TARGET.get(), healTarget);
	      brain.setMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS, nemeses);
	      brain.setMemory(MemoryModuleType.NEARBY_ADULT_PIGLINS, piglins);
   }
   
}