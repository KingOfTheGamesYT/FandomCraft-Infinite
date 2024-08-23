 package apocalypse.fandomcraft.entity;

 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;

 public class koopaShell
   extends Item
 {
   public koopaShell() {
     setMaxStackSize(1);
   }

   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
     if (!player.capabilities.isCreativeMode)
     {
       stack.stackSize--;
     }

     world.playSoundAtEntity((Entity)player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
     world.playSoundAtEntity((Entity)player, "fandomcraft:koopaKick", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

     if (!world.isRemote)
     {
       world.spawnEntityInWorld((Entity)new EntityKoopaShell(world, (EntityLivingBase)player));
     }

     return stack;
   }
 }