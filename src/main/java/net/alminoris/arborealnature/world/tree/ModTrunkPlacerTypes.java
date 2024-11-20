package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.mixin.TrunkPlacerTypeInvoker;
import net.alminoris.arborealnature.world.tree.custom.LargeHazelnutTrunkPlacer;
import net.alminoris.arborealnature.world.tree.custom.LargeHornbeamTrunkPlacer;
import net.alminoris.arborealnature.world.tree.custom.ViburnumTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes
{
    public static final TrunkPlacerType<?> LARGE_HAZELNUT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("large_hazelnut_trunk_placer", LargeHazelnutTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> LARGE_HORNBEAM_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("large_hornbeam_trunk_placer", LargeHornbeamTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> VIBURNUM_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("viburnum_trunk_placer", ViburnumTrunkPlacer.CODEC);

    public static void register()
    {
    }
}
