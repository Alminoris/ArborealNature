package net.alminoris.arborealnature.util.helper;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.util.math.random.Random;

public class BiasedIntProvider extends IntProvider {
    public static final Codec<BiasedIntProvider> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("min").forGetter(p -> p.min),
                    Codec.INT.fieldOf("max").forGetter(p -> p.max),
                    Codec.FLOAT.fieldOf("bias_factor").forGetter(p -> p.biasFactor)
            ).apply(instance, BiasedIntProvider::new)
    );

    private final int min;
    private final int max;
    private final float biasFactor; // e.g., 0.7 = 70% chance to return min

    public BiasedIntProvider(int min, int max, float biasFactor) {
        if (min >= max) {
            throw new IllegalArgumentException("min must be < max");
        }
        this.min = min;
        this.max = max;
        this.biasFactor = biasFactor;
    }

    @Override
    public int get(Random random) {
        // Bias toward `min` (e.g. variant 0)
        if (random.nextFloat() < biasFactor) {
            return min;
        }

        // Otherwise pick any other value in [min, max)
        int value = random.nextInt((max - min)) + min;
        if (value == min) {
            // Avoid duplicate probability for min
            return (min + 1 <= max - 1) ? (random.nextInt(max - min - 1) + min + 1) : min;
        }
        return value;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max - 1; // because nextInt(max - min) is exclusive of max
    }

    @Override
    public IntProviderType<?> getType() {
        return ModIntProviderTypes.BIASED; // you must register this
    }

    public static IntProvider createWithBias(int min, int max, float biasFactor) {
        return new BiasedIntProvider(min, max, biasFactor);
    }
}