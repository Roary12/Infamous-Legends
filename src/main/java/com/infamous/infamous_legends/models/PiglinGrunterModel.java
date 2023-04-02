package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.keyframe_animations.definition.PiglinGrunterKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.PiglinGrunterSineWaveAnimations;
import com.infamous.infamous_legends.entities.PiglinGrunter;

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


public class PiglinGrunterModel<T extends PiglinGrunter> extends HierarchicalModel<T> {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart rightHand;
	public final ModelPart head;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;
	
	public PiglinGrunterModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = this.everything.getChild("body");
		this.head = this.body.getChild("head");
		this.leftEar = this.head.getChild("leftEar");
		this.rightEar = this.head.getChild("rightEar");
		this.leftArm = this.body.getChild("leftArm");
		this.rightArm = this.body.getChild("rightArm");
		this.rightHand = this.rightArm.getChild("rightHand");
		this.leftLeg = this.everything.getChild("leftLeg");
		this.rightLeg = this.everything.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 16).addBox(-4.0F, -9.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-4.0F, -3.15F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(24, 30).mirror().addBox(0.0F, -1.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -8.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 30).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -8.0F, 0.0F));

		PartDefinition rightHand = rightArm.addOrReplaceChild("rightHand", CubeListBuilder.create(), PartPose.offset(-2.0F, 7.5F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 9).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 4).mirror().addBox(-0.5F, 3.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.5F, -6.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(36, 0).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-1.5F, 3.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -6.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(37, 48).addBox(-2.0F, 0.15F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.24F)), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 37).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(17, 48).addBox(-2.0F, 0.15F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.24F)), PartPose.offset(-2.0F, -7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayWalkAnimation = speed > 0 && entity.throwAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.throwAnimationTick <= 0;	
		
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		PiglinGrunterSineWaveAnimations.piglinGrunterWalkAnimation(this, SineWaveAnimationUtils.getTick(entity), speed * 17, shouldPlayWalkAnimation);
		PiglinGrunterSineWaveAnimations.piglinGrunterIdleAnimation(this, SineWaveAnimationUtils.getTick(entity), 1, shouldPlayIdleAnimation);
		this.animate(entity.throwAnimationState, PiglinGrunterKeyframeAnimations.GRUNTER_THROW, ageInTicks);
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