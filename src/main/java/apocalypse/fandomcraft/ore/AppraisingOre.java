package apocalypse.fandomcraft.ore;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;

import apocalypse.fandomcraft.main.*;

import java.util.*;

public class AppraisingOre extends Item
{
    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if ((par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.consumeInventoryItem(Main.AppraisingOre)) && !par2World.isRemote) {
            final Random rand = new Random();
            final int i = rand.nextInt(74) + 1;
            final Random r2 = new Random();
            final int i2 = r2.nextInt(2);
            final Random r3 = new Random();
            final int i3 = r3.nextInt(3);
            final Random r4 = new Random();
            final int i4 = 1 + r4.nextInt(4);
            if (par3EntityPlayer.inventory.hasItem(Main.appraisalKit)) {
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 52 || i == 53) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.coal, i2));
                }
                if (i == 15 || i == 12 || i == 16 || i == 17 || i == 18 || i == 54 || i == 55) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.dye, 4, i2));
                }
                if (i == 19 || i == 20 || i == 21 || i == 22) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.iron_ingot, i2));
                }
                if (i == 23 || i == 24 || i == 25 || i == 26) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rockSalt, i2));
                }
                if (i == 27 || i == 28 || i == 29) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.emerald, i2));
                }
                if (i == 30 || i == 31 || i == 32) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gold_nugget, i2));
                }
                if (i == 33 || i == 34 || i == 35) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.quartz, i2));
                }
                if (i == 36 || i == 37 || i == 38) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glowstone_dust, i2));
                }
                if (i == 39 || i == 40 || i == 41) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.clay_ball, i2));
                }
                if (i == 42 || i == 43 || i == 56) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gold_ingot, i2));
                }
                if (i == 44 || i == 45) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.flint, i2));
                }
                if (i == 46 || i == 47) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gunpowder, i2));
                }
                if (i == 48 || i == 49) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.diamond, i2));
                }
                if (i == 50 || i == 51) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Blocks.stone, i2));
                }
                if (i == 57 || i == 58) {
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
                }
                if (i == 64 || i == 65) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rupeeRed, i2));
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
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.elvenSteelIngot, i2));
                }
                if (i == 71) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.dwarvenSteelIngot, i2));
                }
                if (i == 72) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 73) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.hellstoneIngot, i2));
                }
                if (i == 74) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.darkSteelIngot, i2));
                }
                else {
                    System.out.println("Couldn't appraise the mineral...");
                }
            }
            else if (par3EntityPlayer.inventory.hasItem(Main.appraisalKit1)) {
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 52 || i == 53) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.coal, i3));
                }
                if (i == 15 || i == 12 || i == 16 || i == 17 || i == 18 || i == 54 || i == 55) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.dye, 4, i3));
                }
                if (i == 19 || i == 20 || i == 21 || i == 22) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.iron_ingot, i3));
                }
                if (i == 23 || i == 24 || i == 25 || i == 26) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rockSalt, i3));
                }
                if (i == 27 || i == 28 || i == 29) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.emerald, i3));
                }
                if (i == 30 || i == 31 || i == 32) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gold_nugget, i3));
                }
                if (i == 33 || i == 34 || i == 35) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.quartz, i3));
                }
                if (i == 36 || i == 37 || i == 38) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glowstone_dust, i3));
                }
                if (i == 39 || i == 40 || i == 41) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.clay_ball, i3));
                }
                if (i == 42 || i == 43 || i == 56) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gold_ingot, i3));
                }
                if (i == 44 || i == 45) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.flint, i3));
                }
                if (i == 46 || i == 47) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gunpowder, i3));
                }
                if (i == 48 || i == 49) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.diamond, i3));
                }
                if (i == 50 || i == 51) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Blocks.stone, i3));
                }
                if (i == 57 || i == 58) {
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
                }
                if (i == 64 || i == 65) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rupeeRed, i3));
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
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.elvenSteelIngot, i3));
                }
                if (i == 71) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.dwarvenSteelIngot, i3));
                }
                if (i == 72) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 73) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.hellstoneIngot, i3));
                }
                if (i == 74) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.darkSteelIngot, i3));
                }
                if (i <= 3) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.energyCrystal, i4));
                }
                else {
                    System.out.println("Couldn't appraise the mineral...");
                }
            }
            else if (par3EntityPlayer.inventory.hasItem(Main.appraisalKit2)) {
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 52 || i == 53) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.coal, i4));
                }
                if (i == 15 || i == 12 || i == 16 || i == 17 || i == 18 || i == 54 || i == 55) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.dye, 4, i4));
                }
                if (i == 19 || i == 20 || i == 21 || i == 22) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.iron_ingot, i4));
                }
                if (i == 23 || i == 24 || i == 25 || i == 26) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rockSalt, i4));
                }
                if (i == 27 || i == 28 || i == 29) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.emerald, i4));
                }
                if (i == 30 || i == 31 || i == 32) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gold_nugget, i4));
                }
                if (i == 33 || i == 34 || i == 35) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.quartz, i4));
                }
                if (i == 36 || i == 37 || i == 38) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glowstone_dust, i4));
                }
                if (i == 39 || i == 40 || i == 41) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.clay_ball, i4));
                }
                if (i == 42 || i == 43 || i == 56) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gold_ingot, i4));
                }
                if (i == 44 || i == 45) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.flint, i4));
                }
                if (i == 46 || i == 47) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.gunpowder, i4));
                }
                if (i == 48 || i == 49) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.diamond, i4));
                }
                if (i == 50 || i == 51) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Blocks.stone, i4));
                }
                if (i == 57 || i == 58) {
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
                }
                if (i == 64 || i == 65) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.rupeeRed, i4));
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
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.elvenSteelIngot, i4));
                }
                if (i == 71) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.dwarvenSteelIngot, i4));
                }
                if (i == 72) {
                    System.out.println("Couldn't appraise the mineral...");
                }
                if (i == 73) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.hellstoneIngot, i4));
                }
                if (i == 74) {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.darkSteelIngot, i4));
                }
                else {
                    par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Main.energyCrystal, i4));
                }
            }
        }
        return par1ItemStack;
    }
}
