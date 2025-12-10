package com.example.triggerbot;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import org.lwjgl.glfw.GLFW;

public class TriggerbotClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            tryTick(client);
        });
    }

    private void tryTick(MinecraftClient client) {
        if (client.player == null || client.world == null) return;

        long window = client.getWindow().getHandle();
        boolean held = GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;
        if (!held) return;

        HitResult hit = client.crosshairTarget;
        if (hit == null || hit.getType() != HitResult.Type.ENTITY) return;

        EntityHitResult ehr = (EntityHitResult) hit;
        Entity target = ehr.getEntity();
        PlayerEntity player = client.player;

        if (target == player) return;

        float cooldown = player.getAttackCooldownProgress(0.5F);
        if (cooldown < 0.9F) return;

        client.interactionManager.attackEntity(player, target);
        player.swingHand(Hand.MAIN_HAND);
    }
}
