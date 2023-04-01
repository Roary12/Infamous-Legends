package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.itemgroups.InfamousLegendsItemsItemGroup;
import com.infamous.infamous_legends.itemgroups.InfamousLegendsMobsItemGroup;
import com.infamous.infamous_legends.items.PiglinMaceItem;
import com.infamous.infamous_legends.items.ThrowableBlazeRodItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			InfamousLegends.MOD_ID);	
	
	// SPAWN EGGS
	
	public static final RegistryObject<Item> PIGLIN_RUNT_SPAWN_EGG = ITEMS.register("piglin_runt_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_RUNT, 0x4b3f34, 0xe8a074,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	// WEAPONS
	
	public static final RegistryObject<Item> PIGLIN_MACE = ITEMS.register("piglin_mace",
			() -> new PiglinMaceItem(7, -3.15F, Tiers.NETHERITE,
					new Item.Properties().tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> THROWABLE_BLAZE_ROD = ITEMS.register("throwable_blaze_rod",
			() -> new ThrowableBlazeRodItem(
					new Item.Properties().durability(200).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));

}
