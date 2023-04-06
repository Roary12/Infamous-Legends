package com.infamous.infamous_legends.itemgroups;

import com.infamous.infamous_legends.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class InfamousLegendsMobsItemGroup extends CreativeModeTab {
	
	public static final InfamousLegendsMobsItemGroup INFAMOUS_LEGENDS_MOBS = new InfamousLegendsMobsItemGroup(CreativeModeTab.TABS.length, "infamous_legends_mobs");

	public InfamousLegendsMobsItemGroup(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.MACE_RUNT_SPAWN_EGG.get());
	}

}
