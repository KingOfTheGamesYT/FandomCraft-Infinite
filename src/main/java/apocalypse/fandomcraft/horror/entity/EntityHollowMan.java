package apocalypse.fandomcraft.horror.entity;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.entity.*;

public class EntityHollowMan extends EntityMob
{
    protected void fall(final float distance) {
    }
    
    public EntityHollowMan(final World world) {
        super(world);
        this.setSize(1.0f, 2.0f);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.3));
        this.tasks.addTask(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0, true));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIMoveTowardsTarget((EntityCreature)this, 0.9, 32.0f));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityPlayer.class, 0, true));
        this.experienceValue = 3;
    }
    
    public int getMaxSpawnedInChunk() {
        return 5;
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, (Object)new Byte((byte)0));
    }
    
    protected String getLivingSound() {
        return "mob.zombie.say";
    }
    
    protected String getHurtSound() {
        return "mob.zombie.hurt";
    }
    
    protected String getDeathSound() {
        return "mob.zombie.death";
    }
    
    protected Item getDropItem() {
        return Items.bone;
    }
    
    protected void dropRareDrop(final int p_70600_1_) {
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.dropItem(Items.rotten_flesh, 1);
                break;
            }
            case 1: {
                this.dropItem(Main.rupeeGreen, 1);
                break;
            }
        }
    }
    
    protected void collideWithEntity(final Entity p_82167_1_) {
        if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)p_82167_1_);
        }
        super.collideWithEntity(p_82167_1_);
    }
    
    public boolean attackEntityAsMob(final Entity p_70652_1_) {
        this.worldObj.setEntityState((Entity)this, (byte)4);
        final boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)(7 + this.rand.nextInt(15)));
        if (flag) {
            p_70652_1_.motionY += 0.01;
        }
        this.playSound("mob.zombie.say", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        return flag;
    }
    
    public static void mainRegistry() {
        registerEntity();
    }
    
    private static void registerEntity() {
        createEntity(EntityHollowMan.class, "EntityHollowMan", 5128747, 16777215);
    }
    
    public static void createEntity(final Class entityClass, final String entityName, final int solidColour, final int spotColour) {
        final int id = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
        EntityRegistry.registerModEntity(entityClass, entityName, id, (Object)Main.instance, 64, 1, true);
        createEgg(id, solidColour, spotColour);
    }
    
    private static void createEgg(final int id, final int solidColour, final int spotColour) {
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, solidColour, spotColour));
    }
    
    public boolean isAIenabled() {
        return true;
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0);
    }
}
