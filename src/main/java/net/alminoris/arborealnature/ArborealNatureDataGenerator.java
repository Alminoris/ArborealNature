package net.alminoris.arborealnature;

import net.alminoris.arborealnature.datagen.*;
import net.alminoris.arborealnature.world.ModConfiguredFeatures;
import net.alminoris.arborealnature.world.ModPlacedFeatures;
import net.alminoris.arborealnature.world.biome.ModBiomes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ArborealNatureDataGenerator implements DataGeneratorEntrypoint
{
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		fabricDataGenerator.addProvider(ModBlockTagProvider::new);
		fabricDataGenerator.addProvider(ModItemTagProvider::new);
		fabricDataGenerator.addProvider(ModEntityTypeTagProvider::new);
		fabricDataGenerator.addProvider(ModLootTableProvider::new);
		fabricDataGenerator.addProvider(ModBiomeTagProvider::new);
		fabricDataGenerator.addProvider(ModRecipeProvider::new);
		fabricDataGenerator.addProvider(ModModelProvider::new);
		fabricDataGenerator.addProvider(ModWorldGenerator::new);
	}
}
