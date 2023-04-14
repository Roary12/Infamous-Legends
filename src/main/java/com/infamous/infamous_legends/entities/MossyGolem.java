package com.infamous.infamous_legends.entities;

import javax.annotation.Nullable;

import com.infamous.infamous_legends.ai.goals.MossyGolemApproachHealTargetGoal;
import com.infamous.infamous_legends.ai.goals.MossyGolemFindHealTargetGoal;
import com.infamous.infamous_legends.ai.goals.MossyGolemHealAlliesGoal;
import com.infamous.infamous_legends.ai.goals.MossyGolemLookAtHealTargetGoal;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.utils.PositionUtils;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.GolemRandomStrollInVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

public class MossyGolem extends AbstractGolem {

	@Nullable
	private LivingEntity healTarget;
	   
	public boolean shooting;
	
	public MossyGolemHealingZone subEntity1;
	public MossyGolemHealingZone subEntity2;
	
	public MossyGolem(EntityType<? extends MossyGolem> type, Level level) {
		super(type, level);		
		this.subEntity1 = new MossyGolemHealingZone(this);
		this.subEntity2 = new MossyGolemHealingZone(this);
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MossyGolemFindHealTargetGoal(this));
		this.goalSelector.addGoal(1, new MossyGolemHealAlliesGoal(this));
		this.goalSelector.addGoal(2, new MossyGolemLookAtHealTargetGoal(this));
		this.goalSelector.addGoal(3, new MossyGolemApproachHealTargetGoal(this, 3, 1.3));
		this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, LivingEntity.class, 5, 1.3, 1.3, (entity) -> {
			return entity instanceof Enemy;
		}));
		this.goalSelector.addGoal(5, new MoveBackToVillageGoal(this, 0.6D, false));
		this.goalSelector.addGoal(6, new GolemRandomStrollInVillageGoal(this, 0.6D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}
	
	public void setHealTarget(@Nullable LivingEntity healTarget) {
		this.healTarget = healTarget;
	}

	@Nullable
	public LivingEntity getHealTarget() {
		return this.healTarget;
	}
	
	public void handleEntityEvent(byte p_219360_) {
		if (p_219360_ == 4) {
			this.shooting = true;
		} else if (p_219360_ == 11) {
			this.shooting = false;
		} else {
			super.handleEntityEvent(p_219360_);
		}

	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.25D).add(Attributes.FOLLOW_RANGE, 25.0D);
	}
	
	@Override
	public void baseTick() {
		super.baseTick();
		
		if (this.shooting && this.level.isClientSide) {
			Vec3 shootFromPos1 = PositionUtils.getOffsetPos(this, 0.6, 1.4, -0.6, this.yBodyRot + (this.tickCount * (-175 / 19.99F)));
			Vec3 shootFromPos2 = PositionUtils.getOffsetPos(this, -0.6, 1.4, 0.6, this.yBodyRot + (this.tickCount * (-175 / 19.99F)));
			
			Vec3 shootMotion1 = PositionUtils.getOffsetMotion(this, 0.25, 0.1, 0, this.yBodyRot + (this.tickCount * (-175 / 19.99F) - 45));
			Vec3 shootMotion2 = PositionUtils.getOffsetMotion(this, -0.25, 0.1, -0, this.yBodyRot + (this.tickCount * (-175 / 19.99F) - 45));
			
			this.level.addParticle(ParticleTypeInit.WATER.get(), shootFromPos1.x, shootFromPos1.y, shootFromPos1.z, shootMotion1.x, shootMotion1.y, shootMotion1.z);
			this.level.addParticle(ParticleTypeInit.WATER.get(), shootFromPos2.x, shootFromPos2.y, shootFromPos2.z, shootMotion2.x, shootMotion2.y, shootMotion2.z);
		}
		
		this.updateParts();
	}
	
	protected void updateParts() {
		Vec3 partPos1 = PositionUtils.getOffsetPos(this, 1.0, 0, -2, this.yBodyRot + (this.tickCount * (-175 / 19.99F)));
		this.movePart(this.subEntity1, partPos1.x, partPos1.y, partPos1.z);
		this.subEntity1.tickHealing();
		
		Vec3 partPos2 = PositionUtils.getOffsetPos(this, -1.0, 0, 2, this.yBodyRot + (this.tickCount * (-175 / 19.99F)));
		this.movePart(this.subEntity2, partPos2.x, partPos2.y, partPos2.z);
		this.subEntity2.tickHealing();
	}
	
    protected void movePart(MossyGolemHealingZone part, double dX, double dY, double dZ)
    {
    	Vec3 lastPos = new Vec3(part.getX(), part.getY(), part.getZ());

        part.setPos(dX, dY, dZ);

        part.xo = lastPos.x;
        part.yo = lastPos.y;
        part.zo = lastPos.z;
        part.xOld = lastPos.x;
        part.yOld = lastPos.y;
        part.zOld = lastPos.z;
    }
    
    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {    
        return new PartEntity<?>[]{this.subEntity1, this.subEntity2};
    }
    
    @Override
    public void setId(int p_145769_1_) {
        super.setId(p_145769_1_);
        this.subEntity1.setId(p_145769_1_ + 1);
        this.subEntity2.setId(p_145769_1_ + 2);
    }

	protected SoundEvent getHurtSound(DamageSource p_35498_) {
		return SoundEvents.MOSS_HIT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.MOSS_BREAK;
	}
	   
	protected int decreaseAirSupply(int p_28882_) {
		return p_28882_;
	}
}
