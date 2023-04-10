package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class PortalGuardWreckingBall extends AbstractArrow {
	   
	   private static final EntityDataAccessor<Integer> CLIENT_SERVER_ID = SynchedEntityData.defineId(PortalGuardWreckingBall.class, EntityDataSerializers.INT);
	   
	   public boolean hasLanded;
	   public boolean playedChainSound;
	   
	   public float landingXRot;
	   public float landingYRot;
	   
	   public PortalGuardWreckingBall(EntityType<? extends PortalGuardWreckingBall> p_37561_, Level p_37562_) {
	      super(p_37561_, p_37562_);
	      this.pickup = AbstractArrow.Pickup.DISALLOWED;
	      
	   }

	   public PortalGuardWreckingBall(Level p_37569_, LivingEntity p_37570_) {
	      super(EntityTypeInit.PORTAL_GUARD_WRECKING_BALL.get(), p_37570_, p_37569_);
	      this.pickup = AbstractArrow.Pickup.DISALLOWED;
	   }
	   
		   @Override
		protected void defineSynchedData() {
			super.defineSynchedData();
			this.entityData.define(CLIENT_SERVER_ID, 0);
		}
		   
	   public void setClientOwner(Entity newOwner) {
		   if (newOwner != null) {
			   this.entityData.set(CLIENT_SERVER_ID, newOwner.getId());
		   }
	   }
	   
	   public LivingEntity getClientOwner() {
		   return this.level.getEntity(this.entityData.get(CLIENT_SERVER_ID)) instanceof LivingEntity ? ((LivingEntity)this.level.getEntity(this.entityData.get(CLIENT_SERVER_ID))) : null;
	   }
	   
	   public PortalGuard getPortalGuardOwner() {
		   Entity owner = this.level.isClientSide ? this.getClientOwner() : this.getOwner();
		   return owner instanceof PortalGuard ? ((PortalGuard)owner) : null;
	   }

	   public void tick() {
	      super.tick();
	      
	      double distance = 20;
	      
	      if (!this.level.isClientSide && this.getPortalGuardOwner() != null) {
	    	  distance = this.getPortalGuardOwner().getTarget() != null ? this.getPortalGuardOwner().distanceTo(this.getPortalGuardOwner().getTarget()) - 2 : 20;
	      }
	      
	      if (!this.level.isClientSide && this.getPortalGuardOwner() != null && !this.hasLanded && this.distanceTo(this.getPortalGuardOwner()) >= distance) {
	    	  this.getPortalGuardOwner().push(this.getDeltaMovement().x * 0.25, 0, this.getDeltaMovement().z * 0.25);
	    	  this.setDeltaMovement(this.getDeltaMovement().x * 0.5, this.getDeltaMovement().y - 0.05, this.getDeltaMovement().z * 0.5);
	    	  if (!this.playedChainSound) {
	    		  this.playSound(SoundEvents.CHAIN_PLACE);
	    		  this.playedChainSound = true;
	    	  }
	      }
	      
	      if (!this.level.isClientSide && this.getPortalGuardOwner() != null && this.hasLanded && this.inGroundTime >= 20 && this.getPortalGuardOwner().reelInBallAnimationTick <= 0) {
	    	  this.getPortalGuardOwner().reelInBallAnimationTick = this.getPortalGuardOwner().reelInBallAnimationLength;
	    	  this.level.broadcastEntityEvent(this.getPortalGuardOwner(), (byte)8);
	    	  this.getPortalGuardOwner().playingIdleShootingAnimation = false;
	    	  this.level.broadcastEntityEvent(this.getPortalGuardOwner(), (byte)10);
	      }
	      
	      if (!this.level.isClientSide && this.getPortalGuardOwner() != null && this.getPortalGuardOwner().reelInBallAnimationTick == this.getPortalGuardOwner().reelInBallAnimationActionPoint) {
	    	  this.discard();
	      }
	      
	      if (this.getPortalGuardOwner() != null) {
	    	  this.getPortalGuardOwner().getNavigation().stop();
	    	  this.getPortalGuardOwner().lookAt(Anchor.EYES, this.position());
	    	  this.getPortalGuardOwner().hasWreckingBallTime = 2;
	      }
	      
	      if (this.getPortalGuardOwner() != null && (this.getPortalGuardOwner().reelInBallAnimationTick == this.getPortalGuardOwner().reelInBallAnimationLength - 6 || this.getPortalGuardOwner().reelInBallAnimationTick == this.getPortalGuardOwner().reelInBallAnimationLength - 20 || this.getPortalGuardOwner().reelInBallAnimationTick == this.getPortalGuardOwner().reelInBallAnimationLength - 35)) {
	    	  this.inGround = false;
	    	  
	    	  this.playSound(SoundEvents.CHAIN_PLACE, 1.0F, MiscUtils.randomSoundPitch() * 0.75F);
	    	  this.playSound(SoundEvents.GRASS_STEP, 1.25F, MiscUtils.randomSoundPitch() * 0.005F);
	    	  
	    	  double speed = 0.325 * (this.distanceTo(this.getPortalGuardOwner()) * 0.25);
	    	  
	    	  this.setPos(this.getX(), this.getY() + 0.1, this.getZ());
	    	  
	    	  Vec3 vec3 = PositionUtils.getOffsetPos(this.getPortalGuardOwner(), 1.5, 2.0, 2, this.getPortalGuardOwner().yBodyRot);
	    	  
				double x = vec3.x - this.getX();
				double y = vec3.y - this.getY();
				double z = vec3.z - this.getZ();
				double d = Math.sqrt(x * x + y * y + z * z);
				this.setDeltaMovement(this.getDeltaMovement()
						.add(x / d * speed, y / d * speed, z / d * speed));
	      }
	      
	      if (this.getPortalGuardOwner() != null && this.getPortalGuardOwner().reelInBallAnimationTick > 0) {
	    	  this.level.addParticle(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
	      }
	      
	      if (this.hasLanded) {
	    	  this.setXRot(this.landingXRot);
	    	  this.setYRot(this.landingYRot);
	      }
	      
	      this.setClientOwner(this.getOwner());
	   }
	   
	   @Override
		protected boolean canHitEntity(Entity p_36743_) {
			boolean piglinThatCantBeHurt = this.getOwner() != null && this.getOwner() instanceof AbstractPiglin && MiscUtils.piglinAllies(this.getOwner(), p_36743_);
			return !piglinThatCantBeHurt && super.canHitEntity(p_36743_);
		}

	   protected ItemStack getPickupItem() {
	      return null;
	   }

	   @Nullable
	   protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
	      return super.findHitEntity(p_37575_, p_37576_);
	   }
	   
	   @Override
	protected float getWaterInertia() {
		return 1.0F;
	}
	   
	   @Override
	protected void onHitBlock(BlockHitResult p_36755_) {
			if (!this.hasLanded) {
				this.landingXRot = this.getXRot();
				this.landingYRot = this.getYRot();
				if (!this.level.isClientSide) {
					((ServerLevel)this.level).sendParticles(ParticleTypeInit.DUST.get(), this.getX(), this.getY(), this.getZ(), 12, 0.2D, 0.2D, 0.2D, 0.0D);
					this.playSound(SoundEvents.ANVIL_LAND, 2.0F, 0.75F);
					this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0F, 0.75F);
					for (Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(2))) {
						if (entity instanceof LivingEntity && !MiscUtils.piglinAllies(this, entity)) {
							boolean flag = entity.hurt(DamageSource.explosion(this.getOwner() instanceof LivingEntity ? ((LivingEntity)this.getOwner()) : null), 20);
							MiscUtils.disableShield(((LivingEntity)entity), 150);
							if (this.distanceTo(entity) > 0.2) {
								double d0 = entity.getX() - this.getX();
								double d1 = entity.getZ() - this.getZ();
								double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
								entity.push(d0 / d2 * 2.0D, 0.3D, d1 / d2 * 2.0D);
							}
						}
					}
				}
			}
			this.hasLanded = true;
		super.onHitBlock(p_36755_);
	}

	   protected void onHitEntity(EntityHitResult p_37573_) {
		  if (!this.hasLanded && !this.level.isClientSide) {
		      Entity entity = p_37573_.getEntity();
		      float f = 25F;
		      Entity entity1 = this.getOwner();
		      DamageSource damagesource = DamageSource.thrown(this, (Entity)(entity1 == null ? this : entity1));
		      SoundEvent soundevent = SoundEvents.ANVIL_LAND;
		      boolean flag = entity.hurt(damagesource, f);
		      
		      if (entity instanceof LivingEntity) {
		    	  MiscUtils.disableShield(((LivingEntity)entity), 300);
		      }
	
		      this.playSound(soundevent, 1.0F, 1.0F);
		  }
	   }
	   
	   @Override
	public void setSoundEvent(SoundEvent p_36741_) {

	}

	   protected boolean tryPickup(Player p_150196_) {
	      return false;
	   }

	   protected SoundEvent getDefaultHitGroundSoundEvent() {
	      return null;
	   }

	   public void playerTouch(Player p_37580_) {
	      if (this.ownedBy(p_37580_) || this.getOwner() == null) {
	         super.playerTouch(p_37580_);
	      }

	   }

	   public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
	      return true;
	   }
	   
	   @Override
		public Packet<?> getAddEntityPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
	}
