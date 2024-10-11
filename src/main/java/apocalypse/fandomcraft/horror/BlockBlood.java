package apocalypse.fandomcraft.horror;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public class BlockBlood extends Block
{
    public BlockBlood() {
        super(Material.water);
        this.setHardness(0.1f);
        this.setResistance(0.1f);
        this.setStepSound(BlockBlood.soundTypeSnow);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
        this.setCreativeTab(Main.tabFandomCraftBlocks);
        this.setBlockBoundsFromMeta(0);
    }
    
    public boolean canPlaceBlockAt(final World worldIn, final int x, final int y, final int z) {
        return World.doesBlockHaveSolidTopSurface((IBlockAccess)worldIn, x, y - 1, z);
    }
    
    public void onNeighborBlockChange(final World worldIn, final int x, final int y, final int z, final Block neighbor) {
        super.onNeighborBlockChange(worldIn, x, y, z, neighbor);
        this.checkAndDropBlock(worldIn, x, y, z);
    }
    
    public void updateTick(final World worldIn, final int x, final int y, final int z, final Random random) {
        this.checkAndDropBlock(worldIn, x, y, z);
    }
    
    protected void checkAndDropBlock(final World worldIn, final int x, final int y, final int z) {
        if (!this.canBlockStay(worldIn, x, y, z)) {
            this.dropBlockAsItem(worldIn, x, y, z, worldIn.getBlockMetadata(x, y, z), 0);
            worldIn.setBlock(x, y, z, getBlockById(0), 0, 2);
        }
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World worldIn, final int x, final int y, final int z) {
        final byte b0 = 0;
        final float f = 0.0625f;
        return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, (double)(y + b0 * f), z + this.maxZ);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public void setBlockBoundsForItemRender() {
        this.setBlockBoundsFromMeta(0);
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess worldIn, final int x, final int y, final int z) {
        this.setBlockBoundsFromMeta(worldIn.getBlockMetadata(x, y, z));
    }
    
    protected void setBlockBoundsFromMeta(final int meta) {
        final byte b0 = 0;
        final float f = 1 * (1 + b0) / 16.0f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess worldIn, final int x, final int y, final int z, final int side) {
        return side == 1 || super.shouldSideBeRendered(worldIn, x, y, z, side);
    }
}
