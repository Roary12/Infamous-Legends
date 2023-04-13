package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.GrindstoneGolem;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.GrindstoneGolemModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class GrindstoneGolemRenderer extends MobRenderer<GrindstoneGolem, GrindstoneGolemModel<GrindstoneGolem>> {

	public GrindstoneGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new GrindstoneGolemModel<>(context.bakeLayer(ModelLayerInit.GRINDSTONE_GOLEM)), 0.5F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.GRINDSTONE_GOLEM_INNER_ARMOUR, ModelLayerInit.GRINDSTONE_GOLEM_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(GrindstoneGolem p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/grindstone_golem.png");
	}

}
