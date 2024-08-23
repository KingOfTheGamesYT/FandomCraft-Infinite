package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class paupu extends ItemFood
{
    public paupu(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Connecting friends' hearts since 2001!");
    }
}
