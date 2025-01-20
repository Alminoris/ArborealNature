package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.MooseEntity;
import net.alminoris.arborealnature.entity.custom.WolverineEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WolverineRenderer extends GeoEntityRenderer<WolverineEntity>
{
    public WolverineRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new WolverineModel());
    }

    @Override
    public Identifier getTextureLocation(WolverineEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/wolverine.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, WolverineEntity entity, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour)
    {
        if (entity.isBaby())
        {
            poseStack.scale(0.6f, 0.6f, 0.6f);
        }
        else
        {
            poseStack.scale(1.2F, 1.2F, 1.2F);
        }

        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}