package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.main.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.*;

import java.util.*;

public class AppraisingOre extends Item
{
    public AppraisingOre() {
        super(new Item.Properties().group(FandomCraft.tabFandomCraftBlocks));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World par2World, PlayerEntity par3EntityPlayer, Hand hand) {
        ItemStack par1ItemStack = par3EntityPlayer.getHeldItem(hand);

        if(!par3EntityPlayer.abilities.isCreativeMode) {
            par1ItemStack.shrink(1);
        }
        if (!par2World.isRemote) {
            final Random rand = new Random();
            final int i = rand.nextInt(74) + 1;
            final Random r2 = new Random();
            final int i2 = r2.nextInt(2);
            final Random r3 = new Random();
            final int i3 = r3.nextInt(3);
            final Random r4 = new Random();
            final int i4 = 1 + r4.nextInt(4);
            ResourceLocation dyeTagId = new ResourceLocation("forge", "dyes");
            ITag<Item> dyeTag = ItemTags.getCollection().get(dyeTagId);
            List<Item> dyes = dyeTag.getAllElements();
            Item randomDye = dyes.get(par3EntityPlayer.world.rand.nextInt(dyes.size()));
            ItemStack dyeStack = new ItemStack(randomDye, 4);

            if (par3EntityPlayer.inventory.hasItemStack(new ItemStack(RegistryHandler.APPRAISAL_KIT_BASIC.get()))) {
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 52 || i == 53) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.COAL, i2));
                }
                if (i == 15 || i == 12 || i == 16 || i == 17 || i == 18 || i == 54 || i == 55) {
                    par3EntityPlayer.inventory.addItemStackToInventory(dyeStack);
                }
                if (i == 19 || i == 20 || i == 21 || i == 22) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.IRON_INGOT, i2));
                }
             /*   if (i == 23 || i == 24 || i == 25 || i == 26) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rockSalt, i2));
                } */
                if (i == 27 || i == 28 || i == 29) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.EMERALD, i2));
                }
                if (i == 30 || i == 31 || i == 32) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_NUGGET, i2));
                }
                if (i == 33 || i == 34 || i == 35) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.QUARTZ, i2));
                }
                if (i == 36 || i == 37 || i == 38) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GLOWSTONE_DUST, i2));
                }
                if (i == 39 || i == 40 || i == 41) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.CLAY_BALL, i2));
                }
                if (i == 42 || i == 43 || i == 56) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_INGOT, i2));
                }
                if (i == 44 || i == 45) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.FLINT, i2));
                }
                if (i == 46 || i == 47) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GUNPOWDER, i2));
                }
                if (i == 48 || i == 49) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, i2));
                }
                if (i == 50 || i == 51) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Blocks.SAND, i2));
                }
              /*  if (i == 57 || i == 58) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.orichulumIngot, i2));
                }
                if (i == 59 || i == 60) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.mythrilIngot, i2));
                }
                if (i == 61 || i == 62) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.eridiumIngot, i2));
                }
                if (i == 63) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.adamantiumIngot, i2));
                }*/
                if (i == 64 || i == 65) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.RUPEE_RED.get(), i2));
                }
                if (i == 66 || i == 67) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 68) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 69) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 70) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.ELVEN_STEEL_INGOT.get(), i2));
                }
                  if (i == 71) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.DWARVEN_STEEL_INGOT.get(), i2));
                }
                if (i == 72) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 73) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.HELLSTONE_INGOT.get(), i2));
                }
               /* if (i == 74) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.darkSteelIngot, i2));
                } */
                else {
                    System.out.println("Couldn't appraise the mineral...");
                }
            }
            else if (par3EntityPlayer.inventory.hasItemStack(new ItemStack(RegistryHandler.APPRAISAL_KIT_ADVANCED.get()))) {
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 52 || i == 53) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.COAL, i3));
                }
                if (i == 15 || i == 12 || i == 16 || i == 17 || i == 18 || i == 54 || i == 55) {
                    par3EntityPlayer.inventory.addItemStackToInventory(dyeStack);
                }
                if (i == 19 || i == 20 || i == 21 || i == 22) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.IRON_INGOT, i3));
                }
              /*  if (i == 23 || i == 24 || i == 25 || i == 26) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rockSalt, i3));
                } */
                if (i == 27 || i == 28 || i == 29) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.EMERALD, i3));
                }
                if (i == 30 || i == 31 || i == 32) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_NUGGET, i3));
                }
                if (i == 33 || i == 34 || i == 35) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.QUARTZ, i3));
                }
                if (i == 36 || i == 37 || i == 38) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GLOWSTONE_DUST, i3));
                }
                if (i == 39 || i == 40 || i == 41) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.CLAY_BALL, i3));
                }
                if (i == 42 || i == 43 || i == 56) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_INGOT, i3));
                }
                if (i == 44 || i == 45) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.FLINT, i3));
                }
                if (i == 46 || i == 47) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GUNPOWDER, i3));
                }
                if (i == 48 || i == 49) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, i3));
                }
                if (i == 50 || i == 51) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Blocks.STONE, i3));
                }
               /* if (i == 57 || i == 58) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.orichulumIngot, i3));
                }
                if (i == 59 || i == 60) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.mythrilIngot, i3));
                }
                if (i == 61 || i == 62) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.eridiumIngot, i3));
                }
                if (i == 63) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.adamantiumIngot, i3));
                } */
                if (i == 64 || i == 65) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.RUPEE_RED.get(), i3));
                }
                if (i == 66 || i == 67) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 68) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 69) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 70) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.ELVEN_STEEL_INGOT.get(), i3));
                }
                if (i == 71) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.DWARVEN_STEEL_INGOT.get(), i3));
                }
                if (i == 72) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 73) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.HELLSTONE_INGOT.get(), i3));
                }
              /*  if (i == 74) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.darkSteelIngot, i3));
                }
                if (i <= 3) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.energyCrystal, i4));
                } */
                else {
                    System.out.println("Couldn't appraise the mineral...");
                }
            }
            else if (par3EntityPlayer.inventory.hasItemStack(new ItemStack(RegistryHandler.APPRAISAL_KIT_MASTER.get()))) {
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 52 || i == 53) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.COAL, i4));
                }
                if (i == 15 || i == 12 || i == 16 || i == 17 || i == 18 || i == 54 || i == 55) {
                    par3EntityPlayer.inventory.addItemStackToInventory(dyeStack);
                }
                if (i == 19 || i == 20 || i == 21 || i == 22) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.IRON_INGOT, i4));
                }
              /*  if (i == 23 || i == 24 || i == 25 || i == 26) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rockSalt, i4));
                }*/
                if (i == 27 || i == 28 || i == 29) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.EMERALD, i4));
                }
                if (i == 30 || i == 31 || i == 32) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_NUGGET, i4));
                }
                if (i == 33 || i == 34 || i == 35) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.QUARTZ, i4));
                }
                if (i == 36 || i == 37 || i == 38) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GLOWSTONE_DUST, i4));
                }
                if (i == 39 || i == 40 || i == 41) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.CLAY_BALL, i4));
                }
                if (i == 42 || i == 43 || i == 56) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_INGOT, i4));
                }
                if (i == 44 || i == 45) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.FLINT, i4));
                }
                if (i == 46 || i == 47) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.GUNPOWDER, i4));
                }
                if (i == 48 || i == 49) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, i4));
                }
                if (i == 50 || i == 51) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Blocks.STONE, i4));
                }
              /*  if (i == 57 || i == 58) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.orichulumIngot, i4));
                }
                if (i == 59 || i == 60) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.mythrilIngot, i4));
                }
                if (i == 61 || i == 62) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.eridiumIngot, i4));
                }
                if (i == 63) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.adamantiumIngot, i4));
                }*/
                if (i == 64 || i == 65) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.RUPEE_RED.get(), i4));
                }
                if (i == 66 || i == 67) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 68) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 69) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 70) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.ELVEN_STEEL_INGOT.get(), i4));
                }
                if (i == 71) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.DWARVEN_STEEL_INGOT.get(), i4));
                }
                if (i == 72) {
                    System.out.println("Couldn't appraise the mineral...");
                }
               if (i == 73) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(RegistryHandler.HELLSTONE_INGOT.get(), i4));
                }
              /*  if (i == 74) {
                   par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.darkSteelIngot, i4));
                }
                else {
                   par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.energyCrystal, i4));
                }*/
            }
        }
        return new ActionResult<>(ActionResultType.SUCCESS, par1ItemStack);
    }
}
