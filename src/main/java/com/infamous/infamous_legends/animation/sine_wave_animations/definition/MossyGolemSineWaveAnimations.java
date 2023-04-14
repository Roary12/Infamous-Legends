package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.MossyGolemModel;

public class MossyGolemSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void mossyGolemIdleAnimation(MossyGolemModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -0.5F, 150, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.25F, 150, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -1F, 150, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -0.5F, 150, tick, -floatMax, floatMax, 50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.25F, 150, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -2, 150, tick, -floatMax, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 2, 150, tick, -floatMax, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
	}
	
	public static void mossyGolemWalkAnimation(MossyGolemModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 5F, 250, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 250, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.25F, 250, tick, -0, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.25F, 250, tick, -0, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -1.5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -5F, 250, tick, -floatMax, floatMax, -125, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 1.25F, 250, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.5F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -30, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 30, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 20, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -2, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -20, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 2, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -1, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
	public static void mossyGolemRunAnimation(MossyGolemModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 1000, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2F, 1000, tick, -1.25F, floatMax, 50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 7.5F, 1000, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 1.5F, 1000, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 1F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -30, 500, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 0.0945F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 2.4976F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 4.3329F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 0.5F, 1000, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 30, 500, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 0.0945F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.4976F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -4.3329F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -0.5F, 1000, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 30, 500, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -2.5F, 500, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -30, 500, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 2.5F, 500, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -1.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
	public static void mossyGolemShootAnimation(MossyGolemModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -0.5F, 300, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.125F, 300, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addConstantMotionToModelPart(model.head, -175, tick, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -3F, 500, tick, -floatMax, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -2.5F, 1000, tick, -floatMax, floatMax, 100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -2F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 120F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -3F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -120F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 1F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 3F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
}
