package apocalypse.fandomcraft.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBackpack extends Container {
    public final InventoryBackpack inventory;
    public static final int INV_START = 20;
    public static final int INV_END = 46;
    public static final int HOTBAR_START = 47;
    public static final int HOTBAR_END = 55;

    public ContainerBackpack(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, InventoryBackpack inventoryItem) {
        this.inventory = inventoryItem;

        int i;
        for(i = 0; i < 20; ++i) {
            this.addSlotToContainer(new BackpackSlot(this.inventory, i, 80 + 18 * (i / 4), 8 + 18 * (i % 4)));
        }

        for(i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }

    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.inventory.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (par2 < 20) {
                if (!this.mergeItemStack(itemstack1, 20, 56, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 >= 20 && par2 < 47) {
                if (!this.mergeItemStack(itemstack1, 47, 56, false)) {
                    return null;
                }
            } else if (par2 >= 47 && par2 < 56 && !this.mergeItemStack(itemstack1, 20, 47, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

    public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
        return slot >= 0 && this.getSlot(slot) != null && this.getSlot(slot).getStack() == player.getHeldItem() ? null : super.slotClick(slot, button, flag, player);
    }

    protected boolean mergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4) {
        boolean flag1 = false;
        int k = par2;
        if (par4) {
            k = par3 - 1;
        }

        Slot slot;
        ItemStack itemstack1;
        int l;
        if (par1ItemStack.isStackable()) {
            while(par1ItemStack.stackSize > 0 && (!par4 && k < par3 || par4 && k >= par2)) {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();
                if (itemstack1 != null && itemstack1 == par1ItemStack && (!par1ItemStack.getHasSubtypes() || par1ItemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(par1ItemStack, itemstack1)) {
                    l = itemstack1.stackSize + par1ItemStack.stackSize;
                    if (l <= par1ItemStack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
                        par1ItemStack.stackSize = 0;
                        itemstack1.stackSize = l;
                        this.inventory.markDirty();
                        flag1 = true;
                    } else if (itemstack1.stackSize < par1ItemStack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
                        par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - itemstack1.stackSize;
                        itemstack1.stackSize = par1ItemStack.getMaxStackSize();
                        this.inventory.markDirty();
                        flag1 = true;
                    }
                }

                if (par4) {
                    --k;
                } else {
                    ++k;
                }
            }
        }

        if (par1ItemStack.stackSize > 0) {
            if (par4) {
                k = par3 - 1;
            } else {
                k = par2;
            }

            while(!par4 && k < par3 || par4 && k >= par2) {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();
                if (itemstack1 == null) {
                    l = par1ItemStack.stackSize;
                    if (l <= slot.getSlotStackLimit()) {
                        slot.putStack(par1ItemStack.copy());
                        par1ItemStack.stackSize = 0;
                        this.inventory.markDirty();
                        flag1 = true;
                        break;
                    }

                    this.putStackInSlot(k, new ItemStack(par1ItemStack.getItem(), slot.getSlotStackLimit()));
                    par1ItemStack.stackSize -= slot.getSlotStackLimit();
                    this.inventory.markDirty();
                    flag1 = true;
                }

                if (par4) {
                    --k;
                } else {
                    ++k;
                }
            }
        }

        return flag1;
    }
}
