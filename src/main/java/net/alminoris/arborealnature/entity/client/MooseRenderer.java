package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.MooseEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MooseRenderer extends GeoEntityRenderer<MooseEntity>
{
    public MooseRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new MooseModel());
    }

    @Override
    public Identifier getTextureLocation(MooseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/moose.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, MooseEntity entity, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour)
    {
        if (entity.isBaby())
        {
            poseStack.scale(0.6f, 0.6f, 0.6f);
            model.getBone("horn1").get().setHidden(true);
            model.getBone("horn2").get().setHidden(true);
        }
        else
        {
            poseStack.scale(1.2F, 1.2F, 1.2F);
            model.getBone("horn1").get().setHidden(false);
            model.getBone("horn2").get().setHidden(false);
        }

        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}