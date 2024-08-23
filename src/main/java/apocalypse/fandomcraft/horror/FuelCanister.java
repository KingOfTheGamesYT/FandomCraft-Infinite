package apocalypse.fandomcraft.horror;

import net.minecraft.item.*;
import java.awt.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import apocalypse.fandomcraft.player.*;

public class FuelCanister extends Item
{
    public void addInformation(final ItemStack par1ItemStack, final List par2List) {
        par2List.add("Adds 15 seconds of fuel.");
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        if (!world.isRemote) {
            final ExtendedPlayer props = ExtendedPlayer.get(player);
            props.addCurrentFuel(15);
        }
        return stack;
    }
}
