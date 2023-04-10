package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.PortalGuardKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.PortalGuardSineWaveAnimations;
import com.infamous.infamous_legends.entities.PortalGuard;
import com.infamous.infamous_legends.interfaces.ArmourWearingModel;
import com.infamous.infamous_legends.interfaces.CustomHeadedModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer.ArmourModelPart;
import com.mojang.blaze3d.vertex.PoseStack;

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
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PortalGuardModel<T extends PortalGuard> extends HierarchicalModel<T> implements CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart bodyOverlayLower;
	public final ModelPart bodyOverlayLowerLeft;
	public final ModelPart bodyOverlayLowerRight;
	public final ModelPart leftArm;
	public final ModelPart weapon;
	public final ModelPart rightArm;
	public final ModelPart piston;
	public final ModelPart ball;
	public final ModelPart chainBase;
	public final ModelPart head;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public PortalGuardModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.bodyOverlayLower = this.body.getChild("bodyOverlayLower");
		this.bodyOverlayLowerLeft = this.bodyOverlayLower.getChild("bodyOverlayLowerLeft");
		this.bodyOverlayLowerRight = this.bodyOverlayLower.getChild("bodyOverlayLowerRight");
		this.head = this.body.getChild("head");
		this.leftEar = this.head.getChild("leftEar");
		this.rightEar = this.head.getChild("rightEar");
		this.leftArm = this.body.getChild("leftArm");
		this.weapon = this.leftArm.getChild("weapon");
		this.rightArm = this.body.getChild("rightArm");
		this.piston = this.rightArm.getChild("piston");
		this.ball = this.rightArm.getChild("ball");
		this.chainBase = this.rightArm.getChild("chainBase");
		this.leftLeg = this.everything.getChild("leftLeg");
		this.rightLeg = this.everything.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 76).addBox(-14.0F, -34.0F, -9.0F, 28.0F, 34.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-14.0F, -20.0F, -9.0F, 28.0F, 20.0F, 18.0F, new CubeDeformation(0.25F))
		.texOffs(186, 116).addBox(3.0F, -11.0F, -11.25F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(148, 95).addBox(-11.0F, -15.0F, -11.25F, 11.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(155, 115).addBox(-5.0F, -9.0F, -12.25F, 10.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(40, 129).addBox(0.0F, -6.0F, -5.0F, 10.0F, 34.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(200, 199).addBox(10.0F, 12.5F, -2.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(189, 169).addBox(-2.0F, 24.5F, -7.0F, 14.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(198, 119).addBox(10.0F, -7.0F, -7.0F, 3.0F, 11.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(197, 145).addBox(10.0F, -11.0F, -7.0F, 3.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, -28.0F, 0.0F));

		PartDefinition weapon = leftArm.addOrReplaceChild("weapon", CubeListBuilder.create().texOffs(130, 187).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 6.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(139, 197).addBox(0.0F, 0.5F, -19.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 28.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition weapon_r1 = weapon.addOrReplaceChild("weapon_r1", CubeListBuilder.create().texOffs(139, 197).addBox(-0.5F, -3.0F, -4.0F, 1.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.5F, -15.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition weapon_r2 = weapon.addOrReplaceChild("weapon_r2", CubeListBuilder.create().texOffs(136, 228).addBox(-2.0F, -11.0F, -1.0F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.0F, 15.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition weapon_r3 = weapon.addOrReplaceChild("weapon_r3", CubeListBuilder.create().texOffs(151, 228).addBox(-2.0F, -9.0F, -1.0F, 4.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 5.0F, 15.0F, 0.0F, 0.0F, 0.0262F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(40, 129).mirror().addBox(-10.0F, -6.0F, -5.0F, 10.0F, 34.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(152, 132).addBox(-10.0F, -7.0F, -6.0F, 11.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(138, 51).addBox(-13.0F, -7.0F, -7.0F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(94, 73).addBox(-13.0F, -7.0F, -2.0F, 3.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(200, 217).addBox(-12.0F, 19.0F, -7.0F, 14.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(164, 229).addBox(-12.0F, 6.0F, -7.0F, 3.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, -28.0F, 0.0F));

		PartDefinition piston = rightArm.addOrReplaceChild("piston", CubeListBuilder.create().texOffs(143, 170).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(125, 31).addBox(-6.5F, -17.0F, -6.5F, 13.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -7.0F, 0.0F));

		PartDefinition ball = rightArm.addOrReplaceChild("ball", CubeListBuilder.create().texOffs(8, 178).addBox(-9.2016F, -0.05F, -9.9872F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(69, 192).addBox(1.7984F, 12.95F, -10.9872F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(157, 8).addBox(-7.2016F, 7.35F, -13.9872F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(69, 184).addBox(-9.2016F, 15.95F, -9.9872F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.7984F, 31.05F, -0.0128F));

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

		PartDefinition chainBase = rightArm.addOrReplaceChild("chainBase", CubeListBuilder.create(), PartPose.offset(-5.0F, 31.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(178, 20).addBox(-7.0F, -12.0F, -11.0F, 14.0F, 14.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(195, 0).addBox(-8.5F, -14.0F, -12.0F, 17.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(196, 102).addBox(-5.5F, -6.0F, -12.0F, 11.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(198, 53).addBox(-1.5F, -18.01F, -15.0F, 3.0F, 16.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(48, 176).addBox(0.0F, -39.01F, -15.0F, 1.0F, 37.0F, 43.0F, new CubeDeformation(0.0F))
		.texOffs(222, 21).addBox(-3.0F, -4.0F, -16.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(126, 115).addBox(3.0F, -1.0F, -16.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(124, 113).addBox(-6.0F, -1.0F, -18.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -32.0F, -6.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(240, 28).mirror().addBox(0.0F, 0.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(248, 28).mirror().addBox(-1.0F, 5.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.5F, -9.5F, -1.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(240, 28).mirror().addBox(-1.0F, 0.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -9.5F, -1.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition bodyOverlayLower = body.addOrReplaceChild("bodyOverlayLower", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bodyOverlayLowerRight = bodyOverlayLower.addOrReplaceChild("bodyOverlayLowerRight", CubeListBuilder.create().texOffs(0, 38).addBox(-7.5F, -4.5F, -9.0F, 14.0F, 17.0F, 18.0F, new CubeDeformation(0.24F)), PartPose.offset(-6.5F, 0.0F, 0.0F));

		PartDefinition bodyOverlayLowerLeft = bodyOverlayLower.addOrReplaceChild("bodyOverlayLowerLeft", CubeListBuilder.create().texOffs(74, 38).addBox(-6.5F, -4.5F, -9.0F, 14.0F, 17.0F, 18.0F, new CubeDeformation(0.245F)), PartPose.offset(6.5F, 0.0F, 0.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(101, 2).mirror().addBox(-6.0F, 0.0F, -6.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.5F, -14.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(101, 2).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -14.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayIdleShootingAnimation = entity.playingIdleShootingAnimation && entity.attackAnimationTick <= 0 && entity.shootAnimationTick <= 0 && entity.reelInBallAnimationTick <= 0;
		
		boolean shouldPlayWalkAnimation = speed > 0 && !shouldPlayIdleShootingAnimation && entity.attackAnimationTick <= 0 && entity.shootAnimationTick <= 0 && entity.reelInBallAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && !shouldPlayIdleShootingAnimation && entity.attackAnimationTick <= 0 && entity.shootAnimationTick <= 0 && entity.reelInBallAnimationTick <= 0;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		PortalGuardSineWaveAnimations.portalGuardIdleShootingAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleShootingAnimation ? 1 : 0);
		PortalGuardSineWaveAnimations.portalGuardWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 10F, shouldPlayWalkAnimation ? 1 : 0);
		PortalGuardSineWaveAnimations.portalGuardIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, PortalGuardKeyframeAnimations.PORTAL_GUARD_ATTACK, ageInTicks);
		this.animate(entity.shootAnimationState, PortalGuardKeyframeAnimations.PORTAL_GUARD_SHOOT, ageInTicks);
		this.animate(entity.reelInBallAnimationState, PortalGuardKeyframeAnimations.PORTAL_GUARD_REEL_IN_BALL, ageInTicks);
	}
	
	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
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
				stack.translate(0, 1.0 / 16.0F, -3.5 / 16.0F);
				stack.scale(1.5F, 1.5F, 1.55F);
				break;
			case BODY:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				stack.translate(0, -33 / 16.0F, 0);
				stack.scale(2.8F, 2.8F, 3.0F);
				break;
			case RIGHT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.rightArm.translateAndRotate(stack);
				stack.translate(5.5 / 16.0F, -4.5 / 16.0F, 0);
				stack.scale(1.75F, 1.75F, 1.75F);
				break;
			case LEFT_ARM:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.body.translateAndRotate(stack);
				this.leftArm.translateAndRotate(stack);
				stack.translate(-5.5 / 16.0F, -4.5 / 16.0F, 0);
				stack.scale(1.75F, 1.75F, 1.75F);
				break;
			case RIGHT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.rightLeg.translateAndRotate(stack);
				if (innerModel) {
					stack.translate(4.5 / 16.0F, -19 / 16.0F, 0);
					stack.scale(2.5F, 1.5F, 2.5F);
				} else {
					stack.translate(4.25 / 16.0F, -21 / 16.0F, 0);
					stack.scale(2.25F, 1.5F, 2.25F);
				}
				break;
			case LEFT_LEG:
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				if (innerModel) {
					stack.translate(-4.5 / 16.0F, -19 / 16.0F, 0);
					stack.scale(2.5F, 1.5F, 2.5F);
				} else {
					stack.translate(-4.25 / 16.0F, -21 / 16.0F, 0);
					stack.scale(2.25F, 1.5F, 2.25F);
				}
				break;
		}
	}
}