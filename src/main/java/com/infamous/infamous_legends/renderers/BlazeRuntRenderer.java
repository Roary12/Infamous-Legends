package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.BlazeRunt;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.BlazeRuntModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class BlazeRuntRenderer extends MobRenderer<BlazeRunt, BlazeRuntModel<BlazeRunt>> {

	public BlazeRuntRenderer(EntityRendererProvider.Context context) {
		super(context, new BlazeRuntModel<>(context.bakeLayer(ModelLayerInit.BLAZE_RUNT)), 0.5F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.BLAZE_RUNT_INNER_ARMOUR, ModelLayerInit.BLAZE_RUNT_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(BlazeRunt entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(BlazeRunt p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/blaze_runt.png");
	}

}
