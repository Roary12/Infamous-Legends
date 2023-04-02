package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PiglinGrunter;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PiglinGrunterModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class PiglinGrunterRenderer extends MobRenderer<PiglinGrunter, PiglinGrunterModel<PiglinGrunter>> {

	public PiglinGrunterRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinGrunterModel<>(context.bakeLayer(ModelLayerInit.PIGLIN_GRUNTER)), 0.5F);
	}
	
	protected boolean isShaking(PiglinGrunter entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(PiglinGrunter p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/piglin_grunter.png");
	}

}
