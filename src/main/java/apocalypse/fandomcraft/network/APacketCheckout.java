 package apocalypse.fandomcraft.network;

 import apocalypse.fandomcraft.horror.HorrorReg;
 import apocalypse.fandomcraft.main.Main;
 import apocalypse.fandomcraft.main.Tools;
 import apocalypse.fandomcraft.player.ExtendedPlayer;
 import cpw.mods.fml.common.network.simpleimpl.IMessage;
 import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
 import cpw.mods.fml.common.network.simpleimpl.MessageContext;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.entity.EntityClientPlayerMP;
 import net.minecraft.client.gui.FontRenderer;
 import net.minecraft.client.gui.GuiTextField;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ChatComponentText;
 import net.minecraft.util.IChatComponent;

 public class APacketCheckout implements IMessage, IMessageHandler<APacketCheckout, IMessage> {
   private GuiTextField amount1;
   private GuiTextField amount2;
   private GuiTextField amount3;
   private GuiTextField amount4;
   private String text_amount1 = "";
   private String text_amount2 = "";
   private String text_amount3 = "";
   private String text_amount4 = "";

   private int final_amount1 = 0;
   private int final_amount2 = 0;
   private int final_amount3 = 0;
   private int final_amount4 = 0;

   private int paid1 = 0;
   private int paid2 = 0;
   private int paid3 = 0;
   private int paid4 = 0;

   private int totalPrice = 0;

   private FontRenderer font = (Minecraft.getMinecraft()).fontRenderer;

   public APacketCheckout(GuiTextField amount1, GuiTextField amount2, GuiTextField amount3, GuiTextField amount4) {
     Tools.printcon("1: " + amount1 + ", 2:" + amount1 + ", 3:" + amount1 + ", 4:" + amount1 + ".");
     this.amount1 = amount1;
     this.amount2 = amount2;
     this.amount3 = amount3;
     this.amount4 = amount4;
   }

   public void fromBytes(ByteBuf buf) {}

   public void toBytes(ByteBuf buf) {}

   @SideOnly(Side.CLIENT)
   public IMessage onMessage(APacketCheckout message, MessageContext ctx) {
     EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
     ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)entityClientPlayerMP);

     correctValues();
     fixValues();
     convertToInteger();
     checkValues();
     toMoney();

     this.totalPrice = this.paid1 + this.paid2 + this.paid3 + this.paid4;

     if (inventoryHasRoom((EntityPlayer)entityClientPlayerMP))
     {
       if (props.getMoney() >= this.totalPrice) {

         if (this.final_amount1 > 0) ((EntityPlayer)entityClientPlayerMP).inventory.addItemStackToInventory(new ItemStack(HorrorReg.haloOfTheSun, this.final_amount1));
         if (this.final_amount2 > 0) ((EntityPlayer)entityClientPlayerMP).inventory.addItemStackToInventory(new ItemStack(Main.bomb, this.final_amount2));
         if (this.final_amount3 > 0) ((EntityPlayer)entityClientPlayerMP).inventory.addItemStackToInventory(new ItemStack(Main.miningHelmet, this.final_amount3));
         if (this.final_amount4 > 0) ((EntityPlayer)entityClientPlayerMP).inventory.addItemStackToInventory(new ItemStack(HorrorReg.backpack, this.final_amount4));

         props.spendMoney(this.totalPrice);
       }
     }

     return null;
   }

   public void checkout(EntityPlayer player) {
     correctValues();
     fixValues();
     convertToInteger();
     checkValues();
     toMoney();

     this.totalPrice = this.paid1 + this.paid2 + this.paid3 + this.paid4;

     ExtendedPlayer props = ExtendedPlayer.get(player);
     if (inventoryHasRoom(player)) {

       if (props.getMoney() >= this.totalPrice)
       {
         if (this.final_amount1 > 0) player.inventory.addItemStackToInventory(new ItemStack(HorrorReg.haloOfTheSun, this.final_amount1));
         if (this.final_amount2 > 0) player.inventory.addItemStackToInventory(new ItemStack(Main.bomb, this.final_amount2));
         if (this.final_amount3 > 0) player.inventory.addItemStackToInventory(new ItemStack(Main.miningHelmet, this.final_amount3));
         if (this.final_amount4 > 0) player.inventory.addItemStackToInventory(new ItemStack(HorrorReg.backpack, this.final_amount4));

         props.spendMoney(this.totalPrice);
         player.addChatMessage((IChatComponent)new ChatComponentText("Items purchased!"));

       }
       else
       {
         player.addChatMessage((IChatComponent)new ChatComponentText("You can't afford that."));
       }

     } else {

       player.addChatMessage((IChatComponent)new ChatComponentText("You don't have enough room."));
     }
   }

   public void correctValues() {
     this.text_amount1 = this.amount1.getText();
     this.text_amount2 = this.amount2.getText();
     this.text_amount3 = this.amount3.getText();
     this.text_amount4 = this.amount4.getText();

     if (this.amount1.getText().isEmpty())
     {
       this.text_amount1 = "0";
     }
     if (this.amount2.getText().isEmpty())
     {
       this.text_amount2 = "0";
     }
     if (this.amount3.getText().isEmpty())
     {
       this.text_amount3 = "0";
     }
     if (this.amount4.getText().isEmpty())
     {
       this.text_amount4 = "0";
     }
   }

   public void fixValues() {
     if (this.text_amount1.contains("\\D")) {

       Tools.println("Original string: " + this.text_amount1 + " becomes: " + this.text_amount1.replaceAll("\\D", ""));
       this.text_amount1 = this.text_amount1.replaceAll("\\D", "");
       if (this.text_amount1 == null)
       {
         this.text_amount1 = "0";
       }
     }
     if (this.text_amount2.contains("\\D")) {

       Tools.println("Original string: " + this.text_amount2 + " becomes: " + this.text_amount2.replaceAll("\\D", ""));
       this.text_amount2 = this.text_amount2.replaceAll("\\D", "");
       if (this.text_amount2 == null)
       {
         this.text_amount2 = "0";
       }
     }
     if (this.text_amount3.contains("\\D")) {

       Tools.println("Original string: " + this.text_amount3 + " becomes: " + this.text_amount3.replaceAll("\\D", ""));
       this.text_amount3 = this.text_amount3.replaceAll("\\D", "");
       if (this.text_amount3 == null)
       {
         this.text_amount2 = "0";
       }
     }
     if (this.text_amount4.contains("\\D")) {

       Tools.println("Original string: " + this.text_amount4 + " becomes: " + this.text_amount4.replaceAll("\\D", ""));
       this.text_amount4 = this.text_amount4.replaceAll("\\D", "");
       if (this.text_amount4 == null)
       {
         this.text_amount4 = "0";
       }
     }
   }

   public void convertToInteger() {
     this.final_amount1 = Integer.getInteger(this.text_amount1).intValue();
     this.final_amount2 = Integer.getInteger(this.text_amount2).intValue();
     this.final_amount3 = Integer.getInteger(this.text_amount3).intValue();
     this.final_amount4 = Integer.getInteger(this.text_amount4).intValue();
   }

   public void checkValues() {
     int stacks = 0;
     if (this.final_amount1 > 0) stacks++;
     if (this.final_amount2 > 0) stacks++;
     if (this.final_amount3 > 0) stacks++;
     if (this.final_amount4 > 0) stacks++;
     if (this.final_amount1 > 64) this.final_amount1 = 64;
     if (this.final_amount2 > 64) this.final_amount2 = 64;
     if (this.final_amount3 > 64) this.final_amount3 = 64;
     if (this.final_amount4 > 64) this.final_amount4 = 64;

   }

   public void toMoney() {
    this.paid1 = this.final_amount1 * 1500;
     this.paid2 = this.final_amount2 * 50;
     this.paid3 = this.final_amount3 * 500;
     this.paid4 = this.final_amount4 * 750;
   }

   public boolean inventoryHasRoom(EntityPlayer player) {
     int emptySlots = 0;
     int neededSlots = this.final_amount1 + this.final_amount2 + this.final_amount3 + this.final_amount4;
     for (int i = 0; i < 35; i++) {

       if (player.inventory.getStackInSlot(i) != null)
       {
         emptySlots++;
       }
     }
     if (emptySlots > neededSlots)
     {
       return true;
     }
     return false;
   }
 }