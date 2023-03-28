package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
			InfamousLegends.MOD_ID);

	// MOBS
	
	//public static final RegistryObject<EntityType<PlaceholderMob>> MOB = ENTITY_TYPES.register(
	//		"mob", () -> EntityType.Builder.<PlaceholderMob>of(PlaceholderMob::new, MobCategory.MISC).sized(1.5F, 1.5F)
	//				.fireImmune().build(new ResourceLocation(InfamousLegends.MOD_ID, "mob").toString()));

}
