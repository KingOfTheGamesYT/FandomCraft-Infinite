package apocalypse.fandomcraft.zelda;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.entity.*;
import net.minecraft.entity.*;

public class itemBomb extends Item
{
    public itemBomb() {
        this.setMaxStackSize(1);
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        world.playSoundAtEntity((Entity)player, "fandomcraft:bombThrow", 0.5f, 0.4f / (itemBomb.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote) {
            world.spawnEntityInWorld((Entity)new EntityBomb(world, (EntityLivingBase)player));
        }
        return stack;
    }
}
