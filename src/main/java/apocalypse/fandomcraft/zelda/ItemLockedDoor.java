package apocalypse.fandomcraft.zelda;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class ItemLockedDoor extends Item
{
    public ItemLockedDoor() {
        this.setMaxStackSize(1);
    }
    
    public boolean onItemUse(final ItemStack p_77648_1_, final EntityPlayer p_77648_2_, final World p_77648_3_, final int p_77648_4_, int p_77648_5_, final int p_77648_6_, final int p_77648_7_, final float p_77648_8_, final float p_77648_9_, final float p_77648_10_) {
        if (p_77648_7_ != 1) {
            return false;
        }
        ++p_77648_5_;
        final Block block = Main.lockedDoor;
        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) || !p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
        }
        if (!block.canPlaceBlockAt(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
            return false;
        }
        final int i1 = MathHelper.floor_double((p_77648_2_.rotationYaw + 180.0f) * 4.0f / 360.0f - 0.5) & 0x3;
        placeDoorBlock(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1, block);
        --p_77648_1_.stackSize;
        return true;
    }
    
    public static void placeDoorBlock(final World p_150924_0_, final int p_150924_1_, final int p_150924_2_, final int p_150924_3_, final int p_150924_4_, final Block p_150924_5_) {
        byte b0 = 0;
        byte b2 = 0;
        if (p_150924_4_ == 0) {
            b2 = 1;
        }
        if (p_150924_4_ == 1) {
            b0 = -1;
        }
        if (p_150924_4_ == 2) {
            b2 = -1;
        }
        if (p_150924_4_ == 3) {
            b0 = 1;
        }
        int i1 = (p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_, p_150924_3_ - b2).isNormalCube() ? 1 : 0) + (p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_ + 1, p_150924_3_ - b2).isNormalCube() ? 1 : 0);
        int j1 = (p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_, p_150924_3_ + b2).isNormalCube() ? 1 : 0) + (p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_ + 1, p_150924_3_ + b2).isNormalCube() ? 1 : 0);
        final boolean flag = p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_, p_150924_3_ - b2) == p_150924_5_ || p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_ + 1, p_150924_3_ - b2) == p_150924_5_;
        final boolean flag2 = p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_, p_150924_3_ + b2) == p_150924_5_ || p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_ + 1, p_150924_3_ + b2) == p_150924_5_;
        boolean flag3 = false;
        if (flag && !flag2) {
            flag3 = true;
        }
        else if (j1 > i1) {
            flag3 = true;
        }
        p_150924_0_.setBlock(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_, p_150924_4_, 2);
        p_150924_0_.setBlock(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_, 0x8 | (flag3 ? 1 : 0), 2);
        p_150924_0_.notifyBlocksOfNeighborChange(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_);
        p_150924_0_.notifyBlocksOfNeighborChange(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_);
    }
}
