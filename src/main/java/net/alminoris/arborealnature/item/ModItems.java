package net.alminoris.arborealnature.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.item.custom.ChiselTool;
import net.alminoris.arborealnature.item.custom.StatusEffectArmorItem;
import net.alminoris.arborealnature.item.custom.SilentArrowItem;
import net.alminoris.arborealnature.item.custom.TransformableItem;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
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

    public static final Item SQUIRREL_HIDE = registerItem("squirrel_hide", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item WOOD_MOUSE_TAIL = registerItem("wood_mouse_tail", new Item(
            new Item.Settings().maxCount(16)));

    public static final Item FIGEATER_BEETLE_SHELL = registerItem("figeater_beetle_shell", new Item(
            new Item.Settings().maxCount(16)));

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

    public static Item registerSignItem(String name, Block signBlock, Block wallSignBlock)
    {
        return registerItem(name+"_sign", new SignItem(new Item.Settings().maxCount(16), signBlock, wallSignBlock));
    }

    public static Item registerHangingSignItem(String name, Block hangingSignBlock, Block wallHangingSignBlock)
    {
        return registerItem(name+"_hanging_sign", new HangingSignItem(hangingSignBlock, wallHangingSignBlock, new Item.Settings().maxCount(16)));
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
