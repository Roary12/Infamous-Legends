package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PiglinGrunterModel;
import com.infamous.infamous_legends.models.WarpedBomberModel;

public class WarpedBomberSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void warpedBomberIdleAnimation(WarpedBomberModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 75, tick, -floatMax, floatMax, 0, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.0F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 5F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, 5F, 75, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, 1.5F, 75, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, -2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, 5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, 2.5F, 75, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine2, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, 5F, 75, tick, -floatMax, floatMax, -175, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, 1.5F, 75, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 2.5F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -40.0269F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -1.9149F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1.6076F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 2.5F, 75, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -47.6809F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 1.528F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -5.3764F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, 5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, 2.5F, 75, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 52.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 7.5F, 75, tick, -floatMax, floatMax, -300, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 5F, 75, tick, -floatMax, floatMax, -300, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root1, 82.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, 7.5F, 75, tick, -floatMax, floatMax, -275, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, 5F, 75, tick, -floatMax, floatMax, -325, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -5F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -85F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, -7.5F, 75, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 5F, 75, tick, -floatMax, floatMax, -275, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 2.5F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 87.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, 7.5F, 75, tick, -floatMax, floatMax, -325, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, 5F, 75, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root4, -95F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
	}
	
	public static void warpedBomberWalkAnimation(WarpedBomberModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 500, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -10F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.5F, 250, tick, -0, floatMax, -25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.5F, 250, tick, -0, floatMax, -25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -2.5F, 500, tick, -floatMax, floatMax, -175, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, -5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, -3F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, -1.5F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, -2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, -5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, -5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine2, 2.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, -4F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, -1.5F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 2.4892F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, -0.2774F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 4.992F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -37.4807F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 0.9564F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 2.3099F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -57.4753F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2.1083F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -1.3439F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, -2.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, 2.5F, 500, tick, -floatMax, floatMax, -275, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 52.5263F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, -1.5216F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 2.3099F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 2F, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 1F, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, -7.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 5F, 500, tick, -floatMax, floatMax, -0, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root1, 82.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, -7.5F, 500, tick, -floatMax, floatMax, -275, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, 5F, 500, tick, -floatMax, floatMax, 50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -0.2187F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -4.9952F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -89.9905F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 7.5F, 500, tick, -floatMax, floatMax, -300, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 5F, 500, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 2.5F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 85F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, -7.5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, 5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root4, -95F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -2.5F, 250, tick, -0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 1.0F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -25F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 2.5F, 250, tick, -0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -1.0F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
	}
	
	public static void warpedBomberRunAnimation(WarpedBomberModel model, float tick, float speedMultiplier, boolean shouldPlay) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -5F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -10F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.0F, 250, tick, -0, floatMax, -25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.0F, 250, tick, -0, floatMax, -25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -5F, 500, tick, -floatMax, floatMax, -150, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 10F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightEar, -20F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, -10F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftEar, 20F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine3, 7.5F, 500, tick, -floatMax, floatMax, -225, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 7.4907F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, 0.434F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine3, -2.4621F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine2, 10F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine2, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.vine1, 7.5F, 500, tick, -floatMax, floatMax, -175, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 7.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.vine1, 2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -7.5F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -195F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 2F, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -7.5F, 500, tick, -floatMax, floatMax, -200, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -190F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, 2F, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.fungusBomb, -2.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, 177.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, -4F, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.fungusBomb, -3.5F, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root1, 2.5F, 500, tick, -floatMax, floatMax, -250, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root1, 42.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root2, -10F, 500, tick, -floatMax, floatMax, -100, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, 17.5F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root2, -90F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root3, 10F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, -17.5F, SineWaveMotionTypes.ROTATION_Y, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root3, 90F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.root4, -15F, 500, tick, -floatMax, floatMax, -75, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.root4, -72.5F, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 45F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -3.5F, 250, tick, -0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -45F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, SineWaveMotionTypes.ROTATION_X, shouldPlay);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftLeg, -2.5F, SineWaveMotionTypes.ROTATION_Z, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 3.5F, 250, tick, -0, floatMax, 25, speedMultiplier, SineWaveMotionTypes.POSITION_Y, shouldPlay);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -0.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, SineWaveMotionTypes.POSITION_Z, shouldPlay);
	}
}
