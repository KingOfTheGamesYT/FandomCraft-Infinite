package apocalypse.fandomcraft.ore;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.main.*;

public class dirtOre extends Block
{
    public dirtOre() {
        super(Material.ground);
        this.setHardness(5.0f);
        this.setResistance(1.0f);
        this.setStepSound(dirtOre.soundTypeGrass);
        this.setLightLevel(2.0f);
        this.setHarvestLevel("spade", 3);
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Main.earthEssence;
    }
}
