package com.infamous.infamous_legends;

import com.infamous.infamous_legends.entities.PiglinBruiser;
import com.infamous.infamous_legends.entities.PiglinEngineer;
import com.infamous.infamous_legends.entities.PiglinGrunter;
import com.infamous.infamous_legends.entities.PiglinRunt;
import com.infamous.infamous_legends.entities.WarpedBomber;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
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
		
			EntityTypeInit.ENTITY_TYPES.register(bus);
			ItemInit.ITEMS.register(bus);
			
			bus.addListener(this::commonSetup);
			
			MinecraftForge.EVENT_BUS.register(this);

		}

	private void addAttributes(final EntityAttributeCreationEvent event) {
	        event.put(EntityTypeInit.PIGLIN_RUNT.get(), PiglinRunt.createAttributes().build());
	        event.put(EntityTypeInit.PIGLIN_GRUNTER.get(), PiglinGrunter.createAttributes().build());
	        event.put(EntityTypeInit.PIGLIN_BRUISER.get(), PiglinBruiser.createAttributes().build());
	        event.put(EntityTypeInit.PIGLIN_ENGINEER.get(), PiglinEngineer.createAttributes().build());
	        event.put(EntityTypeInit.WARPED_BOMBER.get(), WarpedBomber.createAttributes().build());
	}
	
    public void commonSetup(final FMLCommonSetupEvent event) {    
    	Messages.register();
    }
}