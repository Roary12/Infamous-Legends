package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.entities.PiglinRunt;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PiglinRuntModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class PiglinRuntRenderer extends MobRenderer<PiglinRunt, PiglinRuntModel<PiglinRunt>> {

	public PiglinRuntRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinRuntModel<>(context.bakeLayer(ModelLayerInit.PIGLIN_RUNT)), 0.5F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.PIGLIN_RUNT_INNER_ARMOUR, ModelLayerInit.PIGLIN_RUNT_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	@Override
	public void render(PiglinRunt p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_,
			MultiBufferSource p_115459_, int p_115460_) {

		/*float animationTransitionPerTick = ((float)p_115455_.animationTransitionTime + p_115457_) / 20.0F;

		System.out.print("\r\n" + "animationTransitionPerTick: " + animationTransitionPerTick);
		
		p_115455_.runAnimationAmountMultiplier = SineWaveAnimationUtils.tickAmountMultiplierChange(p_115455_.runAnimationAmountMultiplier, p_115455_.shouldPlayRunAnimation, animationTransitionPerTick);
		
		p_115455_.walkAnimationAmountMultiplier = SineWaveAnimationUtils.tickAmountMultiplierChange(p_115455_.walkAnimationAmountMultiplier, p_115455_.shouldPlayWalkAnimation, animationTransitionPerTick);
		
		p_115455_.idleAnimationAmountMultiplier = SineWaveAnimationUtils.tickAmountMultiplierChange(p_115455_.idleAnimationAmountMultiplier, p_115455_.shouldPlayIdleAnimation, animationTransitionPerTick);
		*/
		
		super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
	}
	
	protected boolean isShaking(PiglinRunt entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(PiglinRunt p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/piglin_runt.png");
	}

}
