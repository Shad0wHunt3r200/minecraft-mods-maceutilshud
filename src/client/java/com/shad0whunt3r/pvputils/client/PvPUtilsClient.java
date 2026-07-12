package com.shad0whunt3r.pvputils.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.resources.Identifier;


public class PvPUtilsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		ModConfig.load();
		net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			if (ModConfig.INSTANCE.itemTrackerX == 0) ModConfig.INSTANCE.itemTrackerX = ModConfig.defaultX();
			if (ModConfig.INSTANCE.itemTrackerY == 0) ModConfig.INSTANCE.itemTrackerY = ModConfig.defaultY();
		});
		HudElementRegistry.attachElementBefore(
				VanillaHudElements.CHAT,
				Identifier.fromNamespaceAndPath("pvputils", "hud"),
				HUDOverlay::render
		);

	}
}