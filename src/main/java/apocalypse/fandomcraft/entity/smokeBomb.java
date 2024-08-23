 package apocalypse.fandomcraft.entity;

 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;

 public class smokeBomb
   extends Item
 {
   public smokeBomb() {
     setMaxStackSize(1);
   }

   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
     if (!player.capabilities.isCreativeMode)
     {
       stack.stackSize--;
     }

     world.playSoundAtEntity((Entity)player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

     if (!world.isRemote)
     {
       world.spawnEntityInWorld((Entity)new EntitySmokeBomb(world, (EntityLivingBase)player));
     }

     return stack;
   }
 }