package com.infamous.infamous_legends.models;

import com.infamous.infamous_legends.animation.keyframe_animations.definition.PlankGolemKeyframeAnimations;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.definition.PlankGolemSineWaveAnimations;
import com.infamous.infamous_legends.entities.PlankGolem;
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


public class PlankGolemModel<T extends PlankGolem> extends HierarchicalModel<T> implements CustomHeadedModel, ArmourWearingModel {
	private final ModelPart root;
	public final ModelPart everything;
	public final ModelPart body;
	public final ModelPart nose;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;
	public final ModelPart arrows;
	public final ModelPart arrow1;
	public final ModelPart arrow2;
	public final ModelPart arrow3;
	public final ModelPart arrow4;
	public final ModelPart arrow5;
	public final ModelPart arrow6;
	public final ModelPart arrow7;
	public final ModelPart arrow8;
	public final ModelPart arrow9;

	public PlankGolemModel(ModelPart root) {
		super(RenderType::entityTranslucent);
		this.root = root;
		this.everything = root.getChild("everything");
		this.body = everything.getChild("body");
		this.nose = body.getChild("nose");
		this.leftLeg = everything.getChild("leftLeg");
		this.rightLeg = everything.getChild("rightLeg");
		this.arrows = body.getChild("arrows");
		this.arrow1 = arrows.getChild("arrow1");
		this.arrow2 = arrows.getChild("arrow2");
		this.arrow3 = arrows.getChild("arrow3");
		this.arrow4 = arrows.getChild("arrow4");
		this.arrow5 = arrows.getChild("arrow5");
		this.arrow6 = arrows.getChild("arrow6");
		this.arrow7 = arrows.getChild("arrow7");
		this.arrow8 = arrows.getChild("arrow8");
		this.arrow9 = arrows.getChild("arrow9");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(66, 0).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition nose = body.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -8.0F));

		PartDefinition arrows = body.addOrReplaceChild("arrows", CubeListBuilder.create(), PartPose.offset(0.5F, -2.0F, 0.5F));

		PartDefinition arrow1 = arrows.addOrReplaceChild("arrow1", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -10.0F, -3.5F));

		PartDefinition arrow2 = arrows.addOrReplaceChild("arrow2", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -10.0F, -3.5F));

		PartDefinition arrow3 = arrows.addOrReplaceChild("arrow3", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -10.0F, -3.5F));

		PartDefinition arrow4 = arrows.addOrReplaceChild("arrow4", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -10.0F, -0.5F));

		PartDefinition arrow5 = arrows.addOrReplaceChild("arrow5", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -10.0F, -0.5F));

		PartDefinition arrow6 = arrows.addOrReplaceChild("arrow6", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -10.0F, -0.5F));

		PartDefinition arrow7 = arrows.addOrReplaceChild("arrow7", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -10.0F, 2.5F));

		PartDefinition arrow8 = arrows.addOrReplaceChild("arrow8", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -10.0F, 2.5F));

		PartDefinition arrow9 = arrows.addOrReplaceChild("arrow9", CubeListBuilder.create().texOffs(65, 21).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 19).addBox(-1.0F, -13.0F, 0.0F, 2.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(74, 17).addBox(0.0F, -13.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -10.0F, 2.5F));

		PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.6F, -2.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.6F, -5.0F, 0.0F));

		PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.6F, -2.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.4F, -5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		
		Vec3 velocity = entity.getDeltaMovement();
		float speed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));				

		boolean shouldPlayWalkAnimation = speed > 0 && entity.shootAnimationTick <= 0;
		
		boolean shouldPlayIdleAnimation = !shouldPlayWalkAnimation && entity.shootAnimationTick <= 0;	
		
		PlankGolemSineWaveAnimations.plankGolemWalkAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), speed * 7.5F, shouldPlayWalkAnimation ? 1 : 0);
		PlankGolemSineWaveAnimations.plankGolemIdleAnimation(this, SineWaveAnimationUtils.getTick(entity.tickCount, true), 1, shouldPlayIdleAnimation ? 1 : 0);
		this.animate(entity.shootAnimationState, PlankGolemKeyframeAnimations.PLANK_GOLEM_SHOOT, ageInTicks);
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
	}

	@Override
	public void translateArmour(ArmourModelPart modelPart, PoseStack stack, boolean innerModel) {
		switch (modelPart) {
		case HEAD:
			stack.scale(0, 0, 0);
			break;
		case BODY:
			stack.scale(0, 0, 0);
			break;
		case RIGHT_ARM:
			stack.scale(0, 0, 0);
			break;
		case LEFT_ARM:
			stack.scale(0, 0, 0);
			break;
		case RIGHT_LEG:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.rightLeg.translateAndRotate(stack);
			stack.translate(2.25F / 16.0F, -13 / 16.0F, 0);
			if (innerModel) {
				stack.scale(1.25F, 0.5F, 1.25F);
				stack.translate(0, 11 / 16.0F, 0);
			} else {
				stack.scale(1, 0.75F, 1.1F);
			}
			break;
		case LEFT_LEG:
			this.root().translateAndRotate(stack);
			this.everything.translateAndRotate(stack);
			this.leftLeg.translateAndRotate(stack);
			stack.translate(-2.25F / 16.0F, -13 / 16.0F, 0);
			if (innerModel) {
				stack.scale(1.25F, 0.5F, 1.25F);
				stack.translate(0, 11 / 16.0F, 0);
			} else {
				stack.scale(1, 0.75F, 1.1F);
			}
			break;
		}
	}
}