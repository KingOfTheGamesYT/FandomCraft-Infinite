package apocalypse.fandomcraft.tools;

import apocalypse.fandomcraft.main.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import apocalypse.fandomcraft.entity.*;
import java.util.*;
import net.minecraft.util.*;

public class RedLion extends ItemBoat
{
    public RedLion() {
        this.maxStackSize = 1;
        this.setCreativeTab(Main.tabFandomCraftMisc);
    }
    
    public ItemStack onItemRightClick(final ItemStack itemStackIn, final World worldIn, final EntityPlayer player) {
        final float f = 1.0f;
        final float f2 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
        final float f3 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
        final double d0 = player.prevPosX + (player.posX - player.prevPosX) * f;
        final double d2 = player.prevPosY + (player.posY - player.prevPosY) * f + 1.62 - player.yOffset;
        final double d3 = player.prevPosZ + (player.posZ - player.prevPosZ) * f;
        final Vec3 vec3 = Vec3.createVectorHelper(d0, d2, d3);
        final float f4 = MathHelper.cos(-f3 * 0.017453292f - 3.1415927f);
        final float f5 = MathHelper.sin(-f3 * 0.017453292f - 3.1415927f);
        final float f6 = -MathHelper.cos(-f2 * 0.017453292f);
        final float f7 = MathHelper.sin(-f2 * 0.017453292f);
        final float f8 = f5 * f6;
        final float f9 = f4 * f6;
        final double d4 = 5.0;
        final Vec3 vec4 = vec3.addVector(f8 * d4, f7 * d4, f9 * d4);
        final MovingObjectPosition movingobjectposition = worldIn.rayTraceBlocks(vec3, vec4, true);
        if (movingobjectposition == null) {
            return itemStackIn;
        }
        final Vec3 vec5 = player.getLook(f);
        boolean flag = false;
        final float f10 = 1.0f;
        final List list = worldIn.getEntitiesWithinAABBExcludingEntity((Entity)player, player.boundingBox.addCoord(vec5.xCoord * d4, vec5.yCoord * d4, vec5.zCoord * d4).expand((double)f10, (double)f10, (double)f10));
        for (int i = 0; i < list.size(); ++i) {
            final Entity entity = (Entity) list.get(i);
            if (entity.canBeCollidedWith()) {
                final float f11 = entity.getCollisionBorderSize();
                final AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double)f11, (double)f11, (double)f11);
                if (axisalignedbb.isVecInside(vec3)) {
                    flag = true;
                }
            }
        }
        if (flag) {
            return itemStackIn;
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            final int k = movingobjectposition.blockZ;
            if (worldIn.getBlock(i, j, k) == Blocks.snow_layer) {
                --j;
            }
            final EntityRedLion lion = new EntityRedLion(worldIn, (double)(i + 0.5f), (double)(j + 1.0f), (double)(k + 0.5f));
            lion.rotationYaw = (float)(((MathHelper.floor_double(player.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3) - 1) * 90);
            if (!worldIn.getCollidingBoundingBoxes((Entity)lion, lion.boundingBox.expand(-0.1, -0.1, -0.1)).isEmpty()) {
                return itemStackIn;
            }
            if (!worldIn.isRemote) {
                worldIn.spawnEntityInWorld((Entity)lion);
            }
            if (!player.capabilities.isCreativeMode) {
                --itemStackIn.stackSize;
            }
        }
        return itemStackIn;
    }
}
