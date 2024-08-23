package apocalypse.fandomcraft.items;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;

public class ale extends ItemFood
{
    private int[] potionEffect;
    private int[] potionTier;
    private int[] potionDuration;
    
    public ale(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
        this.potionEffect = new int[] { 9 };
        this.potionTier = new int[] { 1 };
        this.potionDuration = new int[] { 30 };
        this.maxStackSize = 16;
    }
    
    public void onFoodEaten(final ItemStack itemstack, final World world, final EntityPlayer player) {
        world.playSoundAtEntity((Entity)player, "random.burp", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        this.addPotionEffects(itemstack, world, player);
    }
    
    protected void addPotionEffects(final ItemStack item, final World world, final EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(this.potionEffect[0], this.potionDuration[0], this.potionTier[0]));
    }
    
    public EnumAction getItemUseAction(final ItemStack itemstack) {
        return EnumAction.drink;
    }
}
