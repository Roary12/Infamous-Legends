package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.keyframe_animations.definition.PiglinEngineerKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.PiglinEngineerSineWaveAnimations;
import com.infamous.infamous_legends.entities.PiglinEngineer;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class PiglinEngineerModel<T extends PiglinEngineer> extends HierarchicalModel<T> {
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
	public final ModelPart backpack;
	public final ModelPart hatch;
	public final ModelPart flame;
	public final ModelPart claw1;
	public final ModelPart claw2;
	public final ModelPart bomb;
	public final ModelPart fuse;
	public final ModelPart spark;
	public final ModelPart helmetExtention;
	public final ModelPart helmetExtentionRotation;

	public PiglinEngineerModel(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = everything.getChild("body");
		this.leftArm = body.getChild("leftArm");
		this.rightArm = body.getChild("rightArm");
		this.head = body.getChild("head");
		this.leftEar = head.getChild("leftEar");
		this.rightEar = head.getChild("rightEar");
		this.leftLeg = everything.getChild("leftLeg");
		this.rightLeg = everything.getChild("rightLeg");
		this.backpack = body.getChild("backpack");
		this.hatch = backpack.getChild("hatch");
		this.flame = leftArm.getChild("flame");
		this.claw1 = rightArm.getChild("claw1");
		this.claw2 = rightArm.getChild("claw2");
		this.bomb = rightArm.getChild("bomb");
		this.fuse = bomb.getChild("fuse");
		this.spark = fuse.getChild("spark");
		this.helmetExtention = head.getChild("helmetExtention");
		this.helmetExtentionRotation = helmetExtention.getChild("helmetExtentionRotation");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(44, 43).addBox(-4.0F, -10.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-4.0F, -10.2F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.245F))
		.texOffs(40, 22).addBox(-2.0F, -6.75F, -3.25F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition backpack = body.addOrReplaceChild("backpack", CubeListBuilder.create().texOffs(62, 98).addBox(-10.0F, -7.0F, 0.0F, 20.0F, 14.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 70).addBox(8.0F, -21.0F, 2.0F, 4.0F, 22.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 72).addBox(8.0F, -21.0F, 6.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(54, 0).addBox(-5.0F, -3.0F, 8.0F, 10.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 2.0F));

		PartDefinition hatch = backpack.addOrReplaceChild("hatch", CubeListBuilder.create().texOffs(52, 79).addBox(-2.0F, -6.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 1.0F, 4.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(57, 56).mirror().addBox(0.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(58, 10).addBox(0.0F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(4.0F, -8.0F, 0.0F));

		PartDefinition flame = leftArm.addOrReplaceChild("flame", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 8.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition flame_r1 = flame.addOrReplaceChild("flame_r1", CubeListBuilder.create().texOffs(10, 21).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition flame_r2 = flame.addOrReplaceChild("flame_r2", CubeListBuilder.create().texOffs(10, 21).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(57, 56).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 44).addBox(-4.0F, 2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-4.0F, -8.0F, 0.0F));

		PartDefinition claw1 = rightArm.addOrReplaceChild("claw1", CubeListBuilder.create().texOffs(85, 8).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(104, 11).addBox(-1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 9.0F, -3.0F));

		PartDefinition claw2 = rightArm.addOrReplaceChild("claw2", CubeListBuilder.create().texOffs(104, 11).addBox(-1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.5F, -3.0F));

		PartDefinition rightArm_r1 = claw2.addOrReplaceChild("rightArm_r1", CubeListBuilder.create().texOffs(85, 8).addBox(-1.0F, -1.0F, -4.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition bomb = rightArm.addOrReplaceChild("bomb", CubeListBuilder.create().texOffs(27, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(23, 106).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(10, 100).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.0F, 10.1F, 4.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition fuse = bomb.addOrReplaceChild("fuse", CubeListBuilder.create().texOffs(42, 89).addBox(-0.5F, -2.8F, -0.1F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.2F, 0.0F));

		PartDefinition spark = fuse.addOrReplaceChild("spark", CubeListBuilder.create(), PartPose.offset(0.0F, -1.4F, 0.0F));

		PartDefinition spark_r1 = spark.addOrReplaceChild("spark_r1", CubeListBuilder.create().texOffs(28, 85).addBox(-1.5F, -3.0F, -0.1F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition spark_r2 = spark.addOrReplaceChild("spark_r2", CubeListBuilder.create().texOffs(28, 85).addBox(-1.5F, -3.0F, -0.1F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 27).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(68, 47).addBox(-2.0F, -4.5F, -5.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(91, 60).addBox(-1.5F, -12.25F, -0.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(107, 61).addBox(-1.5F, -12.25F, 4.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(91, 29).addBox(-3.0F, -16.25F, -4.5F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(76, 69).addBox(-5.5F, -9.0F, -4.5F, 11.0F, 6.0F, 9.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition helmetExtention = head.addOrReplaceChild("helmetExtention", CubeListBuilder.create().texOffs(78, 41).addBox(-1.5F, -2.275F, -11.9F, 3.0F, 7.0F, 12.0F, new CubeDeformation(-0.06F))
		.texOffs(106, 46).addBox(-1.5F, -1.175F, -9.7F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.07F))
		.texOffs(106, 46).addBox(-1.5F, 0.225F, -10.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.07F)), PartPose.offset(0.0F, -14.0F, -2.6F));

		PartDefinition helmetExtentionRotation = helmetExtention.addOrReplaceChild("helmetExtentionRotation", CubeListBuilder.create().texOffs(75, 62).addBox(-1.5F, 1.225F, 0.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 1.0F, -12.9F, 0.9338F, 0.0F, 0.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(40, 66).addBox(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -5.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(40, 66).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -5.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(12, 59).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(29, 115).addBox(-1.8F, 0.15F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.24F)), PartPose.offset(2.0F, -5.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(12, 59).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 115).addBox(-2.1F, 0.15F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.235F)), PartPose.offset(-2.0F, -5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayWalkAnimation = speed > 0 && entity.throwAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.throwAnimationTick <= 0;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		PiglinEngineerSineWaveAnimations.piglinEngineerWalkAnimation(this, SineWaveAnimationUtils.getTick(entity), speed * 17, shouldPlayWalkAnimation);
		PiglinEngineerSineWaveAnimations.piglinEngineerIdleAnimation(this, SineWaveAnimationUtils.getTick(entity), 1, shouldPlayIdleAnimation);
		this.animate(entity.throwAnimationState, PiglinEngineerKeyframeAnimations.ENGINEER_THROW, ageInTicks);
	}
	
	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.xRot = xRot * ((float) Math.PI / 180F);
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}