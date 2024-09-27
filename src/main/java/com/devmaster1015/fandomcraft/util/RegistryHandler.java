package com.devmaster1015.fandomcraft.util;

import com.devmaster1015.fandomcraft.blocks.*;
import com.devmaster1015.fandomcraft.entities.EntityBullet;
import com.devmaster1015.fandomcraft.entities.EntityDekuNut;
import com.devmaster1015.fandomcraft.entities.EntityEnergyBall;
import com.devmaster1015.fandomcraft.entities.EntityWoodSlingshotAmmo;
import com.devmaster1015.fandomcraft.items.*;
import com.devmaster1015.fandomcraft.items.itemtypes.*;
import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.main.events.ArmourEvents;
import com.devmaster1015.fandomcraft.main.events.ArmourEvents.EventType;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistryHandler{
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FandomCraft.MOD_ID);
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FandomCraft.MOD_ID);
        public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, FandomCraft.MOD_ID);
        public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FandomCraft.MOD_ID);

        public static void init() {
            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
            ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
            SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());

        }

        //Sounds
        public static final RegistryObject<SoundEvent> RUPEE_PICKUP = SOUNDS.register("rupee", () -> new SoundEvent(new ResourceLocation(FandomCraft.MOD_ID , "rupee")));
        public static final RegistryObject<SoundEvent> HEART_PICKUP = SOUNDS.register("getheart", () -> new SoundEvent(new ResourceLocation(FandomCraft.MOD_ID , "getheart")));
        public static final RegistryObject<SoundEvent> HAL_SHOOT = SOUNDS.register("hal_shoot", () -> new SoundEvent(new ResourceLocation(FandomCraft.MOD_ID , "hal_shoot")));
        public static final RegistryObject<SoundEvent> EMPTY_CLIP = SOUNDS.register("empty_clip", () -> new SoundEvent(new ResourceLocation(FandomCraft.MOD_ID , "empty_clip")));
        public static final RegistryObject<SoundEvent> ENERGY_SHOOT = SOUNDS.register("energy_shoot", () -> new SoundEvent(new ResourceLocation(FandomCraft.MOD_ID , "energy_shoot")));
        public static final RegistryObject<SoundEvent> ENERGY_HIT = SOUNDS.register("energy_hit", () -> new SoundEvent(new ResourceLocation(FandomCraft.MOD_ID , "energy_hit")));

        //Items
        public static final RegistryObject<AppraisingOre> UNKNOWN_MINERAL = ITEMS.register("unknown_mineral", AppraisingOre::new);
        public static final RegistryObject<Item> APPRAISAL_KIT_BASIC = ITEMS.register("appraisal_kit_basic", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> APPRAISAL_KIT_ADVANCED = ITEMS.register("appraisal_kit_advanced", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> APPRAISAL_KIT_MASTER = ITEMS.register("appraisal_kit_master", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> ELVEN_STEEL_INGOT = ITEMS.register("elven_steel_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> RUPEE_GREEN = ITEMS.register("rupee_green", () -> new Rupee(FandomCraft.tabFandomCraftMisc, Rarity.UNCOMMON).addInfo("A gem of 1 value."));
        public static final RegistryObject<Item> RUPEE_RED = ITEMS.register("rupee_red", () -> new Rupee(FandomCraft.tabFandomCraftMisc, Rarity.UNCOMMON).addInfo("A gem of 20 value."));
        public static final RegistryObject<Item> RUPEE_BLUE = ITEMS.register("rupee_blue", () -> new Rupee(FandomCraft.tabFandomCraftMisc, Rarity.UNCOMMON).addInfo("A gem of 5 value."));
        public static final RegistryObject<Item> RUPEE_ORANGE= ITEMS.register("rupee_orange", () -> new Rupee(FandomCraft.tabFandomCraftMisc).addInfo("A gem of 10 value."));
        public static final RegistryObject<Item> RUPEE_PURPLE = ITEMS.register("rupee_purple", () -> new Rupee(FandomCraft.tabFandomCraftMisc).addInfo("A gem of 50 value."));
        public static final RegistryObject<Item> RUPEE_SILVER = ITEMS.register("rupee_silver", () -> new Rupee(FandomCraft.tabFandomCraftMisc).addInfo("A gem of 200 value."));
        public static final RegistryObject<Item> RUPEE_YELLOW = ITEMS.register("rupee_yellow", () -> new Rupee(FandomCraft.tabFandomCraftMisc).addInfo("A gem of 100 value."));
        public static final RegistryObject<Item> DWARVEN_STEEL_INGOT = ITEMS.register("dwarven_steel_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> HELLSTONE_INGOT = ITEMS.register("hellstone_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> DARKSTEEL_INGOT = ITEMS.register("darksteel_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ENERGY_CRYSTAL = ITEMS.register("energy_crystal", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> FOOLS_GOLD = ITEMS.register("fools_gold", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ADAMANTIUM_INGOT = ITEMS.register("adamantium_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ERIDIUM_INGOT = ITEMS.register("eridium_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ORICHULUM_INGOT = ITEMS.register("orichulum_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials));
        public static final RegistryObject<Item> ESSENCE_OF_NATURE = ITEMS.register("nature_essence", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> WORM = ITEMS.register("worm", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> BLUE_BERRY = ITEMS.register("blueberry", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(2,1).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(4,1).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(3,0.8F).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(3,1).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> GREEN_PEPPER = ITEMS.register("green_pepper", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(5,1).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> RED_PEPPER = ITEMS.register("red_pepper", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(5,1).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> DAMP_MULCH = ITEMS.register("damp_mulch", DampMulch::new);
        public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic", () -> new Consumable( 64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(2,0.2F).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> HEART = ITEMS.register("heart", () -> new Consumable(1, Rarity.COMMON).useInstantly().health(2).setUseSound(() -> HEART_PICKUP.get()));
        public static final RegistryObject<Item> BULLET = ITEMS.register("bullet", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> HALS_RIFLE = ITEMS.register("hals_rifle", () -> new HalsRifle(2,2000, RegistryHandler.BULLET.get(), Items.AIR));
        public static final RegistryObject<Item> AXE_OF_DISHARMONY = ITEMS.register("axe_of_disharmony", () -> new Sword(new ModdedTier(4000, 14, 1,1.6F).material(Items.AIR), Rarity.COMMON).build(0, 0).addInfo("Heavy metal slayage"));
        public static final RegistryObject<Item> PICKHAMMER = ITEMS.register("pickhammer", () -> new Pickaxe(new ModdedTier(2250, 8, 15, 1.6F).level(5).enchanting(20).material(Items.AIR), Rarity.COMMON).build(0, 0));
        public static final RegistryObject<Item> GREAT_AXE = ITEMS.register("greataxe", () -> new Axe(new ModdedTier(720, 8, 15, 1.6F).level(5).enchanting(20).material(Items.AIR), Rarity.COMMON).build(0, 0));
        public static final RegistryObject<Item> AVOS_TEAR = ITEMS.register("avostear", () -> new Sword(new ModdedTier(2400, 14, 1,1.6F).material(Items.AIR), Rarity.COMMON).build(0, 0).addInfo("The hidden sword"));
        public static final RegistryObject<Item> SWORD_OF_AEONS = ITEMS.register("sword_of_aeons", () -> new Sword(new ModdedTier(4000, 14, 1,1.6F).material(Items.AIR), Rarity.COMMON).build(0, 0).addInfo("The power of Albion"));
        public static final RegistryObject<Item> HARBINGER = ITEMS.register("harbinger", () -> new Sword(new ModdedTier(4000, 14, 1,1.6F).material(Items.AIR), Rarity.COMMON).build(0, 0).addInfo("...of death"));
        public static final RegistryObject<Item> BOLT = ITEMS.register("bolt", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> JET = ITEMS.register("jet", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> ENERGY_TANK = ITEMS.register("energy_tank", () -> new FItem(FandomCraft.tabFandomCraftMisc));
        public static final RegistryObject<Item> ARM_CANNON = ITEMS.register("arm_cannon", () -> new HandCannon("Arm Cannon",14,1200, RegistryHandler.ENERGY_CRYSTAL.get(), RegistryHandler.ENERGY_TANK.get(), Items.AIR).addInfo("Requires Energy Tanks and Crystals as ammo"));
        public static final RegistryObject<Item> DEKUSEED = ITEMS.register("dekuseed", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON).addInfo("Not edible or plantable, but hard", "enough to use as slingshot ammo."));
        public static final RegistryObject<Item> WOODEN_SLINGSHOT = ITEMS.register("wooden_slingshot", () -> new WoodSlingshot(4,32, RegistryHandler.DEKUSEED.get(), Items.STICK));
        public static final RegistryObject<Item> DEKUNUT = ITEMS.register("dekunut", () -> new DekuNut(1, Rarity.COMMON).addInfo("Stuns enemies when thrown.", "Or can be crushed to reveal", "the inedible seeds inside."));
        public static final RegistryObject<Item> FAIRY_SLINGSHOT = ITEMS.register("fairy_slingshot", () -> new WoodSlingshot(5,56, RegistryHandler.DEKUSEED.get(), Items.STICK));
        public static final RegistryObject<Item> OCARINA = ITEMS.register("ocarina", () -> new FItem( 1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<ArmorItem> ROCKET_BOOTS = ITEMS.register("rocket_boots", () -> new Armour(new ArmourTier("fandomcraft:rocket_boots", 1, 1, 1, 1.0f, 0.1f, false, Items.AIR), EquipmentSlotType.FEET, Rarity.COMMON).addEffect(new ArmourEvents(EventType.Auto, null, (player, enemy, source, helditem) -> Tools.addEffect(player, Effects.JUMP_BOOST, 0, 0, false))).isSet(0, 1));
        public static final RegistryObject<ArmorItem> SONIC_SNEAKERS = ITEMS.register("sonic_sneakers", () -> new Armour(new ArmourTier("fandomcraft:sonic_sneakers", 1, 1, 1, 1.0f, 0.1f, false, Items.AIR), EquipmentSlotType.FEET, Rarity.COMMON).addEffect(new ArmourEvents(EventType.Auto, null, (player, enemy, source, helditem) -> Tools.addEffect(player, Effects.SPEED, 3, 0, false))).isSet(1, 1));
        public static final RegistryObject<ArmorItem> INVISIBILITY_CLOAK = ITEMS.register("invisibility_cloak", () -> new Armour(new ArmourTier("fandomcraft:mining_helmet", 1, 1, 0, 1.0f, 0.1f, false, Items.AIR), EquipmentSlotType.CHEST, Rarity.COMMON).addEffect(new ArmourEvents(EventType.Auto, null, (player, enemy, source, helditem) -> Tools.addEffect(player, Effects.INVISIBILITY, 1, 10, false))).isSet(2, 1));
        public static final RegistryObject<ArmorItem> MINING_HELMET = ITEMS.register("mining_helmet", () -> new Armour(new ArmourTier("fandomcraft:mining_helmet", 34, 4, 15, 0.0f, 0.0f, false, Items.AIR), EquipmentSlotType.HEAD, Rarity.COMMON).addEffect(new ArmourEvents(EventType.Auto, null, (player, enemy, source, helditem) -> Tools.addEffect(player, Effects.NIGHT_VISION, 0, 20, false))).isSet(3, 1));
        public static final RegistryObject<ArmorItem> DARKSTEEL_GREAVES = ITEMS.register("darksteel_legs", () -> new Armour(new ArmourTier("fandomcraft:dark_steel", 38, 8, 15, 0.0f, 0.0f, false, Items.AIR), EquipmentSlotType.LEGS, Rarity.COMMON));
        public static final RegistryObject<Item> CHAOS_GREY = ITEMS.register("chaos_grey", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> CHAOS_RED = ITEMS.register("chaos_red", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> CHAOS_PURPLE = ITEMS.register("chaos_purple", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> CHAOS_GREEN = ITEMS.register("chaos_green", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> CHAOS_BLUE = ITEMS.register("chaos_blue", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> CHAOS_YELLOW = ITEMS.register("chaos_yellow", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> PAOPU = ITEMS.register("paopu", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(10,1.0F).meat().action(UseAction.EAT).addInfo("Connecting friends' hearts since 2001!"));
        public static final RegistryObject<Item> CHESTNUT = ITEMS.register("chestnut", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(5,1.0F).meat().action(UseAction.EAT));
        public static final RegistryObject<Item> RED_VINE = ITEMS.register("red_vine", () -> new Consumable(64, Rarity.COMMON, FandomCraft.tabFandomCraftfood).hunger(20,1.0F).setAlwaysEdible(true).meat().action(UseAction.EAT).addInfo("Delicacy of parallel universes since 2008!"));
        public static final RegistryObject<Item> DREAM_SWORD = ITEMS.register("dream_sword", () -> new Sword(new ModdedTier(1, 5, 1,1.6F).enchanting(50).material(Items.AIR), Rarity.COMMON).build(0, 0));
        public static final RegistryObject<Item> PRACTICE_SSWORD = ITEMS.register("practice_sword", () -> new Sword(new ModdedTier(250, 6, 6,1.6F).level(2).enchanting(14).material(Items.AIR), Rarity.COMMON).build(0, 0));
        public static final RegistryObject<Item> ANTI_VENOM = ITEMS.register("antivenom", () -> new Consumable(24, Rarity.COMMON).hunger(0,0F).setAlwaysEdible(true).action(UseAction.DRINK).removeEffect(Effects.POISON).removeEffect(Effects.MINING_FATIGUE).removeEffect(Effects.SLOWNESS).removeEffect(Effects.NAUSEA).removeEffect(Effects.HUNGER).removeEffect(Effects.WEAKNESS).removeEffect(Effects.WITHER));
        public static final RegistryObject<Item> TRIFORCE_OF_POWER = ITEMS.register("triforce_of_power", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON).addInfo("Power"));
        public static final RegistryObject<Item> TRIFORCE_OF_COURAGE = ITEMS.register("triforce_of_courage", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON).addInfo("Courage"));
        public static final RegistryObject<Item> TRIFORCE_OF_WISDOM = ITEMS.register("triforce_of_wisdom", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON).addInfo("Wisdom"));
        public static final RegistryObject<Item> BLADE = ITEMS.register("blade", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> HILT = ITEMS.register("hilt", () -> new FItem(1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> INSIGNIA = ITEMS.register("insignia", () -> new FItem( 1, FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> LOST_ILLUSION = ITEMS.register("lost_illusion", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> MANIFEST_ILLUSION = ITEMS.register("manifest_illusion", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> SOUL_EATER = ITEMS.register("soul_eater", () -> new Sword(new ModdedTier(1, 13, 1,1.6F).level(3).material(Items.AIR), Rarity.COMMON).build(0, 0));
        public static final RegistryObject<Item> SOUL = ITEMS.register("soul", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> DARK_HEART = ITEMS.register("dark_heart", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> PURE_HEART = ITEMS.register("pure_heart", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> SOUL_HARNESS = ITEMS.register("soul_harness", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> UNOBTAINIUM_INGOT = ITEMS.register("unobtainium_ingot", () -> new FItem(FandomCraft.tabFandomCraftMaterials, Rarity.COMMON));
        public static final RegistryObject<Item> SOUL_STONE = ITEMS.register("soul_stone", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));
        public static final RegistryObject<Item> RAGING_SOUL = ITEMS.register("raging_soul", () -> new FItem(FandomCraft.tabFandomCraftMisc, Rarity.COMMON));

        //Entities
        public static final RegistryObject<EntityType<EntityBullet>> BULLET_ENTITY =
                ENTITIES.register("bullet", () -> EntityType.Builder.
                                <EntityBullet>create(EntityBullet::new, EntityClassification.MISC)
                        .size(0.25f, 0.25f)
                        .trackingRange(4)
                        .updateInterval(4)
                        .build(new ResourceLocation(FandomCraft.MOD_ID, "bullet").toString()));
        public static final RegistryObject<EntityType<EntityEnergyBall>>ENERGY_BALL_ENTITY =
                ENTITIES.register("energy_crystal", () -> EntityType.Builder.
                                <EntityEnergyBall>create(EntityEnergyBall::new, EntityClassification.MISC)
                        .size(0.25f, 0.25f)
                        .trackingRange(4)
                        .updateInterval(4)
                        .build(new ResourceLocation(FandomCraft.MOD_ID, "energy_crystal").toString()));
        public static final RegistryObject<EntityType<EntityWoodSlingshotAmmo>>WOOD_SLINGSHOT_AMMO =
                ENTITIES.register("slingshotammo", () -> EntityType.Builder.
                                <EntityWoodSlingshotAmmo>create(EntityWoodSlingshotAmmo::new, EntityClassification.MISC)
                        .size(0.25f, 0.25f)
                        .trackingRange(4)
                        .updateInterval(4)
                        .build(new ResourceLocation(FandomCraft.MOD_ID, "slingshotammo").toString()));
        public static final RegistryObject<EntityType<EntityDekuNut>>DEKUNUT_ENTITY =
                ENTITIES.register("dekunut", () -> EntityType.Builder.
                                <EntityDekuNut>create(EntityDekuNut::new, EntityClassification.MISC)
                        .size(0.25f, 0.25f)
                        .trackingRange(4)
                        .updateInterval(4)
                        .build(new ResourceLocation(FandomCraft.MOD_ID, "dekunut").toString()));

        //Spawn Eggs

        //Tools

        //Blocks
        public static final RegistryObject<Block> ADAMANTIUM_ORE_BLOCK = registerBlock("adamantium_ore", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(20.0F, 5.0F).harvestLevel(6).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> ROCK_STONE_BLOCK = registerBlock("rock", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 12.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> GODDESS_ORE_BLOCK = registerBlock("goddessoreblock", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(65,1).harvestTool(ToolType.PICKAXE).harvestLevel(8).setRequiresTool(), 6));
        public static final RegistryObject<Block> UNKNOWN_ORE_BLOCK = registerBlock("unknown_ore", unknownOre::new);
        public static final RegistryObject<Block> HELLSTONE_ORE_BLOCK = registerBlock("hellstone_ore", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(25.0F, 5.0F).harvestLevel(6).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> FOOLS_GOLD_ORE_BLOCK = registerBlock("fools_gold_ore", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> ERIDIUM_ORE_BLOCK = registerBlock("eridium_ore", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(17.0F, 5.0F).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> HALITE = registerBlock("halite", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(4.0F, 1.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> MYTHRIL_ORE = registerBlock("mythril_ore", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(14.0F, 5.0F).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> ORICHULUM_ORE = registerBlock("orichulum_ore", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(10.0F, 5.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));
        public static final RegistryObject<Block> PEARL_STONE_BLOCK = registerBlock("pearlstone", PearlStone::new);
        public static final RegistryObject<Block> UNOBTAINIUM_ORE = registerBlock("unobtainium_ore", () -> new FBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(25.0F, 5.0F).harvestLevel(7).harvestTool(ToolType.PICKAXE).setRequiresTool(), 0));

        //Block Items
        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
                RegistryObject<T> toReturn = BLOCKS.register(name, block);
                registerBlockItem(name, toReturn);
                return toReturn;
        }
        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
                return RegistryHandler.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(FandomCraft.tabFandomCraftBlocks)));
        }

        //Dimensions
}