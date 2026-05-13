package com.shad0whunt3r.maceutils.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ModConfig {
    public boolean enabled = true;
    public int textColor = 0xFFFFFFFF;
    public List<String> trackedItems = new ArrayList<>(List.of(
            "minecraft:wind_charge",
            "minecraft:ender_pearl",
            "minecraft:elytra"
    ));

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir().resolve("mace-utils.json");

    public static ModConfig INSTANCE = new ModConfig();

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) {
            save();
            return;
        }

        try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
            INSTANCE = GSON.fromJson(reader, ModConfig.class);
        } catch (IOException e) {
            System.err.println("Failed to load Mace Utils config: " + e.getMessage());
        }
    }

    public static void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(INSTANCE, writer);
        } catch (IOException e) {
            System.err.println("Failed to save Mace Utils config: " + e.getMessage());
        }
    }
}

