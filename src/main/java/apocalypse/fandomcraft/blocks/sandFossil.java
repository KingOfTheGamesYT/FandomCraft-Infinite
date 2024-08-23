package apocalypse.fandomcraft.blocks;

import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class sandFossil extends BlockFalling {
    public sandFossil() {
        super(Material.sand);
        this.setHardness(0.5F);
        this.setResistance(999.0F);
        this.setStepSound(soundTypeSand);
        this.setHarvestLevel("shovel", 2);
    }

    public int quantityDropped(Random p_149745_1_) {
        return 1 + p_149745_1_.nextInt(3);
    }

    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_) {
        if (p_149679_1_ > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, p_149679_2_, p_149679_1_)) {
            int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
            if (j < 0) {
                j = 0;
            }

            return this.quantityDropped(p_149679_2_) * (j + 1);
        } else {
            return this.quantityDropped(p_149679_2_);
        }
    }

    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Items.bone;
    }
}
