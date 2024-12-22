package com.ccc.mixin.client;

import com.ccc.CosmeticsScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextIconButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
@Environment(EnvType.CLIENT)
public class TitleScreenClientMixin extends Screen {
	protected TitleScreenClientMixin(Text title) {
		super(title);
	}

	@Inject(at = @At("TAIL"), method = "init")
	private void init(CallbackInfo info) {
		TextIconButtonWidget menuIconButtonWidget = this.addDrawableChild(createCosmeticsButton((button) -> {
			client.setScreen(new CosmeticsScreen(this, this.client.options));
		}));
		menuIconButtonWidget.setPosition(width / 2 + 104, height / 4 + 48);
	}

	@Unique
	private static TextIconButtonWidget createCosmeticsButton(ButtonWidget.PressAction onPress) {
        return TextIconButtonWidget.builder(Text.translatable("options.cosmetics"), onPress, true).width(20).texture(Identifier.ofVanilla("icon/cosmetics"), 15, 15).build();
	}
}