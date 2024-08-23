package apocalypse.fandomcraft.tools;

import net.minecraft.item.*;

public class plasticknife extends Item
{
    private ItemStack emptyItem;
    private static int maxDamage;
    
    public plasticknife() {
        this.emptyItem = null;
        this.setMaxStackSize(1);
        this.setMaxDamage(32);
    }
    
    public void setEmptyItem(final ItemStack ei) {
        this.emptyItem = ei;
    }
    
    public boolean doesContainerItemLeaveCraftingGrid(final ItemStack par1ItemStack) {
        return false;
    }
    
    public ItemStack getContainerItem(final ItemStack itemStack) {
        final ItemStack cStack = itemStack.copy();
        cStack.stackSize = 1;
        return cStack;
    }
    
    static {
        plasticknife.maxDamage = 32;
    }
}
