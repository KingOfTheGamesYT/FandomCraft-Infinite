package apocalypse.fandomcraft.horror;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Bloodleaf extends Block {
    public Bloodleaf(Material mat) {
        super(mat);
        this.setHardness(0.3F);
        this.setResistance(0.1F);
        this.setStepSound(soundTypeSand);
    }
}