package apocalypse.fandomcraft.weapons;

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

public class ArmCannon extends Item
{
    public ArmCannon() {
        this.maxStackSize = 1;
        this.setMaxDamage(1200);
        this.setFull3D();
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Requires Energy Tanks and Crystals as ammo");
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
        if (flag || player.inventory.hasItem(Main.energyTank)) {
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
            if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
                final ItemStack crown = player.getCurrentArmor(3);
                final ItemStack armour = player.getCurrentArmor(2);
                final ItemStack mail = player.getCurrentArmor(1);
                final ItemStack boots = player.getCurrentArmor(0);
                if (crown.getItem() != Main.powerHelmet || armour.getItem() != Main.powerPlate || mail.getItem() != Main.powerSuit || boots.getItem() != Main.powerBoots) {
                    player.inventory.consumeInventoryItem(Main.energyTank);
                }
            }
            world.playSoundAtEntity((Entity)player, "fandomcraft:shoot", 0.5f, world.rand.nextFloat() * 0.1f + 0.9f);
            if (!world.isRemote) {
                world.spawnEntityInWorld((Entity)entityenergyball);
            }
        }
        else {
            world.playSoundAtEntity((Entity)player, "fandomcraft:unable", 1.0f, 1.0f);
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
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Main.energyCrystal)) {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
}
