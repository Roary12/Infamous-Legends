package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.entity.PartEntity;

public class LavaLauncherPiglin extends PartEntity<LavaLauncher> {

	public final LavaLauncher parentMob;
	
	public LavaLauncherPiglin(LavaLauncher parent) {
		super(parent);
		this.parentMob = parent;
		this.refreshDimensions();
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
	
	@Override
	public boolean hurt(DamageSource p_19946_, float p_19947_) {
		boolean flag = !this.isInvulnerableTo(p_19946_) && this.parentMob.getPiglinHealth() > 0 && this.parentMob.piglinInvulnerableTime <= 0;
		if (flag && !this.level.isClientSide) {
			this.parentMob.setPiglinHealth(this.parentMob.getPiglinHealth() - p_19947_);
			this.parentMob.resetPiglinAmbientSoundTime();
			this.playSound(this.parentMob.getPiglinHealth() <= 0 ? SoundEvents.PIGLIN_BRUTE_DEATH : SoundEvents.PIGLIN_BRUTE_HURT, 1.0F, MiscUtils.randomSoundPitch() * 1.4F);
			this.parentMob.piglinInvulnerableTime = 20;
			this.level.broadcastEntityEvent(this.parentMob, (byte)9);
		}
		return flag;
	}
	
	public void refreshDimensions() {
		double d0 = this.getX();
		double d1 = this.getY();
		double d2 = this.getZ();
		super.refreshDimensions();
		this.setPos(d0, d1, d2);
	}

	public EntityDimensions getDimensions(Pose p_213305_1_) {
		return EntityDimensions.scalable(0.6F, 1.4F);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean isAttackable() {
		return this.parentMob.getPiglinHealth() > 0;
	}

	@Override
	public boolean isPickable() {
		return this.parentMob.getPiglinHealth() > 0;
	}
}
