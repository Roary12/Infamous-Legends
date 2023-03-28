package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PiglinRunt;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PiglinRuntModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PiglinRuntRenderer extends MobRenderer<PiglinRunt, PiglinRuntModel<PiglinRunt>> {

	public PiglinRuntRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinRuntModel<>(context.bakeLayer(ModelLayerInit.PIGLIN_RUNT)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(PiglinRunt p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/piglin_runt.png");
	}

}
