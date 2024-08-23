package apocalypse.fandomcraft.items;

import apocalypse.fandomcraft.main.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class growthMulch extends Item
{
    public growthMulch() {
        this.setCreativeTab(Main.tabFandomCraftTools);
        this.setTextureName("fandomcraft:growthMulch");
        this.setMaxDamage(128);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
    
    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        final UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return false;
        }
        if (event.getResult() == Event.Result.ALLOW) {
            par1ItemStack.damageItem(1, (EntityLivingBase)par2EntityPlayer);
            return true;
        }
        final Block block = par3World.getBlock(par4, par5, par6);
        if (par7 == 0 || !par3World.getBlock(par4, par5 + 1, par6).isAir((IBlockAccess)par3World, par4, par5 + 1, par6) || (block != Blocks.grass && block != Blocks.dirt)) {
            return false;
        }
        final Block block2 = Blocks.farmland;
        par3World.playSoundEffect((double)(par4 + 0.5f), (double)(par5 + 0.5f), (double)(par6 + 0.5f), block2.stepSound.getStepResourcePath(), (block2.stepSound.getVolume() + 1.0f) / 2.0f, block2.stepSound.getPitch() * 0.8f);
        if (par3World.isRemote) {
            return true;
        }
        par3World.setBlock(par4, par5, par6, block2);
        par1ItemStack.damageItem(1, (EntityLivingBase)par2EntityPlayer);
        return true;
    }
}
