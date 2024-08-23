package apocalypse.fandomcraft.horror;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraftforge.common.util.*;

public class FCRenderBlocks
{
    public IBlockAccess blockAccess;
    public IIcon overrideBlockTexture;
    
    public boolean hasOverrideBlockTexture() {
        return this.overrideBlockTexture != null;
    }
    
    public IIcon getBlockIconFromSideAndMetadata(final Block p_147787_1_, final int p_147787_2_, final int p_147787_3_) {
        return this.getIconSafe(p_147787_1_.getIcon(p_147787_2_, p_147787_3_));
    }
    
    public IIcon getIconSafe(IIcon p_147758_1_) {
        if (p_147758_1_ == null) {
            p_147758_1_ = (IIcon)((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
        }
        return p_147758_1_;
    }
    
    public boolean renderBlockPane(final BlockPane p_147767_1_, final int p_147767_2_, final int p_147767_3_, final int p_147767_4_) {
        final int l = this.blockAccess.getHeight();
        final Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(p_147767_1_.getMixedBrightnessForBlock(this.blockAccess, p_147767_2_, p_147767_3_, p_147767_4_));
        final int i1 = p_147767_1_.colorMultiplier(this.blockAccess, p_147767_2_, p_147767_3_, p_147767_4_);
        float f = (i1 >> 16 & 0xFF) / 255.0f;
        float f2 = (i1 >> 8 & 0xFF) / 255.0f;
        float f3 = (i1 & 0xFF) / 255.0f;
        if (EntityRenderer.anaglyphEnable) {
            final float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
            final float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
            final float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
            f = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.setColorOpaque_F(f, f2, f3);
        IIcon iicon;
        IIcon iicon2;
        if (this.hasOverrideBlockTexture()) {
            iicon = this.overrideBlockTexture;
            iicon2 = this.overrideBlockTexture;
        }
        else {
            final int j1 = this.blockAccess.getBlockMetadata(p_147767_2_, p_147767_3_, p_147767_4_);
            iicon = this.getBlockIconFromSideAndMetadata((Block)p_147767_1_, 0, j1);
            iicon2 = p_147767_1_.func_150097_e();
        }
        final double d21 = iicon.getMinU();
        final double d22 = iicon.getInterpolatedU(8.0);
        final double d23 = iicon.getMaxU();
        final double d24 = iicon.getMinV();
        final double d25 = iicon.getMaxV();
        final double d26 = iicon2.getInterpolatedU(7.0);
        final double d27 = iicon2.getInterpolatedU(9.0);
        final double d28 = iicon2.getMinV();
        final double d29 = iicon2.getInterpolatedV(8.0);
        final double d30 = iicon2.getMaxV();
        final double d31 = p_147767_2_;
        final double d32 = p_147767_2_ + 0.5;
        final double d33 = p_147767_2_ + 1;
        final double d34 = p_147767_4_;
        final double d35 = p_147767_4_ + 0.5;
        final double d36 = p_147767_4_ + 1;
        final double d37 = p_147767_2_ + 0.5 - 0.0625;
        final double d38 = p_147767_2_ + 0.5 + 0.0625;
        final double d39 = p_147767_4_ + 0.5 - 0.0625;
        final double d40 = p_147767_4_ + 0.5 + 0.0625;
        final boolean flag = p_147767_1_.canPaneConnectTo(this.blockAccess, p_147767_2_, p_147767_3_, p_147767_4_ - 1, ForgeDirection.NORTH);
        final boolean flag2 = p_147767_1_.canPaneConnectTo(this.blockAccess, p_147767_2_, p_147767_3_, p_147767_4_ + 1, ForgeDirection.SOUTH);
        final boolean flag3 = p_147767_1_.canPaneConnectTo(this.blockAccess, p_147767_2_ - 1, p_147767_3_, p_147767_4_, ForgeDirection.WEST);
        final boolean flag4 = p_147767_1_.canPaneConnectTo(this.blockAccess, p_147767_2_ + 1, p_147767_3_, p_147767_4_, ForgeDirection.EAST);
        final boolean flag5 = p_147767_1_.shouldSideBeRendered(this.blockAccess, p_147767_2_, p_147767_3_ + 1, p_147767_4_, 1);
        final boolean flag6 = p_147767_1_.shouldSideBeRendered(this.blockAccess, p_147767_2_, p_147767_3_ - 1, p_147767_4_, 0);
        final double d41 = 0.01;
        final double d42 = 0.005;
        if ((!flag3 || !flag4) && (flag3 || flag4 || flag || flag2)) {
            if (flag3 && !flag4) {
                tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 1), d35, d21, d24);
                tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 0), d35, d21, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d22, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d22, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d21, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d21, d25);
                tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 0), d35, d22, d25);
                tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 1), d35, d22, d24);
                if (!flag2 && !flag) {
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d40, d26, d28);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d40, d26, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d39, d27, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d39, d27, d28);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d39, d26, d28);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d39, d26, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d40, d27, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d40, d27, d28);
                }
                if (flag5 || (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_ - 1, p_147767_3_ + 1, p_147767_4_))) {
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                }
                if (flag6 || (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_ - 1, p_147767_3_ - 1, p_147767_4_))) {
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d29);
                }
            }
            else if (!flag3 && flag4) {
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d22, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d22, d25);
                tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 0), d35, d23, d25);
                tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 1), d35, d23, d24);
                tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 1), d35, d22, d24);
                tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 0), d35, d22, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d23, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d23, d24);
                if (!flag2 && !flag) {
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d39, d26, d28);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d39, d26, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d40, d27, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d40, d27, d28);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d40, d26, d28);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d40, d26, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d39, d27, d30);
                    tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d39, d27, d28);
                }
                if (flag5 || (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_ + 1, p_147767_3_ + 1, p_147767_4_))) {
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d39, d26, d28);
                }
                if (flag6 || (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_ + 1, p_147767_3_ - 1, p_147767_4_))) {
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d39, d26, d28);
                }
            }
        }
        else {
            tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 1), d35, d21, d24);
            tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 0), d35, d21, d25);
            tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 0), d35, d23, d25);
            tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 1), d35, d23, d24);
            tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 1), d35, d21, d24);
            tessellator.addVertexWithUV(d33, (double)(p_147767_3_ + 0), d35, d21, d25);
            tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 0), d35, d23, d25);
            tessellator.addVertexWithUV(d31, (double)(p_147767_3_ + 1), d35, d23, d24);
            if (flag5) {
                tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d40, d27, d30);
                tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d40, d27, d28);
                tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d39, d26, d28);
                tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d39, d26, d30);
                tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d40, d27, d30);
                tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d40, d27, d28);
                tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d39, d26, d28);
                tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d39, d26, d30);
            }
            else {
                if (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_ - 1, p_147767_3_ + 1, p_147767_4_)) {
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ + 1 + 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                }
                if (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_ + 1, p_147767_3_ + 1, p_147767_4_)) {
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ + 1 + 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ + 1 + 0.01, d39, d26, d28);
                }
            }
            if (flag6) {
                tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d40, d27, d30);
                tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d40, d27, d28);
                tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d39, d26, d28);
                tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d39, d26, d30);
                tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d40, d27, d30);
                tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d40, d27, d28);
                tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d39, d26, d28);
                tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d39, d26, d30);
            }
            else {
                if (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_ - 1, p_147767_3_ - 1, p_147767_4_)) {
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d40, d27, d30);
                    tessellator.addVertexWithUV(d31, p_147767_3_ - 0.01, d39, d26, d30);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d29);
                }
                if (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_ + 1, p_147767_3_ - 1, p_147767_4_)) {
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d28);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d40, d27, d28);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d40, d27, d29);
                    tessellator.addVertexWithUV(d32, p_147767_3_ - 0.01, d39, d26, d29);
                    tessellator.addVertexWithUV(d33, p_147767_3_ - 0.01, d39, d26, d28);
                }
            }
        }
        if ((!flag || !flag2) && (flag3 || flag4 || flag || flag2)) {
            if (flag && !flag2) {
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d34, d21, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d34, d21, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d22, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d22, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d21, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d21, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d34, d22, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d34, d22, d24);
                if (!flag4 && !flag3) {
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 1), d35, d26, d28);
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 0), d35, d26, d30);
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 0), d35, d27, d30);
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 1), d35, d27, d28);
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 1), d35, d26, d28);
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 0), d35, d26, d30);
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 0), d35, d27, d30);
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 1), d35, d27, d28);
                }
                if (flag5 || (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ + 1, p_147767_4_ - 1))) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d34, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d34, d26, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d34, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d34, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d26, d28);
                }
                if (flag6 || (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ - 1, p_147767_4_ - 1))) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d34, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d34, d26, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d34, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d34, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d26, d28);
                }
            }
            else if (!flag && flag2) {
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d22, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d22, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d36, d23, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d36, d23, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d36, d22, d24);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d36, d22, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d35, d23, d25);
                tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d35, d23, d24);
                if (!flag4 && !flag3) {
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 1), d35, d26, d28);
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 0), d35, d26, d30);
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 0), d35, d27, d30);
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 1), d35, d27, d28);
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 1), d35, d26, d28);
                    tessellator.addVertexWithUV(d37, (double)(p_147767_3_ + 0), d35, d26, d30);
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 0), d35, d27, d30);
                    tessellator.addVertexWithUV(d38, (double)(p_147767_3_ + 1), d35, d27, d28);
                }
                if (flag5 || (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ + 1, p_147767_4_ + 1))) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d36, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d36, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d36, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d36, d27, d29);
                }
                if (flag6 || (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ - 1, p_147767_4_ + 1))) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d36, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d36, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d36, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d36, d27, d29);
                }
            }
        }
        else {
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d36, d21, d24);
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d36, d21, d25);
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d34, d23, d25);
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d34, d23, d24);
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d34, d21, d24);
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d34, d21, d25);
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 0), d36, d23, d25);
            tessellator.addVertexWithUV(d32, (double)(p_147767_3_ + 1), d36, d23, d24);
            if (flag5) {
                tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d36, d27, d30);
                tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d34, d27, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d34, d26, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d36, d26, d30);
                tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d34, d27, d30);
                tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d36, d27, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d36, d26, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d34, d26, d30);
            }
            else {
                if (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ + 1, p_147767_4_ - 1)) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d34, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d34, d26, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d34, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d34, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d26, d28);
                }
                if (p_147767_3_ < l - 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ + 1, p_147767_4_ + 1)) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d36, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d36, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d36, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ + 1 + 0.005, d35, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d35, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ + 1 + 0.005, d36, d27, d29);
                }
            }
            if (flag6) {
                tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d36, d27, d30);
                tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d34, d27, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d34, d26, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d36, d26, d30);
                tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d34, d27, d30);
                tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d36, d27, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d36, d26, d28);
                tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d34, d26, d30);
            }
            else {
                if (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ - 1, p_147767_4_ - 1)) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d34, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d34, d26, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d27, d28);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d34, d27, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d34, d26, d29);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d26, d28);
                }
                if (p_147767_3_ > 1 && this.blockAccess.isAirBlock(p_147767_2_, p_147767_3_ - 1, p_147767_4_ + 1)) {
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d36, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d36, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d27, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d36, d26, d29);
                    tessellator.addVertexWithUV(d37, p_147767_3_ - 0.005, d35, d26, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d35, d27, d30);
                    tessellator.addVertexWithUV(d38, p_147767_3_ - 0.005, d36, d27, d29);
                }
            }
        }
        return true;
    }
}
