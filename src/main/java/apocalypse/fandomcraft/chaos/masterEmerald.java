 package apocalypse.fandomcraft.chaos;

 import apocalypse.fandomcraft.entity.EntityChaosBoss;
 import net.minecraft.block.Block;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.IEntityLivingData;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.Facing;
 import net.minecraft.util.MathHelper;
 import net.minecraft.util.MovingObjectPosition;
 import net.minecraft.world.World;

 public class masterEmerald
   extends Item
 {
   public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
     if (p_77648_3_.isRemote)
     {
       return true;
     }

     Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);
     p_77648_4_ += Facing.offsetsXForSide[p_77648_7_];
     p_77648_5_ += Facing.offsetsYForSide[p_77648_7_];
     p_77648_6_ += Facing.offsetsZForSide[p_77648_7_];
     double d0 = 0.0D;

     if (p_77648_7_ == 1 && block.getRenderType() == 11)
     {
       d0 = 0.5D;
     }

     Entity entity = spawnCreature(p_77648_3_, p_77648_1_.getItemDamage(), p_77648_4_ + 0.5D, p_77648_5_ + d0, p_77648_6_ + 0.5D);

     if (entity != null) {

       if (entity instanceof net.minecraft.entity.EntityLivingBase && p_77648_1_.hasDisplayName())
       {
         ((EntityLiving)entity).setCustomNameTag(p_77648_1_.getDisplayName());
       }

       if (!p_77648_2_.capabilities.isCreativeMode)
       {
         p_77648_1_.stackSize--;
       }
     }

     return true;
   }

   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
     if (p_77659_2_.isRemote)
     {
       return p_77659_1_;
     }

     MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, true);

     if (movingobjectposition == null)
     {
       return p_77659_1_;
     }

     if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

       int i = movingobjectposition.blockX;
       int j = movingobjectposition.blockY;
       int k = movingobjectposition.blockZ;

       if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k))
       {
         return p_77659_1_;
       }

       if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
       {
         return p_77659_1_;
       }

       if (p_77659_2_.getBlock(i, j, k) instanceof net.minecraft.block.BlockLiquid) {

         Entity entity = spawnCreature(p_77659_2_, p_77659_1_.getItemDamage(), i, j, k);

         if (entity != null) {

           if (entity instanceof net.minecraft.entity.EntityLivingBase && p_77659_1_.hasDisplayName())
           {
             ((EntityLiving)entity).setCustomNameTag(p_77659_1_.getDisplayName());
           }

           if (!p_77659_3_.capabilities.isCreativeMode)
           {
             p_77659_1_.stackSize--;
           }
         }
       }
     }

     return p_77659_1_;
   }

   public static Entity spawnCreature(World world, int p_77840_1_, double x, double y, double z) {
     EntityChaosBoss chaos = new EntityChaosBoss(world);

     chaos.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
     chaos.rotationYawHead = chaos.rotationYaw;
     chaos.renderYawOffset = chaos.rotationYaw;
     chaos.onSpawnWithEgg((IEntityLivingData)null);
     world.spawnEntityInWorld((Entity)chaos);
     chaos.playLivingSound();
     return (Entity)chaos;
   }
 }