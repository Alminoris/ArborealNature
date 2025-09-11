package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.GreatHornedOwlEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GreatHornedOwlModel extends GeoModel<GreatHornedOwlEntity>
{
    @Override
    public Identifier getModelResource(GreatHornedOwlEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/great_horned_owl.geo.json");
    }

    @Override
    public Identifier getTextureResource(GreatHornedOwlEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/great_horned_owl.png");
    }

    @Override
    public Identifier getAnimationResource(GreatHornedOwlEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/great_horned_owl.animation.json");
    }

    @Override
    public void setCustomAnimations(GreatHornedOwlEntity animatable, long instanceId, AnimationState<GreatHornedOwlEntity> animationState)
    {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null)
        {
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityModelData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}