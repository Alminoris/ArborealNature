package net.alminoris.arborealnature.util.helper;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.alminoris.arborealnature.ArborealNature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.IntProviderType;

public class ModIntProviderTypes {
    public static final IntProviderType<BiasedIntProvider> BIASED =
            register("biased", BiasedIntProvider.CODEC);

    private static <P extends IntProvider> IntProviderType<P> register(String id, MapCodec<P> codec)
    {
        return Registry.register(Registries.INT_PROVIDER_TYPE, Identifier.of(ArborealNature.MOD_ID, id), () -> codec);
    }

    public static void init() {}
}

