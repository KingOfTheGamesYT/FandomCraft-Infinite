package apocalypse.fandomcraft.player;

import apocalypse.fandomcraft.horror.HorrorReg;
import apocalypse.fandomcraft.main.FConfig2;
import apocalypse.fandomcraft.network.APacketFuel;
import apocalypse.fandomcraft.network.APacketHandler;
import apocalypse.fandomcraft.network.APacketSanity;
import apocalypse.fandomcraft.terraria.TerraReg;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ExtendedPlayerEvents {
    int ticks = 0;

    public ExtendedPlayerEvents() {
    }

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)event.entity) == null) {
            ExtendedPlayer.register((EntityPlayer)event.entity);
        }

    }

    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        Item item = event.item.getEntityItem().getItem();
        ItemStack stack = new ItemStack(item);
        int amount = stack.stackSize;
        EntityPlayer player = (EntityPlayer)event.entity;
        ExtendedPlayer props = ExtendedPlayer.get(player);
        if (item == TerraReg.copper_coin) {
            player.worldObj.playSoundAtEntity(player, "fandomcraft:getCoins", 1.0F, 1.0F);
            props.addMoney(1 * amount);
            event.item.setDead();
            event.setCanceled(true);
        }

        if (item == TerraReg.silver_coin) {
            player.worldObj.playSoundAtEntity(player, "fandomcraft:getCoins", 1.0F, 1.0F);
            props.addMoney(10 * amount);
            event.item.setDead();
            event.setCanceled(true);
        }

        if (item == TerraReg.gold_coin) {
            player.worldObj.playSoundAtEntity(player, "fandomcraft:getCoins", 1.0F, 1.0F);
            props.addMoney(100 * amount);
            event.item.setDead();
            event.setCanceled(true);
        }

        if (item == TerraReg.platinum_coin) {
            player.worldObj.playSoundAtEntity(player, "fandomcraft:getCoins", 1.0F, 1.0F);
            props.addMoney(1000 * amount);
            event.item.setDead();
            event.setCanceled(true);
        }

    }

    @SubscribeEvent
    public void onLivingFallEvent(LivingFallEvent event) {
        if (event.entity instanceof EntityPlayer) {
            ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)event.entity);
            if (event.distance > 3.0F && props.getCurrentSanity() > 0 + (int)event.distance) {
                int loss = (int)(event.distance - event.distance / 4.0F);
                props.consumeSanity((int)event.distance / 2);
            }
        }

    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent event) {
        if (event.entity instanceof EntityPlayer) {
            ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)event.entity);
            props.consumeSanity(1);
        }

    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
            ExtendedPlayer.loadProxyData((EntityPlayer)event.entity);
            IMessage msg1 = new APacketSanity.SanityMesage(500, (EntityPlayer)event.entity);
            APacketHandler.net.sendToServer(msg1);
            IMessage msg2 = new APacketFuel.FuelMesage(501, (EntityPlayer)event.entity);
            APacketHandler.net.sendToServer(msg2);
        }

    }

    @SubscribeEvent
    public void onLivingDeathEvent(LivingDeathEvent event) {
        if (!event.entity.worldObj.isRemote) {
            if (event.entity instanceof EntityPlayer) {
                ExtendedPlayer.saveProxyData((EntityPlayer)event.entity);
            }

            if (event.entity instanceof EntityMob) {
                World world = event.entity.worldObj;
                double x = event.entity.posX;
                double y = event.entity.posY;
                double z = event.entity.posZ;
                Random random = new Random();
                int r = random.nextInt(5);
                EntityItem item = new EntityItem(world, x, y, z, new ItemStack(TerraReg.copper_coin, r));
                event.entity.worldObj.spawnEntityInWorld(item);
            }
        }

    }

    @SubscribeEvent
    public void onClonePlayer(PlayerEvent.Clone event) {
        ExtendedPlayer.get(event.entityPlayer).copy(ExtendedPlayer.get(event.original));
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)event.entity;
            ExtendedPlayer props = ExtendedPlayer.get(player);
            if (player.isPlayerFullyAsleep()) {
                props.replenishSanity();
            }

            if (props.getCurrentSanity() == 0) {
                player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 0, 3, true));
            }

            if (player.dimension == FConfig2.OtherworldID()) {
                if (this.ticks >= 600) {
                    props.consumeSanity(1);
                    this.ticks = 0;
                } else {
                    ++this.ticks;
                }
            }

            if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == HorrorReg.giantKnife) {
                player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 0, 2, true));
            }
        }

    }
}
