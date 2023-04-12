package com.infamous.infamous_legends;

import com.infamous.infamous_legends.entities.BigFungusThrower;
import com.infamous.infamous_legends.entities.BlazeRunt;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.entities.MaceRunt;
import com.infamous.infamous_legends.entities.PiglinBruiser;
import com.infamous.infamous_legends.entities.PiglinEngineer;
import com.infamous.infamous_legends.entities.Pigmadillo;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.entities.WarBoar;
import com.infamous.infamous_legends.entities.WarpedBomber;
import com.infamous.infamous_legends.init.ActivityInit;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import com.infamous.infamous_legends.init.ParticleTypeInit;
import com.infamous.infamous_legends.init.SensorTypeInit;
import com.infamous.infamous_legends.network.Messages;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("infamous_legends")
@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class InfamousLegends {

	public static final String MOD_ID = "infamous_legends";

	public InfamousLegends() {
			
			IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
			
			bus.addListener(this::addAttributes);
		
			ActivityInit.ACTIVITIES.register(bus);
			EntityTypeInit.ENTITY_TYPES.register(bus);
			ItemInit.ITEMS.register(bus);
			ParticleTypeInit.PARTICLE_TYPES.register(bus);
			MemoryModuleTypeInit.MEMORY_MODULE_TYPES.register(bus);
			SensorTypeInit.SENSOR_TYPES.register(bus);
			
			bus.addListener(this::commonSetup);
			
			MinecraftForge.EVENT_BUS.register(this);

		}

	private void addAttributes(final EntityAttributeCreationEvent event) {
	        event.put(EntityTypeInit.MACE_RUNT.get(), MaceRunt.createAttributes().build());
	        event.put(EntityTypeInit.BLAZE_RUNT.get(), BlazeRunt.createAttributes().build());
	        event.put(EntityTypeInit.SPORE_MEDIC.get(), SporeMedic.createAttributes().build());
	        event.put(EntityTypeInit.PIGLIN_BRUISER.get(), PiglinBruiser.createAttributes().build());
	        event.put(EntityTypeInit.WAR_BOAR.get(), WarBoar.createAttributes().build());
	        event.put(EntityTypeInit.PIGLIN_ENGINEER.get(), PiglinEngineer.createAttributes().build());
	        event.put(EntityTypeInit.WARPED_BOMBER.get(), WarpedBomber.createAttributes().build());
	        event.put(EntityTypeInit.BIG_FUNGUS_THROWER.get(), BigFungusThrower.createAttributes().build());
	        event.put(EntityTypeInit.LAVA_LAUNCHER.get(), LavaLauncher.createAttributes().build());
	        event.put(EntityTypeInit.PIGMADILLO.get(), Pigmadillo.createAttributes().build());
	        event.put(EntityTypeInit.PORTAL_GUARD.get(), PortalGuard.createAttributes().build());
	}
	
    public void commonSetup(final FMLCommonSetupEvent event) {    
    	Messages.register();
    }
}