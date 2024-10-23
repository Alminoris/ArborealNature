package net.alminoris.arborealnature.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.custom.ChiselTool;
import net.alminoris.arborealnature.item.custom.TransformableItem;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item SQUIRREL_SPAWN_EGG = registerItem("squirrel_spawn_egg", new SpawnEggItem(
            ModEntities.SQUIRREL, 0xC77510, 0XE8E1D3, new Item.Settings()));

    public static final Item HAZELNUT_CRACKED = registerItem("hazelnut_cracked", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item HAZELNUT_SPOILED = registerItem("hazelnut_spoiled", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item MINIHAMMER = registerItem("minihammer", new ToolItem(
            ToolMaterials.IRON, new Item.Settings().maxCount(1)));

    public static final Item CHISEL = registerItem("chisel", new ChiselTool(
            ToolMaterials.IRON, new Item.Settings().maxCount(1)));

    public static final Item HAZELNUT = registerItem("hazelnut",
            new TransformableItem(HAZELNUT_CRACKED, HAZELNUT_SPOILED, MINIHAMMER, 0.25f, new Item.Settings().maxCount(16)));

    public static final Item HAZELNUT_PEELED = registerItem("hazelnut_peeled",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.HAZELNUT)));

    /*public static final Item HAZELNUT_SIGN = registerItem("hazelnut_sign",
            new SignItem(new Item.Settings().maxCount(16),
                    ModBlocks.HAZELNUT_SIGN, ModBlocks.HAZELNUT_WALL_SIGN));

    public static final Item HAZELNUT_HANGING_SIGN = registerItem("hazelnut_hanging_sign",
            new HangingSignItem(ModBlocks.HAZELNUT_HANGING_SIGN, ModBlocks.HAZELNUT_WALL_HANGING_SIGN,
                    new Item.Settings().maxCount(16)));

    public static final Item HAZELNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(
            ModBoats.HAZELNUT_BOAT_ID, ModBoats.HAZELNUT_BOAT_KEY, false);

    public static final Item HAZELNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(
            ModBoats.HAZELNUT_CHEST_BOAT_ID, ModBoats.HAZELNUT_BOAT_KEY, true);*/

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(ArborealNature.MOD_ID, name), item);
    }

    public static void registerModItems()
    {

    }

    public static Item registerSignItem(String name, Block signBlock, Block wallSignBlock)
    {
        return registerItem(name+"_sign", new SignItem(new Item.Settings().maxCount(16), signBlock, wallSignBlock));
    }

    public static Item registerHangingSignItem(String name, Block hangingSignBlock, Block wallHangingSignBlock)
    {
        return registerItem(name+"_hanging_sign", new HangingSignItem(hangingSignBlock, wallHangingSignBlock, new Item.Settings().maxCount(16)));
    }

    public static Item registerBoatItem(String name, Identifier boatID,  RegistryKey<TerraformBoatType> boatKey)
    {
        return TerraformBoatItemHelper.registerBoatItem(boatID, boatKey, false);
    }

    public static Item registerChestBoatItem(String name, Identifier chestBoatID,  RegistryKey<TerraformBoatType> boatKey)
    {
        return TerraformBoatItemHelper.registerBoatItem(chestBoatID, boatKey, true);
    }
}
