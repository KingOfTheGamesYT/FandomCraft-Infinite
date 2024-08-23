package apocalypse.fandomcraft.zelda;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import apocalypse.fandomcraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class TingleTuner extends Item
{
    public TingleTuner() {
        this.maxStackSize = 1;
    }
    
    public boolean onItemUse(final ItemStack p_77648_1_, final EntityPlayer p_77648_2_, final World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, final int p_77648_7_, final float p_77648_8_, final float p_77648_9_, final float p_77648_10_) {
        if (p_77648_3_.isRemote) {
            return true;
        }
        final Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
        p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
        p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
        p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];
        double d0 = 0.0;
        if (p_77648_7_ == 1 && block.getRenderType() == 11) {
            d0 = 0.5;
        }
        final Entity entity = spawnCreature(p_77648_3_, p_77648_1_.getItemSpriteNumber(), p_77648_4_ + 0.5, p_77648_5_ + d0, p_77648_6_ + 0.5);
        if (entity != null) {
            if (entity instanceof EntityLivingBase && p_77648_1_.hasDisplayName()) {
                ((EntityLiving)entity).setCustomNameTag(p_77648_1_.getDisplayName());
            }
            if (!p_77648_2_.capabilities.isCreativeMode) {
                --p_77648_1_.stackSize;
            }
        }
        return true;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemStackIn, final World worldIn, final EntityPlayer player) {
        if (worldIn.isRemote) {
            return itemStackIn;
        }
        final MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, player, true);
        if (movingobjectposition == null) {
            return itemStackIn;
        }
        if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            final int i = movingobjectposition.blockX;
            final int j = movingobjectposition.blockY;
            final int k = movingobjectposition.blockZ;
            if (!worldIn.canMineBlock(player, i, j, k)) {
                return itemStackIn;
            }
            if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStackIn)) {
                return itemStackIn;
            }
            if (worldIn.getBlock(i, j, k) instanceof BlockLiquid) {
                final Entity entity = spawnCreature(worldIn, itemStackIn.getItemSpriteNumber(), i, j, k);
                if (entity != null) {
                    if (entity instanceof EntityLivingBase && itemStackIn.hasDisplayName()) {
                        ((EntityLiving)entity).setCustomNameTag(itemStackIn.getDisplayName());
                    }
                    if (!player.capabilities.isCreativeMode) {
                        --itemStackIn.stackSize;
                    }
                }
            }
        }
        return itemStackIn;
    }
    
    public static Entity spawnCreature(final World world, final int p_77840_1_, final double x, final double y, final double z) {
        final EntityTingle chaos = new EntityTingle(world);
        chaos.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0f), 0.0f);
        chaos.rotationYawHead = chaos.rotationYaw;
        chaos.renderYawOffset = chaos.rotationYaw;
        chaos.onSpawnWithEgg((IEntityLivingData)null);
        world.spawnEntityInWorld((Entity)chaos);
        chaos.playLivingSound();
        return (Entity)chaos;
    }
}
