package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.main.Main;
import apocalypse.fandomcraft.tileEntity.TileEntityHeartPot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EntityHeartPot extends BlockContainer {
    public EntityHeartPot() {
        super(Material.glass);
        this.setStepSound(soundTypeGlass);
        this.setHardness(0.1F);
        this.setResistance(0.1F);
        this.setBlockBounds(0.17F, 0.0F, 0.17F, 0.8125F, 0.8125F, 0.8125F);
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Main.heart;
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
        return new TileEntityHeartPot();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fandomcraft:" + this.getUnlocalizedName().substring(5));
    }

    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
        return World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
    }
}
