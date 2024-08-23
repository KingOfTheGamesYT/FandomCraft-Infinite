 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import java.util.Random;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.item.Item;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;

 public class EntityMetroid
   extends EntityMob
 {
   private float heightOffset = 0.5F;

   private int heightOffsetUpdateTime;

   private int field_70846_g;

   public EntityMetroid(World p_i1731_1_) {
     super(p_i1731_1_);
     this.experienceValue = 5;
     setSize(1.0F, 2.0F);
   }

   public int getMaxSpawnedInChunk() {
     return 1;
   }

   protected Entity findPlayerToAttack() {
     return (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 16.0D);
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
   }

   protected void entityInit() {
     super.entityInit();
     this.dataWatcher.addObject(16, new Byte((byte)0));
   }

   protected String getHurtSound() {
     return "fandomcraft:metroid";
   }

   protected String getDeathSound() {
     return "fandomcraft:classicDeath";
   }

   public void onLivingUpdate() {
     if (!this.worldObj.isRemote) {

       this.heightOffsetUpdateTime--;

       if (this.heightOffsetUpdateTime <= 0) {

         this.heightOffsetUpdateTime = 100;
         this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
       }

       if (getEntityToAttack() != null && (getEntityToAttack()).posY + getEntityToAttack().getEyeHeight() > this.posY + getEyeHeight() + this.heightOffset)
       {
         this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
       }
     }

     if (!this.onGround && this.motionY < 0.0D)
     {
       this.motionY *= 0.6D;
     }

     super.onLivingUpdate();
   }

   protected void collideWithEntity(Entity p_82167_1_) {
     if (p_82167_1_ instanceof net.minecraft.entity.monster.IMob && getRNG().nextInt(20) == 0)
     {
       setAttackTarget((EntityLivingBase)p_82167_1_);
     }

     super.collideWithEntity(p_82167_1_);
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     if (super.attackEntityAsMob(p_70652_1_)) {

       if (p_70652_1_ instanceof EntityLivingBase) {

         playSound("fandomcraft:metroid", 1.0F, 1.0F);
         ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, 5, 0));
         addPotionEffect(new PotionEffect(Potion.heal.id, 2, 5));
       }

       return true;
     }

     return false;
   }

   protected void fall(float p_70069_1_) {}

   protected Item getDropItem() {
     Random r = new Random();
     int i = r.nextInt(100);
     if (i == 13)
     {
       return Main.pulseRifle;
     }

     return Main.energyTank;
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
     if (p_70628_1_) {

       int j = this.rand.nextInt(2 + p_70628_2_);

       for (int k = 0; k < j; k++)
       {
         dropItem(Main.worm, 1);
       }
     }
   }

   public boolean func_70845_n() {
     return ((this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0);
   }

   public void func_70844_e(boolean p_70844_1_) {
     byte b0 = this.dataWatcher.getWatchableObjectByte(16);

     if (p_70844_1_) {

       b0 = (byte)(b0 | 0x1);
     }
     else {

       b0 = (byte)(b0 & 0xFFFFFFFE);
     }

     this.dataWatcher.updateObject(16, Byte.valueOf(b0));
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityMetroid.class, "Metroid", 7667690, 8912896);
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