package apocalypse.fandomcraft.weapons;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.enchantment.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraft.client.renderer.texture.*;

public class compoundBow extends Item
{
    public static final String[] bowPullIconNameArray;
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    
    public compoundBow() {
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Powered Arrows lose charge on hit.");
    }
    
    public void onPlayerStoppedUsing(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer, final int par4) {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
        final ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return;
        }
        j = event.charge;
        final boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
        if (flag || par3EntityPlayer.inventory.hasItem(Main.eridiumArrow)) {
            float f = j / 20.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            final EntityArrow entityarrow = new EntityArrow(par2World, (EntityLivingBase)par3EntityPlayer, f * 2.0f);
            entityarrow.setDamage(entityarrow.getDamage() + 2.0);
            if (f == 1.0f) {
                entityarrow.setIsCritical(true);
            }
            final int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
            if (k > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + k * 0.5 + 0.5);
            }
            final int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
            if (l > 0) {
                entityarrow.setKnockbackStrength(l);
            }
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
                entityarrow.setFire(100);
            }
            par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
            par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 1.0f, 1.0f / (compoundBow.itemRand.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
            if (flag) {
                entityarrow.canBePickedUp = 2;
            }
            else {
                par3EntityPlayer.inventory.consumeInventoryItem(Main.eridiumArrow);
            }
            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld((Entity)entityarrow);
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
        final ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCanceled()) {
            return event.result;
        }
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Main.eridiumArrow)) {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }
        return par1ItemStack;
    }
    
    public int getItemEnchantability() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("fandomcraft:cbow_standby");
        this.iconArray = new IIcon[compoundBow.bowPullIconNameArray.length];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon("fandomcraft:cbow_" + compoundBow.bowPullIconNameArray[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(final int par1) {
        return this.iconArray[par1];
    }
    
    static {
        bowPullIconNameArray = new String[] { "pulling_0", "pulling_1", "pulling_2" };
    }
}
