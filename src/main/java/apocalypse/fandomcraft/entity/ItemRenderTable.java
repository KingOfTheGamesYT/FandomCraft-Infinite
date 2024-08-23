 package apocalypse.fandomcraft.entity;

 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.item.ItemStack;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraftforge.client.IItemRenderer;
 import org.lwjgl.opengl.GL11;

 public class ItemRenderTable
   implements IItemRenderer
 {
   TileEntitySpecialRenderer render;
   private TileEntity entity;

   public ItemRenderTable(TileEntitySpecialRenderer render, TileEntity entity) {
     this.entity = entity;
     this.render = render;
   }

   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
     return true;
   }

   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
     return true;
   }

   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
     if (type == IItemRenderer.ItemRenderType.ENTITY)
       GL11.glTranslatef(-0.75F, 0.0F, -0.75F);
     GL11.glScaled(0.5D, 0.5D, 0.5D);
     this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
   }
 }