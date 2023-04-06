package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.ai.brains.sensors.CustomPlayerSensor;

import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SensorTypeInit {
	public static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, InfamousLegends.MOD_ID);
	
	public static final RegistryObject<SensorType<CustomPlayerSensor>> CUSTOM_NEAREST_PLAYERS = SENSOR_TYPES.register("custom_nearest_players",
	        () -> new SensorType<>(CustomPlayerSensor::new));
}

