package apocalypse.fandomcraft.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmallLeatherTable extends TileEntity {
    public TileEntitySmallLeatherTable() {
    }

    public boolean canUpdate() {
        return true;
    }

    public void writeToNBT(NBTTagCompound par1) {
        super.writeToNBT(par1);
    }

    public void readFromNBT(NBTTagCompound par1) {
        super.readFromNBT(par1);
    }
}
