package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RockCobble extends Block {
    public RockCobble() {
        super(Material.rock);
        this.setHardness(2.5F);
        this.setResistance(15.0F);
        this.setHarvestLevel("pickaxe", 1);
    }
}
