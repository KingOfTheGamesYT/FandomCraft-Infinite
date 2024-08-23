package apocalypse.fandomcraft.otherworld;

import apocalypse.fandomcraft.horror.*;
import net.minecraft.world.*;
import java.util.*;

public class BiomeBloodwood extends FCBiomes
{
    public BiomeBloodwood(final int biomeId) {
        super(biomeId);
        this.theBiomeDecorator.treesPerChunk = 30;
        this.theBiomeDecorator.grassPerChunk = 5;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.topBlock = HorrorReg.bloodGrass;
        this.fillerBlock = HorrorReg.bloodstoneRock;
        this.setBiomeName("Bloodwood");
        this.waterColorMultiplier = 1900544;
    }
    
    public void decorate(final World world, final Random random, final int par3, final int par4) {
        super.decorate(world, random, par3, par4);
    }
    
    public int getBiomeGrassColor(final int x, final int y, final int z) {
        return 1382929;
    }
    
    public int getBiomeFoliageColor(final int x, final int y, final int z) {
        return 2499612;
    }
    
    public int getSkyColorByTemp(final float f) {
        return 0;
    }
}
