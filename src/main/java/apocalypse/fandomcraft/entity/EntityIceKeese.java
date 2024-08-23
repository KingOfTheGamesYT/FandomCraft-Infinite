 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import java.util.Calendar;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAIHurtByTarget;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.monster.IMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.util.ChunkCoordinates;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityIceKeese
   extends EntityMob
 {
   private ChunkCoordinates spawnPosition;

   public EntityIceKeese(World p_i1680_1_) {
     super(p_i1680_1_);
     setSize(1.0F, 1.5F);
     setIsBatHanging(true);
     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
     this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, false, true, IMob.mobSelector));
     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
     this.tasks.addTask(4, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
     this.tasks.addTask(5, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityPlayer.class, 1.0D, false));
   }

   protected void entityInit() {
     super.entityInit();
     this.dataWatcher.addObject(16, new Byte((byte)0));
   }

   protected Entity findPlayerToAttack() {
     double d0 = 16.0D;
     return (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, d0);
   }

   protected float getSoundVolume() {
     return 1.0F;
   }

   protected float getSoundPitch() {
     return super.getSoundPitch() * 0.95F;
   }

   protected String getLivingSound() {
     return (getIsBatHanging() && this.rand.nextInt(4) != 0) ? null : "mob.bat.idle";
   }

   protected String getHurtSound() {
     return "fandomcraft:keeseDeath";
   }

   protected String getDeathSound() {
     return "fandomcraft:classicDeath";
   }

   public boolean canBePushed() {
     return false;
   }

   protected void collideWithEntity(Entity p_82167_1_) {}

   protected void collideWithNearbyEntities() {}

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     if (super.attackEntityAsMob(p_70652_1_)) {

       if (p_70652_1_ instanceof EntityLivingBase) {

         byte b0 = 15;

         ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 2));
       }

       return true;
    }

     return false;
   }

   public boolean getIsBatHanging() {
     return ((this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0);
   }

   public void setIsBatHanging(boolean p_82236_1_) {
     byte b0 = this.dataWatcher.getWatchableObjectByte(16);

     if (p_82236_1_) {

       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 0x1)));
     }
     else {

       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
     }
   }

   protected boolean isAIEnabled() {
     return true;
   }

   public void onUpdate() {
     super.onUpdate();

     this.motionX = this.motionY = this.motionZ = 0.0D;
     this.posY = MathHelper.floor_double(this.posY) + 1.0D - this.height;

     this.motionY *= 0.6000000238418579D;
   }

   protected void updateAITasks() {
     super.updateAITasks();

     if (getIsBatHanging()) {

       if (!this.worldObj.getBlock(MathHelper.floor_double(this.posX), (int)this.posY + 1, MathHelper.floor_double(this.posZ)).isNormalCube()) {

         setIsBatHanging(false);
         this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
       }
       else {

         if (this.rand.nextInt(200) == 0)
         {
           this.rotationYawHead = this.rand.nextInt(360);
         }

         if (this.worldObj.getClosestPlayerToEntity((Entity)this, 4.0D) != null)
         {
           setIsBatHanging(false);
           this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1015, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
         }

       }
     } else {

       if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition.posX, this.spawnPosition.posY, this.spawnPosition.posZ) || this.spawnPosition.posY < 1))
       {
         this.spawnPosition = null;
       }

       if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 4.0F)
       {
         this.spawnPosition = new ChunkCoordinates((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
       }

       double d0 = this.spawnPosition.posX + 0.5D - this.posX;
       double d1 = this.spawnPosition.posY + 0.1D - this.posY;
       double d2 = this.spawnPosition.posZ + 0.5D - this.posZ;
       this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
       this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
       this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
       float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
       float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
       this.moveForward = 0.5F;
       this.rotationYaw += f1;

       if (this.rand.nextInt(100) == 0 && this.worldObj.getBlock(MathHelper.floor_double(this.posX), (int)this.posY + 1, MathHelper.floor_double(this.posZ)).isNormalCube())
       {
         setIsBatHanging(true);
       }
     }
   }

   protected boolean canTriggerWalking() {
     return false;
   }

   protected void fall(float p_70069_1_) {}

   protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {}

   public boolean doesEntityNotTriggerPressurePlate() {
     return true;
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
     if (isEntityInvulnerable())
     {
       return false;
     }

     if (!this.worldObj.isRemote && getIsBatHanging())
     {
       setIsBatHanging(false);
     }

     return super.attackEntityFrom(p_70097_1_, p_70097_2_);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
     super.readEntityFromNBT(p_70037_1_);
     this.dataWatcher.updateObject(16, Byte.valueOf(p_70037_1_.getByte("BatFlags")));
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
       super.writeEntityToNBT(p_70014_1_);
       p_70014_1_.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
   }

   public boolean getCanSpawnHere() {
     int i = MathHelper.floor_double(this.boundingBox.minY);

     if (i >= 63)
     {
       return false;
     }

     int j = MathHelper.floor_double(this.posX);
     int k = MathHelper.floor_double(this.posZ);
     int l = this.worldObj.getBlockLightValue(j, i, k);
     byte b0 = 4;
     Calendar calendar = this.worldObj.getCurrentDate();

     if ((calendar.get(2) + 1 != 10 || calendar.get(5) < 20) && (calendar.get(2) + 1 != 11 || calendar.get(5) > 3)) {

       if (this.rand.nextBoolean())
       {
         return false;
       }
     }
     else {

       b0 = 7;
     }

     return (l > this.rand.nextInt(b0)) ? false : super.getCanSpawnHere();
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityIceKeese.class, "IceKeese", 16734720, 16763904);
   }

   public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour) {
     int id = EntityRegistry.findGlobalUniqueEntityId();
     EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
     EntityRegistry.registerModEntity(entityClass, entityName, id, Main.instance, 64, 1, true);
     createEgg(id, solidColour, spotColour);
   }

   private static void createEgg(int id, int solidColour, int spotColour) {
     EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, solidColour, spotColour));
   }
 }