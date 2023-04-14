package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.MossyGolem;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.MossyGolemModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class MossyGolemRenderer extends MobRenderer<MossyGolem, MossyGolemModel<MossyGolem>> {

	public MossyGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new MossyGolemModel<>(context.bakeLayer(ModelLayerInit.MOSSY_GOLEM)), 0.5F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.MOSSY_GOLEM_INNER_ARMOUR, ModelLayerInit.MOSSY_GOLEM_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(MossyGolem p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/mossy_golem.png");
	}

}
