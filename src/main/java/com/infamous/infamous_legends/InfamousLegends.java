package com.infamous.infamous_legends;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("infamous_legends")
@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class InfamousLegends {

	public static final String MOD_ID = "infamous_legends";

	public InfamousLegends() {
			
			IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
			
			bus.addListener(this::addAttributes);

			//EntityTypeInit.ENTITY_TYPES.register(bus);

			MinecraftForge.EVENT_BUS.register(this);

		}

	private void addAttributes(final EntityAttributeCreationEvent event) {
	        //event.put(EntityTypeInit.MOB.get(), Mob.createAttributes().build());
	}
}