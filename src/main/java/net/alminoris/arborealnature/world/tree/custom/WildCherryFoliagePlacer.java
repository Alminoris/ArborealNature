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

public class WildCherryFoliagePlacer extends BlobFoliagePlacer
{
    public static final MapCodec<WildCherryFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> createCodec(instance).apply(instance, WildCherryFoliagePlacer::new)
    );

    public WildCherryFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset, height);
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        // Create a more rounded, cherry-like foliage by adjusting radius and height
        int startHeight = treeNode.getFoliageRadius() - 2;
        BlockPos startPos = treeNode.getCenter().up(startHeight);

        for (int y = 0; y < foliageHeight; y++)
        {
            int levelRadius = radius - y / 2; // Shrinks as the tree gets taller
            for (int x = -levelRadius; x <= levelRadius; x++)
            {
                for (int z = -levelRadius; z <= levelRadius; z++)
                {
                    if (x * x + z * z <= levelRadius * levelRadius)
                    {  // Circle pattern for rounded canopy
                        BlockPos foliagePos = startPos.add(x, y, z);
                        placer.placeBlock(foliagePos, config.foliageProvider.get(random, foliagePos));
                    }
                }
            }
        }
    }

    @Override
    protected FoliagePlacerType<?> getType()
    {
        return ModFoliagePlacerTypes.WILD_CHERRY_FOLIAGE_PLACER;
    }
}
