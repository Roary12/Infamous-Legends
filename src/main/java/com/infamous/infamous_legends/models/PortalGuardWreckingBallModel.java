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


public class PortalGuardWreckingBallModel<T extends Entity> extends Model {
	private final ModelPart root;
	private final ModelPart ball;

	public PortalGuardWreckingBallModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.ball = this.root.getChild("ball");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ball = partdefinition.addOrReplaceChild("ball", CubeListBuilder.create().texOffs(8, 178).addBox(-9.2016F, -0.05F, -9.9872F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(69, 192).addBox(1.7984F, 12.95F, -10.9872F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(157, 8).addBox(-7.2016F, 7.35F, -13.9872F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(69, 184).addBox(-9.2016F, 15.95F, -9.9872F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7984F, 14.05F, 9.9872F, -1.5708F, 0.0F, 0.0F));

		PartDefinition ball_r1 = ball.addOrReplaceChild("ball_r1", CubeListBuilder.create().texOffs(69, 184).addBox(-5.3F, 0.05F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2016F, 5.2F, 6.0128F, 1.5708F, 0.0F, 1.5708F));

		PartDefinition ball_r2 = ball.addOrReplaceChild("ball_r2", CubeListBuilder.create().texOffs(104, 191).addBox(-4.204F, -5.25F, -3.9854F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8024F, 9.2F, -5.8018F, 0.0F, -1.5708F, 0.0F));

		PartDefinition ball_r3 = ball.addOrReplaceChild("ball_r3", CubeListBuilder.create().texOffs(157, 8).addBox(-2.3F, -0.25F, -1.95F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2016F, 13.7F, 5.7628F, 0.0F, 1.5708F, 0.0F));

		PartDefinition ball_r4 = ball.addOrReplaceChild("ball_r4", CubeListBuilder.create().texOffs(157, 8).addBox(-4.0F, 0.25F, -2.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7984F, 15.7F, -3.9872F, 0.0F, 1.5708F, -3.1416F));

		PartDefinition ball_r5 = ball.addOrReplaceChild("ball_r5", CubeListBuilder.create().texOffs(157, 8).addBox(-3.7F, 5.05F, -2.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7984F, 15.7F, 1.5128F, -1.5708F, 0.0F, 1.5708F));

		PartDefinition ball_r6 = ball.addOrReplaceChild("ball_r6", CubeListBuilder.create().texOffs(157, 8).addBox(-8.3F, -12.55F, -9.5F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7016F, 8.7F, -7.9872F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition ball_r7 = ball.addOrReplaceChild("ball_r7", CubeListBuilder.create().texOffs(157, 8).addBox(-1.25F, -0.25F, -2.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5484F, 5.7F, 12.0128F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition ball_r8 = ball.addOrReplaceChild("ball_r8", CubeListBuilder.create().texOffs(157, 8).addBox(-3.2F, -5.05F, -2.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2984F, 5.7F, 12.0128F, 3.1416F, 0.0F, -1.5708F));

		PartDefinition ball_r9 = ball.addOrReplaceChild("ball_r9", CubeListBuilder.create().texOffs(157, 8).addBox(-4.0F, -0.05F, -2.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7016F, 6.9F, -11.9872F, 0.0F, 0.0F, -1.5708F));

		PartDefinition ball_r10 = ball.addOrReplaceChild("ball_r10", CubeListBuilder.create().texOffs(157, 8).addBox(-1.5F, -0.05F, -2.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2984F, 21.9F, -4.4872F, 0.0F, -1.5708F, 1.5708F));

		PartDefinition ball_r11 = ball.addOrReplaceChild("ball_r11", CubeListBuilder.create().texOffs(157, 8).addBox(1.5F, 8.55F, -15.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7016F, 8.9F, -10.9872F, 1.5708F, 0.0F, 0.0F));

		PartDefinition ball_r12 = ball.addOrReplaceChild("ball_r12", CubeListBuilder.create().texOffs(69, 192).addBox(-7.5F, -8.25F, -15.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2016F, 14.2F, 8.5128F, 0.0F, -1.5708F, 0.0F));

		PartDefinition ball_r13 = ball.addOrReplaceChild("ball_r13", CubeListBuilder.create().texOffs(69, 192).addBox(-6.5F, 2.75F, -14.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7016F, 8.2F, -2.9872F, 0.0F, 3.1416F, 0.0F));

		PartDefinition ball_r14 = ball.addOrReplaceChild("ball_r14", CubeListBuilder.create().texOffs(69, 192).addBox(-7.5F, -10.25F, -14.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7984F, 15.2F, -8.4872F, 0.0F, 1.5708F, 0.0F));

		PartDefinition ball_r15 = ball.addOrReplaceChild("ball_r15", CubeListBuilder.create().texOffs(69, 192).addBox(-9.0F, 8.45F, -5.7F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7984F, 15.2F, -8.4872F, 1.5708F, 0.0F, 0.0F));

		PartDefinition ball_r16 = ball.addOrReplaceChild("ball_r16", CubeListBuilder.create().texOffs(104, 191).addBox(-10.754F, -3.25F, 3.9646F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5524F, 9.2F, 13.9482F, 3.1416F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}