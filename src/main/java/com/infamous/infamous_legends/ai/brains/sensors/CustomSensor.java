package com.infamous.infamous_legends.ai.brains.sensors;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public abstract class CustomSensor<E extends LivingEntity> extends Sensor<E> {
	
	   private static final TargetingConditions TARGET_CONDITIONS = TargetingConditions.forNonCombat();
	   private static final TargetingConditions TARGET_CONDITIONS_IGNORE_INVISIBILITY_TESTING = TargetingConditions.forNonCombat().ignoreInvisibilityTesting();
	   private static final TargetingConditions ATTACK_TARGET_CONDITIONS = TargetingConditions.forCombat();
	   private static final TargetingConditions ATTACK_TARGET_CONDITIONS_IGNORE_INVISIBILITY_TESTING = TargetingConditions.forCombat().ignoreInvisibilityTesting();
	   private static final TargetingConditions ATTACK_TARGET_CONDITIONS_IGNORE_LINE_OF_SIGHT = TargetingConditions.forCombat().ignoreLineOfSight();
	   private static final TargetingConditions ATTACK_TARGET_CONDITIONS_IGNORE_INVISIBILITY_AND_LINE_OF_SIGHT = TargetingConditions.forCombat().ignoreLineOfSight().ignoreInvisibilityTesting();
	   
		public static boolean isEntityTargetable(LivingEntity p_26804_, LivingEntity p_26805_) {
			return p_26804_.getBrain().isMemoryValue(MemoryModuleType.ATTACK_TARGET, p_26805_)
					? TARGET_CONDITIONS_IGNORE_INVISIBILITY_TESTING.test(p_26804_, p_26805_)
					: TARGET_CONDITIONS.test(p_26804_, p_26805_);
		}

		public static boolean isEntityAttackable(LivingEntity p_148313_, LivingEntity p_148314_) {
			return p_148313_.getBrain().isMemoryValue(MemoryModuleType.ATTACK_TARGET, p_148314_)
					? ATTACK_TARGET_CONDITIONS_IGNORE_INVISIBILITY_TESTING.test(p_148313_, p_148314_)
					: ATTACK_TARGET_CONDITIONS.test(p_148313_, p_148314_);
		}

		public static boolean isEntityAttackableIgnoringLineOfSight(LivingEntity p_182378_, LivingEntity p_182379_) {
			return p_182378_.getBrain().isMemoryValue(MemoryModuleType.ATTACK_TARGET, p_182379_)
					? ATTACK_TARGET_CONDITIONS_IGNORE_INVISIBILITY_AND_LINE_OF_SIGHT.test(p_182378_, p_182379_)
					: ATTACK_TARGET_CONDITIONS_IGNORE_LINE_OF_SIGHT.test(p_182378_, p_182379_);
		}		
}
