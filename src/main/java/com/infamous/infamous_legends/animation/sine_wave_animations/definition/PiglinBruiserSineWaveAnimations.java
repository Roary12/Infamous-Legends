package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PiglinBruiserModel;

public class PiglinBruiserSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void piglinBruiserIdleAnimation(PiglinBruiserModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.5F, 100, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 5, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -2.5F, 100, tick, -floatMax, floatMax, 50, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -3.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -5F, 100, tick, -floatMax, floatMax, 125, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightEar, -2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 5F, 100, tick, -floatMax, floatMax, 125, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftEar, 2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -3F, 100, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -2F, 100, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -2.4905F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 0.2178F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 19.9953F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -3F, 100, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 2F, 100, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.4905F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -0.2178F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -19.9953F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -2.5002F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.6066F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.3886F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -5F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
	}
	
	public static void piglinBruiserWalkAnimation(PiglinBruiserModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 5F, 500, tick, -floatMax, floatMax, 50, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 5F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 10, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.25F, 500, tick, -1, floatMax, -25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -5F, 500, tick, -floatMax, floatMax, 100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -1.25F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -10, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -7.5F, 500, tick, -floatMax, floatMax, 50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 7.5F, 500, tick, -floatMax, floatMax, 50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -45F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -2.2596F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 5.8428F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 19.7105F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 45F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.2596F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -5.8428F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -19.7105F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 30F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -0.0222F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -1.142F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.2241F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -2F, 250, tick, -0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -30F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, 0.0222F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, 1.142F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.2241F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 2F, 250, tick, -0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -1.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
	}
	
}
