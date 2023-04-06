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


public class ExplosiveFungusModel<T extends Entity> extends Model {
	private final ModelPart root;
	private final ModelPart fungus;

	public ExplosiveFungusModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.fungus = this.root.getChild("fungus");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fungus = partdefinition.addOrReplaceChild("fungus", CubeListBuilder.create().texOffs(0, 20).addBox(4.0F, 5.3F, 19.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(1.0F, 2.3F, 11.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 13.7F, -20.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}