package com.infamous.infamous_legends.ai.brains;

import java.util.Optional;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.infamous.infamous_legends.ai.brains.behaviours.LookAtAttackTarget;
import com.infamous.infamous_legends.ai.brains.behaviours.WarBoarMeleeAttack;
import com.infamous.infamous_legends.ai.brains.behaviours.WarBoarStartAttacking;
import com.infamous.infamous_legends.ai.brains.sensors.CustomSensor;
import com.infamous.infamous_legends.entities.WarBoar;
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
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromAttackTargetIfTargetOutOfReach;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromLookTarget;
import net.minecraft.world.entity.ai.behavior.StopAttackingIfTargetInvalid;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.schedule.Activity;

public class WarBoarAi {

	  public static Brain<?> makeBrain(WarBoar p_35100_, Brain<WarBoar> p_35101_) {
	      initCoreActivity(p_35100_, p_35101_);
	      initIdleActivity(p_35100_, p_35101_);
	      initFightActivity(p_35100_, p_35101_);
	      p_35101_.setCoreActivities(ImmutableSet.of(Activity.CORE));
	      p_35101_.setDefaultActivity(Activity.IDLE);
	      p_35101_.useDefaultActivity();
	      return p_35101_;
	   }
	  
		private static void initCoreActivity(WarBoar p_35100_, Brain<WarBoar> p_34217_) {
			p_34217_.addActivity(Activity.CORE, 0, ImmutableList.of(new LookAtTargetSink(45, 90), new MoveToTargetSink()));
		}

		private static void initIdleActivity(WarBoar p_35100_, Brain<WarBoar> p_34229_) {
			p_34229_.addActivity(Activity.IDLE, 10,
					ImmutableList.of(new WarBoarStartAttacking<>(WarBoarAi::findNearestValidAttackTarget),
							new RunSometimes<WarBoar>(new SetEntityLookTarget(8.0F), UniformInt.of(30, 60)),
							new RunOne<WarBoar>(ImmutableList.of(Pair.of(new RandomStroll(0.4F), 2),
									Pair.of(new SetWalkTargetFromLookTarget(0.4F, 3), 2),
									Pair.of(new DoNothing(30, 60), 1)))));
		}

		private static void initFightActivity(WarBoar p_35100_, Brain<WarBoar> p_34237_) {
			p_34237_.addActivityAndRemoveMemoryWhenStopped(Activity.FIGHT, 10,
					ImmutableList.of(new SetWalkTargetFromAttackTargetIfTargetOutOfReach(1.0F),
							new WarBoarMeleeAttack(20), new LookAtAttackTarget(),
							new StopAttackingIfTargetInvalid<>((p_35118_) -> {
						         return !isNearestValidAttackTarget(p_35100_, p_35118_);
						      })),
					MemoryModuleType.ATTACK_TARGET);
		}
		
		   private static boolean isNearestValidAttackTarget(WarBoar p_35089_, LivingEntity p_35090_) {
			      return findNearestValidAttackTarget(p_35089_).filter((p_35085_) -> {
			         return p_35085_ == p_35090_;
			      }).isPresent();
			   }

			   private static Optional<? extends LivingEntity> findNearestValidAttackTarget(WarBoar p_35087_) {
			      Optional<LivingEntity> optional = BehaviorUtils.getLivingEntityFromUUIDMemory(p_35087_, MemoryModuleType.ANGRY_AT);
			      if (optional.isPresent() && CustomSensor.isEntityAttackableIgnoringLineOfSight(p_35087_, optional.get())) {
			         return optional;
			      } else {
			         Optional<? extends LivingEntity> optional1 = getTargetIfWithinRange(p_35087_, MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER);
			         return optional1.isPresent() ? optional1 : p_35087_.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_NEMESIS);
			      }
			   }

			   private static Optional<? extends LivingEntity> getTargetIfWithinRange(WarBoar p_35092_, MemoryModuleType<? extends LivingEntity> p_35093_) {
			      return p_35092_.getBrain().getMemory(p_35093_).filter((p_35108_) -> {
			         return p_35108_.closerThan(p_35092_, p_35092_.getAttributeValue(Attributes.FOLLOW_RANGE));
			      });
			   }
			   
				public static void updateActivity(WarBoar p_35100_) {
					Activity activity = p_35100_.getBrain().getActiveNonCoreActivity().orElse((Activity) null);
					p_35100_.getBrain().setActiveActivityToFirstValid(ImmutableList.of(Activity.FIGHT, Activity.IDLE));
					Activity activity1 = p_35100_.getBrain().getActiveNonCoreActivity().orElse((Activity) null);
					if (activity1 == Activity.FIGHT && activity != Activity.FIGHT) {
						p_35100_.playAngrySound();
					}

					p_35100_.setAggressive(p_35100_.getBrain().hasMemoryValue(MemoryModuleType.ATTACK_TARGET));
				}
}
