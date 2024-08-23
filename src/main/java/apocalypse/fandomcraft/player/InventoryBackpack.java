package apocalypse.fandomcraft.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryBackpack implements IInventory {
    private String name = "Inventory Item";
    public static final int INV_SIZE = 20;
    private ItemStack[] inventory = new ItemStack[20];
    private final ItemStack invItem;

    public InventoryBackpack(ItemStack stack) {
        this.invItem = stack;
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        this.readFromNBT(stack.getTagCompound());
    }

    public int getSizeInventory() {
        return this.inventory.length;
    }

    public ItemStack getStackInSlot(int slot) {
        return this.inventory[slot];
    }

    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = this.getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize > amount) {
                stack = stack.splitStack(amount);
                this.markDirty();
            } else {
                this.setInventorySlotContents(slot, (ItemStack)null);
            }
        }

        return stack;
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = this.getStackInSlot(slot);
        if (stack != null) {
            this.setInventorySlotContents(slot, (ItemStack)null);
        }

        return stack;
    }

    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        this.inventory[slot] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    public String getInventoryName() {
        return this.name;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void markDirty() {
        for(int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0) {
                this.inventory[i] = null;
            }
        }

        this.writeToNBT(this.invItem.getTagCompound());
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return player.getHeldItem() == this.invItem;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return !(itemstack.getItem() instanceof Backpack);
    }

    public void readFromNBT(NBTTagCompound tagcompound) {
        NBTTagList items = tagcompound.getTagList("ItemInventory", 10);

        for(int i = 0; i < items.tagCount(); ++i) {
            NBTTagCompound item = items.getCompoundTagAt(i);
            byte slot = item.getByte("Slot");
            if (slot >= 0 && slot < this.getSizeInventory()) {
                this.inventory[slot] = ItemStack.loadItemStackFromNBT(item);
            }
        }

    }

    public void writeToNBT(NBTTagCompound tagcompound) {
        NBTTagList items = new NBTTagList();

        for(int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) != null) {
                NBTTagCompound item = new NBTTagCompound();
                item.setInteger("Slot", i);
                this.getStackInSlot(i).writeToNBT(item);
                items.appendTag(item);
            }
        }

        tagcompound.setTag("ItemInventory", items);
    }
}
