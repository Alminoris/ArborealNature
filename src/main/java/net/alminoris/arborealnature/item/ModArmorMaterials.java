package net.alminoris.arborealnature.item;

import net.alminoris.arborealnature.ArborealNature;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials
{
    public static final RegistryEntry<ArmorMaterial> FIGEATER_BEETLE_SHELL = registerArmorMaterial("figeater_beetle_shell",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
            {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, () -> Ingredient.ofItems(ModItems.FIGEATER_BEETLE_SHELL),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ArborealNature.MOD_ID, "figeater_beetle_shell"))), 0,0));

    public static final RegistryEntry<ArmorMaterial> CARIBOU_FUR = registerArmorMaterial("caribou_fur",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
            {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(ModItems.CARIBOU_FUR),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ArborealNature.MOD_ID, "caribou_fur"))), 0.0f,0.0f));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material)
    {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(ArborealNature.MOD_ID, name), material.get());
    }
}
