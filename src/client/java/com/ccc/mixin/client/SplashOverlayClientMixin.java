package com.ccc.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.client.gui.screen.SplashOverlay;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashOverlay.class)
@Environment(EnvType.CLIENT)
public abstract class SplashOverlayClientMixin extends Overlay {

	private static final Identifier LOGO = Identifier.ofVanilla("textures/gui/title/ccc_logo.png");

	@Inject(at = @At("HEAD"), method = "init")
	private static void init(MinecraftClient client, CallbackInfo ci) {
		client.getTextureManager().registerTexture(LOGO, new ResourceTexture(LOGO));
	}
}