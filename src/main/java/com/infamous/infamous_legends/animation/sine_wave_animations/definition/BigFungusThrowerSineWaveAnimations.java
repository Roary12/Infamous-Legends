package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.BigFungusThrowerModel;
import com.infamous.infamous_legends.models.PiglinBruiserModel;

public class BigFungusThrowerSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void bigFungusThrowerIdleAnimation(BigFungusThrowerModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2F, 75, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.1F, 1000, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 15, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 2.5F, 75, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.1F, 1000, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -15, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightEar, -5, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftEar, 5, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.noseFoliage, 5F, 75, tick, -floatMax, 0, -300, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -7.5F, 75, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 2.5F, 75, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -14.7416F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 2.6885F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 9.6065F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -5F, 75, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -2.5F, 75, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -14.9299F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -1.7082F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -4.6999F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, -2F, 75, tick, -floatMax, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, -0.1F, 1000, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLower, -15, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
	}
	
	public static void bigFungusThrowerWalkAnimation(BigFungusThrowerModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 500, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 5F, 250, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.25F, 2000, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 20, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2F, 250, tick, -0, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2F, 250, tick, -0, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 5F, 500, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 3.5F, 250, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.25F, 2000, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -20, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -7.5F, 500, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightEar, -2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 7.5F, 500, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.noseFoliage, 12.5F, 500, tick, -floatMax, 0, -325, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.noseFoliage, -7.5F, 250, tick, -floatMax, 0, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 7.5F, 250, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -20F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 10F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 15F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 7.5F, 250, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -20F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -10F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, 10F, 250, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, 0.25F, 2000, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLowerRight, 15F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerRight, -20, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLowerLeft, -15F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerLeft, -20, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -3F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 3F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -1.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
}
