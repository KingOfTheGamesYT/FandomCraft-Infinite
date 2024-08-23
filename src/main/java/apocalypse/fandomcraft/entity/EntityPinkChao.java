 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import java.util.UUID;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityAgeable;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAvoidEntity;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAIFollowOwner;
 import net.minecraft.entity.ai.EntityAIFollowParent;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAIMate;
 import net.minecraft.entity.ai.EntityAIPanic;
 import net.minecraft.entity.ai.EntityAISwimming;
 import net.minecraft.entity.ai.EntityAITempt;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.passive.EntityAnimal;
 import net.minecraft.entity.passive.EntityTameable;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;

 public class EntityPinkChao extends EntityTameable {
   public EntityPinkChao(World world) {
     super(world);
     setSize(1.0F, 5.0F);
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3D));
     this.tasks.addTask(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.7D));
     this.tasks.addTask(2, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(3, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
     this.tasks.addTask(4, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, Items.apple, true)));
     this.tasks.addTask(5, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 16.0F, 0.8D, 1.33D));
     this.tasks.addTask(6, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 0.8D));
     this.tasks.addTask(7, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.5D));
     this.tasks.addTask(8, (EntityAIBase)new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
     this.tasks.addTask(9, (EntityAIBase)this.aiSit);
   }

   public int getMaxSpawnedInChunk() {
     return 1;
   }
   private EntityAITempt aiTempt;

   protected String getHurtSound() {
     return "fandomcraft:hit";
   }

   protected String getLivingSound() {
     return "fandomcraft:giggle";
   }

   protected String getDeathSound() {
     return "fandomcraft:die";
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

   protected Item getDropItem() {
     return Main.ring;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityPinkChao.class, "PinkChao", 16777215, 16711927);
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
     EntityPinkChao chao = new EntityPinkChao(this.worldObj);

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
     if (!(p_70878_1_ instanceof EntityPinkChao))
     {
       return false;
     }

     EntityPinkChao chao = (EntityPinkChao)p_70878_1_;
     return !chao.isTamed() ? false : ((isInLove() && chao.isInLove()));
   }
 }