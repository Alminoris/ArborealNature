package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.mixin.TrunkPlacerTypeInvoker;
import net.alminoris.arborealnature.world.tree.custom.HazelnutFoliagePlacer;
import net.alminoris.arborealnature.world.tree.custom.HazelnutTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes
{
    public static final TrunkPlacerType<?> HAZELNUT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("hazelnut_trunk_placer", HazelnutTrunkPlacer.MAP_CODEC);

    public static void register()
    {
        ArborealNature.LOGGER.info("Registering Trunk Placers for " + ArborealNature.MOD_ID);
    }
}
