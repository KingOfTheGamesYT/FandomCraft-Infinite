package apocalypse.fandomcraft.horror.entity;

import apocalypse.fandomcraft.main.Main;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMummy extends EntityZombie {
    protected void fall(float p_70069_1_) {
    }

    public EntityMummy(World world) {
        super(world);
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
        return Items.rotten_flesh;
    }

    protected void dropRareDrop(int p_70600_1_) {
        switch(this.rand.nextInt(3)) {
            case 0:
                this.dropItem(Items.rotten_flesh, 1);
                break;
            case 1:
                this.dropItem(Main.rupeeYellow, 1);
        }

    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
    }
}
