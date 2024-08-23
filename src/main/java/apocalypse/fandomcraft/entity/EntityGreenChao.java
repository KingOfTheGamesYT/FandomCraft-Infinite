 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityAgeable;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAIPanic;
 import net.minecraft.entity.ai.EntityAITempt;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.passive.EntityAnimal;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
 import net.minecraft.world.World;

 public class EntityGreenChao
   extends EntityAnimal {
   public EntityGreenChao(World world) {
     super(world);
     setSize(1.0F, 5.0F);
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3D));
     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(2, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, Main.Blueberry, true)));
     this.tasks.addTask(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 2.0D));
     this.experienceValue = 2;
   }
   private EntityAITempt aiTempt;

   public int getMaxSpawnedInChunk() {
     return 1;
   }

   protected String getHurtSound() {
     return "fandomcraft:hit";
   }

   protected String getLivingSound() {
     return "fandomcraft:giggle3";
   }

   protected String getDeathSound() {
     return "fandomcraft:die2";
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

   protected void collideWithEntity(Entity p_82167_1_) {
     if (p_82167_1_ instanceof net.minecraft.entity.monster.IMob && getRNG().nextInt(20) == 0)
     {
       setAttackTarget((EntityLivingBase)p_82167_1_);
     }

     super.collideWithEntity(p_82167_1_);
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     this.worldObj.setEntityState((Entity)this, (byte)4);
     boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (7 + this.rand.nextInt(15)));

     if (flag)
     {
       p_70652_1_.motionY += 0.4000000059604645D;
     }

     playSound("fandomcraft:attack2", 1.0F, 1.0F);
     return flag;
   }

   protected Item getDropItem() {
     return Main.ring;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityGreenChao.class, "GreenChao", 10420149, 56954);
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
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
   }

   public EntityAgeable createChild(EntityAgeable p_90011_1_) {
     return null;
   }
 }