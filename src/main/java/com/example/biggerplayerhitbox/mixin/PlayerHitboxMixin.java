package com.example.biggerplayerhitbox.mixin;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerHitboxMixin {

    @ModifyVariable(
        method = "getDimensions",
        at = @At("STORE"),
        ordinal = 0
    )
    private EntityDimensions enlargePlayerHitbox(EntityDimensions original, EntityPose pose) {
        // Increase player hitbox by 5%
        return EntityDimensions.scalable(
            original.width * 1.05f,
            original.height * 1.05f
        );
    }
}
