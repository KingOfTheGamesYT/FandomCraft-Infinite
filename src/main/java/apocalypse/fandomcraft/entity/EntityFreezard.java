 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAILeapAtTarget;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.monster.IMob;
 import net.minecraft.item.Item;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.util.DamageSource;
 import net.minecraft.world.World;

 public class EntityFreezard extends EntityMob {
   private int slimeJumpDelay;

   public EntityFreezard(World p_i1742_1_) {
     super(p_i1742_1_);
     setSize(1.0F, 1.0F);
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3D));
     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(2, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
     this.tasks.addTask(4, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 1.0F));
     this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, false, true, IMob.mobSelector));
     this.isImmuneToFire = true;
     this.experienceValue = 3;
   }

   public int getMaxSpawnedInChunk() {
     return 1;
   }

   protected String getDeathSound() {
     return "fandomcraft:classicDeath";
   }

   protected String getHurtSound() {
     return "fandomcraft:fierceHit";
   }

   protected Entity findPlayerToAttack() {
     double d0 = 16.0D;
     return (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, d0);
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
     if (p_70628_1_) {
       int j = this.rand.nextInt(3 + p_70628_2_);
       for (int k = 0; k < j; k++)
       {
         dropItem(Main.rupeeGreen, 1);
       }
     }
   }

   protected void collideWithEntity(Entity p_82167_1_) {
     if (p_82167_1_ instanceof IMob && getRNG().nextInt(20) == 0)
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
       p_70652_1_.motionY += 0.1D;
     }

     ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 2));
     playSound("mob.slime.attack", 1.0F, 1.0F);
     return flag;
   }

   protected Item getDropItem() {
     return Main.rupeeGreen;
   }

   public boolean isAIenabled() {
     return true;
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();

     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(75.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityFreezard.class, "Freezard", 16514815, 14021887);
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