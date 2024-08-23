 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.models.modelRedLion;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.renderer.entity.Render;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.MathHelper;
 import net.minecraft.util.ResourceLocation;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class RenderRedLion
   extends Render
 {
   private static final ResourceLocation texture = new ResourceLocation("fandomcraft:textures/models/entity/modelRedLion.png");

   protected ModelBase modelRedLion = (ModelBase)new modelRedLion();

   protected ResourceLocation getEntityTexture(EntityRedLion p_110775_1_) {
     return texture;
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
     return getEntityTexture((EntityRedLion)p_110775_1_);
   }

   public void render(EntityRedLion en, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
     GL11.glPushMatrix();
     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
     GL11.glRotatef(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
     float f2 = en.getTimeSinceHit() - p_76986_9_;
     float f3 = en.getDamageTaken() - p_76986_9_;

     if (f3 < 0.0F)
     {
       f3 = 0.0F;
     }

     if (f2 > 0.0F)
     {
       GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * en.getForwardDirection(), 1.0F, 0.0F, 0.0F);
     }

     float f4 = 0.75F;
     GL11.glScalef(f4, f4, f4);
     GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
     bindEntityTexture(en);
     GL11.glScalef(-1.0F, -1.0F, 1.0F);
     this.modelRedLion.render(en, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
     GL11.glPopMatrix();
   }

   public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
     render((EntityRedLion)p_76986_1_, p_76986_6_, p_76986_6_, p_76986_6_, p_76986_9_, p_76986_9_);
   }
 }