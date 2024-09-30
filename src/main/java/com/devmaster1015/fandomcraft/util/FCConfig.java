package com.devmaster1015.fandomcraft.util;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class FCConfig {
    public static ForgeConfigSpec.IntValue Goombamin;
    public static ForgeConfigSpec.IntValue Goombamax;
    public static ForgeConfigSpec.IntValue Goombaweight;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> Goombabiomes; // Single config list for biomes
    public static ForgeConfigSpec.IntValue Koopamin;
    public static ForgeConfigSpec.IntValue Koopamax;
    public static ForgeConfigSpec.IntValue Koopaweight;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> Koopabiomes; // Single config list for biomes

    public FCConfig() {
    }

    public static void COMMON(ForgeConfigSpec.Builder builder) {
        builder.comment("Spawn Chances");
        builder.comment("Configure mob spawn weight (How frequently they spawn & min/max group size. Set weight to 0 to disable.)");
        builder.push("Goomba Spawn Chances");
        Goombamin = builder.defineInRange("Goomba Min", 1, 0, 640);
        Goombamax = builder.defineInRange("Goomba Max", 2, 0, 640);
        Goombaweight = builder.defineInRange("Goomba Weight", 7, 0, 100);
        builder.pop();

        builder.push("Koopa Spawn Chances");
        Koopamin = builder.defineInRange("Koopa Min", 1, 0, 640);
        Koopamax = builder.defineInRange("Koopa Max", 2, 0, 640);
        Koopaweight = builder.defineInRange("Koopa Weight", 7, 0, 100);
        builder.pop();

        Koopabiomes = builder
                .comment("Biomes for Koopa spawning)").defineList("Koopa Spawn Biomes", Arrays.asList("minecraft:taiga", "minecraft:mountains", "minecraft:jungle"), s -> s instanceof String);

        Goombabiomes = builder
                .comment("Biomes for Goomba spawning")
                .defineList("Goomba Spawn Biomes", Arrays.asList("minecraft:forest", "minecraft:plains", "minecraft:desert"), s -> s instanceof String);
    }

}


