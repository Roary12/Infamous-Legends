package com.infamous.infamous_legends.ai.brains.behaviours;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class StopHealingIfHealTargetInvalid<E extends Mob> extends Behavior<E> {
   private static final int TIMEOUT_TO_GET_WITHIN_ATTACK_RANGE = 200;
   private final Predicate<LivingEntity> stopHealingWhen;
   private final BiConsumer<E, LivingEntity> onTargetErased;
   private final boolean canGrowTiredOfTryingToReachTarget;

   public StopHealingIfHealTargetInvalid(Predicate<LivingEntity> p_217404_, BiConsumer<E, LivingEntity> p_217405_, boolean p_217406_) {
      super(ImmutableMap.of(MemoryModuleTypeInit.HEAL_TARGET.get(), MemoryStatus.VALUE_PRESENT, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryStatus.REGISTERED));
      this.stopHealingWhen = p_217404_;
      this.onTargetErased = p_217405_;
      this.canGrowTiredOfTryingToReachTarget = p_217406_;
   }

   public StopHealingIfHealTargetInvalid(Predicate<LivingEntity> p_217401_, BiConsumer<E, LivingEntity> p_217402_) {
      this(p_217401_, p_217402_, true);
   }

   public StopHealingIfHealTargetInvalid(Predicate<LivingEntity> p_24236_) {
      this(p_24236_, (p_217411_, p_217412_) -> {
      });
   }

   public StopHealingIfHealTargetInvalid(BiConsumer<E, LivingEntity> p_217399_) {
      this((p_147988_) -> {
         return false;
      }, p_217399_);
   }

   public StopHealingIfHealTargetInvalid() {
      this((p_147986_) -> {
         return false;
      }, (p_217408_, p_217409_) -> {
      });
   }

   protected void start(ServerLevel p_24242_, E p_24243_, long p_24244_) {
      if (this.canGrowTiredOfTryingToReachTarget && isTiredOfTryingToReachHealTarget(p_24243_)) {
         this.clearHealTarget(p_24243_);
      } else if (this.isCurrentHealTargetDeadOrRemoved(p_24243_)) {
         this.clearHealTarget(p_24243_);
      } else if (this.isCurrentHealTargetInDifferentLevel(p_24243_)) {
         this.clearHealTarget(p_24243_);
      } else if (this.stopHealingWhen.test(this.getHealTarget(p_24243_))) {
         this.clearHealTarget(p_24243_);
      }
   }

   private boolean isCurrentHealTargetInDifferentLevel(E p_24248_) {
      return this.getHealTarget(p_24248_).level != p_24248_.level;
   }

   private LivingEntity getHealTarget(E p_24252_) {
      return p_24252_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get()).get();
   }

   private static <E extends LivingEntity> boolean isTiredOfTryingToReachHealTarget(E p_24246_) {
      Optional<Long> optional = p_24246_.getBrain().getMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
      return optional.isPresent() && p_24246_.level.getGameTime() - optional.get() > 200L;
   }

   private boolean isCurrentHealTargetDeadOrRemoved(E p_24254_) {
      Optional<LivingEntity> optional = p_24254_.getBrain().getMemory(MemoryModuleTypeInit.HEAL_TARGET.get());
      return optional.isPresent() && !optional.get().isAlive();
   }

   protected void clearHealTarget(E p_24256_) {
      this.onTargetErased.accept(p_24256_, this.getHealTarget(p_24256_));
      p_24256_.getBrain().eraseMemory(MemoryModuleTypeInit.HEAL_TARGET.get());
   }
}