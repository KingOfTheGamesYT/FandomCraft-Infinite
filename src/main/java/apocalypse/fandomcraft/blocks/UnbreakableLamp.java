package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UnbreakableLamp extends Block {
    public UnbreakableLamp(Material m) {
        super(m);
        this.setHardness(200.0F);
        this.setResistance(99999.0F);
        this.setHarvestLevel("axe", 10);
        this.setLightLevel(1.0F);
    }
}
