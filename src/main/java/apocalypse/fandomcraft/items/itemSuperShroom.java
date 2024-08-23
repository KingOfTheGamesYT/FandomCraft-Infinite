package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import java.util.*;

public class itemSuperShroom extends ItemFood
{
    public itemSuperShroom(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
        this.maxStackSize = 1;
        this.setAlwaysEdible();
    }
    
    public void onFoodEaten(final ItemStack itemstack, final World world, final EntityPlayer player) {
        world.playSoundAtEntity((Entity)player, "random.burp", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        world.playSoundAtEntity((Entity)player, "fandomcraft:star", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        this.addPotionEffects(itemstack, world, player);
    }
    
    protected void addPotionEffects(final ItemStack item, final World world, final EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(11, 400, 2, false));
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Invincible!");
    }
}
