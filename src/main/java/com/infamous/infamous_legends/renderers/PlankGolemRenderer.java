package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.entities.PlankGolem;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PlankGolemModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;
import com.infamous.infamous_legends.renderers.layers.PlankGolemGlowLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PlankGolemRenderer extends MobRenderer<PlankGolem, PlankGolemModel<PlankGolem>> {

	public PlankGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new PlankGolemModel<>(context.bakeLayer(ModelLayerInit.PLANK_GOLEM)), 0.5F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.PLANK_GOLEM_INNER_ARMOUR, ModelLayerInit.PLANK_GOLEM_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
	    this.addLayer(new PlankGolemGlowLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(PlankGolem p_114482_) {
		return p_114482_.getPlankGolemType().getTextureLocation();
	}

}
