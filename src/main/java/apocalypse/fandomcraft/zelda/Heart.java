package apocalypse.fandomcraft.zelda;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.main.*;

public class Heart extends Item
{
    public Heart() {
        this.setMaxStackSize(1);
    }
    
    public void onPlayerRightClick() {
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        player.heal(2.0f);
        player.playSound("fandomcraft:heartGet", 1.0f, 1.0f);
        player.inventory.consumeInventoryItem(Main.heart);
        return stack;
    }
}
