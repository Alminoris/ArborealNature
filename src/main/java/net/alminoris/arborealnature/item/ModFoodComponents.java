package net.alminoris.arborealnature.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents
{
    public static final FoodComponent HAZELNUT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();

    public static final FoodComponent QUINCE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.35f).build();

    public static final FoodComponent PLUM = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();

    public static final FoodComponent MANGO = new FoodComponent.Builder().nutrition(3).saturationModifier(0.8f).build();
}
