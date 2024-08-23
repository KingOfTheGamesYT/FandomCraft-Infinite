package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class orichulumOre extends Block {
    public orichulumOre() {
        super(Material.rock);
        this.setHardness(10.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 3);
    }
}
