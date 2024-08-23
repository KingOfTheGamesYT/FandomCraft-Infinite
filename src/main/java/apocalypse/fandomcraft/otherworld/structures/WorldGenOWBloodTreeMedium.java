package apocalypse.fandomcraft.otherworld.structures;

import net.minecraft.world.gen.feature.*;
import cpw.mods.fml.common.*;
import net.minecraft.world.*;
import java.util.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.init.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.world.chunk.*;

public class WorldGenOWBloodTreeMedium extends WorldGenerator implements IWorldGenerator
{
    public boolean generate(final World world, final Random rand, final int x, int y, final int z) {
        y = world.getHeightValue(x, z);
        if (world.getBlock(x + 2, y - 1, z + 2) == HorrorReg.bloodGrass && world.getBlock(x + 2, y + 4, z + 2) == Blocks.air && world.getBlock(x + 2, y + 9, z + 2) == Blocks.air) {
            ++y;
            world.setBlock(x + 2, y, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 2, y + 1, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 2, y + 2, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 2, y + 3, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 3, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 3, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 3, y + 3, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 3, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 4, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 4, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 4, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 4, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 4, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 4, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 4, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 3, y + 4, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 4, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 4, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 4, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 4, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 4, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 5, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 5, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 5, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 5, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 5, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 5, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 5, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 5, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 5, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 5, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 5, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 3, y + 5, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 5, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 5, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 5, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 5, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 5, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 5, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 5, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 5, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 5, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 6, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 6, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 6, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 6, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 6, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 6, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 6, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 6, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 6, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 6, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 6, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 3, y + 6, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 6, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 6, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 6, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 6, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 6, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 6, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 6, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 6, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 6, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 7, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 7, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 7, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 7, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 7, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 7, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 7, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 7, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 7, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 7, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 7, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 3, y + 7, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 7, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 7, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 7, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 7, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 7, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 7, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 7, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 7, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 7, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 8, z, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 8, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 8, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 8, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x, y + 8, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 8, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 8, z + 2, Main.bloodstone, 0, 2);
            world.setBlock(x + 3, y + 8, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 4, y + 8, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 8, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 8, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 8, z + 3, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 8, z + 4, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 9, z + 1, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 1, y + 9, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 9, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 3, y + 9, z + 2, HorrorReg.bloodleaf, 0, 2);
            world.setBlock(x + 2, y + 9, z + 3, HorrorReg.bloodleaf, 0, 2);
        }
        return true;
    }
    
    public void generate(final Random random, int x, final int z, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        final int chunkX = x * 16 + random.nextInt(16);
        final int chunkZ = z * 16 + random.nextInt(16);
        final int chunkY = world.getHeightValue(chunkX, chunkZ);
        final int i = 0;
        while (i < 10) {
            this.generate(world, random, chunkX, chunkY, chunkZ);
            ++x;
        }
    }
}
