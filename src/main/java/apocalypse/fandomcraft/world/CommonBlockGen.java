package apocalypse.fandomcraft.world;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;

public class CommonBlockGen implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1: {
                this.generateInNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 0: {
                this.generateInOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 1: {
                this.generateInEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
        }
    }
    
    private void generateInEnd(final World world, final Random random, final int x, final int z) {
    }
    
    private void generateInOverworld(final World world, final Random random, final int x, final int z) {
        for (int i = 0; i < 15; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(128);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.RockStone, 50, Blocks.stone).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 5; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(5);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.bloodstone, 50).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 15; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(128);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.gneiss, 35, Blocks.stone).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 8; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(63);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.slate, 20, (Block)Blocks.sand).generate(world, random, chunkX, chunkY, chunkZ);
            new WorldGenMinable(Main.slate, 20, Blocks.sandstone).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 10; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(62);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.shale, 30, (Block)Blocks.sand).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 5; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(72);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.marble, 40).generate(world, random, chunkX, chunkY, chunkZ);
        }
    }
    
    private void generateInNether(final World world, final Random random, final int x, final int z) {
    }
}
