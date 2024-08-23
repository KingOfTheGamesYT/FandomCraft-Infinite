package apocalypse.fandomcraft.items;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;

public class chestnut extends ItemFood
{
    private int[] potionEffect;
    private int[] potionTier;
    
    public chestnut(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
        this.potionEffect = new int[] { 7 };
        this.potionTier = new int[] { 0 };
    }
    
    public void onFoodEaten(final ItemStack itemstack, final World world, final EntityPlayer player) {
        this.addPotionEffects(itemstack, world, player);
    }
    
    protected void addPotionEffects(final ItemStack item, final World world, final EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(this.potionEffect[0], this.potionTier[0]));
    }
}
