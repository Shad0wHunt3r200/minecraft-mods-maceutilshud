package com.shad0whunt3r.maceutils.client;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HUDOverlay {
    public static void render(GuiGraphics graphics, DeltaTracker tickDelta) {
        if (!ModConfig.INSTANCE.enabled) return;

        int screenWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();

        int x = screenWidth - 36;
        int y = (Minecraft.getInstance().getWindow().getGuiScaledHeight() / 2) - (ModConfig.INSTANCE.trackedItems.size() * 20 / 2);


        for (String item : ModConfig.INSTANCE.trackedItems) {
            Item resolvedItem = BuiltInRegistries.ITEM.getValue(Identifier.parse(item));

            int count;
            if (resolvedItem.getDefaultInstance().isDamageableItem()) {
                count = ItemCounter.getDurability(resolvedItem);
            } else {
                count = ItemCounter.countItems(resolvedItem);
            }

            drawItem(graphics, resolvedItem, count, x, y);
            y += 20;
        }
    }

    private static void drawItem(GuiGraphics graphics, Item item, int count, int x, int y) {
        if (count == 0) return;
        var itemStack = new ItemStack(item);

        graphics.renderItem(itemStack, x, y);
        graphics.drawString(Minecraft.getInstance().font, String.valueOf(count), (x - (Minecraft.getInstance().font.width(String.valueOf(count)) + 2)), y + 5, /* 0xFFFFFFFF <- the default value */ ModConfig.INSTANCE.textColor, true);
    }
}