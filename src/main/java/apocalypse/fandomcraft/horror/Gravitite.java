package apocalypse.fandomcraft.horror;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class Gravitite extends Block {
    public Gravitite() {
        super(Material.rock);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 3);
    }

    public int quantityDropped(Random p_149745_1_) {
        return 2 + p_149745_1_.nextInt(5);
    }

    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_) {
        if (p_149679_1_ > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, p_149679_2_, p_149679_1_)) {
            int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
            if (j < 0) {
                j = 0;
            }

            return this.quantityDropped(p_149679_2_) * (j + 2);
        } else {
            return this.quantityDropped(p_149679_2_);
        }
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return HorrorReg.gravititeDust;
    }
}
