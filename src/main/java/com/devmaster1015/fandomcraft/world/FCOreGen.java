package com.devmaster1015.fandomcraft.world;

import com.devmaster1015.fandomcraft.main.RegistryHandler;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FCOreGen {

    public static ConfiguredFeature<?, ?> ADAMANTIUM_ORE;
    public static ConfiguredFeature<?, ?> ROCKSTONE;
    public static ConfiguredFeature<?, ?> GODDESS_ORE;


    public static void addConfigFeatures(RegistryEvent.Register<Feature<?>> event){

        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
        ADAMANTIUM_ORE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.ADAMANTIUM_ORE_BLOCK.get().getDefaultState(),3))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 12))
                        .square()
                        .chance/* repeat */(2));

        ROCKSTONE = Feature.ORE.withConfiguration(
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.ROCK_STONE_BLOCK.get().getDefaultState(),50))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 128))
                        .square()
                        .chance/* repeat */(15));

        GODDESS_ORE = Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.GODDESS_ORE_BLOCK.get().getDefaultState(),2))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(10, 0, 48))
                        .square()
                        .chance/* repeat */(6));

        Registry.register(registry, new ResourceLocation("adamantium_ore"), ADAMANTIUM_ORE);
        Registry.register(registry, new ResourceLocation("rock"), ROCKSTONE);
        Registry.register(registry, new ResourceLocation("godessoreblock"), GODDESS_ORE);

    }

    public static void handleWorldGen(BiomeLoadingEvent event){
        RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getCategory() == Biome.Category.NETHER
                || event.getCategory() == Biome.Category.THEEND
                || BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID)) return;
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ADAMANTIUM_ORE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ROCKSTONE);
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, GODDESS_ORE);

    }

}