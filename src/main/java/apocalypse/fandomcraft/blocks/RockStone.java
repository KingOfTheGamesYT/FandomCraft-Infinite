package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RockStone extends Block {
    public RockStone() {
        super(Material.rock);
        this.setHardness(2.0F);
        this.setResistance(12.0F);
        this.setBlockTextureName("fandomcraft:rock");
        this.setHarvestLevel("pickaxe", 1);
    }
}
