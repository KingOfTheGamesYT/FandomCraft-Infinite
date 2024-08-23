package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.main.Main;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class obsidianOre extends Block {
    public obsidianOre() {
        super(Material.rock);
        this.setHardness(12.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 3);
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Main.obsidianChunk;
    }
}
