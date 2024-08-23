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
 public class RenderMiniblin
   extends RenderLiving
 {
   private float scale;
   private static final ResourceLocation textures = new ResourceLocation("fandomcraft:textures/models/entity/modelMiniblin.png");

   public RenderMiniblin(ModelBase base, float f, float s) {
     super(base, f * s);
     this.scale = s;
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
     return textures;
   }

   protected void preRenderCallback(EntityMiniblin p_77041_1_, float p_77041_2_) {
     GL11.glScalef(this.scale, this.scale, this.scale);
   }

   protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
     preRenderCallback((EntityMiniblin)p_77041_1_, p_77041_2_);
   }
 }