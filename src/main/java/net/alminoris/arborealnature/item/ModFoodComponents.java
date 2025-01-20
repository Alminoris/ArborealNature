package net.alminoris.arborealnature.item;


import net.minecraft.item.FoodComponent;

public class ModFoodComponents
{
    public static final FoodComponent HAZELNUT = new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).build();

    public static final FoodComponent QUINCE = new FoodComponent.Builder().hunger(3).saturationModifier(0.35f).build();

    public static final FoodComponent PLUM = new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).build();

    public static final FoodComponent MANGO = new FoodComponent.Builder().hunger(3).saturationModifier(0.8f).build();

    public static final FoodComponent FIGS = new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build();

    public static final FoodComponent VIBURNUM = new FoodComponent.Builder().hunger(2).saturationModifier(0.35f).build();

    public static final FoodComponent WILD_CHERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.45f).build();

    public static final FoodComponent WHITE_MULBERRY = new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build();

    public static final FoodComponent MOOSE_VENISON = new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build();

    public static final FoodComponent COOKED_MOOSE_VENISON = new FoodComponent.Builder().hunger(10).saturationModifier(0.9f).build();

    public static final FoodComponent CARIBOU_VENISON = new FoodComponent.Builder().hunger(4).saturationModifier(0.35f).build();

    public static final FoodComponent COOKED_CARIBOU_VENISON = new FoodComponent.Builder().hunger(9).saturationModifier(0.85f).build();

    public static FoodComponent registerFood(int hunger, float saturation)
    {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build();
    }
}
