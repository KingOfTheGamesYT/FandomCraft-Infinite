 package apocalypse.fandomcraft.fable;

 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.init.Blocks;
 import net.minecraft.inventory.IInventory;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.tileentity.TileEntityChest;
 import net.minecraft.tileentity.TileEntityMobSpawner;
 import net.minecraft.util.WeightedRandomChestContent;
 import net.minecraft.world.World;
 import net.minecraft.world.biome.BiomeGenBase;
 import net.minecraft.world.gen.structure.StructureBoundingBox;
 import net.minecraft.world.gen.structure.StructureComponent;
 import net.minecraftforge.common.ChestGenHooks;

 public class StructureCamp
   extends StructureComponent
 {
   public void generateSurface(World world, Random random, int chunkX, int chunkY, int chunkZ) {
     int h = world.getHeightValue(chunkX, chunkZ) - 1;

     if ((world.getBiomeGenForCoords(chunkX, chunkZ)).biomeName.equals(BiomeGenBase.forest.biomeName) ||
       (world.getBiomeGenForCoords(chunkX, chunkZ)).biomeName.equals(BiomeGenBase.plains.biomeName) ||
       (world.getBiomeGenForCoords(chunkX, chunkZ)).biomeName.equals(BiomeGenBase.birchForest.biomeName) ||
       (world.getBiomeGenForCoords(chunkX, chunkZ)).biomeName.equals(BiomeGenBase.roofedForest.biomeName))
     {
       if (random.nextInt(10) + 1 <= 9) {

         boolean place = true;

         if (place) {

           world.setBlock(chunkX + 0, h + 0, chunkZ + 0, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 0, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 0, Blocks.mossy_cobblestone, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 0, Blocks.mossy_cobblestone, 0, 2);
           world.setBlock(chunkX + 4, h + 0, chunkZ + 0, Blocks.mossy_cobblestone, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 0, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 0, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 0, chunkZ + 1, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 1, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 1, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 1, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 4, h + 0, chunkZ + 1, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 1, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 1, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 0, chunkZ + 2, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 2, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 2, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 2, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 4, h + 0, chunkZ + 2, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 2, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 2, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 0, chunkZ + 3, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 3, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 3, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 3, (Block)Blocks.grass, 0, 2);
          world.setBlock(chunkX + 4, h + 0, chunkZ + 3, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 3, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 3, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 0, chunkZ + 4, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 4, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 4, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 4, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 4, h + 0, chunkZ + 4, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 4, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 4, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 0, chunkZ + 5, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 5, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 5, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 5, (Block)Blocks.grass, 0, 2);
          world.setBlock(chunkX + 4, h + 0, chunkZ + 5, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 5, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 5, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 0, chunkZ + 6, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 6, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 6, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 6, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 4, h + 0, chunkZ + 6, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 6, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 6, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 0, chunkZ + 7, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 1, h + 0, chunkZ + 7, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 2, h + 0, chunkZ + 7, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 3, h + 0, chunkZ + 7, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 4, h + 0, chunkZ + 7, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 5, h + 0, chunkZ + 7, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 6, h + 0, chunkZ + 7, Blocks.dirt, 0, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 1, chunkZ + 0, Blocks.fence, 0, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 0, Blocks.mob_spawner, 0, 2);
           int xm = chunkX + 3;
           int ym = h + 1;
           int zm = chunkZ + 0;
           TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(xm, ym, zm);
           if (tileentitymobspawner != null) {

             tileentitymobspawner.func_145881_a().setEntityName("EntityHobbe");
           }
           else {

             System.err.println("Failed to fetch mob spawner entity at (" + xm + ", " + ym + ", " + zm + ")");
           }
           world.setBlock(chunkX + 4, h + 1, chunkZ + 0, Blocks.fence, 0, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 1, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 2, h + 1, chunkZ + 1, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 1, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 4, h + 1, chunkZ + 1, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 1, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 2, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 2, h + 1, chunkZ + 2, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 2, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 4, h + 1, chunkZ + 2, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 2, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 3, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 2, h + 1, chunkZ + 3, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 3, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 4, h + 1, chunkZ + 3, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 3, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 4, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 2, h + 1, chunkZ + 4, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 4, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 4, h + 1, chunkZ + 4, (Block)Blocks.grass, 0, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 4, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 5, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 2, h + 1, chunkZ + 5, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 5, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 4, h + 1, chunkZ + 5, (Block)Blocks.grass, 8, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 5, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 6, (Block)Blocks.chest, 5, 2);
           int x = chunkX + 1;
           int y = h + 1;
           int z = chunkZ + 6;
           TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y, z);
           if (tileentitychest != null)
           {
             WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems("dungeonChest", random), (IInventory)tileentitychest, ChestGenHooks.getCount("dungeonChest", random));
           }
           world.setBlock(chunkX + 2, h + 1, chunkZ + 6, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 6, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 4, h + 1, chunkZ + 6, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 6, Blocks.carpet, 0, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 1, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 1, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 1, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 1, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 1, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 1, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 1, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 0, Blocks.fence, 0, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 0, Blocks.fence, 0, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 2, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 2, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 2, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 2, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 2, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 2, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 2, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 1, h + 2, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 2, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 2, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 2, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 2, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 2, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 6, Blocks.torch, 4, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 3, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 3, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 2, h + 3, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 3, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 3, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 3, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 6, h + 3, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 4, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 4, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 4, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 4, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 4, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 4, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 4, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 4, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 4, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 3, Blocks.air, 0, 2);
          world.setBlock(chunkX + 1, h + 4, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 3, Blocks.air, 0, 2);
          world.setBlock(chunkX + 5, h + 4, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 4, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 4, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 4, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 4, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 4, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 4, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 4, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 4, h + 4, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 5, h + 4, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 4, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 4, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 4, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 3, h + 4, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 4, chunkZ + 7, Blocks.wool, 12, 2);
          world.setBlock(chunkX + 5, h + 4, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 4, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 0, Blocks.air, 0, 2);
          world.setBlock(chunkX + 3, h + 5, chunkZ + 0, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 0, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 5, chunkZ + 1, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 1, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 5, chunkZ + 2, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 2, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 5, chunkZ + 3, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 3, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 5, chunkZ + 4, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 4, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 5, chunkZ + 5, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 5, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 5, chunkZ + 6, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 6, Blocks.air, 0, 2);
           world.setBlock(chunkX + 0, h + 5, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 1, h + 5, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 2, h + 5, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 3, h + 5, chunkZ + 7, Blocks.wool, 12, 2);
           world.setBlock(chunkX + 4, h + 5, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 5, h + 5, chunkZ + 7, Blocks.air, 0, 2);
           world.setBlock(chunkX + 6, h + 5, chunkZ + 7, Blocks.air, 0, 2);
           System.out.println("A [Bandit Camp] spawned at: " + chunkX + ", " + h + ", " + chunkZ + ".");
         }
       }
     }
   }

    @Override
    protected void func_143012_a(NBTTagCompound p_143012_1_) {

    }

    @Override
    protected void func_143011_b(NBTTagCompound p_143011_1_) {

    }

   public boolean addComponentParts(World world, Random r, StructureBoundingBox box) {
     generateSurface(world, r, this.coordBaseMode, this.coordBaseMode, this.coordBaseMode);

     return true;
   }

   protected void writeStructureToNBT(NBTTagCompound p_143012_1_) {}

   protected void readStructureFromNBT(NBTTagCompound p_143011_1_) {}
 }


/* Location:              C:\Users\minec\Desktop\mod porting\mod porting\Mod Porting Tools - No Eclipse\Mod Porting Tools\Fandomcraft 5a - Beta-deobf.zip!\apocalypse\fandomcraft\fable\StructureCamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */