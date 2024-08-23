package apocalypse.fandomcraft.horror;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;

public class TrashBin extends BlockContainer
{
    public TrashBin() {
        super(Material.iron);
        this.setHardness(4.0f);
        this.setResistance(10.0f);
        this.setStepSound(TrashBin.soundTypeMetal);
    }
    
    public int getRenderType() {
        return -1;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    protected boolean canSilkHarvest() {
        return true;
    }
    
    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return (TileEntity)new TileEntityTrashBin();
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fandomcraft:" + this.getUnlocalizedName().substring(5));
    }
    
    public boolean canPlaceBlockAt(final World worldIn, final int x, final int y, final int z) {
        return World.doesBlockHaveSolidTopSurface((IBlockAccess)worldIn, x, y - 1, z);
    }
}
