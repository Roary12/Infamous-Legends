package com.infamous.infamous_legends.events;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.particles.DustParticle;
import com.infamous.infamous_legends.particles.SparkParticle;
import com.infamous.infamous_legends.particles.SporeCloudParticle;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ApplyParticlesEvent {

	@SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
    	event.register(ParticleTypeInit.SPARK.get(),
                SparkParticle.Provider::new);
    	event.register(ParticleTypeInit.DUST.get(),
                DustParticle.Provider::new);
    	event.register(ParticleTypeInit.SPORE_CLOUD.get(),
                SporeCloudParticle.Provider::new);
    }
}