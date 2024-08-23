 package apocalypse.fandomcraft.entity;

 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.renderer.entity.RenderLiving;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.util.ResourceLocation;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class RenderDitto
   extends RenderLiving
 {
   private ModelBase scaleAmount;
   private static final ResourceLocation textures = new ResourceLocation("fandomcraft:textures/models/entity/modelDitto.png");

   public RenderDitto(ModelBase base, float f) {
     super(base, f);
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
     return textures;
   }

   protected void preRenderCallback(EntityDitto p_77041_1_, float p_77041_2_) {
     float f1 = 1.0F;
     float f2 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / (f1 * 0.5F + 1.0F);
     float f3 = 1.0F / (f2 + 1.0F);
     GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
   }

   protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
     preRenderCallback((EntityDitto)p_77041_1_, p_77041_2_);
   }
 }