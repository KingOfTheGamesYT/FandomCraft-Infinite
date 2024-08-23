package apocalypse.fandomcraft.otherworld;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.biome.*;

public class BiomeDecorate extends BiomeDecorator
{
    public static World currentWorld;
    public static Random randomGenerator;
    public static int chunk_X;
    public static int chunk_Z;
    public static boolean generateLakes;
    public static int howManyTrees;
    
    public BiomeDecorate() {
        BiomeDecorate.generateLakes = true;
    }
    
    public void decorateChunk(final World world, final Random random, final BiomeGenBase biomeGenBase, final int chunkX, final int chunkZ) {
        if (BiomeDecorate.currentWorld != null) {
            throw new RuntimeException("Already doing this.");
        }
        BiomeDecorate.currentWorld = world;
        BiomeDecorate.randomGenerator = random;
        BiomeDecorate.chunk_X = chunkX;
        BiomeDecorate.chunk_Z = chunkZ;
        this.genDecorationsForBiome(world, random, biomeGenBase);
        BiomeDecorate.currentWorld = null;
        BiomeDecorate.randomGenerator = null;
    }
    
    protected void genDecorationsForBiome(final World world, final Random rand, final BiomeGenBase biome) {
        BiomeDecoratorHelper.decorateBiome(world, rand, biome);
    }
}
