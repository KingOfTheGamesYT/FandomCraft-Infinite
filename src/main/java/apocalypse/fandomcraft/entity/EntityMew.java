 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.block.Block;
 import net.minecraft.entity.*;

 import net.minecraft.entity.ai.*;

 import net.minecraft.entity.passive.EntityAnimal;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.Item;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityMew extends EntityAnimal {
   private EntityAITempt aiTempt;
   private float heightOffset;
   private int heightOffsetUpdateTime;

   protected void entityInit() {
     super.entityInit();
     this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
   }

   public EntityMew(World p_i1688_1_) { super(p_i1688_1_);

     this.heightOffset = 0.5F; setSize(0.6F, 0.8F); getNavigator().setAvoidsWater(true); this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
     this.tasks.addTask(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 16.0F, 0.8D, 1.33D));
     this.tasks.addTask(3, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.3F));
     this.tasks.addTask(4, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8D));
     this.tasks.addTask(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
     this.tasks.addTask(6, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, Main.mysteryDust, true))); }
   protected boolean canDespawn() { return true; } public void onLivingUpdate() { if (!this.worldObj.isRemote) {

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

     super.onLivingUpdate(); }
    public boolean isAIEnabled() {
     return true;
   } protected void applyEntityAttributes() {
     super.applyEntityAttributes();
     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
   } protected String getHurtSound() {
     return "fandomcraft:mewRetro";
   }

   protected float getSoundVolume() {
     return 0.4F;
   }

   protected Item getDropItem() {
     return Main.mysteryDust;
   }

   public boolean getCanSpawnHere() {
     if (this.worldObj.rand.nextInt(3) == 0)
     {
       return false;
     }

     if (this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox)) {

       int i = MathHelper.floor_double(this.posX);
       int j = MathHelper.floor_double(this.boundingBox.minY);
       int k = MathHelper.floor_double(this.posZ);

       if (j < 63)
       {
         return false;
       }

       Block block = this.worldObj.getBlock(i, j - 1, k);

       if (block == Blocks.mycelium)
       {
         return true;
       }
     }

     return false;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityMew.class, "Mew", 16764158, 16737021);
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

   public EntityAgeable createChild(EntityAgeable entity) {
     EntityDitto ditto = new EntityDitto(this.worldObj);
     return entity;
   }
 }