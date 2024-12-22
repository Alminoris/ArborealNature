package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.util.helper.ModBlockSetsHelper;
import net.alminoris.arborealnature.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Optional;

public class ModSaplingGenerators
{
    public static final Dictionary<String, RegistryKey<ConfiguredFeature<?, ?>>> keys = new Hashtable<>()
    {{
        put("hazelnut", ModConfiguredFeatures.HAZELNUT_KEY);
        put("hornbeam", ModConfiguredFeatures.HORNBEAM_KEY);
        put("hawthorn", ModConfiguredFeatures.HAWTHORN_KEY);
        put("quince", ModConfiguredFeatures.QUINCE_KEY);
        put("plum", ModConfiguredFeatures.PLUM_KEY);
        put("mango", ModConfiguredFeatures.MANGO_KEY);
        put("fig", ModConfiguredFeatures.FIG_KEY);
        put("viburnum", ModConfiguredFeatures.VIBURNUM_KEY);
        put("wild_cherry", ModConfiguredFeatures.WILD_CHERRY_KEY);
        put("white_mulberry", ModConfiguredFeatures.WHITE_MULBERRY_KEY);
        put("bauhinia", ModConfiguredFeatures.BAUHINIA_KEY);
        put("pine", ModConfiguredFeatures.PINE_KEY);
    }};

    public static final Dictionary<String, SaplingGenerator> saplingGenerators = new Hashtable<>()
    {{
        for(String name : ModBlockSetsHelper.WOOD_NAMES)
        {
            if (name.equals("pine"))
            {
                put(name, new SaplingGenerator(name, 0f, Optional.of(ModConfiguredFeatures.MEGA_PINE_KEY),
                        Optional.empty(),
                        Optional.of(keys.get(name)),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));
            }
            else
            {
                put(name, new SaplingGenerator(name, 0f, Optional.empty(),
                        Optional.empty(),
                        Optional.of(keys.get(name)),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));
            }
        }
    }};
}
