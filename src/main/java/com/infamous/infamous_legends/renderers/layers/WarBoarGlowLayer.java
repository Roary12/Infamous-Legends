package com.infamous.infamous_legends.renderers.layers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.WarBoar;
import com.infamous.infamous_legends.models.WarBoarModel;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WarBoarGlowLayer<T extends WarBoar> extends EyesLayer<T, WarBoarModel<T>> {
   private static final RenderType GLOW = RenderType.eyes(new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/war_boar_glow.png"));

   public WarBoarGlowLayer(RenderLayerParent<T, WarBoarModel<T>> p_116964_) {
      super(p_116964_);
   }

   public RenderType renderType() {
      return GLOW;
   }
}