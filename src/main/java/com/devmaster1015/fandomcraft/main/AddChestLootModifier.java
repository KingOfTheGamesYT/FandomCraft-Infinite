package com.devmaster1015.fandomcraft.main;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
import java.util.ArrayList;
import java.util.List;

public class AddChestLootModifier extends LootModifier {
    private final List<LootEntry> entries;

    protected AddChestLootModifier(ILootCondition[] conditionsIn, List<LootEntry> entries) {
        super(conditionsIn);
        this.entries = entries;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        for (LootEntry entry : entries) {
            if (context.getRandom().nextInt(100) < entry.weight) {
                int count = context.getRandom().nextInt(entry.maxCount - entry.minCount + 1) + entry.minCount;
                generatedLoot.add(new ItemStack(entry.item, count));
            }
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<AddChestLootModifier> {
        @Override
        public AddChestLootModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            JsonArray entriesJson = JSONUtils.getJsonArray(object, "entries");
            List<LootEntry> entries = new ArrayList<>();

            for (JsonElement entryElement : entriesJson) {
                JsonObject entryObject = entryElement.getAsJsonObject();
                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(entryObject, "addition")));
                int weight = JSONUtils.getInt(entryObject, "weight", 1);
                int minCount = JSONUtils.getInt(entryObject, "minCount", 1);
                int maxCount = JSONUtils.getInt(entryObject, "maxCount", 1);
                entries.add(new LootEntry(item, weight, minCount, maxCount));
            }

            return new AddChestLootModifier(conditionsIn, entries);
        }

        @Override
        public JsonObject write(AddChestLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            JsonArray entriesJson = new JsonArray();

            for (LootEntry entry : instance.entries) {
                JsonObject entryJson = new JsonObject();
                entryJson.addProperty("addition", ForgeRegistries.ITEMS.getKey(entry.item).toString());
                entryJson.addProperty("weight", entry.weight);
                entryJson.addProperty("minCount", entry.minCount);
                entryJson.addProperty("maxCount", entry.maxCount);
                entriesJson.add(entryJson);
            }

            json.add("entries", entriesJson);
            return json;
        }
    }

    private static class LootEntry {
        final Item item;
        final int weight;
        final int minCount;
        final int maxCount;

        LootEntry(Item item, int weight, int minCount, int maxCount) {
            this.item = item;
            this.weight = weight;
            this.minCount = minCount;
            this.maxCount = maxCount;
        }
    }
}