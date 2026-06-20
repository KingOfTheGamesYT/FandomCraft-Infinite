package apocalypse.fandomcraft.events;

import apocalypse.fandomcraft.entity.*;
import apocalypse.fandomcraft.fable.EntityHobbe;
import apocalypse.fandomcraft.fable.EntityHollowMan;
import apocalypse.fandomcraft.fable.ProjectileBolt;
import apocalypse.fandomcraft.fable.ProjectileBullet;
import apocalypse.fandomcraft.horror.EntityPumpkinBomb;
import apocalypse.fandomcraft.horror.entity.*;
import apocalypse.fandomcraft.items.FCSpawnEgg;
import apocalypse.fandomcraft.main.Main;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;

public class RegistryHandler
{
    public static Item fcSpawnEgg;
    private static int entityId = 0;

    public static CreativeTabs tabFandomCraftMisc;

    public static void preInit()
    {
        registerConfigs();
        registerMaterials();
        registerTabs();
        registerItems();
        registerBlocks();
        registerTileEntities();
    }

    public static void init()
    {
        registerRecipes();
        registerWorldGen();
        registerEvents();
        registerProjectiles();
        registerEntities();
        registerAchievements();
    }

    public static void postInit()
    {
    }

    private static void registerConfigs()
    {
    }

    private static void registerMaterials()
    {
    }

    private static void registerTabs()
    {
        tabFandomCraftMisc = new CreativeTabs("tabFandomCraftMisc")
        {
            @Override
            public Item getTabIconItem()
            {
                return Main.rupeeGreen;
            }
        };
    }

    private static void registerItems()
    {
    }

    private static void registerBlocks()
    {
    }

    private static void registerTileEntities()
    {
    }

    private static void registerRecipes()
    {
    }

    private static void registerWorldGen()
    {
    }

    private static void registerEvents()
    {
    }

    private static void registerProjectiles()
    {
        //Halo
        registerProjectile(EntityEnergyBall.class, "EnergyBall");

        //Kingdom Hearts
        registerProjectile(EntityChakram.class, "Chakram"); //Todo Rename to Eternal Flames

        //Mario
        registerProjectile(EntityKoopaShell.class, "KoopaShell");

        //Marvel
        registerProjectile(EntityPumpkinBomb.class, "PumpkinBombEntity");

        //Metal Gear Solid
        registerProjectile(EntitySmokeBomb.class, "SmokeBomb"); //Todo Rename to Grenade

        //Resident Evil
        registerProjectile(ProjectileBullet.class, "Bullet"); //Todo Rename to Handgun Bullet

        //Skyrim
        registerProjectile(ProjectileBolt.class, "Bolt");

        //Zelda
        registerProjectile(EntityBomb.class, "Bomb");
        registerProjectile(EntityDekuNut.class, "DekuNut");
        registerProjectile(GrappledHook.class, "GrappledHook");
        registerProjectile(EntityPellet.class, "Pellet");

    }

    private static void registerProjectile(Class<? extends Entity> entityClass, String name)
    {
        EntityRegistry.registerModEntity(entityClass, name, entityId++, Main.instance, 64, 1, true);
    }

    private static void registerEntities()
    {
        fcSpawnEgg = new FCSpawnEgg();
        GameRegistry.registerItem(fcSpawnEgg, "fc_spawn_egg");
        BlockDispenser.dispenseBehaviorRegistry.putObject(fcSpawnEgg, new BehaviorSpawnEggDispense());

        //Doctor Who
        createEntity(EntityLGM.class, "EntityLGM", 16777215, 16777215);

        //Fable
        createEntity(EntityHollowMan.class, "EntityHollowMan", 5128747, 16777215);
        createEntity(EntityHobbe.class, "EntityHobbe", 11903890, 12797184);

        //Friday The 13th
        createEntity(EntityJason.class, "EntityJason", 0, 0);

        //Fringe
        createEntity(EntityFBI.class, "EntityFBI", 16777215, 16777215);

        //Halloween
        createEntity(EntityMyers.class, "EntityMyers", 0, 0);

        //Kingdom Hearts
        createEntity(EntityIfrit.class, "Ifrit", 6838581, 14899968);
        createEntity(EntityShadow.class,"Shadow",15,16776960);

        //Left 4 Dead
        createEntity(EntityTank.class,"TANK",16711680,14483533);
        createEntity(EntitySpitter.class,"SPITTER",15685702,14548205);
        createEntity(EntityCharger.class,"CHARGER",13685702,14548205);

        //Mario
        createEntity(EntityKoopa.class,"Koopa",892431, 16777215);
        createEntity(EntityGoomba.class,"Goomba",7888668, 16110193);

        //Metroid
        createEntity(EntityMetroid.class,"Metroid",7667690,8912896);

        //Nightmare on Elm Street
        createEntity(EntityFreddy.class, "EntityFreddy", 0, 0);

        //Pokemon
        createEntity(EntityCharmander.class,"Charmander",16730112,16776960);
        createEntity(EntityDitto.class, "Ditto", 13017551, 14931169);
        createEntity(EntityMew.class,"Mew",16764158,16737021);
        createEntity(EntityPikachu.class,"Pikachu",16775936,6047510);
        createEntity(EntityRegigigas.class,"Regigigas",11272180,16711918);
        createEntity(EntityUnownT.class,"UnownT",551,16777215);
        createEntity(EntityUnownA.class,"UnownA",551,16777215);
        createEntity(EntityUnownB.class,"UnownB",551,16777215);
        createEntity(EntityUnownC.class,"UnownC",551,16777215);
        createEntity(EntityUnownE.class,"UnownE",551,16777215);
        createEntity(EntityUnownEx.class,"UnownEx",551,16777215);
        createEntity(EntityUnownF.class,"UnownF",551,16777215);
        createEntity(EntityUnownG.class,"UnownG",551,16777215);
        createEntity(EntityUnownH.class,"UnownH",551,16777215);
        createEntity(EntityUnownI.class,"UnownI",551,16777215);
        createEntity(EntityUnownJ.class,"UnownJ",551,16777215);
        createEntity(EntityUnownK.class,"UnownK",551,16777215);
        createEntity(EntityUnownP.class,"UnownP",551,16777215);
        createEntity(EntityUnownQu.class,"UnownQu",551,16777215);

        //Resident Evil
        createEntity(EntityMerchantOver.class, "EntityMerchantOver", 16777215, 16777215);
        createEntity(EntityMerchantOther.class, "EntityMerchantOther", 16777215, 16777215);

        //Silent Hill
        createEntity(EntityCultist.class, "EntityCultist", 5128747, 16777215);
        createEntity(EntityBloodhound.class, "EntityBloodhound", 5128747, 16777215); //TODO: Rename to Feral
        createEntity(EntityGreyChild.class, "EntityGreyChild", 5128747, 16777215);
        createEntity(EntityHeretic.class, "EntityHeretic", 5128747, 16777215);
        createEntity(EntityNurse.class, "EntityNurse", 5128747, 16777215);
        createEntity(EntityPyramid.class, "EntityPyramid", 0, 0);
        createEntity(EntityStalker.class, "EntityStalker", 5128747, 16777215);

        //Sonic
        createEntity(EntityChaosBoss.class,"ChaosBoss",11272180,16711918);
        createEntity(EntityDarkChao.class,"DarkChao",9502735,0);
        createEntity(EntityFriendlyChao.class,"FriendlyChao",10157565,16772608);
        createEntity(EntityGreenChao.class,"GreenChao",10420149,56954);
        createEntity(EntityJungleChao.class,"JungleChao",4906496,14275840);
        createEntity(EntityPinkChao.class,"PinkChao",16777215,16711927);

        //Supernatural

        //The Mummy
        createEntity(EntityMummy.class, "EntityMummy", 5128747, 16777215);

        //The Legend of Zelda
        createEntity(EntityArgorok.class,"Argorok",0,8388608);
        createEntity(EntityArmos.class, "Armos",3551054,3604302);
        createEntity(EntityAttackChicken.class,"AttackChicken",16711680,16777215);
        createEntity(EntityAttackPig.class,"AttackPig",16751846,10289259);
        createEntity(EntityBeastGannon.class, "BeastGannon", 69376, 11750400);
        createEntity(EntityBlueTektite.class, "BlueTektite", 466029, 4336196);
        createEntity(EntityBombskit.class, "Bombskit", 3552334, 9502754);
        createEntity(EntityBulbo.class, "Bulbo", 565760, 16711680);
        createEntity(EntityDarknut.class,"Darknut",14476237,4606303);
        createEntity(EntityDarkLink.class,"DarkLink",0,340224);
        createEntity(EntityBokoblin.class,"EntityBokoblin",16775936,6047510);
        createEntity(EntityFireKeese.class,"FireKeese",16734720,16763904);
        createEntity(EntityFreezard.class,"Freezard",16514815,14021887);
        createEntity(EntityGannondorf.class, "Gannondorf", 69376, 11750400);
        createEntity(EntityGohma.class, "Gohma", 4598809, 12669440);
        createEntity(EntityIceKeese.class,"IceKeese",16734720,16763904);
        createEntity(EntityMightyDarknut.class,"MightyDarknut",6169893,4606303);
        createEntity(EntityMiniblin.class, "Miniblin", 7733248, 16775936);
        createEntity(EntityPhantomGannon.class, "PhantomGannon", 69376, 11750400);
        createEntity(EntityPoe.class, "EntityPoe", 5128747, 16777215);
        createEntity(EntityRedead.class,"Redead",5049600, 3820800);
        createEntity(EntityShadowbeast.class, "ShadowBeast", 0, 7733248);
        createEntity(EntityTektite.class,"Tektite",10420224,4336196);
        createEntity(EntityTingle.class,"Tingle",16775936,6047510);
        createEntity(EntityToado.class,"Toado",3552334,9502754);
        createEntity(EntityWolfos.class, "Wolfos", 16514815, 14021887);
        createEntity(EntityZant.class, "Zant", 0, 65508);

        //Boats
        EntityRegistry.registerModEntity(EntityRedLion.class, "RedLion", entityId++, Main.instance, 64, 1, true);
    }

    private static void createEntity(Class<? extends Entity> entityClass, String name, int primary, int secondary)
    {
        EntityRegistry.registerModEntity(entityClass, name, entityId++, Main.instance, 64, 1, true);
        EntityList.stringToClassMapping.put(name, entityClass);
        EntityList.classToStringMapping.put(entityClass, name);
        FCSpawnEgg.registerEntity(entityClass, name, primary, secondary);
    }

    private static void registerAchievements()
    {
    }
}
