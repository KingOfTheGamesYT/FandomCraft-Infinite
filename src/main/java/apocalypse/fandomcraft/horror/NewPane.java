package apocalypse.fandomcraft.horror;

import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraftforge.common.util.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;

public class NewPane extends BlockPane
{
    private final String field_150100_a;
    private final boolean field_150099_b;
    private final String field_150101_M;
    @SideOnly(Side.CLIENT)
    private IIcon field_150102_N;
    private static final String __OBFID = "CL_00000322";
    
    protected NewPane(final String p_i45432_1_, final String p_i45432_2_, final Material p_i45432_3_, final boolean p_i45432_4_) {
        super(p_i45432_1_, p_i45432_2_, p_i45432_3_, p_i45432_4_);
        this.field_150100_a = p_i45432_2_;
        this.field_150099_b = p_i45432_4_;
        this.field_150101_M = p_i45432_1_;
        this.setStepSound(NewPane.soundTypeMetal);
    }
    
    public Item getItemDropped(final int meta, final Random random, final int fortune) {
        return this.field_150099_b ? super.getItemDropped(meta, random, fortune) : null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return (this.blockMaterial == Material.glass) ? 41 : 18;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess worldIn, final int x, final int y, final int z, final int side) {
        return worldIn.getBlock(x, y, z) != this && super.shouldSideBeRendered(worldIn, x, y, z, side);
    }
    
    public void addCollisionBoxesToList(final World worldIn, final int x, final int y, final int z, final AxisAlignedBB mask, final List list, final Entity collider) {
        final boolean flag = this.canPaneConnectTo((IBlockAccess)worldIn, x, y, z - 1, ForgeDirection.NORTH);
        final boolean flag2 = this.canPaneConnectTo((IBlockAccess)worldIn, x, y, z + 1, ForgeDirection.SOUTH);
        final boolean flag3 = this.canPaneConnectTo((IBlockAccess)worldIn, x - 1, y, z, ForgeDirection.WEST);
        final boolean flag4 = this.canPaneConnectTo((IBlockAccess)worldIn, x + 1, y, z, ForgeDirection.EAST);
        if ((!flag3 || !flag4) && (flag3 || flag4 || flag || flag2)) {
            if (flag3 && !flag4) {
                this.setBlockBounds(0.0f, 0.0f, 0.4375f, 0.5f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(worldIn, x, y, z, mask, list, collider);
            }
            else if (!flag3 && flag4) {
                this.setBlockBounds(0.5f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(worldIn, x, y, z, mask, list, collider);
            }
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.addCollisionBoxesToList(worldIn, x, y, z, mask, list, collider);
        }
        if ((!flag || !flag2) && (flag3 || flag4 || flag || flag2)) {
            if (flag && !flag2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.5f);
                super.addCollisionBoxesToList(worldIn, x, y, z, mask, list, collider);
            }
            else if (!flag && flag2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.5f, 0.5625f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(worldIn, x, y, z, mask, list, collider);
            }
        }
        else {
            this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            super.addCollisionBoxesToList(worldIn, x, y, z, mask, list, collider);
        }
    }
    
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess worldIn, final int x, final int y, final int z) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        final boolean flag = this.canPaneConnectTo(worldIn, x, y, z - 1, ForgeDirection.NORTH);
        final boolean flag2 = this.canPaneConnectTo(worldIn, x, y, z + 1, ForgeDirection.SOUTH);
        final boolean flag3 = this.canPaneConnectTo(worldIn, x - 1, y, z, ForgeDirection.WEST);
        final boolean flag4 = this.canPaneConnectTo(worldIn, x + 1, y, z, ForgeDirection.EAST);
        if ((!flag3 || !flag4) && (flag3 || flag4 || flag || flag2)) {
            if (flag3 && !flag4) {
                f = 0.0f;
            }
            else if (!flag3 && flag4) {
                f2 = 1.0f;
            }
        }
        else {
            f = 0.0f;
            f2 = 1.0f;
        }
        if ((!flag || !flag2) && (flag3 || flag4 || flag || flag2)) {
            if (flag && !flag2) {
                f3 = 0.0f;
            }
            else if (!flag && flag2) {
                f4 = 1.0f;
            }
        }
        else {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e() {
        return this.field_150102_N;
    }
    
    protected boolean canSilkHarvest() {
        return true;
    }
    
    protected ItemStack createStackedBlock(final int meta) {
        return new ItemStack(Item.getItemFromBlock((Block)this), 1, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister reg) {
        this.blockIcon = reg.registerIcon(this.field_150101_M);
        this.field_150102_N = reg.registerIcon(this.field_150100_a);
    }
    
    public boolean canPaneConnectTo(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection dir) {
        return this.canPaneConnectToBlock(world.getBlock(x, y, z)) || world.isSideSolid(x, y, z, dir.getOpposite(), false);
    }
}
