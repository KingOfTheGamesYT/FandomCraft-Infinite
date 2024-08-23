package apocalypse.fandomcraft.armour;

import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.Main;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Jetpack extends ItemArmor {
    public Minecraft mc = Minecraft.getMinecraft();
    public int ticks = 0;
    private String[] armourTypes = new String[]{"Jetpack"};
    public int t = 0;
    public int slot;
    public ItemStack fuel;

    public Jetpack(ItemArmor.ArmorMaterial material, int renderIndex, int armourType) {
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

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        Random rand = new Random();
        boolean hasFuel = this.getFuel(player);
        if (player.getCurrentArmor(2) != null) {
            if (!hasFuel || player.getCurrentArmor(2).getItem() != this) {
                player.capabilities.allowFlying = false;
                return;
            }

            player.capabilities.allowFlying = true;
            if (player.isAirBorne && !player.capabilities.isCreativeMode) {
                player.velocityChanged = true;
                player.jumpMovementFactor = 5.0E-4F;
                double velx = rand.nextDouble() * 0.05 - 0.025;
                double vely = -0.2;
                double velz = rand.nextDouble() * 0.05 - 0.025;
                world.spawnParticle("flame", player.posX, player.posY, player.posZ, velx, vely, velz);
                world.spawnParticle("largesmoke", player.posX, player.posY, player.posZ, velx, vely, velz);
                this.drainFuel(player, this.fuel);
            }
        }

    }

    public boolean getFuel(EntityPlayer player) {
        if (player.inventory.hasItem(HorrorReg.fuelCanister)) {
            for(int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                if (player.inventory.getStackInSlot(i).getItem() == HorrorReg.fuelCanister) {
                    this.slot = i;
                }
            }

            this.fuel = player.inventory.getStackInSlot(this.slot);
            if (this.fuel.getItemDamage() < this.fuel.getMaxItemUseDuration()) {
                return true;
            }
        }

        return false;
    }

    public void drainFuel(EntityPlayer player, ItemStack stack) {
        if (player.getCurrentArmor(2).getItem() == HorrorReg.jetpack) {
            if (this.ticks >= 20) {
                stack.damageItem(1, player);
                this.ticks = 0;
            } else {
                ++this.ticks;
            }

        } else {
            this.ticks = 0;
        }
    }
}
