package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UnbreakableBlock extends Block {
    public UnbreakableBlock(Material m) {
        super(m);
        this.setHardness(200.0F);
        this.setResistance(99999.0F);
        this.setHarvestLevel("axe", 10);
    }
}
