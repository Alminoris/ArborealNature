package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.FigeaterBeetleEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FigeaterBeetleRenderer extends GeoEntityRenderer<FigeaterBeetleEntity>
{
    public FigeaterBeetleRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new FigeaterBeetleModel());
    }

    @Override
    public Identifier getTextureLocation(FigeaterBeetleEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/figeater_beetle.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, FigeaterBeetleEntity entity, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour)
    {
        if (entity.isBaby())
            poseStack.scale(0.4f, 0.4f, 0.4f);
        else { poseStack.scale(1.0F, 1.0F, 1.0F); }
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}
