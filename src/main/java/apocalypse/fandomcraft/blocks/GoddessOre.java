package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.main.Main;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class GoddessOre extends Block {
    public GoddessOre() {
        super(Material.rock);
        this.setHardness(65.0F);
        this.setResistance(1.0F);
        this.setHarvestLevel("pickaxe", 8);
    }

    @Override
    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
    {
        return 6;
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Main.goddessStone;
    }
}
