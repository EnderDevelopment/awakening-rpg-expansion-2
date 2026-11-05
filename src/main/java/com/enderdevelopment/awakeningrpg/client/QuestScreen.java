package com.enderdevelopment.awakeningrpg.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * A lightweight quest tracker screen. It is drawn without any texture
 * assets (pure fills and text) so it never depends on a missing GUI image.
 */
public class QuestScreen extends Screen {
    private static final int BG = 0xFF1B1B2F;
    private static final int PANEL = 0xFF2E2E4A;
    private static final int ACCENT = 0xFFD4AF37;
    private static final int TEXT_COLOR = 0xFFE8E8F0;
    private static final int MUTED = 0xFF9A9AB0;

    public QuestScreen() {
        super(Component.translatable("screen.awakening_rpg.quest_title"));
    }

    @Override
    protected void init() {
        int buttonWidth = 100;
        int buttonHeight = 20;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height - 40;

        this.addRenderableWidget(Button.builder(Component.translatable("gui.awakening_rpg.close"), b -> this.onClose())
                .bounds(x, y, buttonWidth, buttonHeight)
                .build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        drawContent(graphics);
    }

    private void drawContent(GuiGraphics graphics) {
        int panelW = Math.min(320, this.width - 40);
        int panelH = Math.min(280, this.height - 80);
        int left = (this.width - panelW) / 2;
        int top = 30;

        // Outer background panel.
        graphics.fill(left - 2, top - 2, left + panelW + 2, top + panelH + 2, ACCENT);
        graphics.fill(left, top, left + panelW, top + panelH, BG);

        // Title.
        graphics.drawCenteredString(this.font, this.title, this.width / 2, top + 10, ACCENT);

        int y = top + 40;

        drawQuest(graphics, left, panelW, y, "Explore the Awakening Lands", "Enter the new dimension through the Wayfinder Compass.");
        drawQuest(graphics, left, panelW, y + 70, "Gather Epic Relics", "Collect Aetherial gear and rare treasures in the ruins.");
        drawQuest(graphics, left, panelW, y + 140, "Master the Adventure", "Battle legendary foes using The Awakening combat system.");
        drawQuest(graphics, left, panelW, y + 210, "Never Stop Exploring", "The journey is endless - find every hidden place.");

        graphics.drawCenteredString(this.font,
                Component.translatable("gui.awakening_rpg.hint"),
                this.width / 2, top + panelH - 20, MUTED);
    }

    private void drawQuest(GuiGraphics graphics, int left, int panelW, int y, String title, String desc) {
        graphics.fill(left + 10, y, left + panelW - 10, y + 56, PANEL);
        graphics.drawString(this.font, Component.literal("\u25C6 " + title), left + 18, y + 8, ACCENT, false);
        graphics.drawString(this.font, Component.literal(desc), left + 18, y + 24, TEXT_COLOR, false);
        graphics.drawString(this.font, Component.literal("\u2705 Objective: complete it to advance"),
                left + 18, y + 40, MUTED, false);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
