package apocalypse.fandomcraft.otherworld;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.layer.*;

public class OtherworldGenLayerBiomes extends GenLayer
{
    protected BiomeGenBase[] allowedBiomes;
    
    public OtherworldGenLayerBiomes(final long seed) {
        super(seed);
        this.allowedBiomes = new BiomeGenBase[] { FCBiomes.badlands, FCBiomes.bloodwood };
    }
    
    public OtherworldGenLayerBiomes(final long seed, final GenLayer genlayer) {
        super(seed);
        this.allowedBiomes = new BiomeGenBase[] { FCBiomes.badlands, FCBiomes.bloodwood };
        this.parent = genlayer;
    }
    
    public int[] getInts(final int x, final int z, final int width, final int depth) {
        final int[] dest = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; ++dz) {
            for (int dx = 0; dx < width; ++dx) {
                this.initChunkSeed((long)(dx + x), (long)(dz + z));
                dest[dx + dz * width] = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;
            }
        }
        return dest;
    }
}
