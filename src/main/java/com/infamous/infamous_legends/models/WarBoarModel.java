package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.WarBoarKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.WarBoarSineWaveAnimations;
import com.infamous.infamous_legends.entities.WarBoar;

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


public class WarBoarModel<T extends WarBoar> extends HierarchicalModel<T> {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart leftFrontLeg;
	public final ModelPart rightFrontLeg;
	public final ModelPart leftBackLeg;
	public final ModelPart rightBackLeg;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart leftEar;
	public final ModelPart rightEar;
	public final ModelPart tail;

	public WarBoarModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.leftFrontLeg = everything.getChild("leftFrontLeg");
		this.rightFrontLeg = everything.getChild("rightFrontLeg");
		this.leftBackLeg = everything.getChild("leftBackLeg");
		this.rightBackLeg = everything.getChild("rightBackLeg");
		this.body = everything.getChild("body");
		this.head = body.getChild("head");
		this.leftEar = head.getChild("leftEar");
		this.rightEar = head.getChild("rightEar");
		this.tail = body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftFrontLeg = everything.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -2.0F, -3.5F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.5F, -12.0F, -10.5F));

		PartDefinition rightFrontLeg = everything.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -2.0F, -3.5F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -12.0F, -10.5F));

		PartDefinition leftBackLeg = everything.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(56, 50).mirror().addBox(-3.5F, -1.0F, -3.5F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.5F, -12.0F, 10.5F));

		PartDefinition rightBackLeg = everything.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(56, 50).mirror().addBox(-3.5F, -1.0F, -3.5F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -12.0F, 10.5F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -18.0F, -15.0F, 18.0F, 18.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(0.0F, -36.0F, -15.0F, 0.0F, 18.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -1.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 50).addBox(-8.0F, -8.0F, -20.0F, 16.0F, 8.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(8.0F, -15.0F, -15.0F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 26).addBox(6.0F, -15.0F, -15.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(-10.0F, -15.0F, -15.0F, 2.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 26).addBox(-8.0F, -15.0F, -15.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -15.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leftEar = head.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(9, 21).addBox(0.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -3.8981F, 0.848F, -1.5708F, 0.9599F, 0.0F));

		PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(9, 21).addBox(-6.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -4.1481F, 0.848F, -1.5708F, -0.9599F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 50).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 17.0F));

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
		
		this.animateHeadLookTarget(netHeadYaw);
		WarBoarSineWaveAnimations.warBoarRunAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 20, shouldPlayRunAnimation ? 1 : 0);
		WarBoarSineWaveAnimations.warBoarWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 15, shouldPlayWalkAnimation ? 1 : 0);
		WarBoarSineWaveAnimations.warBoarIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, WarBoarKeyframeAnimations.WAR_BOAR_ATTACK, ageInTicks);
	}
	
	private void animateHeadLookTarget(float yRot) {
		this.head.yRot = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}