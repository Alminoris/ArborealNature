package net.alminoris.arborealnature.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents
{
    public static final FoodComponent HAZELNUT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();

    public static final FoodComponent JUNIPER_BERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();

    public static final FoodComponent YEW_BERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.35f).build();

    public static final FoodComponent QUINCE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.35f).build();

    public static final FoodComponent PLUM = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();

    public static final FoodComponent MANGO = new FoodComponent.Builder().nutrition(3).saturationModifier(0.8f).build();

    public static final FoodComponent FIGS = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();

    public static final FoodComponent VIBURNUM = new FoodComponent.Builder().nutrition(2).saturationModifier(0.35f).build();

    public static final FoodComponent WILD_CHERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.45f).build();

    public static final FoodComponent WHITE_MULBERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).build();

    public static final FoodComponent MOOSE_VENISON = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f).build();

    public static final FoodComponent COOKED_MOOSE_VENISON = new FoodComponent.Builder().nutrition(10).saturationModifier(0.9f).build();

    public static final FoodComponent CARIBOU_VENISON = new FoodComponent.Builder().nutrition(4).saturationModifier(0.35f).build();

    public static final FoodComponent COOKED_CARIBOU_VENISON = new FoodComponent.Builder().nutrition(9).saturationModifier(0.85f).build();

    public static final FoodComponent DUCK = new FoodComponent.Builder().nutrition(2).saturationModifier(0.45f).build();

    public static final FoodComponent COOKED_DUCK = new FoodComponent.Builder().nutrition(6).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).build();

    public static FoodComponent registerFood(int nutrition, float saturation)
    {
        return new FoodComponent.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }
}
