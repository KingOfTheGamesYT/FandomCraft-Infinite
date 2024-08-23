package apocalypse.fandomcraft.armour;

import apocalypse.fandomcraft.main.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class miningHelmet extends ItemArmor {
    private String[] armourTypes = new String[]{"Mining Helmet"};

    public miningHelmet(ArmorMaterial material, int renderIndex, int placement) {
        super(material, renderIndex, placement);
        this.canRepair = true;
        if (placement == 0) {
            this.setTextureName("fandomcraft:miningHelmet");
        }

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
        return stack.getItem().equals(Main.miningHelmet) ? "fandomcraft:textures/models/armor/invisibilityCloak_1.png" : null;
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(1) != null) {
            ItemStack slot = player.getCurrentArmor(3);
            if (slot.getItem() == Main.miningHelmet) {
                player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 1, 5, true));
            } else {
                player.removePotionEffect(16);
            }
        }

    }
}
