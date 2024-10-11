package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;

import java.util.*;

public class rupeeYellow extends Item
{
    public rupeeYellow() {
        this.setMaxStackSize(64);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("A gem of 10 value.");
    }
}
