package apocalypse.fandomcraft.horror.entity;

import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.tileentity.*;
import org.lwjgl.opengl.*;

public class TileRenderTrashBin extends TileEntitySpecialRenderer
{
    public static final ResourceLocation textureBluePot;
    private ModelTrashBin model;
    
    public TileRenderTrashBin() {
        this.model = new ModelTrashBin();
    }
    
    public void renderTileEntityAt(final TileEntity tileentity, final double x, final double y, final double z, final float f) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.bindTexture(TileRenderTrashBin.textureBluePot);
        GL11.glPushMatrix();
        this.model.renderModel(0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
    
    static {
        textureBluePot = new ResourceLocation("fandomcraft:textures/models/entity/trash_bin.png");
    }
}
