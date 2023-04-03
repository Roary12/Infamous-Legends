package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class PiglinBomb extends ThrowableProjectile {

	public Explosion.BlockInteraction blockInteraction = Explosion.BlockInteraction.DESTROY;
	
	public int textureChange;
	
	   public PiglinBomb(EntityType<? extends PiglinBomb> p_37391_, Level p_37392_) {
		      super(p_37391_, p_37392_);
		   }

		   public PiglinBomb(Level p_37399_, LivingEntity p_37400_) {
		      super(EntityTypeInit.PIGLIN_BOMB.get(), p_37400_, p_37399_);
		   }

		   public PiglinBomb(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
		      super(EntityTypeInit.PIGLIN_BOMB.get(), p_37395_, p_37396_, p_37397_, p_37394_);
		   }
		   
		   @Override
		public void tick() {
			super.tick();	
			if (this.tickCount % 3 == 0) {
				this.textureChange ++;
			}
			
			if (this.level.isClientSide && !this.isInWaterRainOrBubble()) {
				this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
			}
		}
		   
		   @Override
			protected boolean canHitEntity(Entity p_36743_) {
				boolean piglinThatCantBeHurt = this.getOwner() != null && this.getOwner() instanceof AbstractPiglin && p_36743_.getTeam() == null && this.getOwner().getTeam() == null && p_36743_ instanceof AbstractPiglin;
				return !piglinThatCantBeHurt && super.canHitEntity(p_36743_);
			}

		@Override
		protected void defineSynchedData() {
			
		}
		
		@Override
		protected void onHit(HitResult p_37260_) {
			super.onHit(p_37260_);
			if (!this.level.isClientSide) {
				MiscUtils.customExplosion(this.level, this.getOwner() != null ? this.getOwner() instanceof Player ? this : this.getOwner() : this, DamageSource.explosion(this.getOwner() != null && this.getOwner() instanceof LivingEntity ? ((LivingEntity)this.getOwner()) : null).setProjectile(), null, this.getX(), this.getY(),
						this.getZ(), 3.0F, false, this.blockInteraction, SoundEvents.GENERIC_EXPLODE,
						this.getSoundSource(), ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, 15.0F, false);
				this.discard();
			}
		}
}
