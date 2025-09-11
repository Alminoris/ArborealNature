package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.MosquitoSwarmEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class MosquitoSwarmModel extends GeoModel<MosquitoSwarmEntity>
{
    @Override
    public Identifier getModelResource(MosquitoSwarmEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "geo/mosquito_swarm.geo.json");
    }

    @Override
    public Identifier getTextureResource(MosquitoSwarmEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/mosquito_swarm.png");
    }

    @Override
    public Identifier getAnimationResource(MosquitoSwarmEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "animations/mosquito_swarm.animation.json");
    }
}