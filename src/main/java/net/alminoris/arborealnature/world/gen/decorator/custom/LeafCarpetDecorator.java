package net.alminoris.arborealnature.world.gen.decorator.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.world.gen.decorator.ModTreeDecorators;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeafCarpetDecorator extends TreeDecorator
{
    public static final MapCodec<LeafCarpetDecorator> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    BlockStateProvider.TYPE_CODEC.fieldOf("provider").forGetter(decorator -> decorator.provider),
                    Codec.INT.fieldOf("radius").forGetter(decorator -> decorator.radius),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(decorator -> decorator.probability)
            ).apply(instance, LeafCarpetDecorator::new)
    );
    private final BlockStateProvider provider;
    private final int radius;
    private final float probability;

    public LeafCarpetDecorator(BlockStateProvider provider, int radius, float probability)
    {
        this.provider = provider;
        this.radius = radius;
        this.probability = probability;
    }

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
        List<Block> validBlocks = Arrays.asList(
                Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.STONE, Blocks.PODZOL, Blocks.SAND,
                Blocks.GRAVEL, Blocks.SNOW_BLOCK, Blocks.MYCELIUM, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT, Blocks.WATER);

        List<Block> validBlocks1 = Arrays.asList(
                Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.STONE, Blocks.PODZOL, Blocks.SAND,
                Blocks.GRAVEL, Blocks.SNOW_BLOCK, Blocks.MYCELIUM, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT);

        BlockPos.Mutable carpetPos = new BlockPos.Mutable();
        BlockPos.Mutable groundPos = new BlockPos.Mutable();

        for (int x = -radius; x <= radius; x++)
        {
            for (int z = -radius; z <= radius; z++)
            {
                if (random.nextFloat() < probability)
                {
                    carpetPos.set(basePos.getX() + x, basePos.getY() + 1, basePos.getZ() + z);
                    groundPos.set(basePos.getX() + x, basePos.getY(), basePos.getZ() + z);

                    Random rnd = generator.getRandom();
                    BlockState providerState = provider.get(rnd, basePos);

                    if (providerState.isOf(ModBlocks.FLAT_GRASS))
                    {
                        if (world.testBlockState(carpetPos, BlockState::isAir) &&
                                world.testBlockState(groundPos, state -> validBlocks1.contains(state.getBlock())))
                        {
                            generator.replace(carpetPos, providerState);
                            generator.replace(groundPos, Blocks.COARSE_DIRT.getDefaultState());
                        }
                    }
                    else
                    {
                        if (world.testBlockState(carpetPos, BlockState::isAir) &&
                                world.testBlockState(groundPos, state -> validBlocks.contains(state.getBlock())))
                        {
                            generator.replace(carpetPos, providerState);
                        }
                    }
                }
            }
        }
    }
}