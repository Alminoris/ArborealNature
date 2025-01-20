package net.alminoris.arborealnature.world.gen.feature;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.world.gen.feature.custom.HugeWhiteMushroomFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.HugeBrownMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public abstract class ModFeatures<FC extends FeatureConfig>
{
    public static final Feature<HugeMushroomFeatureConfig> HUGE_WHITE_MUSHROOM = new HugeWhiteMushroomFeature(HugeMushroomFeatureConfig.CODEC);

    public static void registerFeatures()
    {
        Registry.register(Registries.FEATURE, Identifier.of(ArborealNature.MOD_ID, "huge_white_mushroom"), HUGE_WHITE_MUSHROOM);
    }
}
