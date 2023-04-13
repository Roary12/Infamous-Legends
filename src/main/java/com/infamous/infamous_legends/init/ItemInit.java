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
	
	public static final RegistryObject<Item> MACE_RUNT_SPAWN_EGG = ITEMS.register("mace_runt_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.MACE_RUNT, 0x4b3f34, 0xf9f3a4,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> BLAZE_RUNT_SPAWN_EGG = ITEMS.register("blaze_runt_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.BLAZE_RUNT, 0x995f40, 0xffd528,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> SPORE_MEDIC_SPAWN_EGG = ITEMS.register("spore_medic_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.SPORE_MEDIC, 0x995f40, 0xa42429,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGLIN_BRUISER_SPAWN_EGG = ITEMS.register("piglin_bruiser_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_BRUISER, 0x995f40, 0x3f303b,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> WAR_BOAR_SPAWN_EGG = ITEMS.register("war_boar_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.WAR_BOAR, 0xbb725b, 0xf5c650,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGLIN_ENGINEER_SPAWN_EGG = ITEMS.register("piglin_engineer_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGLIN_ENGINEER, 0x4d494d, 0xffd83d,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> WARPED_BOMBER_SPAWN_EGG = ITEMS.register("warped_bomber_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.WARPED_BOMBER, 0x986c7c, 0x119b85,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> BIG_FUNGUS_THROWER_SPAWN_EGG = ITEMS.register("big_fungus_thrower_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.BIG_FUNGUS_THROWER, 0xe5d3c7, 0x119b85,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> LAVA_LAUNCHER_SPAWN_EGG = ITEMS.register("lava_launcher_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.LAVA_LAUNCHER, 0xe5d3c7, 0xa96f7f,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PIGMADILLO_SPAWN_EGG = ITEMS.register("pigmadillo_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PIGMADILLO, 0xbc768e, 0x5c2821,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PORTAL_GUARD_SPAWN_EGG = ITEMS.register("portal_guard_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PORTAL_GUARD, 0xffd83d, 0x584c2f,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> COBBLESTONE_GOLEM_SPAWN_EGG = ITEMS.register("cobblestone_golem_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.COBBLESTONE_GOLEM, 0x8b8985, 0x5f5f5c,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> PLANK_GOLEM_SPAWN_EGG = ITEMS.register("plank_golem_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.PLANK_GOLEM, 0xb8945f, 0x453f3b,
					new Item.Properties().tab(InfamousLegendsMobsItemGroup.INFAMOUS_LEGENDS_MOBS)));
	
	public static final RegistryObject<Item> GRINDSTONE_GOLEM_SPAWN_EGG = ITEMS.register("grindstone_golem_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypeInit.GRINDSTONE_GOLEM, 0x2f4a4b, 0x31c5b8,
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
