package apocalypse.fandomcraft.player;

import apocalypse.fandomcraft.main.Tools;
import apocalypse.fandomcraft.network.APacketGui.GuiMessage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Backpack extends Item {
    public Backpack() {
        this.setMaxStackSize(1);
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote && !player.isSneaking()) {
            Tools.printcon("Sending packet to open backpack");
            new GuiMessage(player);
        }

        return stack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("fandomcraft:backpack");
    }
}
