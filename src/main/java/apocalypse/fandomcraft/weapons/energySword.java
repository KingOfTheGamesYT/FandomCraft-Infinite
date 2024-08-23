package apocalypse.fandomcraft.weapons;

import net.minecraft.item.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class energySword extends ItemSword
{
    public energySword(final Item.ToolMaterial EnergySword) {
        super(EnergySword);
        this.setMaxStackSize(1);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack itemstack) {
        return true;
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Massive power but");
        list.add("loses energy quickly.");
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        world.playSoundAtEntity((Entity)player, "fandomcraft:lightsaber", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        return stack;
    }
}
