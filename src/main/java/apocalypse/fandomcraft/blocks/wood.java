package apocalypse.fandomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class wood extends Block {
    public wood(Material mat) {
        super(mat);
        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
        this.setResistance(3.0F);
        this.setStepSound(soundTypeWood);
    }
}
