package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PiglinRuntModel;
import com.infamous.infamous_legends.utils.MiscUtils;

public class PiglinRuntSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void piglinRuntIdleAnimation(PiglinRuntModel model, float partialTick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.body.xRot += MiscUtils.degToRad(25.6187F);
		model.body.yRot += MiscUtils.degToRad(-14.2008F);
		model.body.zRot += MiscUtils.degToRad(-4.8114F);
		
		model.rightLeg.xRot += MiscUtils.degToRad(12.5F);
		model.rightLeg.zRot += MiscUtils.degToRad(7.5F);
		
		model.leftLeg.zRot += MiscUtils.degToRad(-10F);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 2.5F, 150, partialTick, floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.head.xRot += MiscUtils.degToRad(-22.6852F);
		model.head.yRot += MiscUtils.degToRad(15.3038F);
		model.head.zRot += MiscUtils.degToRad(-1.8076F);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -2.5F, 150, partialTick, floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 2.5F, 150, partialTick, floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -1.0F, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.rightArm.xRot += MiscUtils.degToRad(-46.5424F);
		model.rightArm.yRot += MiscUtils.degToRad(-25.7047F);
		model.rightArm.zRot += MiscUtils.degToRad(-18.6055F);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -1.0F, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		model.leftArm.xRot += MiscUtils.degToRad(-40.8858F);
		model.leftArm.yRot += MiscUtils.degToRad(26.6684F);
		model.leftArm.zRot += MiscUtils.degToRad(27.4022F);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightHand, -1.0F, 150, partialTick, floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		model.rightHand.xRot += MiscUtils.degToRad(56.75F);
		model.rightHand.yRot += MiscUtils.degToRad(-33.0855F);
		model.rightHand.zRot += MiscUtils.degToRad(-2.3738F);
	}
}
