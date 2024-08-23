package apocalypse.fandomcraft.armour;

import apocalypse.fandomcraft.main.Main;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class outfitDarkSteel extends ItemArmor {
    private String[] armourTypes = new String[]{"DarkSteelHat", "DarkSteelChest", "DarkSteelLegs", "DarkSteelBoots"};

    public outfitDarkSteel(ItemArmor.ArmorMaterial material, int renderIndex, int placement) {
        super(material, renderIndex, placement);
        this.setCreativeTab(Main.tabFandomCraftOutfits);
        this.canRepair = true;
        if (placement == 0) {
            this.setTextureName("fandomcraft:DarkSteelHat");
        } else if (placement == 1) {
            this.setTextureName("fandomcraft:DarkSteelChest");
        } else if (placement == 2) {
            this.setTextureName("fandomcraft:DarkSteelLegs");
        } else if (placement == 3) {
            this.setTextureName("fandomcraft:DarkSteelBoots");
        }

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
        if (!stack.getItem().equals(Main.DarkSteelHat) && !stack.getItem().equals(Main.DarkSteelChest) && !stack.getItem().equals(Main.DarkSteelBoots)) {
            return stack.getItem().equals(Main.DarkSteelLegs) ? "fandomcraft:textures/models/armor/darkSteel_2.png" : null;
        } else {
            return "fandomcraft:textures/models/armor/darkSteel_1.png";
        }
    }
}
