package com.infamous.infamous_legends.network;

import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {

    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

	public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(InfamousLegends.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ServerToClientShakeCameraPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        .decoder(ServerToClientShakeCameraPacket::new)
        .encoder(ServerToClientShakeCameraPacket::toBytes)
        .consumerNetworkThread(ServerToClientShakeCameraPacket::handle)
        .add();

    }

    public static <MSG> void sendToServer(MSG message) {
    	if (Minecraft.getInstance().getConnection() != null) {
    		INSTANCE.sendToServer(message);
    	}
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}