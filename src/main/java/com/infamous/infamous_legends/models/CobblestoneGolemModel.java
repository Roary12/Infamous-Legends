package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.CobblestoneGolemKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.CobblestoneGolemSineWaveAnimations;
import com.infamous.infamous_legends.entities.CobblestoneGolem;

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


public class CobblestoneGolemModel<T extends CobblestoneGolem> extends HierarchicalModel<T> {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart nose;
	public final ModelPart leftArm;
	public final ModelPart rightArm;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;

	public CobblestoneGolemModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = everything.getChild("body");
		this.nose = body.getChild("nose");
		this.leftArm = body.getChild("leftArm");
		this.rightArm = body.getChild("rightArm");
		this.leftLeg = everything.getChild("leftLeg");
		this.rightLeg = everything.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition nose = body.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, -8.0F));

		PartDefinition leftArm = body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(57, 0).addBox(0.0F, -3.0F, -4.0F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(86, 0).addBox(3.0F, 9.0F, -4.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -8.0F, 0.0F));

		PartDefinition rightArm = body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(57, 21).addBox(-6.0F, -3.0F, -4.0F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(86, 21).addBox(-6.0F, 9.0F, -4.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -8.0F, 0.0F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(36, 29).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 1.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(15, 29).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				
		
		boolean shouldPlayRunAnimation = speed > 0.125 && entity.attackAnimationTick <= 0;
		
		boolean shouldPlayWalkAnimation = !shouldPlayRunAnimation && speed > 0 && entity.attackAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && !shouldPlayRunAnimation && entity.attackAnimationTick <= 0;	
		
		CobblestoneGolemSineWaveAnimations.cobblestoneGolemRunAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 15, shouldPlayRunAnimation ? 1 : 0);
		CobblestoneGolemSineWaveAnimations.cobblestoneGolemWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 15, shouldPlayWalkAnimation ? 1 : 0);
		CobblestoneGolemSineWaveAnimations.cobblestoneGolemIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.attackAnimationState, CobblestoneGolemKeyframeAnimations.COBBLESTONE_GOLEM_ATTACK, ageInTicks);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}