package com.shad0whunt3r.pvputils.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;

import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.player.Player;

public class RangeIndicator {
    private static final double MAX_RANGE = 20.0; // hardcoded for now, easy to find later
    public static Double getDistanceToTarget() {
        var player = Minecraft.getInstance().player;
        if (player == null) return null;

        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = player.getLookAngle();
        Vec3 reachEnd = eyePos.add(lookVec.scale(MAX_RANGE));

        EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
                player,
                eyePos,
                reachEnd,
                player.getBoundingBox().expandTowards(lookVec.scale(MAX_RANGE)),
                entity -> /*entity instanceof Player &&*/ entity.isAlive(),
                MAX_RANGE * MAX_RANGE // distance squared
        );

        if (hitResult == null) return null;

        var target = hitResult.getEntity(); // to get the entity the raytrace hit
        return eyePos.distanceTo(target.position()); // find the distance to the target's position
    }
}
