package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.ExplosiveFungus;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.ExplosiveFungusModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ExplosiveFungusRenderer extends EntityRenderer<ExplosiveFungus> {
   private final ExplosiveFungusModel model;

   public ExplosiveFungusRenderer(EntityRendererProvider.Context p_174420_) {
      super(p_174420_);
      this.model = new ExplosiveFungusModel(p_174420_.bakeLayer(ModelLayerInit.EXPLOSIVE_FUNGUS));
   }

   public void render(ExplosiveFungus p_116111_, float p_116112_, float p_116113_, PoseStack p_116114_, MultiBufferSource p_116115_, int p_116116_) {
      p_116114_.pushPose();
      p_116114_.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.yRotO, p_116111_.getYRot()) + 180.0F));
      p_116114_.mulPose(Vector3f.XP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.xRotO, p_116111_.getXRot()) + 0.0F));
      p_116114_.translate(0, -1.2, 0);
      RenderType RENDER_TYPE = RenderType.entityTranslucent(this.getTextureLocation(p_116111_));
      VertexConsumer vertexconsumer = p_116115_.getBuffer(RENDER_TYPE);
      this.model.renderToBuffer(p_116114_, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      p_116114_.popPose();
      super.render(p_116111_, p_116112_, p_116113_, p_116114_, p_116115_, p_116116_);
   }

   public ResourceLocation getTextureLocation(ExplosiveFungus p_116109_) {
      return new ResourceLocation(InfamousLegends.MOD_ID, "textures/items/explosive_fungus.png");
   }
}