package apocalypse.fandomcraft.horror;

import apocalypse.fandomcraft.player.ExtendedPlayer;
import java.awt.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HolyWater extends Item {
    public HolyWater() {
    }

    public void addInformation(ItemStack par1ItemStack, List par2List) {
        par2List.add("Restores some Sanity");
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }

        if (!world.isRemote) {
            ExtendedPlayer props = ExtendedPlayer.get(player);
            props.addCurrentSanity(15);
        }

        return stack;
    }
}
