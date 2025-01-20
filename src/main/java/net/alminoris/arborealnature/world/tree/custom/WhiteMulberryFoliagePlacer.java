package net.alminoris.arborealnature.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class WhiteMulberryFoliagePlacer extends BlobFoliagePlacer
{
    public static final Codec<WhiteMulberryFoliagePlacer> CODEC = RecordCodecBuilder.create(
            instance -> createCodec(instance).apply(instance, WhiteMulberryFoliagePlacer::new)
    );

    public WhiteMulberryFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset, height);
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        BlockPos startPos = treeNode.getCenter();
        // Generate the foliage in a spherical pattern around the tree
        for (int y = 0; y < foliageHeight; y++)
        {
            int currentRadius = radius - (y / 2); // Gradually reduce radius as height increases
            for (int x = -currentRadius; x <= currentRadius; x++)
            {
                for (int z = -currentRadius; z <= currentRadius; z++)
                {
                    BlockPos foliagePos = startPos.add(x, y, z);
                    // Only place foliage blocks if within the current radius
                    if (x * x + z * z <= currentRadius * currentRadius)
                    {
                        placer.placeBlock(foliagePos, config.foliageProvider.get(random, foliagePos));
                    }
                }
            }
        }
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.WHITE_MULBERRY_FOLIAGE_PLACER;
    }
}
