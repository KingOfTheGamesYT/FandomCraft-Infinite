 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.block.Block;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAIControlledByPlayer;
 import net.minecraft.entity.ai.EntityAIHurtByTarget;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAISwimming;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.ai.EntityAIWatchClosest;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.passive.EntityChicken;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.stats.AchievementList;
 import net.minecraft.stats.StatBase;
 import net.minecraft.world.World;

 public class EntityBulbo
   extends EntityMob {
   public EntityBulbo(World p_i1689_1_) {
     super(p_i1689_1_);
     setSize(1.5F, 1.5F);
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
     this.tasks.addTask(1, (EntityAIBase)(this.aiControlledByPlayer = new EntityAIControlledByPlayer((EntityLiving)this, 0.3F)));
     this.tasks.addTask(2, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
     this.tasks.addTask(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityChicken.class, 0, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityAttackChicken.class, 0, true));
   }

   private final EntityAIControlledByPlayer aiControlledByPlayer;
   private static final String __OBFID = "CL_00001647";

   public boolean isAIEnabled() {
     return true;
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
   }

   protected void updateAITasks() {
     super.updateAITasks();
   }

   public boolean canBeSteered() {
     ItemStack itemstack = ((EntityPlayer)this.riddenByEntity).getHeldItem();
     return (itemstack != null && itemstack.getItem() == Items.carrot_on_a_stick);
   }

   protected void entityInit() {
     super.entityInit();
     this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
     super.writeEntityToNBT(p_70014_1_);
     p_70014_1_.setBoolean("Saddle", getSaddled());
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
     super.readEntityFromNBT(p_70037_1_);
     setSaddled(p_70037_1_.getBoolean("Saddle"));
   }

   protected String getLivingSound() {
     return "mob.pig.death";
   }

   protected String getHurtSound() {
     return "mob.pig.death";
   }

   protected String getDeathSound() {
     return "mob.pig.death";
   }

   protected void playStepSound(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
     playSound("mob.pig.say", 0.15F, 1.0F);
   }

   public boolean interact(EntityPlayer p_70085_1_) {
     if (super.interact(p_70085_1_))
     {
       return true;
     }
     if (getSaddled() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == p_70085_1_)) {

       p_70085_1_.mountEntity((Entity)this);
       return true;
     }

     return false;
   }

   protected Item getDropItem() {
     return isBurning() ? Items.cooked_porkchop : Items.porkchop;
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
     int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);

     for (int k = 0; k < j; k++) {

       if (isBurning()) {

         dropItem(Items.cooked_porkchop, 1);
       }
       else {

         dropItem(Main.rupeeBlue, 1);
       }
     }

     if (getSaddled())
     {
       dropItem(Items.saddle, 1);
     }
   }

   public boolean getSaddled() {
     return ((this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0);
   }

   public void setSaddled(boolean p_70900_1_) {
     if (p_70900_1_) {

       this.dataWatcher.updateObject(16, Byte.valueOf((byte)1));
     }
     else {

       this.dataWatcher.updateObject(16, Byte.valueOf((byte)0));
     }
   }

   protected void fall(float p_70069_1_) {
     super.fall(p_70069_1_);

     if (p_70069_1_ > 5.0F && this.riddenByEntity instanceof EntityPlayer)
     {
       ((EntityPlayer)this.riddenByEntity).triggerAchievement((StatBase)AchievementList.flyPig);
     }
   }

   public EntityAIControlledByPlayer getAIControlledByPlayer() {
     return this.aiControlledByPlayer;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityBulbo.class, "Bulbo", 565760, 16711680);
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