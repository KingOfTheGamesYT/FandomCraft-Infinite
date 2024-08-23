package apocalypse.fandomcraft.items;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class antivenom extends ItemFood
{
    public antivenom(final int hunger, final float saturation, final boolean alwaysEdible) {
        super(hunger, saturation, alwaysEdible);
        this.maxStackSize = 24;
    }
    
    public void onFoodEaten(final ItemStack itemstack, final World world, final EntityPlayer player) {
        world.playSoundAtEntity((Entity)player, "random.burp", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        player.removePotionEffect(2);
        player.removePotionEffect(4);
        player.removePotionEffect(9);
        player.removePotionEffect(17);
        player.removePotionEffect(18);
        player.removePotionEffect(19);
        player.removePotionEffect(20);
    }
    
    public EnumAction getItemUseAction(final ItemStack itemstack) {
        return EnumAction.drink;
    }
}
