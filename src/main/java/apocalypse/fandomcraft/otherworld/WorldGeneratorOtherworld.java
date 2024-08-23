package apocalypse.fandomcraft.otherworld;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class WorldGeneratorOtherworld extends WorldGenerator
{
    private Block field_150519_a;
    private int numberOfBlocks;
    private Block field_150518_c;
    private int mineableBlockMeta;
    
    public WorldGeneratorOtherworld(final Block blockToPlace, final int howMeny, final Block replaceableBlock) {
        this.field_150519_a = blockToPlace;
        this.numberOfBlocks = howMeny;
        this.field_150518_c = replaceableBlock;
    }
    
    public WorldGeneratorOtherworld(final Block block, final int meta, final int number, final Block target) {
        this(block, number, target);
        this.mineableBlockMeta = meta;
    }
    
    public boolean generate(final World p_76484_1_, final Random p_76484_2_, final int p_76484_3_, final int p_76484_4_, final int p_76484_5_) {
        final float f = p_76484_2_.nextFloat() * 3.1415927f;
        final double d0 = p_76484_3_ + 8 + MathHelper.sin(f) * this.numberOfBlocks / 8.0f;
        final double d2 = p_76484_3_ + 8 - MathHelper.sin(f) * this.numberOfBlocks / 8.0f;
        final double d3 = p_76484_5_ + 8 + MathHelper.cos(f) * this.numberOfBlocks / 8.0f;
        final double d4 = p_76484_5_ + 8 - MathHelper.cos(f) * this.numberOfBlocks / 8.0f;
        final double d5 = p_76484_4_ + p_76484_2_.nextInt(3) - 2;
        final double d6 = p_76484_4_ + p_76484_2_.nextInt(3) - 2;
        for (int l = 0; l <= this.numberOfBlocks; ++l) {
            final double d7 = d0 + (d2 - d0) * l / this.numberOfBlocks;
            final double d8 = d5 + (d6 - d5) * l / this.numberOfBlocks;
            final double d9 = d3 + (d4 - d3) * l / this.numberOfBlocks;
            final double d10 = p_76484_2_.nextDouble() * this.numberOfBlocks / 16.0;
            final double d11 = (MathHelper.sin(l * 3.1415927f / this.numberOfBlocks) + 1.0f) * d10 + 1.0;
            final double d12 = (MathHelper.sin(l * 3.1415927f / this.numberOfBlocks) + 1.0f) * d10 + 1.0;
            final int i1 = MathHelper.floor_double(d7 - d11 / 2.0);
            final int j1 = MathHelper.floor_double(d8 - d12 / 2.0);
            final int k1 = MathHelper.floor_double(d9 - d11 / 2.0);
            final int l2 = MathHelper.floor_double(d7 + d11 / 2.0);
            final int i2 = MathHelper.floor_double(d8 + d12 / 2.0);
            final int j2 = MathHelper.floor_double(d9 + d11 / 2.0);
            for (int k2 = i1; k2 <= l2; ++k2) {
                final double d13 = (k2 + 0.5 - d7) / (d11 / 2.0);
                if (d13 * d13 < 1.0) {
                    for (int l3 = j1; l3 <= i2; ++l3) {
                        final double d14 = (l3 + 0.5 - d8) / (d12 / 2.0);
                        if (d13 * d13 + d14 * d14 < 1.0) {
                            for (int i3 = k1; i3 <= j2; ++i3) {
                                final double d15 = (i3 + 0.5 - d9) / (d11 / 2.0);
                                if (d13 * d13 + d14 * d14 + d15 * d15 < 1.0 && p_76484_1_.getBlock(k2, l3, i3).isReplaceableOreGen(p_76484_1_, k2, l3, i3, this.field_150518_c)) {
                                    p_76484_1_.setBlock(k2, l3, i3, this.field_150519_a, this.mineableBlockMeta, 2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
