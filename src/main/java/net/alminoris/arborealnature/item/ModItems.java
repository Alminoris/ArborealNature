package net.alminoris.arborealnature.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.custom.*;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

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

    public static final Item MOOSE_SPAWN_EGG = registerItem("moose_spawn_egg", new SpawnEggItem(
            ModEntities.MOOSE, 0x110b08, 0X734c30, new Item.Settings()));

    public static final Item LYNX_SPAWN_EGG = registerItem("lynx_spawn_egg", new SpawnEggItem(
            ModEntities.LYNX, 0x926e4d, 0X533c25, new Item.Settings()));

    public static final Item CARIBOU_SPAWN_EGG = registerItem("caribou_spawn_egg", new SpawnEggItem(
            ModEntities.CARIBOU, 0x5a483d, 0Xa4a4a8, new Item.Settings()));

    public static final Item WOLVERINE_SPAWN_EGG = registerItem("wolverine_spawn_egg", new SpawnEggItem(
            ModEntities.WOLVERINE, 0x262c39, 0X4f3331, new Item.Settings()));

    public static final Item TENREC_SPAWN_EGG = registerItem("tenrec_spawn_egg", new SpawnEggItem(
            ModEntities.TENREC, 0x220f0b, 0Xd58728, new Item.Settings()));

    public static final Item MALLARD_SPAWN_EGG = registerItem("mallard_spawn_egg", new SpawnEggItem(
            ModEntities.MALLARD, 0xe0d4cd, 0X235329, new Item.Settings()));

    public static final Item GREAT_BLUE_HERON_SPAWN_EGG = registerItem("great_blue_heron_spawn_egg", new SpawnEggItem(
            ModEntities.GREAT_BLUE_HERON, 0xadb9cc, 0X28435e, new Item.Settings()));

    public static final Item MOSQUITO_SWARM_SPAWN_EGG = registerItem("mosquito_swarm_spawn_egg", new SpawnEggItem(
            ModEntities.MOSQUITO_SWARM, 0x3f3220, 0X330400, new Item.Settings()));

    public static final Item ELK_SPAWN_EGG = registerItem("elk_spawn_egg", new SpawnEggItem(
            ModEntities.ELK, 0x644a32, 0X362216, new Item.Settings()));

    public static final Item GREAT_HORNED_OWL_SPAWN_EGG = registerItem("great_horned_owl_spawn_egg", new SpawnEggItem(
            ModEntities.GREAT_HORNED_OWL, 0x534c49, 0X7a5f47, new Item.Settings()));

    public static final Item PINE_RESIN = registerItem("pine_resin_item", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item CRYPTOMERIA_RESIN = registerItem("cryptomeria_resin_item", new Item(
            new Item.Settings().maxCount(16)));

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

    public static final Item JUNIPER_BERRY = registerItem("juniper_berry",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.JUNIPER_BERRY)));

    public static final Item YEW_BERRY = registerItem("yew_berry",
            new Item(new Item.Settings().maxCount(16).food(ModFoodComponents.YEW_BERRY)));

    public static final Item MOOSE_VENISON = registerItem("moose_venison",
            new Item(new Item.Settings().food(ModFoodComponents.MOOSE_VENISON)));

    public static final Item COOKED_MOOSE_VENISON = registerItem("cooked_moose_venison",
            new Item(new Item.Settings().food(ModFoodComponents.COOKED_MOOSE_VENISON)));

    public static final Item ELK_VENISON = registerItem("elk_venison",
            new Item(new Item.Settings().food(ModFoodComponents.ELK_VENISON)));

    public static final Item COOKED_ELK_VENISON = registerItem("cooked_elk_venison",
            new Item(new Item.Settings().food(ModFoodComponents.COOKED_ELK_VENISON)));

    public static final Item CARIBOU_VENISON = registerItem("caribou_venison",
            new Item(new Item.Settings().food(ModFoodComponents.CARIBOU_VENISON)));

    public static final Item COOKED_CARIBOU_VENISON = registerItem("cooked_caribou_venison",
            new Item(new Item.Settings().food(ModFoodComponents.COOKED_CARIBOU_VENISON)));

    public static final Item DUCK = registerItem("duck",
            new Item(new Item.Settings().food(ModFoodComponents.DUCK)));

    public static final Item COOKED_DUCK = registerItem("cooked_duck",
            new Item(new Item.Settings().food(ModFoodComponents.COOKED_DUCK)));

    public static final Item HERON = registerItem("heron",
            new Item(new Item.Settings().food(ModFoodComponents.HERON)));

    public static final Item COOKED_HERON = registerItem("cooked_heron",
            new Item(new Item.Settings().food(ModFoodComponents.COOKED_HERON)));

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

    public static final Item CARIBOU_FUR = registerItem("caribou_fur", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item WOOD_MOUSE_TAIL = registerItem("wood_mouse_tail", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item FIGEATER_BEETLE_SHELL = registerItem("figeater_beetle_shell", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item MOOSE_HORN = registerItem("moose_horn", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item ELK_HORN = registerItem("elk_horn", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item CARIBOU_HORN = registerItem("caribou_horn", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item ORCHID_MANTIS_INCISOR = registerItem("orchid_mantis_incisor", new OrchidMantisIncisorItem(
            ToolMaterials.STONE, new Item.Settings()
            .attributeModifiers(OrchidMantisIncisorItem.createAttributeModifiers(ToolMaterials.STONE, 4, -1.7f))
            .maxCount(1)));

    public static final Item WOLVERINE_PAW = registerItem("wolverine_paw", new SwordItem(
            ToolMaterials.STONE, new Item.Settings()
            .attributeModifiers(OrchidMantisIncisorItem.createAttributeModifiers(ToolMaterials.STONE, 3, -1.0f))
            .maxCount(1)));

    public static final Item HUNTING_KNIFE = registerItem("hunting_knife", new ToolItem(
            ToolMaterials.STONE, new Item.Settings()
            .attributeModifiers(OrchidMantisIncisorItem.createAttributeModifiers(ToolMaterials.STONE, 1, -1f))
            .maxCount(1)));

    public static final Item FIGEATER_BEETLE_CHESTPLATE = registerItem("figeater_beetle_chestplate",
            new StatusEffectArmorItem(
                    ModArmorMaterials.FIGEATER_BEETLE_SHELL,
                    ArmorItem.Type.CHESTPLATE,
                    StatusEffects.SLOW_FALLING,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));

    public static final Item CARIBOU_FUR_HELMET = registerItem("caribou_fur_helmet",
            new ArmorItem(
                    ModArmorMaterials.CARIBOU_FUR,
                    ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(10))));

    public static final Item CARIBOU_FUR_CHESTPLATE = registerItem("caribou_fur_chestplate",
            new ArmorItem(
                    ModArmorMaterials.CARIBOU_FUR,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(10))));

    public static final Item CARIBOU_FUR_LEGGINGS = registerItem("caribou_fur_leggings",
            new ArmorItem(
                    ModArmorMaterials.CARIBOU_FUR,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(10))));

    public static final Item CARIBOU_FUR_BOOTS = registerItem("caribou_fur_boots",
            new ArmorItem(
                    ModArmorMaterials.CARIBOU_FUR,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(10))));

    public static final Item SILENT_ARROW = registerItem("silent_arrow", new SilentArrowItem(new Item.Settings()));

    public static final Item TENREC_NEEDLE = registerItem("tenrec_needle", new SwordItem(
            ToolMaterials.WOOD, new Item.Settings()
            .attributeModifiers(OrchidMantisIncisorItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2.0f))
            .maxCount(1)));

    public static final Item CARIBOU_SPEAR = registerItem("caribou_spear", new CaribouSpearItem(new Item.Settings().maxDamage(100)
            .attributeModifiers(CaribouSpearItem.createAttributeModifiers())
            .component(DataComponentTypes.TOOL, CaribouSpearItem.createToolComponent())));

    public static final Item ORCHID_LILY_PAD = registerItem("orchid_lily_pad_item", new PlaceableOnWaterItem(ModBlocks.ORCHID_LILY_PAD, new Item.Settings()));

    public static final Item WHITE_LILY_PAD = registerItem("white_lily_pad_item", new PlaceableOnWaterItem(ModBlocks.WHITE_LILY_PAD, new Item.Settings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(ArborealNature.MOD_ID, name), item);
    }

    public static void registerModItems()
    {

    }

    public static Item registerConeItem(String name)
    {
        return registerItem(name+"_cone", new Item(new Item.Settings().maxCount(16)));
    }

    public static Item registerBerryItem(String name, int nutrition, float saturation, Block block)
    {
        return registerItem(name+"_item", new AliasedBlockItem(block, new Item.Settings().maxCount(16).food(ModFoodComponents.registerFood(nutrition, saturation))));
    }

    public static Item registerBoatItem(Identifier boatID,  RegistryKey<TerraformBoatType> boatKey)
    {
        return TerraformBoatItemHelper.registerBoatItem(boatID, boatKey, false);
    }

    public static Item registerChestBoatItem(Identifier chestBoatID,  RegistryKey<TerraformBoatType> boatKey)
    {
        return TerraformBoatItemHelper.registerBoatItem(chestBoatID, boatKey, true);
    }

    public static Item registerSignItem(String name, Block signBlock, Block wallSignBlock)
    {
        return registerItem(name+"_sign_item", new SignItem(new Item.Settings().maxCount(16), signBlock, wallSignBlock));
    }

    public static Item registerHangingSignItem(String name, Block hangingSignBlock, Block wallHangingSignBlock)
    {
        return registerItem(name+"_hanging_sign_item", new HangingSignItem(hangingSignBlock, wallHangingSignBlock, new Item.Settings().maxCount(16)));
    }
}
