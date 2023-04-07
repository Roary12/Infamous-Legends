package com.infamous.infamous_legends.utils;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.infamous.infamous_legends.explosions.CustomExplosion;
import com.infamous.infamous_legends.init.TagInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class MiscUtils {

	public static Random random = new Random();

	public static final Predicate<Entity> ALIVE = (p_213685_0_) -> {
		return p_213685_0_.isAlive();
	};

	public static <T extends Entity> List<T> getNearbyNonLivingEntities(Class<T> entityClass, Level level,
			Entity entityNear, AABB boundingBox) {
		List<T> list = level.getEntitiesOfClass(entityClass, boundingBox, (p_186450_) -> {
			return true;
		});

		return list;
	}

	public static void maybeDisableShield(Mob mob, Player p_21425_, ItemStack p_21426_, ItemStack p_21427_) {
		if (!p_21426_.isEmpty() && !p_21427_.isEmpty() && p_21426_.getItem() instanceof AxeItem
				&& p_21427_.is(Items.SHIELD)) {
			float f = 0.25F + (float) EnchantmentHelper.getBlockEfficiency(mob) * 0.05F;
			if (random.nextFloat() < f) {
				p_21425_.getCooldowns().addCooldown(Items.SHIELD, 100);
				p_21425_.stopUsingItem();
				mob.level.broadcastEntityEvent(p_21425_, (byte) 30);
			}
		}
	}

	public static boolean isHolding(LivingEntity livingEntity, Item item) {
		return livingEntity.getMainHandItem().getItem() == item || livingEntity.getOffhandItem().getItem() == item;
	}

	public static void disableShield(LivingEntity livingEntity, int ticks) {
		if (livingEntity instanceof Player && livingEntity.isBlocking()) {
			((Player) livingEntity).getCooldowns()
					.addCooldown(livingEntity.getItemInHand(livingEntity.getUsedItemHand()).getItem(), ticks);
			livingEntity.stopUsingItem();
			livingEntity.level.broadcastEntityEvent(livingEntity, (byte) 30);
		}
	}

	public static boolean randomPercent(int chance) {
		int randomInt = random.nextInt(100);

		return randomInt < chance;
	}

	public static float distanceToBlockPos(Entity mob, BlockPos pos) {
		float f = (float) (mob.getX() - pos.getX());
		float f1 = (float) (mob.getY() - pos.getY());
		float f2 = (float) (mob.getZ() - pos.getZ());
		return Mth.sqrt(f * f + f1 * f1 + f2 * f2);
	}

	public static float radToDeg(float rad) {
		return rad * (180 / Mth.PI);	
	}
	
	public static float degToRad(float deg) {
		return deg * (Mth.PI / 180);	
	}
		   
	public static float randomSoundPitch() {
		return (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F;
	}
	
	public static Explosion customExplosion(Level level, Entity explodingEntity, DamageSource damageSource,
			ExplosionDamageCalculator damageCalculator, double x, double y, double z, float explosionSize,
			boolean createsFire, BlockInteraction blockInteraction, SoundEvent explosionSound,
			SoundSource explosionSoundSource, ParticleOptions explosionParticle,
			ParticleOptions secondaryExplosionParticle, float entityDamage,
			boolean friendlyFire) {
		CustomExplosion explosion = new CustomExplosion(level, explodingEntity, damageSource, damageCalculator, x, y, z,
				explosionSize, createsFire, blockInteraction, explosionSound, explosionSoundSource, explosionParticle,
				secondaryExplosionParticle, entityDamage, friendlyFire);
		explosion.explode();
		explosion.finalizeExplosion(true);
		return explosion;
	}
	
	public static boolean piglinAllies(Entity piglin, Entity target) {
		if (target.getTeam() == null && piglin.getTeam() == null && target.getType().is(TagInit.EntityTypes.PIGLIN_ALLIES)) {
			return true;
		} else if (piglin.getTeam() != null && target.getTeam() != null && piglin.getTeam() == target.getTeam()) {
			return true;
		} else {
			return false;
		}
	}
}
