package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.LynxEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LynxModel extends GeoModel<LynxEntity>
{
    @Override
    public Identifier getModelResource(LynxEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/lynx.geo.json");
    }

    @Override
    public Identifier getTextureResource(LynxEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/lynx.png");
    }

    @Override
    public Identifier getAnimationResource(LynxEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/lynx.animation.json");
    }

    @Override
    public void setCustomAnimations(LynxEntity animatable, long instanceId, AnimationState<LynxEntity> animationState)
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
