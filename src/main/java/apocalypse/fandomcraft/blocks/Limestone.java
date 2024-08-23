package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Limestone extends Block {
    public Limestone() {
        super(Material.rock);
        this.setHardness(2.5F);
        this.setResistance(12.0F);
        this.setHarvestLevel("pickaxe", 1);
    }
}
