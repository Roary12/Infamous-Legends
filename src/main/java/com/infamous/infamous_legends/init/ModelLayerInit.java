package com.infamous.infamous_legends.init;

import java.util.Set;

import com.google.common.collect.Sets;
import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModelLayerInit {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation PIGLIN_RUNT = register("piglin_runt");
    public static final ModelLayerLocation PIGLIN_RUNT_INNER_ARMOUR = register("piglin_runt_inner_armour");
    public static final ModelLayerLocation PIGLIN_RUNT_OUTER_ARMOUR = register("piglin_runt_outer_armour");
    public static final ModelLayerLocation PIGLIN_GRUNTER = register("piglin_grunter");
    public static final ModelLayerLocation PIGLIN_GRUNTER_INNER_ARMOUR = register("piglin_grunter_inner_armour");
    public static final ModelLayerLocation PIGLIN_GRUNTER_OUTER_ARMOUR = register("piglin_grunter_outer_armour");
    public static final ModelLayerLocation PIGLIN_BRUISER = register("piglin_bruiser");
    public static final ModelLayerLocation PIGLIN_BRUISER_INNER_ARMOUR = register("piglin_bruiser_inner_armour");
    public static final ModelLayerLocation PIGLIN_BRUISER_OUTER_ARMOUR = register("piglin_bruiser_outer_armour");
    public static final ModelLayerLocation PIGLIN_ENGINEER = register("piglin_engineer");
    public static final ModelLayerLocation PIGLIN_ENGINEER_INNER_ARMOUR = register("piglin_engineer_inner_armour");
    public static final ModelLayerLocation PIGLIN_ENGINEER_OUTER_ARMOUR = register("piglin_engineer_outer_armour");
    public static final ModelLayerLocation WARPED_BOMBER = register("warped_bomber");
    public static final ModelLayerLocation WARPED_BOMER_INNER_ARMOUR = register("warped_bomber_inner_armour");
    public static final ModelLayerLocation WARPED_BOMBER_OUTER_ARMOUR = register("warped_bomber_outer_armour");
    public static final ModelLayerLocation THROWN_BLAZE_ROD = register("thrown_blaze_rod");
    public static final ModelLayerLocation PIGLIN_BOMB = register("piglin_bomb");
    public static final ModelLayerLocation EXPLOSIVE_FUNGUS = register("explosive_fungus");

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