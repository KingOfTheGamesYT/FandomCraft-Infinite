package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class mythrilOre extends Block {
    public mythrilOre() {
        super(Material.rock);
        this.setHardness(14.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 4);
    }
}
