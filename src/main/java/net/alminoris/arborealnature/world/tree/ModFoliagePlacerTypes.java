package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.mixin.FoliagePlacerTypeInvoker;
import net.alminoris.arborealnature.mixin.TrunkPlacerTypeInvoker;
import net.alminoris.arborealnature.world.tree.custom.LargeHazelnutTrunkPlacer;
import net.alminoris.arborealnature.world.tree.custom.LargeHornbeamFoliagePlacer;
import net.alminoris.arborealnature.world.tree.custom.LargeHornbeamTrunkPlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModFoliagePlacerTypes
{
    public static final FoliagePlacerType<?> LARGE_HORNBEAM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("large_hornbeam_foliage_placer", LargeHornbeamFoliagePlacer.CODEC);

    public static void register()
    {
    }
}
