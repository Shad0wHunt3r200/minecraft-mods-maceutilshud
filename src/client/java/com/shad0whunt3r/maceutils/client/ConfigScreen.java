package com.shad0whunt3r.maceutils.client;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.ColorControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigScreen extends Screen {
    private final Screen parent;

    public ConfigScreen(Screen parent) {
        super(Component.literal("Mace Utils Config"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        var enabledToggle = Option.<Boolean>createBuilder()
                .name(Component.literal("Enable Mod"))
                .binding(true, () -> ModConfig.INSTANCE.enabled, val -> ModConfig.INSTANCE.enabled = val)
                .controller(TickBoxControllerBuilder::create)
                .build();

        var colorSelector = Option.<Color>createBuilder()
                .name(Component.literal("Text Color"))
                .binding(Color.white, () -> new Color(ModConfig.INSTANCE.textColor), val -> ModConfig.INSTANCE.textColor = val.getRGB())
                .controller(ColorControllerBuilder::create)
                .build();

        var trackedItemsOption = ListOption.<String>createBuilder()
                .name(Component.literal("Tracked Items"))
                .description(OptionDescription.of(Component.literal("List of item IDs to be tracked (e.g., minecraft:elytra)")))
                .binding(
                        List.of("minecraft:wind_charge", "minecraft:ender_pearl", "minecraft:elytra"), // The Default
                        () -> ModConfig.INSTANCE.trackedItems,
                        val -> ModConfig.INSTANCE.trackedItems = new ArrayList<>(val)
                )
                .controller(StringControllerBuilder::create)
                .initial("")
                .build();

        var itemTrackerLocationX = Option.<Integer>createBuilder()
                .name(Component.literal("X Position"))
                .description(OptionDescription.of(Component.literal("Change the X position of the Item Tracker HUD. \nDefault position is aligned to the right of the screen")))
                .binding(
                        ModConfig.defaultX(),
                        () -> ModConfig.INSTANCE.itemTrackerX,
                        val -> ModConfig.INSTANCE.itemTrackerX = val
                )
                .controller(IntegerFieldControllerBuilder::create)
                .build();

        var itemTrackerLocationY = Option.<Integer>createBuilder()
                .name(Component.literal("Y Position"))
                .description(OptionDescription.of(Component.literal("Change the Y position of the Item Tracker HUD. \nDefault position is aligned to the middle of the screen")))
                .binding(
                        ModConfig.defaultY(),
                        () -> ModConfig.INSTANCE.itemTrackerY,
                        val -> ModConfig.INSTANCE.itemTrackerY = val
                )
                .controller(IntegerFieldControllerBuilder::create)
                .build();

        var configCategoryGeneral = ConfigCategory.createBuilder()
                .name(Component.literal("General"))
                .option(enabledToggle)
                .option(colorSelector)
                .build();

        var configCategoryItemTracker = ConfigCategory.createBuilder()
                .name(Component.literal("Item Tracker"))
                .option(trackedItemsOption)
                .option(itemTrackerLocationX)
                .option(itemTrackerLocationY)
                .build();

        var config = YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Mace Utils HUD Config"))
                .categories(List.of(configCategoryGeneral, configCategoryItemTracker))
                .save(ModConfig::save)
                .build();

        this.minecraft.setScreen(config.generateScreen(parent));
    }
}
