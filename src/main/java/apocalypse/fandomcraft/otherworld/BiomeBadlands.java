package apocalypse.fandomcraft.otherworld;

import apocalypse.fandomcraft.fable.EntityHollowMan;
import net.minecraft.world.gen.feature.*;
import apocalypse.fandomcraft.horror.*;
import apocalypse.fandomcraft.otherworld.structures.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.biome.*;
import apocalypse.fandomcraft.entity.*;
import apocalypse.fandomcraft.fable.*;
import apocalypse.fandomcraft.horror.entity.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;

public class BiomeBadlands extends FCBiomes
{
    public static int treesPerChunk;
    protected BiomeDecorate decorator;
    private WorldGenerator WorldGenOWBloodTreeSmall;
    private WorldGenerator WorldGenOWBloodTreeMedium;
    private WorldGenerator WorldGenOWBloodTreeLarge;
    private WorldGenerator WorldGenOWRockSmall;
    private WorldGenerator WorldGenOWRockTall;
    private WorldGenerator WorldGenOWGrass;
    private WorldGenerator WorldGenOWThorns;
    private WorldGenerator WorldGenOWDeathPlant;
    
    public BiomeBadlands(final int biomeId) {
        super(biomeId);
        BiomeBadlands.treesPerChunk = 0;
        this.topBlock = HorrorReg.bloodGrass;
        this.fillerBlock = HorrorReg.bloodstoneRock;
        this.WorldGenOWBloodTreeSmall = new WorldGenOWBloodTreeSmall();
        this.WorldGenOWBloodTreeMedium = new WorldGenOWBloodTreeMedium();
        this.WorldGenOWBloodTreeLarge = new WorldGenOWBloodTreeLarge();
        this.WorldGenOWRockSmall = new WorldGenOWRockSmall();
        this.WorldGenOWRockTall = new WorldGenOWRockTall();
        this.WorldGenOWGrass = new WorldGenOWGrass();
        this.WorldGenOWThorns = new WorldGenOWThorns();
        this.WorldGenOWDeathPlant = new WorldGenOWDeathPlant();
        this.setBiomeName("Badlands");
        this.waterColorMultiplier = 1900544;
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityBat.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityBombskit.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityHobbe.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class) EntityHollowMan.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityFBI.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityLGM.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityMummy.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityCultist.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityHeretic.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityPoe.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityJason.class, 10, 1, 1));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityFreddy.class, 10, 1, 1));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityMyers.class, 10, 1, 1));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityBloodhound.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityGreyChild.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityStalker.class, 50, 1, 5));
    }
    
    public BiomeGenBase.TempCategory getTempCategory() {
        return BiomeGenBase.TempCategory.MEDIUM;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor() {
        return 4469555;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor() {
        return 4469555;
    }
    
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(final float par1) {
        return 4469555;
    }
    
    public WorldGenerator getRandomWorldGenForTrees(final Random par1Random) {
        return (WorldGenerator)((par1Random.nextInt(5) == 0) ? this.worldGeneratorSwamp : ((par1Random.nextInt(10) == 0) ? this.WorldGenOWBloodTreeSmall : this.worldGeneratorTrees));
    }
    
    public float getSpawningChance() {
        return 0.5f;
    }
}
