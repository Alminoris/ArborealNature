package net.alminoris.arborealnature.world.gen.decorator.custom;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import java.util.List;
import java.util.Random;

import net.alminoris.arborealnature.world.gen.decorator.ModTreeDecorators;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class CustomAlterGroundTreeDecorator extends TreeDecorator
{
    public static final MapCodec<CustomAlterGroundTreeDecorator> CODEC = BlockStateProvider.TYPE_CODEC
            .fieldOf("provider")
            .xmap(CustomAlterGroundTreeDecorator::new, decorator -> decorator.provider);
    private final BlockStateProvider provider;

    private final BlockStateProvider baseProvider = BlockStateProvider.of(Blocks.GRASS_BLOCK);

    public CustomAlterGroundTreeDecorator(BlockStateProvider provider)
    {
        this.provider = provider;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.CUSTOM_ALTER_GROUND_DECORATOR;
    }

    @Override
    public void generate(TreeDecorator.Generator generator)
    {
        List<BlockPos> list = Lists.<BlockPos>newArrayList();
        List<BlockPos> list2 = generator.getRootPositions();
        List<BlockPos> list3 = generator.getLogPositions();
        if (list2.isEmpty())
        {
            list.addAll(list3);
        }
        else if (!list3.isEmpty() && ((BlockPos)list2.get(0)).getY() == ((BlockPos)list3.get(0)).getY())
        {
            list.addAll(list3);
            list.addAll(list2);
        }
        else
        {
            list.addAll(list2);
        }

        if (!list.isEmpty())
        {
            int i = ((BlockPos)list.get(0)).getY();
            list.stream().filter(pos -> pos.getY() == i).forEach(pos ->
            {
                this.setArea(generator, pos.west().north());
                this.setArea(generator, pos.east(2).north());
                this.setArea(generator, pos.west().south(2));
                this.setArea(generator, pos.east(2).south(2));

                for (int ix = 0; ix < 5; ix++)
                {
                    int j = generator.getRandom().nextInt(64);
                    int k = j % 8;
                    int l = j / 8;
                    if (k == 0 || k == 7 || l == 0 || l == 7)
                    {
                        this.setArea(generator, pos.add(-3 + k, 0, -3 + l));
                    }
                }
            });
        }
    }

    private void setArea(TreeDecorator.Generator generator, BlockPos origin)
    {
        for (int i = -2; i <= 2; i++)
        {
            for (int j = -2; j <= 2; j++)
            {
                if (Math.abs(i) != 2 || Math.abs(j) != 2)
                {
                    this.setColumn(generator, origin.add(i, 0, j));
                }
            }
        }
    }

    private void setColumn(TreeDecorator.Generator generator, BlockPos origin)
    {
        Random random = new Random();
        for (int i = 2; i >= -3; i--)
        {
            BlockPos blockPos = origin.up(i);
            if (Feature.isSoil(generator.getWorld(), blockPos))
            {
                if (random.nextFloat() < 0.05F)
                    generator.replace(blockPos, this.provider.get(generator.getRandom(), origin));
                else
                    generator.replace(blockPos, this.baseProvider.get(generator.getRandom(), origin));
                break;
            }

            if (!generator.isAir(blockPos) && i < 0)
            {
                break;
            }
        }
    }
}
