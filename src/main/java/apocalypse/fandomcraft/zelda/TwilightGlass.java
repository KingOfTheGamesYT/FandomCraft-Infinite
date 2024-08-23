package apocalypse.fandomcraft.zelda;

import apocalypse.fandomcraft.blocks.*;
import net.minecraft.block.material.*;
import cpw.mods.fml.relauncher.*;

public class TwilightGlass extends UnbreakableBlock
{
    public TwilightGlass(final Material m) {
        super(m);
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
}
