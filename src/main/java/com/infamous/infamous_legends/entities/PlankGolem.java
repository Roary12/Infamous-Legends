package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.ai.goals.ApproachTargetGoal;
import com.infamous.infamous_legends.ai.goals.LookAtTargetGoal;
import com.infamous.infamous_legends.ai.goals.PlankGolemShootAttackGoal;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.GolemRandomStrollInVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class PlankGolem extends AbstractGolem {

	private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(PlankGolem.class, EntityDataSerializers.INT);
	   
	public AnimationState shootAnimationState = new AnimationState();
	public int shootAnimationTick;
	public final int shootAnimationLength = 35;
	public final int shootAnimationActionPoint = 18;
	
	public PlankGolem(EntityType<? extends PlankGolem> type, Level level) {
		super(type, level);		
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new PlankGolemShootAttackGoal(this));
		this.goalSelector.addGoal(1, new LookAtTargetGoal(this));
		this.goalSelector.addGoal(2, new ApproachTargetGoal(this, 20, 1.2, true));
		this.goalSelector.addGoal(3, new MoveBackToVillageGoal(this, 0.6D, false));
		this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(3,
				new NearestAttackableTargetGoal<>(this, Mob.class, 10, false, false, (p_28879_) -> {
					return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper);
				}));
	}
	
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
			MobSpawnType pReason, SpawnGroupData pSpawnData, CompoundTag pDataTag) {
		this.setType(PlankGolem.Type.byId(this.random.nextInt(PlankGolem.Type.values().length)));
		return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
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
	public boolean canAttack(LivingEntity target) {
		if (target instanceof Player && this.getTeam() == null && target.getTeam() == null) {
			return false;
		} else {
			return super.canAttack(target);
		}
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.shootAnimationTick = this.shootAnimationLength;
			this.shootAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 25.0D);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.shootAnimationTick > 0) {
			this.shootAnimationTick--;
		}
		
		if (this.shootAnimationTick <= 0 && this.shootAnimationState.isStarted()) {
			this.shootAnimationState.stop();
		}
	}
	
	protected SoundEvent getHurtSound(DamageSource p_35498_) {
		return SoundEvents.WOOD_HIT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.WOOD_BREAK;
	}
	   
	protected int decreaseAirSupply(int p_28882_) {
		return p_28882_;
	}
	
	public static enum Type {
	      OAK(Blocks.OAK_PLANKS, "oak", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/oak_plank_golem.png"), null),
	      SPRUCE(Blocks.SPRUCE_PLANKS, "spruce", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/spruce_plank_golem.png"), null),
	      BIRCH(Blocks.BIRCH_PLANKS, "birch", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/birch_plank_golem.png"), null),
	      JUNGLE(Blocks.JUNGLE_PLANKS, "jungle", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/jungle_plank_golem.png"), null),
	      ACACIA(Blocks.ACACIA_PLANKS, "acacia", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/acacia_plank_golem.png"), null),
	      DARK_OAK(Blocks.DARK_OAK_PLANKS, "dark_oak", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/dark_oak_plank_golem.png"), null),
	      MANGROVE(Blocks.MANGROVE_PLANKS, "mangrove", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/mangrove_plank_golem.png"), null),
	      WARPED(Blocks.WARPED_PLANKS, "warped", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/warped_plank_golem.png"), new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/nether_plank_golem_eyes.png")),
	      CRIMSON(Blocks.CRIMSON_PLANKS, "crimson", new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/crimson_plank_golem.png"), new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/nether_plank_golem_eyes.png"));

	      private final String name;
	      private final Block planks;
	      private final ResourceLocation textureLocation;
	      private final ResourceLocation glowTextureLocation;

	      private Type(Block pPlanks, String pName, ResourceLocation textureLocation, ResourceLocation glowTextureLocation) {
	         this.name = pName;
	         this.planks = pPlanks;
	         this.textureLocation = textureLocation;
	         this.glowTextureLocation = glowTextureLocation;
	      }

	      public String getName() {
	         return this.name;
	      }

	      public Block getPlanks() {
	         return this.planks;
	      }
	      
			public ResourceLocation getTextureLocation() {
				return this.textureLocation;
			}

			public ResourceLocation getGlowTextureLocation() {
				return this.glowTextureLocation;
			}

	      public String toString() {
	         return this.name;
	      }

	      /**
	       * Get a boat type by its enum ordinal
	       */
	      public static PlankGolem.Type byId(int pId) {
	    	  PlankGolem.Type[] aboat$type = values();
	         if (pId < 0 || pId >= aboat$type.length) {
	            pId = 0;
	         }

	         return aboat$type[pId];
	      }

	      public static PlankGolem.Type byName(String pName) {
	    	  PlankGolem.Type[] aboat$type = values();

	         for(int i = 0; i < aboat$type.length; ++i) {
	            if (aboat$type[i].getName().equals(pName)) {
	               return aboat$type[i];
	            }
	         }

	         return aboat$type[0];
	      }
	   }
}
