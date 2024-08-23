 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.block.Block;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAIHurtByTarget;
 import net.minecraft.entity.ai.EntityAILeapAtTarget;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAISwimming;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.ai.EntityAIWatchClosest;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
 import net.minecraft.world.World;

 public class EntityWolfos
   extends EntityMob
 {
   private float headRotationCourse;
   private float headRotationCourseOld;
   private boolean isShaking;
   private float timeWolfIsShaking;
   private float prevTimeWolfIsShaking;
   private static final String __OBFID = "CL_00001654";

   public EntityWolfos(World p_i1696_1_) {
     super(p_i1696_1_);
     setSize(1.5F, 1.8F);
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
     this.tasks.addTask(2, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 2.0F));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
     this.tasks.addTask(4, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
     this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
     this.tasks.addTask(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
   }

   public boolean isAIEnabled() {
     return true;
   }

   public void setAttackTarget(EntityLivingBase p_70624_1_) {
     super.setAttackTarget(p_70624_1_);
   }

   protected void playStepSound(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
     playSound("mob.wolf.step", 0.15F, 1.0F);
   }

   protected String getLivingSound() {
     return "mob.wolf.growl";
   }

   protected String getHurtSound() {
     return "mob.wolf.hurt";
   }

   protected String getDeathSound() {
     return "fandomcraft:classicDeath";
   }

   protected float getSoundVolume() {
     return 1.0F;
   }

   protected Item getDropItem() {
     return Main.rupeeBlue;
   }

   public void onUpdate() {
     super.onUpdate();
     this.headRotationCourseOld = this.headRotationCourse;
   }

   public float getEyeHeight() {
     return this.height * 0.8F;
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 20.0F);
   }

   @SideOnly(Side.CLIENT)
   public void handleHealthUpdate(byte p_70103_1_) {
     if (p_70103_1_ == 8) {

       this.isShaking = true;
       this.timeWolfIsShaking = 0.0F;
       this.prevTimeWolfIsShaking = 0.0F;
     }
     else {

       super.handleHealthUpdate(p_70103_1_);
     }
   }

   public int getMaxSpawnedInChunk() {
     return 8;
   }

   protected boolean canDespawn() {
     return true;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityWolfos.class, "Wolfos", 16514815, 14021887);
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