 package apocalypse.fandomcraft.entity;
 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.command.IEntitySelector;
 import net.minecraft.enchantment.Enchantment;
 import net.minecraft.enchantment.EnchantmentHelper;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.EnumCreatureAttribute;
 import net.minecraft.entity.IRangedAttackMob;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.*;
 import net.minecraft.entity.boss.IBossDisplayData;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.monster.IMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.projectile.EntityLargeFireball;
 import net.minecraft.item.Item;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.util.DamageSource;
 import net.minecraft.world.World;

 public class EntityIfrit extends EntityMob implements IBossDisplayData, IRangedAttackMob {
   private int attackTimer;
   private EntityAITempt aiTempt;

   protected void fall(float p_70069_1_) {}

   private static final IEntitySelector attackEntitySelector = new IEntitySelector()
     {
       public boolean isEntityApplicable(Entity p_82704_1_)
       {
         return (p_82704_1_ instanceof EntityLivingBase && ((EntityLivingBase)p_82704_1_).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD);
       }
     };
   private Entity targetedEntity;
   private int explosionStrength;
   private int aggroCooldown; @SideOnly(Side.CLIENT)
   public int getBrightnessForRender(float p_70070_1_) { return 15728880; } public float getBrightness(float p_70013_1_) { return 1.0F; } public float getEyeHeight() { return this.height * 0.8F; } protected String getHurtSound() { return "fandomcraft:bossHurt"; } public EntityIfrit(World world) { super(world);

     this.explosionStrength = 1; setSize(1.0F, 2.5F); getNavigator().setAvoidsWater(true); this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3D)); this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this)); this.tasks.addTask(2, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, Main.ring, true))); this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 2.0D, true)); this.tasks.addTask(4, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F)); this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, false, true, IMob.mobSelector));
     this.isImmuneToFire = true;
     this.experienceValue = 500; }
   protected String getDeathSound() { return "fandomcraft:ffVictory"; }
   protected Item getDropItem() { return Main.magmaStone; }
   @SideOnly(Side.CLIENT) public int getAttackTimer() { return this.attackTimer; }
   public int getTotalArmorValue() { return 4; } public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) { if (this.targetedEntity != null && this.targetedEntity.isDead)
     {
       this.targetedEntity = null;
     }

     if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {

       this.targetedEntity = (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 100.0D);

       if (this.targetedEntity != null)
       {
         this.aggroCooldown = 20;
       }
     }
     double d4 = 64.0D;

     if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity((Entity)this) < d4 * d4)
     {
       if (canEntityBeSeen(this.targetedEntity))

       { double d5 = this.targetedEntity.posX - this.posX;
         double d6 = this.targetedEntity.boundingBox.minY + (this.targetedEntity.height / 2.0F) - this.posY + (this.height / 2.0F);
         double d7 = this.targetedEntity.posZ - this.posZ;

         EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, (EntityLivingBase)this, d5, d6, d7);
         int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, getHeldItem());
         int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, getHeldItem());
         entitylargefireball.field_92057_e = this.explosionStrength;
         entitylargefireball.worldObj.spawnParticle("bubble", this.posX - this.motionX * 0.35D, this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX, this.motionY, this.motionZ);

         playSound("random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));

         this.worldObj.spawnEntityInWorld((Entity)entitylargefireball); }  }  } public boolean isArmored() { return (getHealth() <= getMaxHealth() / 2.0F); }
   protected void collideWithEntity(Entity p_82167_1_) { if (p_82167_1_ instanceof IMob && getRNG().nextInt(20) == 0)
       setAttackTarget((EntityLivingBase)p_82167_1_);  super.collideWithEntity(p_82167_1_); }
   public boolean attackEntityAsMob(Entity p_70652_1_) { this.attackTimer = 10; this.worldObj.setEntityState((Entity)this, (byte)4); boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (7 + this.rand.nextInt(15))); if (flag)
       p_70652_1_.motionY += 0.4000000059604645D;  playSound("fandomcraft:gannonHit1", 1.0F, 1.0F); return flag; }
   public static void mainRegistry() { registerEntity(); }
   public void writeEntityToNBT(NBTTagCompound p_70014_1_) { super.writeEntityToNBT(p_70014_1_);
     p_70014_1_.setInteger("ExplosionPower", this.explosionStrength); } private static void registerEntity() { createEntity(EntityIfrit.class, "Ifrit", 6838581, 14899968); }
   public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour) { int id = EntityRegistry.findGlobalUniqueEntityId(); EntityRegistry.registerGlobalEntityID(entityClass, entityName, id); EntityRegistry.registerModEntity(entityClass, entityName, id, Main.instance, 64, 1, true); createEgg(id, solidColour, spotColour); }
   private static void createEgg(int id, int solidColour, int spotColour) { EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, solidColour, spotColour)); }
   public boolean isAIenabled() { return true; }
   protected void applyEntityAttributes() { super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(800.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7D);
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D); }
   public void readEntityFromNBT(NBTTagCompound p_70037_1_) { super.readEntityFromNBT(p_70037_1_);

     if (p_70037_1_.hasKey("ExplosionPower", 99))
     {
       this.explosionStrength = p_70037_1_.getInteger("ExplosionPower");
     } }

 }