 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.command.IEntitySelector;
 import net.minecraft.entity.*;
 import net.minecraft.entity.ai.*;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntitySpitter extends EntityMob {
   private int attackTimer;

   private static final IEntitySelector attackEntitySelector = new IEntitySelector()
     {
       public boolean isEntityApplicable(Entity p_82704_1_)
       {
         return (p_82704_1_ instanceof EntityLivingBase && ((EntityLivingBase)p_82704_1_).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD);
       }
     };

   public EntitySpitter(World world) {
     super(world);
     this.setSize(1.0F, 2.0F);  // Set mob size
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.15D));
     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.15D, 32.0F));
     this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLiving.class, 1.0D, false));
     this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, true));
     this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
     this.isImmuneToFire = true;
     this.experienceValue = 80;
   }
   protected void fall(float p_70069_1_) {}

   protected String getHurtSound() {
     return "mob.zombie.hurt";
   }

   protected String getDeathSound() {
     return "mob.zombie.death";
   }

   protected Item getDropItem() {
     return Main.rupeeYellow;
   }

   protected void dropRareDrop(int p_70600_1_) {
         dropItem(Main.rupeeRed, 1);
   }

   @SideOnly(Side.CLIENT)
   public int getAttackTimer() {
     return this.attackTimer;
   }

   public int getTotalArmorValue() {
     return 0;
   }

   public boolean attackEntityAsMob(Entity target) {
     this.attackTimer = 10;
     this.worldObj.setEntityState(this, (byte) 4);

     // Get the randomized attack damage from SharedMonsterAttributes
     double attackDamage = this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

     // Deal the damage using the randomized attack damage
     boolean flag = target.attackEntityFrom(DamageSource.causeMobDamage(this), (float) attackDamage);

     if (flag) {
       target.motionY += 0.2D;  // Knockback effect
     }

     return flag;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntitySpitter.class, "SPITTER", 15685702, 14548205);
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

     // Set base health and attack damage (will be randomized later)
     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100);
     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
   }

   @Override
   public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityLivingData) {
     super.onSpawnWithEgg(entityLivingData);

     // Randomize Attack Damage
     double[] possibleDamageValues = {10.0D, 15.0D, 20.0D};
     int randomDamageIndex = MathHelper.getRandomIntegerInRange(this.rand, 0, possibleDamageValues.length - 1);
     double randomDamage = possibleDamageValues[randomDamageIndex];
     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(randomDamage);

     return entityLivingData;
   }

 }