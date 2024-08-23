package apocalypse.fandomcraft.horror;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class HorrorPlant extends Block
{
    public HorrorPlant(final float f) {
        super(Material.plants);
        this.setHardness(0.1f);
        this.setResistance(0.1f);
        this.setStepSound(HorrorPlant.soundTypeGrass);
        this.setBlockBounds(f, 0.0f, f, 1.0f - f, 1.0f - f, 1.0f - f);
        this.setCreativeTab(Main.tabFandomCraftBuilding);
    }
    
    protected boolean canPlaceBlockOn(final Block block) {
        return block == HorrorReg.bloodGrass;
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
        return null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return 1;
    }
}
