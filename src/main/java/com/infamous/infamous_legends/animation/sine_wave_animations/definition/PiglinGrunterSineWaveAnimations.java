package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PiglinGrunterModel;

public class PiglinGrunterSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void piglinGrunterIdleAnimation(PiglinGrunterModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 125, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 5, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 3.5F, 125, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -5, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 2.5F, 125, tick, -floatMax, floatMax, -300, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, -2.5F, 125, tick, -floatMax, floatMax, -300, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 5F, 125, tick, -floatMax, floatMax, 125, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -2.5F, 125, tick, -floatMax, floatMax, 175, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -2.4968F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 0.1468F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 9.9957F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 5F, 125, tick, -floatMax, floatMax, 100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 5F, 125, tick, -floatMax, floatMax, 150, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -7.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.4976F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -0.109F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.4976F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -4.9953F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -0.2178F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.4905F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
	}
	
	public static void piglinGrunterWalkAnimation(PiglinGrunterModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -3.5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 250, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 250, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1F, 250, tick, 0, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1F, 250, tick, 0, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -1, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -4F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 1.5F, 250, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -8F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 5F, 500, tick, -floatMax, floatMax, -300, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -5F, 500, tick, -floatMax, floatMax, -300, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -40F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 40F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 30F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -1.5F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -30F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 1.5F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
	}
	
}
