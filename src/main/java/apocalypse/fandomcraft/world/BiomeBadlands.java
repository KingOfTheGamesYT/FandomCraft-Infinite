package apocalypse.fandomcraft.world;

import apocalypse.fandomcraft.horror.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.passive.*;
import apocalypse.fandomcraft.entity.*;
import apocalypse.fandomcraft.fable.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.*;

public class BiomeBadlands extends BiomeGen
{
    public BiomeBadlands(final int id) {
        super(id);
        this.setBiomeName("Badlands");
        this.topBlock = HorrorReg.bloodGrass;
        this.fillerBlock = Main.RockStone;
        this.theBiomeDecorator.generateLakes = true;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.deadBushPerChunk = 3;
        this.theBiomeDecorator.mushroomsPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.cactiPerChunk = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.rainfall = 1.0f;
        this.setHeight(new BiomeGenBase.Height(-1.0f, 1.0f));
        this.waterColorMultiplier = 2235199;
        this.spawnableCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityBat.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityBombskit.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityHobbe.class, 50, 1, 5));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry((Class)EntityHollowMan.class, 50, 1, 5));
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
    
    public void genTerrainBlocks(final World p_150573_1_, final Random p_150573_2_, final Block[] p_150573_3_, final byte[] p_150573_4_, final int p_150573_5_, final int p_150573_6_, final double p_150573_7_) {
        super.genTerrainBlocks(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }
}
