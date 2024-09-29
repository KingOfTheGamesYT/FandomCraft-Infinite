package com.devmaster1015.fandomcraft.world;


import com.devmaster1015.fandomcraft.main.FandomCraft;

import com.devmaster1015.fandomcraft.util.FCConfig;
import com.devmaster1015.fandomcraft.util.RegistryHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = FandomCraft.MOD_ID)
public class EntitySpawns {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void addSpawn(BiomeLoadingEvent event) {
        if (event.getName() != null) {
            Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
            if (biome != null) {
                RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, event.getName());
                List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(FCConfig.Goombabiomes.get()));

                if (!includeList.isEmpty()) {
                    Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biomeKey);
                    if (biomeTypes.stream().anyMatch(includeList::contains)) {
                        System.out.println("Adding Goomba spawn in biome: " + biome.getRegistryName());
                        event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.GOOMBA.get(), FCConfig.Goombaweight.get(), FCConfig.Goombamin.get(), FCConfig.Goombamax.get()));
                    }

                } else {
                    throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
                }
            }
        }
    }

}
