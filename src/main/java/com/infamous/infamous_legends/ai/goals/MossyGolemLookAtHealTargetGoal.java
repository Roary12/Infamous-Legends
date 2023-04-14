package com.infamous.infamous_legends.ai.goals;

import java.util.EnumSet;

import com.infamous.infamous_legends.entities.MossyGolem;

import net.minecraft.world.entity.ai.goal.Goal;

public class MossyGolemLookAtHealTargetGoal extends Goal {
   protected final MossyGolem mob;

   public MossyGolemLookAtHealTargetGoal(MossyGolem mob) {
	  this.setFlags(EnumSet.of(Goal.Flag.LOOK));
      this.mob = mob;
   }

   public boolean canUse() {
         return mob.getHealTarget() != null && mob.getHealTarget().isAlive();
   }

   public boolean canContinueToUse() {
       return mob.getHealTarget() != null && mob.getHealTarget().isAlive();
   }

   public void tick() {
      if (mob.getHealTarget() != null && mob.getHealTarget().isAlive()) {
         this.mob.getLookControl().setLookAt(mob.getHealTarget().getX(), mob.getHealTarget().getEyeY(), mob.getHealTarget().getZ());
      }
   }
}