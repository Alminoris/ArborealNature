package net.alminoris.arborealnature;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.block.ModSigns;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.client.*;
import net.alminoris.arborealnature.entity.client.projectile.SilentArrowRenderer;
import net.alminoris.arborealnature.particle.BauhiniaLeavesParticle;
import net.alminoris.arborealnature.particle.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ArborealNatureClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {
        ModSigns.registerModSigns();

        for (String name : WOOD_NAMES)
        {
            BlockRenderLayerMap.INSTANCE.putBlock(LEAVES.get(name), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_SAPLINGS.get(name), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_DOORS.get(name), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_TRAPDOORS.get(name), RenderLayer.getCutout());
            TerraformBoatClientHelper.registerModelLayers(ModBoats.boatIDs.get(name), false);
        }

        for (String name : BUSHES_NAMES)
        {
            BlockRenderLayerMap.INSTANCE.putBlock(BUSHES.get(name), RenderLayer.getCutout());
        }

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAZELNUT_COVER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORCHID_LILY_PAD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAUHINIA_COVER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAUHINIA_COVER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_COVER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_COVER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAUHINIA_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_ANEMONA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_CELANDINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEGRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GERANIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.XEROCHRYSUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_MUSHROOM, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BRICKS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BRICKS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BRICKS_SLAB, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_CHISELED, RenderLayer.getTranslucent());

        ParticleFactoryRegistry.getInstance().register(ModParticles.BAUHINIA_LEAVES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new BauhiniaLeavesParticle(world, x, y, z, spriteProvider));

        EntityRendererRegistry.register(ModEntities.SQUIRREL, SquirrelRenderer::new);
        EntityRendererRegistry.register(ModEntities.WOOD_MOUSE, WoodMouseRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIGEATER_BEETLE, FigeaterBeetleRenderer::new);
        EntityRendererRegistry.register(ModEntities.ORCHID_MANTIS, OrchidMantisRenderer::new);
        EntityRendererRegistry.register(ModEntities.MOOSE, MooseRenderer::new);
        EntityRendererRegistry.register(ModEntities.LYNX, LynxRenderer::new);

        EntityRendererRegistry.register(ModEntities.SILENT_ARROW, SilentArrowRenderer::new);
    }
}
