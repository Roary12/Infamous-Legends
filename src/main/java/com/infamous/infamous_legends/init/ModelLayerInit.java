package com.infamous.infamous_legends.init;

import java.util.Set;

import com.google.common.collect.Sets;
import com.infamous.infamous_legends.InfamousLegends;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModelLayerInit {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation PIGLIN_RUNT = register("piglin_runt");
    public static final ModelLayerLocation PIGLIN_GRUNTER = register("piglin_grunter");
    public static final ModelLayerLocation PIGLIN_BRUISER = register("piglin_bruiser");
    public static final ModelLayerLocation THROWN_BLAZE_ROD = register("thrown_blaze_rod");

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