package com.devmaster1015.fandomcraft.util;

import com.devmaster1015.fandomcraft.world.BiomeDictionaryHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;

public class FCConfig {
    public static ForgeConfigSpec.IntValue Goombamin;
    public static ForgeConfigSpec.IntValue Goombamax;
    public static ForgeConfigSpec.IntValue Goombaweight;

    public static ForgeConfigSpec.ConfigValue<List<? extends String>> Goombabiomes; // Single config list for biomes

    public FCConfig() {
    }

    // Adjust the COMMON config method
    public static void COMMON(ForgeConfigSpec.Builder builder) {
        builder.comment("Spawn Chances");
        builder.comment("Configure mob spawn weight (How frequently they spawn & min/max group size. Set weight to 0 to disable.)");
        builder.push("Goomba Spawn Chances");
        Goombamin = builder.defineInRange("Goomba Min", 1, 0, 640);
        Goombamax = builder.defineInRange("Goomba Max", 2, 0, 640);
        Goombaweight = builder.defineInRange("Goomba Weight", 7, 0, 100);
        builder.pop();

        builder.comment("Spawnable Biomes");
        builder.push("Goomb's Biomes");
        Goombabiomes = builder.defineList("Spawn Goomba in", Arrays.asList("PLAINS", "FOREST", "DESERT"), // Default values
                FCConfig::isValidBiomeOrType);  // Custom validator
        builder.pop();
    }
    // Custom validator to check if the string is a valid biome category or biome name
    private static boolean isValidBiomeOrType(Object o) {
        if (o instanceof String) {
            String biomeString = (String) o;
            // Check if it is a valid BiomeDictionary.Type
            if (BiomeDictionaryHelper.getType(biomeString) != null) {
                return true;
            }
            // Check if it is a valid specific biome from ForgeRegistries
            ResourceLocation biomeResource = new ResourceLocation(biomeString.toLowerCase());
            if (ForgeRegistries.BIOMES.containsKey(biomeResource)) {
                return true;
            }
        }
        return false;
    }
}


