package apocalypse.fandomcraft.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmallWoodenTable extends TileEntity {
    public TileEntitySmallWoodenTable() {
    }

    public boolean canUpdate() {
        return false;
    }

    public void writeToNBT(NBTTagCompound par1) {
        super.writeToNBT(par1);
        new NBTTagList();
    }

    public void readFromNBT(NBTTagCompound par1) {
        super.readFromNBT(par1);
    }
}
