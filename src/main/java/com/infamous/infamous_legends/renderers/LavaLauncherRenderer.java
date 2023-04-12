package com.infamous.infamous_legends.renderers;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.init.ModelLayerInit;
import com.infamous.infamous_legends.models.LavaLauncherModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer;
import com.infamous.infamous_legends.renderers.layers.HeadItemLayer;
import com.infamous.infamous_legends.renderers.layers.LavaLauncherPiglinLayer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class LavaLauncherRenderer extends MobRenderer<LavaLauncher, LavaLauncherModel<LavaLauncher>> {

	public LavaLauncherRenderer(EntityRendererProvider.Context context) {
		super(context, new LavaLauncherModel<>(context.bakeLayer(ModelLayerInit.LAVA_LAUNCHER)), 3F);
		CustomArmourLayer.addCustomArmourLayers(this, context, ModelLayerInit.LAVA_LAUNCHER_INNER_ARMOUR, ModelLayerInit.LAVA_LAUNCHER_OUTER_ARMOUR);
	    this.addLayer(new HeadItemLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
		this.addLayer(new LavaLauncherPiglinLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(LavaLauncher p_114482_) {
		return new ResourceLocation(InfamousLegends.MOD_ID, "textures/entities/lava_launcher.png");
	}

}
