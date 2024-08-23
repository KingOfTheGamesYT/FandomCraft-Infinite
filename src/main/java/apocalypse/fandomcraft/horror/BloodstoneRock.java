package apocalypse.fandomcraft.horror;

import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class BloodstoneRock extends Block
{
    public BloodstoneRock(final Material material) {
        super(material);
        this.setResistance(5.0f);
        this.setHardness(5.0f);
        this.setStepSound(BloodstoneRock.soundTypeStone);
        this.setHarvestLevel("pickaxe", 3);
    }
}
