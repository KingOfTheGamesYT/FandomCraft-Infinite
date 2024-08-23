 package apocalypse.fandomcraft.entity;

 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.renderer.entity.RenderLiving;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.boss.BossStatus;
 import net.minecraft.util.ResourceLocation;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class RenderZant
   extends RenderLiving
 {
   private float scale;
   private static final ResourceLocation textures = new ResourceLocation("fandomcraft:textures/models/entity/modelZant.png");

   public RenderZant(ModelBase base, float f, float s) {
     super(base, f * s);
     this.scale = s;
   }

   public void doRender(Entity entity, double var2, double var4, double var6, float var8, float var9) {
     BossStatus.setBossStatus((EntityZant)entity, true);
     super.doRender(entity, var2, var4, var6, var8, var9);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
     return textures;
   }

   protected void preRenderCallback(EntityZant p_77041_1_, float p_77041_2_) {
     GL11.glScalef(this.scale, this.scale, this.scale);
   }

   protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
     preRenderCallback((EntityZant)p_77041_1_, p_77041_2_);
   }
 }