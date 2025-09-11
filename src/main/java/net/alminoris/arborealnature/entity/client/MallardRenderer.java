package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.MallardEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MallardRenderer extends GeoEntityRenderer<MallardEntity>
{
    public MallardRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new MallardModel());
    }

    @Override
    public Identifier getTextureLocation(MallardEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/mallard.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, MallardEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (entity.isBaby())
            poseStack.scale(0.4f, 0.4f, 0.4f);
        else { poseStack.scale(1.0F, 1.0F, 1.0F); }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}