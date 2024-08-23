package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class clayBlock extends Block {
    public clayBlock(Material material) {
        super(material);
        this.setHarvestLevel("pickaxe", 1);
    }
}
