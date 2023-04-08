package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.ai.brains.sensors.CustomNearestLivingEntitySensor;
import com.infamous.infamous_legends.ai.brains.sensors.CustomPlayerSensor;
import com.infamous.infamous_legends.ai.brains.sensors.LegendsPiglinSpecificSensor;
import com.infamous.infamous_legends.ai.brains.sensors.SporeMedicSpecificSensor;
import com.infamous.infamous_legends.entities.SporeMedic;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SensorTypeInit {
	public static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, InfamousLegends.MOD_ID);
	
	public static final RegistryObject<SensorType<CustomPlayerSensor>> CUSTOM_NEAREST_PLAYERS = SENSOR_TYPES.register("custom_nearest_players",
	        () -> new SensorType<>(CustomPlayerSensor::new));
	
	public static final RegistryObject<SensorType<CustomNearestLivingEntitySensor<LivingEntity>>> CUSTOM_NEAREST_LIVING_ENTITIES = SENSOR_TYPES.register("custom_nearest_living_entities",
	        () -> new SensorType<>(CustomNearestLivingEntitySensor::new));
	
	public static final RegistryObject<SensorType<SporeMedicSpecificSensor>> SPORE_MEDIC_SPECIFIC_SENSOR = SENSOR_TYPES.register("spore_medic_specific_sensor",
	        () -> new SensorType<>(SporeMedicSpecificSensor::new));
	
	public static final RegistryObject<SensorType<LegendsPiglinSpecificSensor>> LEGENDS_PIGLIN_SPECIFIC_SENSOR = SENSOR_TYPES.register("legends_piglin_specific_sensor",
	        () -> new SensorType<>(LegendsPiglinSpecificSensor::new));
}

