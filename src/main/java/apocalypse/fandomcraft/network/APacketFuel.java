
package apocalypse.fandomcraft.network;

import apocalypse.fandomcraft.player.ExtendedPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class APacketFuel implements IMessageHandler<APacketFuel.FuelMesage, IMessage> {
    public int id;
    public int currentFuel;
    public int maxFuel;

    public APacketFuel() {
    }

    public IMessage onMessage(APacketFuel.FuelMesage message, MessageContext ctx) {
        this.currentFuel = message.currentFuel;
        this.maxFuel = message.maxFuel;
        return message;
    }

    public static class FuelMesage implements IMessage {
        public int id;
        public int currentFuel;
        public int maxFuel;

        public FuelMesage() {
        }

        public FuelMesage(int id, EntityPlayer player) {
            ExtendedPlayer props = ExtendedPlayer.get(player);
            this.id = id;
            this.currentFuel = props.getCurrentFuel();
            this.maxFuel = props.getMaxFuel();
        }

        public void fromBytes(ByteBuf buf) {
            this.id = buf.readInt();
            this.currentFuel = buf.readInt();
            this.maxFuel = buf.readInt();
        }

        public void toBytes(ByteBuf buf) {
            buf.writeInt(this.id);
            buf.writeInt(this.currentFuel);
            buf.writeInt(this.maxFuel);
        }
    }
}
