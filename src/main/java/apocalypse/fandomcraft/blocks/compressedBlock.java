package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class compressedBlock extends Block {
    public compressedBlock() {
        super(Material.iron);
        this.setHardness(3.0F);
        this.setResistance(15.0F);
        this.setStepSound(soundTypeMetal);
        this.setHarvestLevel("pickaxe", 3);
    }
}
