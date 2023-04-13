package com.infamous.infamous_legends.animation.keyframe_animations.definition;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.entities.GrindstoneGolem;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GrindstoneGolemKeyframeAnimations {

	private static float floatMax = Float.MAX_VALUE;

public static AnimationDefinition GRINDSTONE_GOLEM_ATTACK(GrindstoneGolem entity) {
	return AnimationDefinition.Builder.withLength(3.3433335f).addAnimation("everything",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, 6f, -1f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.5834334f, KeyframeAnimations.posVec(0f, 7f, -1f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, -6.5f, -1f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(0.9583434f, KeyframeAnimations.posVec(0f, -4.500000000000002f, -1f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(1.0834333f, KeyframeAnimations.posVec(0f, -5 + SineWaveAnimationUtils.getSineWaveKeyframe(-0.75F, 2000, SineWaveAnimationUtils.getTick(entity.tickCount, true), -0.5F, floatMax, 0), -1f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(2.75f, KeyframeAnimations.posVec(0f, -5 + SineWaveAnimationUtils.getSineWaveKeyframe(-0.75F, 2000, SineWaveAnimationUtils.getTick(entity.tickCount, true), -0.5F, floatMax, 0), -1f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(3f, KeyframeAnimations.posVec(0f, 7f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(3.25f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.CATMULLROM), 
		new Keyframe(3.3433335f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("body",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.125f, KeyframeAnimations.posVec(0f, -3.5f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, -3.5f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 1f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("body",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.625f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.2083433f, KeyframeAnimations.degreeVec(SineWaveAnimationUtils.getConstantMotionKeyframe(750, SineWaveAnimationUtils.getTick(entity.rollAnimationLength + -entity.rollAnimationTick, false)) - 650f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.75f, KeyframeAnimations.degreeVec(SineWaveAnimationUtils.getConstantMotionKeyframe(750, SineWaveAnimationUtils.getTick(entity.rollAnimationLength + -entity.rollAnimationTick, false)) - 650f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.7916765f, KeyframeAnimations.degreeVec(-100f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(3.3433335f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("leftArm",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, -3f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5416766f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 4f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("leftArm",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(-270f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-270f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(-270 + SineWaveAnimationUtils.getSineWaveKeyframe(-5F, 2000, SineWaveAnimationUtils.getTick(entity.tickCount, true), -floatMax, floatMax, -50), 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.5f, KeyframeAnimations.degreeVec(-270 + SineWaveAnimationUtils.getSineWaveKeyframe(-5F, 2000, SineWaveAnimationUtils.getTick(entity.tickCount, true), -floatMax, floatMax, -50), 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.875f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(3.1676665f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("rightArm",
	new AnimationChannel(AnimationChannel.Targets.POSITION, 
		new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, -3f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.5416766f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, 4f, 0f),
			AnimationChannel.Interpolations.LINEAR), 
		new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR)))
.addAnimation("rightArm",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.75f, KeyframeAnimations.degreeVec(-270f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(0.9167666f, KeyframeAnimations.degreeVec(-270f, 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(-270 + SineWaveAnimationUtils.getSineWaveKeyframe(-5F, 2000, SineWaveAnimationUtils.getTick(entity.tickCount, true), -floatMax, floatMax, -50), 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.5f, KeyframeAnimations.degreeVec(-270 + SineWaveAnimationUtils.getSineWaveKeyframe(-5F, 2000, SineWaveAnimationUtils.getTick(entity.tickCount, true), -floatMax, floatMax, -50), 0f, 0f),
			AnimationChannel.Interpolations.LINEAR),
		new Keyframe(2.875f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(3.1676665f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM))).build();
}

}