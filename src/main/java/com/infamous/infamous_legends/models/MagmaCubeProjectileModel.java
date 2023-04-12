package com.infamous.infamous_legends.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class MagmaCubeProjectileModel<T extends Entity> extends Model {
	private final ModelPart root;
	private final ModelPart magmaCubeProjectile;

	public MagmaCubeProjectileModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.magmaCubeProjectile = this.root.getChild("magmaCubeProjectile");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition magmaCubeProjectile = partdefinition.addOrReplaceChild("magmaCubeProjectile", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition segment1 = magmaCubeProjectile.addOrReplaceChild("segment1", CubeListBuilder.create().texOffs(344, 428).addBox(-20.0F, 14.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -26.0F, -8.0F));

		PartDefinition segment2 = magmaCubeProjectile.addOrReplaceChild("segment2", CubeListBuilder.create().texOffs(344, 431).addBox(-20.0F, 15.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -24.0F, -8.0F));

		PartDefinition segment3 = magmaCubeProjectile.addOrReplaceChild("segment3", CubeListBuilder.create().texOffs(416, 458).addBox(-20.0F, 16.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -22.0F, -8.0F));

		PartDefinition segment4 = magmaCubeProjectile.addOrReplaceChild("segment4", CubeListBuilder.create().texOffs(416, 485).addBox(-20.0F, 17.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -20.0F, -8.0F));

		PartDefinition segment5 = magmaCubeProjectile.addOrReplaceChild("segment5", CubeListBuilder.create().texOffs(344, 440).addBox(-20.0F, 18.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -18.0F, -8.0F));

		PartDefinition segment6 = magmaCubeProjectile.addOrReplaceChild("segment6", CubeListBuilder.create().texOffs(344, 443).addBox(-20.0F, 19.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -16.0F, -8.0F));

		PartDefinition segment7 = magmaCubeProjectile.addOrReplaceChild("segment7", CubeListBuilder.create().texOffs(344, 446).addBox(-20.0F, 20.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -14.0F, -8.0F));

		PartDefinition segment8 = magmaCubeProjectile.addOrReplaceChild("segment8", CubeListBuilder.create().texOffs(344, 449).addBox(-20.0F, 21.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -12.0F, -8.0F));

		PartDefinition core = magmaCubeProjectile.addOrReplaceChild("core", CubeListBuilder.create().texOffs(344, 476).addBox(-10.0F, 10.0F, -2.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -16.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}