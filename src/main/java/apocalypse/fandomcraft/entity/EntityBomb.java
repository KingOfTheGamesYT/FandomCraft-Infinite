 package apocalypse.fandomcraft.entity;

 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.projectile.EntityThrowable;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MovingObjectPosition;
 import net.minecraft.world.World;

 public class EntityBomb
   extends EntityThrowable
 {
   public EntityBomb(World world) {
     super(world);
   }

   public EntityBomb(World world, EntityLivingBase entity) {
     super(world, entity);
   }

   public EntityBomb(World world, double x, double y, double z) {
     super(world, x, y, z);
   }

   protected void onImpact(MovingObjectPosition mop) {
     if (mop.entityHit != null) {

       float damageCount = 7.0F;
       mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), damageCount);
     }
     if (!this.worldObj.isRemote) {

       this.worldObj.createExplosion((Entity)this, this.posX, this.posY, this.posZ, 2.0F, true);
       setDead();
     }
   }
 }