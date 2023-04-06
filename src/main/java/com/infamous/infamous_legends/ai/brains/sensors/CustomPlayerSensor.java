package com.infamous.infamous_legends.ai.brains.sensors;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableSet;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;

public class CustomPlayerSensor extends CustomSensor<LivingEntity> {

   public Set<MemoryModuleType<?>> requires() {
      return ImmutableSet.of(MemoryModuleType.NEAREST_PLAYERS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER);
   }

   protected void doTick(ServerLevel p_26740_, LivingEntity p_26741_) {
      List<Player> list = p_26740_.players().stream().filter(EntitySelector.NO_SPECTATORS).filter((p_26744_) -> {
         return p_26741_.closerThan(p_26744_, p_26741_.getAttributeValue(Attributes.FOLLOW_RANGE));
      }).sorted(Comparator.comparingDouble(p_26741_::distanceToSqr)).collect(Collectors.toList());
      Brain<?> brain = p_26741_.getBrain();
      brain.setMemory(MemoryModuleType.NEAREST_PLAYERS, list);
      List<Player> list1 = list.stream().filter((p_26747_) -> {
         return isEntityTargetable(p_26741_, p_26747_);
      }).collect(Collectors.toList());
      brain.setMemory(MemoryModuleType.NEAREST_VISIBLE_PLAYER, list1.isEmpty() ? null : list1.get(0));
      Optional<Player> optional = list1.stream().filter((p_148304_) -> {
         return isEntityAttackable(p_26741_, p_148304_);
      }).findFirst();
      brain.setMemory(MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER, optional);
   }
   
}