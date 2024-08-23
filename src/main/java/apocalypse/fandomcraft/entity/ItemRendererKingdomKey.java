 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.models.modelKingdomKey;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.Minecraft;
 import net.minecraft.entity.Entity;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraftforge.client.IItemRenderer;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class ItemRendererKingdomKey
   implements IItemRenderer
 {
   protected modelKingdomKey modelKingdomKey = new modelKingdomKey();

   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
     switch (type) { case EQUIPPED:
         return true;
       case EQUIPPED_FIRST_PERSON: return true; }
      return false;
   }

   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
     return false;
   }

   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
     switch (type) {

       case EQUIPPED:
         GL11.glPushMatrix();

         (Minecraft.getMinecraft()).renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/models/entity/modelKingdomKey.png"));

         GL11.glRotatef(90.0F, -65.0F, 215.0F, 1.0F);
         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

         GL11.glTranslatef(0.0F, -0.25F, 0.7F);

         GL11.glScalef(0.8F, 0.8F, 0.8F);

         this.modelKingdomKey.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.03125F);

         GL11.glPopMatrix();

       case EQUIPPED_FIRST_PERSON:
         GL11.glPushMatrix();

         (Minecraft.getMinecraft()).renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/models/entity/modelKingdomKey.png"));

         GL11.glRotatef(90.0F, -65.0F, 215.0F, 1.0F);
         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

         GL11.glTranslatef(0.0F, -0.25F, 0.7F);

         GL11.glScalef(0.8F, 0.8F, 0.8F);

         this.modelKingdomKey.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.03215F);

         GL11.glPopMatrix();
         break;
     }
   }
 }