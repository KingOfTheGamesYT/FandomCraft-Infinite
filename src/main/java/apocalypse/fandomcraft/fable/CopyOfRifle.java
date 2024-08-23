 package apocalypse.fandomcraft.fable;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.Event;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.renderer.texture.IIconRegister;
 import net.minecraft.enchantment.Enchantment;
 import net.minecraft.enchantment.EnchantmentHelper;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.EnumAction;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.IIcon;
 import net.minecraft.world.World;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.event.entity.player.ArrowLooseEvent;
 import net.minecraftforge.event.entity.player.ArrowNockEvent;

 public class CopyOfRifle
   extends Item {
   public static final float baseFOV = (Minecraft.getMinecraft()).gameSettings.fovSetting;
   public static int burstFire = 0;

   @SideOnly(Side.CLIENT)
   private IIcon[] iconArray;

   public CopyOfRifle() {
     this.maxStackSize = 1;
       setMaxDamage(2000);
   }

   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
     int ticksInUse = getMaxItemUseDuration(stack) - count;

     if (ticksInUse % 2 != 0)
     {
       burstFire = 0;
     }
   }

   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {}

   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
     return par1ItemStack;
   }

   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
     return 0;
   }

   public EnumAction getItemUseAction(ItemStack par1ItemStack) {
     return EnumAction.bow;
   }

   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
     ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
     MinecraftForge.EVENT_BUS.post((Event)event);
     if (event.isCanceled())
     {
       return event.result;
     }

     if (par3EntityPlayer.inventory.hasItem(Main.bullet)) {

       par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
       int j = 72000;

       ArrowLooseEvent event2 = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
       MinecraftForge.EVENT_BUS.post((Event)event2);
       j = event2.charge;

       boolean flag = (par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0);

       if (flag || par3EntityPlayer.inventory.hasItem(Main.bullet)) {

         float f = j / 20.0F;
         f = (f * f + f * 2.0F) / 3.0F;

         if (f > 1.0F)
         {
           f = 1.0F;
         }

         ProjectileBullet entitybullet = new ProjectileBullet(par2World, (EntityLivingBase)par3EntityPlayer, f * 2.0F);
         entitybullet.setDamage((entitybullet.power + 2.0F));

         if (f == 1.0F)
         {
           entitybullet.setIsCritical(true);
         }

         int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

         if (k > 0)
         {
           entitybullet.setDamage(entitybullet.power + k * 0.5D + 0.5D);
         }

         int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);


         if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
         {
           entitybullet.setFire(100);
         }

         par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
         par2World.playSoundAtEntity((Entity)par3EntityPlayer, "fandomcraft:gunshot", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

         par3EntityPlayer.inventory.consumeInventoryItem(Main.bullet);

         if (!par2World.isRemote)
         {
           par2World.spawnEntityInWorld((Entity)entitybullet);
         }
       }
     }

     return par1ItemStack;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
     this.itemIcon = par1IconRegister.registerIcon("fandomcraft:halsRifle");
   }

   @SideOnly(Side.CLIENT)
   public IIcon getItemIconForUseDuration(int par1) {
     return this.iconArray[par1];
   }
 }