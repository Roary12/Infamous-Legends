package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.SporeMedic;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.SporeMedicModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class SporeMedicRenderer extends MobRenderer<SporeMedic, SporeMedicModel<SporeMedic>> {

	public SporeMedicRenderer(EntityRendererProvider.Context context) {
		super(context, new SporeMedicModel<>(context.bakeLayer(ModelLayerInit.SPORE_MEDIC)), 0.75F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.SPORE_MEDIC_INNER_ARMOUR, ModelLayerInit.SPORE_MEDIC_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(SporeMedic entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(SporeMedic p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/spore_medic.png");
	}

}
