package com.infamous.infamous_legends.init;

import java.util.Set;

import com.google.common.collect.Sets;
import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModelLayerInit {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation MACE_RUNT = register("piglin_runt");
    public static final ModelLayerLocation MACE_RUNT_INNER_ARMOUR = register("mace_runt_inner_armour");
    public static final ModelLayerLocation MACE_RUNT_OUTER_ARMOUR = register("mace_runt_outer_armour");
    public static final ModelLayerLocation BLAZE_RUNT = register("blaze_runt");
    public static final ModelLayerLocation BLAZE_RUNT_INNER_ARMOUR = register("blaze_runt_inner_armour");
    public static final ModelLayerLocation BLAZE_RUNT_OUTER_ARMOUR = register("blaze_runt_outer_armour");
    public static final ModelLayerLocation SPORE_MEDIC = register("spore_medic");
    public static final ModelLayerLocation SPORE_MEDIC_INNER_ARMOUR = register("spore_medic_inner_armour");
    public static final ModelLayerLocation SPORE_MEDIC_OUTER_ARMOUR = register("spore_medic_outer_armour");
    public static final ModelLayerLocation PIGLIN_BRUISER = register("piglin_bruiser");
    public static final ModelLayerLocation PIGLIN_BRUISER_INNER_ARMOUR = register("piglin_bruiser_inner_armour");
    public static final ModelLayerLocation PIGLIN_BRUISER_OUTER_ARMOUR = register("piglin_bruiser_outer_armour");
    public static final ModelLayerLocation WAR_BOAR = register("war_boar");
    public static final ModelLayerLocation PIGLIN_ENGINEER = register("piglin_engineer");
    public static final ModelLayerLocation PIGLIN_ENGINEER_INNER_ARMOUR = register("piglin_engineer_inner_armour");
    public static final ModelLayerLocation PIGLIN_ENGINEER_OUTER_ARMOUR = register("piglin_engineer_outer_armour");
    public static final ModelLayerLocation WARPED_BOMBER = register("warped_bomber");
    public static final ModelLayerLocation WARPED_BOMBER_INNER_ARMOUR = register("warped_bomber_inner_armour");
    public static final ModelLayerLocation WARPED_BOMBER_OUTER_ARMOUR = register("warped_bomber_outer_armour");
    public static final ModelLayerLocation BIG_FUNGUS_THROWER = register("big_fungus_thrower");
    public static final ModelLayerLocation BIG_FUNGUS_THROWER_INNER_ARMOUR = register("big_fungus_thrower_inner_armour");
    public static final ModelLayerLocation BIG_FUNGUS_THROWER_OUTER_ARMOUR = register("big_fungus_thrower_outer_armour");
    public static final ModelLayerLocation LAVA_LAUNCHER = register("lava_launcher");
    public static final ModelLayerLocation LAVA_LAUNCHER_INNER_ARMOUR = register("lava_launcher_inner_armour");
    public static final ModelLayerLocation LAVA_LAUNCHER_OUTER_ARMOUR = register("lava_launcher_outer_armour");
    public static final ModelLayerLocation PIGMADILLO = register("pigmadillo");
    public static final ModelLayerLocation PIGMADILLO_INNER_ARMOUR = register("pigmadillo_inner_armour");
    public static final ModelLayerLocation PIGMADILLO_OUTER_ARMOUR = register("pigmadillo_outer_armour");
    public static final ModelLayerLocation PORTAL_GUARD = register("portal_guard");
    public static final ModelLayerLocation PORTAL_GUARD_INNER_ARMOUR = register("portal_guard_inner_armour");
    public static final ModelLayerLocation PORTAL_GUARD_OUTER_ARMOUR = register("portal_guard_outer_armour");
    public static final ModelLayerLocation COBBLESTONE_GOLEM = register("cobblestone_golem");
    public static final ModelLayerLocation COBBLESTONE_GOLEM_INNER_ARMOUR = register("cobblestone_golem_inner_armour");
    public static final ModelLayerLocation COBBLESTONE_GOLEM_OUTER_ARMOUR = register("cobblestone_golem_outer_armour");
    public static final ModelLayerLocation THROWN_BLAZE_ROD = register("thrown_blaze_rod");
    public static final ModelLayerLocation PIGLIN_BOMB = register("piglin_bomb");
    public static final ModelLayerLocation EXPLOSIVE_FUNGUS = register("explosive_fungus");
    public static final ModelLayerLocation PORTAL_GUARD_WRECKING_BALL = register("portal_guard_wrecking_ball");
    public static final ModelLayerLocation MAGMA_CUBE_PROJECTILE = register("magma_cube_projectile");

    private static ModelLayerLocation register(String path) {
        return register("main", new ResourceLocation(InfamousLegends.MOD_ID, path));
    }

    private static ModelLayerLocation register(String layer, ResourceLocation location) {
        ModelLayerLocation modellayerlocation = createLocation(layer, location);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String layer, ResourceLocation location) {
        return new ModelLayerLocation(location, layer);
    }
}