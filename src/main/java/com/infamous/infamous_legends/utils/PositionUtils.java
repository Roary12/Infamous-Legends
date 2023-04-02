package com.infamous.infamous_legends.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PositionUtils {

	public static Vec3 getOffsetPos(Entity entity, double offsetX, double offsetY, double offsetZ, float rotation) {
        Vec3 Vec3 = (new Vec3(offsetZ, offsetY, offsetX).yRot(-rotation * ((float)Math.PI / 180F) - ((float)Math.PI / 2F)));
        return entity.position().add(Vec3.x, Vec3.y, Vec3.z);
	}
	
	public static BlockPos getOffsetBlockPos(Entity entity, double offsetX, double offsetY, double offsetZ, float rotation) {
        Vec3 Vec3 = (new Vec3(offsetZ, offsetY, offsetX).yRot(-rotation * ((float)Math.PI / 180F) - ((float)Math.PI / 2F)));
        return entity.blockPosition().offset(Vec3.x, Vec3.y, Vec3.z);
	}
	
	public static Vec3 getOffsetMotion(Entity entity, double offsetX, double offsetY, double offsetZ, float rotation) {
        Vec3 Vec3 = (new Vec3(offsetZ, offsetY, offsetX).yRot(-rotation * ((float)Math.PI / 180F) - ((float)Math.PI / 2F)));
        return Vec3;
	}
	
	public static void moveToCorrectHeight(Entity entity) {
		BlockPos blockpos = entity.blockPosition();	
        boolean flag = false;
        double d0 = 0.0D;

        do {
           BlockPos blockpos1 = blockpos.below();
           BlockState blockstate = entity.level.getBlockState(blockpos1);
           if (blockstate.isFaceSturdy(entity.level, blockpos1, Direction.UP)) {
              if (!entity.level.isEmptyBlock(blockpos)) {
                 BlockState blockstate1 = entity.level.getBlockState(blockpos);
                 VoxelShape voxelshape = blockstate1.getCollisionShape(entity.level, blockpos);
                 if (!voxelshape.isEmpty()) {
                    d0 = voxelshape.max(Direction.Axis.Y);
                 }
              }

              flag = true;
              break;
           }

           blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(blockpos.getY()) - 1);

        if (flag) {
        	entity.setPos(blockpos.getX(), blockpos.getY() + d0, blockpos.getZ());
        }
	}
	
	   public static boolean hasLineOfSight(Entity entitySearching, Vec3 targetPos) {
		         Vec3 vec3 = new Vec3(entitySearching.getX(), entitySearching.getEyeY(), entitySearching.getZ());
		         Vec3 vec31 = new Vec3(targetPos.x, targetPos.y, targetPos.z);
		         if (vec31.distanceTo(vec3) > 128.0D) {
		            return false;
		         } else {
		            return entitySearching.level.clip(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entitySearching)).getType() == HitResult.Type.MISS;
		         }
		   }
}
