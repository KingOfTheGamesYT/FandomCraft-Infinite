 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import java.util.UUID;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityAgeable;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
 import net.minecraft.entity.ai.EntityAIAvoidEntity;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAIFollowOwner;
 import net.minecraft.entity.ai.EntityAIFollowParent;
 import net.minecraft.entity.ai.EntityAIHurtByTarget;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAIMate;
 import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
 import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
 import net.minecraft.entity.ai.EntityAIPanic;
 import net.minecraft.entity.ai.EntityAISwimming;
 import net.minecraft.entity.ai.EntityAITargetNonTamed;
 import net.minecraft.entity.ai.EntityAITempt;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.ai.EntityAIWatchClosest;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.monster.IMob;
 import net.minecraft.entity.passive.EntityAnimal;
 import net.minecraft.entity.passive.EntitySheep;
 import net.minecraft.entity.passive.EntityTameable;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityFriendlyChao
   extends EntityTameable {
   private int attackTimer;
   private EntityAITempt aiTempt;
   private float headRotationCourse;
   private float headRotationCourseOld;
   private boolean isShaking;
   private float timeChaoIsShaking;
   private float prevTimeChaoIsShaking;

  public EntityFriendlyChao(World world) {
     super(world);
     setSize(1.0F, 5.0F);
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3D));
     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.7D));
     this.tasks.addTask(2, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(3, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
     this.tasks.addTask(4, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, Items.apple, true)));
     this.tasks.addTask(5, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityMob.class, 16.0F, 0.8D, 1.33D));
     this.tasks.addTask(6, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 0.8D));
     this.tasks.addTask(7, (EntityAIBase)this.aiSit);
     this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 16.0F));
     this.tasks.addTask(9, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
     this.tasks.addTask(10, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
     this.tasks.addTask(11, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.5D));
     this.tasks.addTask(12, (EntityAIBase)new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
     this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, false, true, IMob.mobSelector));
     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIOwnerHurtByTarget(this));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAIOwnerHurtTarget(this));
     this.targetTasks.addTask(3, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
     this.targetTasks.addTask(4, (EntityAIBase)new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));
     setTamed(false);
   }

   public int getMaxSpawnedInChunk() {
     return 1;
   }

   public void onLivingUpdate() {
     super.onLivingUpdate();

     if (!this.worldObj.isRemote && this.isShaking && !this.isShaking && !hasPath() && this.onGround) {

       this.isShaking = true;
       this.timeChaoIsShaking = 0.0F;
       this.prevTimeChaoIsShaking = 0.0F;
       this.worldObj.setEntityState((Entity)this, (byte)8);
     }
   }

   public void onUpdate() {
     super.onUpdate();
     this.headRotationCourseOld = this.headRotationCourse;

     if (isWet()) {

       this.isShaking = true;
       this.isShaking = false;
       this.timeChaoIsShaking = 0.0F;
       this.prevTimeChaoIsShaking = 0.0F;
     }
     else if ((this.isShaking || this.isShaking) && this.isShaking) {

       if (this.timeChaoIsShaking == 0.0F)
       {
         playSound("mob.Chao.shake", getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
       }

       this.prevTimeChaoIsShaking = this.timeChaoIsShaking;
       this.timeChaoIsShaking += 0.05F;

       if (this.prevTimeChaoIsShaking >= 2.0F) {
         this.isShaking = false;
         this.prevTimeChaoIsShaking = 0.0F;
         this.timeChaoIsShaking = 0.0F;
       }

       if (this.timeChaoIsShaking > 0.4F) {
         float f = (float)this.boundingBox.minY;
         int i = (int)(MathHelper.sin((this.timeChaoIsShaking - 0.4F) * 3.1415927F) * 7.0F);
         for (int j = 0; j < i; j++) {

           float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
           float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
           this.worldObj.spawnParticle("splash", this.posX + f1, (f + 0.8F), this.posZ + f2, this.motionX, this.motionY, this.motionZ);
         }
       }
     }
   }

   @SideOnly(Side.CLIENT)
   public boolean getChaoShaking() {
     return this.isShaking;
   }

   @SideOnly(Side.CLIENT)
   public float getShadingWhileShaking(float p_70915_1_) {
     return 0.75F + (this.prevTimeChaoIsShaking + (this.timeChaoIsShaking - this.prevTimeChaoIsShaking) * p_70915_1_) / 2.0F * 0.25F;
   }

   @SideOnly(Side.CLIENT)
   public float getShakeAngle(float p_70923_1_, float p_70923_2_) {
     float f2 = (this.prevTimeChaoIsShaking + (this.timeChaoIsShaking - this.prevTimeChaoIsShaking) * p_70923_1_ + p_70923_2_) / 1.8F;

     if (f2 < 0.0F) {
         f2 = 0.0F;
     }
     else if (f2 > 1.0F) {
       f2 = 1.0F;
     }

     return MathHelper.sin(f2 * 3.1415927F) * MathHelper.sin(f2 * 3.1415927F * 11.0F) * 0.15F * 3.1415927F;
   }

   protected String getHurtSound() {
     return "fandomcraft:hit";
   }

   protected String getLivingSound() {
     return "fandomcraft:giggle";
   }

   protected String getDeathSound() {
     return "fandomcraft:die";
   }

   protected boolean canDespawn() {
     return (!isTamed() && this.ticksExisted > 2400);
   }

   protected void collideWithEntity(Entity p_82167_1_) {
     if (p_82167_1_ instanceof IMob && getRNG().nextInt(20) == 0)
     {
       setAttackTarget((EntityLivingBase)p_82167_1_);
     }

     super.collideWithEntity(p_82167_1_);
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     this.attackTimer = 10;
     this.worldObj.setEntityState((Entity)this, (byte)4);
     boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (7 + this.rand.nextInt(15)));

     if (flag)
     {
       p_70652_1_.motionY += 0.4000000059604645D;
     }

     playSound("fandomcraft:attack2", 1.0F, 1.0F);
     return flag;
   }

   public boolean isTamed() {
     return ((this.dataWatcher.getWatchableObjectByte(16) & 0x4) != 0);
   }

   public void setTamed(boolean p_70903_1_) {
     byte b0 = this.dataWatcher.getWatchableObjectByte(16);

     if (p_70903_1_) {
       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 0x4)));
     }
     else {
       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFB)));
     }
   }

   public boolean isSitting() {
     return ((this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0);
   }

   public void setSitting(boolean p_70904_1_) {
     byte b0 = this.dataWatcher.getWatchableObjectByte(16);

     if (p_70904_1_) {
       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 0x1)));
     }
     else {
       this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
     }
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
     if (p_70628_1_) {
       int j = this.rand.nextInt(2 + p_70628_2_);
       for (int k = 0; k < j; k++)
       {
         dropItem(Main.ring, 1);
       }
     }
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityFriendlyChao.class, "FriendlyChao", 10157565, 16772608);
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

   public boolean isAIenabled() {
     return true;
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();

     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
   }

   public boolean func_152114_e(EntityLivingBase p_152114_1_) {
     return (p_152114_1_ == getOwner());
   }

   public String func_152113_b() {
     return this.dataWatcher.getWatchableObjectString(17);
   }

   public EntityLivingBase getOwner() {
     try {
       UUID uuid = UUID.fromString(func_152113_b());
       return (uuid == null) ? null : (EntityLivingBase)this.worldObj.func_152378_a(uuid);
     }
     catch (IllegalArgumentException illegalargumentexception) {

       return null;
     }
   }

   public boolean interact(EntityPlayer p_70085_1_) {
     ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

     if (isTamed()) {

       if (func_152114_e((EntityLivingBase)p_70085_1_) && !this.worldObj.isRemote && !isBreedingItem(itemstack))
       {
         this.aiSit.setSitting(!isSitting());
       }
     }
     else if (this.aiTempt.isRunning() && itemstack != null && itemstack.getItem() == Main.Blueberry && p_70085_1_.getDistanceSqToEntity((Entity)this) < 9.0D) {

       if (!p_70085_1_.capabilities.isCreativeMode)
       {
         itemstack.stackSize--;
       }
       if (itemstack.stackSize <= 0)
       {
         p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
       }

       if (!this.worldObj.isRemote)
       {
         if (this.rand.nextInt(3) == 0) {
           setTamed(true);
           func_152115_b(p_70085_1_.getUniqueID().toString());
           playTameEffect(true);
           this.aiSit.setSitting(true);
           this.worldObj.setEntityState((Entity)this, (byte)7);
         }
         else {
           playTameEffect(false);
           this.worldObj.setEntityState((Entity)this, (byte)6);
         }
       }
       return true;
     }
     return super.interact(p_70085_1_);
   }

   public EntityAgeable createChild(EntityAgeable ageable) {
     EntityFriendlyChao chao = new EntityFriendlyChao(this.worldObj);

     if (isTamed()) {

       chao.func_152115_b(func_152113_b());
       chao.setTamed(true);
     }

     return (EntityAgeable)chao;
   }

   public boolean isBreedingItem(ItemStack p_70877_1_) {
     return (p_70877_1_ != null && p_70877_1_.getItem() == Main.Blueberry);
   }

   public boolean canMateWith(EntityAnimal p_70878_1_) {
     if (p_70878_1_ == this)
     {
       return false;
     }
     if (!isTamed())
     {
       return false;
     }
     if (!(p_70878_1_ instanceof EntityFriendlyChao))
     {
       return false;
     }

     EntityFriendlyChao chao = (EntityFriendlyChao)p_70878_1_;
     return !chao.isTamed() ? false : ((isInLove() && chao.isInLove()));
   }
 }
