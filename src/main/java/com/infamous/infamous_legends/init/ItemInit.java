package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			InfamousLegends.MOD_ID);	
	
	// SPAWN EGGS
	
	//public static final RegistryObject<Item> MOB_SPAWN_EGG = ITEMS.register("mob_spawn_egg",
	//		() -> new ForgeSpawnEggItem(EntityTypeInit.MOB, 0xffffff, 0xffffff,
	//				new Item.Properties().tab(InfamousLegendsItemGroup.INFAMOUS_LEGENDS)));


}
