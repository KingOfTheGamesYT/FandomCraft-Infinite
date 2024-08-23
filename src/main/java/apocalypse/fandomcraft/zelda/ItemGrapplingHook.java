package apocalypse.fandomcraft.zelda;

import apocalypse.fandomcraft.main.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import apocalypse.fandomcraft.entity.*;
import net.minecraft.client.renderer.texture.*;

public class ItemGrapplingHook extends Item
{
    public ItemGrapplingHook() {
        this.setMaxStackSize(1);
        this.setCreativeTab(Main.tabFandomCraftTools);
        this.setMaxDamage(128);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (player.capabilities.isCreativeMode) {
            return stack;
        }
        stack.damageItem(1, (EntityLivingBase)player);
        world.playSoundAtEntity((Entity)player, "fandomcraft:ropeThrow", 0.5f, 0.4f / (Item.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.isRemote) {
            world.spawnEntityInWorld((Entity)new GrappledHook(world, (EntityLivingBase)player));
        }
        return stack;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister register) {
        this.itemIcon = register.registerIcon(this.getIconString());
    }
    
    public boolean isItemTool(final ItemStack p_77616_1_) {
        return super.isItemTool(p_77616_1_);
    }
    
    public int getItemEnchantability() {
        return 0;
    }
}
