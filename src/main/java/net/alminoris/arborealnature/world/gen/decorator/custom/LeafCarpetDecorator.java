package net.alminoris.arborealnature.world.gen.decorator.custom;

import com.mojang.serialization.MapCodec;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.world.gen.decorator.ModTreeDecorators;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Comparator;
import java.util.List;

public class LeafCarpetDecorator extends TreeDecorator
{
    public static final MapCodec<LeafCarpetDecorator> CODEC = MapCodec.unit(LeafCarpetDecorator::new);

    @Override
    protected TreeDecoratorType<?> getType()
    {
        return ModTreeDecorators.LEAF_CARPET_DECORATOR;
    }

    @Override
    public void generate(Generator generator)
    {
        // Get the world
        TestableWorld world = generator.getWorld();

        // Find the lowest log of the tree by iterating over logs
        List<BlockPos> logPositions = generator.getLogPositions(); // Method for getting log positions
        BlockPos lowestLog = logPositions.stream().min(Comparator.comparingInt(BlockPos::getY)).orElse(logPositions.get(0));

        // Place leaf carpets around the base of the tree
        placeLeafCarpets(generator, world, lowestLog, generator.getRandom());
    }

    // Method to place leaf carpets near the lowest log
    private void placeLeafCarpets(Generator generator, TestableWorld world, BlockPos basePos, Random random)
    {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int x = -2; x <= 2; x++)
        {
            for (int z = -2; z <= 2; z++)
            {
                if (random.nextFloat() < 0.5f)
                {
                    mutable.set(basePos.getX() + x, basePos.getY()+1, basePos.getZ() + z);
                    if (world.testBlockState(mutable, BlockState::isAir))
                    {
                        generator.replace(mutable, ModBlocks.HAZELNUT_COVER.getDefaultState());
                    }
                }
            }
        }
    }
}
