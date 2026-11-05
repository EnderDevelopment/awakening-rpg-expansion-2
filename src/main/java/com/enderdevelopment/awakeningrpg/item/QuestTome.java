package com.enderdevelopment.awakeningrpg.item;

import com.enderdevelopment.awakeningrpg.client.QuestScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Opens the RPG quest tracker GUI. The screen is client-side only, so the
 * item simply does nothing on the server.
 */
public class QuestTome extends Item {
    public QuestTome() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide && player instanceof net.minecraft.client.player.LocalPlayer) {
            Minecraft.getInstance().setScreen(new QuestScreen());
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
