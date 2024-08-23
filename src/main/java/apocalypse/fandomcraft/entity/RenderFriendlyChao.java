 package apocalypse.fandomcraft.entity;

 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.renderer.entity.RenderLiving;
 import net.minecraft.entity.Entity;
 import net.minecraft.util.ResourceLocation;

 @SideOnly(Side.CLIENT)
 public class RenderFriendlyChao
   extends RenderLiving
 {
   private static final ResourceLocation textures = new ResourceLocation("fandomcraft:textures/models/entity/chao.png");

   public RenderFriendlyChao(ModelBase base, float f) {
     super(base, f);
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
     return textures;
   }
 }