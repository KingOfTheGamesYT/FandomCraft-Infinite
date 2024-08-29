package com.devmaster1015.fandomcraft.blocks;

import com.devmaster1015.fandomcraft.main.RegistryHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LootTableModifier {

        private static final List<WeightedDrop> DROPS = new ArrayList<>();
        private static final int TOTAL_WEIGHT;

        static {
            DROPS.add(new WeightedDrop(RegistryHandler.RUPEE_GREEN, 15));
            DROPS.add(new WeightedDrop(RegistryHandler.RUPEE_BLUE, 2));
            DROPS.add(new WeightedDrop(RegistryHandler.RUPEE_YELLOW, 1));
            DROPS.add(new WeightedDrop(() -> Items.ARROW, 10));
            DROPS.add(new WeightedDrop(RegistryHandler.ESSENCE_OF_NATURE, 1));

            int totalWeight = 0;
            for (WeightedDrop drop : DROPS) {
                totalWeight += drop.weight;
            }
            TOTAL_WEIGHT = totalWeight;
        }

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void onBlockBreak(BlockEvent.BreakEvent event) {
            PlayerEntity player = event.getPlayer();
            ItemStack heldItem = player.getHeldItemMainhand();
            BlockState state = event.getState();

            if ((state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.TALL_GRASS)
                    && heldItem.getItem() instanceof SwordItem) {
                World world = (World) event.getWorld();
                BlockPos pos = event.getPos();

                if (world instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld) world;
                    ItemStack drop = getWeightedDrop(serverWorld.getRandom());
                    if (!drop.isEmpty()) {
                        spawnItemStack(serverWorld, pos, drop);
                    }
                    // Damage the sword
                    if (!player.abilities.isCreativeMode) {
                        heldItem.damageItem(1, player, (entity) -> entity.sendBreakAnimation(player.getActiveHand()));
                    }
                    // Cancel the event to prevent normal drops
                    event.setCanceled(true);
                    // Set the block to air manually since we canceled the event
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                }
            }
        }

        private static ItemStack getWeightedDrop(Random random) {
            int roll = random.nextInt(TOTAL_WEIGHT);
            int currentTotal = 0;
            for (WeightedDrop drop : DROPS) {
                currentTotal += drop.weight;
                if (roll < currentTotal) {
                    return new ItemStack(drop.item.get());
                }
            }
            return ItemStack.EMPTY;
        }

        private static void spawnItemStack(ServerWorld world, BlockPos pos, ItemStack stack) {
            double d0 = world.rand.nextFloat() * 0.5 + 0.25;
            double d1 = world.rand.nextFloat() * 0.5 + 0.25;
            double d2 = world.rand.nextFloat() * 0.5 + 0.25;
            ItemEntity itemEntity = new ItemEntity(world, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2, stack);
            itemEntity.setDefaultPickupDelay();
            world.addEntity(itemEntity);
        }

        private static class WeightedDrop {
            final Supplier<Item> item;
            final int weight;

            WeightedDrop(Supplier<Item> item, int weight) {
                this.item = item;
                this.weight = weight;
            }
        }
    }