package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.util.helper.ModWoodHelper;
import net.alminoris.arborealnature.world.ModConfiguredFeautures;
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
        put("hazelnut", ModConfiguredFeautures.HAZELNUT_KEY);
        put("hornbeam", ModConfiguredFeautures.HORNBEAM_KEY);
        put("hawthorn", ModConfiguredFeautures.HAWTHORN_KEY);
    }};

    public static final Dictionary<String, SaplingGenerator> saplingGenerators = new Hashtable<>()
    {{
        for(String name : ModWoodHelper.WOOD_NAMES)
            put(name, new SaplingGenerator(name, 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(keys.get(name)),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()));
    }};
}
