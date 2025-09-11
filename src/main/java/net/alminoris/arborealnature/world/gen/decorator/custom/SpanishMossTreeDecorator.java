package net.alminoris.arborealnature.world.gen.decorator.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.block.custom.SpanishMossBlock;
import net.alminoris.arborealnature.world.gen.decorator.ModTreeDecorators;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class SpanishMossTreeDecorator extends TreeDecorator
{
    private final float probability;

    public static final Codec<SpanishMossTreeDecorator> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(decorator -> decorator.probability)
    ).apply(instance, SpanishMossTreeDecorator::new));

    public SpanishMossTreeDecorator(float probability)
    {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType()
    {
        return ModTreeDecorators.SPANISH_MOSS_TREE_DECORATOR;
    }

    @Override
    public void generate(Generator generator)
    {
        Random random = generator.getRandom();

        for (BlockPos leafPos : generator.getLeavesPositions())
        {
            if (random.nextFloat() < probability)
            {
                int length = 1 + random.nextInt(5);
                BlockPos.Mutable cursor = leafPos.down().mutableCopy();

                for (int i = 0; i < length; i++)
                {
                    boolean canReplace = generator.getWorld().testBlockState(cursor, state -> state.isAir() || state.isOf(Blocks.WATER));

                    if (!canReplace) break;

                    boolean isBottom = (i == length - 1);
                    generator.replace(cursor, ModBlocks.SPANISH_MOSS.getDefaultState()
                            .with(SpanishMossBlock.BOTTOM, isBottom));

                    cursor.move(Direction.DOWN);
                }
            }
        }
    }
}