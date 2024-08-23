package apocalypse.fandomcraft.horror;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class bloodstoneBrick extends Block
{
    public bloodstoneBrick() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(150.0f);
        this.setHarvestLevel("pickaxe", 3);
    }
}
