package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.LavaLauncherModel;

public class LavaLauncherSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void lavaLauncherIdleAnimation(LavaLauncherModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, 0.5F, 75, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, 0.5F, 75, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.lavaLauncherBody, -2, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherHead, 1.5F, 75, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.lavaLauncherHead, -12.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherHead, -0.5F, 75, tick, -floatMax, floatMax, -350, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherRightEar, -7.5F, 75, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherLeftEar, 7.5F, 75, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.headPlants, 5F, 75, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.headPlants, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, -2.5F, 75, tick, -0, floatMax, 40, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, 5F, 37.5F, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 5, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.piglinBody, 2.5F, 75, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piglinBody, 12.4825F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piglinBody, 3.1306F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piglinBody, -4.632F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -2.5F, 75, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -17.4375F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1.5018F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 44.7697F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -7.5F, 75, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 2.5F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -11.9681F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.7398F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -19.811F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 2.5F, 75, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -9.9929F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 0.3262F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 2.4786F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.piglinRightEar, -5F, 75, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.piglinLeftEar, 5F, 75, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
	}
	
	public static void lavaLauncherWalkAnimation(LavaLauncherModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, -1.5F, 200, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, -1.5F, 200, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, -2.5F, 200, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.lavaLauncherBody, 1.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, -2.5F, 200, tick, -0.5F, floatMax, 60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, 2.5F, 200, tick, -0.5F, floatMax, 60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.lavaLauncherBody, -3, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherHead, 2.5F, 200, tick, -floatMax, floatMax, -60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherHead, 2.5F, 200, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.lavaLauncherHead, -7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, -1.5F, 200, tick, -0.5F, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherBody, 1.5F, 200, tick, -0.5F, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherRightEar, 5F, 400, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.lavaLauncherLeftEar, -5F, 400, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.headPlants, 7.5F, 200, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.headPlants, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, 2.5F, 400, tick, -0, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.tail, -15F, 200, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 5, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.piglinBody, 5F, 200, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piglinBody, 30.5041F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piglinBody, 14.4775F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piglinBody, 3.9671F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -5F, 200, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -47.0634F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 6.7372F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 39.907F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 0.75F, 200, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 0.75F, 200, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -15F, 200, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -0.9688F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -18.1538F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -20.6153F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -7.5F, 200, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -27.1817F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -15.6015F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 2.4842F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.piglinRightEar, 7.5F, 400, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.piglinLeftEar, -7.5F, 400, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		//SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.everything, 15F, 200, tick, -2F, 0, -115, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);	
		//SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.everything, 2.5F, 200, tick, -0.5F, floatMax, 60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFrontLeg, -10F, 200, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFrontLeg, -5F, 200, tick, -0, floatMax, 60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftFrontLeg, -2.5F, 200, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFrontLeg, 10F, 200, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFrontLeg, 5F, 200, tick, -0, floatMax, 60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightFrontLeg, 2.5F, 200, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightBackLeg, -10F, 200, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightBackLeg, -5F, 200, tick, -0, floatMax, 60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightBackLeg, -2.5F, 200, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftBackLeg, 10F, 200, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftBackLeg, 5F, 200, tick, -0, floatMax, 60, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftBackLeg, 2.5F, 200, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
}
