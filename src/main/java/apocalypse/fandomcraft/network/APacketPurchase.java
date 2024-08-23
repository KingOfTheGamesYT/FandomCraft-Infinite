package apocalypse.fandomcraft.network;

import apocalypse.fandomcraft.main.Tools;
import apocalypse.fandomcraft.player.ExtendedPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class APacketPurchase implements IMessageHandler<APacketPurchase.PurchaseMessage, IMessage> {
    public APacketPurchase() {
    }

    public IMessage onMessage(APacketPurchase.PurchaseMessage message, MessageContext ctx) {
        return message;
    }

    public static class PurchaseMessage implements IMessage {
        public PurchaseMessage() {
        }

        public PurchaseMessage(EntityPlayer player, int price, Item item) {
            ExtendedPlayer props = ExtendedPlayer.get(player);
            Tools.printcon("Selected " + item.getUnlocalizedName() + " at a price of $" + price + ".");
            Tools.printcon("You have $" + props.getMoney() + "/" + price + ".");
            if (props.getMoney() >= price) {
                if (player.inventory.addItemStackToInventory(new ItemStack(item))) {
                    props.spendMoney(price);
                    Tools.printcon("you purchased one " + item.getUnlocalizedName() + " for $" + price + ", and now have " + props.getMoney() + " left.");
                } else {
                    Tools.printcon("You don't have enough room.");
                }
            } else {
                Tools.printcon("You can't afford that.");
            }

        }

        public PurchaseMessage(EntityPlayer player, int price, Item item, int amount) {
            ExtendedPlayer props = ExtendedPlayer.get(player);
            Tools.printcon("Selected " + item.getUnlocalizedName() + " at a price of $" + price + ".");
            Tools.printcon("You have $" + props.getMoney() + "/" + price + ".");
            if (props.getMoney() >= price) {
                if (player.inventory.addItemStackToInventory(new ItemStack(item, amount))) {
                    props.spendMoney(price);
                    Tools.printcon("you purchased " + amount + " " + item.getUnlocalizedName() + "(s) for $" + price + ", and now have " + props.getMoney() + " left.");
                } else {
                    Tools.printcon("You don't have enough room.");
                }
            } else {
                Tools.printcon("You can't afford that.");
            }

        }

        public void fromBytes(ByteBuf buf) {
        }

        public void toBytes(ByteBuf buf) {
        }
    }
}
