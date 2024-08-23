 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.monster.IMob;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
 import net.minecraft.util.MathHelper;
 import net.minecraft.world.World;

 public class EntityDitto
   extends EntityLiving implements IMob {
   public float squishAmount;
   public float squishFactor;
   public float prevSquishFactor;
   private int slimeJumpDelay;

   public EntityDitto(World p_i1742_1_) {
     super(p_i1742_1_);
     int i = 1 << this.rand.nextInt(3);
     this.yOffset = 0.0F;
     this.slimeJumpDelay = this.rand.nextInt(20) + 10;
   }

   public int getMaxSpawnedInChunk() {
     return 1;
   }

   protected void entityInit() {
     super.entityInit();
     this.dataWatcher.addObject(16, new Byte((byte)1));
   }

   protected String getJumpSound() {
     return "mob.slime.big";
   }

   public void onUpdate() {
     this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
     this.prevSquishFactor = this.squishFactor;
     boolean flag = this.onGround;
     super.onUpdate();

     if (this.onGround && !flag) {

       for (int j = 0; j < 8; j++) {

         float f = this.rand.nextFloat() * 3.1415927F * 2.0F;
         float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
         float f2 = MathHelper.sin(f) * 0.5F * f1;
         float f3 = MathHelper.cos(f) * 0.5F * f1;
       }

       if (makesSoundOnLand())
       {
         playSound(getJumpSound(), getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
       }

       this.squishAmount = -0.5F;
     }
     else if (!this.onGround && flag) {

       this.squishAmount = 1.0F;
     }

     alterSquishAmount();
   }

   protected void updateEntityActionState() {
     despawnEntity();
     EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity((Entity)this, 16.0D);

     if (entityplayer != null)
     {
       faceEntity((Entity)entityplayer, 10.0F, 20.0F);
     }

     if (this.onGround && this.slimeJumpDelay-- <= 0) {

       this.slimeJumpDelay = getJumpDelay();

       if (entityplayer != null)
       {
         this.slimeJumpDelay /= 3;
       }

       this.isJumping = true;

       if (makesSoundOnJump())
       {
         playSound(getJumpSound(), getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
       }

       this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
       this.moveForward = 1.0F;
     }
     else {

       this.isJumping = false;

       if (this.onGround)
       {
         this.moveStrafing = this.moveForward = 0.0F;
       }
     }
   }

   protected void alterSquishAmount() {
     this.squishAmount *= 0.6F;
   }

   protected int getJumpDelay() {
     return this.rand.nextInt(20) + 10;
   }

   protected EntityDitto createInstance() {
     return new EntityDitto(this.worldObj);
   }

   public void onCollideWithPlayer(EntityPlayer p_70100_1_) {
     if (canDamagePlayer())
     {
       if (canEntityBeSeen((Entity)p_70100_1_) && getDistanceSqToEntity((Entity)p_70100_1_) < 0.36D && p_70100_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), getAttackStrength()))
       {
         playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
       }
     }
   }

   protected boolean canDamagePlayer() {
     return true;
   }

   protected int getAttackStrength() {
     return 1;
   }

   protected Item getDropItem() {
     return Items.slime_ball;
   }

   protected float getSoundVolume() {
     return 0.4F;
   }

   protected boolean makesSoundOnJump() {
     return true;
   }

   protected boolean makesSoundOnLand() {
     return false;
   }

   public static void mainRegistry() {
     registerEntity();
   }

   private static void registerEntity() {
     createEntity(EntityDitto.class, "Ditto", 13017551, 14931169);
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