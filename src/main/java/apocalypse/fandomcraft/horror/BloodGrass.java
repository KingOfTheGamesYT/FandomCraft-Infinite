package apocalypse.fandomcraft.horror;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BloodGrass extends Block {
    public BloodGrass(Material material) {
        super(material);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setStepSound(soundTypeGrass);
        this.setHarvestLevel("shovel", 3);
    }
}