package apocalypse.fandomcraft.otherworld;

import net.minecraft.world.gen.structure.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.terraingen.*;
import cpw.mods.fml.common.eventhandler.*;

public class BiomeDecoratorHelper
{
    private static WorldGenerator gravititeGen;
    private static WorldGenerator rustGen;
    private static StructureComponent bloodTreeSmall;
    
    public BiomeDecoratorHelper() {
        BiomeDecoratorHelper.gravititeGen = (WorldGenerator)new WorldGenMinable(HorrorReg.gravitite, 10, HorrorReg.bloodstoneRock);
        BiomeDecoratorHelper.rustGen = (WorldGenerator)new WorldGenMinable(HorrorReg.bloodstoneOre, 10, HorrorReg.bloodstoneRock);
    }
    
    protected static void decorateBiome(final World world, final Random rand, final BiomeGenBase biome) {
        MinecraftForge.EVENT_BUS.post((Event)new DecorateBiomeEvent.Pre(world, rand, BiomeDecorate.chunk_X, BiomeDecorate.chunk_Z));
        initOres();
        generateOreInBiome(biome);
        if (biome == FCBiomes.badlands) {}
        if (biome == FCBiomes.bloodwood) {}
    }
    
    private static void initOres() {
        BiomeDecoratorHelper.gravititeGen = (WorldGenerator)new WorldGenMinable(HorrorReg.gravitite, 10, HorrorReg.bloodstoneRock);
        BiomeDecoratorHelper.rustGen = (WorldGenerator)new WorldGenMinable(HorrorReg.bloodstoneOre, 10, HorrorReg.bloodstoneRock);
    }
    
    private static void generateOreInBiome(final BiomeGenBase biome) {
        if (biome == FCBiomes.badlands) {
            genStandardOre(8, BiomeDecoratorHelper.gravititeGen, 20, 70);
            genStandardOre(8, BiomeDecoratorHelper.rustGen, 10, 40);
        }
    }
    
    private static void genStandardOre(final int spawnWeight, final WorldGenerator generatorToSpawn, final int minSpawnHeight, final int maxYSpawnHeight) {
        for (int l = 0; l < spawnWeight; ++l) {
            final int i1 = BiomeDecorate.chunk_X + BiomeDecorate.randomGenerator.nextInt(16);
            final int j1 = BiomeDecorate.randomGenerator.nextInt(maxYSpawnHeight - minSpawnHeight) + minSpawnHeight;
            final int k1 = BiomeDecorate.chunk_Z + BiomeDecorate.randomGenerator.nextInt(16);
            generatorToSpawn.generate(BiomeDecorate.currentWorld, BiomeDecorate.randomGenerator, i1, j1, k1);
        }
    }
}
