package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.main.Main;
import apocalypse.fandomcraft.tileEntity.TileEntityBoulder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Boulder extends BlockContainer {
    public Boulder() {
        super(Material.rock);
        this.setStepSound(soundTypeStone);
        this.setHardness(99999.0F);
        this.setResistance(5.0F);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.25F, 1.0F);
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        Random r = new Random();
        int i = r.nextInt(20);
        if (i < 5 && i > 1) {
            return Main.rupeeBlue;
        } else {
            return i != 0 && i != 1 ? Main.rupeeGreen : Main.rupeeYellow;
        }
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
        return new TileEntityBoulder();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fandomcraft:" + this.getUnlocalizedName().substring(5));
    }

    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
        return World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
    }
}
