 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.intelligence.IGanon;
 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import java.util.Random;
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
 import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAITempt;
 import net.minecraft.entity.ai.EntityAIWatchClosest;
 import net.minecraft.entity.boss.IBossDisplayData;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.DamageSource;
 import net.minecraft.world.World;

 public class EntityGannondorf extends EntityMob implements IBossDisplayData, IGanon {
   private int attackTimer;
   private EntityAITempt aiTempt;

   protected void fall(float p_70069_1_) {}

   public EntityGannondorf(World world) {
     super(world);
     setSize(1.0F, 2.0F);
     getNavigator().setAvoidsWater(true);
     this.tasks.addTask(0, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 3.0F));
     this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 32.0F));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
     this.tasks.addTask(4, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
     this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
     this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
   }

   protected void entityInit() {
     super.entityInit();
     this.dataWatcher.addObject(13, new Byte((byte)0));
   }

   protected String getLivingSound() {
     return "fandomcraft:gannonSay";
   }

   protected String getHurtSound() {
     return "fandomcraft:gannonHit";
   }

   protected String getDeathSound() {
    return "fandomcraft:Fanfare";
   }

   protected Item getDropItem() {
     return Item.getItemFromBlock(Main.gannonStatue);
   }

   protected void dropFewItems(int p_70628_2_) {
     entityDropItem(new ItemStack(Main.rupeeSilver, 2), 1.0F);
   }

   protected boolean canDespawn() {
     return false;
   }

   protected void collideWithEntity(Entity p_82167_1_) {
     if (p_82167_1_ instanceof net.minecraft.entity.monster.IMob && getRNG().nextInt(20) == 0)
     {
       setAttackTarget((EntityLivingBase)p_82167_1_);
     }

     super.collideWithEntity(p_82167_1_);
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     Random rand = new Random();
     int a = rand.nextInt(3);
     if (a == 1) {

       this.attackTimer = 10;
       this.worldObj.setEntityState((Entity)this, (byte)4);
       boolean bool = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (7 + this.rand.nextInt(15)));

       if (bool)
       {
         p_70652_1_.motionY += 0.01D;
       }
       playSound("fandomcraft:gannonAttack", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
       return bool;
     }

     this.attackTimer = 10;
     this.worldObj.setEntityState((Entity)this, (byte)4);
     boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (9 + this.rand.nextInt(20)));

     if (flag)
     {
       p_70652_1_.motionY += 0.01D;
     }
     playSound("fandomcraft:gannonAttack", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
     return flag;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityGannondorf.class, "Gannondorf", 69376, 11750400);
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

   @SideOnly(Side.CLIENT)
   public int getAttackTimer() {
     return this.attackTimer;
   }

   public boolean isAIenabled() {
     return true;
   }

   public ItemStack getHeldItem() {
     return new ItemStack(Main.gannonSword);
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();

     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4000.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);
     getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.01D);
   }
 }
