package apocalypse.fandomcraft.entity;

import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.command.IEntitySelector;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.EnumCreatureAttribute;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
 import net.minecraft.entity.ai.EntityAILookIdle;
 import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
 import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
 import net.minecraft.entity.ai.EntityAITempt;
 import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.IBossDisplayData;
 import net.minecraft.entity.monster.EntityMob;
 import net.minecraft.entity.monster.IMob;
 import net.minecraft.item.Item;
 import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityChaosBoss
   extends EntityMob implements IBossDisplayData {
  private int attackTimer;

  private static final IEntitySelector attackEntitySelector = new IEntitySelector()
    {
     public boolean isEntityApplicable(Entity p_82704_1_)
      {
        return (p_82704_1_ instanceof EntityLivingBase && ((EntityLivingBase)p_82704_1_).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD);
    }
     };
  private EntityAITempt aiTempt;
 protected void fall(float p_70069_1_) {}
   public EntityChaosBoss(World world) {
    super(world);
    setSize(1.0F, 2.5F);
    getNavigator().setAvoidsWater(true);
   this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3D));
    this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    this.tasks.addTask(2, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, Main.ring, true)));
     this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 2.0D, true));
    this.tasks.addTask(4, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9D, 32.0F));
   this.targetTasks.addTask(0, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityLiving.class, 0, false, true, IMob.mobSelector));
     this.isImmuneToFire = true;
    this.experienceValue = 500;
   }

  public float getEyeHeight() {
    return this.height * 0.8F;
  }

   protected String getHurtSound() {
   return "mob.wither.hurt";
  }

 protected String getDeathSound() {
     return "mob.wither.death";
  }

  protected Item getDropItem() {
    return Main.rupeeSilver;
  }

  @SideOnly(Side.CLIENT)
  public int getAttackTimer() {
    return this.attackTimer;
  }
  public int getTotalArmorValue() {
    return 4;
  }

  public boolean isArmored() {
    return (getHealth() <= getMaxHealth() / 2.0F);
  }

   protected void collideWithEntity(Entity p_82167_1_) {
    if (p_82167_1_ instanceof IMob && getRNG().nextInt(20) == 0)
    {
      setAttackTarget((EntityLivingBase)p_82167_1_);
   }

   super.collideWithEntity(p_82167_1_);
 }

  public boolean attackEntityAsMob(Entity p_70652_1_) {
   this.attackTimer = 10;
    this.worldObj.setEntityState((Entity)this, (byte)4);
   boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (7 + this.rand.nextInt(15)));

   if (flag)
    {
       p_70652_1_.motionY += 0.4000000059604645D;
    }

   playSound("fandomcraft:attack2", 1.0F, 1.0F);
     return flag;
  }

  public static void mainRegistry() {
    registerEntity();
  }

  private static void registerEntity() {
    createEntity(EntityChaosBoss.class, "ChaosBoss", 11272180, 16711918);
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

    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(800.0D);
     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
  }
}