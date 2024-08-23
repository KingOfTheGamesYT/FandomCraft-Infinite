package apocalypse.fandomcraft.horror;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ThrowingKnife extends Item {
    public ThrowingKnife() {
        this.setMaxStackSize(16);
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }

        if (!world.isRemote) {
            player.swingItem();
        }

        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        world.spawnEntityInWorld(new EntityThrowingKnife(world, player, 5.0F));
        return stack;
    }
}
