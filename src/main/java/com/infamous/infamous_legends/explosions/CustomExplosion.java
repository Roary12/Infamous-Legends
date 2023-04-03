package com.infamous.infamous_legends.explosions;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;
import com.infamous.infamous_legends.interfaces.IHasCustomExplosion;
import com.mojang.datafixers.util.Pair;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;
import net.minecraft.world.level.EntityBasedExplosionDamageCalculator;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CustomExplosion extends Explosion {

	   private static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new ExplosionDamageCalculator();
	   
	   private final ExplosionDamageCalculator damageCalculator;	   
	   private final RandomSource random = RandomSource.create();
	   private final Level level;
	   private final boolean fire;
	   private final Explosion.BlockInteraction blockInteraction;
	   private final float radius;
	   
	public SoundEvent sound;
	public ParticleOptions particle;
	public ParticleOptions secondaryParticle;
	public float damage;
	public SoundSource soundSource;
	public boolean friendlyFire;
	
	public CustomExplosion(Level level, Entity explodingEntity, DamageSource damageSource, ExplosionDamageCalculator damageCalculator,
			double x, double y, double z, float explosionSize, boolean createsFire,
			BlockInteraction blockInteraction, SoundEvent explosionSound, SoundSource explosionSoundSource, ParticleOptions explosionParticle, ParticleOptions secondaryExplosionParticle, float entityDamage, boolean friendlyFire) {
		super(level, explodingEntity, damageSource, damageCalculator, x, y, z, explosionSize, createsFire, blockInteraction);
		this.sound = explosionSound;
		this.particle = explosionParticle;
		this.secondaryParticle = secondaryExplosionParticle;
		this.damage = entityDamage;
		this.soundSource = explosionSoundSource;
		this.level = level;
		this.fire = createsFire;
		this.blockInteraction = blockInteraction;
		this.radius = explosionSize;
	    this.damageCalculator = damageCalculator == null ? this.makeDamageCalculator(explodingEntity) : damageCalculator;
	    this.friendlyFire = friendlyFire;
	}
	
	   private ExplosionDamageCalculator makeDamageCalculator(@Nullable Entity p_46063_) {
		      return (ExplosionDamageCalculator)(p_46063_ == null ? EXPLOSION_DAMAGE_CALCULATOR : new EntityBasedExplosionDamageCalculator(p_46063_));
		   }
	   
	   public boolean canHarm(Entity target) {
		   if (this.getExploder() != null && this.getExploder() instanceof IHasCustomExplosion) {
			   if (this.friendlyFire) {
				   return true;
			   } else {
				   return ((IHasCustomExplosion)this.getExploder()).canHarmWithExplosion(target);
			   }
		   } else {
			   return true;
		   }
	   }
	
	@Override
	   public void finalizeExplosion(boolean p_46076_) {
		if (this.sound != null) {
			this.level.playSound((Player)null, this.getPosition().x, this.getPosition().y, this.getPosition().z, this.sound, this.soundSource, 4.0F, (1.0F + (this.level.random.nextFloat() - this.level.random.nextFloat()) * 0.2F) * 0.7F);
		}

	      boolean flag = this.blockInteraction != Explosion.BlockInteraction.NONE;
	      if (p_46076_ && !this.level.isClientSide) {
	    	  if (this.particle == ParticleTypes.EXPLOSION || this.particle == ParticleTypes.EXPLOSION_EMITTER || this.secondaryParticle == ParticleTypes.EXPLOSION || this.secondaryParticle == ParticleTypes.EXPLOSION_EMITTER) {
			         if (!(this.radius < 2.0F) && flag) {
				            //this.level.addParticle(this.secondaryParticle, this.getPosition().x, this.getPosition().y, this.getPosition().z, 1.0D, 0.0D, 0.0D);
				            ((ServerLevel)this.level).sendParticles(this.secondaryParticle, this.getPosition().x, this.getPosition().y, this.getPosition().z, 1,
									0.0D, 1.0D, 0.0D, 0.0D);
				         } else {
				            //this.level.addParticle(this.particle, this.getPosition().x, this.getPosition().y, this.getPosition().z, 1.0D, 0.0D, 0.0D);
				            ((ServerLevel)this.level).sendParticles(this.particle, this.getPosition().x, this.getPosition().y, this.getPosition().z, 1,
									0.0D, 1.0D, 0.0D, 0.0D);
				         }
	    	  } else {
		    	  for (int i = 0; i < 10; i++) {
			         if (!(this.radius < 2.0F) && flag) {
			            //this.level.addParticle(this.secondaryParticle, this.getPosition().x, this.getPosition().y, this.getPosition().z, 1.0D, 0.0D, 0.0D);
			            ((ServerLevel)this.level).sendParticles(this.secondaryParticle, this.getPosition().x - this.radius + this.random.nextInt((int)this.radius * 2), this.getPosition().y - this.radius + this.random.nextInt((int)this.radius * 2), this.getPosition().z - this.radius + this.random.nextInt((int)this.radius * 2), 1,
								0.0D, 1.0D, 0.0D, 0.0D);
			         } else {
			            //this.level.addParticle(this.particle, this.getPosition().x, this.getPosition().y, this.getPosition().z, 1.0D, 0.0D, 0.0D);
			            ((ServerLevel)this.level).sendParticles(this.particle, this.getPosition().x - this.radius + this.random.nextInt((int)this.radius * 2), this.getPosition().y - this.radius + this.random.nextInt((int)this.radius * 2), this.getPosition().z - this.radius + this.random.nextInt((int)this.radius * 2), 1,
								0.0D, 1.0D, 0.0D, 0.0D);
			         }
		    	  }
	    	  }
	      }

	      if (flag) {
	         ObjectArrayList<Pair<ItemStack, BlockPos>> objectarraylist = new ObjectArrayList<>();
	         boolean flag1 = this.getSourceMob() instanceof Player;
	         Util.shuffle((ObjectArrayList)this.getToBlow(), this.level.random);

	         for(BlockPos blockpos : this.getToBlow()) {
	            BlockState blockstate = this.level.getBlockState(blockpos);
	            Block block = blockstate.getBlock();
	            if (!blockstate.isAir()) {
	               BlockPos blockpos1 = blockpos.immutable();
	               this.level.getProfiler().push("explosion_blocks");
	               if (blockstate.canDropFromExplosion(this.level, blockpos, this)) {
	                  Level $$9 = this.level;
	                  if ($$9 instanceof ServerLevel) {
	                     ServerLevel serverlevel = (ServerLevel)$$9;
	                     BlockEntity blockentity = blockstate.hasBlockEntity() ? this.level.getBlockEntity(blockpos) : null;
	                     LootContext.Builder lootcontext$builder = (new LootContext.Builder(serverlevel)).withRandom(this.level.random).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(blockpos)).withParameter(LootContextParams.TOOL, ItemStack.EMPTY).withOptionalParameter(LootContextParams.BLOCK_ENTITY, blockentity).withOptionalParameter(LootContextParams.THIS_ENTITY, this.getExploder());
	                     if (this.blockInteraction == Explosion.BlockInteraction.DESTROY) {
	                        lootcontext$builder.withParameter(LootContextParams.EXPLOSION_RADIUS, this.radius);
	                     }

	                     blockstate.spawnAfterBreak(serverlevel, blockpos, ItemStack.EMPTY, flag1);
	                     blockstate.getDrops(lootcontext$builder).forEach((p_46074_) -> {
	                        addBlockDrops(objectarraylist, p_46074_, blockpos1);
	                     });
	                  }
	               }

	               blockstate.onBlockExploded(this.level, blockpos, this);
	               this.level.getProfiler().pop();
	            }
	         }

	         for(Pair<ItemStack, BlockPos> pair : objectarraylist) {
	            Block.popResource(this.level, pair.getSecond(), pair.getFirst());
	         }
	      }

	      if (this.fire) {
	         for(BlockPos blockpos2 : this.getToBlow()) {
	            if (this.random.nextInt(3) == 0 && this.level.getBlockState(blockpos2).isAir() && this.level.getBlockState(blockpos2.below()).isSolidRender(this.level, blockpos2.below())) {
	               this.level.setBlockAndUpdate(blockpos2, BaseFireBlock.getState(this.level, blockpos2));
	            }
	         }
	      }

	   }
	
	   public static void addBlockDrops(ObjectArrayList<Pair<ItemStack, BlockPos>> p_46068_, ItemStack p_46069_, BlockPos p_46070_) {
		      int i = p_46068_.size();

		      for(int j = 0; j < i; ++j) {
		         Pair<ItemStack, BlockPos> pair = p_46068_.get(j);
		         ItemStack itemstack = pair.getFirst();
		         if (ItemEntity.areMergable(itemstack, p_46069_)) {
		            ItemStack itemstack1 = ItemEntity.merge(itemstack, p_46069_, 16);
		            p_46068_.set(j, Pair.of(itemstack1, pair.getSecond()));
		            if (p_46069_.isEmpty()) {
		               return;
		            }
		         }
		      }

		      p_46068_.add(Pair.of(p_46069_, p_46070_));
		   }

	
	@Override
	   public void explode() {
	      this.level.gameEvent(this.getExploder(), GameEvent.EXPLODE, new Vec3(this.getPosition().x, this.getPosition().y, this.getPosition().z));
	      Set<BlockPos> set = Sets.newHashSet();
	      int i = 16;

	      for(int j = 0; j < 16; ++j) {
	         for(int k = 0; k < 16; ++k) {
	            for(int l = 0; l < 16; ++l) {
	               if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
	                  double d0 = (double)((float)j / 15.0F * 2.0F - 1.0F);
	                  double d1 = (double)((float)k / 15.0F * 2.0F - 1.0F);
	                  double d2 = (double)((float)l / 15.0F * 2.0F - 1.0F);
	                  double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
	                  d0 /= d3;
	                  d1 /= d3;
	                  d2 /= d3;
	                  float f = this.radius * (0.7F + this.level.random.nextFloat() * 0.6F);
	                  double d4 = this.getPosition().x;
	                  double d6 = this.getPosition().y;
	                  double d8 = this.getPosition().z;

	                  for(float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
	                     BlockPos blockpos = new BlockPos(d4, d6, d8);
	                     BlockState blockstate = this.level.getBlockState(blockpos);
	                     FluidState fluidstate = this.level.getFluidState(blockpos);
	                     if (!this.level.isInWorldBounds(blockpos)) {
	                        break;
	                     }

	                     Optional<Float> optional = this.damageCalculator.getBlockExplosionResistance(this, this.level, blockpos, blockstate, fluidstate);
	                     if (optional.isPresent()) {
	                        f -= (optional.get() + 0.3F) * 0.3F;
	                     }

	                     if (f > 0.0F && this.damageCalculator.shouldBlockExplode(this, this.level, blockpos, blockstate, f)) {
	                        set.add(blockpos);
	                     }

	                     d4 += d0 * (double)0.3F;
	                     d6 += d1 * (double)0.3F;
	                     d8 += d2 * (double)0.3F;
	                  }
	               }
	            }
	         }
	      }

	      this.getToBlow().addAll(set);
	      float f2 = this.radius * 2.0F;
	      int k1 = Mth.floor(this.getPosition().x - (double)f2 - 1.0D);
	      int l1 = Mth.floor(this.getPosition().x + (double)f2 + 1.0D);
	      int i2 = Mth.floor(this.getPosition().y - (double)f2 - 1.0D);
	      int i1 = Mth.floor(this.getPosition().y + (double)f2 + 1.0D);
	      int j2 = Mth.floor(this.getPosition().z - (double)f2 - 1.0D);
	      int j1 = Mth.floor(this.getPosition().z + (double)f2 + 1.0D);
	      List<Entity> list = this.level.getEntities(this.getExploder(), new AABB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
	      net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.level, this, list, f2);
	      Vec3 vec3 = new Vec3(this.getPosition().x, this.getPosition().y, this.getPosition().z);

	      for(int k2 = 0; k2 < list.size(); ++k2) {
	         Entity entity = list.get(k2);
	         if (!entity.ignoreExplosion()) {
	            double d12 = Math.sqrt(entity.distanceToSqr(vec3)) / (double)f2;
	            if (d12 <= 1.0D) {
	               double d5 = entity.getX() - this.getPosition().x;
	               double d7 = (entity instanceof PrimedTnt ? entity.getY() : entity.getEyeY()) - this.getPosition().y;
	               double d9 = entity.getZ() - this.getPosition().z;
	               double d13 = Math.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
	               if (d13 != 0.0D) {
	                  d5 /= d13;
	                  d7 /= d13;
	                  d9 /= d13;
	                  double d14 = (double)getSeenPercent(vec3, entity);
	                  double d10 = (1.0D - d12) * d14;
	                  if (this.damage > 0 && this.canHarm(entity)) {
	                	  entity.hurt(this.getDamageSource(), this.damage);  
	                  }
	                  double d11 = d10;
	                  if (entity instanceof LivingEntity) {
	                     d11 = ProtectionEnchantment.getExplosionKnockbackAfterDampener((LivingEntity)entity, d10);
	                  }

	                  entity.setDeltaMovement(entity.getDeltaMovement().add(d5 * d11, d7 * d11, d9 * d11));
	                  if (entity instanceof Player) {
	                     Player player = (Player)entity;
	                     if (!player.isSpectator() && (!player.isCreative() || !player.getAbilities().flying)) {
	                        this.getHitPlayers().put(player, new Vec3(d5 * d10, d7 * d10, d9 * d10));
	                     }
	                  }
	               }
	            }
	         }
	      }

	   }

}
