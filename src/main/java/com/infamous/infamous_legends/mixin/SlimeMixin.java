package com.infamous.infamous_legends.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.infamous.dungeons_libraries.capabilities.minionmaster.Master;
import com.infamous.dungeons_libraries.capabilities.minionmaster.Minion;
import com.infamous.dungeons_libraries.capabilities.minionmaster.MinionMasterHelper;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

@Mixin(Slime.class)
public abstract class SlimeMixin extends Mob {

	protected SlimeMixin(EntityType<? extends Mob> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
	
	@Shadow
	public abstract EntityType<? extends Slime> getType();
	
	@Shadow
    public abstract int getSize();

	@Inject(at = @At("HEAD"), method = "remove", cancellable = true)
	public void infamous_legends_makeSmallSlimesStayMinions(Entity.RemovalReason pReason, CallbackInfo callback) {
	      int i = this.getSize();
	      if (!this.level.isClientSide && i > 1 && this.isDeadOrDying()) {
	         Component component = this.getCustomName();
	         boolean flag = this.isNoAi();
	         float f = (float)i / 4.0F;
	         int j = i / 2;
	         int k = 2 + this.random.nextInt(3);

	         for(int l = 0; l < k; ++l) {
	            float f1 = ((float)(l % 2) - 0.5F) * f;
	            float f2 = ((float)(l / 2) - 0.5F) * f;
	            Slime slime = this.getType().create(this.level);
	            if (this.isPersistenceRequired()) {
	               slime.setPersistenceRequired();
	            }

	            Minion thisMinionCapability = MinionMasterHelper.getMinionCapability(this);
	            if (thisMinionCapability.getMaster() != null) {
		            Master masterCapability = MinionMasterHelper.getMasterCapability(MinionMasterHelper.getMinionCapability(this).getMaster());
		            Minion newSlimeMinionCapability = MinionMasterHelper.getMinionCapability(slime);
		            
		            masterCapability.addMinion(slime);
		            newSlimeMinionCapability.setMaster(thisMinionCapability.getMaster());
		            newSlimeMinionCapability.setMinionTimer(thisMinionCapability.getMinionTimer());
		            newSlimeMinionCapability.setRevertsOnExpiration(thisMinionCapability.revertsOnExpiration());
		            newSlimeMinionCapability.setSummon(thisMinionCapability.isSummon());
		            newSlimeMinionCapability.setTemporary(thisMinionCapability.isTemporary());
		            MinionMasterHelper.addMinionGoals(slime);
	            }

	            slime.setCustomName(component);
	            slime.setNoAi(flag);
	            slime.setInvulnerable(this.isInvulnerable());
	            slime.setSize(j, true);
	            slime.moveTo(this.getX() + (double)f1, this.getY() + 0.5D, this.getZ() + (double)f2, this.random.nextFloat() * 360.0F, 0.0F);
	            this.level.addFreshEntity(slime);
	         }
	      }

	      super.remove(pReason);
	      callback.cancel();
	   }
}
