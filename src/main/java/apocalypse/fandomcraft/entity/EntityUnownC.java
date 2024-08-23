 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.item.Item;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.EnumDifficulty;
 import net.minecraft.world.World;

 public class EntityUnownC
   extends EntityMob
 {
   private float heightOffset = 0.5F;

   private int heightOffsetUpdateTime;

   private int field_70846_g;
   private static final String __OBFID = "CL_00001682";

   public EntityUnownC(World p_i1731_1_) {
     super(p_i1731_1_);
     this.experienceValue = 5;
   }

   public int getMaxSpawnedInChunk() {
     return 1;
   }

   protected Entity findPlayerToAttack() {
     return (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 16.0D);
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
   }

   protected void entityInit() {
     super.entityInit();
     this.dataWatcher.addObject(16, new Byte((byte)0));
   }

   protected String getDeathSound() {
     return "fandomcraft:Darkness";
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

     if (this.rand.nextInt(24) == 0)
     {
       this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fandomcraft:DarknessShot", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
     }

     if (!this.onGround && this.motionY < 0.0D)
     {
       this.motionY *= 0.6D;
     }

     super.onLivingUpdate();
   }

   protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
     float f1 = getBrightness(1.0F);

     if (f1 > 0.5F && this.rand.nextInt(100) == 0) {

       this.entityToAttack = null;

     }
     else if (p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.rand.nextInt(10) == 0) {

       if (this.onGround)
       {
         double d0 = p_70785_1_.posX - this.posX;
         double d1 = p_70785_1_.posZ - this.posZ;
         float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
         this.motionX = d0 / f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
         this.motionZ = d1 / f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
         this.motionY = 0.4000000059604645D;
       }

     } else {

       super.attackEntity(p_70785_1_, p_70785_2_);
     }
   }

   public boolean attackEntityAsMob(Entity p_70652_1_) {
     if (super.attackEntityAsMob(p_70652_1_)) {

       if (p_70652_1_ instanceof EntityLivingBase) {

         byte b0 = 0;

         if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
         {
           b0 = 15;
         }

         if (b0 > 0)
         {
           ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, b0 * 20, 0));
         }
       }

       return true;
     }

     return false;
   }

   protected void fall(float p_70069_1_) {}

   protected Item getDropItem() {
     return Main.mysteryDust;
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
     if (p_70628_1_) {

       int j = this.rand.nextInt(2 + p_70628_2_);

       for (int k = 0; k < j; k++)
       {
         dropItem(Main.rupeeGreen, 1);
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
     createEntity(EntityUnownC.class, "UnownC", 551, 16777215);
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