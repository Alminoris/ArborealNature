package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.TenrecEntity;
import net.alminoris.arborealnature.entity.custom.WoodMouseEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TenrecRenderer extends GeoEntityRenderer<TenrecEntity>
{
    public TenrecRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new TenrecModel());
    }

    @Override
    public Identifier getTextureLocation(TenrecEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/tenrec.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, TenrecEntity entity, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour)
    {
        if (entity.isBaby())
            poseStack.scale(0.4f, 0.4f, 0.4f);
        else { poseStack.scale(0.8F, 0.8F, 0.8F); }
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }
}
