 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import java.util.Random;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.IRangedAttackMob;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIArrowAttack;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAISwimming;
 import net.minecraft.entity.ai.EntityAIWander;
 import net.minecraft.entity.ai.EntityAIWatchClosest;
 import net.minecraft.entity.boss.IBossDisplayData;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.projectile.EntitySmallFireball;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityGohma
   extends EntityMob implements IBossDisplayData, IRangedAttackMob {
   public EntityGohma(World par1World) {
     super(par1World);
     setSize(3.0F, 8.0F);
     this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
     this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, EntityPlayer.class, 0.5D, false));
     this.tasks.addTask(2, (EntityAIBase)new EntityAIArrowAttack(this, 0.0D, 2, 2, 40.0F));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
     this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 40.0F));
     this.tasks.addTask(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
     this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
     this.experienceValue = 500;
   }
   private Entity targetedEntity;
   public float getEyeHeight() {
     return this.height * 0.8F;
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
     getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
   }

   protected String getHurtSound() {
     return "fandomcraft:bossHurt";
   }

   protected String getDeathSound() {
     return "fandomcraft:Fanfare";
   }

   protected String getLivingSound() {
     return "fandomcraft:bossSay";
   }

   protected Item getDropItem() {
     Random r = new Random();
     int i = r.nextInt(3);
     if (i == 1)
     {
       return Main.insignia;
     }
     return Main.rupeeSilver;
   }

   public boolean isAIEnabled() {
     return true;
   }

   public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
     if (this.targetedEntity != null && this.targetedEntity.isDead)
     {
       this.targetedEntity = null;
     }

     if (this.targetedEntity == null)
     {
       this.targetedEntity = (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 100.0D);
     }

     float f1 = MathHelper.sqrt_float(p_82196_2_) * 0.5F;
     double d0 = p_82196_1_.posX - this.posX;
     double d1 = p_82196_1_.boundingBox.minY + 5.0D + (p_82196_1_.height / 2.0F) - this.posY + (this.height / 2.0F);
     double d2 = p_82196_1_.posZ - this.posZ;
     EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, (EntityLivingBase)this, d0 + this.rand.nextGaussian() * f1, d1, d2 + this.rand.nextGaussian() * f1);
     entitysmallfireball.worldObj.spawnParticle("lava", this.posX - this.motionX * 0.35D, this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX, this.motionY, this.motionZ);

     playSound("random.fizz", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
     this.worldObj.spawnEntityInWorld((Entity)entitysmallfireball);
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

       this.worldObj.setEntityState((Entity)this, (byte)4);
       boolean bool = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (15 + this.rand.nextInt(15)));

       if (bool)
       {
         p_70652_1_.motionY += 0.01D;
       }

       playSound("fandomcraft:fierceHit", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
       return bool;
     }

     this.worldObj.setEntityState((Entity)this, (byte)4);
     boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (20 + this.rand.nextInt(20)));

     if (flag)
     {
       p_70652_1_.motionY += 0.01D;
     }

     playSound("fandomcraft:fierceHit", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
     return flag;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityGohma.class, "Gohma", 4598809, 12669440);
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
