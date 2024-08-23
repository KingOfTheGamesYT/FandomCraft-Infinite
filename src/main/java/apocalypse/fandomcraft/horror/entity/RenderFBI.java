 package apocalypse.fandomcraft.horror.entity;

 import apocalypse.fandomcraft.horror.HorrorReg;
 import com.mojang.authlib.GameProfile;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import java.util.UUID;
 import net.minecraft.block.Block;
 import net.minecraft.client.renderer.RenderBlocks;
 import net.minecraft.client.renderer.entity.RenderBiped;
 import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLiving;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.nbt.NBTUtil;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.StringUtils;
 import net.minecraftforge.client.IItemRenderer;
 import net.minecraftforge.client.MinecraftForgeClient;
 import org.lwjgl.opengl.GL11;

 @SideOnly(Side.CLIENT)
 public class RenderFBI
   extends RenderBiped
 {
   private float scale;
   private static final ResourceLocation textures = new ResourceLocation("fandomcraft:textures/models/entity/fbi.png");

   public ModelFBI modelFBI;

   public RenderFBI(ModelFBI base, float f, float s) {
     super(base, f * s);
     this.scale = s;
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
     return textures;
   }

   protected void preRenderCallback(EntityFBI p_77041_1_, float p_77041_2_) {
     GL11.glScalef(this.scale, this.scale, this.scale);
   }

   protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
     preRenderCallback((EntityFBI)p_77041_1_, p_77041_2_);
   }

   protected void renderEquippedItems(EntityLiving p_77029_1_, float p_77029_2_) {
     GL11.glColor3f(1.0F, 1.0F, 1.0F);
     super.renderEquippedItems(p_77029_1_, p_77029_2_);
     ItemStack itemstack = p_77029_1_.getHeldItem();
     ItemStack itemstack1 = p_77029_1_.func_130225_q(3);

     if (itemstack1 != null) {

       GL11.glPushMatrix();
       this.modelFBI.bipedHead.postRender(0.0625F);
       Item item = itemstack1.getItem();

       IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, IItemRenderer.ItemRenderType.EQUIPPED);
       boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, IItemRenderer.ItemRendererHelper.BLOCK_3D));

       if (item instanceof net.minecraft.item.ItemBlock) {

         if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType())) {

           float f1 = 0.625F;
           GL11.glTranslatef(0.0F, -0.25F, 0.0F);
           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
           GL11.glScalef(f1, -f1, -f1);
         }

         this.renderManager.itemRenderer.renderItem((EntityLivingBase)p_77029_1_, itemstack1, 0);
       }
       else if (item == Items.skull) {

         float f1 = 1.0625F;
         GL11.glScalef(f1, -f1, -f1);
         GameProfile gameprofile = null;

         if (itemstack1.hasTagCompound()) {

           NBTTagCompound nbttagcompound = itemstack1.getTagCompound();

           if (nbttagcompound.hasKey("SkullOwner", 10)) {

             gameprofile = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("SkullOwner"));
           }
           else if (nbttagcompound.hasKey("SkullOwner", 8) && !StringUtils.isNullOrEmpty(nbttagcompound.getString("SkullOwner"))) {

             gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
           }
         }

         TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack1.getItemSpriteNumber(), gameprofile);
       }

       GL11.glPopMatrix();
     }

     if (itemstack != null && itemstack.getItem() != null) {

       Item item = itemstack.getItem();
       GL11.glPushMatrix();

       if (this.mainModel.isChild) {

         float f1 = 0.5F;
         GL11.glTranslatef(0.0F, 0.625F, 0.0F);
         GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
         GL11.glScalef(f1, f1, f1);
       }

       GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

       IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
       boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D));

       if (item instanceof net.minecraft.item.ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType()))) {

         float f1 = 0.5F;
         GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
         f1 *= 0.75F;
         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(-f1, -f1, f1);
       }
       else if (item == HorrorReg.handgun) {

         float f1 = 0.625F;
         GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
         GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(f1, -f1, f1);
         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
       }
       else if (item.isFull3D()) {

         float f1 = 0.625F;

         if (item.shouldRotateAroundWhenRendering()) {

           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
           GL11.glTranslatef(0.0F, -0.125F, 0.0F);
         }

         func_82422_c();
         GL11.glScalef(f1, -f1, f1);
         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
       }
       else {

         float f1 = 0.375F;
         GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
         GL11.glScalef(f1, f1, f1);
         GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
       }

       if (itemstack.getItem().requiresMultipleRenderPasses()) {

        for (int i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemSpriteNumber()); i++)
         {
           int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
           float f5 = (j >> 16 & 0xFF) / 255.0F;
           float f2 = (j >> 8 & 0xFF) / 255.0F;
           float f3 = (j & 0xFF) / 255.0F;
           GL11.glColor4f(f5, f2, f3, 1.0F);
           this.renderManager.itemRenderer.renderItem((EntityLivingBase)p_77029_1_, itemstack, i);
         }

       } else {

         int i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
         float f4 = (i >> 16 & 0xFF) / 255.0F;
         float f5 = (i >> 8 & 0xFF) / 255.0F;
         float f2 = (i & 0xFF) / 255.0F;
         GL11.glColor4f(f4, f5, f2, 1.0F);
         this.renderManager.itemRenderer.renderItem((EntityLivingBase)p_77029_1_, itemstack, 0);
       }

       GL11.glPopMatrix();
     }
   }
 }