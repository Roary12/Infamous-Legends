package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.PiglinBruiserKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.PiglinBruiserSineWaveAnimations;
import com.infamous.infamous_legends.entities.PiglinBruiser;
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
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PiglinBruiserModel<T extends PiglinBruiser> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart head;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public PiglinBruiserModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.head = this.body.getChild("head");
		this.leftEar = this.head.getChild("leftEar");
		this.rightEar = this.head.getChild("rightEar");
		this.leftArm = this.body.getChild("leftArm");
		this.rightArm = this.body.getChild("rightArm");
		this.leftLeg = this.everything.getChild("leftLeg");
		this.rightLeg = this.everything.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(72, 59).addBox(-6.0F, -13.0F, -3.0F, 12.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(22, 83).addBox(-6.0F, -8.2F, -3.0F, 12.0F, 8.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(0, 54).mirror().addBox(0.0F, -2.0F, -2.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -11.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(27, 53).addBox(-5.0F, -2.0F, -2.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -11.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(62, 32).addBox(-9.5F, -12.3F, 4.0F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.24F))
		.texOffs(50, 16).addBox(-6.0F, -9.3F, 4.0F, 15.0F, 6.0F, 1.0F, new CubeDeformation(0.24F))
		.texOffs(0, 17).addBox(-6.0F, -9.3F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.25F))
		.texOffs(0, 0).addBox(-4.0F, -3.0F, -4.2F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(2.0F, -2.5F, -4.2F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(87, 5).addBox(-5.5F, -9.0F, -4.0F, 11.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(30, 7).addBox(-2.5F, -5.0F, -5.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(51, 5).addBox(0.7F, -4.0F, -5.01F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(51, 5).addBox(-1.7F, -4.0F, -5.01F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(60, 23).addBox(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -7.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(52, 35).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -7.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(47, 49).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(66, 107).addBox(-3.0F, 0.2F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.245F)), PartPose.offset(3.0F, -10.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(32, 36).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(22, 109).addBox(-3.0F, 0.2F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.24F)), PartPose.offset(-3.0F, -10.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayWalkAnimation = speed > 0 && entity.attackAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.attackAnimationTick <= 0;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		PiglinBruiserSineWaveAnimations.piglinBruiserWalkAnimation(this, SineWaveAnimationUtils.getTick(entity), speed * 17, shouldPlayWalkAnimation ? 1 : 0);
		PiglinBruiserSineWaveAnimations.piglinBruiserIdleAnimation(this, SineWaveAnimationUtils.getTick(entity), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, PiglinBruiserKeyframeAnimations.BRUISER_ATTACK, ageInTicks);
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
				stack.scale(1.25F, 1.25F, 1.025F);
				break;
			case BODY:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				stack.translate(0, -13 / 16.0F, 0);
				if (innerModel) {
					stack.scale(1.4F, 1.08F, 1.4F);
				} else {
					stack.scale(1.3F, 1.08F, 1.3F);
				}
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
				if (innerModel) {
					stack.translate(2.475 / 16.0F, -13 / 16.0F, 0);
					stack.scale(1.3F, 1.0F, 1.3F);
				} else {
					stack.translate(2.25 / 16.0F, -18 / 16.0F, 0);
					stack.scale(1.2F, 1.2F, 1.2F);
				}
				break;
			case LEFT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				if (innerModel) {
					stack.translate(-2.475 / 16.0F, -13 / 16.0F, 0);
					stack.scale(1.3F, 1.0F, 1.3F);
				} else {
					stack.translate(-2.25 / 16.0F, -18 / 16.0F, 0);
					stack.scale(1.2F, 1.2F, 1.2F);
				}
				break;
		}
	}
}