package com.devmaster1015.fandomcraft.world;

import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.util.FCConfig;
import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.MobSpawnInfo;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FandomCraft.MOD_ID)
public class EntitySpawns {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        ResourceLocation biomeName = event.getName();  // Get the biome's registry name

        //Check if the biome is in the configured list
        List<? extends String> configBiomesKoopa = FCConfig.Koopabiomes.get();
        if (biomeName != null && configBiomesKoopa.contains(biomeName.toString())) {
            int spawnWeightKoopa = FCConfig.Koopaweight.get();
            int spawnMinKoopa = FCConfig.Koopamin.get();
            int spawnMaxKoopa = FCConfig.Koopamax.get();

            event.getSpawns().getSpawner(EntityClassification.MONSTER)
                    .add(new MobSpawnInfo.Spawners(RegistryHandler.KOOPA.get(), spawnWeightKoopa, spawnMinKoopa, spawnMaxKoopa));
        }

        //Check if the biome is in the configured list
        List<? extends String> configBiomesGoomba = FCConfig.Goombabiomes.get();
        if (biomeName != null && configBiomesGoomba.contains(biomeName.toString())) {
            int spawnWeightGoomba = FCConfig.Goombaweight.get();
            int spawnMinGoomba = FCConfig.Goombamin.get();
            int spawnMaxGoomba = FCConfig.Goombamax.get();
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(RegistryHandler.GOOMBA.get(), spawnWeightGoomba, spawnMinGoomba, spawnMaxGoomba));
        }
    }
}
