package net.alminoris.arborealnature.entity.client.projectile;

import net.alminoris.arborealnature.entity.custom.projectile.CaribouSpearEntity;
import net.alminoris.arborealnature.item.ModItems;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class CaribouSpearEntityRenderer extends EntityRenderer<CaribouSpearEntity>
{
    private final ItemRenderer itemRenderer;

    public CaribouSpearEntityRenderer(EntityRendererFactory.Context context)
    {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CaribouSpearEntity caribouSpearEntity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light)
    {
        matrixStack.push();

        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, caribouSpearEntity.prevYaw, caribouSpearEntity.getYaw()) - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, caribouSpearEntity.prevPitch, caribouSpearEntity.getPitch()) - 90.0F));
        matrixStack.scale(0.8F, 0.8F, 0.8F);

        ItemStack spearStack = new ItemStack(ModItems.CARIBOU_SPEAR);

        this.itemRenderer.renderItem(
                null,
                spearStack,
                ModelTransformationMode.GROUND,
                false,
                matrixStack,
                vertexConsumerProvider,
                caribouSpearEntity.getWorld(),
                light,
                OverlayTexture.DEFAULT_UV,
                caribouSpearEntity.getId()
        );

        matrixStack.pop();
        super.render(caribouSpearEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
    }

    public Identifier getTexture(CaribouSpearEntity caribouSpearEntity) {
        return null;
    }
}
