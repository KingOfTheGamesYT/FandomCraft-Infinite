package apocalypse.fandomcraft.zelda;

import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.item.*;

public class LockedDoor extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon not;
    
    public LockedDoor() {
        super(Material.rock);
        this.setResistance(99999.0f);
        this.setBlockUnbreakable();
    }
    
    public boolean canPlaceBlockAt(final World world, final int x, final int y, final int z) {
        return y < 254;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.top = icon.registerIcon("fandomcraft:" + this.getTextureName() + "_upper");
        this.not = icon.registerIcon("fandomcraft:" + this.getTextureName() + "_lower");
    }
    
    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int side, final float subX, final float subY, final float subZ) {
        final int i1 = this.getFullMetadata((IBlockAccess)world, x, y, z);
        int j1 = i1 & 0x7;
        j1 ^= 0x4;
        if (player.inventory.getCurrentItem().getItem() == Main.smallKey) {
            if ((i1 & 0x8) == 0x0) {
                world.setBlockMetadataWithNotify(x, y, z, j1, 2);
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }
            else {
                world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
                world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
            }
            player.inventory.consumeInventoryItem(Main.smallKey);
        }
        else {
            player.playSound("fandomcraft:noAction", 1.0f, 1.0f);
            player.addChatMessage((IChatComponent)new ChatComponentText("You can't enter this dungeon without a " + EnumChatFormatting.GOLD + "Small Key" + EnumChatFormatting.WHITE + "."));
        }
        return true;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean isPassable(final IBlockAccess worldIn, final int x, final int y, final int z) {
        final int l = this.getFullMetadata(worldIn, x, y, z);
        return (l & 0x4) != 0x0;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return 7;
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(final World worldIn, final int x, final int y, final int z) {
        this.setBlockBoundsBasedOnState((IBlockAccess)worldIn, x, y, z);
        return super.getSelectedBoundingBoxFromPool(worldIn, x, y, z);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World worldIn, final int x, final int y, final int z) {
        this.setBlockBoundsBasedOnState((IBlockAccess)worldIn, x, y, z);
        return super.getCollisionBoundingBoxFromPool(worldIn, x, y, z);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.not;
    }
    
    public MovingObjectPosition collisionRayTrace(final World worldIn, final int x, final int y, final int z, final Vec3 startVec, final Vec3 endVec) {
        this.setBlockBoundsBasedOnState((IBlockAccess)worldIn, x, y, z);
        return super.collisionRayTrace(worldIn, x, y, z, startVec, endVec);
    }
    
    public int getMobilityFlag() {
        return 1;
    }
    
    public int getFullMetadata(final IBlockAccess p_150012_1_, final int p_150012_2_, final int p_150012_3_, final int p_150012_4_) {
        final int l = p_150012_1_.getBlockMetadata(p_150012_2_, p_150012_3_, p_150012_4_);
        final boolean flag = (l & 0x8) != 0x0;
        int i1;
        int j1;
        if (flag) {
            i1 = p_150012_1_.getBlockMetadata(p_150012_2_, p_150012_3_ - 1, p_150012_4_);
            j1 = l;
        }
        else {
            i1 = l;
            j1 = p_150012_1_.getBlockMetadata(p_150012_2_, p_150012_3_ + 1, p_150012_4_);
        }
        final boolean flag2 = (j1 & 0x1) != 0x0;
        return (i1 & 0x7) | (flag ? 8 : 0) | (flag2 ? 16 : 0);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final IBlockAccess worldIn, final int x, final int y, final int z, final int side) {
        if (side != 1 && side != 0) {
            final int i1 = this.getFullMetadata(worldIn, x, y, z);
            final int j1 = i1 & 0x3;
            final boolean flag = (i1 & 0x4) != 0x0;
            boolean flag2 = false;
            final boolean flag3 = (i1 & 0x8) != 0x0;
            if (flag) {
                if (j1 == 0 && side == 2) {
                    flag2 = !flag2;
                }
                else if (j1 == 1 && side == 5) {
                    flag2 = !flag2;
                }
                else if (j1 == 2 && side == 3) {
                    flag2 = !flag2;
                }
                else if (j1 == 3 && side == 4) {
                    flag2 = !flag2;
                }
            }
            else {
                if (j1 == 0 && side == 5) {
                    flag2 = !flag2;
                }
                else if (j1 == 1 && side == 3) {
                    flag2 = !flag2;
                }
                else if (j1 == 2 && side == 4) {
                    flag2 = !flag2;
                }
                else if (j1 == 3 && side == 2) {
                    flag2 = !flag2;
                }
                if ((i1 & 0x10) != 0x0) {
                    flag2 = !flag2;
                }
            }
            return flag3 ? this.top : this.not;
        }
        return this.not;
    }
    
    public Item getItemDropped(final int meta, final Random random, final int fortune) {
        return Main.itemLockedDoor;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(final World worldIn, final int x, final int y, final int z) {
        return Main.itemLockedDoor;
    }
}
