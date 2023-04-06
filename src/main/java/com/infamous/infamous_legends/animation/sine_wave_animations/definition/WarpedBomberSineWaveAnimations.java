package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.BlazeRuntModel;
import com.infamous.infamous_legends.models.WarpedBomberModel;

public class WarpedBomberSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void warpedBomberIdleAnimation(WarpedBomberModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 75, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.0F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 5F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, 5F, 75, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, 1.5F, 75, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, -2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, 5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, 2.5F, 75, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine2, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, 5F, 75, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, 1.5F, 75, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 2.5F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -40.0269F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -1.9149F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1.6076F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 2.5F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -47.6809F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 1.528F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -5.3764F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, 5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, 2.5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 52.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 7.5F, 75, tick, -floatMax, floatMax, -300, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 5F, 75, tick, -floatMax, floatMax, -300, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root1, 82.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, 7.5F, 75, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, 5F, 75, tick, -floatMax, floatMax, -325, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -85F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, -7.5F, 75, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 5F, 75, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 87.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, 7.5F, 75, tick, -floatMax, floatMax, -325, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, 5F, 75, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root4, -95F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
	}
	
	public static void warpedBomberWalkAnimation(WarpedBomberModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 500, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -10F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.5F, 250, tick, -0, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.5F, 250, tick, -0, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -2.5F, 500, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, -5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, -3F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, -1.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, -2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, -5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, -5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine2, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, -4F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, -1.5F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 2.4892F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, -0.2774F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 4.992F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -37.4807F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 0.9564F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 2.3099F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -57.4753F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.1083F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -1.3439F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, -2.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, 2.5F, 500, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 52.5263F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, -1.5216F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 2.3099F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 2F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 1F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, -7.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 5F, 500, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root1, 82.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, -7.5F, 500, tick, -floatMax, floatMax, -275, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, 5F, 500, tick, -floatMax, floatMax, 50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -0.2187F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -4.9952F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -89.9905F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 7.5F, 500, tick, -floatMax, floatMax, -300, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 5F, 500, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 85F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, -7.5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, 5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root4, -95F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -2.5F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1.0F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 2.5F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -1.0F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
	public static void warpedBomberRunAnimation(WarpedBomberModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -5F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -10F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.0F, 250, tick, -0, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.0F, 250, tick, -0, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 10F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightEar, -20F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, -10F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftEar, 20F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, 7.5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 7.4907F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 0.434F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, -2.4621F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, 10F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine2, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, 7.5F, 500, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 7.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -7.5F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -195F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 2F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -7.5F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -190F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 2F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, -2.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 177.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, -4F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, -3.5F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 2.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root1, 42.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, -10F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, 17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -90F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 10F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, -17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 90F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, -15F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root4, -72.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 45F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -3.5F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -45F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 3.5F, 250, tick, -0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
}
