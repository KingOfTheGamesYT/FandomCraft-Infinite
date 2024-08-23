package apocalypse.fandomcraft.horror.entity;

import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.Main;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityJason extends EntityMob implements IBossDisplayData {
    private int attackTimer;
    private EntityAITempt aiTempt;

    protected void fall(float p_70069_1_) {
    }

    public EntityJason(World world) {
        super(world);
        this.setSize(1.0F, 1.8F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAILeapAtTarget(this, 3.0F));
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.experienceValue = 80;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(13, new Byte((byte)0));
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected Item getDropItem() {
        return HorrorReg.chainsaw;
    }

    protected void dropRareDrop(int p_70600_1_) {
        switch(this.rand.nextInt(3)) {
            case 0:
                this.dropItem(HorrorReg.throwingKnife, 9);
                break;
            case 1:
                this.dropItem(HorrorReg.maskJason, 1);
                break;
            case 2:
                this.dropItem(HorrorReg.smallPumpkin, 3);
        }

    }

    protected boolean canDespawn() {
        return false;
    }

    protected void collideWithEntity(Entity p_82167_1_) {
        if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)p_82167_1_);
        }

        super.collideWithEntity(p_82167_1_);
    }

    public boolean attackEntityAsMob(Entity p_70652_1_) {
        Random rand = new Random();
        int a = rand.nextInt(3);
        boolean flag;
        if (a == 1) {
            this.attackTimer = 10;
            this.worldObj.setEntityState(this, (byte)4);
            flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
            if (flag) {
                p_70652_1_.motionY += 0.01D;
            }

            return flag;
        } else {
            this.attackTimer = 10;
            this.worldObj.setEntityState(this, (byte)4);
            flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(9 + this.rand.nextInt(20)));
            if (flag) {
                p_70652_1_.motionY += 0.01D;
            }

            return flag;
        }
    }

    public static void mainRegistry() {
        registerEntity();
    }

    private static void registerEntity() {
        createEntity(EntityJason.class, "EntityJason", 0, 0);
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

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    public boolean isAIenabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(750.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.3D);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(HorrorReg.chainsaw));
    }
}
