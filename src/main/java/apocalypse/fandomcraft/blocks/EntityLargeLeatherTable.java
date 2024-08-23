package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.tileEntity.TileEntityLargeLeatherTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EntityLargeLeatherTable extends BlockContainer {
    public EntityLargeLeatherTable() {
        super(Material.rock);
        this.setHardness(10.0F);
        this.setResistance(10.0F);
        this.setBlockBounds(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F);
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

    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityLargeLeatherTable();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fandomcraft:" + this.getUnlocalizedName().substring(5));
    }
}
