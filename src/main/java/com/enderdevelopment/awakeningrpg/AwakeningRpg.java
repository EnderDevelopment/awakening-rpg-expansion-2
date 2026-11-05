package com.enderdevelopment.awakeningrpg;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(AwakeningRpg.MOD_ID)
public class AwakeningRpg {
    public static final String MOD_ID = "awakening_rpg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public AwakeningRpg(IEventBus modEventBus) {
        // Register all content (items, creative tab) through their DeferredRegisters.
        ModItems.ITEMS.register(modEventBus);
        ModItems.TAB.register(modEventBus);

        LOGGER.info("Awakening RPG Companion initialized. The Awakening remains the combat system.");
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
