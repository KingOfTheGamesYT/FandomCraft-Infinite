package apocalypse.fandomcraft.network;

import apocalypse.fandomcraft.player.ExtendedPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class APacketSanity implements IMessageHandler<APacketSanity.SanityMesage, IMessage> {
    public int id;
    public int currentSanity;
    public int maxSanity;

    public APacketSanity() {
    }

    public IMessage onMessage(APacketSanity.SanityMesage message, MessageContext ctx) {
        this.currentSanity = message.currentSanity;
        this.maxSanity = message.maxSanity;
        return message;
    }

    public static class SanityMesage implements IMessage {
        public int id;
        public int currentSanity;
        public int maxSanity;

        public SanityMesage() {
        }

        public SanityMesage(int id, EntityPlayer player) {
            ExtendedPlayer props = ExtendedPlayer.get(player);
            this.id = id;
            this.currentSanity = props.getCurrentSanity();
            this.maxSanity = props.getMaxSanity();
        }

        public void fromBytes(ByteBuf buf) {
            this.id = buf.readInt();
            this.currentSanity = buf.readInt();
            this.maxSanity = buf.readInt();
        }

        public void toBytes(ByteBuf buf) {
            buf.writeInt(this.id);
            buf.writeInt(this.currentSanity);
            buf.writeInt(this.maxSanity);
        }
    }
}
