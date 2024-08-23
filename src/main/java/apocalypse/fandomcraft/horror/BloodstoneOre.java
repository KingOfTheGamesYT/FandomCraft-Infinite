package apocalypse.fandomcraft.horror;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;

public class BloodstoneOre extends Block
{
    public BloodstoneOre() {
        super(Material.rock);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setHarvestLevel("pickaxe", 3);
    }
    
    public int quantityDropped(final Random random) {
        return 2 + random.nextInt(5);
    }
    
    public int quantityDroppedWithBonus(final int maxBonus, final Random random) {
        if (maxBonus > 0 && Item.getItemFromBlock((Block)this) != this.getItemDropped(0, random, maxBonus)) {
            int j = random.nextInt(maxBonus + 2) - 1;
            if (j < 0) {
                j = 0;
            }
            return this.quantityDropped(random) * (j + 2);
        }
        return this.quantityDropped(random);
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return HorrorReg.rustClump;
    }
}
