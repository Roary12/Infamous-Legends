package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PiglinRuntModel;
import com.infamous.infamous_legends.utils.MiscUtils;

public class PiglinRuntSineWaveAnimations {

	private static float floatMax = 360;
	
	public static void piglinRuntIdleAnimation(PiglinRuntModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1, 150, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 25.6187F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -14.2008F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -4.8114F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 12.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 7.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -10F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 2.5F, 150, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -22.6852F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 15.3038F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -1.8076F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -2.5F, 150, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 2.5F, 150, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -1.0F, 150, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -46.5424F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -25.7047F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -18.6055F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -1.0F, 150, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -40.8858F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 26.6684F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 27.4022F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightHand, -1.0F, 150, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, 56.75F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, -33.0855F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, -2.3738F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
	}
	
	public static void piglinRuntWalkAnimation(PiglinRuntModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 23.7877F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -18.4203F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -7.9294F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.5F, 250, tick, 0, floatMax, 0, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -0.5F, 250, tick, 0, floatMax, 0, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -2.5F, 500, tick,- floatMax, floatMax, -175, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -20.8162F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 20.5876F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 0.363F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 5.0F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -5.0F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -2.5F, 500, tick, -floatMax, floatMax, -175, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -35.8085F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 16.2701F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 11.792F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -0.8F, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 1.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -35.3286F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -22.6699F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -33.9085F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1F, SineWaveMotionTypes.POSITION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -2F, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightHand, 1.5F, 1000, tick, -floatMax, 0, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightHand, 0.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, 169.1457F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, -27.1932F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, -125.7744F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, 1.5F, SineWaveMotionTypes.POSITION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, -3F, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightHand, 2F, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -1.5F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 0.75F, 250, tick, 0, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 1.5F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -0.75F, 250, tick, 0, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
	}
	
	public static void piglinRuntRunAnimation(PiglinRuntModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 7.5F, 50, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -15F, 12.5F, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -10F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.5F, 500, tick, -0.25F, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -7.5F, 50, tick, -floatMax, floatMax, -125, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 15F, 12.5F, tick, -floatMax, floatMax, -125, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -12.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -7.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 7.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 2.5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -15F, 12.5F, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -82.7057F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -22.4774F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1.0351F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -2F, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 2.5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -15F, 12.5F, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -64.1254F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 48.2028F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 24.0239F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2F, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 20F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -1F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -20F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 1F, 250, tick, 0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
	}
	
}
