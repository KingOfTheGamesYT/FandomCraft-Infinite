package apocalypse.fandomcraft.otherworld.structures;

import net.minecraft.world.gen.feature.*;
import cpw.mods.fml.common.*;
import net.minecraft.world.*;
import java.util.*;
import apocalypse.fandomcraft.main.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.*;

public class WorldGenOWDeathPlant extends WorldGenerator implements IWorldGenerator
{
    public boolean generate(final World world, final Random rand, final int x, int y, final int z) {
        y = world.getHeightValue(x, z);
        Tools.println("Checking for deathplant placement at " + x + ", " + y + ", " + z + ".");
        Tools.println("Block found is '" + world.getBlock(x, y, z).getUnlocalizedName() + ".'");
        Tools.println("Block two above is '" + world.getBlock(x, y + 2, z).getUnlocalizedName() + ".'");
        Tools.println("Block below is '" + world.getBlock(x, y - 1, z).getUnlocalizedName() + ".'");
        Tools.printcon("Trying to generate deathplant");
        if (world.getBlock(x, y - 1, z) == HorrorReg.bloodGrass && world.getBlock(x, y, z) == Blocks.air) {
            Tools.printcon("Generating deathplant");
            world.setBlock(x, y, z, HorrorReg.plant_grass, 0, 2);
        }
        return true;
    }
    
    public void generate(final Random random, final int x, final int z, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        final int chunkX = x * 16 + random.nextInt(16);
        final int chunkZ = z * 16 + random.nextInt(16);
        final int chunkY = world.getHeightValue(chunkX, chunkZ);
        for (int i = 0; i < 10; ++i) {
            this.generate(world, random, chunkX, chunkY, chunkZ);
        }
    }
}
