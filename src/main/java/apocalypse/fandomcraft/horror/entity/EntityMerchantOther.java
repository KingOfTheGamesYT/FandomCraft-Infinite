package apocalypse.fandomcraft.horror.entity;

import apocalypse.fandomcraft.main.Main;
import apocalypse.fandomcraft.main.Tools;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMerchantOther extends EntityCreature implements INpc {
    private EntityPlayer buyingPlayer;

    public EntityMerchantOther(World world) {
        super(world);
    }

    public EntityMerchantOther(World p_i1748_1_, int p_i1748_2_) {
        super(p_i1748_1_);
        this.setSize(0.6F, 1.8F);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    }

    public boolean isAIEnabled() {
        return false;
    }

    public boolean interact(EntityPlayer p_70085_1_) {
        if (this.isEntityAlive() && !p_70085_1_.isSneaking()) {
            if (!this.worldObj.isRemote) {
                int i = (int)p_70085_1_.posX;
                int j = (int)p_70085_1_.posY;
                int k = (int)p_70085_1_.posZ;
                p_70085_1_.openGui(Main.instance, Main.GuiTravellerOther, p_70085_1_.worldObj, i, j, k);
                Tools.println("Opening GUI with id of " + Main.GuiTravellerOther);
            }

            return true;
        } else {
            return false;
        }
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        return this.isTrading() ? "mob.villager.haggle" : "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }

    public void setCustomer(EntityPlayer p_70932_1_) {
        this.buyingPlayer = p_70932_1_;
    }

    public EntityPlayer getCustomer() {
        return this.buyingPlayer;
    }

    public boolean isTrading() {
        return this.buyingPlayer != null;
    }

    public void verifySellingItem(ItemStack p_110297_1_) {
        if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            if (p_110297_1_ != null) {
                this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
            } else {
                this.playSound("mob.villager.no", this.getSoundVolume(), this.getSoundPitch());
            }
        }

    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_) {
        if (p_70103_1_ == 12) {
            this.generateRandomParticles("heart");
        } else if (p_70103_1_ == 13) {
            this.generateRandomParticles("angryVillager");
        } else if (p_70103_1_ == 14) {
            this.generateRandomParticles("happyVillager");
        } else {
            super.handleHealthUpdate(p_70103_1_);
        }

    }

    @SideOnly(Side.CLIENT)
    private void generateRandomParticles(String p_70942_1_) {
        for(int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(p_70942_1_, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
        }

    }

    public boolean allowLeashing() {
        return false;
    }

    public static void mainRegistry() {
        registerEntity();
    }

    private static void registerEntity() {
        createEntity(EntityMerchantOther.class, "EntityMerchantOther", 16777215, 16777215);
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
}
