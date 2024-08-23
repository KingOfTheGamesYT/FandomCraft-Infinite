package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.main.Main;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class unknownOre extends Block {
    public unknownOre() {
        super(Material.rock);
        this.setHardness(15.0F);
        this.setResistance(200.0F);
        this.setHarvestLevel("pickaxe", 4);
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Main.AppraisingOre;
    }
}
