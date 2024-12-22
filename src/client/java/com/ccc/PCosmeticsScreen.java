package com.ccc;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.DirectionalLayoutWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class PCosmeticsScreen extends GameOptionsScreen {

    public PCosmeticsScreen(Screen parent, GameOptions options, CosmeticTypes cosmeticTypes) {
        super(parent, options, Text.translatable("gui.pcosmetics." + cosmeticTypes.name() + "_title"));
        layout.setFooterHeight(53);
    }

    protected void initBody() {

    }

    protected void addOptions() {
    }

    protected void initFooter() {
        DirectionalLayoutWidget directionalLayoutWidget = layout.addFooter(DirectionalLayoutWidget.vertical()).spacing(8);
        directionalLayoutWidget.getMainPositioner().alignHorizontalCenter();
        DirectionalLayoutWidget backApplyDirectionalLayoutWidget = directionalLayoutWidget.add(DirectionalLayoutWidget.horizontal().spacing(8));
        backApplyDirectionalLayoutWidget.add(ButtonWidget.builder(ScreenTexts.BACK, (button) -> {
            client.setScreen(parent);
        }).build());
    }

    protected void refreshWidgetPositions() {
        super.refreshWidgetPositions();
    }
}

