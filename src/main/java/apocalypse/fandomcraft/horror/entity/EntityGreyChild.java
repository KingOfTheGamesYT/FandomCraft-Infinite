package apocalypse.fandomcraft.horror.entity;

import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.Main;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGreyChild extends EntityMob {
    protected void fall(float p_70069_1_) {
    }

    public EntityGreyChild(World world) {
        super(world);
        this.setSize(1.0F, 2.0F);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAIWander(this, 0.3D));
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, new Byte((byte)0));
    }

    protected Item getDropItem() {
        return HorrorReg.rustClump;
    }

    protected void collideWithEntity(Entity p_82167_1_) {
        if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)p_82167_1_);
        }

        super.collideWithEntity(p_82167_1_);
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        this.worldObj.setEntityState(this, (byte)4);
        boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
        if (flag) {
            p_70652_1_.motionY += 0.01D;
        }

        return flag;
    }

    public static void mainRegistry() {
        registerEntity();
    }

    private static void registerEntity() {
        createEntity(EntityGreyChild.class, "EntityGreyChild", 5128747, 16777215);
    }

    public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour) {
        int id = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
        EntityRegistry.registerModEntity(entityClass, entityName, id, Main.instance, 64, 1, true);
        createEgg(id, solidColour, spotColour);
    }

    private static void createEgg(int id, int solidColour, int spotColour) {
        EntityList.entityEggs.put(id, new EntityEggInfo(id, solidColour, spotColour));
    }

    public boolean isAIenabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
    }
}
