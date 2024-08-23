package apocalypse.fandomcraft.weapons;

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

public class pulseRifle extends Item
{
    public static final String[] chargingArray;
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    
    public pulseRifle() {
        this.maxStackSize = 1;
        this.setMaxDamage(1200);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Charge up for more");
        list.add("powerful shots!");
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
        if (flag || player.inventory.hasItem(Main.energyCrystal)) {
            float f = j / 20.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            final EntityEnergyBall entityenergyball = new EntityEnergyBall(world, (EntityLivingBase)player, f * 2.0f);
            stack.damageItem(1, (EntityLivingBase)player);
            world.playSoundAtEntity((Entity)player, "fandomcraft:shoot", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
            player.inventory.consumeInventoryItem(Main.energyCrystal);
            if (!world.isRemote) {
                world.spawnEntityInWorld((Entity)entityenergyball);
            }
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
        par2World.playSoundAtEntity((Entity)par3EntityPlayer, "fandomcraft:charge", 0.5f, par2World.rand.nextFloat() * 0.1f + 0.9f);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return event.result;
        }
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Main.energyCrystal)) {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("fandomcraft:pulseRifle");
        this.iconArray = new IIcon[pulseRifle.chargingArray.length];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(final int par1) {
        return this.iconArray[par1];
    }
    
    static {
        chargingArray = new String[] { "charging" };
    }
}
