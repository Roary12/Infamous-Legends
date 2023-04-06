package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.BigFungusThrower;
import com.infamous.infamous_legends.init.ItemInit;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.BigFungusThrowerModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.item.ItemStack;

public class BigFungusThrowerRenderer extends MobRenderer<BigFungusThrower, BigFungusThrowerModel<BigFungusThrower>> {

	public BigFungusThrowerRenderer(EntityRendererProvider.Context context) {
		super(context, new BigFungusThrowerModel<>(context.bakeLayer(ModelLayerInit.BIG_FUNGUS_THROWER)), 1F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.BIG_FUNGUS_THROWER_INNER_ARMOUR, ModelLayerInit.BIG_FUNGUS_THROWER_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()) {		
			@Override
			protected void renderArmWithItem(LivingEntity p_117185_, ItemStack p_117186_, TransformType p_117187_,
					HumanoidArm p_117188_, PoseStack p_117189_, MultiBufferSource p_117190_, int p_117191_) {
				if (p_117188_ == HumanoidArm.RIGHT && p_117185_.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ItemInit.EXPLOSIVE_FUNGUS.get()) {
					
				} else {
					super.renderArmWithItem(p_117185_, p_117186_, p_117187_, p_117188_, p_117189_, p_117190_, p_117191_);
				}
			}
		});
	}
	
	protected boolean isShaking(BigFungusThrower entity) {
		return super.isShaking(entity) || entity instanceof AbstractPiglin && ((AbstractPiglin) entity).isConverting();
	}

	@Override
	public ResourceLocation getTextureLocation(BigFungusThrower p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/big_fungus_thrower.png");
	}

}
