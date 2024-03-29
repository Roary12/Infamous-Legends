package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PortalGuardWreckingBall;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.PortalGuardWreckingBallModel;
import com.infamous.infamous_legends.utils.PositionUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PortalGuardWreckingBallRenderer extends EntityRenderer<PortalGuardWreckingBall> {
	
	private static final ResourceLocation CHAIN_LOCATION = new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/portal_guard_chain.png");
	private static final RenderType CHAIN_RENDER_TYPE = RenderType.entityCutoutNoCull(CHAIN_LOCATION);
	   
   private final PortalGuardWreckingBallModel model;

   public PortalGuardWreckingBallRenderer(EntityRendererProvider.Context p_174420_) {
      super(p_174420_);
      this.model = new PortalGuardWreckingBallModel(p_174420_.bakeLayer(ModelLayerInit.PORTAL_GUARD_WRECKING_BALL));
   }

   public void render(PortalGuardWreckingBall p_116111_, float p_116112_, float p_116113_, PoseStack p_116114_, MultiBufferSource p_116115_, int p_116116_) {
      p_116114_.pushPose();
      p_116114_.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.yRotO, p_116111_.getYRot()) + 180.0F));
      p_116114_.mulPose(Vector3f.XP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.xRotO, p_116111_.getXRot()) + 0.0F));
      p_116114_.translate(0, -0.9, 0.4);
      RenderType RENDER_TYPE = RenderType.entityTranslucent(this.getTextureLocation(p_116111_));
      VertexConsumer vertexconsumer = p_116115_.getBuffer(RENDER_TYPE);
      this.model.renderToBuffer(p_116114_, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      p_116114_.popPose();
      LivingEntity entity = p_116111_.getClientOwner();
      if (entity != null) {
         this.renderChain(p_116111_, p_116113_, p_116114_, p_116115_, entity);
      }
      super.render(p_116111_, p_116112_, p_116113_, p_116114_, p_116115_, p_116116_);
   }
   
   private <E extends LivingEntity> void renderChain(PortalGuardWreckingBall p_115462_, float p_115463_, PoseStack p_115464_, MultiBufferSource p_115465_, E p_115466_) {
	      p_115464_.pushPose();
	      Vec3 vec3 = PositionUtils.getOffsetPos(p_115466_, 1.5, 2.5, 2, p_115466_.yBodyRot);
	      double d0 = (double)(Mth.lerp(p_115463_, p_115462_.yRotO, p_115462_.getYRot()) * ((float)Math.PI / 180F)) + (Math.PI / 2D);
	      Vec3 vec31 = p_115462_.getLeashOffset();
	      double d1 = Math.cos(d0) * vec31.z + Math.sin(d0) * vec31.x;
	      double d2 = Math.sin(d0) * vec31.z - Math.cos(d0) * vec31.x;
	      double d3 = Mth.lerp((double)p_115463_, p_115462_.xo, p_115462_.getX()) + d1;
	      double d4 = Mth.lerp((double)p_115463_, p_115462_.yo, p_115462_.getY()) + vec31.y;
	      double d5 = Mth.lerp((double)p_115463_, p_115462_.zo, p_115462_.getZ()) + d2;
	      p_115464_.translate(d1, vec31.y, d2);
	      float f = (float)(vec3.x - d3);
	      float f1 = (float)(vec3.y - d4);
	      float f2 = (float)(vec3.z - d5);
	      float f3 = 0.025F;
	      VertexConsumer vertexconsumer = p_115465_.getBuffer(RenderType.leash());
	      Matrix4f matrix4f = p_115464_.last().pose();
	      float f4 = Mth.fastInvSqrt(f * f + f2 * f2) * 0.025F / 2.0F;
	      float f5 = f2 * f4;
	      float f6 = f * f4;
	      BlockPos blockpos = new BlockPos(p_115462_.getEyePosition(p_115463_));
	      BlockPos blockpos1 = new BlockPos(p_115466_.getEyePosition(p_115463_));
	      int i = this.getBlockLightLevel(p_115462_, blockpos);
	      int j = p_115466_.level.getBrightness(LightLayer.BLOCK, blockpos1);
	      int k = p_115462_.level.getBrightness(LightLayer.SKY, blockpos);
	      int l = p_115462_.level.getBrightness(LightLayer.SKY, blockpos1);

	      for(int i1 = 0; i1 <= 24; ++i1) {
	         addVertexPair(vertexconsumer, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.025F, f5, f6, i1, false);
	      }

	      for(int j1 = 24; j1 >= 0; --j1) {
	         addVertexPair(vertexconsumer, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.0F, f5, f6, j1, true);
	      }

	      p_115464_.popPose();
	   }

	   private static void addVertexPair(VertexConsumer p_174308_, Matrix4f p_174309_, float p_174310_, float p_174311_, float p_174312_, int p_174313_, int p_174314_, int p_174315_, int p_174316_, float p_174317_, float p_174318_, float p_174319_, float p_174320_, int p_174321_, boolean p_174322_) {
	      float f = (float)p_174321_ / 24.0F;
	      int i = (int)Mth.lerp(f, (float)p_174313_, (float)p_174314_);
	      int j = (int)Mth.lerp(f, (float)p_174315_, (float)p_174316_);
	      int k = LightTexture.pack(i, j);
	      float f1 = p_174321_ % 2 == (p_174322_ ? 1 : 0) ? 0.7F : 1.0F;
	      float f2 = 0.5F * f1;
	      float f3 = 0.4F * f1;
	      float f4 = 0.3F * f1;
	      float f5 = p_174310_ * f;
	      float f6 = p_174311_ > 0.0F ? p_174311_ * f * f : p_174311_ - p_174311_ * (1.0F - f) * (1.0F - f);
	      float f7 = p_174312_ * f;
	      p_174308_.vertex(p_174309_, f5 - p_174319_, f6 + p_174318_, f7 + p_174320_).color(f2, f3, f4, 1.0F).uv2(k).endVertex();
	      p_174308_.vertex(p_174309_, f5 + p_174319_, f6 + p_174317_ - p_174318_, f7 - p_174320_).color(f2, f3, f4, 1.0F).uv2(k).endVertex();
	   }

   public ResourceLocation getTextureLocation(PortalGuardWreckingBall p_116109_) {
      return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/portal_guard.png");
   }
}