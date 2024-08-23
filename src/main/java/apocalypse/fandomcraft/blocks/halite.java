package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class halite extends Block {
    public halite() {
        super(Material.rock);
        this.setHardness(4.0F);
        this.setResistance(1.0F);
        this.setHarvestLevel("pickaxe", 2);
    }
}
