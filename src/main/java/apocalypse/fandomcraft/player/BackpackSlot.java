package apocalypse.fandomcraft.player;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class BackpackSlot extends Slot {
    public BackpackSlot(IInventory par1iInventory, int par2, int par3, int par4) {
        super(par1iInventory, par2, par3, par4);
    }

    public boolean isItemValid(ItemStack itemstack) {
        return !(itemstack.getItem() instanceof Backpack);
    }
}
