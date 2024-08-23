package apocalypse.fandomcraft.player;

import apocalypse.fandomcraft.main.Tools;
import apocalypse.fandomcraft.network.APacketHandler;
import apocalypse.fandomcraft.network.ServerProxy;
import apocalypse.fandomcraft.network.APacketFuel.FuelMesage;
import apocalypse.fandomcraft.network.APacketSanity.SanityMesage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {
    public static final String EXT_PROP_NAME = "ExtendedPlayer";
    public static final int SANITYWATCHER = 20;
    public static final int MONEYWATCHER = 21;
    public static final int FUELWATCHER = 22;
    private final EntityPlayer player;
    private int maxSanity;
    private int maxFuel;

    public ExtendedPlayer(EntityPlayer player) {
        this.player = player;
        this.maxSanity = 50;
        this.maxFuel = 50;
        this.player.getDataWatcher().addObject(20, this.maxSanity);
        this.player.getDataWatcher().addObject(22, this.maxFuel);
        this.player.getDataWatcher().addObject(21, 0);
    }

    public static final void register(EntityPlayer player) {
        player.registerExtendedProperties("ExtendedPlayer", new ExtendedPlayer(player));
    }

    public static final ExtendedPlayer get(EntityPlayer player) {
        return (ExtendedPlayer)player.getExtendedProperties("ExtendedPlayer");
    }

    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = new NBTTagCompound();
        properties.setInteger("CurrentSanity", this.player.getDataWatcher().getWatchableObjectInt(20));
        properties.setInteger("MaxSanity", this.maxSanity);
        properties.setInteger("CurrentFuel", this.player.getDataWatcher().getWatchableObjectInt(22));
        properties.setInteger("MaxFuel", this.maxFuel);
        properties.setInteger("Money", this.player.getDataWatcher().getWatchableObjectInt(21));
        compound.setTag("ExtendedPlayer", properties);
    }

    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = (NBTTagCompound)compound.getTag("ExtendedPlayer");
        this.player.getDataWatcher().updateObject(20, properties.getInteger("CurrentSanity"));
        this.maxSanity = properties.getInteger("MaxSanity");
        this.player.getDataWatcher().updateObject(22, properties.getInteger("CurrentFuel"));
        this.maxSanity = properties.getInteger("MaxFuel");
        this.player.getDataWatcher().updateObject(21, properties.getInteger("Money"));
    }

    public void init(Entity entity, World world) {
    }

    public final boolean consumeSanity(int amount) {
        int sanity = this.player.getDataWatcher().getWatchableObjectInt(20);
        boolean sufficient = amount <= sanity;
        sanity -= amount < sanity ? amount : sanity;
        this.player.getDataWatcher().updateObject(20, sanity);
        return sufficient;
    }

    public final boolean consumeFuel(int amount) {
        int fuel = this.player.getDataWatcher().getWatchableObjectInt(22);
        boolean sufficient = amount <= fuel;
        fuel -= amount < fuel ? amount : fuel;
        this.player.getDataWatcher().updateObject(22, fuel);
        return sufficient;
    }

    public final void replenishSanity() {
        this.player.getDataWatcher().updateObject(20, this.maxSanity);
    }

    public final void replenishFuel() {
        this.player.getDataWatcher().updateObject(22, this.maxFuel);
    }

    public final int getCurrentSanity() {
        return this.player.getDataWatcher().getWatchableObjectInt(20);
    }

    public final int getCurrentFuel() {
        return this.player.getDataWatcher().getWatchableObjectInt(22);
    }

    public final int getMoney() {
        return this.player.getDataWatcher().getWatchableObjectInt(21);
    }

    public final int getMaxSanity() {
        return this.maxSanity;
    }

    public final int getMaxFuel() {
        return this.maxFuel;
    }

    public void addCurrentSanity(int amount) {
        int currentSanity = this.player.getDataWatcher().getWatchableObjectInt(20);
        if (currentSanity + amount < this.maxSanity) {
            Tools.println("Sanity is at " + currentSanity + "/" + this.maxSanity + ".");
            this.player.getDataWatcher().updateObject(20, currentSanity + amount);
            Tools.println("Restored " + amount + " sanity.");
            Tools.println("Sanity is now at " + currentSanity + "/" + this.maxSanity + ".");
        } else {
            this.player.getDataWatcher().updateObject(20, this.maxSanity);
        }

    }

    public void addCurrentFuel(int amount) {
        int currentFuel = this.player.getDataWatcher().getWatchableObjectInt(22);
        if (currentFuel + amount < this.maxFuel) {
            Tools.println("Fuel is at " + currentFuel + "/" + this.maxFuel + ".");
            this.player.getDataWatcher().updateObject(22, currentFuel + amount);
            Tools.println("Restored " + amount + " fuel.");
            Tools.println("Fuel is now at " + currentFuel + "/" + this.maxFuel + ".");
        } else {
            this.player.getDataWatcher().updateObject(22, this.maxFuel);
        }

    }

    public void setMaxSanity(int amount) {
        this.maxSanity = amount > 0 ? amount : 0;
        this.sync();
    }

    public void addMaxSanity(int amount) {
        this.maxSanity += amount;
        this.sync();
    }

    public void setMaxFuel(int amount) {
        this.maxFuel = amount > 0 ? amount : 0;
        this.sync();
    }

    public void addMaxFuel(int amount) {
        this.maxFuel += amount;
        this.sync();
    }

    public void addMoney(int amount) {
        int money = this.player.getDataWatcher().getWatchableObjectInt(21);
        this.player.getDataWatcher().updateObject(21, money + amount);
    }

    public void spendMoney(int amount) {
        int money = this.player.getDataWatcher().getWatchableObjectInt(21);
        this.player.getDataWatcher().updateObject(21, money - amount);
    }

    public final void sync() {
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream(8);
        DataOutputStream outputStream1 = new DataOutputStream(bos1);
        ByteArrayOutputStream bos2 = new ByteArrayOutputStream(8);
        DataOutputStream outputStream2 = new DataOutputStream(bos2);

        try {
            outputStream1.writeInt(this.maxSanity);
            outputStream2.writeInt(this.maxFuel);
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        if (!this.player.worldObj.isRemote) {
            IMessage msg1 = new SanityMesage(500, this.player);
            APacketHandler.net.sendToServer(msg1);
            IMessage msg2 = new FuelMesage(501, this.player);
            APacketHandler.net.sendToServer(msg2);
        }

    }

    public void copy(ExtendedPlayer props) {
        this.player.getDataWatcher().updateObject(20, props.getCurrentSanity());
        this.maxSanity = props.maxSanity;
        this.player.getDataWatcher().updateObject(22, props.getCurrentFuel());
        this.maxFuel = props.maxFuel;
    }

    private static String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + "ExtendedPlayer";
    }

    public static void saveProxyData(EntityPlayer player) {
        ExtendedPlayer playerData = get(player);
        NBTTagCompound savedData = new NBTTagCompound();
        playerData.saveNBTData(savedData);
        ServerProxy.storeEntityData(getSaveKey(player), savedData);
    }

    public static void loadProxyData(EntityPlayer player) {
        ExtendedPlayer playerData = get(player);
        NBTTagCompound savedData = ServerProxy.getEntityData(getSaveKey(player));
        if (savedData != null) {
            playerData.loadNBTData(savedData);
        }

        playerData.sync();
    }
}
