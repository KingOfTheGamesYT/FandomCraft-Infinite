package apocalypse.fandomcraft.structures;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.nbt.*;

public class DungeonTwilightGate extends StructureComponent
{
    public boolean place;
    
    public void generateStart(final World world, final Random random, final int chunkX, final int chunkY, final int chunkZ) {
        final int y = world.getHeightValue(chunkX, chunkZ) + 10;
        this.place = true;
        if (this.place && y < 200) {
            world.setBlock(chunkX + 7, y - 8, chunkZ + 8, Blocks.mob_spawner, 0, 2);
            final int x1 = chunkX + 7;
            final int y2 = y - 8;
            final int z1 = chunkZ + 8;
            final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x1, y2, z1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a().setEntityName("ShadowBeast");
            }
            else {
                System.err.println("Failed to fetch mob spawner entity at (" + x1 + ", " + y2 + ", " + z1 + ")");
            }
            world.setBlock(chunkX + 13, y + 7, chunkZ + 0, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 7, chunkZ + 1, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 1, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 13, y + 7, chunkZ + 1, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 7, chunkZ + 2, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 2, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 2, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 2, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 2, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 13, y + 7, chunkZ + 2, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 3, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 3, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 3, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 3, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 3, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 4, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 4, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 4, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 6, y + 7, chunkZ + 4, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 4, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 4, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 4, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 5, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 6, y + 7, chunkZ + 5, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 5, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 7, chunkZ + 5, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 5, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 5, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 5, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 7, chunkZ + 6, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 7, chunkZ + 6, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 14, y + 7, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 1, y + 7, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 7, chunkZ + 7, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 7, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 7, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 7, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 13, y + 7, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 14, y + 7, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 1, y + 7, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 7, chunkZ + 8, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 8, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 8, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 13, y + 7, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 0, y + 7, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 1, y + 7, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 9, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 9, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 7, chunkZ + 10, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 7, chunkZ + 10, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 10, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 2, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 7, chunkZ + 11, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 5, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 11, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 12, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 7, chunkZ + 12, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 12, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 10, y + 7, chunkZ + 12, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 12, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 12, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 7, chunkZ + 13, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 7, chunkZ + 13, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 7, chunkZ + 13, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 13, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 7, chunkZ + 13, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 13, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 13, y + 7, chunkZ + 13, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 7, chunkZ + 14, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 14, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 7, chunkZ + 14, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 13, y + 7, chunkZ + 14, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 15, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 7, chunkZ + 15, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 7, chunkZ + 16, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 8, chunkZ + 2, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 8, chunkZ + 2, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 8, chunkZ + 3, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 4, y + 8, chunkZ + 3, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 8, chunkZ + 3, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 8, chunkZ + 4, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 8, chunkZ + 4, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 8, chunkZ + 5, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 6, y + 8, chunkZ + 5, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 8, chunkZ + 5, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 10, y + 8, chunkZ + 5, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 8, chunkZ + 6, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 5, y + 8, chunkZ + 6, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 6, y + 8, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 8, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 8, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 8, chunkZ + 6, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 3, y + 8, chunkZ + 7, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 4, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 8, chunkZ + 7, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 8, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 12, y + 8, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 13, y + 8, chunkZ + 7, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 1, y + 8, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 2, y + 8, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 8, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 8, chunkZ + 8, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 8, y + 8, chunkZ + 8, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 9, y + 8, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 8, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 8, chunkZ + 8, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 4, y + 8, chunkZ + 9, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 5, y + 8, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 8, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 8, chunkZ + 9, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 8, y + 8, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 8, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 8, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 5, y + 8, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 8, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 8, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 8, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 8, chunkZ + 10, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 3, y + 8, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 4, y + 8, chunkZ + 11, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 6, y + 8, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 8, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 8, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 10, y + 8, chunkZ + 11, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 8, chunkZ + 11, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 3, y + 8, chunkZ + 12, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 8, chunkZ + 12, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 11, y + 8, chunkZ + 12, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 8, chunkZ + 13, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 6, y + 9, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 9, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 9, chunkZ + 7, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 9, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 9, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 9, y + 9, chunkZ + 8, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 6, y + 9, chunkZ + 9, Main.twilightStone, 0, 2);
            world.setBlock(chunkX + 7, y + 9, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 8, y + 9, chunkZ + 9, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 9, chunkZ + 10, Main.twilightBrick3, 0, 2);
            world.setBlock(chunkX + 7, y + 10, chunkZ + 8, Main.twilightBrick3, 0, 2);
            System.out.print("FandomCraft] Built a Twilight Gate at (" + chunkX + ", " + y + ", " + chunkZ + ")");
        }
    }

    @Override
    protected void func_143012_a(NBTTagCompound p_143012_1_) {

    }

    @Override
    protected void func_143011_b(NBTTagCompound p_143011_1_) {

    }

    public boolean addComponentParts(final World world, final Random r, final StructureBoundingBox box) {
        this.generateStart(world, r, this.coordBaseMode, this.coordBaseMode, this.coordBaseMode);
        return true;
    }
    
    protected void writeStructureToNBT(final NBTTagCompound p_143012_1_) {
    }
    
    protected void readStructureFromNBT(final NBTTagCompound p_143011_1_) {
    }
}
