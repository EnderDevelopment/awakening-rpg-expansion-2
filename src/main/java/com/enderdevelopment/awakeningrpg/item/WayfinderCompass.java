package com.enderdevelopment.awakeningrpg.item;

import com.enderdevelopment.awakeningrpg.ModDimensions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Teleports the player between the Overworld and the Awakening Lands
 * adventure dimension. This is the exploration tool that makes the
 * endless adventure reachable.
 */
public class WayfinderCompass extends Item {
    public WayfinderCompass() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            ServerLevel current = serverPlayer.serverLevel();
            ServerLevel targetWorld;

            if (current.dimension() == ModDimensions.AWAKENING_LANDS) {
                targetWorld = serverPlayer.server.getLevel(Level.OVERWORLD);
                serverPlayer.sendSystemMessage(Component.translatable("message.awakening_rpg.returned"));
            } else {
                targetWorld = serverPlayer.server.getLevel(ModDimensions.AWAKENING_LANDS);
                if (targetWorld == null) {
                    targetWorld = serverPlayer.server.getLevel(Level.OVERWORLD);
                    serverPlayer.sendSystemMessage(Component.translatable("message.awakening_rpg.dimension_missing"));
                } else {
                    serverPlayer.sendSystemMessage(Component.translatable("message.awakening_rpg.travelled"));
                }
            }

            // Teleport the player to the equivalent coordinates in the target dimension.
            if (targetWorld != null) {
                serverPlayer.teleportTo(targetWorld, serverPlayer.getX(), serverPlayer.getY(),
                        serverPlayer.getZ(), serverPlayer.getYRot(), serverPlayer.getXRot());
            }
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
