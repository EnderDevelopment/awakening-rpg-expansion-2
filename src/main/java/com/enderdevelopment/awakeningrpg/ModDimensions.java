package com.enderdevelopment.awakeningrpg;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

/**
 * Holds the identity of the Awakening Lands adventure dimension.
 *
 * The dimension's actual data (dimension type and generator) is declared in
 * the datapack under data/awakening_rpg/dimension and dimension_type, so no
 * runtime registration is required for it to exist.
 */
public class ModDimensions {
    public static final ResourceKey<Level> AWAKENING_LANDS =
            ResourceKey.create(Registries.DIMENSION, new ResourceLocation(AwakeningRpg.MOD_ID, "awakening_lands"));

    private ModDimensions() {
    }
}
