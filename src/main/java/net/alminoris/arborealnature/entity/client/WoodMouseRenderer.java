package net.alminoris.arborealnature.entity.client;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.alminoris.arborealnature.entity.custom.WoodMouseEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WoodMouseRenderer extends GeoEntityRenderer<WoodMouseEntity>
{
    public WoodMouseRenderer(EntityRendererFactory.Context renderManager)
    {
        super(renderManager, new WoodMouseModel());
    }

    @Override
    public Identifier getTextureLocation(WoodMouseEntity animatable)
    {
        return Identifier.of(ArborealNature.MOD_ID, "textures/entity/wood_mouse.png");
    }

    @Override
    public void render(WoodMouseEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight)
    {
        if (entity.isBaby())
            poseStack.scale(0.4f, 0.4f, 0.4f);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
