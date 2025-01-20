package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SquirrelRenderer extends GeoEntityRenderer<SquirrelEntity>
{
    private final ItemRenderer itemRenderer;

    public SquirrelRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new SquirrelModel());

        this.itemRenderer = renderManager.getItemRenderer();
    }

    @Override
    public Identifier getTextureLocation(SquirrelEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/squirrel.png");
    }

    @Override
    public void postRender(MatrixStack poseStack, SquirrelEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        this.renderHeldItem(entity, poseStack, bufferSource, packedLight);
        super.postRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void preRender(MatrixStack poseStack, SquirrelEntity entity, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        if (entity.isBaby())
            poseStack.scale(0.4f, 0.4f, 0.4f);
        else { poseStack.scale(1.0F, 1.0F, 1.0F); }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    private void renderHeldItem(SquirrelEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light)
    {
        // Get the item in the squirrel's main hand
        ItemStack itemStack = entity.getStackInHand(Hand.MAIN_HAND);

        if (!itemStack.isEmpty())
        {
            // Get the model of the item to be rendered
            BakedModel model = this.itemRenderer.getModel(itemStack, entity.getWorld(), entity, 0);

            matrices.push();
            matrices.translate(0.0D, 0.5D, 0.0D);
            matrices.scale(0.5F, 0.5F, 0.5F);

            this.itemRenderer.renderItem(itemStack,
                    ModelTransformationMode.THIRD_PERSON_RIGHT_HAND,
                    false,
                    matrices,
                    vertexConsumers,
                    light,
                    0,
                    model);

            matrices.pop();
        }
    }
}
