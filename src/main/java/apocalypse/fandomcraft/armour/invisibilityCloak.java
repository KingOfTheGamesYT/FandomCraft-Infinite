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

public class invisibilityCloak extends ItemArmor {
    private String[] armourTypes = new String[]{"placeholder0", "invisibilityCloak", "placeholder1", "placeholder2"};

    public invisibilityCloak(ArmorMaterial material, int renderIndex, int placement) {
        super(material, renderIndex, placement);
        this.canRepair = true;
        if (placement == 0) {
            this.setTextureName("fandomcraft:placeholder");
        } else if (placement == 1) {
            this.setTextureName("fandomcraft:invisibilityCloak");
        } else if (placement == 2) {
            this.setTextureName("fandomcraft:placeholder");
        } else if (placement == 3) {
            this.setTextureName("fandomcraft:placeholder");
        }

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
        return stack.getItem().equals(Main.invisibilityCloak) ? "fandomcraft:textures/models/armor/invisibilityCloak_1.png" : null;
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(2) != null) {
            ItemStack cloak = player.getCurrentArmor(2);
            if (cloak.getItem() == Main.invisibilityCloak) {
                player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 10, 1));
                player.stopUsingItem();
            } else {
                player.removePotionEffect(14);
            }
        }

    }
}
