package com.infamous.infamous_legends.itemgroups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class InfamousLegendsBlocksItemGroup extends CreativeModeTab {
	
	public static final InfamousLegendsBlocksItemGroup INFAMOUS_LEGENDS_BLOCKS = new InfamousLegendsBlocksItemGroup(CreativeModeTab.TABS.length, "infamous_legends_blocks");

	public InfamousLegendsBlocksItemGroup(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Items.SPAWNER);
	}

}
