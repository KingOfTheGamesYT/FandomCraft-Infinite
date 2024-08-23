package apocalypse.fandomcraft.otherworld;

import java.util.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraftforge.common.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import apocalypse.fandomcraft.horror.*;
import apocalypse.fandomcraft.main.*;
import net.minecraft.world.biome.*;

public class FCBiomes extends BiomeGenBase
{
    public static final BiomeGenBase.Height biomeHeight;
    public static BiomeGenBase badlands;
    public static BiomeGenBase bloodwood;
    
    public FCBiomes(final int biomeId) {
        super(biomeId);
        this.theBiomeDecorator = (BiomeDecorator)new BiomeDecorate();
    }
    
    public WorldGenerator getRandomWorldGenForGrass(final Random random) {
        if (random.nextInt(4) == 0) {
            return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.deadbush, 2);
        }
        return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.tallgrass, 1);
    }
    
    public static void registerWithBiomeDictionary() {
        BiomeDictionary.registerBiomeType(FCBiomes.badlands, new BiomeDictionary.Type[] { BiomeDictionary.Type.SAVANNA });
        BiomeDictionary.registerBiomeType(FCBiomes.bloodwood, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
    }
    
    public void genTerrainBlocks(final World p_150573_1_, final Random p_150573_2_, final Block[] p_150573_3_, final byte[] p_150573_4_, final int p_150573_5_, final int p_150573_6_, final double p_150573_7_) {
        this.genBiomeModdedTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }
    
    public void genBiomeModdedTerrain(final World world, final Random random, final Block[] replacableBlock, final byte[] aByte, final int x, final int y, final double z) {
        Block block = this.topBlock;
        byte b0 = (byte)(this.field_150609_ah & 0xFF);
        Block block2 = this.fillerBlock;
        int k = -1;
        final int l = (int)(z / 3.0 + 3.0 + random.nextDouble() * 0.25);
        final int i1 = x & 0xF;
        final int j1 = y & 0xF;
        final int k2 = replacableBlock.length / 256;
        for (int l2 = 255; l2 >= 0; --l2) {
            final int i2 = (j1 * 16 + i1) * k2 + l2;
            if (l2 <= 0 + random.nextInt(5)) {
                replacableBlock[i2] = Blocks.bedrock;
            }
            else {
                final Block block3 = replacableBlock[i2];
                if (block3 != null && block3.getMaterial() != Material.air) {
                    if (block3 == HorrorReg.bloodstoneRock) {
                        if (k == -1) {
                            if (l <= 0) {
                                block = null;
                                b0 = 0;
                                block2 = HorrorReg.bloodstoneRock;
                            }
                            else if (l2 >= 59 && l2 <= 64) {
                                block = this.topBlock;
                                b0 = (byte)(this.field_150609_ah & 0xFF);
                                block2 = this.fillerBlock;
                            }
                            if (l2 < 63 && (block == null || block.getMaterial() == Material.air)) {
                                if (this.getFloatTemperature(x, l2, y) < 0.15f) {
                                    block = Blocks.ice;
                                    b0 = 0;
                                }
                                else {
                                    block = Blocks.water;
                                    b0 = 0;
                                }
                            }
                            k = l;
                            if (l2 >= 62) {
                                replacableBlock[i2] = block;
                                aByte[i2] = b0;
                            }
                            else if (l2 < 56 - l) {
                                block = null;
                                block2 = HorrorReg.bloodstoneRock;
                                replacableBlock[i2] = HorrorReg.gravitite;
                            }
                            else {
                                replacableBlock[i2] = block2;
                            }
                        }
                        else if (k > 0) {
                            --k;
                            replacableBlock[i2] = block2;
                            if (k == 0 && block2 == HorrorReg.gravitite) {
                                k = random.nextInt(4) + Math.max(0, l2 - 63);
                                block2 = Main.bloodstone;
                            }
                        }
                    }
                }
                else {
                    k = -1;
                }
            }
        }
    }
    
    static {
        biomeHeight = new BiomeGenBase.Height(0.3f, 0.6f);
        FCBiomes.badlands = new BiomeBadlands(BiomeIDs.BADLANDS).setColor(5470985).setTemperatureRainfall(0.95f, 0.1f).setHeight(FCBiomes.biomeHeight).setBiomeName("Badlands");
        FCBiomes.bloodwood = new BiomeBloodwood(BiomeIDs.BLOODWOOD).setColor(34049320).setTemperatureRainfall(0.8f, 0.4f).setHeight(FCBiomes.biomeHeight).setBiomeName("Bloodwood Forest");
    }
}
