package apocalypse.fandomcraft.events;

import apocalypse.fandomcraft.items.FCSpawnEgg;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BehaviorSpawnEggDispense extends BehaviorDefaultDispenseItem
{
    @Override
    public ItemStack dispenseStack(IBlockSource source, ItemStack stack)
    {
        EnumFacing facing = BlockDispenser.func_149937_b(source.getBlockMetadata());

        double x = source.getX() + facing.getFrontOffsetX();
        double y = source.getYInt() + 0.2D;
        double z = source.getZ() + facing.getFrontOffsetZ();
        World world = source.getWorld();

        if (!world.isRemote)
        {
            FCSpawnEgg.spawnFromDispenser(stack, world, x, y, z);
        }

        stack.splitStack(1);
        return stack;
    }
}