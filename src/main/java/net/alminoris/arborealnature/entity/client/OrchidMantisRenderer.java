package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.OrchidMantisEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OrchidMantisRenderer extends GeoEntityRenderer<OrchidMantisEntity>
{
    public OrchidMantisRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new OrchidMantisModel());
    }

    @Override
    public Identifier getTextureLocation(OrchidMantisEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/orchid_mantis.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, OrchidMantisEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        if (entity.isBaby())
        {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}