package net.alminoris.arborealnature;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.client.SquirrelRenderer;
import net.alminoris.arborealnature.entity.client.WoodMouseRenderer;
import net.alminoris.arborealnature.entity.client.projectile.SilentArrowRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

import static net.alminoris.arborealnature.util.helper.ModWoodHelper.*;

public class ArborealNatureClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {
        for (String name : WOOD_NAMES)
        {
            BlockRenderLayerMap.INSTANCE.putBlock(LEAVES.get(name), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_SAPLINGS.get(name), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_DOORS.get(name), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_TRAPDOORS.get(name), RenderLayer.getCutout());
            TerraformBoatClientHelper.registerModelLayers(ModBoats.boatIDs.get(name), false);
        }


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAZELNUT_COVER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_ANEMONA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_CELANDINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_MUSHROOM, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.SQUIRREL, SquirrelRenderer::new);
        EntityRendererRegistry.register(ModEntities.WOOD_MOUSE, WoodMouseRenderer::new);

        EntityRendererRegistry.register(ModEntities.SILENT_ARROW, SilentArrowRenderer::new);
    }
}
