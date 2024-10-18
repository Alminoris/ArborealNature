package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SquirrelModel extends GeoModel<SquirrelEntity>
{
    @Override
    public Identifier getModelResource(SquirrelEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/squirrel.geo.json");
    }

    @Override
    public Identifier getTextureResource(SquirrelEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/squirrel.png");
    }

    @Override
    public Identifier getAnimationResource(SquirrelEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/squirrel.animation.json");
    }

    @Override
    public void setCustomAnimations(SquirrelEntity animatable, long instanceId, AnimationState<SquirrelEntity> animationState)
    {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null)
        {
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityModelData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
