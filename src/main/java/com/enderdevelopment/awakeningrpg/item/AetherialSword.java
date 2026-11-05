package com.enderdevelopment.awakeningrpg.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

/**
 * A strong but passive RPG blade. It deliberately does NOT add any combat
 * behaviour beyond vanilla attacking so that The Awakening mod remains the
 * active combat system without conflicts.
 */
public class AetherialSword extends SwordItem {
    public AetherialSword() {
        super(Tiers.NETHERITE, 6, -2.4f, new Properties().fireResistant().stacksTo(1));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // No custom combat effects: combat is owned by The Awakening mod.
        return super.hurtEnemy(stack, target, attacker);
    }
}
