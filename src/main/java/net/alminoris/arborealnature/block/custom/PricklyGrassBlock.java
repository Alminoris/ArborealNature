package net.alminoris.arborealnature.block.custom;

import net.minecraft.block.FlowerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class PricklyGrassBlock extends FlowerBlock
{
    public PricklyGrassBlock(Settings settings) {
        super(StatusEffects.HASTE, 12, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity)
    {
        if (!world.isClient && entity instanceof LivingEntity livingEntity)
        {
            if (!livingEntity.isSneaking())
            {
                Registry<DamageType> damageTypeRegistry = world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE);
                Optional<RegistryEntry.Reference<DamageType>> optionalEntry = damageTypeRegistry.getEntry(DamageTypes.CACTUS);

                if (optionalEntry.isPresent())
                {
                    DamageSource pricklySource = new DamageSource(optionalEntry.get());
                    livingEntity.damage(pricklySource, 0.5f);
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0));
                }
            }
        }

        super.onEntityCollision(state, world, pos, entity);
    }
}