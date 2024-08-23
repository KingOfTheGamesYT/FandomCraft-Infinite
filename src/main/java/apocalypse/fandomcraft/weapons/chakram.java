package apocalypse.fandomcraft.weapons;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.entity.*;
import net.minecraft.entity.*;

public class chakram extends ItemSword
{
    public chakram(final Item.ToolMaterial m) {
        super(m);
        this.setMaxStackSize(1);
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World par2World, final EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        par2World.playSoundAtEntity((Entity)player, "random.bow", 1.0f, 1.0f);
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld((Entity)new EntityChakram(par2World, (EntityLivingBase)player, 8.0f));
        }
        return stack;
    }
}
