package com.infamous.infamous_legends.ai.brains;

import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.infamous.infamous_legends.ai.brains.behaviours.LavaLauncherMeleeAttack;
import com.infamous.infamous_legends.ai.brains.behaviours.LavaLauncherSetWalkTargetFromAttackTargetIfTargetOutOfReach;
import com.infamous.infamous_legends.ai.brains.behaviours.LavaLauncherShootAttack;
import com.infamous.infamous_legends.ai.brains.behaviours.LookAtAttackTarget;
import com.infamous.infamous_legends.ai.brains.sensors.CustomSensor;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.mojang.datafixers.util.Pair;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.ai.behavior.MoveToTargetSink;
import net.minecraft.world.entity.ai.behavior.RandomStroll;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.behavior.RunSometimes;
import net.minecraft.world.entity.ai.behavior.SetEntityLookTarget;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromLookTarget;
import net.minecraft.world.entity.ai.behavior.StartAttacking;
import net.minecraft.world.entity.ai.behavior.StopAttackingIfTargetInvalid;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.schedule.Activity;

public class LavaLauncherAi {

	  public static Brain<?> makeBrain(LavaLauncher p_35100_, Brain<LavaLauncher> p_35101_) {
	      initCoreActivity(p_35100_, p_35101_);
	      initIdleActivity(p_35100_, p_35101_);
	      initFightActivity(p_35100_, p_35101_);
	      p_35101_.setCoreActivities(ImmutableSet.of(Activity.CORE));
	      p_35101_.setDefaultActivity(Activity.IDLE);
	      p_35101_.useDefaultActivity();
	      return p_35101_;
	   }
	  
		private static void initCoreActivity(LavaLauncher p_35100_, Brain<LavaLauncher> p_34217_) {
			p_34217_.addActivity(Activity.CORE, 0, ImmutableList.of(new LookAtTargetSink(45, 90), new MoveToTargetSink()));
		}

		private static void initIdleActivity(LavaLauncher p_35100_, Brain<LavaLauncher> p_34229_) {
			p_34229_.addActivity(Activity.IDLE, 10,
					ImmutableList.of(new StartAttacking<>(LavaLauncherAi::findNearestValidAttackTarget),
							new RunSometimes<LavaLauncher>(new SetEntityLookTarget(8.0F), UniformInt.of(30, 60)),
							new RunOne<LavaLauncher>(ImmutableList.of(Pair.of(new RandomStroll(0.5F), 2),
									Pair.of(new SetWalkTargetFromLookTarget(0.5F, 3), 2),
									Pair.of(new DoNothing(30, 60), 1)))));
		}

		private static void initFightActivity(LavaLauncher p_35100_, Brain<LavaLauncher> p_34237_) {
			p_34237_.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10,
					ImmutableList.of(new LavaLauncherSetWalkTargetFromAttackTargetIfTargetOutOfReach((entity) -> {
						return entity.getPiglinHealth() > 0 ? 1.0F : 1.35F;
					}),
							new LavaLauncherMeleeAttack(40), new LavaLauncherShootAttack(150), new LookAtAttackTarget(),
							new StopAttackingIfTargetInvalid<>((p_35118_) -> {
						         return !isNearestValidAttackTarget(p_35100_, p_35118_);
						      })),
					MemoryModuleType.ATTACK_TARGET);
		}
		
		   private static boolean isNearestValidAttackTarget(LavaLauncher p_35089_, LivingEntity p_35090_) {
			      return findNearestValidAttackTarget(p_35089_).filter((p_35085_) -> {
			         return p_35085_ == p_35090_;
			      }).isPresent();
			   }

			   private static Optional<? extends LivingEntity> findNearestValidAttackTarget(LavaLauncher p_35087_) {
			      Optional<LivingEntity> optional = BehaviorUtils.getLivingEntityFromUUIDMemory(p_35087_, MemoryModuleType.ANGRY_AT);
			      if (optional.isPresent() && CustomSensor.isEntityAttackableIgnoringLineOfSight(p_35087_, optional.get())) {
			         return optional;
			      } else {
			         Optional<? extends LivingEntity> optional1 = getTargetIfWithinRange(p_35087_, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER);
			         return optional1.isPresent() ? optional1 : p_35087_.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
			      }
			   }

			   private static Optional<? extends LivingEntity> getTargetIfWithinRange(LavaLauncher p_35092_, MemoryModuleType<? extends LivingEntity> p_35093_) {
			      return p_35092_.getBrain().getMemory(p_35093_).filter((p_35108_) -> {
			         return p_35108_.closerThan(p_35092_, p_35092_.getAttributeValue(Attributes.FOLLOW_RANGE));
			      });
			   }
			   
				public static void updateActivity(LavaLauncher p_35100_) {
					Activity activity = p_35100_.getBrain().getActiveNonCoreActivity().orElse((Activity) null);
					p_35100_.getBrain().setActiveActivityToFirstValid(ImmutableList.of(Activity.FIGHT, Activity.IDLE));
					Activity activity1 = p_35100_.getBrain().getActiveNonCoreActivity().orElse((Activity) null);
					if (activity1 == Activity.FIGHT && activity != Activity.FIGHT) {
						p_35100_.playAngrySound();
					}

					p_35100_.setAggressive(p_35100_.getBrain().hasMemoryValue(MemoryModuleType.ATTACK_TARGET));
				}
}
