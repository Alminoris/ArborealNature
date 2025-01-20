package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.WolverineEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WolverineModel extends GeoModel<WolverineEntity>
{
    @Override
    public Identifier getModelResource(WolverineEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/wolverine.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolverineEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/wolverine.png");
    }

    @Override
    public Identifier getAnimationResource(WolverineEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/wolverine.animation.json");
    }

    @Override
    public void setCustomAnimations(WolverineEntity animatable, long instanceId, AnimationState<WolverineEntity> animationState)
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
