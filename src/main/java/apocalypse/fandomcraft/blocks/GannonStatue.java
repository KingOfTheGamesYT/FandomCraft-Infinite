package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.tileEntity.TileEntityGannonStatue;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GannonStatue extends BlockContainer {
    public GannonStatue() {
        super(Material.rock);
        this.setStepSound(soundTypeStone);
        this.setHardness(10.0F);
        this.setResistance(99999.0F);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.8F, 2.0F, 1.0F);
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

    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityGannonStatue();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fandomcraft:" + this.getUnlocalizedName().substring(5));
    }

    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
        return World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
    }
}
