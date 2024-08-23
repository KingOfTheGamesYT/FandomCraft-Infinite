 package apocalypse.fandomcraft.entity;

 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.model.ModelBase;
 import net.minecraft.client.renderer.entity.RenderLiving;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.boss.BossStatus;
 import net.minecraft.util.ResourceLocation;

 @SideOnly(Side.CLIENT)
 public class RenderChaosBoss
   extends RenderLiving
 {
   private static final ResourceLocation textures = new ResourceLocation("fandomcraft:textures/models/entity/Chaos.png");

   public RenderChaosBoss(ModelBase base, float f) {
     super(base, f);
   }

   public void doRender(Entity entity, double var2, double var4, double var6, float var8, float var9) {
     BossStatus.setBossStatus((EntityChaosBoss)entity, true);
     super.doRender(entity, var2, var4, var6, var8, var9);
   }

   protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
     return textures;
   }
 }