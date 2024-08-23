package apocalypse.fandomcraft.horror;


import apocalypse.fandomcraft.main.Main;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class ItemJetpack extends ItemArmor {
    int delay = 0;

    public ItemJetpack(ArmorMaterial material, int renderIndex, int armourType) {
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

    public boolean hasFuel(EntityPlayer player) {
        return player.inventory.hasItem(HorrorReg.gravititeDust);
    }

    public void consumeFuel(EntityPlayer player, int rate) {
        ++this.delay;
        if (this.delay > rate) {
            if (player.inventory.hasItem(HorrorReg.gravititeDust)) {
                player.inventory.consumeInventoryItem(HorrorReg.gravititeDust);
            }

            this.delay = 0;
        }

    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (player != null) {
            ItemStack item = player.inventory.armorItemInSlot(2);
            if (item != null && item.getItem() instanceof ItemJetpack) {
                ((ItemJetpack)item.getItem()).action(player, (int)player.posX, (int)player.posY, (int)player.posZ, true);
            }

        }
    }

    public void action(EntityPlayer player, int x, int y, int z, boolean key) {
        Random rand = new Random();
        double velx = rand.nextDouble() * 0.05D - 0.025D;
        double vely = -0.2D;
        double velz = rand.nextDouble() * 0.05D - 0.025D;
        if (Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode()) && this.hasFuel(player)) {
            player.motionY = 0.1D;
            player.jumpMovementFactor = 0.05F;
            player.worldObj.spawnParticle("flame", player.posX, player.posY - 1.0D, player.posZ, velx, vely, velz);
            player.worldObj.spawnParticle("largesmoke", player.posX, player.posY - 1.0D, player.posZ, velx, vely, velz);
            this.consumeFuel(player, 10);
        }

        player.fallDistance = 0.0F;
    }
}
