package net.alminoris.arborealnature.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item HAZELNUT = registerItem("hazelnut", new Item(new Item.Settings()));

    public static final Item HAZELNUT_HANGING_SIGN = registerItem("hazelnut_hanging_sign", new SignItem(new Item.Settings().maxCount(16),
            ModBlocks.HAZELNUT_HANGING_SIGN, ModBlocks.HAZELNUT_WALL_HANGING_SIGN));

    public static final Item HAZELNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HAZELNUT_BOAT_ID, ModBoats.HAZELNUT_BOAT_KEY, false);

    public static final Item HAZELNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HAZELNUT_CHEST_BOAT_ID, ModBoats.HAZELNUT_BOAT_KEY, true);

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(ArborealNature.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(HAZELNUT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries ->
        {
            fabricItemGroupEntries.add(HAZELNUT_BOAT);
            fabricItemGroupEntries.add(HAZELNUT_CHEST_BOAT);
        });


    }
}
