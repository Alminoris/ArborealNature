package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.world.ModConfiguredFeautures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators
{
    public static final SaplingGenerator HAZELNUT =
            new SaplingGenerator("hazelnut", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeautures.HAZELNUT_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
