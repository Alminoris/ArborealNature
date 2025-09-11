package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.MosquitoSwarmEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MosquitoSwarmRenderer extends GeoEntityRenderer<MosquitoSwarmEntity>
{
    public MosquitoSwarmRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new MosquitoSwarmModel());
    }

    @Override
    public Identifier getTextureLocation(MosquitoSwarmEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/mosquito_swarm.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, MosquitoSwarmEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (entity.isBaby())
        {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public RenderLayer getRenderType(MosquitoSwarmEntity animatable, Identifier texture,
                                     @Nullable VertexConsumerProvider bufferSource,
                                     float partialTick)
    {
        return RenderLayer.getEntityTranslucent(texture);
    }
}