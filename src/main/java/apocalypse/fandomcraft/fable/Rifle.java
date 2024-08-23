 package apocalypse.fandomcraft.fable;

 import apocalypse.fandomcraft.main.Main;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import net.minecraft.client.renderer.texture.IIconRegister;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.EnumAction;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;

 public class Rifle
   extends Item
 {
   public Rifle() {
     this.maxStackSize = 1;
     setMaxDamage(2000);
   }

   public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int par4) {}

   public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player) {
     return stack;
   }

   public int getMaxItemUseDuration(ItemStack stack) {
     return 7200;
   }

   public EnumAction getItemUseAction(ItemStack stack) {
     return EnumAction.bow;
   }

   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
     if (player.inventory.hasItem(Main.bullet)) {

       ProjectileBullet bullet = new ProjectileBullet(world, (EntityLivingBase)player, 2.0F);
       world.spawnEntityInWorld((Entity)bullet);
       player.inventory.consumeInventoryItem(Main.bullet);
       player.playSound("fandomcraft:shot", 1.0F, 1.0F);

       stack.damageItem(1, (EntityLivingBase)player);
     }
     else {

       player.playSound("fandomcraft:emptyClip", 1.0F, 1.0F);
     }
     return stack;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister par1IconRegister) {
     this.itemIcon = par1IconRegister.registerIcon("fandomcraft:halsRifle");
   }
 }