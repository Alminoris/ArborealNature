package net.alminoris.arborealnature;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.client.*;
import net.alminoris.arborealnature.entity.client.projectile.CaribouSpearEntityRenderer;
import net.alminoris.arborealnature.entity.client.projectile.SilentArrowRenderer;
import net.alminoris.arborealnature.particle.LeavesParticle;
import net.alminoris.arborealnature.particle.NeedlesParticle;
import net.alminoris.arborealnature.particle.PetalsParticle;
import net.alminoris.arborealnature.particle.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.biome.GrassColors;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

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
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_COVER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNIPER_COVER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAUHINIA_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_ANEMONA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_SORREL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBELL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REINDEER_LICHEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REINDEER_LICHEN_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_CELANDINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEGRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GERANIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.XEROCHRYSUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.THISTLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRICKLY_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_MUSHROOM, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BRICKS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BRICKS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_BRICKS_SLAB, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINE_RESIN_CHISELED, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAT_GRASS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAT_GRASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAT_GRASS_BLOCK, RenderLayer.getTranslucent());

        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null
                        ? BiomeColors.getGrassColor(world, pos)
                        : GrassColors.getColor(0.5D, 1.0D),
                ModBlocks.FLAT_GRASS
        );

        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null
                        ? BiomeColors.getGrassColor(world, pos)
                        : GrassColors.getColor(0.5D, 1.0D),
                ModBlocks.FLAT_GRASS_BLOCK
        );

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D),
                ModBlocks.FLAT_GRASS.asItem()
        );

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D),
                ModBlocks.FLAT_GRASS_BLOCK.asItem()
        );

        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null
                        ? BiomeColors.getGrassColor(world, pos)
                        : 0xa2c09b,
                LEAVES.get("fir")
        );

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> 0xa2c09b,
                LEAVES.get("fir").asItem()
        );

        ParticleFactoryRegistry.getInstance().register(ModParticles.BAUHINIA_PETALS,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new PetalsParticle(world, x, y, z, spriteProvider, 12));

        ParticleFactoryRegistry.getInstance().register(ModParticles.PINE_NEEDLES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new NeedlesParticle(world, x, y, z, spriteProvider, 10));

        ParticleFactoryRegistry.getInstance().register(ModParticles.FIR_NEEDLES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new NeedlesParticle(world, x, y, z, spriteProvider, 8));

        ParticleFactoryRegistry.getInstance().register(ModParticles.CEDAR_NEEDLES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new NeedlesParticle(world, x, y, z, spriteProvider, 10));

        ParticleFactoryRegistry.getInstance().register(ModParticles.ARAUCARIA_NEEDLES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new PetalsParticle(world, x, y, z, spriteProvider, 5));

        ParticleFactoryRegistry.getInstance().register(ModParticles.JUNIPER_NEEDLES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new PetalsParticle(world, x, y, z, spriteProvider, 5));

        ParticleFactoryRegistry.getInstance().register(ModParticles.HAZELNUT_LEAVES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new LeavesParticle(world, x, y, z, spriteProvider, 12));

        ParticleFactoryRegistry.getInstance().register(ModParticles.HORNBEAM_LEAVES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new LeavesParticle(world, x, y, z, spriteProvider, 8));

        ParticleFactoryRegistry.getInstance().register(ModParticles.HAWTHORN_PETALS,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new PetalsParticle(world, x, y, z, spriteProvider, 12));

        ParticleFactoryRegistry.getInstance().register(ModParticles.FIG_LEAVES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) ->
                        new LeavesParticle(world, x, y, z, spriteProvider, 12));

        EntityRendererRegistry.register(ModEntities.SQUIRREL, SquirrelRenderer::new);
        EntityRendererRegistry.register(ModEntities.WOOD_MOUSE, WoodMouseRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIGEATER_BEETLE, FigeaterBeetleRenderer::new);
        EntityRendererRegistry.register(ModEntities.ORCHID_MANTIS, OrchidMantisRenderer::new);
        EntityRendererRegistry.register(ModEntities.MOOSE, MooseRenderer::new);
        EntityRendererRegistry.register(ModEntities.LYNX, LynxRenderer::new);
        EntityRendererRegistry.register(ModEntities.CARIBOU, CaribouRenderer::new);
        EntityRendererRegistry.register(ModEntities.WOLVERINE, WolverineRenderer::new);
        EntityRendererRegistry.register(ModEntities.TENREC, TenrecRenderer::new);

        EntityRendererRegistry.register(ModEntities.SILENT_ARROW, SilentArrowRenderer::new);
        EntityRendererRegistry.register(ModEntities.CARIBOU_SPEAR, CaribouSpearEntityRenderer::new);
    }
}
