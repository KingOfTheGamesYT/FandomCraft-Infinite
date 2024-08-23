package apocalypse.fandomcraft.items;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class cola extends ItemFood
{
    public cola(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
        this.maxStackSize = 16;
    }
    
    public void onFoodEaten(final ItemStack itemstack, final World world, final EntityPlayer player) {
        world.playSoundAtEntity((Entity)player, "random.burp", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
    }
    
    public EnumAction getItemUseAction(final ItemStack itemstack) {
        return EnumAction.drink;
    }
}
