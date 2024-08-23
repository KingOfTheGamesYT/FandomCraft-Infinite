package apocalypse.fandomcraft.armour;

import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.Main;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class outfitAdamantium extends ItemArmor {
    private String[] armourTypes = new String[]{"AdamantiumHat", "AdamantiumChest", "AdamantiumLegs", "AdamantiumBoots"};

    public outfitAdamantium(ArmorMaterial material, int renderIndex, int placement) {
        super(material, renderIndex, placement);
        this.setCreativeTab(Main.tabFandomCraftOutfits);
        this.canRepair = true;
        if (placement == 0) {
            this.setTextureName("fandomcraft:AdamantiumHat");
        } else if (placement == 1) {
            this.setTextureName("fandomcraft:AdamantiumChest");
        } else if (placement == 2) {
            this.setTextureName("fandomcraft:AdamantiumLegs");
        } else if (placement == 3) {
            this.setTextureName("fandomcraft:AdamantiumBoots");
        }

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
        if (!stack.getItem().equals(Main.AdamantiumHat) && !stack.getItem().equals(Main.AdamantiumChest) && !stack.getItem().equals(Main.AdamantiumBoots)) {
            return stack.getItem().equals(Main.AdamantiumLegs) ? "fandomcraft:textures/models/armor/adamantium_2.png" : null;
        } else {
            return "fandomcraft:textures/models/armor/adamantium_1.png";
        }
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (stack.getItem() == Main.AdamantiumBoots) {
            int j = EnchantmentHelper.getEnchantmentLevel(HorrorReg.lightfoot.effectId, stack);
            if (j > 0) {
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 10, j - 1));
            }
        }

    }
}
