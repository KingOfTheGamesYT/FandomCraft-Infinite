package apocalypse.fandomcraft.otherworld;

import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import apocalypse.fandomcraft.horror.*;
import java.util.*;
import net.minecraft.util.*;

public class OtherworldTeleporter extends Teleporter
{
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache;
    private final List destinationCoordinateKeys;
    
    public OtherworldTeleporter(final WorldServer worldIn) {
        super(worldIn);
        this.destinationCoordinateCache = new LongHashMap();
        this.destinationCoordinateKeys = new ArrayList();
        this.worldServerInstance = worldIn;
        this.random = new Random(worldIn.getSeed());
    }
    
    public void placeInPortal(final Entity p_77185_1_, final double p_77185_2_, final double p_77185_4_, final double p_77185_6_, final float p_77185_8_) {
        if (this.worldServerInstance.provider.dimensionId != 1) {
            if (!this.placeInExistingPortal(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_)) {
                this.makePortal(p_77185_1_);
                this.placeInExistingPortal(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_);
            }
        }
        else {
            final int i = MathHelper.floor_double(p_77185_1_.posX);
            final int j = MathHelper.floor_double(p_77185_1_.posY) - 1;
            final int k = MathHelper.floor_double(p_77185_1_.posZ);
            final byte b0 = 1;
            final byte b2 = 0;
            for (int l = -2; l <= 2; ++l) {
                for (int i2 = -2; i2 <= 2; ++i2) {
                    for (int j2 = -1; j2 < 3; ++j2) {
                        final int k2 = i + i2 * b0 + l * b2;
                        final int l2 = j + j2;
                        final int i3 = k + i2 * b2 - l * b0;
                        final boolean flag = j2 < 0;
                        this.worldServerInstance.setBlock(k2, l2, i3, flag ? Blocks.stone : Blocks.air);
                    }
                }
            }
            p_77185_1_.setLocationAndAngles((double)i, (double)j, (double)k, p_77185_1_.rotationYaw, 0.0f);
            final double motionX = 0.0;
            p_77185_1_.motionZ = motionX;
            p_77185_1_.motionY = motionX;
            p_77185_1_.motionX = motionX;
        }
    }
    
    public boolean placeInExistingPortal(final Entity p_77184_1_, final double p_77184_2_, final double p_77184_4_, final double p_77184_6_, final float p_77184_8_) {
        final short short1 = 128;
        double d3 = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        final int l = MathHelper.floor_double(p_77184_1_.posX);
        final int i2 = MathHelper.floor_double(p_77184_1_.posZ);
        final long j2 = ChunkCoordIntPair.chunkXZ2Int(l, i2);
        boolean flag = true;
        if (this.destinationCoordinateCache.containsItem(j2)) {
            final PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey(j2);
            d3 = 0.0;
            i = portalposition.posX;
            j = portalposition.posY;
            k = portalposition.posZ;
            portalposition.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            flag = false;
        }
        else {
            for (int l2 = l - short1; l2 <= l + short1; ++l2) {
                final double d4 = l2 + 0.5 - p_77184_1_.posX;
                for (int l3 = i2 - short1; l3 <= i2 + short1; ++l3) {
                    final double d5 = l3 + 0.5 - p_77184_1_.posZ;
                    for (int i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; --i3) {
                        if (this.worldServerInstance.getBlock(l2, i3, l3) == HorrorReg.otherworldPortal) {
                            while (this.worldServerInstance.getBlock(l2, i3 - 1, l3) == HorrorReg.otherworldPortal) {
                                --i3;
                            }
                            final double d6 = i3 + 0.5 - p_77184_1_.posY;
                            final double d7 = d4 * d4 + d6 * d6 + d5 * d5;
                            if (d3 < 0.0 || d7 < d3) {
                                d3 = d7;
                                i = l2;
                                j = i3;
                                k = l3;
                            }
                        }
                    }
                }
            }
        }
        if (d3 >= 0.0) {
            if (flag) {
                this.destinationCoordinateCache.add(j2, (Object)new PortalPosition(i, j, k, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(j2);
                System.out.println("Location " + j2);
            }
            double d8 = i + 0.5;
            final double d9 = j + 0.5;
            double d6 = k + 0.5;
            int i4 = -1;
            if (this.worldServerInstance.getBlock(i - 1, j, k) == HorrorReg.otherworldPortal) {
                i4 = 2;
            }
            if (this.worldServerInstance.getBlock(i + 1, j, k) == HorrorReg.otherworldPortal) {
                i4 = 0;
            }
            if (this.worldServerInstance.getBlock(i, j, k - 1) == HorrorReg.otherworldPortal) {
                i4 = 3;
            }
            if (this.worldServerInstance.getBlock(i, j, k + 1) == HorrorReg.otherworldPortal) {
                i4 = 1;
            }
            final int j3 = p_77184_1_.getTeleportDirection();
            if (i4 > -1) {
                int k2 = Direction.rotateLeft[i4];
                int l4 = Direction.offsetX[i4];
                int i5 = Direction.offsetZ[i4];
                int j4 = Direction.offsetX[k2];
                int k3 = Direction.offsetZ[k2];
                boolean flag2 = !this.worldServerInstance.isAirBlock(i + l4 + j4, j, k + i5 + k3) || !this.worldServerInstance.isAirBlock(i + l4 + j4, j + 1, k + i5 + k3);
                boolean flag3 = !this.worldServerInstance.isAirBlock(i + l4, j, k + i5) || !this.worldServerInstance.isAirBlock(i + l4, j + 1, k + i5);
                if (flag2 && flag3) {
                    i4 = Direction.rotateOpposite[i4];
                    k2 = Direction.rotateOpposite[k2];
                    l4 = Direction.offsetX[i4];
                    i5 = Direction.offsetZ[i4];
                    j4 = Direction.offsetX[k2];
                    k3 = Direction.offsetZ[k2];
                    final int l2 = i - j4;
                    d8 -= j4;
                    final int k4 = k - k3;
                    d6 -= k3;
                    flag2 = (!this.worldServerInstance.isAirBlock(l2 + l4 + j4, j, k4 + i5 + k3) || !this.worldServerInstance.isAirBlock(l2 + l4 + j4, j + 1, k4 + i5 + k3));
                    flag3 = (!this.worldServerInstance.isAirBlock(l2 + l4, j, k4 + i5) || !this.worldServerInstance.isAirBlock(l2 + l4, j + 1, k4 + i5));
                }
                float f1 = 0.5f;
                float f2 = 0.5f;
                if (!flag2 && flag3) {
                    f1 = 1.0f;
                }
                else if (flag2 && !flag3) {
                    f1 = 0.0f;
                }
                else if (flag2 && flag3) {
                    f2 = 0.0f;
                }
                d8 += j4 * f1 + f2 * l4;
                d6 += k3 * f1 + f2 * i5;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                if (i4 == j3) {
                    f3 = 1.0f;
                    f4 = 1.0f;
                }
                else if (i4 == Direction.rotateOpposite[j3]) {
                    f3 = -1.0f;
                    f4 = -1.0f;
                }
                else if (i4 == Direction.facingToDirection[j3]) {
                    f5 = 1.0f;
                    f6 = -1.0f;
                }
                else {
                    f5 = -1.0f;
                    f6 = 1.0f;
                }
                final double d10 = p_77184_1_.motionX;
                final double d11 = p_77184_1_.motionZ;
                p_77184_1_.motionX = d10 * f3 + d11 * f6;
                p_77184_1_.motionZ = d10 * f5 + d11 * f4;
                p_77184_1_.rotationYaw = p_77184_8_ - j3 * 90 + i4 * 90;
            }
            else {
                final double motionX = 0.0;
                p_77184_1_.motionZ = motionX;
                p_77184_1_.motionY = motionX;
                p_77184_1_.motionX = motionX;
            }
            p_77184_1_.setLocationAndAngles(d8, d9, d6, p_77184_1_.rotationYaw, p_77184_1_.rotationPitch);
            return true;
        }
        return false;
    }
    
    public boolean makePortal(final Entity p_85188_1_) {
        final byte b0 = 16;
        double d0 = -1.0;
        final int i = MathHelper.floor_double(p_85188_1_.posX);
        final int j = MathHelper.floor_double(p_85188_1_.posY);
        final int k = MathHelper.floor_double(p_85188_1_.posZ);
        int l = i;
        int i2 = j;
        int j2 = k;
        int k2 = 0;
        final int l2 = this.random.nextInt(4);
        for (int i3 = i - b0; i3 <= i + b0; ++i3) {
            final double d2 = i3 + 0.5 - p_85188_1_.posX;
            for (int k3 = k - b0; k3 <= k + b0; ++k3) {
                final double d3 = k3 + 0.5 - p_85188_1_.posZ;
            Label_0433:
                for (int i4 = this.worldServerInstance.getActualHeight() - 1; i4 >= 0; --i4) {
                    if (this.worldServerInstance.isAirBlock(i3, i4, k3)) {
                        while (i4 > 0 && this.worldServerInstance.isAirBlock(i3, i4 - 1, k3)) {
                            --i4;
                        }
                        for (int j3 = l2; j3 < l2 + 4; ++j3) {
                            int k4 = j3 % 2;
                            int l3 = 1 - k4;
                            if (j3 % 4 >= 2) {
                                k4 = -k4;
                                l3 = -l3;
                            }
                            for (int i5 = 0; i5 < 3; ++i5) {
                                for (int j4 = 0; j4 < 4; ++j4) {
                                    for (int k5 = -1; k5 < 4; ++k5) {
                                        final int l4 = i3 + (j4 - 1) * k4 + i5 * l3;
                                        final int i6 = i4 + k5;
                                        final int j5 = k3 + (j4 - 1) * l3 - i5 * k4;
                                        if (k5 < 0 && !this.worldServerInstance.getBlock(l4, i6, j5).getMaterial().isSolid()) {
                                            continue Label_0433;
                                        }
                                        if (k5 >= 0 && !this.worldServerInstance.isAirBlock(l4, i6, j5)) {
                                            continue Label_0433;
                                        }
                                    }
                                }
                            }
                            final double d4 = i4 + 0.5 - p_85188_1_.posY;
                            final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                            if (d0 < 0.0 || d5 < d0) {
                                d0 = d5;
                                l = i3;
                                i2 = i4;
                                j2 = k3;
                                k2 = j3 % 4;
                            }
                        }
                    }
                }
            }
        }
        if (d0 < 0.0) {
            for (int i3 = i - b0; i3 <= i + b0; ++i3) {
                final double d2 = i3 + 0.5 - p_85188_1_.posX;
                for (int k3 = k - b0; k3 <= k + b0; ++k3) {
                    final double d3 = k3 + 0.5 - p_85188_1_.posZ;
                Label_0786:
                    for (int i4 = this.worldServerInstance.getActualHeight() - 1; i4 >= 0; --i4) {
                        if (this.worldServerInstance.isAirBlock(i3, i4, k3)) {
                            while (i4 > 0 && this.worldServerInstance.isAirBlock(i3, i4 - 1, k3)) {
                                --i4;
                            }
                            for (int j3 = l2; j3 < l2 + 2; ++j3) {
                                final int k4 = j3 % 2;
                                final int l3 = 1 - k4;
                                for (int i5 = 0; i5 < 4; ++i5) {
                                    for (int j4 = -1; j4 < 4; ++j4) {
                                        final int k5 = i3 + (i5 - 1) * k4;
                                        final int l4 = i4 + j4;
                                        final int i6 = k3 + (i5 - 1) * l3;
                                        if (j4 < 0 && !this.worldServerInstance.getBlock(k5, l4, i6).getMaterial().isSolid()) {
                                            continue Label_0786;
                                        }
                                        if (j4 >= 0 && !this.worldServerInstance.isAirBlock(k5, l4, i6)) {
                                            continue Label_0786;
                                        }
                                    }
                                }
                                final double d4 = i4 + 0.5 - p_85188_1_.posY;
                                final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                                if (d0 < 0.0 || d5 < d0) {
                                    d0 = d5;
                                    l = i3;
                                    i2 = i4;
                                    j2 = k3;
                                    k2 = j3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int k6 = l;
        int j6 = i2;
        int k3 = j2;
        int l5 = k2 % 2;
        int l6 = 1 - l5;
        if (k2 % 4 >= 2) {
            l5 = -l5;
            l6 = -l6;
        }
        if (d0 < 0.0) {
            if (i2 < 70) {
                i2 = 70;
            }
            if (i2 > this.worldServerInstance.getActualHeight() - 10) {
                i2 = this.worldServerInstance.getActualHeight() - 10;
            }
            j6 = i2;
            for (int i4 = -1; i4 <= 1; ++i4) {
                for (int j3 = 1; j3 < 3; ++j3) {
                    for (int k4 = -1; k4 < 3; ++k4) {
                        final int l3 = k6 + (j3 - 1) * l5 + i4 * l6;
                        final int i5 = j6 + k4;
                        final int j4 = k3 + (j3 - 1) * l6 - i4 * l5;
                        final boolean flag = k4 < 0;
                        this.worldServerInstance.setBlock(l3, i5, j4, flag ? Blocks.stone : Blocks.air);
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 4; ++i4) {
            for (int j3 = 0; j3 < 4; ++j3) {
                for (int k4 = -1; k4 < 4; ++k4) {
                    final int l3 = k6 + (j3 - 1) * l5;
                    final int i5 = j6 + k4;
                    final int j4 = k3 + (j3 - 1) * l6;
                    final boolean flag = j3 == 0 || j3 == 3 || k4 == -1 || k4 == 3;
                    this.worldServerInstance.setBlock(l3, i5, j4, flag ? Blocks.stone : HorrorReg.otherworldPortal, 0, 2);
                }
            }
            for (int j3 = 0; j3 < 4; ++j3) {
                for (int k4 = -1; k4 < 4; ++k4) {
                    final int l3 = k6 + (j3 - 1) * l5;
                    final int i5 = j6 + k4;
                    final int j4 = k3 + (j3 - 1) * l6;
                    this.worldServerInstance.notifyBlocksOfNeighborChange(l3, i5, j4, this.worldServerInstance.getBlock(l3, i5, j4));
                }
            }
        }
        return true;
    }
    
    public void removeStalePortalLocations(final long p_85189_1_) {
        if (p_85189_1_ % 100L == 0L) {
            final Iterator iterator = this.destinationCoordinateKeys.iterator();
            final long j = p_85189_1_ - 600L;
            while (iterator.hasNext()) {
                final Long olong = (Long) iterator.next();
                final PortalPosition portalposition = (PortalPosition)this.destinationCoordinateCache.getValueByKey((long)olong);
                if (portalposition == null || portalposition.lastUpdateTime < j) {
                    iterator.remove();
                    this.destinationCoordinateCache.remove((long)olong);
                }
            }
        }
    }
    
    public class PortalPosition extends ChunkCoordinates
    {
        public long lastUpdateTime;
        
        public PortalPosition(final int p_i1962_2_, final int p_i1962_3_, final int p_i1962_4_, final long p_i1962_5_) {
            super(p_i1962_2_, p_i1962_3_, p_i1962_4_);
            this.lastUpdateTime = p_i1962_5_;
        }
    }
}
