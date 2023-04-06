package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.BigFungusThrowerKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.BigFungusThrowerSineWaveAnimations;
import com.infamous.infamous_legends.entities.BigFungusThrower;
import com.infamous.infamous_legends.interfaces.ArmourWearingModel;
import com.infamous.infamous_legends.interfaces.CustomHeadedModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer.ArmourModelPart;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class BigFungusThrowerModel<T extends BigFungusThrower> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart bodyOverlayLower;
	public final ModelPart bodyOverlayLowerLeft;
	public final ModelPart bodyOverlayLowerRight;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart fungus;
	public final ModelPart head;
	public final ModelPart noseFoliage;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public BigFungusThrowerModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.bodyOverlayLower = this.body.getChild("bodyOverlayLower");
		this.bodyOverlayLowerLeft = this.bodyOverlayLower.getChild("bodyOverlayLowerLeft");
		this.bodyOverlayLowerRight = this.bodyOverlayLower.getChild("bodyOverlayLowerRight");
		this.head = this.body.getChild("head");
		this.noseFoliage = this.head.getChild("noseFoliage");
		this.leftEar = this.head.getChild("leftEar");
		this.rightEar = this.head.getChild("rightEar");
		this.leftArm = this.body.getChild("leftArm");
		this.rightArm = this.body.getChild("rightArm");
		this.fungus = this.rightArm.getChild("fungus");
		this.leftLeg = this.everything.getChild("leftLeg");
		this.rightLeg = this.everything.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.5F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 50).addBox(-10.0F, -23.0F, -7.5F, 20.0F, 23.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(-10.0F, -10.0F, -7.5F, 20.0F, 10.0F, 15.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -11.0F, -0.5F));

		PartDefinition bodyFungus_r1 = body.addOrReplaceChild("bodyFungus_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-11.0F, -6.5F, 4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-17.0F, -8.5F, 7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 90).addBox(-14.0F, -3.5F, -0.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 90).addBox(-18.0F, -5.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-8.0F, -10.0F, -1.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(9, 111).addBox(-15.0F, -0.5F, 10.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 111).addBox(-8.0F, 1.5F, 7.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 111).addBox(-12.5F, 1.5F, 1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 111).addBox(-16.5F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 111).addBox(-5.0F, -2.0F, 1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -20.5F, 10.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(78, 0).addBox(-6.5F, -11.0F, -9.0F, 13.0F, 14.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(52, 90).addBox(-4.5F, -17.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(70, 84).addBox(-2.5F, -15.0F, -13.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(70, 84).addBox(-9.5F, -14.0F, -5.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(52, 90).addBox(-9.0F, -15.0F, -11.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(11, 115).addBox(-3.0F, -13.0F, -7.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 115).addBox(-1.5F, -12.0F, -12.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 115).addBox(-7.5F, -12.0F, -9.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 115).addBox(-8.5F, -12.0F, -4.75F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 1).addBox(-2.5F, -2.0F, -11.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, -6.5F));

		PartDefinition headFungus_r1 = head.addOrReplaceChild("headFungus_r1", CubeListBuilder.create().texOffs(11, 115).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -10.5F, -10.5F, 1.5708F, 0.0F, -1.5708F));

		PartDefinition headFungus_r2 = head.addOrReplaceChild("headFungus_r2", CubeListBuilder.create().texOffs(11, 115).addBox(-2.0F, 0.0F, 4.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 115).addBox(-2.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -10.0F, -9.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -2.5F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -5.0F, -4.5F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -5.0F, -4.5F, 0.0F, 0.0F, 0.6109F));

		PartDefinition noseFoliage = head.addOrReplaceChild("noseFoliage", CubeListBuilder.create().texOffs(45, 11).addBox(-0.5F, 0.0F, -0.05F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, -11.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(72, 31).mirror().addBox(0.0F, -3.0F, -3.5F, 7.0F, 25.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, -19.0F, -2.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(72, 31).addBox(-7.0F, -3.0F, -3.5F, 7.0F, 25.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -19.0F, -2.0F));

		PartDefinition fungus = rightArm.addOrReplaceChild("fungus", CubeListBuilder.create().texOffs(9, 111).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 19.0F, -3.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bodyOverlayLower = body.addOrReplaceChild("bodyOverlayLower", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bodyOverlayLowerLeft = bodyOverlayLower.addOrReplaceChild("bodyOverlayLowerLeft", CubeListBuilder.create().texOffs(73, 84).addBox(-5.0F, -3.5F, -7.5F, 10.0F, 12.0F, 15.0F, new CubeDeformation(0.24F)), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition bodyOverlayLowerRight = bodyOverlayLower.addOrReplaceChild("bodyOverlayLowerRight", CubeListBuilder.create().texOffs(50, 98).addBox(-5.0F, -3.5F, -7.5F, 10.0F, 12.0F, 15.0F, new CubeDeformation(0.23F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(72, 64).mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -11.0F, -0.5F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(72, 64).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -11.0F, -0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayWalkAnimation = speed > 0 && entity.throwAnimationTick <= 0 && entity.noveltyAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.throwAnimationTick <= 0 && entity.noveltyAnimationTick <= 0;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		BigFungusThrowerSineWaveAnimations.bigFungusThrowerWalkAnimation(this, SineWaveAnimationUtils.getTick(entity), speed * 17, shouldPlayWalkAnimation ? 1 : 0);
		BigFungusThrowerSineWaveAnimations.bigFungusThrowerIdleAnimation(this, SineWaveAnimationUtils.getTick(entity), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.throwAnimationState, BigFungusThrowerKeyframeAnimations.BIG_FUNGUS_THROWER_THROW, ageInTicks);
		this.animate(entity.noveltyAnimationState, BigFungusThrowerKeyframeAnimations.BIG_FUNGUS_THROWER_NOVELTY, ageInTicks);
	}
	
	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
	
	private ModelPart getArm(HumanoidArm arm) {
		return arm == HumanoidArm.LEFT ? this.leftArm : this.rightArm;
	}
   
	@Override
	public void translateToHand(HumanoidArm arm, PoseStack stack) {
		this.root().translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.body.translateAndRotate(stack);
		this.getArm(arm).translateAndRotate(stack);
		stack.translate(arm == HumanoidArm.LEFT ? 2.5 / 16.0F : -2.5 / 16.0F, 10.75 / 16.0F, -2.0 / 16.0F);
	}

	@Override
	public void translateToHead(PoseStack stack) {
		this.root().translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.body.translateAndRotate(stack);
		this.head.translateAndRotate(stack);
	}
	
	@Override
	public void translateArmour(ArmourModelPart modelPart, PoseStack stack, boolean innerModel) {
		switch (modelPart) {
			case HEAD:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.head.translateAndRotate(stack);
				stack.translate(0, 0.5 / 16.0F, -3 / 16.0F);
				stack.scale(1.35F, 1.35F, 1.35F);
				break;
			case BODY:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				stack.translate(0, -22 / 16.0F, 0);
				stack.scale(2, 2, 2.5F);
				break;
			case RIGHT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.rightArm.translateAndRotate(stack);
				stack.translate(3.75 / 16.0F, -2.5 / 16.0F, 0);
				stack.scale(1.25F, 1.25F, 1.25F);
				break;
			case LEFT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.leftArm.translateAndRotate(stack);
				stack.translate(-3.75 / 16.0F, -2.5 / 16.0F, 0);
				stack.scale(1.25F, 1.25F, 1.25F);
				break;
			case RIGHT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.rightLeg.translateAndRotate(stack);
				if (innerModel) {
					stack.translate(2.7 / 16.0F, -15 / 16.0F, 0);
					stack.scale(1.45F, 1.25F, 1.45F);
				} else {
					stack.translate(2.7 / 16.0F, -22.5 / 16.0F, 0);
					stack.scale(1.45F, 1.45F, 1.45F);
				}
				break;
			case LEFT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				if (innerModel) {
					stack.translate(-2.7 / 16.0F, -15 / 16.0F, 0);
					stack.scale(1.45F, 1.25F, 1.45F);
				} else {
					stack.translate(-2.7 / 16.0F, -22.5 / 16.0F, 0);
					stack.scale(1.45F, 1.45F, 1.45F);
				}
				break;
		}
	}
}