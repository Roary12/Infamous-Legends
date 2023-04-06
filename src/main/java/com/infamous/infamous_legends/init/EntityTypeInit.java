package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.BigFungusThrower;
import com.infamous.infamous_legends.entities.ExplosiveFungus;
import com.infamous.infamous_legends.entities.PiglinBomb;
import com.infamous.infamous_legends.entities.PiglinBruiser;
import com.infamous.infamous_legends.entities.PiglinEngineer;
import com.infamous.infamous_legends.entities.BlazeRunt;
import com.infamous.infamous_legends.entities.MaceRunt;
import com.infamous.infamous_legends.entities.ThrownBlazeRod;
import com.infamous.infamous_legends.entities.WarpedBomber;

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

	public static final RegistryObject<EntityType<MaceRunt>> MACE_RUNT = ENTITY_TYPES.register("mace_runt",
			() -> EntityType.Builder.<MaceRunt>of(MaceRunt::new, MobCategory.MONSTER).sized(0.6F, 1.4F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "mace_runt").toString()));
	
	public static final RegistryObject<EntityType<BlazeRunt>> BLAZE_RUNT = ENTITY_TYPES.register("blaze_runt",
			() -> EntityType.Builder.<BlazeRunt>of(BlazeRunt::new, MobCategory.MONSTER).sized(0.6F, 1.6F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "blaze_runt").toString()));
	
	public static final RegistryObject<EntityType<PiglinBruiser>> PIGLIN_BRUISER = ENTITY_TYPES.register("piglin_bruiser",
			() -> EntityType.Builder.<PiglinBruiser>of(PiglinBruiser::new, MobCategory.MONSTER).sized(0.7F, 2.1F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "piglin_bruiser").toString()));
	
	public static final RegistryObject<EntityType<PiglinEngineer>> PIGLIN_ENGINEER = ENTITY_TYPES.register("piglin_engineer",
			() -> EntityType.Builder.<PiglinEngineer>of(PiglinEngineer::new, MobCategory.MONSTER).sized(0.6F, 1.4F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "piglin_engineer").toString()));
	
	public static final RegistryObject<EntityType<WarpedBomber>> WARPED_BOMBER = ENTITY_TYPES.register("warped_bomber",
			() -> EntityType.Builder.<WarpedBomber>of(WarpedBomber::new, MobCategory.MONSTER).sized(0.7F, 2.3F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "warped_bomber").toString()));
	
	public static final RegistryObject<EntityType<BigFungusThrower>> BIG_FUNGUS_THROWER = ENTITY_TYPES.register("big_fungus_thrower",
			() -> EntityType.Builder.<BigFungusThrower>of(BigFungusThrower::new, MobCategory.MONSTER).sized(0.8F, 2.4F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "warped_bomber").toString()));
	
	// PROJECTILES

	public static final RegistryObject<EntityType<ThrownBlazeRod>> THROWN_BLAZE_ROD = ENTITY_TYPES.register("thrown_blaze_rod",
			() -> EntityType.Builder.<ThrownBlazeRod>of(ThrownBlazeRod::new, MobCategory.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "thrown_blaze_rod").toString()));

	public static final RegistryObject<EntityType<PiglinBomb>> PIGLIN_BOMB = ENTITY_TYPES.register("piglin_bomb",
			() -> EntityType.Builder.<PiglinBomb>of(PiglinBomb::new, MobCategory.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "piglin_bomb").toString()));
	
	public static final RegistryObject<EntityType<ExplosiveFungus>> EXPLOSIVE_FUNGUS = ENTITY_TYPES.register("explosive_fungus",
			() -> EntityType.Builder.<ExplosiveFungus>of(ExplosiveFungus::new, MobCategory.MISC).sized(0.5F, 0.5F)
					.build(new ResourceLocation(InfamousLegends.MOD_ID, "explosive_fungus").toString()));
}
