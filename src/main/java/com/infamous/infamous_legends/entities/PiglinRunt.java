package com.infamous.infamous_legends.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.level.Level;

public class PiglinRunt extends PiglinBrute {

	public PiglinRunt(EntityType<? extends PiglinRunt> type, Level level) {
		super(type, level);
	}
	
	@Override
	public float getVoicePitch() {
		return super.getVoicePitch() * 1.5F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.4F).add(Attributes.ATTACK_DAMAGE, 7.0D);
	}
	   
}
