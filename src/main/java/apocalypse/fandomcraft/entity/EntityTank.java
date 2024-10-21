 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;

 import cpw.mods.fml.common.registry.EntityRegistry;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;

 import net.minecraft.command.IEntitySelector;
 import net.minecraft.entity.*;
 import net.minecraft.entity.ai.*;
 import net.minecraft.entity.boss.IBossDisplayData;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityTank extends EntityMob implements IBossDisplayData {
   private int attackTimer;

   private static final IEntitySelector attackEntitySelector = new IEntitySelector()
     {
       public boolean isEntityApplicable(Entity p_82704_1_)
       {
         return (p_82704_1_ instanceof EntityLivingBase && ((EntityLivingBase)p_82704_1_).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD);
       }
     };

   public EntityTank(World world) {
     super(world);
     this.setSize(1.0F, 2.0F);  // Set mob size
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3D));
     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
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

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     this.attackTimer = 10;
     this.worldObj.setEntityState((Entity)this, (byte)4);
     boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (7 + this.rand.nextInt(15)));

     if (flag)
     {
       p_70652_1_.motionY += 0.2D;
     }

     return flag;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityTank.class, "TANK", 16711680, 3080192);
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
     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(3000.0D);
     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
     this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
   }

   @Override
   public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityLivingData) {
     super.onSpawnWithEgg(entityLivingData);

     // Randomize Health
     int[] possibleHealthValues = {3000, 4000, 6000, 8000};
     int randomHealthIndex = MathHelper.getRandomIntegerInRange(this.rand, 0, possibleHealthValues.length - 1);
     int randomHealth = possibleHealthValues[randomHealthIndex];
     this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(randomHealth);
     this.setHealth(randomHealth);

     // Randomize Attack Damage
     double[] possibleDamageValues = {12.0D, 24.0D, 33.0D, 100.0D};
     int randomDamageIndex = MathHelper.getRandomIntegerInRange(this.rand, 0, possibleDamageValues.length - 1);
     double randomDamage = possibleDamageValues[randomDamageIndex];
     this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(randomDamage);

     return entityLivingData;
   }

 }