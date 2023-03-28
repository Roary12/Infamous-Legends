package com.infamous.infamous_legends.network;

import java.util.function.Supplier;

import com.infamous.infamous_legends.events.ShakeCameraEvent;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class ServerToClientShakeCameraPacket {

    private final int duration;
    private final float amount;
    private final BlockPos causePos;
    private final int range;

    public ServerToClientShakeCameraPacket(int duration, float amount, BlockPos causePos, int range) {
        this.duration = duration;
        this.amount = amount;
        this.causePos = causePos;
        this.range = range;
    }

    public ServerToClientShakeCameraPacket(FriendlyByteBuf buf) {
    	duration = buf.readInt();
    	amount = buf.readFloat();
    	causePos = buf.readBlockPos();
    	range = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(duration);
        buf.writeFloat(amount);
        buf.writeBlockPos(causePos);
        buf.writeInt(range);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {        	
            ShakeCameraEvent.shake(null, this.duration, this.amount, this.causePos, this.range);
        });
        return true;
    }
}