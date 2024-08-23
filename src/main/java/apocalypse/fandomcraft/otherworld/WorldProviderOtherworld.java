package apocalypse.fandomcraft.otherworld;

import net.minecraft.world.chunk.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.biome.*;

public class WorldProviderOtherworld extends WorldProvider
{
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new ChunkProviderOtherworld(this.worldObj, this.worldObj.getSeed(), true);
    }
    
    public void registerWorldChunkManager() {
        this.worldChunkMgr = (WorldChunkManager)new WorldChunkManagerOtherworld(this.worldObj.getSeed(), this.terrainType);
        this.dimensionId = DimensionIDs.OTHERWORLDDIMENSION;
    }
    
    public static WorldProvider getProviderForDimension(final int id) {
        return DimensionManager.createProviderFor(DimensionIDs.OTHERWORLDDIMENSION);
    }
    
    public String getDimensionName() {
        return "Otherworld";
    }
    
    public String getSaveFolder() {
        return "DIM" + DimensionIDs.OTHERWORLDDIMENSION;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean renderStars() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public double getMovementFactor() {
        return 0.1;
    }
    
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(final World world, final float f) {
        return 1.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean renderClouds() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean renderVoidFog() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean renderEndSky() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public float setSunSize() {
        return 0.1f;
    }
    
    @SideOnly(Side.CLIENT)
    public float setMoonSize() {
        return 4.0f;
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(final Entity cameraEntity, final float partialTicks) {
        return this.worldObj.getSkyColorBody(cameraEntity, partialTicks);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isSkyColored() {
        return true;
    }
    
    public boolean canRespawnHere() {
        return true;
    }
    
    public boolean isSurfaceWorld() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return this.terrainType.getCloudHeight();
    }
    
    public ChunkCoordinates getEntrancePortalLocation() {
        return new ChunkCoordinates(50, 5, 0);
    }
    
    protected void generateLightBrightnessTable() {
        final float f = 0.0f;
        for (int i = 0; i <= 15; ++i) {
            final float f2 = 1.0f - i / 15.0f;
            this.lightBrightnessTable[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public String getWelcomeMessage() {
        return "Entering the Otherworld";
    }
    
    @SideOnly(Side.CLIENT)
    public String getDepartMessage() {
        return "Leaving the Otherworld";
    }
    
    public Vec3 drawClouds(final float partialTicks) {
        return super.drawClouds(partialTicks);
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(final float par1, final float par2) {
        return Vec3.createVectorHelper(0.4, 0.0, 0.0);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(final int par1, final int par2) {
        return true;
    }
}
