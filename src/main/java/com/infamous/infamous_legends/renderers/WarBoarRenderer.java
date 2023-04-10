package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.WarBoar;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.WarBoarModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WarBoarRenderer extends MobRenderer<WarBoar, WarBoarModel<WarBoar>> {

	public WarBoarRenderer(EntityRendererProvider.Context context) {
		super(context, new WarBoarModel<>(context.bakeLayer(ModelLayerInit.WAR_BOAR)), 0.75F);
	}

	@Override
	public ResourceLocation getTextureLocation(WarBoar p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/war_boar.png");
	}

}
