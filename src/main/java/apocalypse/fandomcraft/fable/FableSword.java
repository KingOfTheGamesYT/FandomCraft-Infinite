package apocalypse.fandomcraft.fable;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class FableSword extends Item {
    public static float attackDamage;
    public static boolean isBreakable;
    public String lore;
    public static int effectType;

    public FableSword(String description, int maxDurability, float attack, boolean breakable, int type) {
        this.maxStackSize = 1;  // Stack size remains 1, but we use max damage for durability.
        this.setMaxDamage(maxDurability);  // Set the sword's durability.
        attackDamage = attack;
        lore = description;
        effectType = type;
        isBreakable = breakable;  // Determines if the sword is breakable.
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
        return true;
    }

    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add(lore);  // Add the lore to the tooltip.
    }

    public float func_150931_i() {
        return attackDamage;
    }


    public float getStrVsBlock(ItemStack itemStack, Block block) {
        if (block == Blocks.web) {
            return 15.0F;
        } else {
            Material material = block.getMaterial();
            return material != Material.plants && material != Material.vine && material != Material.coral
                    && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
        }
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
        if (isBreakable) {
            itemStack.damageItem(1, attacker);  // Damage sword by 1 on each hit.
        }
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
        if (block.getBlockHardness(world, x, y, z) != 0.0D) {
            itemStack.damageItem(2, entity);  // Damage sword by 2 when a block is destroyed.
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.block;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }


    public boolean canItemHarvestBlock(Block block) {
        return block == Blocks.web;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repairItem) {
        return false;
    }

    @Override
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier("Weapon modifier", attackDamage, 0));
        return multimap;
    }
}