package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PiglinRunt;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypeInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister
			.create(ForgeRegistries.ENTITY_TYPES, InfamousLegends.MOD_ID);

	// MOBS

	public static final RegistryObject<EntityType<PiglinRunt>> PIGLIN_RUNT = ENTITY_TYPES.register("piglin_runt",
			() -> EntityType.Builder.<PiglinRunt>of(PiglinRunt::new, MobCategory.MISC).sized(0.6F, 1.3F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "piglin_runt").toString()));

}
