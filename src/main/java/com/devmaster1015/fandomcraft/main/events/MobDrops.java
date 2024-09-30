package com.devmaster1015.fandomcraft.main.events;

import com.devmaster1015.fandomcraft.entities.EntityGoomba;
import com.devmaster1015.fandomcraft.entities.EntityKoopa;
import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class MobDrops {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        // Check if the entity that died is a LivingEntity
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        LivingEntity entity = (LivingEntity) event.getEntity();
        Entity source = event.getSource().getTrueSource();

        // Check if the killer is a player
        if (source instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) source;

            // Get the weapon the player used to kill the entity
            ItemStack weapon = player.getHeldItemMainhand();

            // Check if the weapon is the Soul Eater
            if (weapon.getItem() == RegistryHandler.SOUL_EATER.get()) {
                // Check if the entity that died is one of the specified mobs (Cow, Pig, Sheep, Creeper, etc.)
                if (entity instanceof CowEntity ||
                        entity instanceof PigEntity ||
                        entity instanceof SheepEntity ||
                        entity instanceof CreeperEntity ||
                        entity instanceof SpiderEntity){

                    // Drop a Soul item if it's one of the specified mobs
                    entity.entityDropItem(new ItemStack(RegistryHandler.SOUL.get()), 0);
                }
                if (entity instanceof WitchEntity)
                    entity.entityDropItem(new ItemStack(RegistryHandler.RAGING_SOUL.get()), 0);
            }
            // Check if the weapon is the Dream Sword
            else if (weapon.getItem() == RegistryHandler.DREAM_SWORD.get()) {
                // Check if the entity that died is one of the specified mobs (Zombie, Skeleton, Zombified Piglin, etc.)
                if (entity instanceof ZombieEntity ||
                        entity instanceof SkeletonEntity ||
                        entity instanceof ZombifiedPiglinEntity ||
                        entity instanceof GhastEntity ||
                        entity instanceof WitchEntity ||
                        entity instanceof EndermanEntity) {

                    // Drop a Dark Heart if it's one of the specified mobs
                    entity.entityDropItem(new ItemStack(RegistryHandler.COIN.get()), 0);
                }
            }
            else if (weapon.getItem() == RegistryHandler.STAR_HAMMER.get()) {
                if (entity instanceof EntityGoomba ||
                        entity instanceof EntityKoopa) {

                    // Drop a Dark Heart if it's one of the specified mobs
                    entity.entityDropItem(new ItemStack(RegistryHandler.COIN.get()), 0);
                }
            }
            // For all other weapons, drop a Green Rupee
            else {
                entity.entityDropItem(new ItemStack(RegistryHandler.RUPEE_GREEN.get()), 0);
            }
        }
    }
}