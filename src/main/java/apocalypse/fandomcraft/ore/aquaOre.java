package apocalypse.fandomcraft.ore;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.main.*;

public class aquaOre extends Block
{
    public aquaOre() {
        super(Material.water);
        this.setHardness(5.0f);
        this.setResistance(999.0f);
        this.setLightLevel(2.0f);
        this.setHarvestLevel("pickaxe", 3);
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }
    
    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Main.aquaEssence;
    }
}
