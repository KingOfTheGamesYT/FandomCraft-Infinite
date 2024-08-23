package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class rupeeBlue extends Item
{
    public rupeeBlue() {
        this.setMaxStackSize(64);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Value: 5.");
    }
}
