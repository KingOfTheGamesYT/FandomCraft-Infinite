 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.models.modelSkillet;
 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.ResourceLocation;
 import org.lwjgl.opengl.GL11;

 public class RenderSkillet
   extends TileEntitySpecialRenderer
 {
   public static final ResourceLocation textureSkillet = new ResourceLocation("fandomcraft:textures/models/entity/skillet.png");

   private modelSkillet model = new modelSkillet();

   public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
     GL11.glPushMatrix();
     GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
     bindTexture(textureSkillet);

     GL11.glPushMatrix();
     this.model.renderModel(0.0625F);
     GL11.glPopMatrix();

     GL11.glPopMatrix();
   }
 }