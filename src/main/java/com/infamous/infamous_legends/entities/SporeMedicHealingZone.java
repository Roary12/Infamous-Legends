package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraftforge.entity.PartEntity;

public class SporeMedicHealingZone extends PartEntity<SporeMedic> {

	public final SporeMedic parentMob;
	
	public SporeMedicHealingZone(SporeMedic parent) {
		super(parent);
		this.parentMob = parent;
		this.refreshDimensions();
	}
	
	public void tickHealing() {
		if (!this.level.isClientSide && this.parentMob.shooting) {		
			for (LivingEntity entity : this.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forNonCombat(), this.parentMob, this.getBoundingBox())) {
				if (entity != this.parentMob && MiscUtils.piglinAllies(this.parentMob, entity)) {
					if (entity.tickCount % 10 == 0) {
						entity.heal(1);
					}
				}
			}
		}
	}

	@Override
	protected void defineSynchedData() {
		
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag p_20052_) {
		
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag p_20139_) {
		
	}
	
	public void refreshDimensions() {
		double d0 = this.getX();
		double d1 = this.getY();
		double d2 = this.getZ();
		super.refreshDimensions();
		this.setPos(d0, d1, d2);
	}

	public EntityDimensions getDimensions(Pose p_213305_1_) {
		return EntityDimensions.scalable(3.5F, 3.5F);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean isAttackable() {
		return false;
	}

	@Override
	public boolean isPickable() {
		return false;
	}
}
