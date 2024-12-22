package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.MooseEntity;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
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
    public void setCustomAnimations(MooseEntity entity, long instanceId, AnimationState<MooseEntity> animationState)
    {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null && !entity.isSitting())
        {
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityModelData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
