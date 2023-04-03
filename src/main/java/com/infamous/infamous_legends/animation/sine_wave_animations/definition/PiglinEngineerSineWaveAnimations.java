package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PiglinEngineerModel;

public class PiglinEngineerSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void piglinEngineerIdleAnimation(PiglinEngineerModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.5F, 100, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 12.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 2.5F, 100, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -12.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -2.5F, 100, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 2.5F, 100, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -1.5F, 100, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -47.1142F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 8.3735F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 5.6533F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 5F, 100, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -2.5F, 100, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -20F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -7.5F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -17.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -4.9992F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -2.2727F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.7083F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, 10F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -7.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bomb, -1F, SineWaveMotionTypes.SCALE_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bomb, -1F, SineWaveMotionTypes.SCALE_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bomb, -1F, SineWaveMotionTypes.SCALE_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.backpack, -7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.claw1, -0.25F, 50, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.helmetExtention, 2F, 100, tick, -floatMax, 0, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
	}
	
	public static void piglinEngineerWalkAnimation(PiglinEngineerModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -3.0F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 250, tick, -floatMax, floatMax, -0, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 20.0F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.25F, 250, tick, 0, floatMax, -25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.25F, 250, tick, 0, floatMax, -25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -5F, 500, tick, -floatMax, floatMax, 150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -15F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 5F, 500, tick, -floatMax, floatMax, 100, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, -5F, 500, tick, -floatMax, floatMax, 100, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -10F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -34.6593F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 14.2455F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 5.9628F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -33.7003F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -8.1178F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -15.2384F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -2.5F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 2.5F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -1F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.backpack, -3F, 250, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.backpack, -12.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.backpack, -1F, 250, tick, -0, floatMax, -75, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.backpack, -1F, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bomb, -1F, SineWaveMotionTypes.SCALE_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bomb, -1F, SineWaveMotionTypes.SCALE_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bomb, -1F, SineWaveMotionTypes.SCALE_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.claw1, -0.25F, 250, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.helmetExtention, -3F, 500, tick, -floatMax, 0, 125, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
	}
	
}
