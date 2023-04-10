package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PortalGuardModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class PortalGuardRenderer extends MobRenderer<PortalGuard, PortalGuardModel<PortalGuard>> {

	public PortalGuardRenderer(EntityRendererProvider.Context context) {
		super(context, new PortalGuardModel<>(context.bakeLayer(ModelLayerInit.PORTAL_GUARD)), 1.75F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.PORTAL_GUARD_INNER_ARMOUR, ModelLayerInit.PORTAL_GUARD_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(PortalGuard entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(PortalGuard p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/portal_guard.png");
	}

}
