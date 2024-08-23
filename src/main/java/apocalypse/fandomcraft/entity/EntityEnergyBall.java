 package apocalypse.fandomcraft.entity;

 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.projectile.EntityThrowable;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.util.MovingObjectPosition;
 import net.minecraft.world.World;

 public class EntityEnergyBall
   extends EntityThrowable {
   float power;
   int fadeTimer;

   public EntityEnergyBall(World par1World) {
     super(par1World);

     this.fadeTimer = 0; } public EntityEnergyBall(World world, EntityLivingBase living, float f) { super(world, living); this.fadeTimer = 0; this.power = f; } public EntityEnergyBall(World world, double x, double y, double z) { super(world, x, y, z); this.fadeTimer = 0; }
    protected float getGravityVelocity() {
     return 0.0F;
   }
   public void onUpdate(World world, EntityLivingBase living, EntityLivingBase livingbase, float f1_, float f2_) {
     this.posY = living.posY + living.getEyeHeight() - 0.10000000149011612D;
     double d0 = livingbase.posX - living.posX;
     double d1 = livingbase.boundingBox.minY + (livingbase.height / 3.0F) - this.posY;
     double d2 = livingbase.posZ - living.posZ;
     double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);

     if (d3 >= 1.0E-7D) {

       float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
       float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
       double d4 = d0 / d3;
       double d5 = d2 / d3;
       setLocationAndAngles(living.posX + d4, this.posY, living.posZ + d5, f2, f3);
       this.yOffset = 0.0F;
       float f4 = (float)d3 * 0.2F;
       setThrowableHeading(d0, d1 + f4, d2, f1_, f2_);
     }

     this.fadeTimer++;
     if (this.fadeTimer >= 100)
     {
       setDead();
     }
   }

   protected void onImpact(MovingObjectPosition mop) {
     if (mop.entityHit != null) {

       mop.entityHit.hurtResistantTime = 0;
       mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)getThrower()), this.power);

       mop.entityHit.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "fandomcraft:energyHit", 1.0F, 1.0F);
       if (mop.entityHit instanceof EntityLiving) {

         EntityLiving living = (EntityLiving)mop.entityHit;

         if (mop.entityHit != null) {

           float damage = 14.0F;
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
   }

   public void setIsCritical(boolean b) {
     float damage = 14.0F;
   }
 }