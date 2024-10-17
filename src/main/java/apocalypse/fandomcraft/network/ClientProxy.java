 package apocalypse.fandomcraft.network;
 import apocalypse.fandomcraft.entity.*;

  import apocalypse.fandomcraft.events.CommandFC;
 import apocalypse.fandomcraft.events.CraftingEvent;
 import apocalypse.fandomcraft.events.KeyHandlerEvents;
 import apocalypse.fandomcraft.events.LoadingEvent;
 import apocalypse.fandomcraft.events.PickupEvents;
 import apocalypse.fandomcraft.fable.*;

 import apocalypse.fandomcraft.fable.EntityHollowMan;
 import apocalypse.fandomcraft.fable.RenderHollowMan;
 import apocalypse.fandomcraft.gui.GuiStats;
 import apocalypse.fandomcraft.gui.SanityBar;
 import apocalypse.fandomcraft.horror.EntityPumpkinBomb;
 import apocalypse.fandomcraft.horror.EntityThrowingKnife;
 import apocalypse.fandomcraft.horror.HorrorReg;
 import apocalypse.fandomcraft.horror.TileEntityTrashBin;
 import apocalypse.fandomcraft.horror.entity.*;

  import apocalypse.fandomcraft.main.FConfig;
 import apocalypse.fandomcraft.main.Main;
 import apocalypse.fandomcraft.models.*;

  import apocalypse.fandomcraft.tileEntity.*;

  import cpw.mods.fml.client.registry.ClientRegistry;
 import cpw.mods.fml.client.registry.RenderingRegistry;
 import cpw.mods.fml.common.FMLCommonHandler;
 import cpw.mods.fml.common.network.simpleimpl.MessageContext;
 import cpw.mods.fml.common.registry.EntityRegistry;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.model.ModelBiped;
 import net.minecraft.client.model.ModelChicken;
 import net.minecraft.client.model.ModelPig;
 import net.minecraft.client.renderer.entity.Render;
 import net.minecraft.client.renderer.entity.RenderSnowball;
 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.entity.EnumCreatureType;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.world.biome.BiomeGenBase;
 import net.minecraftforge.client.IItemRenderer;
 import net.minecraftforge.client.MinecraftForgeClient;
 import net.minecraftforge.common.MinecraftForge;

 public class ClientProxy extends ServerProxy {
   public static final LoadingEvent loginEvent = new LoadingEvent();
   public static final CraftingEvent craftingEvent = new CraftingEvent();
   public static final PickupEvents pickupEvent = new PickupEvents();
   public static final KeyHandlerEvents keyBinding = new KeyHandlerEvents();
   public static final CommandFC commands = new CommandFC();

   public void init() {}

   public EntityPlayer getPlayerEntity(MessageContext ctx) {
     return ctx.side.isClient() ? (EntityPlayer)(Minecraft.getMinecraft()).thePlayer : super.getPlayerEntity(ctx);
   }

   public void registerEvents() {
     MinecraftForge.EVENT_BUS.register(pickupEvent);
     FMLCommonHandler.instance().bus().register(pickupEvent);
     MinecraftForge.EVENT_BUS.register(loginEvent);
     FMLCommonHandler.instance().bus().register(loginEvent);
     MinecraftForge.EVENT_BUS.register(craftingEvent);
     FMLCommonHandler.instance().bus().register(craftingEvent);
     MinecraftForge.EVENT_BUS.register(keyBinding);
     FMLCommonHandler.instance().bus().register(keyBinding);
     MinecraftForge.EVENT_BUS.register(commands);
     FMLCommonHandler.instance().bus().register(commands);
     MinecraftForge.EVENT_BUS.register(new SanityBar(Minecraft.getMinecraft()));

     MinecraftForge.EVENT_BUS.register(new GuiStats(Minecraft.getMinecraft()));

     System.out.print("[FandomCraft] Registering multiplayer compatibility");
   }

   public void registerRenderThings() {
     RenderBluePot renderBluePot = new RenderBluePot();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBluePot.class, (TileEntitySpecialRenderer)renderBluePot);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.bluePot), (IItemRenderer)new ItemRenderPot((TileEntitySpecialRenderer)renderBluePot, (TileEntity)new TileEntityBluePot()));

     RenderGannonStatue renderGannonStatue = new RenderGannonStatue();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGannonStatue.class, (TileEntitySpecialRenderer)renderGannonStatue);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.gannonStatue), (IItemRenderer)new ItemRendererGannonStatue((TileEntitySpecialRenderer)renderGannonStatue, (TileEntity)new TileEntityGannonStatue()));

     RenderHeartPot renderHeartPot = new RenderHeartPot();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHeartPot.class, (TileEntitySpecialRenderer)renderHeartPot);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.heartPot), (IItemRenderer)new ItemRenderPot((TileEntitySpecialRenderer)renderHeartPot, (TileEntity)new TileEntityHeartPot()));

     RenderBrownPot renderBrownPot = new RenderBrownPot();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrownPot.class, (TileEntitySpecialRenderer)renderBrownPot);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.brownPot), (IItemRenderer)new ItemRenderPot((TileEntitySpecialRenderer)renderBrownPot, (TileEntity)new TileEntityBrownPot()));

     RenderPC renderPC = new RenderPC();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPC.class, (TileEntitySpecialRenderer)renderPC);

     RenderPlant renderPlant = new RenderPlant();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlant.class, (TileEntitySpecialRenderer)renderPlant);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.Plant), (IItemRenderer)new ItemRenderPlant((TileEntitySpecialRenderer)renderPlant, (TileEntity)new TileEntityPlant()));

     RenderCuttingBoard renderCuttingBoard = new RenderCuttingBoard();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCuttingBoard.class, (TileEntitySpecialRenderer)renderCuttingBoard);

     RenderSkillet renderSkillet = new RenderSkillet();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkillet.class, (TileEntitySpecialRenderer)renderSkillet);

     RenderBoulder renderBoulder = new RenderBoulder();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoulder.class, (TileEntitySpecialRenderer)renderBoulder);

     TileRenderTrashBin tileRenderTrashBin = new TileRenderTrashBin();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrashBin.class, (TileEntitySpecialRenderer)tileRenderTrashBin);

     RenderLargeStoneTable renderLargeStoneTable = new RenderLargeStoneTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLargeStoneTable.class, (TileEntitySpecialRenderer)renderLargeStoneTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.largeStoneTable), (IItemRenderer)new ItemRenderTable((TileEntitySpecialRenderer)renderLargeStoneTable, (TileEntity)new TileEntityLargeStoneTable()));

     RenderLargeBloodstoneTable renderLargeBloodstoneTable = new RenderLargeBloodstoneTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLargeBloodstoneTable.class, (TileEntitySpecialRenderer)renderLargeBloodstoneTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.largeBloodstoneTable), (IItemRenderer)new ItemRenderTable((TileEntitySpecialRenderer)renderLargeBloodstoneTable, (TileEntity)new TileEntityLargeBloodstoneTable()));

     RenderLargeWoodenTable renderLargeWoodenTable = new RenderLargeWoodenTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLargeWoodenTable.class, (TileEntitySpecialRenderer)renderLargeWoodenTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.largeWoodenTable), (IItemRenderer)new ItemRenderTable((TileEntitySpecialRenderer)renderLargeWoodenTable, (TileEntity)new TileEntityLargeWoodenTable()));

     RenderLargeModernTable renderLargeModernTable = new RenderLargeModernTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLargeModernTable.class, (TileEntitySpecialRenderer)renderLargeModernTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.largeModernTable), (IItemRenderer)new ItemRenderTable((TileEntitySpecialRenderer)renderLargeModernTable, (TileEntity)new TileEntityLargeModernTable()));

     RenderLargeMarbleTable renderLargeMarbleTable = new RenderLargeMarbleTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLargeMarbleTable.class, (TileEntitySpecialRenderer)renderLargeMarbleTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.largeMarbleTable), (IItemRenderer)new ItemRenderTable((TileEntitySpecialRenderer)renderLargeMarbleTable, (TileEntity)new TileEntityLargeMarbleTable()));

     RenderLargeLeatherTable renderLargeLeatherTable = new RenderLargeLeatherTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLargeLeatherTable.class, (TileEntitySpecialRenderer)renderLargeLeatherTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.largeLeatherTable), (IItemRenderer)new ItemRenderTable((TileEntitySpecialRenderer)renderLargeLeatherTable, (TileEntity)new TileEntityLargeLeatherTable()));

     RenderSmallStoneTable renderSmallStoneTable = new RenderSmallStoneTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallStoneTable.class, (TileEntitySpecialRenderer)renderSmallStoneTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.smallStoneTable), (IItemRenderer)new ItemRenderTable2((TileEntitySpecialRenderer)renderSmallStoneTable, (TileEntity)new TileEntitySmallStoneTable()));

     RenderSmallBloodstoneTable renderSmallBloodstoneTable = new RenderSmallBloodstoneTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallBloodstoneTable.class, (TileEntitySpecialRenderer)renderSmallBloodstoneTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.smallBloodstoneTable), (IItemRenderer)new ItemRenderTable2((TileEntitySpecialRenderer)renderSmallBloodstoneTable, (TileEntity)new TileEntitySmallBloodstoneTable()));

     RenderSmallWoodenTable renderSmallWoodenTable = new RenderSmallWoodenTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallWoodenTable.class, (TileEntitySpecialRenderer)renderSmallWoodenTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.smallWoodenTable), (IItemRenderer)new ItemRenderTable2((TileEntitySpecialRenderer)renderSmallWoodenTable, (TileEntity)new TileEntitySmallWoodenTable()));

     RenderSmallModernTable renderSmallModernTable = new RenderSmallModernTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallModernTable.class, (TileEntitySpecialRenderer)renderSmallModernTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.smallModernTable), (IItemRenderer)new ItemRenderTable2((TileEntitySpecialRenderer)renderSmallModernTable, (TileEntity)new TileEntitySmallModernTable()));

     RenderSmallMarbleTable renderSmallMarbleTable = new RenderSmallMarbleTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallMarbleTable.class, (TileEntitySpecialRenderer)renderSmallMarbleTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.smallMarbleTable), (IItemRenderer)new ItemRenderTable2((TileEntitySpecialRenderer)renderSmallMarbleTable, (TileEntity)new TileEntitySmallMarbleTable()));

     RenderSmallLeatherTable renderSmallLeatherTable = new RenderSmallLeatherTable();
     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallLeatherTable.class, (TileEntitySpecialRenderer)renderSmallLeatherTable);
     MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.smallLeatherTable), (IItemRenderer)new ItemRenderTable2((TileEntitySpecialRenderer)renderSmallLeatherTable, (TileEntity)new TileEntitySmallLeatherTable()));

     RenderingRegistry.registerEntityRenderingHandler(EntityDarkChao.class, (Render)new RenderDarkChao((ModelBase)new modelChao(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyChao.class, (Render)new RenderFriendlyChao((ModelBase)new modelChao(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityJungleChao.class, (Render)new RenderJungleChao((ModelBase)new modelChao(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityPinkChao.class, (Render)new RenderPinkChao((ModelBase)new modelChao(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityGreenChao.class, (Render)new RenderGreenChao((ModelBase)new modelChao(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityChaosBoss.class, (Render)new RenderChaosBoss((ModelBase)new modelChaos(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, (Render)new RenderShadow((ModelBase)new modelShadow(), 0.0F, 0.3F));
     RenderingRegistry.registerEntityRenderingHandler(EntityKoopa.class, (Render)new RenderKoopa((ModelBase)new modelKoopa(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityPikachu.class, (Render)new RenderPikachu((ModelBase)new modelPikachu(), 0.0F, 0.3F));
     RenderingRegistry.registerEntityRenderingHandler(EntityGoomba.class, (Render)new RenderGoomba((ModelBase)new modelGoomba(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityRedead.class, (Render)new RenderRedead((ModelBase)new modelRedead(), 0.0F, 1.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityDitto.class, (Render)new RenderDitto((ModelBase)new modelDitto(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityMew.class, (Render)new RenderMew((ModelBase)new modelMew(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityAttackPig.class, (Render)new RenderAttackPig((ModelBase)new ModelPig(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityAttackChicken.class, (Render)new RenderAttackChicken((ModelBase)new ModelChicken(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityBulbo.class, (Render)new RenderBulbo((ModelBase)new ModelPig(), 0.0F, 1.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityTektite.class, (Render)new RenderTektite((ModelBase)new modelTektite(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityBlueTektite.class, (Render)new RenderBlueTektite((ModelBase)new modelTektite(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityBokoblin.class, (Render)new RenderBokoblin((ModelBase)new modelBokoblin(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityArmos.class, (Render)new RenderArmos((ModelBase)new modelArmos(), 0.0F, 0.8F));
     RenderingRegistry.registerEntityRenderingHandler(EntityDarkLink.class, (Render)new RenderDarkLink((ModelBase)new modelLink(), 0.0F, 0.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityMetroid.class, (Render)new RenderMetroid((ModelBase)new modelMetroid(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityMiniblin.class, (Render)new RenderMiniblin((ModelBase)new modelMiniblin(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityDarknut.class, (Render)new RenderDarknut((ModelBase)new modelDarknut(), 0.0F, 1.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityMightyDarknut.class, (Render)new RenderMightyDarknut((ModelBase)new modelDarknut(), 0.0F, 2.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityRegigigas.class, (Render)new RenderRegigigas((ModelBase)new modelRegigigas(), 0.0F, 2.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityToado.class, (Render)new RenderToado((ModelBase)new modelToado(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityFreezard.class, (Render)new RenderFreezard((ModelBase)new modelFreezard(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityShadowbeast.class, (Render)new RenderShadowbeast((ModelBase)new modelShadowBeast(), 0.0F, 1.8F));
     RenderingRegistry.registerEntityRenderingHandler(EntityFireKeese.class, (Render)new RenderFireKeese((ModelBase)new modelKeese(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityIceKeese.class, (Render)new RenderIceKeese((ModelBase)new modelIceKeese(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityBombskit.class, (Render)new RenderBombskit((ModelBase)new modelBombskit(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityCharmander.class, (Render)new RenderCharmander((ModelBase)new modelCharmander(), 0.0F, 0.75F));
     RenderingRegistry.registerEntityRenderingHandler(EntityTingle.class, (Render)new RenderTingle((ModelBase)new modelTingle(), 0.0F, 0.75F));
     RenderingRegistry.registerEntityRenderingHandler(EntityWolfos.class, (Render)new RenderWolfos((ModelBase)new modelWolfos(), 0.0F, 2.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityIfrit.class, (Render)new RenderIfrit((ModelBase)new modelIfrit(), 0.0F, 2.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityGohma.class, (Render)new RenderGohma((ModelBase)new modelGohma(), 0.0F, 1.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityGannondorf.class, (Render)new RenderGannondorf((ModelBase)new modelGannondorf(), 0.0F, 1.2F));
     RenderingRegistry.registerEntityRenderingHandler(EntityZant.class, (Render)new RenderZant((ModelBase)new modelZant(), 0.0F, 1.1F));
     RenderingRegistry.registerEntityRenderingHandler(EntityBeastGannon.class, (Render)new RenderBeastGannon((ModelBase)new modelBeastGannon(), 0.0F, 3.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityPhantomGannon.class, (Render)new RenderPhantomGannon((ModelBase)new modelPhantomGannon(), 0.0F, 1.2F));
     RenderingRegistry.registerEntityRenderingHandler(EntityArgorok.class, (Render)new RenderArgorok((ModelBase)new modelArgorok(), 0.0F, 1.0F));

     RenderingRegistry.registerEntityRenderingHandler(EntityUnownA.class, (Render)new RenderUnown((ModelBase)new modelUnownA(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownB.class, (Render)new RenderUnown((ModelBase)new modelUnownB(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownC.class, (Render)new RenderUnown((ModelBase)new modelUnownC(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownE.class, (Render)new RenderUnown((ModelBase)new modelUnownE(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownF.class, (Render)new RenderUnown((ModelBase)new modelUnownF(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownG.class, (Render)new RenderUnown((ModelBase)new modelUnownG(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownH.class, (Render)new RenderUnown((ModelBase)new modelUnownH(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownI.class, (Render)new RenderUnown((ModelBase)new modelUnownI(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownJ.class, (Render)new RenderUnown((ModelBase)new modelUnownJ(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownK.class, (Render)new RenderUnown((ModelBase)new modelUnownK(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownP.class, (Render)new RenderUnown((ModelBase)new modelUnownP(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownT.class, (Render)new RenderUnown((ModelBase)new modelUnownT(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownEx.class, (Render)new RenderUnown((ModelBase)new modelUnownEx(), 0.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityUnownQu.class, (Render)new RenderUnown((ModelBase)new modelUnownQu(), 0.0F));

     RenderingRegistry.registerEntityRenderingHandler(EntityHollowMan.class, (Render)new RenderHollowMan((ModelBase)new modelHollowMan(), 0.0F, 1.0F));
     EntityRegistry.addSpawn(EntityHollowMan.class, FableConfig.spawnHollowMan(), 1, 2, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.coldTaiga, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.frozenRiver, BiomeGenBase.jungle, BiomeGenBase.megaTaiga, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mushroomIsland, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga });

     RenderingRegistry.registerEntityRenderingHandler(EntityHobbe.class, (Render)new RenderHobbe((ModelBase)new modelHobbe(), 0.0F, 0.75F));
     EntityRegistry.addSpawn(EntityHobbe.class, FableConfig.spawnHobbes(), 1, 5, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.coldTaiga, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.frozenRiver, BiomeGenBase.jungle, BiomeGenBase.megaTaiga, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mushroomIsland, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga });

     RenderingRegistry.registerEntityRenderingHandler(EntityMerchantOver.class, (Render)new RenderMerchantOver((ModelBase)new ModelMerchantOver(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityMerchantOther.class, (Render)new RenderMerchantOther((ModelBase)new ModelMerchantOther(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityFBI.class, (Render)new RenderFBI(new ModelFBI(), 0.0F, 1.1F));
     RenderingRegistry.registerEntityRenderingHandler(EntityLGM.class, (Render)new RenderLGM(new ModelLGM(), 0.0F, 0.8F));
     RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, (Render)new RenderMummy((ModelBase)new ModelMummy(), 0.0F, 0.85F));
     RenderingRegistry.registerEntityRenderingHandler(EntityCultist.class, (Render)new RenderCultist(new ModelCultist(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityHeretic.class, (Render)new RenderHeretic(new ModelHeretic(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityNurse.class, (Render)new RenderNurse(new ModelNurse(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityPoe.class, (Render)new RenderPoe((ModelBase)new modelPoe(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityJason.class, (Render)new RenderJason(new ModelJason(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityFreddy.class, (Render)new RenderFreddy(new ModelFreddy(), 0.0F, 1.0F));
     RenderingRegistry.registerEntityRenderingHandler(EntityMyers.class, (Render)new RenderMyers(new ModelMyers(), 0.0F, 1.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityBloodhound.class, (Render)new RenderBloodhound((ModelBase)new ModelBloodhound(), 0.0F, 1.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityGreyChild.class, (Render)new RenderGreyChild(new ModelGreyChild(), 0.0F, 0.5F));
     RenderingRegistry.registerEntityRenderingHandler(EntityStalker.class, (Render)new RenderStalker(new ModelStalker(), 0.0F, 0.8F));
     RenderingRegistry.registerEntityRenderingHandler(EntityPyramid.class, (Render)new RenderPyramid((ModelBase)new ModelPyramid(), 0.0F, 1.6F));

     RenderingRegistry.registerEntityRenderingHandler(EntityRedLion.class, (Render)new RenderRedLion());
   }

   public void spawnMobs() {
     EntityRegistry.addSpawn(EntityFriendlyChao.class, FConfig.mobFriendlyChaoSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F });
     EntityRegistry.addSpawn(EntityDarkChao.class, FConfig.mobDarkChaoSpawn(), 1, 2, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell });
     EntityRegistry.addSpawn(EntityJungleChao.class, FConfig.mobJungleChaoSpawn(), 1, 2, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills });
     EntityRegistry.addSpawn(EntityPinkChao.class, FConfig.mobPinkChaoSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.savanna, BiomeGenBase.roofedForest });
     EntityRegistry.addSpawn(EntityGreenChao.class, FConfig.mobGreenChaoSpawn(), 1, 2, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills });
     EntityRegistry.addSpawn(EntityShadow.class, FConfig.mobShadowSpawn(), 1, 2, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.coldTaiga, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.frozenRiver, BiomeGenBase.jungle, BiomeGenBase.mushroomIsland, BiomeGenBase.sky, BiomeGenBase.swampland, BiomeGenBase.taiga });
     EntityRegistry.addSpawn(EntityPikachu.class, FConfig.mobPikachuSpawn(), 1, 2, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.savanna, BiomeGenBase.roofedForest, BiomeGenBase.forest });
     EntityRegistry.addSpawn(EntityGoomba.class, FConfig.mobGoombaSpawn(), 1, 2, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.roofedForest, BiomeGenBase.desert });
     EntityRegistry.addSpawn(EntityKoopa.class, FConfig.mobKoopaSpawn(), 1, 2, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.jungle, BiomeGenBase.taiga, BiomeGenBase.extremeHills });
     EntityRegistry.addSpawn(EntityAttackPig.class, FConfig.mobAttackPigSpawn(), 1, 2, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.forest, BiomeGenBase.plains, BiomeGenBase.birchForest, BiomeGenBase.river });
     EntityRegistry.addSpawn(EntityAttackChicken.class, FConfig.mobAttackChickenSpawn(), 1, 3, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.forest, BiomeGenBase.plains, BiomeGenBase.savanna, BiomeGenBase.extremeHills });
     EntityRegistry.addSpawn(EntityBokoblin.class, FConfig.mobBokoblinSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.ocean, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.mesa, BiomeGenBase.megaTaiga });
     EntityRegistry.addSpawn(EntityRedead.class, FConfig.mobRedeadSpawn(), 1, 3, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau });
     EntityRegistry.addSpawn(EntityTektite.class, FConfig.mobTektiteSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert, BiomeGenBase.desertHills });
     EntityRegistry.addSpawn(EntityBlueTektite.class, FConfig.mobTektiteSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert });
     EntityRegistry.addSpawn(EntityMiniblin.class, FConfig.mobMiniblinSpawn(), 3, 5, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.hell, BiomeGenBase.megaTaiga });
     EntityRegistry.addSpawn(EntityArmos.class, FConfig.mobArmosSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.extremeHills });
     EntityRegistry.addSpawn(EntityDarknut.class, FConfig.mobDarknutSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.coldBeach, BiomeGenBase.extremeHillsPlus });
     EntityRegistry.addSpawn(EntityToado.class, FConfig.mobToadoSpawn(), 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[] { BiomeGenBase.ocean, BiomeGenBase.deepOcean, BiomeGenBase.forest, BiomeGenBase.plains });
     EntityRegistry.addSpawn(EntityFreezard.class, FConfig.mobFreezardSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver });
     EntityRegistry.addSpawn(EntityFireKeese.class, FConfig.mobKeeseSpawn(), 2, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.hell });
     EntityRegistry.addSpawn(EntityIceKeese.class, FConfig.mobKeeseSpawn(), 2, 3, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver });
     EntityRegistry.addSpawn(EntityBombskit.class, FConfig.mobBombskitSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.savanna, BiomeGenBase.forest, BiomeGenBase.desert });
     EntityRegistry.addSpawn(EntityWolfos.class, FConfig.mobWolfosSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.coldBeach, BiomeGenBase.megaTaiga, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver });
     EntityRegistry.addSpawn(EntityMetroid.class, FConfig.mobMetroidSpawn(), 1, 3, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.hell });

     EntityRegistry.addSpawn(EntityUnownA.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownB.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownC.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownE.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownF.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownG.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownH.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownI.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownJ.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownK.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownP.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownT.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownEx.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityUnownQu.class, FConfig.mobUnownSpawn(), 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.sky });

     EntityRegistry.addSpawn(EntityLGM.class, 50, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityStalker.class, 50, 1, 3, EnumCreatureType.monster, new BiomeGenBase[] { BiomeGenBase.sky });
     EntityRegistry.addSpawn(EntityPoe.class, 50, 1, 2, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.coldTaiga, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.frozenRiver, BiomeGenBase.jungle, BiomeGenBase.mushroomIsland, BiomeGenBase.sky, BiomeGenBase.swampland, BiomeGenBase.taiga });
     EntityRegistry.addSpawn(EntityMerchantOver.class, 25, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.savanna, BiomeGenBase.forest, BiomeGenBase.desert });
   }

   public void registerTileEntitySpecialRenderer() {}

   public void registerItemRenderers() {
     MinecraftForgeClient.registerItemRenderer(Main.masamune, (IItemRenderer)new ItemRendererMasamune());
     MinecraftForgeClient.registerItemRenderer(Main.legendMasterSword, (IItemRenderer)new ItemRendererMasterSword());
     MinecraftForgeClient.registerItemRenderer(Main.keyKingdom, (IItemRenderer)new ItemRendererKingdomKey());
     MinecraftForgeClient.registerItemRenderer(Main.pikoHammer, (IItemRenderer)new ItemRendererPikoHammer());
     MinecraftForgeClient.registerItemRenderer(Main.starHammer, (IItemRenderer)new ItemRendererStarHammer());
     MinecraftForgeClient.registerItemRenderer(Main.koopaShell, (IItemRenderer)new ItemRendererKoopaShell());
     MinecraftForgeClient.registerItemRenderer(Main.cardboardBox, (IItemRenderer)new ItemRendererCardboardBox());
     MinecraftForgeClient.registerItemRenderer(Main.armCannon, (IItemRenderer)new ItemRendererArmCannon());
     MinecraftForgeClient.registerItemRenderer(HorrorReg.giantKnife, (IItemRenderer)new RenderItemGiantKnife());
     RenderingRegistry.registerEntityRenderingHandler(EntitySmokeBomb.class, (Render)new RenderSnowball(Main.smokeGrenade));
     RenderingRegistry.registerEntityRenderingHandler(EntityEnergyBall.class, (Render)new RenderSnowball(Main.energyCrystal));
     RenderingRegistry.registerEntityRenderingHandler(GrappledHook.class, (Render)new RenderSnowball(Main.grapplehook));
     RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, (Render)new RenderSnowball(Main.bomb));
     RenderingRegistry.registerEntityRenderingHandler(EntityPumpkinBomb.class, (Render)new RenderSnowball(HorrorReg.pumpkinBomb));
     RenderingRegistry.registerEntityRenderingHandler(EntityDekuNut.class, (Render)new RenderSnowball(Main.DEKUSEED));
     RenderingRegistry.registerEntityRenderingHandler(EntityPellet.class, (Render)new RenderSnowball(Main.DEKUSEED));
     RenderingRegistry.registerEntityRenderingHandler(EntityChakram.class, (Render)new RenderSnowball(Main.chakram));
     RenderingRegistry.registerEntityRenderingHandler(EntityThrowingKnife.class, (Render)new RenderSnowball(HorrorReg.throwingKnife));
     RenderingRegistry.registerEntityRenderingHandler(ProjectileBullet.class, (Render)new RenderSnowball(Main.shotBullet));
     RenderingRegistry.registerEntityRenderingHandler(EntityKoopaShell.class, (Render)new RenderSnowball(Main.koopaShell));

   }

   public ModelBiped getArmorModel(int id) {
     return null;
   }
 }