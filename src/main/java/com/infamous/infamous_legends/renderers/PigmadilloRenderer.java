package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.Pigmadillo;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PigmadilloModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class PigmadilloRenderer extends MobRenderer<Pigmadillo, PigmadilloModel<Pigmadillo>> {

	public PigmadilloRenderer(EntityRendererProvider.Context context) {
		super(context, new PigmadilloModel<>(context.bakeLayer(ModelLayerInit.PIGMADILLO)), 1.25F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.PIGMADILLO_INNER_ARMOUR, ModelLayerInit.PIGMADILLO_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(Pigmadillo entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(Pigmadillo p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/pigmadillo.png");
	}

}
