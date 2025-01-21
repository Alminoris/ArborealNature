package net.alminoris.arborealnature.util;

import net.alminoris.arborealnature.ArborealNature;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> CHISELABLE_BLOCKS = createTag("chiselable_blocks");

        public static final TagKey<Block> ORCHID_MANTIS_FLOWERS = createTag("orchid_mantis_flowers");

        public static final TagKey<Block> MOOSE_SPAWNABLE_ON = createTag("moose_spawnable_on");

        public static final TagKey<Block> CARIBOU_SPAWNABLE_ON = createTag("caribou_spawnable_on");

        public static final TagKey<Block> WOLVERINE_SPAWNABLE_ON = createTag("wolverine_spawnable_on");

        public static final TagKey<Block> LOGS_TO_BE_BURNT = createTag("logs_to_be_burnt");

        public static final TagKey<Block> INTEGRATION_CHISELABLE_BLOCKS = createTag("integration_chiselable_blocks");

        public static final TagKey<Block> INTEGRATION_LOGS_TO_BE_BURNT = createTag("integration_logs_to_be_burnt");

        private static TagKey<Block> createTag(String name)
        {
            return TagKey.of(Registry.BLOCK_KEY, Identifier.of(ArborealNature.MOD_ID, name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> SQUIRREL_FOOD = createTag("squirrel_food");

        public static final TagKey<Item> MOOSE_FOOD = createTag("moose_food");

        public static final TagKey<Item> LYNX_FOOD = createTag("lynx_food");

        public static final TagKey<Item> CARIBOU_FOOD = createTag("caribou_food");

        public static final TagKey<Item> WOLVERINE_FOOD = createTag("wolverine_food");

        private static TagKey<Item> createTag(String name)
        {
            return TagKey.of(Registry.ITEM_KEY, Identifier.of(ArborealNature.MOD_ID, name));
        }
    }

    public static class Entities
    {
        public static final TagKey<EntityType<?>> LEATHER_DROPPERS = createTag("leather_droppers");

        private static TagKey<EntityType<?>> createTag(String name)
        {
            return TagKey.of(Registry.ENTITY_TYPE_KEY, Identifier.of(ArborealNature.MOD_ID, name));
        }
    }
}
