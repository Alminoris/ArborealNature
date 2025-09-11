package net.alminoris.arborealnature.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents
{
    public static final FoodComponent HAZELNUT = new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).build();

    public static final FoodComponent JUNIPER_BERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();

    public static final FoodComponent YEW_BERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.35f).build();

    public static final FoodComponent QUINCE = new FoodComponent.Builder().hunger(3).saturationModifier(0.35f).build();

    public static final FoodComponent PLUM = new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).build();

    public static final FoodComponent MANGO = new FoodComponent.Builder().hunger(3).saturationModifier(0.8f).build();

    public static final FoodComponent FIGS = new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build();

    public static final FoodComponent VIBURNUM = new FoodComponent.Builder().hunger(2).saturationModifier(0.35f).build();

    public static final FoodComponent WILD_CHERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.45f).build();

    public static final FoodComponent WHITE_MULBERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build();

    public static final FoodComponent MOOSE_VENISON = new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build();

    public static final FoodComponent COOKED_MOOSE_VENISON = new FoodComponent.Builder().hunger(10).saturationModifier(0.9f).build();

    public static final FoodComponent ELK_VENISON = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build();

    public static final FoodComponent COOKED_ELK_VENISON = new FoodComponent.Builder().hunger(10).saturationModifier(0.75f).build();

    public static final FoodComponent CARIBOU_VENISON = new FoodComponent.Builder().hunger(4).saturationModifier(0.35f).build();

    public static final FoodComponent COOKED_CARIBOU_VENISON = new FoodComponent.Builder().hunger(9).saturationModifier(0.85f).build();

    public static final FoodComponent DUCK = new FoodComponent.Builder().hunger(2).saturationModifier(0.45f).build();

    public static final FoodComponent COOKED_DUCK = new FoodComponent.Builder().hunger(6).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).build();

    public static final FoodComponent HERON = new FoodComponent.Builder().hunger(3).saturationModifier(0.475f).build();

    public static final FoodComponent COOKED_HERON = new FoodComponent.Builder().hunger(7).saturationModifier(0.775f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).build();

    public static FoodComponent registerFood(int hunger, float saturation)
    {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build();
    }
}