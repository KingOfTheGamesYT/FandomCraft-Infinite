package apocalypse.fandomcraft.world;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import apocalypse.fandomcraft.structures.*;
import apocalypse.fandomcraft.main.*;
import apocalypse.fandomcraft.fable.*;

public class UndergroundOres implements IWorldGenerator
{
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1: {
                this.generateInNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 0: {
                this.generateInOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 1: {
                this.generateInEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 2: {
                this.generateInOtherworld(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
        }
    }
    
    private void generateInEnd(final World world, final Random random, final int x, final int z) {
        for (int i = 0; i < 2; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(256);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.endstoneOre, 2, Blocks.end_stone).generate(world, random, chunkX, chunkY, chunkZ);
        }
    }
    
    private void generateInOverworld(final World world, final Random random, final int x, final int z) {
        for (int i = 0; i < 12; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(35);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.oreFossil, 1).generate(world, random, chunkX, chunkY, chunkZ);
            new WorldGenMinable(Main.pearlstone, 8).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 6; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(60);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.orichulumOre, 4).generate(world, random, chunkX, chunkY, chunkZ);
            new WorldGenMinable(Main.mythrilOre, 2).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 4; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(30);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.eridiumOre, 6).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 2; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(20);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.unobtainiumOre, 4).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 2; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(12);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.adamantiumOre, 3).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 5; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(128);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.unknownOre, 5).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 6; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = 10 + random.nextInt(39); // Adjust Y to spawn between 10 and 48
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.GoddessOre, 2, Blocks.stone).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 2; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(80);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.aquaOre, 2, Blocks.water).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 8; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(68);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.sandFossil, 5, (Block)Blocks.sand).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 1; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(80);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.dirtOre, 2, Blocks.dirt).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 16; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(128);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.infestedDirt, 2, Blocks.dirt).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 1; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(64);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.lavaOre, 2, Blocks.lava).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 2; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(32);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.foolsGoldOre, 6, Blocks.stone).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 50; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(60);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.halite, 10, (Block)Blocks.sand).generate(world, random, chunkX, chunkY, chunkZ);
        }
        final DungeonRaft raft = new DungeonRaft();
        final DungeonDekuTree deku = new DungeonDekuTree();
        final DungeonWater water = new DungeonWater();
        final DungeonFire fire = new DungeonFire();
        final DungeonIce ice = new DungeonIce();
        final DungeonDesert desert = new DungeonDesert();
        final DungeonSky sky = new DungeonSky();
        final DungeonCrypt crypt = new DungeonCrypt();
        final DungeonGuardTower guard = new DungeonGuardTower();
        final DungeonRoyalHall royal = new DungeonRoyalHall();
        final DungeonTwilightGate gate = new DungeonTwilightGate();
        final DungeonFairyIsland fairy = new DungeonFairyIsland();
        final WaterTempleBase waterTemple = new WaterTempleBase();
        final DungeonGannon gannon = new DungeonGannon();
        final Random r = new Random();
        final int chance = r.nextInt(500);
        final int chance2 = r.nextInt(1000);
        final int lowerChance = r.nextInt(2000);
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.bokoblinPirate()) {
                raft.generateSurface(world, random, chunkX2, chunkZ2, chunkY2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.dekuTreeDungeon()) {
                deku.generateSurface(world, random, chunkX2, chunkZ2, chunkY2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (lowerChance < FConfig.waterDungeon()) {
                water.generateSurface(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.fireDungeon()) {
                fire.generateSurface(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.iceDungeon()) {
                ice.generateSurface(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
      /*  for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.desertDungeon()) {
                desert.generateSurface(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }*/
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (lowerChance < FConfig.skyDungeon()) {
                sky.generateStart(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (lowerChance < FConfig.fairyIsland()) {
                fairy.generateStart(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.royalHall()) {
                royal.generateSurface(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.crypt()) {
                crypt.generateStart(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.guardTower()) {
                guard.generateSurface(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x + random.nextInt(16);
            final int chunkZ2 = z + random.nextInt(16);
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.twilightGate()) {
                gate.generateStart(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x;
            final int chunkZ2 = z;
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (chance < FConfig.waterTemple()) {
                waterTemple.generateSurface(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        for (int j = 0; j < 1; ++j) {
            final int chunkX2 = x;
            final int chunkZ2 = z;
            final int chunkY2 = world.getHeightValue(chunkX2, chunkZ2);
            if (lowerChance < FConfig.gannonTower()) {
                gannon.generate1(world, random, chunkX2, chunkY2, chunkZ2);
            }
        }
        final StructureCamp camp = new StructureCamp();
        final StructureTemple temple = new StructureTemple();
        for (int k = 0; k < 1; ++k) {
            final int chunkX3 = x + random.nextInt(16);
            final int chunkZ3 = z + random.nextInt(16);
            final int chunkY3 = world.getHeightValue(chunkX3, chunkZ3);
            if (chance2 < FableConfig.generateBanditCamps()) {
                camp.generateSurface(world, random, chunkX3, chunkY3, chunkZ3);
            }
        }
        for (int k = 0; k < 1; ++k) {
            final int chunkX3 = x + random.nextInt(16);
            final int chunkZ3 = z + random.nextInt(16);
            final int chunkY3 = world.getHeightValue(chunkX3, chunkZ3);
            if (chance2 < FableConfig.generateTemples()) {
                temple.generateSurface(world, random, chunkX3, chunkY3, chunkZ3);
            }
        }
    }
    
    private void generateInNether(final World world, final Random random, final int x, final int z) {
        for (int i = 0; i < 2; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(30);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.hellstoneOre, 5, Blocks.netherrack).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 5; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(20);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.obsidianOre, 10, Blocks.netherrack).generate(world, random, chunkX, chunkY, chunkZ);
        }
        for (int i = 0; i < 1; ++i) {
            final int chunkX = x + random.nextInt(16);
            final int chunkY = random.nextInt(64);
            final int chunkZ = z + random.nextInt(16);
            new WorldGenMinable(Main.lavaOre, 3, Blocks.lava).generate(world, random, chunkX, chunkY, chunkZ);
        }
    }
    
    private void generateInOtherworld(final World world, final Random rand, final int x, final int z) {
    }
}
