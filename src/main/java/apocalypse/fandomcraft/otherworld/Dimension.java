package apocalypse.fandomcraft.otherworld;

import net.minecraftforge.common.*;

public class Dimension
{
    public static void registerDimensions() {
        DimensionManager.registerDimension(DimensionIDs.OTHERWORLDDIMENSION, DimensionIDs.OTHERWORLDDIMENSION);
    }
    
    public static void registerWorldProvider() {
        DimensionManager.registerProviderType(DimensionIDs.OTHERWORLDDIMENSION, (Class)WorldProviderOtherworld.class, true);
    }
}
