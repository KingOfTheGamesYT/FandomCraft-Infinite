 package apocalypse.fandomcraft.fable;

 import net.minecraft.entity.monster.EntityEnderman;
 import net.minecraft.entity.monster.EntityPigZombie;
 import net.minecraft.entity.monster.EntitySilverfish;
 import net.minecraft.entity.monster.EntitySkeleton;
 import net.minecraft.entity.monster.EntitySpider;
 import net.minecraft.entity.monster.EntityZombie;
 import net.minecraft.entity.passive.EntityBat;
 import net.minecraft.entity.passive.EntityWolf;
 import net.minecraft.world.biome.BiomeGenBase;

 public class BiomeDarkForest
   extends BiomeGen
 {
   public BiomeDarkForest(int id) {
     super(id);
     setHeight(new BiomeGenBase.Height(0.1F, 0.2F));
     setColor(1382929);
     setTemperatureRainfall(0.3F, 1.0F);
     this.waterColorMultiplier = 855319;
     this.theBiomeDecorator.generateLakes = true;
     this.theBiomeDecorator.treesPerChunk = 10;
     this.theBiomeDecorator.flowersPerChunk = 0;
     this.theBiomeDecorator.grassPerChunk = 0;
     this.theBiomeDecorator.deadBushPerChunk = 15;
     this.theBiomeDecorator.mushroomsPerChunk = 4;
     this.theBiomeDecorator.reedsPerChunk = 15;
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityBat.class, 5, 1, 5));
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 5, 1, 5));
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 5, 1, 5));
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySilverfish.class, 5, 1, 5));
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 5, 1, 5));
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 5, 1, 5));
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 5, 1, 5));
     this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 5, 1, 5));
   }

   public int getBiomeGrassColor(int x, int y, int z) {
     return 1382929;
   }

   public int getBiomeFoliageColor(int x, int y, int z) {
     return 2499612;
   }

   public int getSkyColorByTemp(float f) {
     return 0;
   }
 }