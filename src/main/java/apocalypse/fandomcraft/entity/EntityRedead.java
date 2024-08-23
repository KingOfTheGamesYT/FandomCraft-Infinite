 package apocalypse.fandomcraft.entity;
 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.block.Block;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.EnumCreatureAttribute;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAIBreakDoor;
 import net.minecraft.entity.ai.EntityAIHurtByTarget;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
 import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAISwimming;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.ai.EntityAIWatchClosest;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.passive.EntityVillager;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityRedead extends EntityMob {
   private final EntityAIBreakDoor field_146075_bs = new EntityAIBreakDoor((EntityLiving)this);

   private int conversionTime;

   private boolean field_146076_bu = false;

   private float field_146074_bv = -1.0F;

   private float field_146073_bw;
   private static final String __OBFID = "CL_00001702";

   public EntityRedead(World p_i1745_1_) {
     super(p_i1745_1_);
     getNavigator().setBreakDoors(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
     this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityPlayer.class, 1.0D, false));
     this.tasks.addTask(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityVillager.class, 1.0D, true));
     this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0D));
     this.tasks.addTask(6, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0D, false));
     this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
     this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
     this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityFriendlyChao.class, 0, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPinkChao.class, 0, true));
     setSize(1.0F, 2.5F);
   }

   public int getMaxSpawnedInChunk() {
     return 1;
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.18D);
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
     getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
   }

   protected void entityInit() {
     super.entityInit();
     getDataWatcher().addObject(12, Byte.valueOf((byte)0));
     getDataWatcher().addObject(13, Byte.valueOf((byte)0));
     getDataWatcher().addObject(14, Byte.valueOf((byte)0));
   }

   protected boolean isAIEnabled() {
     return true;
   }

   public void func_146070_a(boolean p_146070_1_) {
     if (this.field_146076_bu != p_146070_1_) {

       this.field_146076_bu = p_146070_1_;

       if (p_146070_1_) {

         this.tasks.addTask(1, (EntityAIBase)this.field_146075_bs);
       }
       else {

         this.tasks.removeTask((EntityAIBase)this.field_146075_bs);
       }
     }
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
     if (!super.attackEntityFrom(p_70097_1_, p_70097_2_))
     {
       return false;
     }

     EntityLivingBase entitylivingbase = getAttackTarget();

     if (entitylivingbase == null && getEntityToAttack() instanceof EntityLivingBase)
     {
       entitylivingbase = (EntityLivingBase)getEntityToAttack();
     }

     if (entitylivingbase == null && p_70097_1_.getEntity() instanceof EntityLivingBase)
     {
       entitylivingbase = (EntityLivingBase)p_70097_1_.getEntity();
     }

     int i = MathHelper.floor_double(this.posX);
     int j = MathHelper.floor_double(this.posY);
     int k = MathHelper.floor_double(this.posZ);

     return true;
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     boolean flag = super.attackEntityAsMob(p_70652_1_);

     if (flag) {

       int i = this.worldObj.difficultySetting.getDifficultyId();

       if (getHeldItem() == null && isBurning() && this.rand.nextFloat() < i * 0.3F)
       {
         p_70652_1_.setFire(2 * i);
       }
     }

     return flag;
   }

   protected String getLivingSound() {
     return "fandomcraft:Redead";
   }

   protected String getHurtSound() {
     return "fandomcraft:RedeadHit";
   }

   protected String getDeathSound() {
     return "fandomcraft:RedeadDie";
   }

   protected void playStepSound(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
     playSound("mob.zombie.step", 0.15F, 1.0F);
   }

   protected Item getDropItem() {
     return Items.rotten_flesh;
   }

   public EnumCreatureAttribute getCreatureAttribute() {
     return EnumCreatureAttribute.UNDEAD;
   }

   protected void dropRareDrop(int p_70600_1_) {
     switch (this.rand.nextInt(3)) {

       case 0:
         dropItem(Main.rupeePurple, 1);
         break;
       case 1:
         dropItem(Main.hellstoneIngot, 1);
         break;
       case 2:
         dropItem(Main.rupeeRed, 1);
         break;
     }
   }

   protected boolean canDespawn() {
     return true;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityRedead.class, "Redead", 5049600, 3820800);
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