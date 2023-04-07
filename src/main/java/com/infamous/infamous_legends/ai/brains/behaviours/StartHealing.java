package com.infamous.infamous_legends.ai.brains.behaviours;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class StartHealing<E extends Mob> extends Behavior<E> {
   private final Predicate<E> canAttackPredicate;
   private final Function<E, Optional<? extends LivingEntity>> targetFinderFunction;

   public StartHealing(Predicate<E> p_24195_, Function<E, Optional<? extends LivingEntity>> p_24196_) {
      this(p_24195_, p_24196_, 60);
   }

   public StartHealing(Predicate<E> p_217378_, Function<E, Optional<? extends LivingEntity>> p_217379_, int p_217380_) {
      super(ImmutableMap.of(MemoryModuleTypeInit.HEAL_TARGET.get(), MemoryStatus.VALUE_ABSENT, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryStatus.REGISTERED), p_217380_);
      this.canAttackPredicate = p_217378_;
      this.targetFinderFunction = p_217379_;
   }

   public StartHealing(Function<E, Optional<? extends LivingEntity>> p_24193_) {
      this((p_24212_) -> {
         return true;
      }, p_24193_);
   }

   protected boolean checkExtraStartConditions(ServerLevel p_24205_, E p_24206_) {
      if (!this.canAttackPredicate.test(p_24206_)) {
         return false;
      } else {
         Optional<? extends LivingEntity> optional = this.targetFinderFunction.apply(p_24206_);
         return optional.isPresent() ? p_24206_.canAttack(optional.get()) : false;
      }
   }

   protected void start(ServerLevel p_24208_, E p_24209_, long p_24210_) {
      this.targetFinderFunction.apply(p_24209_).ifPresent((p_24218_) -> {
         setAttackTarget(p_24209_, p_24218_);
      });
   }

   public static <E extends Mob> void setAttackTarget(E p_24214_, LivingEntity p_24215_) {
      net.minecraftforge.event.entity.living.LivingChangeTargetEvent changeTargetEvent = net.minecraftforge.common.ForgeHooks.onLivingChangeTarget(p_24214_, p_24215_, net.minecraftforge.event.entity.living.LivingChangeTargetEvent.LivingTargetType.BEHAVIOR_TARGET);
      if(!changeTargetEvent.isCanceled()) {
          p_24214_.getBrain().setMemory(MemoryModuleTypeInit.HEAL_TARGET.get(), changeTargetEvent.getNewTarget());
          p_24214_.getBrain().eraseMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
      }
   }
}