package com.devmaster1015.fandomcraft.main;

import com.devmaster1015.fandomcraft.items.Rupee;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PickupEvent {
    @SubscribeEvent
    public static void onItemPickup(EntityItemPickupEvent event) {
        ItemStack itemStack = event.getItem().getItem();
        PlayerEntity player = event.getPlayer();

        if (itemStack.getItem() instanceof Rupee) {
            World world = player.world;
            if (!world.isRemote) {
                world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(),
                        RegistryHandler.RUPEE_PICKUP.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }
    }
}
