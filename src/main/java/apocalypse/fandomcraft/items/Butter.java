package apocalypse.fandomcraft.items;

import net.minecraft.item.*;

public class Butter extends ItemFood
{
    public Butter(final int hunger, final float saturation, final boolean wolfFood) {
        super(hunger, saturation, wolfFood);
    }
    
    public EnumAction getItemUseAction(final ItemStack itemstack) {
        return EnumAction.drink;
    }
}
