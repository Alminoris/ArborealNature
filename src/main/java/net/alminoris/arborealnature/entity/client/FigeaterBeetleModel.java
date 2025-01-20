package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.CaribouEntity;
import net.alminoris.arborealnature.entity.custom.FigeaterBeetleEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FigeaterBeetleModel extends GeoModel<FigeaterBeetleEntity>
{
    @Override
    public Identifier getModelResource(FigeaterBeetleEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/figeater_beetle.geo.json");
    }

    @Override
    public Identifier getTextureResource(FigeaterBeetleEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/figeater_beetle.png");
    }

    @Override
    public Identifier getAnimationResource(FigeaterBeetleEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/figeater_beetle.animation.json");
    }

    @Override
    public void setCustomAnimations(FigeaterBeetleEntity animatable, long instanceId, AnimationState<FigeaterBeetleEntity> animationState)
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
