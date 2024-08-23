package apocalypse.fandomcraft.horror;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentLightfoot extends Enchantment {
    public EnchantmentLightfoot(int id, int rarity) {
        super(id, rarity, EnumEnchantmentType.armor_feet);
        this.setName("lightfoot");
    }

    public int getMinEnchantability(int par) {
        return 15 + (par - 1) * 10;
    }

    public int getMaxEnchantability(int par) {
        return this.getMinEnchantability(par) + 50;
    }

    public int getMaxLevel() {
        return 3;
    }
}
