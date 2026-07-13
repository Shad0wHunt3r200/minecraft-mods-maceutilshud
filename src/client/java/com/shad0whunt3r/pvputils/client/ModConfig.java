package com.shad0whunt3r.pvputils.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ModConfig {
    public int itemTrackerX = 0;
    public int itemTrackerY = 0;

    public static int defaultItemTrackerX() {
        return Minecraft.getInstance().getWindow().getGuiScaledWidth() - 36;
    }

    public static int defaultItemTrackerY() {
        return Minecraft.getInstance().getWindow().getGuiScaledHeight() / 2;
    }

    public boolean enabled = true;
    public int textColor = 0xFFFFFFFF;


    public List<String> trackedItems = new ArrayList<>(List.of(
            "minecraft:shulker_box",
            "minecraft:golden_apple",
            "minecraft:elytra",
            "minecraft:totem_of_undying"
    ));

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir().resolve("pvp-utils.json");

    public static ModConfig INSTANCE = new ModConfig();

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) {
            save();
            return;
        }
        try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
            INSTANCE = GSON.fromJson(reader, ModConfig.class);
            if (INSTANCE.trackedItems == null) {
                INSTANCE.trackedItems = new ArrayList<>(List.of(
                    "minecraft:shulker_box",
                    "minecraft:golden_apple",
                    "minecraft:elytra",
                    "minecraft:totem_of_undying"
                ));
            }
        } catch (IOException e) {
            System.err.println("Failed to load PvP Utils config: " + e.getMessage());
        }
    }

    public static void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(INSTANCE, writer);
        } catch (IOException e) {
            System.err.println("Failed to save PvP Utils config: " + e.getMessage());
        }
    }
}

