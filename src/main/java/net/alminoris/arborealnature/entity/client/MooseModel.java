package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.MooseEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MooseModel extends GeoModel<MooseEntity>
{
    @Override
    public Identifier getModelResource(MooseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/moose.geo.json");
    }

    @Override
    public Identifier getTextureResource(MooseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/moose.png");
    }

    @Override
    public Identifier getAnimationResource(MooseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/moose.animation.json");
    }

    @Override
    public void setCustomAnimations(MooseEntity animatable, long instanceId, AnimationState<MooseEntity> animationState)
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