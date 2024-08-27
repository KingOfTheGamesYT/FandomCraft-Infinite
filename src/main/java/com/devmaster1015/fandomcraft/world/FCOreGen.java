package com.devmaster1015.fandomcraft.world;

import com.devmaster1015.fandomcraft.main.RegistryHandler;
import static com.devmaster1015.fandomcraft.world.FCOreGen.OreType.*;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.Dimension;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;

public class FCOreGen {

    public static void handleWorldGen(final BiomeLoadingEvent event) {
        spawnOreInAllBiomes(ADAMANTIUM_ORE, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(ROCKSTONE, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(GODDESS_ORE, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(UNKNOWN_ORE, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(HELLSTONE, event, Dimension.THE_NETHER.toString());
        spawnOreInAllBiomes(FOOLS_GOLD, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(ERIDIUM_ORE, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(HALITE, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(ORICHULUM_ORE, event, Dimension.OVERWORLD.toString());
        spawnOreInAllBiomes(MYTHRIL_ORE, event, Dimension.OVERWORLD.toString());

    }

    private static OreFeatureConfig getOverworldFeatureConfig(OreType ore) {
        return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
    }

    private static OreFeatureConfig getNetherFeatureConfig(OreType ore) {
        return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
    }

    private static OreFeatureConfig getHaliteFeatureConfig(OreType ore) {
        return new OreFeatureConfig(new BlockMatchRuleTest(Blocks.SAND),
                ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
    }

    private static OreFeatureConfig getEndFeatureConfig(OreType ore) {
        return new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE),
                ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
    }

    // Currently only supports vanilla Dimensions
    private static ConfiguredFeature<?, ?> makeOreFeature(OreType ore, String dimensionToSpawnIn) {
        OreFeatureConfig oreFeatureConfig = null;

        if (dimensionToSpawnIn.equals(Dimension.OVERWORLD.toString())) {
            if (ore == OreType.HALITE) {
                oreFeatureConfig = getHaliteFeatureConfig(ore);
            } else {
                oreFeatureConfig = getOverworldFeatureConfig(ore);
            }
        } else if (dimensionToSpawnIn.equals(Dimension.THE_NETHER.toString())) {
            oreFeatureConfig = getNetherFeatureConfig(ore);
        } else if (dimensionToSpawnIn.equals(Dimension.THE_END.toString())) {
            oreFeatureConfig = getEndFeatureConfig(ore);
        }

        ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

        return registerOreFeature(ore, oreFeatureConfig, configuredPlacement);
    }

    private static void spawnOreInOverworldInGivenBiomes(OreType ore, final BiomeLoadingEvent event, Biome... biomesToSpawnIn) {
        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());

        ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

        ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

        if (Arrays.stream(biomesToSpawnIn).anyMatch(b -> b.getRegistryName().equals(event.getName()))) {
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
        }
    }


    private static void spawnOreInSpecificModBiome(Biome biomeToSpawnIn, OreType currentOreType,
                                                   final BiomeLoadingEvent event, String dimension) {
        if (event.getName().toString().contains(biomeToSpawnIn.getRegistryName().toString())) {
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
        }
    }

    private static void spawnOreInSpecificBiome(RegistryKey<Biome> biomeToSpawnIn, OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
        if (event.getName().toString().contains(biomeToSpawnIn.getLocation().toString())) {
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
        }
    }

    private static void spawnOreInAllBiomes(OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                makeOreFeature(currentOreType, dimension));
    }

    private static ConfiguredFeature<?, ?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig, ConfiguredPlacement configuredPlacement) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
                Feature.ORE.withConfiguration(oreFeatureConfig).withPlacement(configuredPlacement)
                        .square()
                        .count(ore.getVeinsPerChunk()));
    }
    public enum OreType {
        ADAMANTIUM_ORE(Lazy.of(RegistryHandler.ADAMANTIUM_ORE_BLOCK), 3, 0, 12, 2),
        ROCKSTONE(Lazy.of(RegistryHandler.ROCK_STONE_BLOCK), 50, 0, 128, 15),
        GODDESS_ORE(Lazy.of(RegistryHandler.GODDESS_ORE_BLOCK), 2, 10, 48, 6),
        UNKNOWN_ORE(Lazy.of(RegistryHandler.UNKNOWN_ORE_BLOCK), 5, 0, 128, 5),
        HELLSTONE(Lazy.of(RegistryHandler.HELLSTONE_ORE_BLOCK), 5, 0, 30, 2),
        FOOLS_GOLD(Lazy.of(RegistryHandler.FOOLS_GOLD_ORE_BLOCK), 6, 0, 32, 2),
        ERIDIUM_ORE(Lazy.of(RegistryHandler.ERIDIUM_ORE_BLOCK), 6, 0, 30, 4),
        HALITE(Lazy.of(RegistryHandler.HALITE),10, 0, 60, 50),
        ORICHULUM_ORE(Lazy.of(RegistryHandler.ORICHULUM_ORE), 4, 0, 60, 6),
        MYTHRIL_ORE(Lazy.of(RegistryHandler.MYTHRIL_ORE),2, 0, 60, 6);

        private final Lazy<Block> block;
        private final int maxVeinSize;
        private final int minHeight;
        private final int maxHeight;
        private final int veinsPerChunk;

        OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
            this.block = block;
            this.maxVeinSize = maxVeinSize;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.veinsPerChunk = veinsPerChunk;
        }

        public int getVeinsPerChunk() {
            return veinsPerChunk;
        }

        public Lazy<Block> getBlock() {
            return block;
        }

        public int getMaxVeinSize() {
            return maxVeinSize;
        }

        public int getMinHeight() {
            return minHeight;
        }

        public int getMaxHeight() {
            return maxHeight;
        }
    }
}