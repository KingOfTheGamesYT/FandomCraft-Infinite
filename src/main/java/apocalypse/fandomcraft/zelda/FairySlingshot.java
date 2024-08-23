package apocalypse.fandomcraft.zelda;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import apocalypse.fandomcraft.main.*;
import apocalypse.fandomcraft.entity.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.events.*;
import net.minecraft.client.renderer.texture.*;

public class FairySlingshot extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    
    public FairySlingshot() {
        this.maxStackSize = 1;
        this.setMaxDamage(500);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Use Deku Nuts");
        list.add("as ammo.");
    }
    
    public void onPlayerStoppedUsing(final ItemStack stack, final World world, final EntityPlayer player, final int i) {
        int j = this.getMaxItemUseDuration(stack) - i;
        final BulletLooseEvent event = new BulletLooseEvent(player, stack, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        final boolean flag = player.capabilities.isCreativeMode;
        if (flag || player.inventory.hasItem(Main.dekuNut)) {
            float f = j / 20.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            final EntityDekuNut entityenergyball = new EntityDekuNut(world, (EntityLivingBase)player, f * 2.0f);
            stack.damageItem(1, (EntityLivingBase)player);
            world.playSoundAtEntity((Entity)player, "random.bow", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
            player.inventory.consumeInventoryItem(Main.dekuNut);
            if (!world.isRemote) {
                world.spawnEntityInWorld((Entity)entityenergyball);
            }
        }
        else {
            world.playSoundAtEntity((Entity)player, "random.bow", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
        }
    }
    
    public ItemStack onItemUseFinish(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }
    
    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        final BulletChamberEvent event = new BulletChamberEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return event.result;
        }
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Main.dekuNut)) {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("fandomcraft:fairySlingshot");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(final int par1) {
        return this.iconArray[par1];
    }
}
