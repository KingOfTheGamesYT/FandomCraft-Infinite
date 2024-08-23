package apocalypse.fandomcraft.world;

import net.minecraft.world.gen.structure.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import java.util.*;

public abstract class FCStructure extends StructureComponent
{
    protected StructureBoundingBox boundingBox;
    protected int coordBaseMode;
    
    public int getCoordBaseMode() {
        return this.coordBaseMode;
    }
    
    protected int getXWithOffset(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return this.boundingBox.minX + x;
            }
            case 1: {
                return this.boundingBox.maxX - z;
            }
            case 2: {
                return this.boundingBox.maxX - x;
            }
            case 3: {
                return this.boundingBox.minX + z;
            }
            default: {
                return x;
            }
        }
    }
    
    protected int getYWithOffset(final int y) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return this.boundingBox.minY + y;
            }
            case 1: {
                return this.boundingBox.maxY - y;
            }
            default: {
                return y;
            }
        }
    }
    
    protected int getZWithOffset(final int x, final int z) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                return this.boundingBox.minZ + z;
            }
            case 1: {
                return this.boundingBox.minZ + x;
            }
            case 2: {
                return this.boundingBox.maxZ - z;
            }
            case 3: {
                return this.boundingBox.maxZ - x;
            }
            default: {
                return z;
            }
        }
    }
    
    protected void writeStructureToNBT(final NBTTagCompound p_143012_1_) {
    }
    
    protected void readStructureFromNBT(final NBTTagCompound p_143011_1_) {
    }
    
    public abstract boolean addComponentParts(final World p0, final Random p1, final StructureBoundingBox p2);
}
