package apocalypse.fandomcraft.network;

import apocalypse.fandomcraft.gui.ContainerShop;
import apocalypse.fandomcraft.gui.FCGuiContainer;
import apocalypse.fandomcraft.gui.FCGuideHome;
import apocalypse.fandomcraft.gui.FCGuidePage1;
import apocalypse.fandomcraft.gui.FCGuidePage2;
import apocalypse.fandomcraft.gui.FCGuidePage3;
import apocalypse.fandomcraft.gui.FCGuidePage4;
import apocalypse.fandomcraft.gui.FCGuidePage5;
import apocalypse.fandomcraft.gui.FCGuidePage6;
import apocalypse.fandomcraft.gui.FCGuidePage7;
import apocalypse.fandomcraft.gui.FCGuidePage8;
import apocalypse.fandomcraft.gui.FCGuidePage9;
import apocalypse.fandomcraft.gui.GuiBackpack;
import apocalypse.fandomcraft.gui.TravellerShopOtherworld;
import apocalypse.fandomcraft.gui.TravellerShopOverworld;
import apocalypse.fandomcraft.main.Main;
import apocalypse.fandomcraft.player.ContainerBackpack;
import apocalypse.fandomcraft.player.InventoryBackpack;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ServerProxy implements IGuiHandler {
    private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap();

    public ServerProxy() {
    }

    public void init() {
    }

    public void registerEvents() {
    }

    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return ctx.getServerHandler().playerEntity;
    }

    public static EntityPlayer getServerPlayer(MessageContext ctx) {
        return ctx.getServerHandler().playerEntity;
    }

    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == Main.GuiBackpack) {
            return new ContainerBackpack(player, player.inventory, new InventoryBackpack(player.getHeldItem()));
        } else if (id == Main.GuiTravellerOver) {
            return new ContainerShop(player);
        } else {
            return id == Main.GuiTravellerOther ? new ContainerShop(player) : new FCGuiContainer(player);
        }
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == 0) {
            return new FCGuideHome(world, y, z, z, player);
        } else if (id == 1) {
            return new FCGuidePage1(world, y, z, z, player);
        } else if (id == 2) {
            return new FCGuidePage2(world, y, z, z, player);
        } else if (id == 3) {
            return new FCGuidePage3(world, y, z, z, player);
        } else if (id == 4) {
            return new FCGuidePage4(world, y, z, z, player);
        } else if (id == 5) {
            return new FCGuidePage5(world, y, z, z, player);
        } else if (id == 6) {
            return new FCGuidePage6(world, y, z, z, player);
        } else if (id == 7) {
            return new FCGuidePage7(world, y, z, z, player);
        } else if (id == 8) {
            return new FCGuidePage8(world, y, z, z, player);
        } else if (id == 9) {
            return new FCGuidePage9(world, y, z, z, player);
        } else if (id == Main.GuiBackpack) {
            return new GuiBackpack(new ContainerBackpack(player, player.inventory, new InventoryBackpack(player.getHeldItem())));
        } else if (id == Main.GuiTravellerOver) {
            return new TravellerShopOverworld(new ContainerShop(player));
        } else {
            return id == Main.GuiTravellerOther ? new TravellerShopOtherworld(new ContainerShop(player)) : new FCGuiContainer(player);
        }
    }

    public void registerRenderThings() {
    }

    public void spawnMobs() {
    }

    public void registerTileEntitySpecialRenderer() {
    }

    public void registerItemRenderers() {
    }

    public ModelBiped getArmorModel(int id) {
        return null;
    }

    public static void storeEntityData(String name, NBTTagCompound compound) {
        extendedEntityData.put(name, compound);
    }

    public static NBTTagCompound getEntityData(String name) {
        return (NBTTagCompound)extendedEntityData.remove(name);
    }
}
