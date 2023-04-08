package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.PigmadilloKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.PigmadilloSineWaveAnimations;
import com.infamous.infamous_legends.entities.Pigmadillo;
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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PigmadilloModel<T extends Pigmadillo> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart shellEverything;
	public final ModelPart everything;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;
	public final ModelPart body;
	public final ModelPart shell;
	public final ModelPart shell1;
	public final ModelPart shell2;
	public final ModelPart shell3;
	public final ModelPart shell4;
	public final ModelPart head;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftArm;
	public final ModelPart leftArmBase;
	public final ModelPart leftShoulder;
	public final ModelPart leftGlove;
	public final ModelPart rightArm;
	public final ModelPart rightArmBase;
	public final ModelPart rightShoulder;
	public final ModelPart rightGlove;
	public final ModelPart bodyOverlayLower;
	public final ModelPart bodyOverlayLowerLeft;
	public final ModelPart bodyOverlayLowerRight;

	public PigmadilloModel(ModelPart root) {
		this.root = root;
		this.shellEverything = root.getChild("shellEverything");
		this.everything = shellEverything.getChild("everything");
		this.leftLeg = everything.getChild("leftLeg");
		this.rightLeg = everything.getChild("rightLeg");
		this.body = everything.getChild("body");
		this.shell = body.getChild("shell");
		this.shell1 = shell.getChild("shell1");
		this.shell2 = shell.getChild("shell2");
		this.shell3 = shell.getChild("shell3");
		this.shell4 = shell.getChild("shell4");
		this.head = body.getChild("head");
		this.leftEar = head.getChild("leftEar");
		this.rightEar = head.getChild("rightEar");
		this.leftArm = body.getChild("leftArm");
		this.leftArmBase = leftArm.getChild("leftArmBase");
		this.leftShoulder = leftArm.getChild("leftShoulder");
		this.leftGlove = leftArm.getChild("leftGlove");
		this.rightArm = body.getChild("rightArm");
		this.rightArmBase = rightArm.getChild("rightArmBase");
		this.rightShoulder = rightArm.getChild("rightShoulder");
		this.rightGlove = rightArm.getChild("rightGlove");
		this.bodyOverlayLower = body.getChild("bodyOverlayLower");
		this.bodyOverlayLowerLeft = bodyOverlayLower.getChild("bodyOverlayLowerLeft");
		this.bodyOverlayLowerRight = bodyOverlayLower.getChild("bodyOverlayLowerRight");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition shellEverything = partdefinition.addOrReplaceChild("shellEverything", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -5.0F));

		PartDefinition everything = shellEverything.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(144, 157).mirror().addBox(-4.5F, 0.0F, -5.5F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.5F, 6.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(144, 157).addBox(-4.5F, 0.0F, -5.5F, 9.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 6.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 56).addBox(-11.0F, -28.0F, -9.0F, 22.0F, 28.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-11.0F, -28.0F, -9.0F, 22.0F, 38.0F, 18.0F, new CubeDeformation(0.45F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition shell = body.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(0.0F, -20.0F, 8.0F));

		PartDefinition shell1 = shell.addOrReplaceChild("shell1", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 5.0F));

		PartDefinition shell1_r1 = shell1.addOrReplaceChild("shell1_r1", CubeListBuilder.create().texOffs(168, 0).addBox(5.0F, -9.0F, -12.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 0).addBox(-9.0F, -9.5F, -12.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(56, 117).addBox(-14.0F, -11.0F, -4.0F, 28.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition shell2 = shell.addOrReplaceChild("shell2", CubeListBuilder.create().texOffs(84, 0).addBox(-17.0F, -13.0F, -4.0F, 34.0F, 26.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 9.0F));

		PartDefinition shell2_r1 = shell2.addOrReplaceChild("shell2_r1", CubeListBuilder.create().texOffs(168, 0).addBox(-2.0F, 13.0F, -16.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(206, 16).addBox(6.0F, 4.0F, -16.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(168, 0).addBox(-10.0F, 4.0F, -16.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition shell4 = shell.addOrReplaceChild("shell4", CubeListBuilder.create().texOffs(56, 117).addBox(-14.0F, -11.0F, -4.0F, 28.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 3.0F));

		PartDefinition shell3 = shell.addOrReplaceChild("shell3", CubeListBuilder.create().texOffs(84, 34).mirror().addBox(-16.0F, -13.0F, -4.0F, 32.0F, 26.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 11.0F, 5.0F));

		PartDefinition shell3_r1 = shell3.addOrReplaceChild("shell3_r1", CubeListBuilder.create().texOffs(206, 16).addBox(5.0F, 28.0F, -12.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(168, 0).addBox(-9.0F, 28.0F, -12.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(143, 70).addBox(-8.0F, -12.0F, -9.0F, 16.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(167, 39).addBox(-8.0F, -12.0F, -9.0F, 16.0F, 11.0F, 12.0F, new CubeDeformation(0.5F))
		.texOffs(67, 64).addBox(-3.0F, -6.0F, -13.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(9.0F, -5.0F, -13.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(-12.0F, -5.0F, -13.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(66, 8).addBox(3.0F, -4.0F, -12.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(66, 8).addBox(-9.0F, -4.0F, -12.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 0.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -8.5F, -3.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -8.5F, -3.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(11.0F, -23.0F, 0.0F));

		PartDefinition leftArmBase = leftArm.addOrReplaceChild("leftArmBase", CubeListBuilder.create().texOffs(195, 123).addBox(-6.25F, -23.0F, -7.0F, 14.0F, 38.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(6.25F, 17.0F, 0.0F));

		PartDefinition leftShoulder = leftArm.addOrReplaceChild("leftShoulder", CubeListBuilder.create().texOffs(128, 128).mirror().addBox(-4.75F, -16.0F, -9.0F, 13.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.75F, 9.0F, 0.0F));

		PartDefinition leftGlove = leftArm.addOrReplaceChild("leftGlove", CubeListBuilder.create().texOffs(0, 151).mirror().addBox(2.75F, -4.75F, -9.0F, 7.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(156, 16).mirror().addBox(-6.25F, 3.25F, -9.0F, 16.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.25F, 28.75F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(-11.0F, -23.0F, 0.0F));

		PartDefinition rightArmBase = rightArm.addOrReplaceChild("rightArmBase", CubeListBuilder.create().texOffs(195, 181).addBox(-7.0F, -23.0F, -7.0F, 14.0F, 38.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 17.0F, 0.0F));

		PartDefinition rightShoulder = rightArm.addOrReplaceChild("rightShoulder", CubeListBuilder.create().texOffs(128, 128).addBox(-6.5F, -5.5F, -9.0F, 13.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -1.5F, 0.0F));

		PartDefinition rightGlove = rightArm.addOrReplaceChild("rightGlove", CubeListBuilder.create().texOffs(88, 150).addBox(-9.0F, -1.75F, -9.0F, 10.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(38, 147).addBox(-9.0F, 3.25F, -9.0F, 16.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 28.75F, 0.0F));

		PartDefinition bodyOverlayLower = body.addOrReplaceChild("bodyOverlayLower", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition bodyOverlayLowerLeft = bodyOverlayLower.addOrReplaceChild("bodyOverlayLowerLeft", CubeListBuilder.create().texOffs(74, 202).addBox(-5.2F, -7.5F, -9.0F, 11.0F, 15.0F, 18.0F, new CubeDeformation(0.55F)), PartPose.offset(5.5F, 0.0F, 0.0F));

		PartDefinition bodyOverlayLowerRight = bodyOverlayLower.addOrReplaceChild("bodyOverlayLowerRight", CubeListBuilder.create().texOffs(14, 192).addBox(-5.9F, -7.5F, -9.0F, 11.0F, 15.0F, 18.0F, new CubeDeformation(0.5F)), PartPose.offset(-5.5F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayWalkAnimation = speed > 0 && entity.attackAnimationTick <= 0 && entity.rollAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.attackAnimationTick <= 0 && entity.rollAnimationTick <= 0;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		PigmadilloSineWaveAnimations.pigmadilloWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 6.5F, shouldPlayWalkAnimation ? 1 : 0);
		PigmadilloSineWaveAnimations.pigmadilloIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, PigmadilloKeyframeAnimations.PIGMADILLO_ATTACK, ageInTicks);
		this.animate(entity.rollAnimationState, PigmadilloKeyframeAnimations.PIGMADILLO_ROLL(entity), ageInTicks);
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
		this.shellEverything.translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.body.translateAndRotate(stack);
		this.getArm(arm).translateAndRotate(stack);
		stack.translate(arm == HumanoidArm.LEFT ? 3 / 16.0F : -3 / 16.0F, 14 / 16.0F, -5.0 / 16.0F);
		stack.scale(1.5F, 1.5F, 1.5F);
	}

	@Override
	public void translateToHead(PoseStack stack) {
		this.root().translateAndRotate(stack);
		this.shellEverything.translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.body.translateAndRotate(stack);
		this.head.translateAndRotate(stack);
	}
	
	@Override
	public void translateArmour(ArmourModelPart modelPart, PoseStack stack, boolean innerModel) {
		switch (modelPart) {
			case HEAD:
				this.root().translateAndRotate(stack);
				this.shellEverything.translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.head.translateAndRotate(stack);
				stack.translate(0, 2 / 16.0F, -3 / 16.0F);
				stack.scale(1.7F, 1.7F, 1.5F);
				break;
			case BODY:
				this.root().translateAndRotate(stack);
				this.shellEverything.translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				stack.translate(0, -30 / 16.0F, -0 / 16.0F);
				if (innerModel) {
					stack.scale(2.7F, 2.5F, 3.85F);
				} else {
					stack.scale(2.5F, 2.5F, 3.25F);
				}
				break;
			case RIGHT_ARM:
				this.root().translateAndRotate(stack);
				this.shellEverything.translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.rightArm.translateAndRotate(stack);
				stack.translate(7.5 / 16.0F, -4.25 / 16.0F, -0 / 16.0F);
				stack.scale(2.4F, 2.4F, 2.4F);
				break;
			case LEFT_ARM:
				this.root().translateAndRotate(stack);
				this.shellEverything.translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.leftArm.translateAndRotate(stack);
				stack.translate(-7.5 / 16.0F, -4.25 / 16.0F, -0 / 16.0F);
				stack.scale(2.4F, 2.4F, 2.4F);
				break;
			case RIGHT_LEG:
				this.root().translateAndRotate(stack);
				this.shellEverything.translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.rightLeg.translateAndRotate(stack);
				if (innerModel) {
					stack.translate(3.5F / 16.0F, -15 / 16.0F, -0 / 16.0F);
					stack.scale(1.85F, 1.25F, 2.5F);
				} else {
					stack.translate(3.5F / 16.0F, -12 / 16.0F, -0 / 16.0F);
					stack.scale(1.85F, 1.0F, 2.5F);
				}
				break;
			case LEFT_LEG:
				this.root().translateAndRotate(stack);
				this.shellEverything.translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				if (innerModel) {
					stack.translate(-3.5F / 16.0F, -15 / 16.0F, -0 / 16.0F);
					stack.scale(1.85F, 1.25F, 2.5F);
				} else {
					stack.translate(-3.5F / 16.0F, -12 / 16.0F, -0 / 16.0F);
					stack.scale(1.85F, 1.0F, 2.5F);
				}
				break;
		}
	}
}