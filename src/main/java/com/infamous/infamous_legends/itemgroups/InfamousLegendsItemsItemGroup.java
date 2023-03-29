package com.infamous.infamous_legends.itemgroups;

import com.infamous.infamous_legends.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class InfamousLegendsItemsItemGroup extends CreativeModeTab {
	
	public static final InfamousLegendsItemsItemGroup INFAMOUS_LEGENDS_ITEMS = new InfamousLegendsItemsItemGroup(CreativeModeTab.TABS.length, "infamous_legends_items");

	public InfamousLegendsItemsItemGroup(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.PIGLIN_MACE.get());
	}

}
