 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.block.material.Material;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
 import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.monster.IMob;
 import net.minecraft.entity.passive.EntityWaterMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityToado
   extends EntityWaterMob
 {
   public float squidPitch;
   public float prevSquidPitch;
   public float squidYaw;
   public float prevSquidYaw;
   public float squidRotation;
   public float prevSquidRotation;
   public float tentacleAngle;
   public float lastTentacleAngle;
   private float randomMotionSpeed;
   private float rotationVelocity;
   private float field_70871_bB;
   private float randomMotionVecX;
   private float randomMotionVecY;
   private float randomMotionVecZ;
   private static final String __OBFID = "CL_00001651";

   public EntityToado(World p_i1693_1_) {
     super(p_i1693_1_);
     setSize(0.7F, 2.0F);
     this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
     this.tasks.addTask(0, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, true));
     this.tasks.addTask(1, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
     this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, false, true, IMob.mobSelector));
     this.isImmuneToFire = true;
     this.experienceValue = 15;
   }

   protected Entity findPlayerToAttack() {
     double d0 = 16.0D;
     return (Entity)this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, d0);
   }

   protected String getLivingSound() {
     return "game.player.swim";
   }

   protected String getHurtSound() {
     return "game.player.swim";
   }

   protected String getDeathSound() {
     return "fandomcraft:classicDeath";
   }

   protected float getSoundVolume() {
     return 0.8F;
   }

   protected Item getDropItem() {
     return Main.rupeeBlue;
   }

   protected boolean canTriggerWalking() {
     return false;
   }

   protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
     int j = this.rand.nextInt(3 + p_70628_2_) + 1;

     for (int k = 0; k < j; k++)
     {
       entityDropItem(new ItemStack(Items.fish, 1, 3), 0.0F);
     }
   }

   public void onCollideWithPlayer(EntityPlayer p_70100_1_) {
     playSound("game.player.swim", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
   }

   public boolean isInWater() {
     return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, (Entity)this);
   }

   public void onLivingUpdate() {
     super.onLivingUpdate();
     this.prevSquidPitch = this.squidPitch;
     this.prevSquidYaw = this.squidYaw;
     this.prevSquidRotation = this.squidRotation;
     this.lastTentacleAngle = this.tentacleAngle;
     this.squidRotation += this.rotationVelocity;

     if (this.squidRotation > 6.2831855F) {

       this.squidRotation -= 6.2831855F;

       if (this.rand.nextInt(10) == 0)
       {
         this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
       }
     }

     if (isInWater()) {

       if (this.squidRotation < 3.1415927F) {

         float f1 = this.squidRotation / 3.1415927F;
         this.tentacleAngle = MathHelper.sin(f1 * f1 * 3.1415927F) * 3.1415927F * 0.25F;

         if (f1 > 0.75D)
         {
           this.randomMotionSpeed = 1.0F;
           this.field_70871_bB = 1.0F;
         }
         else
         {
           this.field_70871_bB *= 0.8F;
         }

       } else {

         this.tentacleAngle = 0.0F;
         this.randomMotionSpeed *= 0.9F;
         this.field_70871_bB *= 0.99F;
       }

       if (!this.worldObj.isRemote) {

         this.motionX = (this.randomMotionVecX * this.randomMotionSpeed);
         this.motionY = (this.randomMotionVecY * this.randomMotionSpeed);
         this.motionZ = (this.randomMotionVecZ * this.randomMotionSpeed);
       }

     float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
       this.renderYawOffset += (-((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / 3.1415927F - this.renderYawOffset) * 0.1F;
       this.rotationYaw = this.renderYawOffset;
       this.squidYaw += 3.1415927F * this.field_70871_bB * 1.5F;
       this.squidPitch += (-((float)Math.atan2(f, this.motionY)) * 180.0F / 3.1415927F - this.squidPitch) * 0.1F;
     }
     else {

       this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * 3.1415927F * 0.25F;

       if (!this.worldObj.isRemote) {

         this.motionX = 0.0D;
         this.motionY -= 0.08D;
         this.motionY *= 0.9800000190734863D;
         this.motionZ = 0.0D;
       }

       this.squidPitch = (float)(this.squidPitch + (-90.0F - this.squidPitch) * 0.02D);
     }
   }

   public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
     moveEntity(this.motionX, this.motionY, this.motionZ);
   }

   protected void updateEntityActionState() {
     this.entityAge++;

     if (this.entityAge > 100) {

       this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
     }
     else if (this.rand.nextInt(50) == 0 || !this.inWater || (this.randomMotionVecX == 0.0F && this.randomMotionVecY == 0.0F && this.randomMotionVecZ == 0.0F)) {

       float f = this.rand.nextFloat() * 3.1415927F * 2.0F;
       this.randomMotionVecX = MathHelper.cos(f) * 0.2F;
       this.randomMotionVecY = -0.1F + this.rand.nextFloat() * 0.2F;
       this.randomMotionVecZ = MathHelper.sin(f) * 0.2F;
     }

     despawnEntity();
   }

   public boolean getCanSpawnHere() {
     return (this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere());
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityToado.class, "Toado", 3552334, 9502754);
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

     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7D);
     getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
   }
 }