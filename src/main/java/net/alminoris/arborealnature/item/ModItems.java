package net.alminoris.arborealnature.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.item.custom.TransformableItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item HAZELNUT_CRACKED = registerItem("hazelnut_cracked", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item HAZELNUT_SPOILED = registerItem("hazelnut_spoiled", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item MINIHAMMER = registerItem("minihammer", new ToolItem(
            ToolMaterials.IRON, new Item.Settings().maxCount(1)));

    public static final Item CHISEL = registerItem("chisel", new ToolItem(
            ToolMaterials.IRON, new Item.Settings().maxCount(1)));

    public static final Item HAZELNUT = registerItem("hazelnut",
            new TransformableItem(HAZELNUT_CRACKED, HAZELNUT_SPOILED, MINIHAMMER, 0.25f, new Item.Settings().maxCount(16)));

    public static final Item HAZELNUT_PEELED = registerItem("hazelnut_peeled",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.HAZELNUT)));

    public static final Item HAZELNUT_HANGING_SIGN = registerItem("hazelnut_hanging_sign",
            new SignItem(new Item.Settings().maxCount(16),
            ModBlocks.HAZELNUT_HANGING_SIGN, ModBlocks.HAZELNUT_WALL_HANGING_SIGN));

    public static final Item HAZELNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(
            ModBoats.HAZELNUT_BOAT_ID, ModBoats.HAZELNUT_BOAT_KEY, false);

    public static final Item HAZELNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(
            ModBoats.HAZELNUT_CHEST_BOAT_ID, ModBoats.HAZELNUT_BOAT_KEY, true);

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(ArborealNature.MOD_ID, name), item);
    }

    public static void registerModItems()
    {

    }
}
