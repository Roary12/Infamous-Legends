package com.infamous.infamous_legends.init;

import java.util.Optional;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MemoryModuleTypeInit {
	   public static final DeferredRegister<MemoryModuleType<?>> MEMORY_MODULE_TYPES = DeferredRegister.create(ForgeRegistries.MEMORY_MODULE_TYPES, InfamousLegends.MOD_ID);

	    public static final RegistryObject<MemoryModuleType<LivingEntity>> HEAL_TARGET = MEMORY_MODULE_TYPES.register("heal_target",
	            () -> new MemoryModuleType<>(Optional.empty()));
}

