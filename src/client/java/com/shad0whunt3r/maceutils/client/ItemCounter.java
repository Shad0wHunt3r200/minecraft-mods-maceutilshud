package com.shad0whunt3r.maceutils.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemCounter {
    public static int countItems(Item item) {
        var player = Minecraft.getInstance().player;
        int count = 0;

        if (player == null) return 0;

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            var currentItem = player.getInventory().getItem(i);
            if (currentItem.is(item)) {
                count += currentItem.getCount();
            }
        }

        return count;
    }

    public static String getDurability(Item item) {
        var player = Minecraft.getInstance().player;

        if (player == null) return "0";

        ArrayList<Integer> values = new ArrayList<>();
        int maxDurability = 0;

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            var currentItem = player.getInventory().getItem(i);
            if (currentItem.is(item)) {
                maxDurability = currentItem.getMaxDamage();
                values.add(currentItem.getMaxDamage() - currentItem.getDamageValue());
            }
        }

        if (values.isEmpty()) return "0";

        final int maxDur = maxDurability;
        boolean allFull = values.stream().allMatch(v -> v == maxDur);
        if (!allFull) {
            values.removeIf(v -> v == maxDur);
        }

        Collections.sort(values);
        List<Integer> top = values.subList(0, Math.min(3, values.size()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top.size(); i++) {
            if (i > 0) sb.append(" | ");
            sb.append(top.get(i));
        }
        return sb.toString();
    }
}