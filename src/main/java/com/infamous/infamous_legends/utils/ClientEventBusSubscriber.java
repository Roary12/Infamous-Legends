package com.infamous.infamous_legends.utils;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PiglinRuntModel;
import com.infamous.infamous_legends.models.ThrownBlazeRodModel;
import com.infamous.infamous_legends.renderers.PiglinRuntRenderer;
import com.infamous.infamous_legends.renderers.ThrownBlazeRodRenderer;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_RUNT, PiglinRuntModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.THROWN_BLAZE_ROD, ThrownBlazeRodModel::createBodyLayer);
    }
	
	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityTypeInit.PIGLIN_RUNT.get(), PiglinRuntRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.THROWN_BLAZE_ROD.get(), ThrownBlazeRodRenderer::new);
	}
	
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		  event.enqueueWork(() ->
		  {
		    ItemProperties.register(Items.BLAZE_ROD, 
		      new ResourceLocation("throwing"), (stack, level, living, id) -> {
		        return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
		      });
		  });
		}
}