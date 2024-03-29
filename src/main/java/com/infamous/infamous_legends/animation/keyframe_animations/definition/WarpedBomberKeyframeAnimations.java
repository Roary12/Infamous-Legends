package com.infamous.infamous_legends.animation.keyframe_animations.definition;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WarpedBomberKeyframeAnimations {

	public static final AnimationDefinition WARPED_BOMBER_ATTACK = AnimationDefinition.Builder.withLength(0.375f)
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftArm",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 2f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leftArm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-190f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-210f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-87.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-87.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightArm",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 2f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightArm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-195f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-210f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-87.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-87.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("fungusBomb", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0f, KeyframeAnimations.posVec(0f, -4f, -3.5f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.16766666f, KeyframeAnimations.posVec(0f, 0f, -4.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2916767f, KeyframeAnimations.posVec(0f, -11f, -13.5f),
							AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.375f, KeyframeAnimations.posVec(0f, -11f, -13.5f),
							AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("fungusBomb",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(177.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(135f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(157.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(157.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("fungusBomb",
					new AnimationChannel(AnimationChannel.Targets.SCALE,
							new Keyframe(0.20834334f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.scaleVec(0.9f, 0.9f, 0.9f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.2916767f, KeyframeAnimations.scaleVec(1.1f, 1.1f, 1.1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.scaleVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("root1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(85f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(105f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(90f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("root2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 17.5f, -90f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f,
									KeyframeAnimations.degreeVec(59.61361864742548f, 69.92228515681472f,
											-28.84340836807405f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f,
									KeyframeAnimations.degreeVec(6.230390953054993f, 9.835998975775894f,
											-91.78638324452717f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("root3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -17.5f, 90f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, -70f, 90f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(0f, -15f, 90f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("root4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-72.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-80f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("vine1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(7.5f, 0f, 2.5f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(40f, 0f, 2.5f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(14.36f, 0f, 2.5f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(14.36f, 0f, 2.5f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("vine2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(29.439999999999998f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(29.439999999999998f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("vine3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(7.4907f, 0.43398685644888246f, -2.4620664797216705f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(37.49f, 0.43f, -2.46f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(19.989999999999995f, 0.43f, -2.46f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375f, KeyframeAnimations.degreeVec(19.989999999999995f, 0.43f, -2.46f),
							AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftEar", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125f, KeyframeAnimations.degreeVec(-35f, 0f, 20f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(46.81471710018741f, 9.1823f, 11.4819f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(19.42696980314531f, -5.4299f, 14.8817f),
							AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375f, KeyframeAnimations.degreeVec(19.42696980314531f, -5.4299f, 14.8817f),
							AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("rightEar",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-35f, 0f, -20f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.25f,
									KeyframeAnimations.degreeVec(46.81471710018741f, -9.182287895700028f,
											-11.48185707210996f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.3433333f,
									KeyframeAnimations.degreeVec(19.42696980314531f, 5.429918974605698f,
											-14.881659927311375f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.375f,
									KeyframeAnimations.degreeVec(19.42696980314531f, 5.429918974605698f,
											-14.881659927311375f),
									AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leftLeg",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leftLeg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightLeg",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("rightLeg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f,
							KeyframeAnimations.degreeVec(0f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR)))
			.build();

}