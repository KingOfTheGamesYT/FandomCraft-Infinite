package apocalypse.fandomcraft.otherworld.structures;

import net.minecraft.world.gen.feature.*;
import cpw.mods.fml.common.*;
import net.minecraft.world.*;
import java.util.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.*;

public class WorldGenOWRockTall extends WorldGenerator implements IWorldGenerator
{
    public boolean generate(final World world, final Random rand, final int i, int j, final int k) {
        j = world.getHeightValue(i, k);
        if (world.getBlock(i + 1, j - 1, k + 1) == HorrorReg.bloodGrass && world.getBlock(i + 1, j + 5, k + 1) == Blocks.air && world.getBlock(i + 1, j + 11, k + 1) == Blocks.air) {
            world.setBlock(i + 1, j + 0, k + 0, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 0, j + 0, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 0, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 0, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 0, k + 2, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 1, k + 0, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 0, j + 1, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 1, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 1, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 1, k + 2, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 2, k + 0, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 0, j + 2, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 2, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 2, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 2, k + 2, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 3, k + 0, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 0, j + 3, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 3, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 3, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 3, k + 2, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 4, k + 0, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 0, j + 4, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 4, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 4, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 5, k + 0, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 0, j + 5, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 5, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 5, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 0, j + 6, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 6, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 6, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 7, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 7, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 8, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 2, j + 8, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 9, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 10, k + 1, HorrorReg.bloodGrass, 0, 2);
            world.setBlock(i + 1, j + 11, k + 1, HorrorReg.bloodGrass, 0, 2);
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
