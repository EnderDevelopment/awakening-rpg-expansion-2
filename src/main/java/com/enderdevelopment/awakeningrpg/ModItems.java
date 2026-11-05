package com.enderdevelopment.awakeningrpg;

import com.enderdevelopment.awakeningrpg.item.AetherialSword;
import com.enderdevelopment.awakeningrpg.item.QuestTome;
import com.enderdevelopment.awakeningrpg.item.WayfinderCompass;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(AwakeningRpg.MOD_ID);

    public static final DeferredItem<AetherialSword> AETHERIAL_SWORD =
            ITEMS.register("aetherial_sword", AetherialSword::new);
    public static final DeferredItem<WayfinderCompass> WAYFINDER_COMPASS =
            ITEMS.register("wayfinder_compass", WayfinderCompass::new);
    public static final DeferredItem<QuestTome> QUEST_TOME =
            ITEMS.register("quest_tome", QuestTome::new);

    public static final DeferredRegister<CreativeModeTab> TAB =
            DeferredRegister.create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, AwakeningRpg.MOD_ID);

    public static final Supplier<CreativeModeTab> AWAKENING_TAB = TAB.register("awakening_group", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.awakening_rpg"))
                    .icon(() -> new ItemStack(AETHERIAL_SWORD.get()))
                    .displayItems((params, output) -> {
                        output.accept(AETHERIAL_SWORD.get());
                        output.accept(WAYFINDER_COMPASS.get());
                        output.accept(QUEST_TOME.get());
                    })
                    .build());

    private ModItems() {
    }
}
