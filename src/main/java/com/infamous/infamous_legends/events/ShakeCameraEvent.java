package com.infamous.infamous_legends.events;

import java.util.Random;

import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.network.Messages;
import com.infamous.infamous_legends.network.ServerToClientShakeCameraPacket;
import com.infamous.infamous_legends.utils.MiscUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent.ComputeCameraAngles;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfamousLegends.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShakeCameraEvent {

	public Random random = new Random();

	public static NonNullList<CameraShakeHandler> cameraShakes = NonNullList.create();

	@SubscribeEvent
	public static void cameraShake(ComputeCameraAngles event) {


		for (int i = 0; i < cameraShakes.size(); i++) {
			CameraShakeHandler handler = cameraShakes.get(i);

				Entity cameraEntity = Minecraft.getInstance().cameraEntity;
					
				if (handler != null) {
					if (handler.time <= 0) {
						cameraShakes.remove(handler);
					}
	
					if (handler.time > 0) {
						handler.time--;
					}
	
					if (cameraEntity != null) {
						if (handler.time > 0
								&& MiscUtils.distanceToBlockPos(cameraEntity, handler.causePosition) <= handler.range) {
							shakeCamera(event, cameraEntity, handler.amount * (float)((float)handler.time / (float)handler.duration));
						}
					}
				}
			}
	}

	public static void shake(Level level, int duration, float amount, BlockPos causePosition, int range) {
		if (level == null || level.isClientSide) {
			cameraShakes.add(0, new CameraShakeHandler(amount, duration, duration, causePosition, range));
		}
			
		if (level != null && !level.isClientSide) {
			for (Player player : level.players()) {
				if (player instanceof ServerPlayer) {
					Messages.sendToPlayer(new ServerToClientShakeCameraPacket(duration, amount, causePosition, range), ((ServerPlayer)player));
				}
			}
		}
	}

	public static void shakeCamera(ComputeCameraAngles event, Entity cameraEntity, float amount) {
		float delta = Minecraft.getInstance().getDeltaFrameTime();
		float ticksExistedDelta = (float) cameraEntity.tickCount + delta;
		float finalAmount = amount;
		event.setPitch((float) ((double) event.getPitch()
				+ (double) finalAmount * Math.cos((double) (ticksExistedDelta * 3.0F + 2.0F)) * 25.0D));
		event.setYaw((float) ((double) event.getYaw()
				+ (double) finalAmount * Math.cos((double) (ticksExistedDelta * 5.0F + 1.0F)) * 25.0D));
		event.setRoll((float) ((double) event.getRoll()
				+ (double) finalAmount * Math.cos((double) (ticksExistedDelta * 4.0F)) * 25.0D));
	}

	public static class CameraShakeHandler {

		public float amount;
		public int duration;
		public int time;
		public BlockPos causePosition;
		public int range;
		
		public CameraShakeHandler(float amount, int duration, int time, BlockPos causePosition, int range) {
			this.amount = amount;
			this.duration = duration;
			this.time = duration;
			this.causePosition = causePosition;
			this.range = range;
		}
	}
}