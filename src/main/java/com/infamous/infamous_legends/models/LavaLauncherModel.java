package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.LavaLauncherKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.LavaLauncherSineWaveAnimations;
import com.infamous.infamous_legends.entities.LavaLauncher;
import com.infamous.infamous_legends.interfaces.ArmourWearingModel;
import com.infamous.infamous_legends.interfaces.CustomHeadedModel;
import com.infamous.infamous_legends.renderers.layers.CustomArmourLayer.ArmourModelPart;
import com.infamous.infamous_legends.utils.MiscUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

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


public class LavaLauncherModel<T extends LavaLauncher> extends HierarchicalModel<T> implements ArmedModel, CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart leftFrontLeg;
	public final ModelPart rightFrontLeg;
	public final ModelPart leftBackLeg;
	public final ModelPart rightBackLeg;
	public final ModelPart lavaLauncherBody;
	public final ModelPart platform;
	public final ModelPart magmaCubeProjectile;
	public final ModelPart segment1;
	public final ModelPart segment2;
	public final ModelPart segment3;
	public final ModelPart segment4;
	public final ModelPart segment5;
	public final ModelPart segment6;
	public final ModelPart segment7;
	public final ModelPart segment8;
	public final ModelPart core;
	public final ModelPart cannon;
	public final ModelPart lever;
	public final ModelPart tail;
	public final ModelPart lavaLauncherHead;
	public final ModelPart lavaLauncherLeftEar;
	public final ModelPart lavaLauncherRightEar;
	public final ModelPart headPlants;
	public final ModelPart piglin;
	public final ModelPart piglinBody;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart head;
	public final ModelPart piglinLeftEar;
	public final ModelPart piglinRightEar;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public LavaLauncherModel(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.leftFrontLeg = everything.getChild("leftFrontLeg");
		this.rightFrontLeg = everything.getChild("rightFrontLeg");
		this.leftBackLeg = everything.getChild("leftBackLeg");
		this.rightBackLeg = everything.getChild("rightBackLeg");
		this.lavaLauncherBody = everything.getChild("lavaLauncherBody");
		this.platform = lavaLauncherBody.getChild("platform");
		this.magmaCubeProjectile = platform.getChild("magmaCubeProjectile");
		this.segment1 = magmaCubeProjectile.getChild("segment1");
		this.segment2 = magmaCubeProjectile.getChild("segment2");
		this.segment3 = magmaCubeProjectile.getChild("segment3");
		this.segment4 = magmaCubeProjectile.getChild("segment4");
		this.segment5 = magmaCubeProjectile.getChild("segment5");
		this.segment6 = magmaCubeProjectile.getChild("segment6");
		this.segment7 = magmaCubeProjectile.getChild("segment7");
		this.segment8 = magmaCubeProjectile.getChild("segment8");
		this.core = magmaCubeProjectile.getChild("core");
		this.cannon = platform.getChild("cannon");
		this.lever = platform.getChild("lever");
		this.tail = lavaLauncherBody.getChild("tail");
		this.lavaLauncherHead = lavaLauncherBody.getChild("lavaLauncherHead");
		this.lavaLauncherLeftEar = lavaLauncherHead.getChild("lavaLauncherLeftEar");
		this.lavaLauncherRightEar = lavaLauncherHead.getChild("lavaLauncherRightEar");
		this.headPlants = lavaLauncherHead.getChild("headPlants");
		this.piglin = lavaLauncherBody.getChild("piglin");
		this.piglinBody = piglin.getChild("piglinBody");
		this.leftArm = piglinBody.getChild("leftArm");
		this.rightArm = piglinBody.getChild("rightArm");
		this.head = piglinBody.getChild("head");
		this.piglinLeftEar = head.getChild("piglinLeftEar");
		this.piglinRightEar = head.getChild("piglinRightEar");
		this.leftLeg = piglin.getChild("leftLeg");
		this.rightLeg = piglin.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftFrontLeg = everything.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(1, 311).addBox(-10.0F, 0.0F, -10.0F, 20.0F, 28.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(15.0F, -28.0F, -25.0F));

		PartDefinition rightFrontLeg = everything.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create(), PartPose.offset(-15.0F, -28.0F, -25.0F));

		PartDefinition rightFrontLeg_r1 = rightFrontLeg.addOrReplaceChild("rightFrontLeg_r1", CubeListBuilder.create().texOffs(244, 311).addBox(-10.0F, -4.0F, -10.0F, 20.0F, 28.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition leftBackLeg = everything.addOrReplaceChild("leftBackLeg", CubeListBuilder.create(), PartPose.offset(15.0F, -28.0F, 33.0F));

		PartDefinition leftBackLeg_r1 = leftBackLeg.addOrReplaceChild("leftBackLeg_r1", CubeListBuilder.create().texOffs(82, 311).addBox(-10.0F, -4.0F, -10.0F, 20.0F, 28.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition rightBackLeg = everything.addOrReplaceChild("rightBackLeg", CubeListBuilder.create(), PartPose.offset(-15.0F, -28.0F, 33.0F));

		PartDefinition rightBackLeg_r1 = rightBackLeg.addOrReplaceChild("rightBackLeg_r1", CubeListBuilder.create().texOffs(163, 311).addBox(-10.0F, -4.0F, -10.0F, 20.0F, 28.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition lavaLauncherBody = everything.addOrReplaceChild("lavaLauncherBody", CubeListBuilder.create().texOffs(0, 168).addBox(-29.0F, -52.0F, -44.5F, 58.0F, 52.0F, 90.0F, new CubeDeformation(0.0F))
		.texOffs(219, 54).addBox(29.0F, -38.0F, -14.5F, 16.0F, 28.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(298, 38).addBox(29.0F, -46.0F, 15.5F, 8.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(310, 75).addBox(-20.0F, -46.0F, 45.5F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(322, 96).addBox(-22.0F, -36.0F, 45.5F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, 3.5F));

		PartDefinition platform = lavaLauncherBody.addOrReplaceChild("platform", CubeListBuilder.create().texOffs(251, 301).addBox(-20.0F, -10.0F, -37.5F, 38.0F, 10.0F, 88.0F, new CubeDeformation(0.0F))
		.texOffs(242, 422).addBox(-20.0F, -40.0F, 42.5F, 38.0F, 30.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(242, 467).addBox(-20.0F, -43.0F, 42.5F, 24.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -52.0F, -7.0F));

		PartDefinition magmaCubeProjectile = platform.addOrReplaceChild("magmaCubeProjectile", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -25.0F, 30.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition segment1 = magmaCubeProjectile.addOrReplaceChild("segment1", CubeListBuilder.create().texOffs(344, 428).addBox(-20.0F, 14.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -26.0F, -8.0F));

		PartDefinition segment2 = magmaCubeProjectile.addOrReplaceChild("segment2", CubeListBuilder.create().texOffs(344, 431).addBox(-20.0F, 15.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -24.0F, -8.0F));

		PartDefinition segment3 = magmaCubeProjectile.addOrReplaceChild("segment3", CubeListBuilder.create().texOffs(416, 458).addBox(-20.0F, 16.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -22.0F, -8.0F));

		PartDefinition segment4 = magmaCubeProjectile.addOrReplaceChild("segment4", CubeListBuilder.create().texOffs(416, 485).addBox(-20.0F, 17.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -20.0F, -8.0F));

		PartDefinition segment5 = magmaCubeProjectile.addOrReplaceChild("segment5", CubeListBuilder.create().texOffs(344, 440).addBox(-20.0F, 18.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -18.0F, -8.0F));

		PartDefinition segment6 = magmaCubeProjectile.addOrReplaceChild("segment6", CubeListBuilder.create().texOffs(344, 443).addBox(-20.0F, 19.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -16.0F, -8.0F));

		PartDefinition segment7 = magmaCubeProjectile.addOrReplaceChild("segment7", CubeListBuilder.create().texOffs(344, 446).addBox(-20.0F, 20.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -14.0F, -8.0F));

		PartDefinition segment8 = magmaCubeProjectile.addOrReplaceChild("segment8", CubeListBuilder.create().texOffs(344, 449).addBox(-20.0F, 21.0F, -4.0F, 24.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -12.0F, -8.0F));

		PartDefinition core = magmaCubeProjectile.addOrReplaceChild("core", CubeListBuilder.create().texOffs(344, 476).addBox(-10.0F, 10.0F, -2.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -16.0F, -4.0F));

		PartDefinition cannon = platform.addOrReplaceChild("cannon", CubeListBuilder.create().texOffs(93, 375).addBox(-13.0F, -38.0F, -21.5F, 24.0F, 24.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(94, 435).addBox(-16.0F, -41.0F, -21.5F, 30.0F, 30.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 38.0F));

		PartDefinition lever = platform.addOrReplaceChild("lever", CubeListBuilder.create().texOffs(196, 444).addBox(0.0F, -3.0F, -0.5F, 14.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(206, 452).addBox(13.0F, -3.0F, 0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, -4.0F, 24.0F));

		PartDefinition tail = lavaLauncherBody.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -48.0F, 45.5F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(48, 123).addBox(-2.0F, -29.0F, -2.0F, 4.0F, 60.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.0F, 2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition lavaLauncherHead = lavaLauncherBody.addOrReplaceChild("lavaLauncherHead", CubeListBuilder.create().texOffs(289, 49).addBox(-20.0F, -24.0F, -50.0F, 40.0F, 24.0F, 62.0F, new CubeDeformation(0.0F))
		.texOffs(417, 243).addBox(-22.0F, -26.0F, 12.0F, 44.0F, 26.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(396, 161).addBox(-20.0F, -26.0F, 2.0F, 40.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(447, 206).addBox(20.0F, -26.0F, -18.0F, 2.0F, 6.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(410, 199).mirror().addBox(-22.0F, -26.0F, -18.0F, 2.0F, 6.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(484, 136).addBox(20.0F, -13.0F, 0.0F, 2.0F, 13.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(484, 136).mirror().addBox(-22.0F, -13.0F, 0.0F, 2.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(307, 143).addBox(-12.0F, -26.0F, -50.0F, 24.0F, 2.0F, 52.0F, new CubeDeformation(0.0F))
		.texOffs(333, 0).mirror().addBox(-27.0F, -40.0F, -38.0F, 7.0F, 40.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(364, 0).addBox(20.0F, -40.0F, -38.0F, 7.0F, 40.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(469, 34).mirror().addBox(12.0F, -40.0F, -38.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(432, 47).addBox(-12.0F, -31.0F, 6.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(432, 47).addBox(0.0F, -29.0F, -16.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(432, 47).addBox(-6.0F, -31.0F, -42.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(433, 47).addBox(-8.5F, -35.5F, -44.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.5F))
		.texOffs(433, 47).addBox(-14.5F, -35.5F, 4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.5F))
		.texOffs(462, 53).addBox(-1.1F, -33.0F, -17.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.0F, -44.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition lavaLauncherLeftEar = lavaLauncherHead.addOrReplaceChild("lavaLauncherLeftEar", CubeListBuilder.create(), PartPose.offset(20.0F, -16.5F, 10.0F));

		PartDefinition lavaLauncherLeftEar_r1 = lavaLauncherLeftEar.addOrReplaceChild("lavaLauncherLeftEar_r1", CubeListBuilder.create().texOffs(0, 147).mirror().addBox(-1.0F, -5.0F, -17.0F, 2.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.5F, 4.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition lavaLauncherRightEar = lavaLauncherHead.addOrReplaceChild("lavaLauncherRightEar", CubeListBuilder.create(), PartPose.offset(-20.0F, -16.5F, 10.0F));

		PartDefinition lavaLauncherRightEar_r1 = lavaLauncherRightEar.addOrReplaceChild("lavaLauncherRightEar_r1", CubeListBuilder.create().texOffs(0, 147).addBox(-1.0F, -5.0F, -14.0F, 2.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.5F, 1.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition headPlants = lavaLauncherHead.addOrReplaceChild("headPlants", CubeListBuilder.create().texOffs(303, 154).addBox(-6.0F, 0.0F, 0.0F, 13.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -24.0F, 14.0F));

		PartDefinition piglin = lavaLauncherBody.addOrReplaceChild("piglin", CubeListBuilder.create(), PartPose.offset(21.0F, -52.0F, 27.5F));

		PartDefinition piglinBody = piglin.addOrReplaceChild("piglinBody", CubeListBuilder.create().texOffs(398, 17).addBox(-4.0F, -9.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(398, 35).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition leftArm = piglinBody.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(438, 17).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -7.0F, 0.0F));

		PartDefinition rightArm = piglinBody.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(438, 17).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -7.0F, 0.0F));

		PartDefinition head = piglinBody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(398, 1).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(422, 30).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 6.0F, 8.0F, new CubeDeformation(0.25F))
		.texOffs(434, 10).addBox(-2.0F, -4.5F, -5.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition piglinLeftEar = head.addOrReplaceChild("piglinLeftEar", CubeListBuilder.create().texOffs(434, 1).mirror().addBox(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.5F, -6.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition piglinRightEar = head.addOrReplaceChild("piglinRightEar", CubeListBuilder.create().texOffs(434, 1).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -6.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftLeg = piglin.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(422, 17).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(446, 68).addBox(-2.0F, 0.3F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.245F)), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition rightLeg = piglin.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(422, 17).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(438, 78).addBox(-2.0F, 0.3F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.24F)), PartPose.offset(-2.0F, -7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}
	
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayWalkAnimation = speed > 0 && entity.attackAnimationTick <= 0 && entity.shootAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.attackAnimationTick <= 0 && entity.shootAnimationTick <= 0;	
		
		if (entity.piglinDeathTime > 0) {
			float f = ((float)entity.piglinDeathTime) / 20.0F * 1.6F;
			f = Mth.sqrt(f);
			if (f > 1.0F) {
				f = 1.0F;
			}

			this.piglin.zRot = MiscUtils.degToRad(f * 90);
		}
		
		if (entity.getPiglinHealth() <= 0 && entity.piglinDeathTime >= 20) {
			this.piglin.visible = false;
		} else {
			this.piglin.visible = true;
		}
	      
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.head.xRot = entity.piglinHeadXRot * ((float) Math.PI / 180F);
		this.head.yRot = entity.piglinHeadYRot * ((float) Math.PI / 180F);
		
		LavaLauncherSineWaveAnimations.lavaLauncherWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 12.5F, shouldPlayWalkAnimation ? 1 : 0);
		LavaLauncherSineWaveAnimations.lavaLauncherIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, LavaLauncherKeyframeAnimations.LAVA_LAUNCHER_ATTACK(entity), ageInTicks);
		this.animate(entity.shootAnimationState, LavaLauncherKeyframeAnimations.LAVA_LAUNCHER_SHOOT(entity), ageInTicks);
	}
	
	private void animateHeadLookTarget(float yRot, float xRot) {
		this.lavaLauncherHead.yRot = yRot * ((float) Math.PI / 180F);
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
		this.offsetEquipment(stack);
		this.root().translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.lavaLauncherBody.translateAndRotate(stack);
		this.piglin.translateAndRotate(stack);
		this.piglinBody.translateAndRotate(stack);
		this.getArm(arm).translateAndRotate(stack);
        stack.translate(arm == HumanoidArm.LEFT ? 1 / 16.0F : -1 / 16.0F, -3.25 / 16.0F, -1.5 / 16.0F);
	}

	@Override
	public void translateToHead(PoseStack stack) {
		this.offsetEquipment(stack);
		this.root().translateAndRotate(stack);
		this.everything.translateAndRotate(stack);
		this.lavaLauncherBody.translateAndRotate(stack);
		this.piglin.translateAndRotate(stack);
		this.piglinBody.translateAndRotate(stack);
		this.head.translateAndRotate(stack);
	}

	@Override
	public void translateArmour(ArmourModelPart modelPart, PoseStack stack, boolean innerModel) {
		switch (modelPart) {
			case HEAD:
				this.offsetEquipment(stack);
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.lavaLauncherBody.translateAndRotate(stack);
				this.piglin.translateAndRotate(stack);
				this.piglinBody.translateAndRotate(stack);
				this.head.translateAndRotate(stack);
				stack.scale(1.05F, 1.05F, 1.05F);
				break;
			case BODY:
				this.offsetEquipment(stack);
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.lavaLauncherBody.translateAndRotate(stack);
				this.piglin.translateAndRotate(stack);
				this.piglinBody.translateAndRotate(stack);
				stack.translate(0, -10.5 / 16.0F, 0);
				break;
			case RIGHT_ARM:
				this.offsetEquipment(stack);
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.lavaLauncherBody.translateAndRotate(stack);
				this.piglin.translateAndRotate(stack);
				this.piglinBody.translateAndRotate(stack);
				this.rightArm.translateAndRotate(stack);
				stack.translate(4 / 16.0F, -2 / 16.0F, 0);
				break;
			case LEFT_ARM:
				this.offsetEquipment(stack);
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.lavaLauncherBody.translateAndRotate(stack);
				this.piglin.translateAndRotate(stack);
				this.piglinBody.translateAndRotate(stack);
				this.leftArm.translateAndRotate(stack);
				stack.translate(-4 / 16.0F, -2 / 16.0F, 0);
				break;
			case RIGHT_LEG:
				this.offsetEquipment(stack);
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.lavaLauncherBody.translateAndRotate(stack);
				this.piglin.translateAndRotate(stack);
				this.rightLeg.translateAndRotate(stack);
				stack.translate(2 / 16.0F, -16 / 16.0F, 0);
				if (innerModel) {
					stack.scale(1, 0.58F, 1);
					stack.translate(0, 15 / 16.0F, 0);
				}
				break;
			case LEFT_LEG:
				this.offsetEquipment(stack);
				this.root().translateAndRotate(stack);
				this.everything.translateAndRotate(stack);
				this.lavaLauncherBody.translateAndRotate(stack);
				this.piglin.translateAndRotate(stack);
				this.leftLeg.translateAndRotate(stack);
				stack.translate(-2 / 16.0F, -16 / 16.0F, 0);
				if (innerModel) {
					stack.scale(1, 0.58F, 1);
					stack.translate(0, 15 / 16.0F, 0);
				}
				break;
		}
	}
	
	public void offsetEquipment(PoseStack stack) {
		//stack.translate(8 / 16.0F, 50 / 16.0F, 7 / 16.0F);
	}
}