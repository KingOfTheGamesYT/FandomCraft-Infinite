package apocalypse.fandomcraft.armour;

import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.Main;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.World;

public class JokePack extends ItemArmor {
    private String[] armourTypes = new String[]{"Jetpack"};

    public JokePack(ArmorMaterial material, int renderIndex, int armourType) {
        super(material, renderIndex, armourType);
        this.setCreativeTab(Main.tabFandomCraftOutfits);
        this.canRepair = true;
        if (armourType == 1) {
            this.setTextureName("fandomcraft:jetpack");
        }

    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
        return stack.getItem().equals(HorrorReg.jetpack) ? "fandomcraft:textures/models/armor/jetpack.png" : null;
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        Random rand = new Random();
        if (player.inventory.hasItem(HorrorReg.gravititeDust)) {
            player.capabilities.allowFlying = true;
        } else {
            player.capabilities.allowFlying = false;
        }

        if (player.inventory.hasItem(HorrorReg.gravititeDust)) {
            if (player.isAirBorne) {
                player.velocityChanged = true;
                player.motionY *= 2.0D;
                player.jumpMovementFactor = 0.005F;
                player.worldObj.spawnParticle("flame", player.posX, player.posY, player.posZ, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
                player.worldObj.spawnParticle("lava", player.posX, player.posY, player.posZ, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
                player.inventory.consumeInventoryItem(HorrorReg.gravititeDust);
            }

            if ((player.inventory.armorItemInSlot(2) == null || player.inventory.armorItemInSlot(2).getItem() != HorrorReg.jetpack) && player.capabilities.allowFlying) {
                player.capabilities.allowFlying = false;
            }
        }

    }

    public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        EntityPlayer player = (EntityPlayer)entity;
    }
}

