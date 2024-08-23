
package apocalypse.fandomcraft.network;

import apocalypse.fandomcraft.network.APacketFuel.FuelMesage;
import apocalypse.fandomcraft.network.APacketSanity.SanityMesage;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class APacketHandler {
    public static SimpleNetworkWrapper net;
    private static int nextPacketId = 0;

    public APacketHandler() {
    }

    public static void initPackets() {
        net = NetworkRegistry.INSTANCE.newSimpleChannel("fandomcraft".toUpperCase());
        registerMessage(APacketSanity.class, SanityMesage.class);
        registerMessage(APacketFuel.class, FuelMesage.class);
        registerMessage(APacketGui.class, APacketGui.class);
        registerMessage(APacketPurchase.class, APacketPurchase.class);
    }

    private static void registerMessage(Class packet, Class message) {
        net.registerMessage(packet, message, nextPacketId, Side.CLIENT);
        net.registerMessage(packet, message, nextPacketId, Side.SERVER);
        ++nextPacketId;
    }
}
