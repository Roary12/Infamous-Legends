package com.infamous.infamous_legends.animation;

import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class SineWaveAnimationUtils {

	public static void addSineWaveMotionToModelPart(ModelPart modelPart, float amount, float speed, float partialTick, float min, float max, float offset, float speedMultiplier, SineWaveMotionTypes motionType, boolean shouldPlay) {
		float motion = shouldPlay ? Mth.cos(partialTick * MiscUtils.degToRad(speed)) * MiscUtils.degToRad(amount) : 0;
		
		switch(motionType) {
			case ROTATION_X: {
				modelPart.xRot += motion;
				break;
			}		
			case ROTATION_Y: {
				modelPart.yRot += motion;
				break;
			}	
			case ROTATION_Z: {
				modelPart.zRot += motion;
				break;
			}	
			
			case POSITION_X: {
				modelPart.x += motion;
				break;
			}	
			case POSITION_Y: {
				modelPart.y += motion;
				break;
			}	
			case POSITION_Z: {
				modelPart.z += motion;
				break;
			}	
			
			case SCALE_X: {
				modelPart.xScale += motion;
				break;
			}	
			case SCALE_Y: {
				modelPart.yScale += motion;
				break;
			}	
			case SCALE_Z: {
				modelPart.zScale += motion;
				break;
			}	
		}
	}
	
}
