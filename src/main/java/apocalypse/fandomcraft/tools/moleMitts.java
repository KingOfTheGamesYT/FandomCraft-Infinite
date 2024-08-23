package apocalypse.fandomcraft.tools;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class moleMitts extends ItemPickaxe
{
    public moleMitts(final Item.ToolMaterial MoleMitts) {
        super(MoleMitts);
        this.setMaxStackSize(1);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Mine faster!");
    }
}
