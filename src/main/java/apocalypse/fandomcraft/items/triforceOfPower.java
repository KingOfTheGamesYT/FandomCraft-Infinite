package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class triforceOfPower extends Item
{
    public triforceOfPower() {
        this.setMaxStackSize(1);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Power");
    }
}
