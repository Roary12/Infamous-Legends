package com.infamous.infamous_legends.animation.sine_wave_animations.definition;

import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveAnimationUtils;
import com.infamous.infamous_legends.animation.sine_wave_animations.SineWaveMotionTypes;
import com.infamous.infamous_legends.models.PortalGuardModel;

public class PortalGuardSineWaveAnimations {

	private static float floatMax = Float.MAX_VALUE;
	
	public static void portalGuardIdleAnimation(PortalGuardModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 1.5F, 50, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, 2.5F, 50, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLower, -17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLower, -0.6F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 3.5F, 50, tick, -floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -15F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -5F, 50, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, 5F, 50, tick, -floatMax, floatMax, -200, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -1.5F, 50, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 0.25F, 50, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -3.2772F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -10.5712F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 19.5175F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -0.25F, 50, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 0.75F, 50, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 4F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piston, -10F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -7.5F, 50, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -2.5F, 50, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -15.0895F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -9.4043F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -12.3942F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -1F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
	public static void portalGuardWalkAnimation(PortalGuardModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -1.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -3F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 20F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, -2.5F, 250, tick, 0, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 2.5F, 250, tick, 0, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, 1.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, -2.5F, 250, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, -3F, 250, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLower, -20F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -2.5F, 500, tick,- floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 0.5F, 250, tick,- floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, -1.5F, 250, tick,- floatMax, floatMax, -150, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 7.5F, 500, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftEar, -7.5F, 500, tick, -floatMax, floatMax, -175, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 1.5F, 500, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -1.5F, 1000, tick, -0, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -2.5F, 250, tick, -0, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 2.5F, 250, tick, -0, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 26.3094F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -3.4016F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1.2683F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 0.5F, 250, tick, -floatMax, floatMax, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 0.5F, 1000, tick, -0, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, 2.5F, 250, tick, -floatMax, 0, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -2.5F, 250, tick, -floatMax, 0, -0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -1F, amountMultiplier, SineWaveMotionTypes.POSITION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -3F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 3F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.piston, -10F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 25F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, 5F, 250, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -17.85F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -9.0747F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -14.9315F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLowerRight, 15F, 250, tick, -floatMax, floatMax, -35, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLowerRight, -2.5F, 250, tick, -floatMax, floatMax, -35, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLowerLeft, -15F, 250, tick, -floatMax, floatMax, -35, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLowerLeft, 2.5F, 250, tick, -floatMax, floatMax, -35, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 30F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, -4F, 250, tick, 0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightLeg, 2.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -30F, 250, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, 4F, 250, tick, 0, floatMax, 25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftLeg, -2.5F, 250, tick, -floatMax, floatMax, -50, speedMultiplier, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
	}
	
	public static void portalGuardIdleShootingAnimation(PortalGuardModel model, float tick, float speedMultiplier, float amountMultiplier) {
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.body, 0.5F, 50, tick, -floatMax, floatMax, 0, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 1.4494F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, 19.7371F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.body, -2.8973F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.bodyOverlayLower, -0.75F, 50, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLower, -17.5F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLower, -0.6F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerRight, 4.1953F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerRight, -14.8323F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerRight, 14.6156F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerRight, -2F, amountMultiplier, SineWaveMotionTypes.POSITION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerRight, -1F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerRight, -1F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerLeft, 28.7167F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerLeft, -9.4791F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.bodyOverlayLowerLeft, -0.6752F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 0.1091F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 2.4976F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, 10.0024F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -3F, amountMultiplier, SineWaveMotionTypes.POSITION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightLeg, -0.5F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.head, 1.25F, 50, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 3.3219F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, -14.7671F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.head, 3.5986F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, -2.5F, 50, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightEar, 2.5F, 50, tick, -floatMax, floatMax, -250, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.rightArm, -0.5F, 50, tick, -floatMax, floatMax, -25, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -86.56F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -21.07F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, 1.94F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -1F, amountMultiplier, SineWaveMotionTypes.POSITION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -1F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.rightArm, -3F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -7.5F, 50, tick, -floatMax, floatMax, -100, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.addSineWaveMotionToModelPart(model.leftArm, -2.5F, 50, tick, -floatMax, floatMax, -75, speedMultiplier, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -15.0895F, amountMultiplier, SineWaveMotionTypes.ROTATION_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -9.4043F, amountMultiplier, SineWaveMotionTypes.ROTATION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -12.3942F, amountMultiplier, SineWaveMotionTypes.ROTATION_Z);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -2F, amountMultiplier, SineWaveMotionTypes.POSITION_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.leftArm, -1F, amountMultiplier, SineWaveMotionTypes.POSITION_Z);
		
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.ball, -1F, amountMultiplier, SineWaveMotionTypes.SCALE_X);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.ball, -1F, amountMultiplier, SineWaveMotionTypes.SCALE_Y);
		SineWaveAnimationUtils.adjustPositionOfModelPart(model.ball, -1F, amountMultiplier, SineWaveMotionTypes.SCALE_Z);
	}
	
}
