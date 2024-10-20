 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.models.FloorSpike;

 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.ResourceLocation;

 import org.lwjgl.opengl.GL11;

 public class RenderFloorSpikes extends TileEntitySpecialRenderer {
   public static final ResourceLocation rl = new ResourceLocation("fandomcraft:textures/models/entity/floor_spikes.png");

   private FloorSpike model = new FloorSpike();

   public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
     GL11.glPushMatrix();
     GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
     bindTexture(rl);

     GL11.glPushMatrix();
     this.model.renderModel(0.0625F);
     GL11.glPopMatrix();

     GL11.glPopMatrix();
   }
 }