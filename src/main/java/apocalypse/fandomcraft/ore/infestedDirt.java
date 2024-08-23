package apocalypse.fandomcraft.ore;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.main.*;

public class infestedDirt extends Block
{
    public infestedDirt() {
        super(Material.ground);
        this.setHardness(1.0f);
        this.setResistance(1.0f);
        this.setStepSound(infestedDirt.soundTypeGrass);
        this.setHarvestLevel("spade", 0);
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Main.worm;
    }
}
