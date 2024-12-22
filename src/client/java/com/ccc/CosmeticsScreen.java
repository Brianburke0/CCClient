package com.ccc;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.*;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class CosmeticsScreen extends GameOptionsScreen {

    private ButtonWidget HatButton;
    private ButtonWidget ChestButton;
    private ButtonWidget LegsButton;
    private ButtonWidget FeetButton;
    private ButtonWidget CapeButton;

    public CosmeticsScreen(Screen parent, GameOptions options) {
        super(parent, options, Text.translatable("gui.cosmetics.title"));
        layout.setFooterHeight(53);
    }

    protected void initBody() {
        HatButton = this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.cosmetics.hat"), (button) -> {
            this.client.setScreen(new PCosmeticsScreen(this, this.client.options, CosmeticTypes.hat));
        }).dimensions(width / 2 - 100, height / 2 - 48, 200, 20).build());
        ChestButton = this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.cosmetics.chest"), (button) -> {
            this.client.setScreen(new PCosmeticsScreen(this, this.client.options, CosmeticTypes.chest));
        }).dimensions(width / 2 - 100, height / 2 - 24, 200, 20).build());
        LegsButton = this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.cosmetics.legs"), (button) -> {
            this.client.setScreen(new PCosmeticsScreen(this, this.client.options, CosmeticTypes.legs));
        }).dimensions(width / 2 - 100, height / 2, 200, 20).build());
        FeetButton = this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.cosmetics.feet"), (button) -> {
            this.client.setScreen(new PCosmeticsScreen(this, this.client.options, CosmeticTypes.feet));
        }).dimensions(width / 2 - 100, height / 2 + 24, 200, 20).build());
        CapeButton = this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.cosmetics.cape"), (button) -> {
            this.client.setScreen(new PCosmeticsScreen(this, this.client.options, CosmeticTypes.cape));
        }).dimensions(width / 2 - 100, height / 2 + 48, 200, 20).build());
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
        backApplyDirectionalLayoutWidget.add(ButtonWidget.builder(Text.translatable("gui.apply"), (button) -> {
            client.setScreen(parent);
        }).build());
    }

    protected void refreshWidgetPositions() {
        super.refreshWidgetPositions();

        HatButton.setPosition(width / 2 - 100, height / 2 - 48);
        ChestButton.setPosition(width / 2 - 100, height / 2 - 24);
        LegsButton.setPosition(width / 2 - 100, height / 2);
        FeetButton.setPosition(width / 2 - 100, height / 2 + 24);
        CapeButton.setPosition(width / 2 - 100, height / 2 + 48);
    }
}
