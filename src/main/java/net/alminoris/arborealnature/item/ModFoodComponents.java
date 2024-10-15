package net.alminoris.arborealnature.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents
{
    public static final FoodComponent HAZELNUT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200), 0.4f).build();
}
