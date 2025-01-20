package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.CaribouEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CaribouModel extends GeoModel<CaribouEntity>
{
    @Override
    public Identifier getModelResource(CaribouEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/caribou.geo.json");
    }

    @Override
    public Identifier getTextureResource(CaribouEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/caribou.png");
    }

    @Override
    public Identifier getAnimationResource(CaribouEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/caribou.animation.json");
    }

    @Override
    public void setCustomAnimations(CaribouEntity animatable, long instanceId, software.bernie.geckolib.core.animation.AnimationState<CaribouEntity> animationState)
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
