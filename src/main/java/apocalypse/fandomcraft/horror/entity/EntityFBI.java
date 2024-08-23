package apocalypse.fandomcraft.horror.entity;

import apocalypse.fandomcraft.fable.ProjectileBullet;
import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.FandomAchievementList;
import apocalypse.fandomcraft.main.Main;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFBI extends EntitySkeleton {
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
    private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);

    public EntityFBI(World p_i1741_1_) {
        super(p_i1741_1_);
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected void playStepSound(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }

    public void onLivingUpdate() {
    }

    public void onDeath(DamageSource p_70645_1_) {
        super.onDeath(p_70645_1_);
        if (p_70645_1_.getSourceOfDamage() instanceof ProjectileBullet && p_70645_1_.getEntity() instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer)p_70645_1_.getEntity();
            double d0 = entityplayer.posX - this.posX;
            double d1 = entityplayer.posZ - this.posZ;
            if (d0 * d0 + d1 * d1 >= 2500.0D) {
                entityplayer.triggerAchievement(FandomAchievementList.murder);
            }
        }

    }

    protected Item getDropItem() {
        return Main.bullet;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int j;
        int k;
        if (this.getSkeletonType() == 1) {
            j = this.rand.nextInt(3 + p_70628_2_) - 1;

            for(k = 0; k < j; ++k) {
                this.dropItem(Main.bullet, 1);
            }
        } else {
            j = this.rand.nextInt(3 + p_70628_2_);

            for(k = 0; k < j; ++k) {
                this.dropItem(Main.bullet, 1);
            }
        }

        j = this.rand.nextInt(3 + p_70628_2_);

        for(k = 0; k < j; ++k) {
            this.dropItem(Main.bullet, 1);
        }

    }

    protected void dropRareDrop(int p_70600_1_) {
        if (this.getSkeletonType() == 1) {
            this.entityDropItem(new ItemStack(HorrorReg.handgun, 1, 1), 0.0F);
        }

    }

    public void setCombatTask() {
        this.tasks.removeTask(this.aiAttackOnCollide);
        this.tasks.removeTask(this.aiArrowAttack);
        ItemStack itemstack = this.getHeldItem();
        if (itemstack != null && itemstack.getItem() == HorrorReg.handgun) {
            this.tasks.addTask(4, this.aiArrowAttack);
        } else {
            this.tasks.addTask(4, this.aiAttackOnCollide);
        }

    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        ProjectileBullet entityarrow = new ProjectileBullet(this.worldObj, this, 1.6F);
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
        int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
        entityarrow.setDamage((double)(p_82196_2_ * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11F));
        this.playSound("fandomcraftshot", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entityarrow);
    }

    public void setCurrentItemOrArmor(int p_70062_1_, ItemStack p_70062_2_) {
        super.setCurrentItemOrArmor(p_70062_1_, p_70062_2_);
        if (!this.worldObj.isRemote && p_70062_1_ == 0) {
            this.setCombatTask();
        }

    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(HorrorReg.handgun));
    }

    public static void mainRegistry() {
        registerEntity();
    }

    private static void registerEntity() {
        createEntity(EntityFBI.class, "EntityFBI", 16777215, 16777215);
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
