 package apocalypse.fandomcraft.fable;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.common.eventhandler.Event;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.renderer.texture.IIconRegister;
 import net.minecraft.enchantment.Enchantment;
 import net.minecraft.enchantment.EnchantmentHelper;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.projectile.EntityArrow;
 import net.minecraft.item.EnumAction;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.IIcon;
 import net.minecraft.world.World;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.event.entity.player.ArrowLooseEvent;
 import net.minecraftforge.event.entity.player.ArrowNockEvent;

 public class Crossbow extends Item {
   @SideOnly(Side.CLIENT)
   private IIcon[] iconArray;

   public Crossbow() {
     this.maxStackSize = 1;
     setMaxDamage(1000);
   }

   public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
     int j = getMaxItemUseDuration(par1ItemStack) - par4;

     ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
     MinecraftForge.EVENT_BUS.post((Event)event);
     if (event.isCanceled()) {
       return;
     }

     j = event.charge;

     boolean flag = (par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0);

     if (flag || par3EntityPlayer.inventory.hasItem(Main.bolt)) {

       float f = j / 20.0F;
       f = (f * f + f * 2.0F) / 3.0F;

       if (f < 0.1D) {
         return;
       }

       if (f > 1.0F)
       {
         f = 1.0F;
       }

       EntityArrow entityarrow = new EntityArrow(par2World, (EntityLivingBase)par3EntityPlayer, f * 2.0F);
       entityarrow.setDamage(entityarrow.getDamage() + 2.0D);

       if (f == 1.0F)
       {
         entityarrow.setIsCritical(true);
       }

       int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

       if (k > 0)
       {
         entityarrow.setDamage(entityarrow.getDamage() + k * 0.5D + 0.5D);
       }

       int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

       if (l > 0)
       {
         entityarrow.setKnockbackStrength(l);
       }

       if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
       {
         entityarrow.setFire(100);
       }

       par1ItemStack.damageItem(1, (EntityLivingBase)par3EntityPlayer);
       par2World.playSoundAtEntity((Entity)par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

       if (flag) {

         entityarrow.canBePickedUp = 2;
       }
       else {

         par3EntityPlayer.inventory.consumeInventoryItem(Main.bolt);
       }

       if (!par2World.isRemote)
       {
         par2World.spawnEntityInWorld((Entity)entityarrow);
       }
     }
   }

   public ItemStack onItemUseFinish(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
     return par1ItemStack;
   }

   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
     return 72000;
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

     if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Main.bolt))
     {
       par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
     }

     return par1ItemStack;
   }

   public int getItemEnchantability() {
     return 20;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
     this.itemIcon = par1IconRegister.registerIcon("fandomcraft:crossbow");
   }

   @SideOnly(Side.CLIENT)
   public IIcon getItemIconForUseDuration(int par1) {
     return this.iconArray[par1];
   }
 }