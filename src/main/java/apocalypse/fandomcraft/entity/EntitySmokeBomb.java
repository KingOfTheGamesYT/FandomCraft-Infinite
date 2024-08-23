 package apocalypse.fandomcraft.entity;

 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.projectile.EntityThrowable;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MovingObjectPosition;
 import net.minecraft.world.World;

 public class EntitySmokeBomb
   extends EntityThrowable
 {
   public EntitySmokeBomb(World world) {
     super(world);
   }

   public EntitySmokeBomb(World world, EntityLivingBase entity) {
     super(world, entity);
   }

   public EntitySmokeBomb(World world, double x, double y, double z) {
     super(world, x, y, z);
   }

   protected void onImpact(MovingObjectPosition mop) {
     if (mop.entityHit != null) {

       float damageCount = 7.0F;
       mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), damageCount);
     }

     for (int l = 0; l < 5; l++) {

       this.worldObj.spawnParticle("hugeexplosion", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
       this.worldObj.spawnParticle("explode", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
       this.worldObj.spawnParticle("cloud", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
       this.worldObj.spawnParticle("snowshovel", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
     }

     if (!this.worldObj.isRemote)
     {
       setDead();
     }
   }
 }