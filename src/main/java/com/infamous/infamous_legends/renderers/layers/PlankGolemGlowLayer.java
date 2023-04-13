package com.infamous.infamous_legends.renderers.layers;

import com.infamous.infamous_legends.entities.PlankGolem;
import com.infamous.infamous_legends.models.PlankGolemModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlankGolemGlowLayer<T extends PlankGolem> extends RenderLayer<T, PlankGolemModel<T>> {

   public PlankGolemGlowLayer(RenderLayerParent<T, PlankGolemModel<T>> p_116964_) {
      super(p_116964_);
   }
   
	public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity,
			float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw,
			float pHeadPitch) {
		if (pLivingEntity.getPlankGolemType().getGlowTextureLocation() != null) {
			VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.eyes(pLivingEntity.getPlankGolemType().getGlowTextureLocation()));
			this.getParentModel().renderToBuffer(pMatrixStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F,
					1.0F, 1.0F, 1.0F);
		}
	}
}