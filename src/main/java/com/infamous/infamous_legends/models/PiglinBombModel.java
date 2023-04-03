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

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PiglinBombModel<T extends PiglinBombModel> extends Model {
	private final ModelPart root;
	private final ModelPart bomb;
	private final ModelPart fuse;
	private final ModelPart spark;
	

	public PiglinBombModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.bomb = root.getChild("bomb");
		this.fuse = bomb.getChild("fuse");
		this.spark = fuse.getChild("spark");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bomb = partdefinition.addOrReplaceChild("bomb", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(17, 10).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.5F, -3.5F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition fuse = bomb.addOrReplaceChild("fuse", CubeListBuilder.create().texOffs(24, 4).addBox(-0.5F, -2.8F, -0.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.7F, 0.0F));

		PartDefinition spark = fuse.addOrReplaceChild("spark", CubeListBuilder.create().texOffs(16, 0).addBox(-1.5F, -3.0F, -0.1F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 0).addBox(-1.5F, -3.0F, -0.1F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.4F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}