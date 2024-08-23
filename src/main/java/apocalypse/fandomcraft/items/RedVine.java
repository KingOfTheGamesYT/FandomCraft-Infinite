package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import java.util.*;

public class RedVine extends ItemFood
{
    private int[] potionEffect;
    private int[] potionTier;
    
    public RedVine(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
        this.potionEffect = new int[] { 6 };
        this.potionTier = new int[] { 4 };
        this.setAlwaysEdible();
    }
    
    public void onFoodEaten(final ItemStack itemstack, final World world, final EntityPlayer player) {
        this.addPotionEffects(itemstack, world, player);
    }
    
    protected void addPotionEffects(final ItemStack item, final World world, final EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(this.potionEffect[0], this.potionTier[0]));
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Delicacy of parallel universes since 2008!");
    }
}
