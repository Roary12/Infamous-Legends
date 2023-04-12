package com.infamous.infamous_legends.renderers.layers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.models.LavaLauncherModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LavaLauncherPiglinLayer<T extends LavaLauncher> extends RenderLayer<T, LavaLauncherModel<T>> {

   private static final RenderType RENDER_TYPE = RenderType.entityTranslucent(new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/lava_launcher_piglin.png"));
	   
   public LavaLauncherPiglinLayer(RenderLayerParent<T, LavaLauncherModel<T>> p_116964_) {
      super(p_116964_);
   }

	@Override
	public void render(PoseStack p_117349_, MultiBufferSource p_117350_, int p_117351_, T p_117352_, float p_117353_,
			float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
		if (!p_117352_.isInvisible()) {
		      VertexConsumer vertexconsumer = p_117350_.getBuffer(RENDER_TYPE);
		      this.getParentModel().renderToBuffer(p_117349_, vertexconsumer, p_117351_, (p_117352_.piglinHurtTime > 0 || p_117352_.piglinDeathTime > 0) ? OverlayTexture.RED_OVERLAY_V : OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}