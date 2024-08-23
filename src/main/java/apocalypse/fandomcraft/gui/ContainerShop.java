package apocalypse.fandomcraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class ContainerShop extends Container {
    public ContainerShop(EntityPlayer par1Player) {
    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        return null;
    }
}
