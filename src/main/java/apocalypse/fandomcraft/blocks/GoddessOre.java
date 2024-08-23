package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.main.Main;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class GoddessOre extends Block {
    public GoddessOre() {
        super(Material.rock);
        this.setHardness(65.0F);
        this.setResistance(1.0F);
        this.setHarvestLevel("pickaxe", 8);
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Main.goddessStone;
    }
}
