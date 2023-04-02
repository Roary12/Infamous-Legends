package com.infamous.infamous_legends.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.infamous.infamous_legends.entities.ThrownBlazeRod;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

@Mixin(Item.class)
public class ItemMixin {

	@Inject(at = @At("HEAD"), method = "getUseAnimation", cancellable = true)
	public void infamous_legends_changeBlazeRodUseAnimationToSpear(ItemStack stack, CallbackInfoReturnable<UseAnim> callback) {
		if (stack.getItem() == Items.BLAZE_ROD) {
			callback.setReturnValue(UseAnim.SPEAR);
		}
	}
	
	@Inject(at = @At("HEAD"), method = "getUseDuration", cancellable = true)
	public void infamous_legends_extendBlazeRodUseDuration(ItemStack stack, CallbackInfoReturnable<Integer> callback) {
		if (stack.getItem() == Items.BLAZE_ROD) {
			callback.setReturnValue(72000);
		}
	}

	@Inject(at = @At("HEAD"), method = "releaseUsing", cancellable = true)
	public void infamous_legends_throwBlazeRodAfterUsed(ItemStack stack, Level level, LivingEntity user, int usingFor, CallbackInfo callback) {
		if (stack.getItem() == Items.BLAZE_ROD) {
			if (user instanceof Player player) {
				int i = 72000 - usingFor;
				if (i >= 10) {
					if (!level.isClientSide) {
						ThrownBlazeRod thrownBlazeRod = new ThrownBlazeRod(level, player);
						thrownBlazeRod.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.0F, 1.5F);
	
						level.addFreshEntity(thrownBlazeRod);
						level.playSound((Player) null, thrownBlazeRod, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS,
								1.0F, 1.0F);
						if (!player.getAbilities().instabuild) {
							stack.shrink(1);
						}
					}
	
					player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
	
				}
			}
		}
	}

	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(Level level, Player user, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> callback) {
		ItemStack itemstack = user.getItemInHand(hand);
		if (itemstack.getItem() == Items.BLAZE_ROD) {
			user.startUsingItem(hand);
			callback.setReturnValue(InteractionResultHolder.consume(itemstack));
		}
	}
}
