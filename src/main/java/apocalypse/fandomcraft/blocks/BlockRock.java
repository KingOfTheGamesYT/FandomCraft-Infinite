package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRock extends Block {
    public BlockRock(Material material) {
        super(material);
        this.setResistance(5.0F);
        this.setHardness(5.0F);
        this.setStepSound(soundTypeStone);
        this.setHarvestLevel("pickaxe", 3);
    }
}
