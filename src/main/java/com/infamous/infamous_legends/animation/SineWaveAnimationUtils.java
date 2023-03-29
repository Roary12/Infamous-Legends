package com.infamous.infamous_legends.animation;

import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SineWaveAnimationUtils {

	public static void addSineWaveMotionToModelPart(ModelPart modelPart, float amount, float speed, float tick, float min, float max, float offset, float speedMultiplier, SineWaveMotionTypes motionType, boolean shouldPlay) {
		float motion = shouldPlay ? Mth.cos(tick * (speedMultiplier + speed) + MiscUtils.degToRad(offset)) * MiscUtils.degToRad(amount) : 0;
		
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
	
	public static float getTick(Entity entity) {
		return MiscUtils.degToRad((entity.tickCount + Minecraft.getInstance().getFrameTime())) / 20;
	}
	
}
