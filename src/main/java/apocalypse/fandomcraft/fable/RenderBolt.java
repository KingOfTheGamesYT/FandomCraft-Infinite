 package apocalypse.fandomcraft.fable;

 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.renderer.Tessellator;
 import net.minecraft.client.renderer.entity.Render;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;
 import net.minecraft.util.ResourceLocation;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class RenderBolt
   extends Render
 {
   private static final ResourceLocation arrowTextures = new ResourceLocation("fandomcraft:textures/items/bolt.png");

   private static final String __OBFID = "CL_00000978";

   public void doRender(ProjectileBolt p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
     bindEntityTexture(p_76986_1_);
     GL11.glPushMatrix();
     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
     GL11.glRotatef(p_76986_1_.prevRotationYaw + (p_76986_1_.rotationYaw - p_76986_1_.prevRotationYaw) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
     GL11.glRotatef(p_76986_1_.prevRotationPitch + (p_76986_1_.rotationPitch - p_76986_1_.prevRotationPitch) * p_76986_9_, 0.0F, 0.0F, 1.0F);
     Tessellator tessellator = Tessellator.instance;
     byte b0 = 0;
     float f2 = 0.0F;
     float f3 = 0.5F;
     float f4 = (0 + b0 * 10) / 32.0F;
     float f5 = (5 + b0 * 10) / 32.0F;
     float f6 = 0.0F;
     float f7 = 0.15625F;
     float f8 = (5 + b0 * 10) / 32.0F;
     float f9 = (10 + b0 * 10) / 32.0F;
     float f10 = 0.05625F;
     GL11.glEnable(32826);
     float f11 = p_76986_1_.arrowShake - p_76986_9_;

     if (f11 > 0.0F) {

       float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
       GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
     }

     GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
     GL11.glScalef(f10, f10, f10);
     GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
     GL11.glNormal3f(f10, 0.0F, 0.0F);
     tessellator.startDrawingQuads();
     tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f8);
     tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f8);
     tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f9);
     tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f9);
     tessellator.draw();
     GL11.glNormal3f(-f10, 0.0F, 0.0F);
     tessellator.startDrawingQuads();
     tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f8);
     tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f8);
     tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f9);
     tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f9);
     tessellator.draw();

     for (int i = 0; i < 4; i++) {

       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
       GL11.glNormal3f(0.0F, 0.0F, f10);
       tessellator.startDrawingQuads();
       tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, f2, f4);
       tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, f3, f4);
       tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, f3, f5);
       tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, f2, f5);
       tessellator.draw();
     }

     GL11.glDisable(32826);
     GL11.glPopMatrix();
   }

   protected ResourceLocation getEntityTexture(ProjectileBolt p_110775_1_) {
     return arrowTextures;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
     return getEntityTexture((ProjectileBolt)p_110775_1_);
   }

   public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
     doRender((ProjectileBolt)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
 }