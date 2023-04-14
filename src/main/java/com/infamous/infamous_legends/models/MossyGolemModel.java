package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.MossyGolemSineWaveAnimations;
import com.infamous.infamous_legends.entities.MossyGolem;
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


public class MossyGolemModel<T extends MossyGolem> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public MossyGolemModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = everything.getChild("body");
		this.head = body.getChild("head");
		this.leftArm = head.getChild("leftArm");
		this.rightArm = head.getChild("rightArm");
		this.leftLeg = everything.getChild("leftLeg");
		this.rightLeg = everything.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 26).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition leftArm = head.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(65, 0).addBox(0.0F, -1.5F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -1.5F, 0.0F));

		PartDefinition rightArm = head.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(65, 20).addBox(-5.0F, -1.5F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -1.5F, 0.0F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create().texOffs(-2, 3).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -8.3F, -6.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition petal1 = flower.addOrReplaceChild("petal1", CubeListBuilder.create().texOffs(-2, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition petal2 = flower.addOrReplaceChild("petal2", CubeListBuilder.create().texOffs(-2, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.4363F));

		PartDefinition petal3 = flower.addOrReplaceChild("petal3", CubeListBuilder.create().texOffs(-2, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 2.7053F, 0.0F, 3.1416F));

		PartDefinition petal4 = flower.addOrReplaceChild("petal4", CubeListBuilder.create().texOffs(-2, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.4363F));

		PartDefinition leafiness = head.addOrReplaceChild("leafiness", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition leafyPart1 = leafiness.addOrReplaceChild("leafyPart1", CubeListBuilder.create().texOffs(0, 49).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leafyPart2 = leafiness.addOrReplaceChild("leafyPart2", CubeListBuilder.create().texOffs(0, 51).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leafyPart3 = leafiness.addOrReplaceChild("leafyPart3", CubeListBuilder.create().texOffs(0, 53).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leafyPart4 = leafiness.addOrReplaceChild("leafyPart4", CubeListBuilder.create().texOffs(0, 55).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leafyPart8 = leafiness.addOrReplaceChild("leafyPart8", CubeListBuilder.create().texOffs(0, 63).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 8.0F, 2.7053F, 0.0F, 3.1416F));

		PartDefinition leafyPart9 = leafiness.addOrReplaceChild("leafyPart9", CubeListBuilder.create().texOffs(0, 65).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 8.0F, 2.7053F, 0.0F, 3.1416F));

		PartDefinition leafyPart12 = leafiness.addOrReplaceChild("leafyPart12", CubeListBuilder.create().texOffs(0, 71).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -15.0F, 0.0F, 0.0F, 1.5708F, 0.4363F));

		PartDefinition leafyPart13 = leafiness.addOrReplaceChild("leafyPart13", CubeListBuilder.create().texOffs(0, 73).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -13.0F, 0.0F, 0.0F, 1.5708F, 0.4363F));

		PartDefinition leafyPart14 = leafiness.addOrReplaceChild("leafyPart14", CubeListBuilder.create().texOffs(0, 75).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -15.0F, 0.0F, 0.0F, -1.5708F, -0.4363F));

		PartDefinition leafyPart15 = leafiness.addOrReplaceChild("leafyPart15", CubeListBuilder.create().texOffs(0, 77).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -12.0F, 0.0F, 0.0F, -1.5708F, -0.4363F));

		PartDefinition lowerLeafiness = body.addOrReplaceChild("lowerLeafiness", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leafyPart5 = lowerLeafiness.addOrReplaceChild("leafyPart5", CubeListBuilder.create().texOffs(0, 57).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leafyPart6 = lowerLeafiness.addOrReplaceChild("leafyPart6", CubeListBuilder.create().texOffs(0, 59).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leafyPart7 = lowerLeafiness.addOrReplaceChild("leafyPart7", CubeListBuilder.create().texOffs(0, 61).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leafyPart10 = lowerLeafiness.addOrReplaceChild("leafyPart10", CubeListBuilder.create().texOffs(0, 67).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 8.0F, 2.7053F, 0.0F, 3.1416F));

		PartDefinition leafyPart11 = lowerLeafiness.addOrReplaceChild("leafyPart11", CubeListBuilder.create().texOffs(0, 69).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, 2.7053F, 0.0F, 3.1416F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(87, 13).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 0.0F, 0.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(87, 0).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayShootAnimation = entity.shooting;
		
		boolean shouldPlayRunAnimation = !shouldPlayShootAnimation && speed > 0.125;
		
		boolean shouldPlayWalkAnimation = !shouldPlayShootAnimation && !shouldPlayRunAnimation && speed > 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayShootAnimation && !shouldPlayWalkAnimation && !shouldPlayRunAnimation;	
		
		MossyGolemSineWaveAnimations.mossyGolemShootAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayShootAnimation ? 1 : 0);
		MossyGolemSineWaveAnimations.mossyGolemRunAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 7.5F, shouldPlayRunAnimation ? 1 : 0);
		MossyGolemSineWaveAnimations.mossyGolemWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 15, shouldPlayWalkAnimation ? 1 : 0);
		MossyGolemSineWaveAnimations.mossyGolemIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
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
		this.head.translateAndRotate(stack);
		this.getArm(arm).translateAndRotate(stack);
		stack.translate(arm == HumanoidArm.RIGHT ? -1.5F / 16.0F : 1.5F / 16.0F, 1 / 16.0F, 0 / 16.0F);
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
			stack.scale(1.8F, 1.8F, 1.8F);
			stack.translate(0, 3 / 16.0F, 0);
			break;
		case BODY:
			stack.scale(0, 0, 0);
			break;
		case RIGHT_ARM:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.body.translateAndRotate(stack);
			this.head.translateAndRotate(stack);
			this.rightArm.translateAndRotate(stack);
			stack.translate(4 / 16.0F, -1 / 16.0F, 0);
			stack.scale(1.1F, 1.1F, 1.1F);
			break;
		case LEFT_ARM:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.body.translateAndRotate(stack);
			this.head.translateAndRotate(stack);
			this.leftArm.translateAndRotate(stack);
			stack.translate(-4 / 16.0F, -1 / 16.0F, 0);
			stack.scale(1.1F, 1.1F, 1.1F);
			break;
		case RIGHT_LEG:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.rightLeg.translateAndRotate(stack);
			stack.translate(2.5F / 16.0F, -12.5F / 16.0F, 0);
			if (innerModel) {
				stack.scale(1.25F, 0.5F, 1.25F);
				stack.translate(0, 11 / 16.0F, 0);
			} else {
				stack.scale(1.1F, 0.75F, 1.1F);
				stack.translate(-0.25F / 16.0F, 0, 0);
			}
			break;
		case LEFT_LEG:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.leftLeg.translateAndRotate(stack);
			stack.translate(-2.5F / 16.0F, -12.5F / 16.0F, 0);
			if (innerModel) {
				stack.scale(1.25F, 0.5F, 1.25F);
				stack.translate(0, 11 / 16.0F, 0);
			} else {
				stack.scale(1.1F, 0.75F, 1.1F);
				stack.translate(0.25F / 16.0F, 0, 0);
			}
			break;
		}
	}
}