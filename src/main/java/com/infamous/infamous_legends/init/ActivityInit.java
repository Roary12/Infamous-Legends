package com.infamous.infamous_legends.init;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.world.entity.schedule.Activity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ActivityInit {
	
	public static final DeferredRegister<Activity> ACTIVITIES = DeferredRegister.create(ForgeRegistries.ACTIVITIES, InfamousLegends.MOD_ID);
	
	public static final RegistryObject<Activity> HEAL_ALLY = ACTIVITIES.register("heal_ally", () -> new Activity("heal_ally"));
}

