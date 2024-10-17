package apocalypse.fandomcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;

import java.util.List;

public class rupee extends Item {
    public String lore;

    public rupee(String description) {
        lore = description;
    }

    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add(lore);
    }
}
