package apocalypse.fandomcraft.horror;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class bloodstone extends Block
{
    public bloodstone() {
        super(Material.rock);
        this.setHardness(50.0f);
        this.setResistance(200.0f);
        this.setHarvestLevel("pickaxe", 4);
    }
}
