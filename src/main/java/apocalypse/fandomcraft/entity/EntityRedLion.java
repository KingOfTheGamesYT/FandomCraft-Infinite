 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import java.util.List;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.util.AxisAlignedBB;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityRedLion
   extends Entity
 {
   private boolean isBoatEmpty;
   private double speedMultiplier;
   private int boatPosRotationIncrements;
   private double boatX;
   private double boatY;
   private double boatZ;
   private double boatYaw;
   private double boatPitch;
   @SideOnly(Side.CLIENT)
   private double velocityX;
   @SideOnly(Side.CLIENT)
   private double velocityY;
   @SideOnly(Side.CLIENT)
   private double velocityZ;
   private static final String __OBFID = "CL_00001667";

   public EntityRedLion(World p_i1704_1_) {
     super(p_i1704_1_);
     this.isBoatEmpty = true;
     this.speedMultiplier = 0.07D;
     this.preventEntitySpawning = true;
     setSize(1.5F, 0.6F);
     this.yOffset = this.height / 2.0F;
   }

   protected boolean canTriggerWalking() {
     return false;
   }

   protected void entityInit() {
     this.dataWatcher.addObject(17, new Integer(0));
     this.dataWatcher.addObject(18, new Integer(1));
     this.dataWatcher.addObject(19, new Float(0.0F));
   }

   public AxisAlignedBB getCollisionBox(Entity p_70114_1_) {
     return p_70114_1_.boundingBox;
   }

   public AxisAlignedBB getBoundingBox() {
     return this.boundingBox;
   }

   public boolean canBePushed() {
     return true;
   }

   public EntityRedLion(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
     this(p_i1705_1_);
     setPosition(p_i1705_2_, p_i1705_4_ + this.yOffset, p_i1705_6_);
     this.motionX = 0.0D;
     this.motionY = 0.0D;
     this.motionZ = 0.0D;
     this.prevPosX = p_i1705_2_;
     this.prevPosY = p_i1705_4_;
     this.prevPosZ = p_i1705_6_;
   }

   public double getMountedYOffset() {
     return this.height * 0.0D - 0.30000001192092896D;
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
     if (isEntityInvulnerable())
     {
       return false;
     }
     if (!this.worldObj.isRemote && !this.isDead) {

       setForwardDirection(-getForwardDirection());
       setTimeSinceHit(10);
       setDamageTaken(getDamageTaken() + p_70097_2_ * 10.0F);
       setBeenAttacked();
       boolean flag = (p_70097_1_.getEntity() instanceof EntityPlayer && ((EntityPlayer)p_70097_1_.getEntity()).capabilities.isCreativeMode);

       if (flag || getDamageTaken() > 40.0F) {

         if (this.riddenByEntity != null)
         {
           this.riddenByEntity.mountEntity(this);
         }

         if (!flag)
         {
           func_145778_a(Main.redLion, 1, 0.0F);
         }

         setDead();
       }

       return true;
     }

     return true;
   }

   @SideOnly(Side.CLIENT)
   public void performHurtAnimation() {
     setForwardDirection(-getForwardDirection());
     setTimeSinceHit(10);
     setDamageTaken(getDamageTaken() * 11.0F);
   }

   public boolean canBeCollidedWith() {
     return !this.isDead;
   }

   @SideOnly(Side.CLIENT)
   public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
     if (this.isBoatEmpty) {

       this.boatPosRotationIncrements = p_70056_9_ + 5;
     }
     else {

       double d3 = p_70056_1_ - this.posX;
       double d4 = p_70056_3_ - this.posY;
       double d5 = p_70056_5_ - this.posZ;
       double d6 = d3 * d3 + d4 * d4 + d5 * d5;

       if (d6 <= 1.0D) {
         return;
       }

       this.boatPosRotationIncrements = 3;
     }

     this.boatX = p_70056_1_;
     this.boatY = p_70056_3_;
     this.boatZ = p_70056_5_;
     this.boatYaw = p_70056_7_;
     this.boatPitch = p_70056_8_;
     this.motionX = this.velocityX;
     this.motionY = this.velocityY;
     this.motionZ = this.velocityZ;
   }

   @SideOnly(Side.CLIENT)
   public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
     this.velocityX = this.motionX = p_70016_1_;
     this.velocityY = this.motionY = p_70016_3_;
     this.velocityZ = this.motionZ = p_70016_5_;
   }

   public void onUpdate() {
     super.onUpdate();

     if (getTimeSinceHit() > 0)
     {
       setTimeSinceHit(getTimeSinceHit() - 1);
     }

     if (getDamageTaken() > 0.0F)
     {
       setDamageTaken(getDamageTaken() - 1.0F);
     }

     this.prevPosX = this.posX;
     this.prevPosY = this.posY;
     this.prevPosZ = this.posZ;
     byte b0 = 5;
     double d0 = 0.0D;

     for (int i = 0; i < b0; i++) {

       double d1 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (i + 0) / b0 - 0.125D;
       double d3 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (i + 1) / b0 - 0.125D;
       AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox(this.boundingBox.minX, d1, this.boundingBox.minZ, this.boundingBox.maxX, d3, this.boundingBox.maxZ);

       if (this.worldObj.isAABBInMaterial(axisalignedbb, Material.water))
       {
         d0 += 1.0D / b0;
       }
     }

     double d10 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

     if (d10 > 0.26249999999999996D) {

       double d2 = Math.cos(this.rotationYaw * Math.PI / 180.0D);
       double d4 = Math.sin(this.rotationYaw * Math.PI / 180.0D);

       for (int j = 0; j < 1.0D + d10 * 60.0D; j++) {

         double d5 = (this.rand.nextFloat() * 2.0F - 1.0F);
         double d6 = (this.rand.nextInt(2) * 2 - 1) * 0.7D;

         if (this.rand.nextBoolean()) {

           double d8 = this.posX - d2 * d5 * 0.8D + d4 * d6;
           double d9 = this.posZ - d4 * d5 * 0.8D - d2 * d6;
           this.worldObj.spawnParticle("splash", d8, this.posY - 0.125D, d9, this.motionX, this.motionY, this.motionZ);
         }
         else {

           double d8 = this.posX + d2 + d4 * d5 * 0.7D;
           double d9 = this.posZ + d4 - d2 * d5 * 0.7D;
           this.worldObj.spawnParticle("splash", d8, this.posY - 0.125D, d9, this.motionX, this.motionY, this.motionZ);
         }
       }
     }

     if (this.worldObj.isRemote && this.isBoatEmpty) {

       if (this.boatPosRotationIncrements > 0)
       {
         double d2 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
         double d4 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
         double d11 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
         double d12 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
         this.rotationYaw = (float)(this.rotationYaw + d12 / this.boatPosRotationIncrements);
         this.rotationPitch = (float)(this.rotationPitch + (this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
         this.boatPosRotationIncrements--;
         setPosition(d2, d4, d11);
         setRotation(this.rotationYaw, this.rotationPitch);
       }
       else
       {
         double d2 = this.posX + this.motionX;
         double d4 = this.posY + this.motionY;
         double d11 = this.posZ + this.motionZ;
         setPosition(d2, d4, d11);

         if (this.onGround) {

           this.motionX *= 0.5D;
           this.motionY *= 0.5D;
           this.motionZ *= 0.5D;
         }

         this.motionX *= 0.9900000095367432D;
         this.motionY *= 0.949999988079071D;
         this.motionZ *= 0.9900000095367432D;
       }

     } else {

       if (d0 < 1.0D) {

         double d = d0 * 2.0D - 1.0D;
         this.motionY += 0.03999999910593033D * d;
       }
       else {

         if (this.motionY < 0.0D)
         {
           this.motionY /= 2.0D;
         }

         this.motionY += 0.007000000216066837D;
       }

       if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase) {

         EntityLivingBase entitylivingbase = (EntityLivingBase)this.riddenByEntity;
         float f = this.riddenByEntity.rotationYaw + -entitylivingbase.moveStrafing * 90.0F;
         this.motionX += -Math.sin((f * 3.1415927F / 180.0F)) * this.speedMultiplier * entitylivingbase.moveForward * 0.05000000074505806D;
         this.motionZ += Math.cos((f * 3.1415927F / 180.0F)) * this.speedMultiplier * entitylivingbase.moveForward * 0.05000000074505806D;
       }

       double d2 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

       if (d2 > 0.35D) {

         double d = 0.35D / d2;
         this.motionX *= d;
         this.motionZ *= d;
         d2 = 0.35D;
       }

       if (d2 > d10 && this.speedMultiplier < 0.35D) {

         this.speedMultiplier += (0.35D - this.speedMultiplier) / 35.0D;

         if (this.speedMultiplier > 0.35D)
         {
           this.speedMultiplier = 0.35D;
         }
       }
       else {

         this.speedMultiplier -= (this.speedMultiplier - 0.07D) / 35.0D;

         if (this.speedMultiplier < 0.07D)
         {
           this.speedMultiplier = 0.07D;
         }
       }

       for (int l = 0; l < 4; l++) {

         int i1 = MathHelper.floor_double(this.posX + ((l % 2) - 0.5D) * 0.8D);
         int j = MathHelper.floor_double(this.posZ + ((l / 2) - 0.5D) * 0.8D);

         for (int j1 = 0; j1 < 2; j1++) {

           int k = MathHelper.floor_double(this.posY) + j1;
           Block block = this.worldObj.getBlock(i1, k, j);

           if (block == Blocks.snow_layer) {

             this.worldObj.setBlockToAir(i1, k, j);
             this.isCollidedHorizontally = false;
           }
           else if (block == Blocks.waterlily) {

             this.worldObj.func_147480_a(i1, k, j, true);
             this.isCollidedHorizontally = false;
           }
         }
       }

       if (this.onGround) {

         this.motionX *= 0.5D;
         this.motionY *= 0.5D;
         this.motionZ *= 0.5D;
       }

       moveEntity(this.motionX, this.motionY, this.motionZ);

       if (this.isCollidedHorizontally && d10 > 0.2D) {

         if (!this.worldObj.isRemote && !this.isDead)
         {
           setDead();
           func_145778_a(Main.redLion, 1, 0.0F);
         }

       } else {

         this.motionX *= 0.9900000095367432D;
         this.motionY *= 0.949999988079071D;
         this.motionZ *= 0.9900000095367432D;
       }

       this.rotationPitch = 0.0F;
       double d4 = this.rotationYaw;
       double d11 = this.prevPosX - this.posX;
       double d12 = this.prevPosZ - this.posZ;

       if (d11 * d11 + d12 * d12 > 0.001D)
       {
         d4 = (float)(Math.atan2(d12, d11) * 180.0D / Math.PI);
       }

       double d7 = MathHelper.wrapAngleTo180_double(d4 - this.rotationYaw);

       if (d7 > 20.0D)
       {
         d7 = 20.0D;
       }

       if (d7 < -20.0D)
       {
         d7 = -20.0D;
       }

       this.rotationYaw = (float)(this.rotationYaw + d7);
       setRotation(this.rotationYaw, this.rotationPitch);

       if (!this.worldObj.isRemote) {

         List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));

         if (list != null && !list.isEmpty())
         {
           for (int k1 = 0; k1 < list.size(); k1++) {

             Entity entity = list.get(k1);

             if (entity != this.riddenByEntity && entity.canBePushed() && entity instanceof EntityRedLion)
             {
               entity.applyEntityCollision(this);
             }
           }
         }

         if (this.riddenByEntity != null && this.riddenByEntity.isDead)
         {
           this.riddenByEntity = null;
         }
       }
     }
   }

   public void updateRiderPosition() {
     if (this.riddenByEntity != null) {

       double d0 = Math.cos(this.rotationYaw * Math.PI / 180.0D) * 0.4D;
       double d1 = Math.sin(this.rotationYaw * Math.PI / 180.0D) * 0.4D;
       this.riddenByEntity.setPosition(this.posX + d0, this.posY + getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + d1);
     }
   }

   protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {}

   protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {}

   @SideOnly(Side.CLIENT)
   public float getShadowSize() {
     return 0.0F;
   }

   public boolean interactFirst(EntityPlayer p_130002_1_) {
     if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != p_130002_1_)
     {
       return true;
     }

     if (!this.worldObj.isRemote)
     {
       p_130002_1_.mountEntity(this);
     }

     return true;
   }

   protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
     int i = MathHelper.floor_double(this.posX);
     int j = MathHelper.floor_double(this.posY);
     int k = MathHelper.floor_double(this.posZ);

     if (p_70064_3_) {

       if (this.fallDistance > 3.0F)
       {
         fall(this.fallDistance);

         if (!this.worldObj.isRemote && !this.isDead) {

           setDead();
           func_145778_a(Main.redLion, 1, 0.0F);
         }

         this.fallDistance = 0.0F;
       }

     } else if (this.worldObj.getBlock(i, j - 1, k).getMaterial() != Material.water && p_70064_1_ < 0.0D) {

       this.fallDistance = (float)(this.fallDistance - p_70064_1_);
     }
   }

   public void setDamageTaken(float p_70266_1_) {
     this.dataWatcher.updateObject(19, Float.valueOf(p_70266_1_));
   }

   public float getDamageTaken() {
     return this.dataWatcher.getWatchableObjectFloat(19);
   }

   public void setTimeSinceHit(int p_70265_1_) {
     this.dataWatcher.updateObject(17, Integer.valueOf(p_70265_1_));
   }

   public int getTimeSinceHit() {
     return this.dataWatcher.getWatchableObjectInt(17);
   }

   public void setForwardDirection(int p_70269_1_) {
     this.dataWatcher.updateObject(18, Integer.valueOf(p_70269_1_));
   }

   public int getForwardDirection() {
     return this.dataWatcher.getWatchableObjectInt(18);
   }

   @SideOnly(Side.CLIENT)
   public void setIsBoatEmpty(boolean p_70270_1_) {
     this.isBoatEmpty = p_70270_1_;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityRedLion.class, "RedLion");
   }

   public static void createEntity(Class entityClass, String entityName) {
     int id = EntityRegistry.findGlobalUniqueEntityId();
     EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
     EntityRegistry.registerModEntity(entityClass, entityName, id, Main.instance, 64, 1, true);
   }
 }