package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PiglinEngineer;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PiglinEngineerModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class PiglinEngineerRenderer extends MobRenderer<PiglinEngineer, PiglinEngineerModel<PiglinEngineer>> {

	public PiglinEngineerRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinEngineerModel<>(context.bakeLayer(ModelLayerInit.PIGLIN_ENGINEER)), 1F);
	}
	
	protected boolean isShaking(PiglinEngineer entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(PiglinEngineer p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/piglin_engineer_" + p_114482_.textureChange % 2 + ".png");
	}

}
