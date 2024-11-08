package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.FigeaterBeetleEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
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
    public void render(FigeaterBeetleEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight)
    {
        if (entity.isBaby())
            poseStack.scale(0.4f, 0.4f, 0.4f);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
