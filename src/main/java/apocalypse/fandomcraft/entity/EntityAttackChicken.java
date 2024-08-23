 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import java.util.List;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.util.DamageSource;
 import net.minecraft.world.World;

 public class EntityAttackChicken
   extends EntityMob
 {
   private int angerLevel;
   private int randomSoundDelay;
   private Entity field_110191_bu;
   private static final String __OBFID = "CL_00001693";

   public EntityAttackChicken(World p_i1739_1_) {
     super(p_i1739_1_);
     this.isImmuneToFire = true;
   }

   protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
   }

   protected boolean isAIEnabled() {
     return false;
   }

   public void onUpdate() {
     this.field_110191_bu = this.entityToAttack;

     if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0)
     {
       playSound("mob.chicken.hurt", getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
     }

     super.onUpdate();
   }

   public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
     super.writeEntityToNBT(p_70014_1_);
     p_70014_1_.setShort("Anger", (short)this.angerLevel);
   }

   public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
     super.readEntityFromNBT(p_70037_1_);
     this.angerLevel = p_70037_1_.getShort("Anger");
   }

   protected Entity findPlayerToAttack() {
     return (this.angerLevel == 0) ? null : super.findPlayerToAttack();
   }

   public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
     if (isEntityInvulnerable())
     {
       return false;
     }

     Entity entity = p_70097_1_.getEntity();

     if (entity instanceof EntityPlayer) {

       List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

       for (int i = 0; i < list.size(); i++) {

         Entity entity1 = list.get(i);

         if (entity1 instanceof EntityAttackChicken) {

           EntityAttackChicken entitypigzombie = (EntityAttackChicken)entity1;
           entitypigzombie.becomeAngryAt(entity);
         }
       }

       becomeAngryAt(entity);
     }

     return super.attackEntityFrom(p_70097_1_, p_70097_2_);
   }

   private void becomeAngryAt(Entity p_70835_1_) {
     this.entityToAttack = p_70835_1_;
     this.angerLevel = 400 + this.rand.nextInt(400);
     this.randomSoundDelay = this.rand.nextInt(40);
   }

   protected String getLivingSound() {
     return "fandomcraft:chickenSay";
   }

   protected String getHurtSound() {
     return "fandomcraft:chickenHurt";
   }

   protected String getDeathSound() {
     return "mob.chicken.hurt";
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
     int j = this.rand.nextInt(2 + p_70628_2_);

     int k;
     for (k = 0; k < j; k++)
     {
       dropItem(Items.feather, 1);
     }

     j = this.rand.nextInt(2 + p_70628_2_);

     for (k = 0; k < j; k++)
     {
       dropItem(Items.chicken, 1);
     }
   }

   public boolean interact(EntityPlayer p_70085_1_) {
     return false;
   }

   protected void dropRareDrop(int p_70600_1_) {
     dropItem(Main.goldenFeather, 1);
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityAttackChicken.class, "AttackChicken", 16711680, 16777215);
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