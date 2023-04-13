package com.infamous.infamous_legends.entities;

import com.infamous.dungeons_libraries.capabilities.minionmaster.Master;
import com.infamous.dungeons_libraries.capabilities.minionmaster.Minion;
import com.infamous.dungeons_libraries.capabilities.minionmaster.MinionMasterHelper;
import com.infamous.infamous_legends.events.ShakeCameraEvent;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class MagmaCubeProjectile extends ThrowableProjectile {
	
	public Explosion.BlockInteraction blockInteraction = Explosion.BlockInteraction.DESTROY;
	
	   public MagmaCubeProjectile(EntityType<? extends MagmaCubeProjectile> p_37391_, Level p_37392_) {
		      super(p_37391_, p_37392_);
		   }

		   public MagmaCubeProjectile(Level p_37399_, LivingEntity p_37400_) {
		      super(EntityTypeInit.MAGMA_CUBE_PROJECTILE.get(), p_37400_, p_37399_);
		   }

		   public MagmaCubeProjectile(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
		      super(EntityTypeInit.MAGMA_CUBE_PROJECTILE.get(), p_37395_, p_37396_, p_37397_, p_37394_);
		   }
		   
		   @Override
		public void tick() {
			super.tick();				
			if (this.level.isClientSide && !this.isInWaterRainOrBubble()) {
				this.level.addParticle(ParticleTypes.FLAME, this.getRandomX(1.0F), this.getRandomY(), this.getRandomZ(1.0F), 0, 0, 0);
			}
		}
		   
		   @Override
			protected boolean canHitEntity(Entity p_36743_) {
				boolean piglinThatCantBeHurt = this.getOwner() != null && this.getOwner() instanceof AbstractPiglin && MiscUtils.piglinAllies(this.getOwner(), p_36743_);
				return !piglinThatCantBeHurt && super.canHitEntity(p_36743_);
			}

		@Override
		protected void defineSynchedData() {
			
		}
		
		@Override
		protected void onHit(HitResult p_37260_) {
			super.onHit(p_37260_);
			if (!this.level.isClientSide) {
				ShakeCameraEvent.shake(this.level, 30, 0.075F, this.blockPosition(), 8);
				((ServerLevel)this.level).sendParticles(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 12, 0.2D, 0.2D, 0.2D, 0.0D);
				((ServerLevel)this.level).sendParticles(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 60, 2, 2, 2, 0.0D);
				((ServerLevel)this.level).sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 20, this.getBbWidth(), this.getBbHeight(), this.getBbWidth(), 0.0D);
				int i = 5;
		         for(int j = 0; j < i * 8; ++j) {
		             float f = this.random.nextFloat() * ((float)Math.PI * 2F);
		             float f1 = this.random.nextFloat() * 0.5F + 0.5F;
		             float f2 = Mth.sin(f) * (float)i * 0.5F * f1;
		             float f3 = Mth.cos(f) * (float)i * 0.5F * f1;
		             ((ServerLevel)this.level).sendParticles(ParticleTypes.FLAME, this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 1, 0.0D, 0.0D, 0.0D, 0.0D);
		          }
				this.playSound(SoundEvents.MAGMA_CUBE_SQUISH, 2.0F, 0.75F);
				MiscUtils.customExplosion(this.level, this.getOwner() != null ? this.getOwner() instanceof Player ? this : this.getOwner() : this, DamageSource.explosion(this.getOwner() != null && this.getOwner() instanceof LivingEntity ? ((LivingEntity)this.getOwner()) : null).setProjectile(), null, this.getX(), this.getY(),
						this.getZ(), 3.0F, false, this.blockInteraction, SoundEvents.GENERIC_EXPLODE,
						this.getSoundSource(), ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION_EMITTER, 17.5F, false);
				for (Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(3))) {
					if (entity instanceof LivingEntity && !MiscUtils.piglinAllies(this, entity)) {
						MiscUtils.disableShield(((LivingEntity)entity), 120);
						entity.setSecondsOnFire(5);
						if (this.distanceTo(entity) > 0.3) {
							double d0 = entity.getX() - this.getX();
							double d1 = entity.getZ() - this.getZ();
							double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
							entity.push(d0 / d2 * 2.5D, 0.5D, d1 / d2 * 2.5D);
						}
					}
				}
				
				if (this.getOwner() != null && this.getOwner() instanceof LivingEntity) {
					for (int i1 = 0; i1 < 2; i1++) {
						MagmaCube magmaCube = EntityType.MAGMA_CUBE.create(this.level);
			            Master masterCapability = MinionMasterHelper.getMasterCapability(this.getOwner());
			            Minion minionCapability = MinionMasterHelper.getMinionCapability(magmaCube);
			            masterCapability.addMinion(magmaCube);
			            minionCapability.setMaster(((LivingEntity)this.getOwner()));
			            minionCapability.setSummon(true);
			            minionCapability.setTemporary(true);
			            minionCapability.setMinionTimer(400);
			            minionCapability.setSummon(true);
			            if (this.getOwner() instanceof Mob && ((Mob)this.getOwner()).getTarget() != null) {
			            	magmaCube.setTarget(((Mob)this.getOwner()).getTarget());
			            }
			            magmaCube.setSize(2, true);
			            magmaCube.moveTo(this.position());
			            MinionMasterHelper.addMinionGoals(magmaCube);
			            this.level.addFreshEntity(magmaCube);
					}
				}
				this.discard();
			}
		}
}
