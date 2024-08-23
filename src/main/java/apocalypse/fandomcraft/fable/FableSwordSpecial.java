 package apocalypse.fandomcraft.fable;

 import com.google.common.collect.Multimap;
 import cpw.mods.fml.relauncher.Side;
 import cpw.mods.fml.relauncher.SideOnly;
 import java.awt.List;
import java.util.UUID;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.attributes.AttributeModifier;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.EnumAction;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;

 public class FableSwordSpecial
   extends Item
 {
   public static float attackDamage;
   public static boolean isBreakable;
   public static String lore;
   public static int effectType;
   public static Item itemRepair;
   public static Potion hitEffect;
   public static int potionDuration;
   public static int potionLevel;

   public FableSwordSpecial(String description, int uses, float attack, boolean breakable, int type, Item item, Potion potion, int duration, int effectLevel) {
     potionDuration = duration;
     potionLevel = effectLevel;
     hitEffect = potion;
     itemRepair = item;
     this.maxStackSize = 1;
     attackDamage = attack;
     lore = description;
     effectType = type;
     if (breakable = true) {

       setMaxDamage(-1);
     }
     else {

       setMaxDamage(uses);
     }
   }

   public void addInformation(ItemStack par1ItemStack, List par2List) {
/*  57 */     par2List.add(lore);
/*     */   }

   public float func_150931_i() {
     return attackDamage;
   }

   public float getStrVsBlock(ItemStack stack, Block block) {
     if (block == Blocks.web)
     {
       return 15.0F;
     }

     Material material = block.getMaterial();
     return (material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd) ? 1.0F : 1.5F;
   }

   public boolean hitEntity(ItemStack stack, EntityLivingBase player, EntityLivingBase target) {
     if (isBreakable = true)
     {
       stack.damageItem(1, player);
     }
     if (hitEffect != null)
       target.addPotionEffect(new PotionEffect(hitEffect.id, potionDuration, potionLevel));
     return true;
   }


   public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
     if (p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
     {
       p_150894_1_.damageItem(2, p_150894_7_);
     }

     return true;
   }

   @SideOnly(Side.CLIENT)
   public boolean isFull3D() {
     return true;
   }

   public EnumAction getItemUseAction(ItemStack p_77661_1_) {
     return EnumAction.block;
   }

   public int getMaxDamage(ItemStack p_77626_1_) {
     return 72000;
   }

   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
     p_77659_3_.setItemInUse(p_77659_1_, getMaxItemUseDuration(p_77659_1_));
     return p_77659_1_;
   }

   public boolean canItemHarvestBlock(Block p_150897_1_) {
     return (p_150897_1_ == Blocks.web);
   }

   public boolean getIsRepairable(ItemStack stack, ItemStack p_82789_2_) {
     return (stack.getItem() == itemRepair);
   }

   public Multimap getItemAttributeModifiers() {
     Multimap multimap = super.getItemAttributeModifiers();
     multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.randomUUID(), "Weapon modifier", attackDamage, 0));
     return multimap;
   }
 }