 package apocalypse.fandomcraft.entity;

 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.projectile.EntityThrowable;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MovingObjectPosition;
 import net.minecraft.world.World;

 public class EntityKoopaShell
   extends EntityThrowable
 {
   public EntityKoopaShell(World world) {
     super(world);
   }

   public EntityKoopaShell(World world, EntityLivingBase entity) {
     super(world, entity);
   }

   public EntityKoopaShell(World world, double x, double y, double z) {
     super(world, x, y, z);
   }

   protected void onImpact(MovingObjectPosition mop) {
     if (mop.entityHit != null) {

       float damage = 40.0F;
       mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), damage);
     }

     for (int l = 0; l < 5; l++)
     {
       this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
     }

     if (!this.worldObj.isRemote)
     {
       setDead();
     }
   }
 }