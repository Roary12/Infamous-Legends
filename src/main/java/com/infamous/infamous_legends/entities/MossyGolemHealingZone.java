package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraftforge.entity.PartEntity;

public class MossyGolemHealingZone extends PartEntity<MossyGolem> {

	public final MossyGolem parentMob;
	
	public MossyGolemHealingZone(MossyGolem parent) {
		super(parent);
		this.parentMob = parent;
		this.refreshDimensions();
	}
	
	public void tickHealing() {
		if (this.parentMob.shooting && this.tickCount % 3 == 0) {
			this.level.addParticle(ParticleTypeInit.WATER_SPLASH.get(), this.getX(), this.getY() + 0.5, this.getZ(), 0, 0, 0);
			this.level.addParticle(ParticleTypeInit.WATER.get(), this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.05, 0.25, this.random.nextGaussian() * 0.05);
		}
		if (!this.level.isClientSide && this.parentMob.shooting) {		
			for (LivingEntity entity : this.level.getNearbyEntities(LivingEntity.class, TargetingConditions.forNonCombat(), this.parentMob, this.getBoundingBox())) {
				if (entity != this.parentMob && MiscUtils.golemAllies(this.parentMob, entity)) {
					if (entity.tickCount % 10 == 0) {
						entity.heal(1);
						if (entity.isOnFire()) {
							entity.clearFire();
							entity.playSound(SoundEvents.GENERIC_EXTINGUISH_FIRE);
						}
					}
				} else if (entity != this.parentMob && !MiscUtils.golemAllies(this.parentMob, entity) && entity.isSensitiveToWater() && entity.tickCount % 10 == 0) {
					entity.hurt(DamageSource.DROWN, 1.0F);
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
		return EntityDimensions.scalable(2.5F, 2.5F);
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
