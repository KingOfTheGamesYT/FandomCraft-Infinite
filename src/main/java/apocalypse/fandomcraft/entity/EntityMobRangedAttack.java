 package apocalypse.fandomcraft.entity;

 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import java.util.List;
 import net.minecraft.block.Block;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.projectile.EntityThrowable;
 import net.minecraft.nbt.NBTBase;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.nbt.NBTTagList;
 import net.minecraft.util.AxisAlignedBB;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.util.MovingObjectPosition;
 import net.minecraft.util.Vec3;
 import net.minecraft.world.World;

public abstract class EntityMobRangedAttack
   extends EntityThrowable
 {
   private int field_145795_e = -1;
   private int field_145793_f = -1;
  private int field_145794_g = -1;

  private Block field_145796_h;
  private boolean inGround;
   public EntityLivingBase shootingEntity;
  private int ticksAlive;
   private int ticksInAir;
   public double accelerationX;
  public double accelerationY;
   public double accelerationZ;
  private static final String __OBFID = "CL_00001717";

   public EntityMobRangedAttack(World p_i1759_1_) {
    super(p_i1759_1_);
     setSize(1.0F, 1.0F);
   }

   protected void entityInit() {}

  @SideOnly(Side.CLIENT)
   public boolean isInRangeToRenderDist(double p_70112_1_) {
   double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
    d1 *= 64.0D;
    return (p_70112_1_ < d1 * d1);
   }

   public EntityMobRangedAttack(World p_i1760_1_, double p_i1760_2_, double p_i1760_4_, double p_i1760_6_, double p_i1760_8_, double p_i1760_10_, double p_i1760_12_) {
     super(p_i1760_1_);
   setSize(1.0F, 1.0F);
     setLocationAndAngles(p_i1760_2_, p_i1760_4_, p_i1760_6_, this.rotationYaw, this.rotationPitch);
    setPosition(p_i1760_2_, p_i1760_4_, p_i1760_6_);
   double d6 = MathHelper.sqrt_double(p_i1760_8_ * p_i1760_8_ + p_i1760_10_ * p_i1760_10_ + p_i1760_12_ * p_i1760_12_);
     this.accelerationX = p_i1760_8_ / d6 * 0.1D;
    this.accelerationY = p_i1760_10_ / d6 * 0.1D;
    this.accelerationZ = p_i1760_12_ / d6 * 0.1D;
 }

  public EntityMobRangedAttack(World p_i1761_1_, EntityLivingBase p_i1761_2_, double p_i1761_3_, double p_i1761_5_, double p_i1761_7_) {
    super(p_i1761_1_);
    this.shootingEntity = p_i1761_2_;
    setSize(1.0F, 1.0F);
     setLocationAndAngles(p_i1761_2_.posX, p_i1761_2_.posY, p_i1761_2_.posZ, p_i1761_2_.rotationYaw, p_i1761_2_.rotationPitch);
     setPosition(this.posX, this.posY, this.posZ);
     this.yOffset = 0.0F;
    this.motionX = this.motionY = this.motionZ = 0.0D;
    p_i1761_3_ += this.rand.nextGaussian() * 0.4D;
   p_i1761_5_ += this.rand.nextGaussian() * 0.4D;
    p_i1761_7_ += this.rand.nextGaussian() * 0.4D;
    double d3 = MathHelper.sqrt_double(p_i1761_3_ * p_i1761_3_ + p_i1761_5_ * p_i1761_5_ + p_i1761_7_ * p_i1761_7_);
    this.accelerationX = p_i1761_3_ / d3 * 0.1D;
     this.accelerationY = p_i1761_5_ / d3 * 0.1D;
    this.accelerationZ = p_i1761_7_ / d3 * 0.1D;
  }

  public void onUpdate() {
    if (!this.worldObj.isRemote && ((this.shootingEntity != null && this.shootingEntity.isDead) || !this.worldObj.blockExists((int)this.posX, (int)this.posY, (int)this.posZ))) {

       setDead();
    }
     else {

       super.onUpdate();
     setFire(1);

       if (this.inGround) {

         if (this.worldObj.getBlock(this.field_145795_e, this.field_145793_f, this.field_145794_g) == this.field_145796_h) {

         this.ticksAlive++;

           if (this.ticksAlive == 600)
          {
             setDead();
          }

           return;
       }

         this.inGround = false;
        this.motionX *= (this.rand.nextFloat() * 0.2F);
         this.motionY *= (this.rand.nextFloat() * 0.2F);
       this.motionZ *= (this.rand.nextFloat() * 0.2F);
        this.ticksAlive = 0;
         this.ticksInAir = 0;
     }
       else {

        this.ticksInAir++;
      }

       Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
      Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
       MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
      vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
       vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

      if (movingobjectposition != null)
       {
         vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
       }

       Entity entity = null;
     List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
       double d0 = 0.0D;

       for (int i = 0; i < list.size(); i++) {

        Entity entity1 = list.get(i);

         if (entity1.canBeCollidedWith() && (!entity1.isEntityEqual((Entity)this.shootingEntity) || this.ticksInAir >= 25)) {

           float f = 0.3F;
        AxisAlignedBB axisalignedbb = entity1.boundingBox.expand(f, f, f);
      MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

     if (movingobjectposition1 != null) {

          double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

            if (d1 < d0 || d0 == 0.0D) {

             entity = entity1;
             d0 = d1;
            }
           }
         }
       }

      if (entity != null)
       {
         movingobjectposition = new MovingObjectPosition(entity);
      }

     if (movingobjectposition != null)
     {
        onImpact(movingobjectposition);
      }

       this.posX += this.motionX;
       this.posY += this.motionY;
      this.posZ += this.motionZ;
     float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
     this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) + 90.0F;

      for (this.rotationPitch = (float)(Math.atan2(f1, this.motionY) * 180.0D / Math.PI) - 90.0F; this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);

     while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
      {
        this.prevRotationPitch += 360.0F;
      }

     while (this.rotationYaw - this.prevRotationYaw < -180.0F)
       {
        this.prevRotationYaw -= 360.0F;
      }

       while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
      {
        this.prevRotationYaw += 360.0F;
       }

      this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
      this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
      float f2 = getMotionFactor();

      if (isInWater()) {

         for (int j = 0; j < 4; j++) {

          float f3 = 0.25F;
           this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
        }

       f2 = 0.8F;
     }

       this.motionX += this.accelerationX;
     this.motionY += this.accelerationY;
      this.motionZ += this.accelerationZ;
      this.motionX *= f2;
      this.motionY *= f2;
       this.motionZ *= f2;
       this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
       setPosition(this.posX, this.posY, this.posZ);
     }
   }

   protected float getMotionFactor() {
    return 0.95F;
  }

   protected abstract void onImpact(MovingObjectPosition paramMovingObjectPosition);

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
    p_70014_1_.setShort("xTile", (short)this.field_145795_e);
   p_70014_1_.setShort("yTile", (short)this.field_145793_f);
   p_70014_1_.setShort("zTile", (short)this.field_145794_g);
    p_70014_1_.setByte("inTile", (byte)Block.getIdFromBlock(this.field_145796_h));
     p_70014_1_.setByte("inGround", (byte)(this.inGround ? 1 : 0));
     p_70014_1_.setTag("direction", (NBTBase)newDoubleNBTList(new double[] { this.motionX, this.motionY, this.motionZ }));
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
     this.field_145795_e = p_70037_1_.getShort("xTile");
     this.field_145793_f = p_70037_1_.getShort("yTile");
    this.field_145794_g = p_70037_1_.getShort("zTile");
     this.field_145796_h = Block.getBlockById(p_70037_1_.getByte("inTile") & 0xFF);
    this.inGround = (p_70037_1_.getByte("inGround") == 1);

    if (p_70037_1_.hasKey("direction", 9)) {

      NBTTagList nbttaglist = p_70037_1_.getTagList("direction", 6);
    this.motionX = nbttaglist.func_150309_d(0);
       this.motionY = nbttaglist.func_150309_d(1);
      this.motionZ = nbttaglist.func_150309_d(2);
     }
    else {

      setDead();
    }
   }

   public boolean canBeCollidedWith() {
     return true;
  }

 public float getCollisionBorderSize() {
   return 1.0F;
  }

  public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
     if (isEntityInvulnerable())
     {
      return false;
    }

   setBeenAttacked();

   if (p_70097_1_.getEntity() != null) {

      Vec3 vec3 = p_70097_1_.getEntity().getLookVec();

      if (vec3 != null) {
        this.motionX = vec3.xCoord;
        this.motionY = vec3.yCoord;
         this.motionZ = vec3.zCoord;
         this.accelerationX = this.motionX * 0.1D;
        this.accelerationY = this.motionY * 0.1D;
        this.accelerationZ = this.motionZ * 0.1D;
      }

       if (p_70097_1_.getEntity() instanceof EntityLivingBase)
     {
         this.shootingEntity = (EntityLivingBase)p_70097_1_.getEntity();
       }

      return true;
     }

    return false;
   }

  @SideOnly(Side.CLIENT)
 public float getShadowSize() {
     return 0.0F;
   }
 }
