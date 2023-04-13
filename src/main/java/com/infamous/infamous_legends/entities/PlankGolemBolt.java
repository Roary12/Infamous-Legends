package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class PlankGolemBolt extends AbstractArrow {

	private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(PlankGolemBolt.class, EntityDataSerializers.INT);
	
	private int life;
	   
	public PlankGolemBolt(EntityType<? extends PlankGolemBolt> p_37561_, Level p_37562_) {
		super(p_37561_, p_37562_);
		this.pickup = AbstractArrow.Pickup.DISALLOWED;
	}

	public PlankGolemBolt(Level p_37569_, LivingEntity p_37570_) {
		super(EntityTypeInit.PLANK_GOLEM_BOLT.get(), p_37570_, p_37569_);
		this.pickup = AbstractArrow.Pickup.DISALLOWED;
	}
	
	@Override
	protected boolean canHitEntity(Entity p_36743_) {
		boolean mobThatCantBeHurt = this.getOwner() != null && this.getOwner() instanceof PlankGolem
				&& MiscUtils.nonEnemy(this.getOwner(), p_36743_);
		return !mobThatCantBeHurt && super.canHitEntity(p_36743_);
	}
	
	protected void onHitEntity(EntityHitResult p_37573_) {
		if (!this.level.isClientSide) {
			Entity entity = p_37573_.getEntity();
			float f = 4F;
			Entity entity1 = this.getOwner();
			DamageSource damagesource = DamageSource.arrow(this, (Entity) (entity1 == null ? this : entity1));
			SoundEvent soundevent = SoundEvents.ARROW_HIT;
			if (entity.hurt(damagesource, f)) {
				if (entity.getType() == EntityType.ENDERMAN) {
					return;
				}
			}
	
			this.discard();
	
			this.playSound(soundevent, 1.0F, 1.0F);
		}
	}

	@Override
	protected boolean tryPickup(Player pPlayer) {
		return false;
	}

	@Override
	protected ItemStack getPickupItem() {
		return null;
	}
	
	protected void defineSynchedData() {
	    super.defineSynchedData();
		this.entityData.define(TYPE, PlankGolem.Type.OAK.ordinal());
	}
	
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putString("Type", this.getPlankGolemType().getName());
	}

	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		if (pCompound.contains("Type", 8)) {
			this.setType(PlankGolem.Type.byName(pCompound.getString("Type")));
		}
	}
	
	public void setType(PlankGolem.Type type) {
		this.entityData.set(TYPE, type.ordinal());
	}

	public PlankGolem.Type getPlankGolemType() {
		return PlankGolem.Type.byId(this.entityData.get(TYPE));
	}
	
	   @Override
		protected void tickDespawn() {
			++this.life;
			if (this.life >= 100) {
				this.discard();
			}
		}
	   
	   @Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
