package apocalypse.fandomcraft.main;

import net.minecraftforge.common.config.*;
import cpw.mods.fml.common.event.*;
import java.io.*;
import apocalypse.fandomcraft.otherworld.*;

public class FConfig2
{
    public static Configuration fConfig;
    private static boolean printConsole;
    private static boolean hardmode;
    
    public static void init(final FMLPreInitializationEvent event) {
        (FConfig2.fConfig = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "/FandomCraft System.cfg"))).load();
        System.out.println("[FandomCraft] Loaded config.");
        FConfig2.printConsole = FConfig2.fConfig.getBoolean("Dev Console", "System", true, "Prints dev statements in the console when available.");
        FConfig2.hardmode = FConfig2.fConfig.getBoolean("Hardmode", "System", false, "Setting to 'true' makes the player drop half their coins on death.");
        DimensionIDs.OTHERWORLDDIMENSION = FConfig2.fConfig.getInt("Otherworld ID", "Dimensions", 11, 3, 100, "Dimension ID for the Otherworld.");
        BiomeIDs.BADLANDS = FConfig2.fConfig.getInt("Badlands ID", "Biomes", 30, 30, 100, "Biome ID for Badlands.");
        BiomeIDs.BLOODWOOD = FConfig2.fConfig.getInt("Bloodwoods ID", "Biomes", 31, 30, 100, "Biome ID for Bloodwood Forest.");
        if (FConfig2.fConfig.hasChanged()) {
            FConfig2.fConfig.save();
            System.out.println("[FandomCraft] Synchronised config.");
        }
    }
    
    public static int OtherworldID() {
        return DimensionIDs.OTHERWORLDDIMENSION;
    }
    
    public static boolean printConsole() {
        return FConfig2.printConsole;
    }
    
    public static boolean hardmode() {
        return FConfig2.hardmode;
    }
}
