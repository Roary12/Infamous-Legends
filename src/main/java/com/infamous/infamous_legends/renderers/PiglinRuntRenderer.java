package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PiglinRunt;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PiglinRuntModel;
import com.infamous.infamous_legends.renderers.layers.CustomHeldItemLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class PiglinRuntRenderer extends MobRenderer<PiglinRunt, PiglinRuntModel<PiglinRunt>> {

	public PiglinRuntRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinRuntModel<>(context.bakeLayer(ModelLayerInit.PIGLIN_RUNT)), 0.5F);
		this.addLayer(new CustomHeldItemLayer<>(this, context.getItemInHandRenderer()));
	}
	
	protected boolean isShaking(PiglinRunt entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(PiglinRunt p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/piglin_runt.png");
	}

}
