package net.alminoris.arborealnature.world.biome.surface;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules
{
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule MUD = makeStateRule(Blocks.MUD);
    private static final MaterialRules.MaterialRule BOG_SOIL_COVER = makeStateRule(ModBlocks.BOG_SOIL_COVER);
    private static final MaterialRules.MaterialRule BOG_SOIL = makeStateRule(ModBlocks.BOG_SOIL);

    public static MaterialRules.MaterialRule makeRules()
    {
        MaterialRules.MaterialCondition atOrAboveWater = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(
                MaterialRules.condition(atOrAboveWater, GRASS_BLOCK),
                DIRT
        );

        MaterialRules.MaterialRule bogSoilSurface = MaterialRules.sequence(
                MaterialRules.condition(atOrAboveWater, BOG_SOIL_COVER),
                BOG_SOIL
        );

        MaterialRules.MaterialRule marshSurface = MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, -0.25D, 0.25D),
                        MUD
                ),
                bogSoilSurface
        );

        MaterialRules.MaterialCondition bogSoilFloor = MaterialRules.stoneDepth(0, false, 0, VerticalSurfaceType.FLOOR);

        return MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomes.BOREAL_MARSH),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6, marshSurface)
                ),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface));
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}