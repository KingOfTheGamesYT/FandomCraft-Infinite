package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class ragecandybar extends ItemFood
{
    public ragecandybar(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("A famous candybar from the Johto region.");
    }
}
