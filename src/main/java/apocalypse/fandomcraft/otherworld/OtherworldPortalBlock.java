package apocalypse.fandomcraft.otherworld;

import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.entity.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.init.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class OtherworldPortalBlock extends BlockBreakable
{
    public static final int[][] field_150001_a;
    
    public OtherworldPortalBlock() {
        super("fandomcraft:otherworldPortal", Material.portal, false);
        this.setTickRandomly(true);
        this.setLightLevel(1.0f);
    }
    
    public void updateTick(final World world, final int x, final int y, final int z, final Random random) {
        super.updateTick(world, x, y, z, random);
        if (world.provider.isSurfaceWorld() && world.getGameRules().getGameRuleBooleanValue("doMobSpawning") && random.nextInt(2000) < world.difficultySetting.getDifficultyId()) {
            int l;
            for (l = y; !World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, l, z) && l > 0; --l) {}
            if (l > 0 && !world.getBlock(x, l + 1, z).isNormalCube()) {
                final Entity entity = ItemMonsterPlacer.spawnCreature(world, 57, x + 0.5, l + 1.1, z + 0.5);
                if (entity != null) {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world, final int x, final int y, final int z) {
        return null;
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess blockaccess, final int x, final int y, final int z) {
        int l = func_149999_b(blockaccess.getBlockMetadata(x, y, z));
        if (l == 0) {
            if (blockaccess.getBlock(x - 1, y, z) != this && blockaccess.getBlock(x + 1, y, z) != this) {
                l = 2;
            }
            else {
                l = 1;
            }
            if (blockaccess instanceof World && !((World)blockaccess).isRemote) {
                ((World)blockaccess).setBlockMetadataWithNotify(x, y, z, l, 2);
            }
        }
        float f = 0.125f;
        float f2 = 0.125f;
        if (l == 1) {
            f = 0.5f;
        }
        if (l == 2) {
            f2 = 0.5f;
        }
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f2, 0.5f + f, 1.0f, 0.5f + f2);
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean getPortalSize(final World world, final int x, final int y, final int z) {
        final Size size = new Size(world, x, y, z, 1);
        final Size size2 = new Size(world, x, y, z, 2);
        if (size.func_150860_b() && size.field_150864_e == 0) {
            size.func_150859_c();
            return true;
        }
        if (size2.func_150860_b() && size2.field_150864_e == 0) {
            size2.func_150859_c();
            return true;
        }
        return false;
    }
    
    public boolean tryToCreatePortal(final World par1World, int par2, final int par3, int par4) {
        byte b0 = 0;
        byte b2 = 0;
        if (par1World.getBlock(par2 - 1, par3, par4) == Main.bloodstone || par1World.getBlock(par2 + 1, par3, par4) == Main.bloodstone) {
            b0 = 1;
        }
        if (par1World.getBlock(par2, par3, par4 - 1) == Main.bloodstone || par1World.getBlock(par2, par3, par4 + 1) == Main.bloodstone) {
            b2 = 1;
        }
        if (b0 == b2) {
            return false;
        }
        if (par1World.getBlock(par2 - b0, par3, par4 - b2) == Blocks.air) {
            par2 -= b0;
            par4 -= b2;
        }
        for (int l = -1; l <= 2; ++l) {
            for (int i1 = -1; i1 <= 3; ++i1) {
                final boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
                if ((l != -1 && l != 2) || (i1 != -1 && i1 != 3)) {
                    final Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1, par4 + b2 * l);
                    if (flag && j1 != Main.bloodstone) {
                        return false;
                    }
                }
            }
        }
        for (int l = 0; l < 2; ++l) {
            for (int i1 = 0; i1 < 3; ++i1) {
                par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b2 * l, HorrorReg.otherworldPortal, 0, 2);
            }
        }
        return true;
    }
    
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        final int l = func_149999_b(world.getBlockMetadata(x, y, z));
        final Size size = new Size(world, x, y, z, 1);
        final Size size2 = new Size(world, x, y, z, 2);
        if (l == 1 && (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g)) {
            world.setBlock(x, y, z, Blocks.air);
        }
        else if (l == 2 && (!size2.func_150860_b() || size2.field_150864_e < size2.field_150868_h * size2.field_150862_g)) {
            world.setBlock(x, y, z, Blocks.air);
        }
        else if (l == 0 && !size.func_150860_b() && !size2.func_150860_b()) {
            world.setBlock(x, y, z, Blocks.air);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess worldIn, final int x, final int y, final int z, final int side) {
        int i1 = 0;
        if (worldIn.getBlock(x, y, z) == this) {
            i1 = func_149999_b(worldIn.getBlockMetadata(x, y, z));
            if (i1 == 0) {
                return false;
            }
            if (i1 == 2 && side != 5 && side != 4) {
                return false;
            }
            if (i1 == 1 && side != 3 && side != 2) {
                return false;
            }
        }
        final boolean flag = worldIn.getBlock(x - 1, y, z) == this && worldIn.getBlock(x - 2, y, z) != this;
        final boolean flag2 = worldIn.getBlock(x + 1, y, z) == this && worldIn.getBlock(x + 2, y, z) != this;
        final boolean flag3 = worldIn.getBlock(x, y, z - 1) == this && worldIn.getBlock(x, y, z - 2) != this;
        final boolean flag4 = worldIn.getBlock(x, y, z + 1) == this && worldIn.getBlock(x, y, z + 2) != this;
        final boolean flag5 = flag || flag2 || i1 == 1;
        final boolean flag6 = flag3 || flag4 || i1 == 2;
        return (flag5 && side == 4) || (flag5 && side == 5) || (flag6 && side == 2) || (flag6 && side == 3);
    }
    
    public int quantityDropped(final Random random) {
        return 0;
    }
    
    public void onEntityCollidedWithBlock(final World world, final int x, final int y, final int z, final Entity entity) {
        if (entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP) {
            final EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 10;
            }
            else if (thePlayer.dimension != DimensionIDs.OTHERWORLDDIMENSION) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, DimensionIDs.OTHERWORLDDIMENSION, (Teleporter)new OtherworldTeleporter(thePlayer.mcServer.worldServerForDimension(DimensionIDs.OTHERWORLDDIMENSION)));
            }
            else {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, (Teleporter)new OtherworldTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int x, final int y, final int z, final Random random) {
        if (random.nextInt(100) == 0) {
            world.playSound(x + 0.5, y + 0.5, z + 0.5, "portal.portal", 0.5f, random.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int l = 0; l < 4; ++l) {
            double d0 = x + random.nextFloat();
            final double d2 = y + random.nextFloat();
            double d3 = z + random.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            final int i1 = random.nextInt(2) * 2 - 1;
            d4 = (random.nextFloat() - 0.5) * 0.5;
            d5 = (random.nextFloat() - 0.5) * 0.5;
            d6 = (random.nextFloat() - 0.5) * 0.5;
            if (world.getBlock(x - 1, y, z) != this && world.getBlock(x + 1, y, z) != this) {
                d0 = x + 0.5 + 0.25 * i1;
                d4 = random.nextFloat() * 2.0f * i1;
            }
            else {
                d3 = z + 0.5 + 0.25 * i1;
                d6 = random.nextFloat() * 2.0f * i1;
            }
            world.spawnParticle("portal", d0, d2, d3, d4, d5, d6);
        }
    }
    
    public static int func_149999_b(final int p_149999_0_) {
        return p_149999_0_ & 0x3;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(final World worldIn, final int x, final int y, final int z) {
        return Item.getItemById(0);
    }
    
    static {
        field_150001_a = new int[][] { new int[0], { 3, 1 }, { 2, 0 } };
    }
    
    public static class Size
    {
        private final World worldObj;
        private final int field_150865_b;
        private final int field_150866_c;
        private final int field_150863_d;
        private int field_150864_e;
        private ChunkCoordinates field_150861_f;
        private int field_150862_g;
        private int field_150868_h;
        
        public Size(final World p_i45415_1_, final int p_i45415_2_, int p_i45415_3_, final int p_i45415_4_, final int p_i45415_5_) {
            this.field_150864_e = 0;
            this.worldObj = p_i45415_1_;
            this.field_150865_b = p_i45415_5_;
            this.field_150863_d = OtherworldPortalBlock.field_150001_a[p_i45415_5_][0];
            this.field_150866_c = OtherworldPortalBlock.field_150001_a[p_i45415_5_][1];
            for (int i1 = p_i45415_3_; p_i45415_3_ > i1 - 21 && p_i45415_3_ > 0 && this.getBlockMaterial(p_i45415_1_.getBlock(p_i45415_2_, p_i45415_3_ - 1, p_i45415_4_)); --p_i45415_3_) {}
            final int j1 = this.func_150853_a(p_i45415_2_, p_i45415_3_, p_i45415_4_, this.field_150863_d) - 1;
            if (j1 >= 0) {
                this.field_150861_f = new ChunkCoordinates(p_i45415_2_ + j1 * Direction.offsetX[this.field_150863_d], p_i45415_3_, p_i45415_4_ + j1 * Direction.offsetZ[this.field_150863_d]);
                this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY, this.field_150861_f.posZ, this.field_150866_c);
                if (this.field_150868_h < 2 || this.field_150868_h > 21) {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                }
            }
            if (this.field_150861_f != null) {
                this.field_150862_g = this.func_150858_a();
            }
        }
        
        protected int func_150853_a(final int x, final int y, final int z, final int p_150853_4_) {
            final int j1 = Direction.offsetX[p_150853_4_];
            final int k1 = Direction.offsetZ[p_150853_4_];
            int i1;
            for (i1 = 0; i1 < 22; ++i1) {
                final Block block = this.worldObj.getBlock(x + j1 * i1, y, z + k1 * i1);
                if (!this.getBlockMaterial(block)) {
                    break;
                }
                final Block block2 = this.worldObj.getBlock(x + j1 * i1, y - 1, z + k1 * i1);
                if (block2 != Blocks.stone) {
                    break;
                }
            }
            final Block block = this.worldObj.getBlock(x + j1 * i1, y, z + k1 * i1);
            return (block == Blocks.stone) ? i1 : 0;
        }
        
        protected int func_150858_a() {
            this.field_150862_g = 0;
        Label_0272:
            while (this.field_150862_g < 21) {
                final int i = this.field_150861_f.posY + this.field_150862_g;
                for (int j = 0; j < this.field_150868_h; ++j) {
                    final int k = this.field_150861_f.posX + j * Direction.offsetX[OtherworldPortalBlock.field_150001_a[this.field_150865_b][1]];
                    final int l = this.field_150861_f.posZ + j * Direction.offsetZ[OtherworldPortalBlock.field_150001_a[this.field_150865_b][1]];
                    Block block = this.worldObj.getBlock(k, i, l);
                    if (!this.getBlockMaterial(block)) {
                        break Label_0272;
                    }
                    if (block == HorrorReg.otherworldPortal) {
                        ++this.field_150864_e;
                    }
                    if (j == 0) {
                        block = this.worldObj.getBlock(k + Direction.offsetX[OtherworldPortalBlock.field_150001_a[this.field_150865_b][0]], i, l + Direction.offsetZ[OtherworldPortalBlock.field_150001_a[this.field_150865_b][0]]);
                        if (block != Blocks.stone) {
                            break Label_0272;
                        }
                    }
                    else if (j == this.field_150868_h - 1) {
                        block = this.worldObj.getBlock(k + Direction.offsetX[OtherworldPortalBlock.field_150001_a[this.field_150865_b][1]], i, l + Direction.offsetZ[OtherworldPortalBlock.field_150001_a[this.field_150865_b][1]]);
                        if (block != Blocks.stone) {
                            break Label_0272;
                        }
                    }
                }
                ++this.field_150862_g;
            }
            for (int i = 0; i < this.field_150868_h; ++i) {
                final int j = this.field_150861_f.posX + i * Direction.offsetX[OtherworldPortalBlock.field_150001_a[this.field_150865_b][1]];
                final int k = this.field_150861_f.posY + this.field_150862_g;
                final int l = this.field_150861_f.posZ + i * Direction.offsetZ[OtherworldPortalBlock.field_150001_a[this.field_150865_b][1]];
                if (this.worldObj.getBlock(j, k, l) != Blocks.stone) {
                    this.field_150862_g = 0;
                    break;
                }
            }
            if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
                return this.field_150862_g;
            }
            this.field_150861_f = null;
            this.field_150868_h = 0;
            return this.field_150862_g = 0;
        }
        
        protected boolean getBlockMaterial(final Block block) {
            return block.getMaterial() == Material.air || block == HorrorReg.otherworldPortal;
        }
        
        public boolean func_150860_b() {
            return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }
        
        public void func_150859_c() {
            for (int i = 0; i < this.field_150868_h; ++i) {
                final int j = this.field_150861_f.posX + Direction.offsetX[this.field_150866_c] * i;
                final int k = this.field_150861_f.posZ + Direction.offsetZ[this.field_150866_c] * i;
                for (int l = 0; l < this.field_150862_g; ++l) {
                    final int i2 = this.field_150861_f.posY + l;
                    this.worldObj.setBlock(j, i2, k, HorrorReg.otherworldPortal, this.field_150865_b, 2);
                }
            }
        }
    }
}
