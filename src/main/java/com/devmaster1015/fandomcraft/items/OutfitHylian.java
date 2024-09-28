package com.devmaster1015.fandomcraft.items;

import com.devmaster1015.fandomcraft.main.FandomCraft;
import com.devmaster1015.fandomcraft.util.RegistryHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class OutfitHylian extends ArmorItem {
    private int t;

    public OutfitHylian(IArmorMaterial material, EquipmentSlotType slot, Rarity rarity) {
        super(material, slot, get(rarity));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        // Armor slot items
        ItemStack crown = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack armor = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack chainmail = player.getItemStackFromSlot(EquipmentSlotType.LEGS);

        if (!crown.isEmpty() && !armor.isEmpty() && !chainmail.isEmpty()) {
            if (crown.getItem() == RegistryHandler.MAGIC_CROWN.get() &&
                    armor.getItem() == RegistryHandler.MAGIC_ARMOR.get() &&
                    chainmail.getItem() == RegistryHandler.MAGIC_CHAINMAIL.get()) {

                if (player.inventory.hasItemStack(new ItemStack(RegistryHandler.RUPEE_GREEN.get()))) {
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 5, true, false, true));

                    if (this.t == 60) {
                        // Manually remove 1 rupee from the inventory
                        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                            ItemStack itemStack = player.inventory.getStackInSlot(i);  // Get the item in the slot
                            if (itemStack.getItem() == RegistryHandler.RUPEE_GREEN.get()) {
                                itemStack.shrink(1);  // Remove 1 rupee
                                if (itemStack.isEmpty()) {
                                    player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);  // Clear slot if empty
                                }
                                break;  // Exit loop once 1 rupee is removed
                            }
                        }
                        this.t = 0;  // Reset the timer
                    } else {
                        this.t++;
                    }
                } else {
                    player.addVelocity(0, -0.1, 0);  // Push down if no rupees
                    player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 5, true, false, true));  // Add slowness effect
                    player.removePotionEffect(Effects.RESISTANCE);
                }
            }
        }
        // Check for boots (apply slowness effect)
        ItemStack boots = player.getItemStackFromSlot(EquipmentSlotType.FEET);
        if (!boots.isEmpty() && boots.getItem() == RegistryHandler.MEGATON_BOOTS.get()) {
            if (!player.isPotionActive(Effects.SLOWNESS)) {
                player.addVelocity(0, -0.1, 0);  // Push down if no rupees
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 5, true, false, true));  // Add slowness effect
            }
        }
    }

    protected static final Properties get(Rarity rarity) {
        return new Properties().maxStackSize(1).group(FandomCraft.tabFandomCraftOutfits).rarity(rarity);
    }
}