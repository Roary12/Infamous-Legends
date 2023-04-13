package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.CobblestoneGolem;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.CobblestoneGolemModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class CobblestoneGolemRenderer extends MobRenderer<CobblestoneGolem, CobblestoneGolemModel<CobblestoneGolem>> {

	public CobblestoneGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new CobblestoneGolemModel<>(context.bakeLayer(ModelLayerInit.COBBLESTONE_GOLEM)), 0.5F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.COBBLESTONE_GOLEM_INNER_ARMOUR, ModelLayerInit.COBBLESTONE_GOLEM_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(CobblestoneGolem p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/cobblestone_golem.png");
	}

}
