package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.tileEntity.TileEntityFloorSpikes;
import apocalypse.fandomcraft.tileEntity.TileEntityLargeBloodstoneTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class FloorSpikes extends BlockContainer {
    public FloorSpikes() {
        super(Material.iron);
        this.setStepSound(soundTypeMetal);
        this.setHardness(9.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
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
        return new TileEntityFloorSpikes();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fandomcraft:" + "floor_spikes");
    }

    // Damage entities that step on the block
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntityLiving) {
            entity.attackEntityFrom(DamageSource.generic, 4.0F); // Deal 4 damage to players
        }
    }
}