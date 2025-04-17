package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.TenrecEntity;
import net.alminoris.arborealnature.entity.custom.WoodMouseEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TenrecModel extends GeoModel<TenrecEntity>
{
    @Override
    public Identifier getModelResource(TenrecEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/tenrec.geo.json");
    }

    @Override
    public Identifier getTextureResource(TenrecEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/tenrec.png");
    }

    @Override
    public Identifier getAnimationResource(TenrecEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/tenrec.animation.json");
    }

    @Override
    public void setCustomAnimations(TenrecEntity animatable, long instanceId, AnimationState<TenrecEntity> animationState)
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