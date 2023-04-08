package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.SporeMedicSineWaveAnimations;
import com.infamous.infamous_legends.entities.SporeMedic;
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


public class SporeMedicModel<T extends SporeMedic> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart chestEquipment;
	public final ModelPart container;
	public final ModelPart lever;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart head;
	public final ModelPart nose;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public SporeMedicModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.chestEquipment = this.body.getChild("chestEquipment");
		this.container = this.body.getChild("container");
		this.lever = this.container.getChild("lever");
		this.head = this.body.getChild("head");
		this.nose = this.head.getChild("nose");
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

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 34).addBox(-4.0F, -10.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-4.0F, -10.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition chestEquipment = body.addOrReplaceChild("chestEquipment", CubeListBuilder.create().texOffs(36, 0).addBox(-3.5F, -3.0625F, -2.25F, 7.0F, 6.0F, 2.0F, new CubeDeformation(0.25F))
		.texOffs(40, 50).addBox(-0.5F, -3.0625F, -3.75F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -6.9375F, -2.0F));

		PartDefinition container = body.addOrReplaceChild("container", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -4.0F, 2.0F, 14.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(50, 32).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 2.0F));

		PartDefinition lever = container.addOrReplaceChild("lever", CubeListBuilder.create().texOffs(56, 0).addBox(-3.5F, 0.05F, -0.75F, 7.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.05F, 9.85F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(24, 47).mirror().addBox(0.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -9.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 47).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -9.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(38, 37).addBox(-6.0F, -3.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(38, 37).mirror().addBox(5.0F, -3.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 20).addBox(-5.0F, -3.0F, -5.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).mirror().addBox(2.0F, -3.0F, -5.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(50, 50).addBox(-5.0F, -3.0F, 4.0F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -8.0F, -5.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(59, 21).addBox(-1.5F, -8.0F, 4.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 22).addBox(-1.5F, -10.0F, -5.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(36, 8).addBox(-2.5F, -2.0F, -8.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -4.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(50, 38).mirror().addBox(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.5F, -6.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(50, 38).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -6.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 52).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.245F)), PartPose.offset(2.0F, -5.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(42, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2475F)), PartPose.offset(-2.0F, -5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayShootAnimation = entity.shooting;
		
		boolean shouldPlayWalkAnimation = speed > 0 && !shouldPlayShootAnimation;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && !shouldPlayShootAnimation;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		SporeMedicSineWaveAnimations.sporeMedicShootAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayShootAnimation ? 1 : 0);
		SporeMedicSineWaveAnimations.sporeMedicWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 17, shouldPlayWalkAnimation ? 1 : 0);
		SporeMedicSineWaveAnimations.sporeMedicIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
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
		stack.translate(arm == HumanoidArm.RIGHT ? -1 / 16.0F : 1 / 16.0F, -2.25 / 16.0F, -0.5 / 16.0F);
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
				stack.scale(1.05F, 1.05F, 1.05F);
				break;
			case BODY:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				stack.translate(0, -10.5 / 16.0F, 0);
				break;
			case RIGHT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.rightArm.translateAndRotate(stack);
				stack.translate(4 / 16.0F, -2 / 16.0F, 0);
				break;
			case LEFT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.leftArm.translateAndRotate(stack);
				stack.translate(-4 / 16.0F, -2 / 16.0F, 0);
				break;
			case RIGHT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.rightLeg.translateAndRotate(stack);
				stack.translate(2 / 16.0F, -16 / 16.0F, 0);
				if (innerModel) {
					stack.scale(1, 0.58F, 1);
					stack.translate(0, 15 / 16.0F, 0);
				}
				break;
			case LEFT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				stack.translate(-2 / 16.0F, -16 / 16.0F, 0);
				if (innerModel) {
					stack.scale(1, 0.58F, 1);
					stack.translate(0, 15 / 16.0F, 0);
				}
				break;
		}
	}

}