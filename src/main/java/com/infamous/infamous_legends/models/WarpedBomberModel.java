package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.WarpedBomberKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.WarpedBomberSineWaveAnimations;
import com.infamous.infamous_legends.entities.WarpedBomber;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class WarpedBomberModel<T extends WarpedBomber> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart fungusBomb;
	public final ModelPart root1;
	public final ModelPart root2;
	public final ModelPart root3;
	public final ModelPart root4;
	public final ModelPart head;
	public final ModelPart vine1;
	public final ModelPart vine2;
	public final ModelPart vine3;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public WarpedBomberModel(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = everything.getChild("body");
		this.leftArm = body.getChild("leftArm");
		this.rightArm = body.getChild("rightArm");
		this.fungusBomb = rightArm.getChild("fungusBomb");
		this.root1 = fungusBomb.getChild("root1");
		this.root2 = fungusBomb.getChild("root2");
		this.root3 = fungusBomb.getChild("root3");
		this.root4 = fungusBomb.getChild("root4");
		this.head = body.getChild("head");
		this.vine1 = head.getChild("vine1");
		this.vine2 = head.getChild("vine2");
		this.vine3 = head.getChild("vine3");
		this.leftEar = head.getChild("leftEar");
		this.rightEar = head.getChild("rightEar");
		this.leftLeg = everything.getChild("leftLeg");
		this.rightLeg = everything.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(49, 52).addBox(-6.0F, -14.0F, -4.0F, 12.0F, 14.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(2, 82).addBox(-6.0F, -14.0F, -4.0F, 12.0F, 14.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(2, 61).mirror().addBox(0.0F, -2.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -12.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(2, 61).addBox(-5.0F, -2.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -12.0F, 0.0F));

		PartDefinition fungusBomb = rightArm.addOrReplaceChild("fungusBomb", CubeListBuilder.create().texOffs(6, 4).addBox(-7.0F, -8.0F, -11.0F, 14.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(2, 1).addBox(-4.0F, -1.0F, -14.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 33).addBox(-10.0F, -2.0F, -8.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 12.0F, -3.0F));

		PartDefinition fungusBomb_r1 = fungusBomb.addOrReplaceChild("fungusBomb_r1", CubeListBuilder.create().texOffs(44, 33).addBox(1.0F, -2.0F, 0.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 1.0F, -4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition fungusBomb_r2 = fungusBomb.addOrReplaceChild("fungusBomb_r2", CubeListBuilder.create().texOffs(2, 1).mirror().addBox(-3.0F, -2.5F, 4.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.5F, 8.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition root1 = fungusBomb.addOrReplaceChild("root1", CubeListBuilder.create().texOffs(38, 92).addBox(-9.0F, 0.0F, -12.0F, 22.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -11.0F));

		PartDefinition root2 = fungusBomb.addOrReplaceChild("root2", CubeListBuilder.create().texOffs(32, 104).addBox(-12.0F, 0.0F, -8.0F, 12.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 4.0F, -3.0F));

		PartDefinition root3 = fungusBomb.addOrReplaceChild("root3", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, -8.0F));

		PartDefinition root3_r1 = root3.addOrReplaceChild("root3_r1", CubeListBuilder.create().texOffs(32, 104).mirror().addBox(-7.0F, 0.0F, -4.0F, 12.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 0.0F, 5.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition root4 = fungusBomb.addOrReplaceChild("root4", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition root4_r1 = root4.addOrReplaceChild("root4_r1", CubeListBuilder.create().texOffs(36, 92).mirror().addBox(-16.0F, 0.0F, -3.0F, 26.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, 9.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(4, 35).addBox(-6.0F, -11.0F, -5.5F, 12.0F, 11.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(24, 66).addBox(2.0F, -13.0F, -9.5F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(3.0F, -11.0F, -9.5F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(-4.5F, -14.0F, -2.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-4.5F, -17.0F, 5.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(54, 77).addBox(-2.5F, -8.5F, -7.5F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-4.0F, -6.0F, -6.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(2.0F, -5.0F, -6.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.0F));

		PartDefinition vine1 = head.addOrReplaceChild("vine1", CubeListBuilder.create().texOffs(70, 71).addBox(0.05F, -0.05F, -2.0F, 0.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.1F, 0.0F, 5.5F));

		PartDefinition vine2 = head.addOrReplaceChild("vine2", CubeListBuilder.create().texOffs(70, 76).addBox(-5.0F, 0.0F, 0.0F, 5.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 5.5F));

		PartDefinition vine3 = head.addOrReplaceChild("vine3", CubeListBuilder.create().texOffs(70, 71).addBox(-0.05F, -0.05F, -2.0F, 0.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.1F, 0.0F, 3.5F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(74, 8).addBox(0.0F, 0.0F, -3.5F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -9.0F, 0.5F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(74, 8).addBox(-1.0F, 0.0F, -3.5F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -9.0F, 0.5F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(63, 27).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(95, 64).addBox(-3.0F, -1.9F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.15F)), PartPose.offset(3.0F, -10.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(63, 27).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(87, 106).addBox(-3.1F, -1.8F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offset(-3.0F, -10.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayRunAnimation = speed > 0.15 && entity.attackAnimationTick <= 0;
		
		boolean shouldPlayWalkAnimation = !shouldPlayRunAnimation && speed > 0 && entity.attackAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && !shouldPlayRunAnimation && entity.attackAnimationTick <= 0;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		WarpedBomberSineWaveAnimations.warpedBomberRunAnimation(this, SineWaveAnimationUtils.getTick(entity), speed * 20, shouldPlayRunAnimation ? 1 : 0);
		WarpedBomberSineWaveAnimations.warpedBomberWalkAnimation(this, SineWaveAnimationUtils.getTick(entity), speed * 15, shouldPlayWalkAnimation ? 1 : 0);
		WarpedBomberSineWaveAnimations.warpedBomberIdleAnimation(this, SineWaveAnimationUtils.getTick(entity), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, WarpedBomberKeyframeAnimations.WARPED_BOMBER_ATTACK, ageInTicks);
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
		stack.translate(arm == HumanoidArm.LEFT ? 1.5 / 16.0F : -1.5 / 16.0F, 0.75 / 16.0F, 0.0 / 16.0F);
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
				stack.translate(0, -0.25 / 16.0F, 0);
				stack.scale(1.25F, 1.25F, 1.25F);
				break;
			case BODY:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				stack.translate(0, -14.5 / 16.0F, 0);
				stack.scale(1.2F, 1.2F, 1.375F);
				break;
			case RIGHT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.rightArm.translateAndRotate(stack);
				stack.translate(4 / 16.0F, -2 / 16.0F, 0);
				stack.scale(1.1F, 1.1F, 1.1F);
				break;
			case LEFT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.leftArm.translateAndRotate(stack);
				stack.translate(-4 / 16.0F, -2 / 16.0F, 0);
				stack.scale(1.1F, 1.1F, 1.1F);
				break;
			case RIGHT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.rightLeg.translateAndRotate(stack);
				stack.translate(2 / 16.0F, -12 / 16.0F, 0);
				stack.scale(1.025F, 1.025F, 1.025F);
				break;
			case LEFT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				stack.translate(-2 / 16.0F, -12 / 16.0F, 0);
				stack.scale(1.025F, 1.025F, 1.025F);
				break;
		}
	}
}