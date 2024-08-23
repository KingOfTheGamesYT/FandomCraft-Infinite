package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class foolsGoldOre extends Block {
    public foolsGoldOre() {
        super(Material.rock);
        this.setHardness(3.0F);
        this.setResistance(3.0F);
        this.setHarvestLevel("pickaxe", 2);
    }
}
