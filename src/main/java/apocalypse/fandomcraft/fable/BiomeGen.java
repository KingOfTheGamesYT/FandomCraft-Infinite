 package apocalypse.fandomcraft.fable;

 import apocalypse.fandomcraft.main.Main;
 import apocalypse.fandomcraft.world.BiomeBadlands;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.init.Blocks;
 import net.minecraft.world.World;
 import net.minecraft.world.biome.BiomeGenBase;
 import net.minecraft.world.gen.feature.WorldGenTallGrass;
 import net.minecraft.world.gen.feature.WorldGenerator;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;

 public class BiomeGen
   extends BiomeGenBase
 {
   public static BiomeGenBase darkForest;
   public static BiomeGenBase deadlands;
   public static final BiomeGenBase.Height biomeHeight = new BiomeGenBase.Height(0.3F, 0.6F);

   public BiomeGen(int biomeId) {
     super(biomeId);
   }

   static {
     deadlands = (new BiomeBadlands(50)).setColor(4325376).setTemperatureRainfall(0.95F, 0.9F).setHeight(biomeHeight).setBiomeName("Badlands");
     darkForest = (new BiomeDarkForest(51)).setColor(203264).setTemperatureRainfall(0.8F, 0.4F).setHeight(biomeHeight).setBiomeName("Dark Forest");
   }

   public WorldGenerator getRandomWorldGenForGrass(Random random) {
     if (random.nextInt(4) == 0) {
       return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.tallgrass, 2);
     }
     return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.tallgrass, 1);
   }

   public static void registerWithBiomeDictionary() {
     BiomeDictionary.registerBiomeType(darkForest, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
     BiomeDictionary.registerBiomeType(deadlands, new BiomeDictionary.Type[] { BiomeDictionary.Type.SAVANNA });
     BiomeDictionary.registerAllBiomes();
     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(darkForest, 10));
     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(deadlands, 10));
     BiomeManager.addSpawnBiome(darkForest);
     BiomeManager.addSpawnBiome(deadlands);
   }

   public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
     genBiomeModdedTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
   }

   public void genBiomeModdedTerrain(World world, Random random, Block[] replacableBlock, byte[] aByte, int x, int y, double z) {
     Block block = this.topBlock;
     byte b0 = (byte)(this.field_76754_C & 0xFF);
     Block block1 = this.fillerBlock;
     int k = -1;
     int l = (int)(z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
     int i1 = x & 0xF;
     int j1 = y & 0xF;
     int k1 = replacableBlock.length / 256;
     for (int l1 = 255; l1 >= 0; l1--) {

       int i2 = (j1 * 16 + i1) * k1 + l1;

       if (l1 <= 0 + random.nextInt(5)) {

         replacableBlock[i2] = Main.bloodstone;
       }
       else {

         Block block2 = replacableBlock[i2];

         if (block2 != null && block2.getMaterial() != Material.air) {

           if (block2 == Blocks.wool)
           {
             if (k == -1) {

               if (l <= 0) {

                 block = null;
                 b0 = 0;
                 block1 = Blocks.dirt;
               }
               else if (l1 >= 59 && l1 <= 64) {

                 block = this.topBlock;
                 b0 = (byte)(this.field_76754_C & 0xFF);
                 block1 = this.fillerBlock;
               }

               if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {

                 block = Blocks.water;
                 b0 = 0;
               }

               k = l;

               if (l1 >= 62)
               {
                 replacableBlock[i2] = block;
                 aByte[i2] = b0;
               }
               else if (l1 < 56 - l)
               {
                 block = null;
                 block1 = Blocks.cobblestone;
                 replacableBlock[i2] = Blocks.gravel;
               }
               else
               {
                 replacableBlock[i2] = block1;
               }

             } else if (k > 0) {

               k--;
               replacableBlock[i2] = block1;

               if (k == 0 && block1 == Blocks.sand)
               {
                 k = random.nextInt(4) + Math.max(0, l1 - 63);
                 block1 = Blocks.sandstone;
               }

             }
           }
         } else {

           k = -1;
         }
       }
     }
   }

   public static void registerBiomes() {}
 }