package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.itemgroups.InfamousLegendsItemsItemGroup;
import com.infamous.infamous_legends.itemgroups.InfamousLegendsMobsItemGroup;
import com.infamous.infamous_legends.items.ExplosiveFungusItem;
import com.infamous.infamous_legends.items.PiglinBombItem;
import com.infamous.infamous_legends.items.PiglinMaceItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
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
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_RUNT, 0x4b3f34, 0xf9f3a4,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGLIN_GRUNTER_SPAWN_EGG = ITEMS.register("piglin_grunter_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_GRUNTER, 0x995f40, 0xffd528,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGLIN_BRUISER_SPAWN_EGG = ITEMS.register("piglin_bruiser_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_BRUISER, 0x995f40, 0x3f303b,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGLIN_ENGINEER_SPAWN_EGG = ITEMS.register("piglin_engineer_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_ENGINEER, 0x4d494d, 0xffd83d,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> WARPED_BOMBER_SPAWN_EGG = ITEMS.register("warped_bomber_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.WARPED_BOMBER, 0x986c7c, 0x119b85,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	// WEAPONS
	
	public static final RegistryObject<Item> PIGLIN_MACE = ITEMS.register("piglin_mace",
			() -> new PiglinMaceItem(7, -3.15F, Tiers.NETHERITE,
					new Item.Properties().tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> PIGLIN_SAW = ITEMS.register("piglin_saw",
			() -> new SwordItem(Tiers.NETHERITE, 6, -3.0F,
					new Item.Properties().tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> PIGLIN_BOMB = ITEMS.register("piglin_bomb",
			() -> new PiglinBombItem(new Item.Properties().stacksTo(16).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));
	
	public static final RegistryObject<Item> EXPLOSIVE_FUNGUS = ITEMS.register("explosive_fungus",
			() -> new ExplosiveFungusItem(new Item.Properties().stacksTo(16).tab(InfamousLegendsItemsItemGroup.INFAMOUS_LEGENDS_ITEMS)));

}
