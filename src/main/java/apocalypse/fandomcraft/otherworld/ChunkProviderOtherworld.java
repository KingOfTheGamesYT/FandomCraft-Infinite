package apocalypse.fandomcraft.otherworld;

import net.minecraft.world.gen.structure.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.init.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraft.world.gen.feature.*;
import apocalypse.fandomcraft.otherworld.structures.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;

public class ChunkProviderOtherworld implements IChunkProvider
{
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorPerlin noisePerl;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private WorldType worldType;
    private final double[] noiseArray;
    private final float[] parabolicField;
    private double[] stoneNoise;
    private MapGenBase caveGenerator;
    private MapGenScatteredFeature scatteredFeatureGenerator;
    private MapGenBase ravineGenerator;
    private BiomeGenBase[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    int[][] field_73219_j;
    
    public ChunkProviderOtherworld(final World world, final long seed, final boolean mapFeaturesEnabled) {
        this.stoneNoise = new double[256];
        this.caveGenerator = (MapGenBase)new MapGenCaves();
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        this.ravineGenerator = (MapGenBase)new MapGenRavine();
        this.field_73219_j = new int[32][32];
        this.caveGenerator = TerrainGen.getModdedMapGen(this.caveGenerator, InitMapGenEvent.EventType.CAVE);
        this.scatteredFeatureGenerator = (MapGenScatteredFeature)TerrainGen.getModdedMapGen((MapGenBase)this.scatteredFeatureGenerator, InitMapGenEvent.EventType.SCATTERED_FEATURE);
        this.ravineGenerator = TerrainGen.getModdedMapGen(this.ravineGenerator, InitMapGenEvent.EventType.RAVINE);
        this.worldObj = world;
        this.mapFeaturesEnabled = mapFeaturesEnabled;
        this.worldType = world.getWorldInfo().getTerrainType();
        this.rand = new Random(seed);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 12);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 12);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 9);
        this.noisePerl = new NoiseGeneratorPerlin(this.rand, 2);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 6);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 8);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 9);
        this.noiseArray = new double[825];
        this.parabolicField = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                final float f = 10.0f / MathHelper.sqrt_float(j * j + k * k + 0.2f);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }
        NoiseGenerator[] noiseGens = { (NoiseGenerator)this.noiseGen1, (NoiseGenerator)this.noiseGen2, (NoiseGenerator)this.noiseGen3, (NoiseGenerator)this.noisePerl, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
        noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
        this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
        this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
    }
    
    public void func_147424_a(final int par1, final int par2, final Block[] blocks) {
        final byte b0 = 63;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
        this.func_147423_a(par1 * 4, 0, par2 * 4);
        for (int k = 0; k < 4; ++k) {
            final int l = k * 5;
            final int i1 = (k + 1) * 5;
            for (int j1 = 0; j1 < 4; ++j1) {
                final int k2 = (l + j1) * 33;
                final int l2 = (l + j1 + 1) * 33;
                final int i2 = (i1 + j1) * 33;
                final int j2 = (i1 + j1 + 1) * 33;
                for (int k3 = 0; k3 < 32; ++k3) {
                    final double d0 = 0.125;
                    double d2 = this.noiseArray[k2 + k3];
                    double d3 = this.noiseArray[l2 + k3];
                    double d4 = this.noiseArray[i2 + k3];
                    double d5 = this.noiseArray[j2 + k3];
                    final double d6 = (this.noiseArray[k2 + k3 + 1] - d2) * d0;
                    final double d7 = (this.noiseArray[l2 + k3 + 1] - d3) * d0;
                    final double d8 = (this.noiseArray[i2 + k3 + 1] - d4) * d0;
                    final double d9 = (this.noiseArray[j2 + k3 + 1] - d5) * d0;
                    for (int l3 = 0; l3 < 8; ++l3) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k3 * 8 + l3;
                            final short short1 = 256;
                            j3 -= short1;
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * d15;
                            double d17 = d11 - d16;
                            for (int k4 = 0; k4 < 4; ++k4) {
                                if ((d17 += d16) > 0.0) {
                                    blocks[j3 += short1] = HorrorReg.bloodstoneRock;
                                }
                                else if (k3 * 8 + l3 < b0) {
                                    blocks[j3 += short1] = Blocks.water;
                                }
                                else {
                                    blocks[j3 += short1] = null;
                                }
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }
    
    public void replaceBlocksForBiome(final int par1, final int par2, final Block[] blocks, final byte[] par3ArrayOfByte, final BiomeGenBase[] par4ArrayOfBiomeGenBase) {
        final ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks((IChunkProvider)this, par1, par2, blocks, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        final double d0 = 0.03125;
        this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (double)(par1 * 16), (double)(par2 * 16), 16, 16, d0 * 2.0, d0 * 2.0, 1.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                final FCBiomes biomegenbase = (FCBiomes)par4ArrayOfBiomeGenBase[l + k * 16];
                biomegenbase.genTerrainBlocks(this.worldObj, this.rand, blocks, par3ArrayOfByte, par1 * 16 + k, par2 * 16 + l, this.stoneNoise[l + k * 16]);
            }
        }
    }
    
    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }
    
    public Chunk provideChunk(final int par1, final int par2) {
        this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        final Block[] ablock = new Block[65536];
        final byte[] abyte = new byte[65536];
        this.func_147424_a(par1, par2, ablock);
        this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16));
        this.caveGenerator.func_151539_a((IChunkProvider)this, this.worldObj, par1, par2, ablock);
        this.ravineGenerator.func_151539_a((IChunkProvider)this, this.worldObj, par1, par2, ablock);
        if (this.mapFeaturesEnabled) {
            this.scatteredFeatureGenerator.func_151539_a((IChunkProvider)this, this.worldObj, par1, par2, ablock);
        }
        final Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        final byte[] abyte2 = chunk.getBiomeArray();
        for (int k = 0; k < abyte2.length; ++k) {
            abyte2[k] = (byte)this.biomesForGeneration[k].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }
    
    private void func_147423_a(final int p_147423_1_, final int p_147423_2_, final int p_147423_3_) {
        this.noise5 = this.noiseGen6.generateNoiseOctaves(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0, 200.0, 0.5);
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        int l = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < 5; ++j1) {
            for (int k1 = 0; k1 < 5; ++k1) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                final byte b0 = 2;
                final BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
                for (int l2 = -b0; l2 <= b0; ++l2) {
                    for (int i2 = -b0; i2 <= b0; ++i2) {
                        final BiomeGenBase biomegenbase2 = this.biomesForGeneration[j1 + l2 + 2 + (k1 + i2 + 2) * 10];
                        float f4 = biomegenbase2.field_76754_C;
                        float f5 = biomegenbase2.field_150604_aj;
                        if (this.worldType == WorldType.AMPLIFIED && f4 > 0.0f) {
                            f4 = 1.0f + f4 * 2.0f;
                            f5 = 1.0f + f5 * 4.0f;
                        }
                        float f6 = this.parabolicField[l2 + 2 + (i2 + 2) * 5] / (f4 + 2.0f);
                        if (biomegenbase2.field_76754_C > biomegenbase.field_150604_aj) {
                            f6 /= 2.0f;
                        }
                        f += f5 * f6;
                        f2 += f4 * f6;
                        f3 += f6;
                    }
                }
                f /= f3;
                f2 /= f3;
                f = f * 0.9f + 0.1f;
                f2 = (f2 * 4.0f - 1.0f) / 8.0f;
                double d12 = this.noise5[i1] / 8000.0;
                if (d12 < 0.0) {
                    d12 = -d12 * 0.3;
                }
                d12 = d12 * 3.0 - 2.0;
                if (d12 < 0.0) {
                    d12 /= 2.0;
                    if (d12 < -1.0) {
                        d12 = -1.0;
                    }
                    d12 /= 1.4;
                    d12 /= 2.0;
                }
                else {
                    if (d12 > 1.0) {
                        d12 = 1.0;
                    }
                    d12 /= 8.0;
                }
                ++i1;
                double d13 = f2;
                final double d14 = f;
                d13 += d12 * 0.2;
                d13 = d13 * 8.5 / 8.0;
                final double d15 = 8.5 + d13 * 4.0;
                for (int j2 = 0; j2 < 33; ++j2) {
                    double d16 = (j2 - d15) * 12.0 * 128.0 / 256.0 / d14;
                    if (d16 < 0.0) {
                        d16 *= 4.0;
                    }
                    final double d17 = this.noise1[l] / 512.0;
                    final double d18 = this.noise2[l] / 512.0;
                    final double d19 = (this.noise3[l] / 10.0 + 1.0) / 2.0;
                    double d20 = MathHelper.denormalizeClamp(d17, d18, d19) - d16;
                    if (j2 > 29) {
                        final double d21 = (j2 - 29) / 3.0f;
                        d20 = d20 * (1.0 - d21) + -10.0 * d21;
                    }
                    this.noiseArray[l] = d20;
                    ++l;
                }
            }
        }
    }
    
    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }
    
    public void populate(final IChunkProvider par1IChunkProvider, final int chunkX, final int chunkZ) {
        BlockFalling.fallInstantly = true;
        int k = chunkX * 16;
        int l = chunkZ * 16;
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        final long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * i1 + chunkZ * j1 ^ this.worldObj.getSeed());
        final boolean flag = false;
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, flag));
        if (this.mapFeaturesEnabled) {
            this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, chunkX, chunkZ);
        }
        if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, flag, PopulateChunkEvent.Populate.EventType.LAKE)) {
            final int k2 = k + this.rand.nextInt(16) + 8;
            final int l2 = this.rand.nextInt(256);
            final int i2 = l + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Blocks.water).generate(this.worldObj, this.rand, k2, l2, i2);
        }
        if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, flag, PopulateChunkEvent.Populate.EventType.LAVA) && !flag && this.rand.nextInt(8) == 0) {
            final int k2 = k + this.rand.nextInt(16) + 8;
            final int l2 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            final int i2 = l + this.rand.nextInt(16) + 8;
            if (l2 < 63 || this.rand.nextInt(10) == 0) {
                new WorldGenLakes(Blocks.lava).generate(this.worldObj, this.rand, k2, l2, i2);
            }
        }
        int k2;
        int l2;
        int i2;
        boolean doGen;
        int j2;
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, flag, PopulateChunkEvent.Populate.EventType.DUNGEON), k2 = 0; doGen && k2 < 8; ++k2) {
            l2 = k + this.rand.nextInt(16) + 8;
            i2 = this.rand.nextInt(256);
            j2 = l + this.rand.nextInt(16) + 8;
            new WorldGenDungeons().generate(this.worldObj, this.rand, l2, i2, j2);
        }
        biomegenbase.decorate(this.worldObj, this.rand, k, l);
        if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, flag, PopulateChunkEvent.Populate.EventType.ANIMALS)) {}
        k += 8;
        l += 8;
        for (doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, flag, PopulateChunkEvent.Populate.EventType.ICE), k2 = 0; doGen && k2 < 16; ++k2) {
            for (int l22 = 0; l22 < 16; ++l22) {
                i2 = this.worldObj.getPrecipitationHeight(k + k2, l + l22);
                if (this.worldObj.isBlockFreezable(k2 + k, i2 - 1, l22 + l)) {
                    this.worldObj.setBlock(k2 + k, i2 - 1, l22 + l, Blocks.ice, 0, 2);
                }
                if (this.worldObj.canSnowAtBody(k2 + k, i2, l22 + l, true)) {
                    this.worldObj.setBlock(k2 + k, i2, l22 + l, Blocks.snow_layer, 0, 2);
                }
            }
        }
        final int x = chunkX * 16 + this.rand.nextInt(16);
        final int z = chunkZ * 16 + this.rand.nextInt(16);
        for (int m = 0; m < 10; ++m) {
            new WorldGenOWGrass().generate(this.worldObj, this.rand, x, 0, z);
        }
        for (int m = 0; m < 6; ++m) {
            new WorldGenOWThorns().generate(this.worldObj, this.rand, x, 0, z);
        }
        for (int m = 0; m < 2; ++m) {
            new WorldGenOWDeathPlant().generate(this.worldObj, this.rand, x, 0, z);
        }
        new WorldGenOWBloodTreeSmall().generate(this.worldObj, this.rand, x, 0, z);
        new WorldGenOWBloodTreeMedium().generate(this.worldObj, this.rand, x, 0, z);
        new WorldGenOWBloodTreeLarge().generate(this.worldObj, this.rand, x, 0, z);
        new WorldGenOWRockSmall().generate(this.worldObj, this.rand, x, 0, z);
        new WorldGenOWRockTall().generate(this.worldObj, this.rand, x, 0, z);
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, flag));
        BlockFalling.fallInstantly = false;
    }
    
    public boolean saveChunks(final boolean par1, final IProgressUpdate par2IProgressUpdate) {
        return true;
    }
    
    public void saveExtraData() {
    }
    
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    public boolean canSave() {
        return true;
    }
    
    public String makeString() {
        return "RandomLevelSource";
    }
    
    public List getPossibleCreatures(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3, final int par4) {
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
        return (par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4)) ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() : biomegenbase.getSpawnableList(par1EnumCreatureType);
    }

    @Override
    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
        return null;
    }

    public int getLoadedChunkCount() {
        return 0;
    }
    
    public void recreateStructures(final int par1, final int par2) {
        if (this.mapFeaturesEnabled) {}
    }
    
    public ChunkPosition findClosestStructure(final World world, final String arg1, final int arg2, final int arg3, final int arg4) {
        return null;
    }
}
