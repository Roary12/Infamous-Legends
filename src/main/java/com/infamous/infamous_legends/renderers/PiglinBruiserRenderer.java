package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PiglinBruiser;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PiglinBruiserModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class PiglinBruiserRenderer extends MobRenderer<PiglinBruiser, PiglinBruiserModel<PiglinBruiser>> {

	public PiglinBruiserRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinBruiserModel<>(context.bakeLayer(ModelLayerInit.PIGLIN_BRUISER)), 0.75F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.PIGLIN_BRUISER_INNER_ARMOUR, ModelLayerInit.PIGLIN_BRUISER_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(PiglinBruiser entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(PiglinBruiser p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/piglin_bruiser.png");
	}

}
