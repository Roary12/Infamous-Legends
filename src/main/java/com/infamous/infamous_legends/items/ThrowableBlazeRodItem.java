package com.infamous.infamous_legends.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.infamous.infamous_legends.entities.ThrownBlazeRod;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ThrowableBlazeRodItem extends Item implements Vanishable {
   private final Multimap<Attribute, AttributeModifier> defaultModifiers;

   public ThrowableBlazeRodItem(Item.Properties p_43381_) {
      super(p_43381_);
      ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
      builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 3.0D, AttributeModifier.Operation.ADDITION));
      builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-2.2F, AttributeModifier.Operation.ADDITION));
      this.defaultModifiers = builder.build();
   }

   public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
      return !p_43412_.isCreative();
   }

   public UseAnim getUseAnimation(ItemStack p_43417_) {
      return UseAnim.SPEAR;
   }

   public int getUseDuration(ItemStack p_43419_) {
      return 72000;
   }

	public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
		if (p_43396_ instanceof Player player) {
			int i = this.getUseDuration(p_43394_) - p_43397_;
			if (i >= 10) {
				if (!p_43395_.isClientSide) {
					ThrownBlazeRod thrownBlazeRod = new ThrownBlazeRod(p_43395_, player);
					thrownBlazeRod.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F,
							2.0F, 1.5F);

					p_43395_.addFreshEntity(thrownBlazeRod);
					p_43395_.playSound((Player) null, thrownBlazeRod, SoundEvents.SNOWBALL_THROW, SoundSource.PLAYERS,
							1.0F, 1.0F);
					if (!player.getAbilities().instabuild) {
						p_43394_.shrink(1);
					}
				}

				player.awardStat(Stats.ITEM_USED.get(this));

			}
		}
	}

   public InteractionResultHolder<ItemStack> use(Level p_43405_, Player p_43406_, InteractionHand p_43407_) {
      ItemStack itemstack = p_43406_.getItemInHand(p_43407_);
		p_43406_.startUsingItem(p_43407_);
		return InteractionResultHolder.consume(itemstack);
   }

   public boolean hurtEnemy(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
	  p_43391_.setSecondsOnFire(2);  
      return true;
   }

   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43383_) {
      return p_43383_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43383_);
   }
}