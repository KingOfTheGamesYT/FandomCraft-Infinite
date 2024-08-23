 package apocalypse.fandomcraft.entity;

 import apocalypse.fandomcraft.models.modelArmCannon2;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.Minecraft;
 import net.minecraft.entity.Entity;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraftforge.client.IItemRenderer;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class ItemRendererArmCannon
   implements IItemRenderer
 {
   protected modelArmCannon2 modelArmCannon2 = new modelArmCannon2();

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

         (Minecraft.getMinecraft()).renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/models/entity/modelArmCannon.png"));

         GL11.glRotatef(45.0F, 0.0F, 0.0F, -45.0F);
         GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);

         GL11.glTranslatef(0.3F, 0.2F, 0.0F);

         GL11.glScalef(2.8F, 2.8F, 2.8F);

         this.modelArmCannon2.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.03125F);

         GL11.glPopMatrix();

       case EQUIPPED_FIRST_PERSON:
         GL11.glPushMatrix();

         (Minecraft.getMinecraft()).renderEngine.bindTexture(new ResourceLocation("fandomcraft:textures/models/entity/modelArmCannon.png"));

         GL11.glRotatef(45.0F, 0.0F, 0.0F, -45.0F);
         GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);

         GL11.glTranslatef(0.3F, 0.2F, 0.0F);

         GL11.glScalef(2.8F, 2.8F, 2.8F);

         this.modelArmCannon2.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.03125F);

         GL11.glPopMatrix();
         break;
     }
   }
 }