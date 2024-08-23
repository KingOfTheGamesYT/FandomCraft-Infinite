package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class eridiumOre extends Block {
    public eridiumOre() {
        super(Material.rock);
        this.setHardness(17.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 5);
    }
}
