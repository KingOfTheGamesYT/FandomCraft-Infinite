package apocalypse.fandomcraft.zelda;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.util.*;

public class Oocoo extends Item
{
    public Oocoo() {
        this.setMaxStackSize(1);
        this.setMaxDamage(5);
    }
    
    public void addInformation(final ItemStack item, final EntityPlayer player, final List list, final boolean par4) {
        list.add("Use to return home");
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        stack.damageItem(1, (EntityLivingBase)player);
        if (!world.isRemote) {
            teleportHome(world, player);
            world.playSoundAtEntity((Entity)player, "fandomcraft:Darkness", 1.0f, 1.0f);
        }
        return stack;
    }
    
    public static void teleportHome(final World world, final EntityPlayer player) {
        final ChunkCoordinates bedCoords = player.getBedLocation(0);
        final ChunkCoordinates spawnCoords = world.getSpawnPoint();
        final EntityPlayerMP entityplayermp = (EntityPlayerMP)player;
        if (entityplayermp.playerNetServerHandler.netManager.isChannelOpen()) {
            final EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase)entityplayermp, player.posX, player.posY, player.posZ, 5.0f);
            if (!MinecraftForge.EVENT_BUS.post((Event)event)) {
                if (player.isRiding()) {
                    player.mountEntity((Entity)null);
                }
                if (bedCoords == null) {
                    player.setPositionAndUpdate((double)spawnCoords.posX, (double)(spawnCoords.posY + 1), (double)spawnCoords.posZ);
                }
                else {
                    player.setPositionAndUpdate((double)bedCoords.posX, (double)(bedCoords.posY + 1), (double)bedCoords.posZ);
                }
            }
        }
    }
}
