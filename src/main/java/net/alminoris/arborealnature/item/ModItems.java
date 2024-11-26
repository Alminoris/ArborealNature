package net.alminoris.arborealnature.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.custom.*;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

public class ModItems
{
    public static final Item SQUIRREL_SPAWN_EGG = registerItem("squirrel_spawn_egg", new SpawnEggItem(
            ModEntities.SQUIRREL, 0xC77510, 0XE8E1D3, new Item.Settings()));

    public static final Item WOOD_MOUSE_SPAWN_EGG = registerItem("wood_mouse_spawn_egg", new SpawnEggItem(
            ModEntities.WOOD_MOUSE, 0x9e8c6c, 0Xcdb8b3, new Item.Settings()));

    public static final Item FIGEATER_BEETLE_SPAWN_EGG = registerItem("figeater_beetle_spawn_egg", new SpawnEggItem(
            ModEntities.FIGEATER_BEETLE, 0x1e5f1d, 0X84632c, new Item.Settings()));

    public static final Item ORCHID_MANTIS_SPAWN_EGG = registerItem("orchid_mantis_spawn_egg", new SpawnEggItem(
            ModEntities.ORCHID_MANTIS, 0xffedff, 0Xff74ff, new Item.Settings()));

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

    public static final Item QUINCE = registerItem("quince",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.QUINCE)));

    public static final Item PLUM = registerItem("plum",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.PLUM)));

    public static final Item MANGO = registerItem("mango",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.MANGO)));

    public static final Item FIGS = registerItem("figs",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.FIGS)));

    public static final Item VIBURNUM = registerItem("viburnum",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.VIBURNUM)));

    public static final Item WILD_CHERRY = registerItem("wild_cherry",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.WILD_CHERRY)));

    public static final Item WHITE_MULBERRY = registerItem("white_mulberry",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.WHITE_MULBERRY)));

    public static final Item SQUIRREL_HIDE = registerItem("squirrel_hide", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item WOOD_MOUSE_TAIL = registerItem("wood_mouse_tail", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item FIGEATER_BEETLE_SHELL = registerItem("figeater_beetle_shell", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item ORCHID_MANTIS_INCISOR = registerItem("orchid_mantis_incisor", new OrchidMantisIncisorItem(
            ToolMaterials.STONE, new Item.Settings()
            .attributeModifiers(OrchidMantisIncisorItem.createAttributeModifiers(ToolMaterials.STONE, 4, -1.7f))
            .maxCount(1)));

    public static final Item FIGEATER_BEETLE_CHESTPLATE = registerItem("figeater_beetle_chestplate",
            new StatusEffectArmorItem(
                    ModArmorMaterials.FIGEATER_BEETLE_SHELL,
                    ArmorItem.Type.CHESTPLATE,
                    StatusEffects.SLOW_FALLING,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));

    public static final Item SILENT_ARROW = registerItem("silent_arrow", new SilentArrowItem(new Item.Settings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(ArborealNature.MOD_ID, name), item);
    }

    public static void registerModItems()
    {

    }

    public static Item registerBerryItem(String name, int nutrition, float saturation, Block block)
    {
        return registerItem(name, new AliasedBlockItem(block, new Item.Settings().maxCount(16).food(ModFoodComponents.registerFood(nutrition, saturation))));
    }

    public static Item registerBoatItem(Identifier boatID,  RegistryKey<TerraformBoatType> boatKey)
    {
        return TerraformBoatItemHelper.registerBoatItem(boatID, boatKey, false);
    }

    public static Item registerChestBoatItem(Identifier chestBoatID,  RegistryKey<TerraformBoatType> boatKey)
    {
        return TerraformBoatItemHelper.registerBoatItem(chestBoatID, boatKey, true);
    }
}
