package apocalypse.fandomcraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class invisible extends Block {
    public invisible() {
        super(Material.iron);
        this.setHardness(0.5F);
        this.setResistance(999.0F);
    }

    public int getRenderBlockPass() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }
}
