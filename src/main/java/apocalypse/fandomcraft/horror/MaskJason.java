
package apocalypse.fandomcraft.horror;

import apocalypse.fandomcraft.main.Main;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class MaskJason extends ItemArmor {
    private String[] armourTypes = new String[]{"jasonMask"};
    public int t = 0;

    public MaskJason(ArmorMaterial material, int renderIndex, int armourType) {
        super(material, renderIndex, armourType);
        this.setCreativeTab(Main.tabFandomCraftOutfits);
        this.canRepair = true;
        if (armourType == 3) {
            this.setTextureName("fandomcraft:jasonMask");
        }

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
        return stack.getItem().equals(HorrorReg.maskJason) ? "fandomcraft:textures/models/armor/maskJason.png" : null;
    }
}
