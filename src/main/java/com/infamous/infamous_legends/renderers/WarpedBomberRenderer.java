package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.WarpedBomber;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.WarpedBomberModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class WarpedBomberRenderer extends MobRenderer<WarpedBomber, WarpedBomberModel<WarpedBomber>> {

	public WarpedBomberRenderer(EntityRendererProvider.Context context) {
		super(context, new WarpedBomberModel<>(context.bakeLayer(ModelLayerInit.WARPED_BOMBER)), 0.75F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.WARPED_BOMBER_INNER_ARMOUR, ModelLayerInit.WARPED_BOMBER_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(WarpedBomber entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(WarpedBomber p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/warped_bomber.png");
	}

}
