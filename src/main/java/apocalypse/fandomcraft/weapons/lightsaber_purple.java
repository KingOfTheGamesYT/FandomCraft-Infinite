package apocalypse.fandomcraft.weapons;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class lightsaber_purple extends ItemSword
{
    public lightsaber_purple(final Item.ToolMaterial Lightsaber) {
        super(Lightsaber);
        this.setMaxStackSize(1);
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        world.playSoundAtEntity((Entity)player, "fandomcraft:energysword", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        return stack;
    }
}
