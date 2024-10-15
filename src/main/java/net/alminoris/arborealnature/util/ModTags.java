package net.alminoris.arborealnature.util;

import net.alminoris.arborealnature.ArborealNature;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags
{
    public static class Blocks
    {
        private static TagKey<Block> createTag(String name)
        {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ArborealNature.MOD_ID, name));
        }
    }

    public static class Items
    {
        private static TagKey<Item> createTag(String name)
        {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ArborealNature.MOD_ID, name));
        }
    }
}
