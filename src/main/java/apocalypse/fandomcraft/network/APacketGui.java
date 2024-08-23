package apocalypse.fandomcraft.network;

import apocalypse.fandomcraft.main.Main;
import apocalypse.fandomcraft.main.Tools;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class APacketGui implements IMessageHandler<APacketGui.GuiMessage, IMessage> {
    public APacketGui() {
    }

    public IMessage onMessage(APacketGui.GuiMessage message, MessageContext ctx) {
        return message;
    }

    public static class GuiMessage implements IMessage {
        public GuiMessage() {
        }

        public GuiMessage(EntityPlayer player) {
            int i = (int)player.posX;
            int j = (int)player.posY;
            int k = (int)player.posZ;
            player.openGui(Main.instance, Main.GuiBackpack, player.worldObj, i, j, k);
            Tools.println("Opening GUI with id of " + Main.GuiBackpack);
        }

        public void fromBytes(ByteBuf buf) {
        }

        public void toBytes(ByteBuf buf) {
        }
    }
}
