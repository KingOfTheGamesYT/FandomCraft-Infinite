package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class adamantiumOre extends Block {
    public adamantiumOre() {
        super(Material.rock);
        this.setHardness(20.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 6);
    }
}
