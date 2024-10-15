package net.alminoris.arborealnature.world.tree;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.mixin.FoliagePlacerTypeInvoker;
import net.alminoris.arborealnature.world.tree.custom.HazelnutFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes
{
    public static final FoliagePlacerType<?> HAZELNUT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("hazelnut_foliage_placer", HazelnutFoliagePlacer.MAP_CODEC);

    public static void register() {
        ArborealNature.LOGGER.info("Registering Foliage Placer for " + ArborealNature.MOD_ID);
    }
}
