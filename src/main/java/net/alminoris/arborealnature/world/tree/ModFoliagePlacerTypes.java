package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.mixin.FoliagePlacerTypeInvoker;
import net.alminoris.arborealnature.world.tree.custom.*;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes
{
    public static final FoliagePlacerType<?> LARGE_HORNBEAM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("large_hornbeam_foliage_placer", LargeHornbeamFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> FIR_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("fir_foliage_placer", FirFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> ARAUCARIA_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("araucaria_foliage_placer", AraucariaFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> JUNIPER_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("juniper_foliage_placer", JuniperFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> CEDAR_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("cedar_foliage_placer", CedarFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> SEQUOIA_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("sequoia_foliage_placer", SequoiaFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> THUJA_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("thuja_foliage_placer", ThujaFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> WILD_CHERRY_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("wild_cherry_foliage_placer", WildCherryFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> WHITE_MULBERRY_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("white_mulberry_foliage_placer", WhiteMulberryFoliagePlacer.CODEC);

    public static void register()
    {
    }
}
