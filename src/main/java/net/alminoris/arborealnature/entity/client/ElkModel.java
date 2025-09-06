package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.ElkEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ElkModel extends GeoModel<ElkEntity>
{
    @Override
    public Identifier getModelResource(ElkEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/elk.geo.json");
    }

    @Override
    public Identifier getTextureResource(ElkEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/elk.png");
    }

    @Override
    public Identifier getAnimationResource(ElkEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/elk.animation.json");
    }

    @Override
    public void setCustomAnimations(ElkEntity entity, long instanceId, AnimationState<ElkEntity> animationState)
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
