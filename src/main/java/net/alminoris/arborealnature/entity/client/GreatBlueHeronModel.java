package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.GreatBlueHeronEntity;
import net.alminoris.arborealnature.entity.custom.MallardEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GreatBlueHeronModel extends GeoModel<GreatBlueHeronEntity>
{
    @Override
    public Identifier getModelResource(GreatBlueHeronEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/great_blue_heron.geo.json");
    }

    @Override
    public Identifier getTextureResource(GreatBlueHeronEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/great_blue_heron.png");
    }

    @Override
    public Identifier getAnimationResource(GreatBlueHeronEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/great_blue_heron.animation.json");
    }

    @Override
    public void setCustomAnimations(GreatBlueHeronEntity animatable, long instanceId, AnimationState<GreatBlueHeronEntity> animationState)
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
