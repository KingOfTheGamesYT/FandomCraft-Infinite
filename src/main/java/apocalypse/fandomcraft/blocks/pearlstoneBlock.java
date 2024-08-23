package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class pearlstoneBlock extends Block {
    public pearlstoneBlock() {
        super(Material.rock);
        this.setHardness(8.0F);
        this.setResistance(12.0F);
        this.setHarvestLevel("pickaxe", 3);
    }
}
