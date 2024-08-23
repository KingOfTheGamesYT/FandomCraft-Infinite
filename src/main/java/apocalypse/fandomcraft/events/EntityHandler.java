 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import java.util.Random;
 import net.minecraft.entity.EntityList;
 import net.minecraft.entity.EnumCreatureType;

 public class EntityHandler
 {
   public static void registerMonsters(Class entityClass, String name) {
     int entityId = EntityRegistry.findGlobalUniqueEntityId();
     long x = name.hashCode();
     Random random = new Random(x);
     int mainColour = random.nextInt() * 16777215;
     int secondColour = random.nextInt() * 16777215;

     EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
     EntityRegistry.addSpawn(entityClass, 50, 2, 4, EnumCreatureType.ambient, new net.minecraft.world.biome.BiomeGenBase[0]);
     EntityRegistry.registerModEntity(entityClass, name, entityId, Main.instance, 32, 1, true);
     EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColour, secondColour));
   }
 }