package apocalypse.fandomcraft.ore;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.main.*;

public class lavaOre extends Block
{
    public lavaOre() {
        super(Material.lava);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
        this.setStepSound(lavaOre.soundTypeSand);
        this.setLightLevel(5.0f);
        this.setHarvestLevel("pickaxe", 3);
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Main.fireEssence;
    }
}
