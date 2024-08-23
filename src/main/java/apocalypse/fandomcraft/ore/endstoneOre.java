package apocalypse.fandomcraft.ore;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.main.*;

public class endstoneOre extends Block
{
    public endstoneOre() {
        super(Material.rock);
        this.setHardness(5.0f);
        this.setResistance(5.0f);
        this.setStepSound(endstoneOre.soundTypeStone);
        this.setLightLevel(2.0f);
        this.setHarvestLevel("pickaxe", 3);
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Main.voidEssence;
    }
}
