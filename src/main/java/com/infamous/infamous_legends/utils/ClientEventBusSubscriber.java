package com.infamous.infamous_legends.utils;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PortalGuardWreckingBall;
import com.infamous.infamous_legends.init.EntityTypeInit;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.BigFungusThrowerModel;
import com.infamous.infamous_legends.models.BlazeRuntModel;
import com.infamous.infamous_legends.models.ExplosiveFungusModel;
import com.infamous.infamous_legends.models.MaceRuntModel;
import com.infamous.infamous_legends.models.PiglinBombModel;
import com.infamous.infamous_legends.models.PiglinBruiserModel;
import com.infamous.infamous_legends.models.PiglinEngineerModel;
import com.infamous.infamous_legends.models.PigmadilloModel;
import com.infamous.infamous_legends.models.PortalGuardModel;
import com.infamous.infamous_legends.models.PortalGuardWreckingBallModel;
import com.infamous.infamous_legends.models.SporeMedicModel;
import com.infamous.infamous_legends.models.ThrownBlazeRodModel;
import com.infamous.infamous_legends.models.WarpedBomberModel;
import com.infamous.infamous_legends.renderers.BigFungusThrowerRenderer;
import com.infamous.infamous_legends.renderers.BlazeRuntRenderer;
import com.infamous.infamous_legends.renderers.ExplosiveFungusRenderer;
import com.infamous.infamous_legends.renderers.MaceRuntRenderer;
import com.infamous.infamous_legends.renderers.PiglinBombRenderer;
import com.infamous.infamous_legends.renderers.PiglinBruiserRenderer;
import com.infamous.infamous_legends.renderers.PiglinEngineerRenderer;
import com.infamous.infamous_legends.renderers.PigmadilloRenderer;
import com.infamous.infamous_legends.renderers.PortalGuardRenderer;
import com.infamous.infamous_legends.renderers.PortalGuardWreckingBallRenderer;
import com.infamous.infamous_legends.renderers.SporeMedicRenderer;
import com.infamous.infamous_legends.renderers.ThrownBlazeRodRenderer;
import com.infamous.infamous_legends.renderers.WarpedBomberRenderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
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
        event.registerLayerDefinition(ModelLayerInit.MACE_RUNT, MaceRuntModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.MACE_RUNT_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.MACE_RUNT_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BLAZE_RUNT, BlazeRuntModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.BLAZE_RUNT_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BLAZE_RUNT_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SPORE_MEDIC, SporeMedicModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.SPORE_MEDIC_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.SPORE_MEDIC_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BRUISER, PiglinBruiserModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BRUISER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BRUISER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_ENGINEER, PiglinEngineerModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_ENGINEER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_ENGINEER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.WARPED_BOMBER, WarpedBomberModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.WARPED_BOMBER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.WARPED_BOMBER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BIG_FUNGUS_THROWER, BigFungusThrowerModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.BIG_FUNGUS_THROWER_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.BIG_FUNGUS_THROWER_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO, PigmadilloModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGMADILLO_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD, PortalGuardModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD_INNER_ARMOUR, ClientEventBusSubscriber::createInnerArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD_OUTER_ARMOUR, ClientEventBusSubscriber::createOuterArmourLayer);
        event.registerLayerDefinition(ModelLayerInit.THROWN_BLAZE_ROD, ThrownBlazeRodModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PIGLIN_BOMB, PiglinBombModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.EXPLOSIVE_FUNGUS, ExplosiveFungusModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayerInit.PORTAL_GUARD_WRECKING_BALL, PortalGuardWreckingBallModel::createBodyLayer);
    }
	
	public static LayerDefinition createInnerArmourLayer() {
		return LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0.0F), 64, 32);
	}
	
	public static LayerDefinition createOuterArmourLayer() {
		return LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32);
	}
	
	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityTypeInit.MACE_RUNT.get(), MaceRuntRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.BLAZE_RUNT.get(), BlazeRuntRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.SPORE_MEDIC.get(), SporeMedicRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGLIN_BRUISER.get(), PiglinBruiserRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGLIN_ENGINEER.get(), PiglinEngineerRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.WARPED_BOMBER.get(), WarpedBomberRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.BIG_FUNGUS_THROWER.get(), BigFungusThrowerRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGMADILLO.get(), PigmadilloRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PORTAL_GUARD.get(), PortalGuardRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.THROWN_BLAZE_ROD.get(), ThrownBlazeRodRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PIGLIN_BOMB.get(), PiglinBombRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.EXPLOSIVE_FUNGUS.get(), ExplosiveFungusRenderer::new);
		event.registerEntityRenderer(EntityTypeInit.PORTAL_GUARD_WRECKING_BALL.get(), PortalGuardWreckingBallRenderer::new);
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