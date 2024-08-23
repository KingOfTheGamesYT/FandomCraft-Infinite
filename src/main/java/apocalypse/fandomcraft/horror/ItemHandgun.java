package apocalypse.fandomcraft.horror;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.world.*;
import apocalypse.fandomcraft.main.*;
import apocalypse.fandomcraft.fable.*;
import net.minecraft.entity.*;
import apocalypse.fandomcraft.events.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class ItemHandgun extends Item
{
    public ItemHandgun() {
        this.maxStackSize = 1;
        this.setMaxDamage(400);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Requires Bullets");
    }
    
    public void onPlayerStoppedUsing(final ItemStack stack, final World world, final EntityPlayer player, final int i) {
        if (player.inventory.hasItem(Main.bullet)) {
            final ProjectileBullet entityenergyball = new ProjectileBullet(world, (EntityLivingBase)player, 5.0f);
            stack.damageItem(1, (EntityLivingBase)player);
            world.playSoundAtEntity((Entity)player, "fandomcraft:shot", 1.0f, 1.0f);
            player.inventory.consumeInventoryItem(Main.bullet);
            if (!world.isRemote) {
                world.spawnEntityInWorld((Entity)entityenergyball);
            }
        }
        else {
            world.playSoundAtEntity((Entity)player, "fandomcraft:emptyClip", 1.0f, 1.0f);
        }
    }
    
    public ItemStack onItemUseFinish(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final BulletChamberEvent event = new BulletChamberEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return event.result;
        }
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Main.bullet)) {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("fandomcraft:handgun");
    }
}
