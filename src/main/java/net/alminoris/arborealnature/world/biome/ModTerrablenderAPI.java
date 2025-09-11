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
        Regions.register(new ForestRegion(Identifier.of(ArborealNature.MOD_ID, "forest_region"), 6));
        Regions.register(new PineRegion(Identifier.of(ArborealNature.MOD_ID, "pine_region"), 4));
        Regions.register(new SequoiaRegion(Identifier.of(ArborealNature.MOD_ID, "sequoia_region"), 6));
        Regions.register(new HighlandsRegion(Identifier.of(ArborealNature.MOD_ID, "highlands_region"), 10));
        Regions.register(new SnowRegion(Identifier.of(ArborealNature.MOD_ID, "snow_region"), 5));
        Regions.register(new DesertRegion(Identifier.of(ArborealNature.MOD_ID, "desert_region"), 1));
        Regions.register(new DryRegion(Identifier.of(ArborealNature.MOD_ID, "dry_region"), 4));
        Regions.register(new MarshRegion(Identifier.of(ArborealNature.MOD_ID, "marsh_region"), 5));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ArborealNature.MOD_ID, ModMaterialRules.makeRules());
    }
}