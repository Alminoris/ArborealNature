package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.LynxEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LynxRenderer extends GeoEntityRenderer<LynxEntity>
{
    public LynxRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new LynxModel());
    }

    @Override
    public Identifier getTextureLocation(LynxEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/lynx.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, LynxEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        if (entity.isBaby())
        {
            poseStack.scale(0.4f, 0.4f, 0.4f);
            model.getBone("head").get().updateScale(1.3f, 1.3f, 1.3f);
        }
        else
        {
            poseStack.scale(1.0F, 1.0F, 1.0F);
            model.getBone("head").get().updateScale(1.0f, 1.0f, 1.0f);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}