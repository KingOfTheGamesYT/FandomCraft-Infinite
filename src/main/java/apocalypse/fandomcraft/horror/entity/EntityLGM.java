package apocalypse.fandomcraft.horror.entity;

import apocalypse.fandomcraft.main.Main;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityLGM extends EntityEnderman {
    public EntityLGM(World world) {
        super(world);
        this.setSize(0.6F, 2.9F);
        this.stepHeight = 1.0F;
    }

    protected Item getDropItem() {
        return Main.mysteryDust;
    }

    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        Item item = this.getDropItem();
        if (item != null) {
            int j = this.rand.nextInt(2 + p_70628_2_);

            for(int k = 0; k < j; ++k) {
                this.dropItem(item, 1);
            }
        }

    }

    public static void mainRegistry() {
        registerEntity();
    }

    private static void registerEntity() {
        createEntity(EntityLGM.class, "EntityLGM", 16777215, 16777215);
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
