package com.infamous.infamous_legends.init;

import java.util.function.Function;

import com.infamous.infamous_legends.InfamousLegends;
import com.mojang.serialization.Codec;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleTypeInit {
	
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, InfamousLegends.MOD_ID);

    public static final RegistryObject<SimpleParticleType> SPARK =
            PARTICLE_TYPES.register("spark", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> DUST =
            PARTICLE_TYPES.register("dust", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SPORE_CLOUD =
            PARTICLE_TYPES.register("spore_cloud", () -> new SimpleParticleType(true));
	
	   private static <T extends ParticleOptions> RegistryObject<ParticleType<T>> registerAdvancedParticle(String p_235906_, boolean p_235907_, ParticleOptions.Deserializer<T> p_235908_, final Function<ParticleType<T>, Codec<T>> p_235909_) {
		      return PARTICLE_TYPES.register(p_235906_, () -> new ParticleType<T>(p_235907_, p_235908_) {
		         public Codec<T> codec() {
		            return p_235909_.apply(this);
		         }
		      });
		   }
}
