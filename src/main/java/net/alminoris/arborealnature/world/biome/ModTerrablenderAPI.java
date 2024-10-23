package net.alminoris.arborealnature.world.biome;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi
{

    @Override
    public void onTerraBlenderInitialized()
    {
        Regions.register(new ModOverworldRegion(Identifier.of(ArborealNature.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ArborealNature.MOD_ID, ModMaterialRules.makeRules());
    }
}
