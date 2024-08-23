package apocalypse.fandomcraft.structures;

import net.minecraft.world.*;
import java.util.*;
import apocalypse.fandomcraft.fable.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.nbt.*;

public class DungeonRaft extends StructureComponent
{
    public void generateSurface(final World world, final Random random, final int chunkX, final int chunkZ, final int chunkY) {
        final int j = world.getHeightValue(chunkX, chunkZ) - 1;
        if ((world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.equals(BiomeGen.ocean.biomeName) || world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.equals(BiomeGen.deepOcean.biomeName)) && random.nextInt(10) + 1 <= 9) {
            final boolean place = true;
            if (place && world.getBlock(chunkX, j, chunkZ) == Blocks.water) {
                world.setBlock(chunkX + 4, j + 0, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 0, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 0, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 0, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 0, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 0, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 0, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 0, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 0, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 0, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 1, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 1, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 1, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 1, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 1, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 1, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 1, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 1, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 1, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 2, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 2, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 2, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 2, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 2, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 2, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 2, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 2, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 2, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 3, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 3, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 3, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 3, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 3, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 3, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 3, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 3, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 3, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 4, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 4, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 4, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 4, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 4, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 4, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 4, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 4, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 4, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 5, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 5, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 5, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 5, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 5, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 5, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 5, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 5, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 6, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 6, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 6, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 6, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 6, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 6, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 6, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 6, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 6, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 7, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 7, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 7, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 7, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 7, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 7, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 7, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 7, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 7, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 8, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 8, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 8, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 8, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 8, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 8, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 8, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 8, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 8, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 9, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 9, Blocks.log, 4, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 9, Blocks.log, 4, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 9, Blocks.log, 4, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 9, Blocks.log, 4, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 9, Blocks.log, 4, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 9, Blocks.log, 4, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 9, Blocks.log, 4, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 9, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 1, chunkZ + 10, Blocks.log, 8, 2);
                world.setBlock(chunkX + 1, j + 1, chunkZ + 10, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 2, j + 1, chunkZ + 10, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 3, j + 1, chunkZ + 10, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 4, j + 1, chunkZ + 10, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 5, j + 1, chunkZ + 10, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 6, j + 1, chunkZ + 10, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 7, j + 1, chunkZ + 10, (Block)Blocks.wooden_slab, 1, 2);
                world.setBlock(chunkX + 8, j + 1, chunkZ + 10, Blocks.log, 8, 2);
                world.setBlock(chunkX + 0, j + 2, chunkZ + 2, Main.bluePot, 0, 2);
                world.setBlock(chunkX + 8, j + 2, chunkZ + 2, Main.bluePot, 0, 2);
                world.setBlock(chunkX + 4, j + 2, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 0, j + 2, chunkZ + 8, Main.bluePot, 0, 2);
                world.setBlock(chunkX + 8, j + 2, chunkZ + 8, Main.bluePot, 0, 2);
                world.setBlock(chunkX + 4, j + 3, chunkZ + 5, Blocks.mob_spawner, 0, 2);
                final int x = chunkX + 4;
                final int y = j + 3;
                final int z = chunkZ + 5;
                final TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
                if (tileentitymobspawner1 != null) {
                    tileentitymobspawner1.func_145881_a().setEntityName("EntityBokoblin");
                }
                else {
                    System.err.println("Failed to fetch mob spawner entity at (" + x + ", " + y + ", " + z + ")");
                }
                world.setBlock(chunkX + 4, j + 4, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 4, j + 5, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 4, j + 6, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 4, j + 6, chunkZ + 6, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 6, chunkZ + 7, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 6, chunkZ + 8, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 7, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 4, j + 7, chunkZ + 7, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 7, chunkZ + 8, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 7, chunkZ + 9, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 7, chunkZ + 10, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 7, chunkZ + 11, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 7, chunkZ + 12, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 8, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 4, j + 8, chunkZ + 7, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 8, chunkZ + 8, Blocks.wool, 4, 2);
                world.setBlock(chunkX + 4, j + 8, chunkZ + 9, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 8, chunkZ + 10, Blocks.wool, 4, 2);
                world.setBlock(chunkX + 4, j + 8, chunkZ + 11, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 9, chunkZ + 5, Blocks.log, 0, 2);
                world.setBlock(chunkX + 4, j + 9, chunkZ + 6, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 9, chunkZ + 7, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 9, chunkZ + 8, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 9, chunkZ + 9, Blocks.wool, 4, 2);
                world.setBlock(chunkX + 4, j + 9, chunkZ + 10, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 9, chunkZ + 11, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 10, chunkZ + 8, Blocks.wool, 15, 2);
                world.setBlock(chunkX + 4, j + 10, chunkZ + 9, Blocks.wool, 15, 2);
                System.out.println("Built a pirate dungeon at (" + chunkX + ", " + j + ", " + chunkZ + ")");
            }
        }
    }

    @Override
    protected void func_143012_a(NBTTagCompound p_143012_1_) {

    }

    @Override
    protected void func_143011_b(NBTTagCompound p_143011_1_) {

    }

    public boolean addComponentParts(final World world, final Random r, final StructureBoundingBox box) {
        this.generateSurface(world, r, this.coordBaseMode, this.coordBaseMode, this.coordBaseMode);
        return true;
    }
    
    protected void writeStructureToNBT(final NBTTagCompound p_143012_1_) {
    }
    
    protected void readStructureFromNBT(final NBTTagCompound p_143011_1_) {
    }
}
