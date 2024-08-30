package com.devmaster1015.fandomcraft.main;

import com.google.gson.JsonObject;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class AddChestLootModifier extends LootModifier {
    private final Item addition;
    private final int weight;
    private final int minCount;
    private final int maxCount;

    protected AddChestLootModifier(ILootCondition[] conditionsIn, Item addition, int weight, int minCount, int maxCount) {
        super(conditionsIn);
        this.addition = addition;
        this.weight = weight;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextInt(100) < weight) {
            int count = context.getRandom().nextInt(maxCount - minCount + 1) + minCount;
            generatedLoot.add(new ItemStack(addition, count));
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<AddChestLootModifier> {
        @Override
        public AddChestLootModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(JSONUtils.getString(object, "addition")));
            int weight = JSONUtils.getInt(object, "weight", 1);
            int minCount = JSONUtils.getInt(object, "minCount", 1);
            int maxCount = JSONUtils.getInt(object, "maxCount", 1);
            return new AddChestLootModifier(conditionsIn, addition, weight, minCount, maxCount);
        }

        @Override
        public JsonObject write(AddChestLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            json.addProperty("weight", instance.weight);
            json.addProperty("minCount", instance.minCount);
            json.addProperty("maxCount", instance.maxCount);
            return json;
        }
    }
}