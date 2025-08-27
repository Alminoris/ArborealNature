package net.alminoris.arborealnature.world.gen.root;

import net.alminoris.arborealnature.mixin.RootPlacerTypeInvoker;
import net.alminoris.arborealnature.world.gen.root.custom.FluidLevelAdaptiveMangroveRootPlacer;
import net.minecraft.world.gen.root.RootPlacerType;

public class ModRootPlacerTypes
{
    public static final RootPlacerType<?> FLUID_ADAPTIVE_MANGROVE_ROOT_PLACER = RootPlacerTypeInvoker.callRegister("fluid_adaptive_mangrove_root_placer", FluidLevelAdaptiveMangroveRootPlacer.CODEC);

    public static void register()
    {
    }
}
