package net.alminoris.arborealnature.block.custom;

import com.mojang.serialization.MapCodec;
import net.alminoris.arborealnature.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BauhiniaLeavesBlock extends LeavesBlock
{
    public static final MapCodec<BauhiniaLeavesBlock> CODEC = createCodec(BauhiniaLeavesBlock::new);

    @Override
    public MapCodec<BauhiniaLeavesBlock> getCodec() {
        return CODEC;
    }

    public BauhiniaLeavesBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random)
    {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(10) == 0)
        {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP))
            {
                ParticleUtil.spawnParticle(world, pos, random, ModParticles.BAUHINIA_LEAVES);
            }
        }
    }

}
