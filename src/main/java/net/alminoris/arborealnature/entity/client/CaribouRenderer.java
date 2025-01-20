package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.CaribouEntity;
import net.alminoris.arborealnature.entity.custom.MooseEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CaribouRenderer extends GeoEntityRenderer<CaribouEntity>
{
    public CaribouRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new CaribouModel());
    }

    @Override
    public Identifier getTextureLocation(CaribouEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/caribou.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, CaribouEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
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
            model.getBone("saddle").get().setHidden(!entity.isSaddled());
            model.getBone("horn1").get().setHidden(false);
            model.getBone("horn2").get().setHidden(false);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}