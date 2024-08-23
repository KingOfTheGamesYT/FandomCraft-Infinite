package apocalypse.fandomcraft.main;

import net.minecraftforge.common.config.*;
import cpw.mods.fml.common.event.*;
import java.io.*;

public class FConfig
{
    public static Configuration fConfig;
    private static int bokoblinPirate;
    private static int dekuTreeDungeon;
    private static int waterDungeon;
    private static int fireDungeon;
    private static int iceDungeon;
    private static int desertDungeon;
    private static int waterTemple;
    private static int crypt;
    private static int royalHall;
    private static int twilightGate;
    private static int guardTower;
    private static int skyDungeon;
    private static int fairyIsland;
    private static int gannonTower;
    private static int mobFriendlyChaoSpawn;
    private static int mobDarkChaoSpawn;
    private static int mobPinkChaoSpawn;
    private static int mobJungleChaoSpawn;
    private static int mobGreenChaoSpawn;
    private static int mobShadowSpawn;
    private static int mobKoopaSpawn;
    private static int mobGoombaSpawn;
    private static int mobPikachuSpawn;
    private static int mobUnownSpawn;
    private static int mobRedeadSpawn;
    private static int mobDittoSpawn;
    private static int mobAttackPigSpawn;
    private static int mobAttackChickenSpawn;
    private static int mobBulboSpawn;
    private static int mobBokoblinSpawn;
    private static int mobTektiteSpawn;
    private static int mobCharmanderSpawn;
    private static int mobArmosSpawn;
    private static int mobDarknutSpawn;
    private static int mobKeeseSpawn;
    private static int mobMetroidSpawn;
    private static int mobShadowbeastSpawn;
    private static int mobTingleSpawn;
    private static int mobToadoSpawn;
    private static int mobBlueTektiteSpawn;
    private static int mobMiniblinSpawn;
    private static int mobFreezardSpawn;
    private static int mobWolfosSpawn;
    private static int mobBombskitSpawn;
    private static int mobHobbeSpawn;
    private static int mobHollowManSpawn;
    
    public static void init(final FMLPreInitializationEvent event) {
        (FConfig.fConfig = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "/FandomCraft Spawns.cfg"))).load();
        System.out.println("[FandomCraft] Loaded spawn config.");
        FConfig.waterDungeon = FConfig.fConfig.getInt("Water Dungeon Chance", "Dungeons", 1, 1, 2000, "Chance for Water Dungeons to spawn (Out of 2000) This number should be lower than other dungeons because it's not biome-dependent.");
        FConfig.skyDungeon = FConfig.fConfig.getInt("Sky Dungeon Chance", "Dungeons", 1, 1, 2000, "Chance for Sky Dungeons to spawn (Out of 2000) This number should be lower than other dungeons because it's not biome-dependent.");
        FConfig.fairyIsland = FConfig.fConfig.getInt("Fairy Island Chance", "Dungeons", 1, 1, 2000, "Chance for Fairy Islands to spawn (Out of 2000) This number should be lower than other dungeons because it's not biome-dependent.");
        FConfig.royalHall = FConfig.fConfig.getInt("Royal Hall Chance", "Dungeons", 1, 1, 2000, "Chance for Royal Halls to spawn (Out of 2000) This number should be lower than other dungeons because it's not biome-dependent.");
        FConfig.bokoblinPirate = FConfig.fConfig.getInt("Bokoblin Raft Chance", "Dungeons", 5, 1, 500, "Chance for Bokoblin Rafts to spawn in oceans (Out of 500)");
        FConfig.dekuTreeDungeon = FConfig.fConfig.getInt("Deku Tree Chance", "Dungeons", 2, 1, 500, "Chance for Deku Trees to spawn (Out of 500)");
        FConfig.fireDungeon = FConfig.fConfig.getInt("Fire Dungeon Chance", "Dungeons", 1, 1, 500, "Chance for Fire Dungeons to spawn (Out of 500)");
        FConfig.iceDungeon = FConfig.fConfig.getInt("Ice Dungeon Chance", "Dungeons", 1, 1, 500, "Chance for Ice Dungeons to spawn (Out of 500)");
        FConfig.desertDungeon = FConfig.fConfig.getInt("Desert Dungeon Chance", "Dungeons", 1, 1, 500, "Chance for Desert Dungeons to spawn (Out of 500)");
        FConfig.crypt = FConfig.fConfig.getInt("Crypt Chance", "Dungeons", 1, 1, 500, "Chance for Crypts to spawn (Out of 500)");
        FConfig.twilightGate = FConfig.fConfig.getInt("Twilight Gate Chance", "Dungeons", 1, 1, 500, "Chance for Twilight Gates to spawn (Out of 500)");
        FConfig.guardTower = FConfig.fConfig.getInt("Guard Tower Chance", "Dungeons", 1, 1, 500, "Chance for Guard Towers to spawn (Out of 500)");
        FConfig.waterTemple = FConfig.fConfig.getInt("Water Temple Chance", "Boss Dungeons", 1, 1, 2, "Chance for the Water Temple to spawn. (Out of 500. Must be 1 or 2) WARNING: Higher numbers may cause a lot of lag when generating.");
        FConfig.gannonTower = FConfig.fConfig.getInt("Gannon's Tower Chance", "Boss Dungeons", 1, 1, 4, "Chance for Gannon's Tower to spawn. (Out of 2000. Must be between 1 and 4) WARNING: Higher numbers will cause a ton of lag when generating.");
        FConfig.mobFriendlyChaoSpawn = FConfig.fConfig.getInt("Hero Chao", "Mob Spawning", 0, 0, 100, "Chance to spawn");
        FConfig.mobDarkChaoSpawn = FConfig.fConfig.getInt("Dark Chao", "Mob Spawning", 1, 0, 100, "Chance to spawn");
        FConfig.mobPinkChaoSpawn = FConfig.fConfig.getInt("Companion Chao", "Mob Spawning", 0, 0, 100, "Chance to spawn");
        FConfig.mobJungleChaoSpawn = FConfig.fConfig.getInt("Nesting Chao", "Mob Spawning", 1, 0, 100, "Chance to spawn");
        FConfig.mobGreenChaoSpawn = FConfig.fConfig.getInt("Lonely Chao", "Mob Spawning", 0, 0, 100, "Chance to spawn");
        FConfig.mobShadowSpawn = FConfig.fConfig.getInt("Shadow", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobKoopaSpawn = FConfig.fConfig.getInt("Koopa", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobGoombaSpawn = FConfig.fConfig.getInt("Goomba", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobPikachuSpawn = FConfig.fConfig.getInt("Pikachu", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobUnownSpawn = FConfig.fConfig.getInt("Unown", "Mob Spawning", 15, 0, 100, "Chance to spawn");
        FConfig.mobRedeadSpawn = FConfig.fConfig.getInt("Redead", "Mob Spawning", 15, 0, 100, "Chance to spawn");
        FConfig.mobDittoSpawn = FConfig.fConfig.getInt("Ditto", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobAttackPigSpawn = FConfig.fConfig.getInt("Angry Pig", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobAttackChickenSpawn = FConfig.fConfig.getInt("Angry Chicken", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobBulboSpawn = FConfig.fConfig.getInt("Bullbo", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobBokoblinSpawn = FConfig.fConfig.getInt("Bokoblin", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobTektiteSpawn = FConfig.fConfig.getInt("Tektite", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobCharmanderSpawn = FConfig.fConfig.getInt("Charmander", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobArmosSpawn = FConfig.fConfig.getInt("Armos", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobDarknutSpawn = FConfig.fConfig.getInt("Darknut", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobKeeseSpawn = FConfig.fConfig.getInt("Keese", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobMetroidSpawn = FConfig.fConfig.getInt("Metroid", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobToadoSpawn = FConfig.fConfig.getInt("Toado", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobMiniblinSpawn = FConfig.fConfig.getInt("Miniblin", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobFreezardSpawn = FConfig.fConfig.getInt("Freezard", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobWolfosSpawn = FConfig.fConfig.getInt("Wolfos", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobBombskitSpawn = FConfig.fConfig.getInt("Bombskit", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobHobbeSpawn = FConfig.fConfig.getInt("Hobbe", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        FConfig.mobHollowManSpawn = FConfig.fConfig.getInt("Hollow Man", "Mob Spawning", 50, 0, 100, "Chance to spawn");
        if (FConfig.fConfig.hasChanged()) {
            FConfig.fConfig.save();
            System.out.println("[FandomCraft] Synchronised spawn config.");
        }
    }
    
    public static int waterDungeon() {
        return FConfig.waterDungeon;
    }
    
    public static int skyDungeon() {
        return FConfig.skyDungeon;
    }
    
    public static int fairyIsland() {
        return FConfig.fairyIsland;
    }
    
    public static int royalHall() {
        return FConfig.royalHall;
    }
    
    public static int bokoblinPirate() {
        return FConfig.bokoblinPirate;
    }
    
    public static int dekuTreeDungeon() {
        return FConfig.dekuTreeDungeon;
    }
    
    public static int fireDungeon() {
        return FConfig.fireDungeon;
    }
    
    public static int iceDungeon() {
        return FConfig.iceDungeon;
    }
    
    public static int desertDungeon() {
        return FConfig.desertDungeon;
    }
    
    public static int crypt() {
        return FConfig.crypt;
    }
    
    public static int twilightGate() {
        return FConfig.twilightGate;
    }
    
    public static int guardTower() {
        return FConfig.guardTower;
    }
    
    public static int waterTemple() {
        return FConfig.waterTemple;
    }
    
    public static int gannonTower() {
        return FConfig.gannonTower;
    }
    
    public static int mobFriendlyChaoSpawn() {
        return FConfig.mobFriendlyChaoSpawn;
    }
    
    public static int mobDarkChaoSpawn() {
        return FConfig.mobDarkChaoSpawn;
    }
    
    public static int mobPinkChaoSpawn() {
        return FConfig.mobPinkChaoSpawn;
    }
    
    public static int mobJungleChaoSpawn() {
        return FConfig.mobJungleChaoSpawn;
    }
    
    public static int mobGreenChaoSpawn() {
        return FConfig.mobGreenChaoSpawn;
    }
    
    public static int mobShadowSpawn() {
        return FConfig.mobShadowSpawn;
    }
    
    public static int mobKoopaSpawn() {
        return FConfig.mobKoopaSpawn;
    }
    
    public static int mobGoombaSpawn() {
        return FConfig.mobGoombaSpawn;
    }
    
    public static int mobPikachuSpawn() {
        return FConfig.mobPikachuSpawn;
    }
    
    public static int mobUnownSpawn() {
        return FConfig.mobUnownSpawn;
    }
    
    public static int mobRedeadSpawn() {
        return FConfig.mobRedeadSpawn;
    }
    
    public static int mobDittoSpawn() {
        return FConfig.mobDittoSpawn;
    }
    
    public static int mobAttackPigSpawn() {
        return FConfig.mobAttackPigSpawn;
    }
    
    public static int mobAttackChickenSpawn() {
        return FConfig.mobAttackChickenSpawn;
    }
    
    public static int mobBulboSpawn() {
        return FConfig.mobBulboSpawn;
    }
    
    public static int mobBokoblinSpawn() {
        return FConfig.mobBokoblinSpawn;
    }
    
    public static int mobTektiteSpawn() {
        return FConfig.mobTektiteSpawn;
    }
    
    public static int mobCharmanderSpawn() {
        return FConfig.mobCharmanderSpawn;
    }
    
    public static int mobArmosSpawn() {
        return FConfig.mobArmosSpawn;
    }
    
    public static int mobDarknutSpawn() {
        return FConfig.mobDarknutSpawn;
    }
    
    public static int mobKeeseSpawn() {
        return FConfig.mobKeeseSpawn;
    }
    
    public static int mobMetroidSpawn() {
        return FConfig.mobMetroidSpawn;
    }
    
    public static int mobShadowbeastSpawn() {
        return FConfig.mobShadowbeastSpawn;
    }
    
    public static int mobTingleSpawn() {
        return FConfig.mobTingleSpawn;
    }
    
    public static int mobToadoSpawn() {
        return FConfig.mobToadoSpawn;
    }
    
    public static int mobBlueTektiteSpawn() {
        return FConfig.mobBlueTektiteSpawn;
    }
    
    public static int mobMiniblinSpawn() {
        return FConfig.mobMiniblinSpawn;
    }
    
    public static int mobFreezardSpawn() {
        return FConfig.mobFreezardSpawn;
    }
    
    public static int mobWolfosSpawn() {
        return FConfig.mobWolfosSpawn;
    }
    
    public static int mobBombskitSpawn() {
        return FConfig.mobBombskitSpawn;
    }
    
    public static int mobHobbeSpawn() {
        return FConfig.mobHobbeSpawn;
    }
    
    public static int mobHollowManSpawn() {
        return FConfig.mobHollowManSpawn;
    }
}
