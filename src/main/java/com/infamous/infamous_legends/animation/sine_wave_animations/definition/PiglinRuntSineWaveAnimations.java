package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PiglinRuntModel;

public class PiglinRuntSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void piglinRuntIdleAnimation(PiglinRuntModel model, float partialTick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.body.xRot += 25.6187;
		model.body.yRot += -14.2008;
		model.body.zRot += -4.8114;
		
		model.rightLeg.xRot += 12.5;
		model.rightLeg.zRot += 7.5;
		
		model.leftLeg.zRot += -10;
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 2.5F, 150, partialTick, floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.head.xRot += -22.6852;
		model.head.yRot += 15.3038;
		model.head.zRot += -1.8076;
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -2.5F, 150, partialTick, floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 2.5F, 150, partialTick, floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -1.0F, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.rightArm.xRot += -46.5424;
		model.rightArm.yRot += -25.7047;
		model.rightArm.zRot += -18.6055;
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -1.0F, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.leftArm.xRot += -40.8858;
		model.leftArm.yRot += 26.6684;
		model.leftArm.zRot += 27.4022;
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightHand, -1.0F, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		model.rightHand.xRot += 56.75;
		model.rightHand.yRot += -33.0855;
		model.rightHand.zRot += -2.3738;
	}
}
