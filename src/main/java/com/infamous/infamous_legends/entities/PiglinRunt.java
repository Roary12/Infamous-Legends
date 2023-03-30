package com.infamous.infamous_legends.entities;

import com.infamous.infamous_legends.init.ItemInit;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
				.add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.ATTACK_DAMAGE, 7.0D);
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource p_219209_, DifficultyInstance p_219210_) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.PIGLIN_MACE.get()));
	}
	   
}
