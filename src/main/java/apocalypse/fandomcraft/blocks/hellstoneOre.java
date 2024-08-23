package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class hellstoneOre extends Block {
    public hellstoneOre() {
        super(Material.rock);
        this.setHardness(25.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 6);
    }
}
