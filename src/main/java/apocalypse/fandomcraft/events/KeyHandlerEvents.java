 package apocalypse.fandomcraft.events;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.client.FMLClientHandler;
 import cpw.mods.fml.client.registry.ClientRegistry;
 import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 import cpw.mods.fml.common.gameevent.InputEvent;
 import java.util.Random;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.entity.EntityClientPlayerMP;
 import net.minecraft.client.gui.GuiChat;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.client.settings.KeyBinding;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.util.ChatComponentText;
 import net.minecraft.util.IChatComponent;
 import net.minecraft.world.World;

 public class KeyHandlerEvents
 {
   public static final String ocarina = "keybinds.ocarina";
   public static final String metroid = "keybinds.weapons";
   public static final String gui = "keybinds.gui";
   public static final int key0 = 79;
   public final KeyBinding bind0;
   public static final int key1 = 80;
   public final KeyBinding bind1;
   public static final int key2 = 81;
   public final KeyBinding bind2;
   public static final int key3 = 75;
   public final KeyBinding bind3;
   public static final int key4 = 76;
   public final KeyBinding bind4;
   public static final int key5 = 77;
   public final KeyBinding bind5;
   public static final int key6 = 71;
   public final KeyBinding bind6;
   public static final int key7 = 72;
   public final KeyBinding bind7;
   public static final int key8 = 35;
   public final KeyBinding bind8;
   public int ticks;

   public KeyHandlerEvents() {
     this.bind0 = new KeyBinding("keybinds.ocarina.lullaby", 79, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind0);
     this.bind1 = new KeyBinding("keybinds.ocarina.saria", 80, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind1);
     this.bind2 = new KeyBinding("keybinds.ocarina.stormsSong", 81, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind2);
     this.bind3 = new KeyBinding("keybinds.ocarina.sunsSong", 75, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind3);
     this.bind4 = new KeyBinding("keybinds.ocarina.nocturne", 76, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind4);
     this.bind5 = new KeyBinding("keybinds.ocarina.healingsong", 77, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind5);
     this.bind6 = new KeyBinding("keybinds.ocarina.bolero", 71, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind6);
     this.bind7 = new KeyBinding("keybinds.ocarina.prelude", 72, "keybinds.ocarina");
     ClientRegistry.registerKeyBinding(this.bind7);

     this.bind8 = new KeyBinding("keybinds.gui.help", 35, "keybinds.gui");
     ClientRegistry.registerKeyBinding(this.bind8);
   }

   @SubscribeEvent
   public void checkKeybind(InputEvent.KeyInputEvent event) {
     EntityClientPlayerMP entityClientPlayerMP = (Minecraft.getMinecraft()).thePlayer;
     WorldClient worldClient = (Minecraft.getMinecraft()).theWorld;

     if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {

       if (this.bind0.isPressed())
       {
         if (((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem() != null && ((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem().getItem() == Main.ocarina && ((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.song1)) {

           if (((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.rupeePurple))
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You played Zelda's Lullaby!"));
             entityClientPlayerMP.playSound("fandomcraft:ocarina.lullaby", 1.0F, 1.0F);
             entityClientPlayerMP.addPotionEffect(new PotionEffect(Potion.heal.getId(), 1, 4, true));
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Traded Rupees for health!"));
             ((EntityPlayer)entityClientPlayerMP).inventory.consumeInventoryItem(Main.rupeePurple);

           }
           else
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("A Purple Rupee is required to restore health."));
           }

         }
         else {

           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can't play that song unless you have the song page and are holding the Ocarina."));
         }
       }
       if (this.bind1.isPressed())
       {
         if (((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem() != null && ((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem().getItem() == Main.ocarina && ((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.song2)) {

           entityClientPlayerMP.playSound("fandomcraft:ocarina.saria", 1.0F, 1.0F);
           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Saria's voice echoes:"));
           Random r = new Random();
           int i = r.nextInt(21);
           if (i == 1)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Rupees, Coins and Rings can all be used to buy different items from villagers."));
           }
           if (i == 2)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Many items can only be obtained from villagers. You'll have to travel all over the world to find certain quest items."));
           }
           if (i == 3)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Trade the Dream Sword for a Keyblade. The Keyblade can be upgraded through regular crafting."));
           }
           if (i == 4)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Trade the Four Sword for the True Four Sword which can be used to obtain Golden Feathers which are required for the Master Sword."));
           }
           if (i == 5)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Find courage deep underground. Find power where monsters swarm. Find wisdom in puzzling pits."));
           }
           if (i == 6)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Use CraftGuide or NEI (Not Enough Items) with this mod to help figure out crafting recipes. Look on the official FandomCraft website to find out detailed info on villager trading."));
           }
           if (i == 7)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can craft higher value Rupees with lower value ones. For example, 5 Green Rupees in any shape makes 1 Blue Rupee."));
           }
           if (i == 8)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Finding an Ooccoo in a chest will allow you to teleport out of a dungeon and return to your spawn point."));
           }
           if (i == 9)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Play other songs on the Ocarina by finding Song Pages in chests or by killing bosses."));
           }
           if (i == 10)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can use the Ocarina to affect the world as often as you like, but you must be holding it to play it."));
           }
           if (i == 11)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Make tons of new foods from wheat products and fruits & vegetables that can be found by cutting down grass and inside chests. Many foods can be sliced to make more ingredients with a Plastic Knife."));
           }
           if (i == 12)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Bosses can spawn in the world either by using a special item or when a certain mob is struck by lightning."));
           }
           if (i == 13)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("If you experience a bug while playing this mod please tell me either on PlanetMinecraft or the official FandomCraft website."));
           }
           if (i == 14)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Help add to this mod by sending in your models, skins, items or code."));
           }
           if (i == 15)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Killing Slimes with different Zelda swords drop different colour Chu Jelly which can be used to make potions."));
           }
           if (i == 16)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Use the Grappling Hook to quickly pull yourself to hard-to-reach location."));
           }
           if (i == 17)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Rupees, Arrows and Bombs can be found by cutting grass."));
           }
           if (i == 18)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("The 6 Chaos Emeralds are found in chests throughout the world. Find them all and combine them to create the Master Emerald that can spawn Chaos."));
           }
           if (i == 19)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("The Power Suit, Hylian and XCOM Armour sets give you powerful buffs when worn, but they render you immobile if you don't have their power source in your inventory."));
           }
           if (i == 20)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Energy Tanks charge the Power Suit. Rupees charge the Hylian Armour. Rings charge the XCOM Armour. But be careful, since the items used to charge them are drained every second the armour is worn."));
           }
           if (i == 21)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You'll need Goddess Stones to craft the Master Sword. To find it you'll have to dig through the Bloodstone layer and find it hidden in bedrock if you're very lucky."));
           }
           if (i == 22)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Some mobs, such as Skeletons or Keese, have a chance of dropping special items used to summon bosses."));
           }
           if (i == 23)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("The Clawshot comes with a spare hook so you can shoot it a second time while latched onto a wall."));
           }
           if (i == 24)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Some weapons are maddeningly expensive or incredibly hard to find, but some bosses can't be killed without them."));
           }
           if (i == 25)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("The Power Suit lets you fire blasts of energy when worn, using additional Energy Tanks as ammo."));
           }
           if (i == 0)
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Saria doesn't feel like talking right now..."));
           }
         }
         else {

           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can't play that song unless you have the song page and are holding the Ocarina."));
         }
       }
       if (this.bind2.isPressed())
       {
         if (((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem() != null && ((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem().getItem() == Main.ocarina && ((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.song3)) {

           entityClientPlayerMP.playSound("fandomcraft:ocarina.stormsSong", 1.0F, 1.0F);
           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You played the Song of Storms!"));
           Random r = new Random();
           int i = r.nextInt(10);
           if (worldClient.isRaining() || worldClient.isThundering())
           {
             worldClient.getWorldInfo().setRaining(false);
             worldClient.getWorldInfo().setThundering(false);
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You cleared the skies."));
           }
           else
           {
             worldClient.getWorldInfo().setRaining(true);
             worldClient.getWorldInfo().setThundering(true);
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You created a storm."));
           }

         }
         else {

           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can't play that song unless you have the song page and are holding the Ocarina."));
         }
       }
       if (this.bind3.isPressed())
       {
         if (((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem() != null && ((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem().getItem() == Main.ocarina && ((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.song4)) {

           if (worldClient.isDaytime())
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Play Nocturne of Shadow to make it nighttime."));
           }
           else
           {
             entityClientPlayerMP.playSound("fandomcraft:ocarina.sunsSong", 1.0F, 1.0F);
             worldClient.setWorldTime(0L);
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You played the Sun's Song!"));
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Look to the morning sun."));
           }

         } else {

           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can't play that song unless you have the song page and are holding the Ocarina."));
         }
       }
       if (this.bind4.isPressed())
       {
         if (((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem() != null && ((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem().getItem() == Main.ocarina && ((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.song5)) {

           if (worldClient.isDaytime())
           {
             entityClientPlayerMP.playSound("fandomcraft:ocarina.nocturne", 1.0F, 1.0F);
             worldClient.setWorldTime(16000L);
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You played the Nocturne of Shadow!"));
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("The sun bows below the horizon."));
           }
           else
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("Play the Sun's Song to make it daytime."));
           }

        } else {

           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can't play that song unless you have the song page and are holding the Ocarina."));
         }
       }
       if (this.bind5.isPressed())
       {
         if (((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem() != null && ((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem().getItem() == Main.ocarina && ((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.song6)) {

           if (worldClient.isRaining() || entityClientPlayerMP.isInWater())
           {
             entityClientPlayerMP.playSound("fandomcraft:ocarina.healingsong", 1.0F, 1.0F);
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You played the Song of Healing!"));
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("The water's power heals your wounds."));
             entityClientPlayerMP.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 15, 1, true));
           }
           else
           {
             entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("This song must draw its power from water."));

           }

         }
         else {

           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can't play that song unless you have the song page and are holding the Ocarina."));
         }
       }
      if (this.bind6.isPressed())
       {

         if (((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem() != null && ((EntityPlayer)entityClientPlayerMP).inventory.getCurrentItem().getItem() == Main.ocarina && ((EntityPlayer)entityClientPlayerMP).inventory.hasItem(Main.song7)) {

           entityClientPlayerMP.playSound("fandomcraft:ocarina.timeSong", 1.0F, 1.0F);
           String time = keepTime((World)worldClient);
           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("The time " + time + "."));
         }
         else {

           entityClientPlayerMP.addChatMessage((IChatComponent)new ChatComponentText("You can't play that song unless you have the song page and are holding the Ocarina."));
         }
       }
       if (this.bind8.isPressed()) {

         int i = (int)((EntityPlayer)entityClientPlayerMP).posX;
         int j = (int)((EntityPlayer)entityClientPlayerMP).posY;
         int k = (int)((EntityPlayer)entityClientPlayerMP).posZ;

         if (entityClientPlayerMP instanceof EntityPlayer) entityClientPlayerMP.openGui(Main.instance, Main.FGuideHome, (World)worldClient, i, j, k);

       }
     }
   }

   public String keepTime(World world) {
     this.ticks = (int)world.getWorldTime();
     if (this.ticks <= 1000)
     {
       return "is approximately 6:00 AM";
     }
     if (this.ticks > 1000 && this.ticks <= 2000)
     {
       return "is approximately 7:00 AM";
     }
     if (this.ticks > 2000 && this.ticks <= 3000)
     {
       return "is approximately 8:00 AM";
     }
     if (this.ticks > 3000 && this.ticks <= 4000)
     {
       return "is approximately 9:00 AM";
     }
     if (this.ticks > 4000 && this.ticks <= 5000)
     {
       return "is approximately 10:00 AM";
     }
     if (this.ticks > 5000 && this.ticks <= 6000)
     {
       return "is approximately 11:00 AM";
     }
     if (this.ticks > 6000 && this.ticks <= 7000)
     {
       return "is approximately 12:00 PM";
     }
     if (this.ticks > 7000 && this.ticks <= 8000)
     {
       return "is approximately 1:00 AM";
     }
     if (this.ticks > 8000 && this.ticks <= 9000)
     {
       return "is approximately 2:00 PM";
     }
     if (this.ticks > 9000 && this.ticks <= 10000)
     {
       return "is approximately 3:00 PM";
     }
     if (this.ticks > 10000 && this.ticks <= 11000)
     {
       return "is approximately 4:00 PM";
     }
     if (this.ticks > 11000 && this.ticks <= 12000)
     {
       return "is approximately 5:00 PM";
     }
     if (this.ticks > 12000 && this.ticks <= 13000)
     {
       return "is approximately 6:00 PM";
     }
     if (this.ticks > 13000 && this.ticks <= 14000)
     {
       return "is approximately 7:00 PM";
     }
     if (this.ticks > 14000 && this.ticks <= 15000)
     {
       return "is approximately 8:00 PM";
     }
     if (this.ticks > 15000 && this.ticks <= 16000)
     {
       return "is approximately 9:00 PM";
     }
     if (this.ticks > 16000 && this.ticks <= 17000)
     {
       return "is approximately 10:00 PM";
     }
     if (this.ticks > 17000 && this.ticks <= 18000)
     {
       return "is approximately 11:00 PM";
     }
     if (this.ticks > 18000 && this.ticks <= 19000)
     {
       return "is approximately 12:00 AM";
     }
     if (this.ticks > 19000 && this.ticks <= 20000)
     {
       return "is approximately 1:00 AM";
     }
     if (this.ticks > 20000 && this.ticks <= 21000)
     {
       return "is approximately 2:00 AM";
     }
     if (this.ticks > 21000 && this.ticks <= 22000)
     {
       return "is approximately 3:00 AM";
     }
     if (this.ticks > 22000 && this.ticks <= 23000)
     {
       return "is approximately 4:00 AM";
     }
     if (this.ticks > 23000)
     {
       return "is approximately 5:00 AM";
     }

     return "cannot be determined. This usually happens if the time command is used or if a different mod affects the ticks in world time. Sleep or play a time song to fix this.";
   }
 }