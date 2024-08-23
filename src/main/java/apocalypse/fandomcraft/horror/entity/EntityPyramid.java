package apocalypse.fandomcraft.horror.entity;

import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.Main;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPyramid extends EntityMob implements IBossDisplayData {
    private int attackTimer;
    private EntityAITempt aiTempt;

    protected void fall(float p_70069_1_) {
    }

    public EntityPyramid(World world) {
        super(world);
        this.setSize(1.5F, 2.5F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityNurse.class, 16.0F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 2.0D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityNurse.class, 0, true));
        this.experienceValue = 80;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected Item getDropItem() {
        return HorrorReg.giantKnife;
    }

    protected boolean canDespawn() {
        return false;
    }

    public static void mainRegistry() {
        registerEntity();
    }

    private static void registerEntity() {
        createEntity(EntityPyramid.class, "EntityPyramid", 0, 0);
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.3D);
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(HorrorReg.giantKnife));
    }
}
