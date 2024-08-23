package apocalypse.fandomcraft.weapons;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;

public class iceRod extends ItemSword
{
    public iceRod(final Item.ToolMaterial material) {
        super(material);
        this.setMaxStackSize(1);
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 0.5f, 0.4f / (iceRod.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld((Entity)new EntitySnowball(par2World, (EntityLivingBase)par3EntityPlayer));
        }
        return par1ItemStack;
    }
}
