package apocalypse.fandomcraft.world;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraftforge.common.util.*;
import net.minecraft.client.renderer.texture.*;

public class Hellfire extends BlockFire
{
    private int[] chanceToEncourageFire;
    private int[] abilityToCatchFire;
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArry;
    
    public Hellfire() {
        this.chanceToEncourageFire = new int[256];
        this.abilityToCatchFire = new int[256];
        this.setTickRandomly(true);
    }
    
    public IIcon getIcon() {
        return this.blockIcon;
    }
    
    public void onBlockAdded(final World w, final int x, final int y, final int z) {
        if (w.provider.dimensionId > 0 || !Blocks.portal.func_150000_e(w, x, y, z)) {
            if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)w, x, y - 1, z) && !this.canNeighborBurn(w, x, y, z)) {
                w.setBlockToAir(x, y, z);
            }
            else {
                w.scheduleBlockUpdate(x, y, z, (Block)this, this.tickRate(w) + w.rand.nextInt(10));
            }
        }
    }
    
    private boolean canNeighborBurn(final World w, final int x, final int y, final int z) {
        return this.canCatchFire((IBlockAccess)w, x + 1, y, z, ForgeDirection.WEST) || this.canCatchFire((IBlockAccess)w, x - 1, y, z, ForgeDirection.EAST) || this.canCatchFire((IBlockAccess)w, x, y - 1, z, ForgeDirection.UP) || this.canCatchFire((IBlockAccess)w, x, y + 1, z, ForgeDirection.DOWN) || this.canCatchFire((IBlockAccess)w, x, y, z - 1, ForgeDirection.SOUTH) || this.canCatchFire((IBlockAccess)w, x, y, z + 1, ForgeDirection.NORTH);
    }
    
    private int getChanceOfNeighborsEncouragingFire(final World w, final int x, final int y, final int z) {
        final byte b0 = 0;
        if (!w.isAirBlock(x, y, z)) {
            return 0;
        }
        int l = b0;
        l = this.getChanceToEncourageFire((IBlockAccess)w, x + 1, y, z, l, ForgeDirection.WEST);
        l = this.getChanceToEncourageFire((IBlockAccess)w, x - 1, y, z, l, ForgeDirection.EAST);
        l = this.getChanceToEncourageFire((IBlockAccess)w, x, y - 1, z, l, ForgeDirection.UP);
        l = this.getChanceToEncourageFire((IBlockAccess)w, x, y + 1, z, l, ForgeDirection.DOWN);
        l = this.getChanceToEncourageFire((IBlockAccess)w, x, y, z - 1, l, ForgeDirection.SOUTH);
        l = this.getChanceToEncourageFire((IBlockAccess)w, x, y, z + 1, l, ForgeDirection.NORTH);
        return l;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.iconArry = new IIcon[] { icon.registerIcon("fandomcraft:fire_layer_0"), icon.registerIcon("fandomcraft:fire_layer_1") };
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getBlockTextureFromSideAndMetadata(final int side, final int meta) {
        return this.iconArry[0];
    }
}
