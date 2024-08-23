package apocalypse.fandomcraft.otherworld.structures;

import net.minecraft.world.gen.feature.*;
import cpw.mods.fml.common.*;
import net.minecraft.world.*;
import java.util.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.*;

public class WorldGenOWGrass extends WorldGenerator implements IWorldGenerator
{
    public boolean generate(final World world, final Random rand, final int x, int y, final int z) {
        y = world.getHeightValue(x, z);
        if (world.getBlock(x, y - 1, z) == HorrorReg.bloodGrass && world.getBlock(x, y, z) == Blocks.air) {
            world.setBlock(x, y, z, HorrorReg.plant_grass, 0, 2);
        }
        return true;
    }
    
    public void generate(final Random random, final int x, final int z, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        final int chunkX = x * 16 + random.nextInt(16);
        final int chunkZ = z * 16 + random.nextInt(16);
        final int chunkY = world.getHeightValue(chunkX, chunkZ);
        for (int i = 0; i < 30; ++i) {
            this.generate(world, random, chunkX, chunkY, chunkZ);
        }
    }
}
