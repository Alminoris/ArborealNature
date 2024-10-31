package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.alminoris.arborealnature.entity.custom.WoodMouseEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WoodMouseModel extends GeoModel<WoodMouseEntity>
{
    @Override
    public Identifier getModelResource(WoodMouseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/wood_mouse.geo.json");
    }

    @Override
    public Identifier getTextureResource(WoodMouseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/wood_mouse.png");
    }

    @Override
    public Identifier getAnimationResource(WoodMouseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/wood_mouse.animation.json");
    }

    @Override
    public void setCustomAnimations(WoodMouseEntity animatable, long instanceId, AnimationState<WoodMouseEntity> animationState)
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
