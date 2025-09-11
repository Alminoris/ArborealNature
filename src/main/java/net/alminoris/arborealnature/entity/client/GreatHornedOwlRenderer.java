package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.GreatHornedOwlEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GreatHornedOwlRenderer extends GeoEntityRenderer<GreatHornedOwlEntity>
{
    public GreatHornedOwlRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new GreatHornedOwlModel());
    }

    @Override
    public Identifier getTextureLocation(GreatHornedOwlEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/great_horned_owl.png");
    }

    @Override
    public void preRender(MatrixStack poseStack, GreatHornedOwlEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (entity.isBaby())
            poseStack.scale(0.55f, 0.55f, 0.55f);
        else { poseStack.scale(1.2F, 1.2F, 1.2F); }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}