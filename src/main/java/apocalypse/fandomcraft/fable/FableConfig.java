 package apocalypse.fandomcraft.fable;

 import cpw.mods.fml.common.event.FMLPreInitializationEvent;
 import java.io.File;
 import net.minecraftforge.common.config.Configuration;

 public class FableConfig
 {
   public static Configuration fableConfig;
   private static int welcomeReminder;
   private static boolean killerHobbes;
   private static int spawnHobbes;
   private static int spawnHollowMan;
   private static int generateBanditCamps;
   private static int generateTemples;
   private static int generateDungeons;

   public static void init(FMLPreInitializationEvent event) {
     fableConfig = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "/FandomCraft_Fable_Addon.cfg"));
     fableConfig.load();
     System.out.println("[Ms_Raven's Fable Heroes Mod] Loaded config.");

     welcomeReminder = fableConfig.getInt("Login Message", "System", 2, 0, 2, "Set this to '0' if you don't want a login message. Set this to '1' if you want a welcome message. Set this to '2' if you want a full welcome message with fraud warnings.");
     killerHobbes = fableConfig.getBoolean("Hobbes Kill Animals", "Mob Behavior", true, "Set this to 'false' if you don't want Hobbes to attack animals");

     spawnHobbes = fableConfig.getInt("Hobbe spawn chance", "Mob Spawning", 10, 0, 100, "");
     spawnHollowMan = fableConfig.getInt("Hollow Man spawn chance", "Mob Spawning", 10, 0, 100, "");

     generateBanditCamps = fableConfig.getInt("Bandit Camp generation chance", "World Generation", 100, 0, 100, "The chance that a Bandit Camp will spawn each time a chunk loads (out of 1000).");
     generateTemples = fableConfig.getInt("Temple generation chance", "World Generation", 10, 0, 100, "The chance that a Temple will spawn each time a chunk loads (out of 1000).");
     generateDungeons = fableConfig.getInt("Dungeon generation chance", "World Generation", 10, 0, 100, "The chance that an advanced Dungeon will spawn each time a chunk loads (out of 1000).");

     saveConfig();
   }

   public static int welcomeReminder() {
     return welcomeReminder; } public static boolean killerHobbes() {
     return killerHobbes;
   }
   public static int spawnHobbes() { return spawnHobbes; } public static int spawnHollowMan() {
     return spawnHollowMan;
   }
   public static int generateBanditCamps() { return generateBanditCamps; }
   public static int generateTemples() { return generateTemples; } public static int generateDungeons() {
     return generateDungeons;
   }

   public static void changeWelcomeReminder(int type) {
     welcomeReminder = type;
     saveConfig();
   }

   public static void saveConfig() {
     fableConfig.save();
     System.out.println("[Ms_Raven's Fable Heroes Mod] Saved config.");
   }
 }