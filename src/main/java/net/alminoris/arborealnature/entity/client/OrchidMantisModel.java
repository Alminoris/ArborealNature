package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.OrchidMantisEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class OrchidMantisModel extends GeoModel<OrchidMantisEntity>
{
    @Override
    public Identifier getModelResource(OrchidMantisEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/orchid_mantis.geo.json");
    }

    @Override
    public Identifier getTextureResource(OrchidMantisEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/orchid_mantis.png");
    }

    @Override
    public Identifier getAnimationResource(OrchidMantisEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/orchid_mantis.animation.json");
    }

    @Override
    public void setCustomAnimations(OrchidMantisEntity animatable, long instanceId, AnimationState<OrchidMantisEntity> animationState)
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
