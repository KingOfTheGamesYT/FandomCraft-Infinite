package apocalypse.fandomcraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class UnbreakableGlass extends UnbreakableBlock {
    public UnbreakableGlass(Material m) {
        super(m);
        this.setLightOpacity(1);
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess access, int x, int y, int z, int side) {
        Block block = access.getBlock(x, y, z);
        return !this.isOpaqueCube() && block == this ? false : super.shouldSideBeRendered(access, x, y, z, side);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
}
