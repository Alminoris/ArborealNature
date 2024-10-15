package net.alminoris.arborealnature;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.world.gen.ModWorldGeneration;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArborealNature implements ModInitializer
{
	public static final String MOD_ID = "arborealnature";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModTrunkPlacerTypes.register();

		ModFoliagePlacerTypes.register();

		StrippableBlockRegistry.register(ModBlocks.HAZELNUT_LOG, ModBlocks.STRIPPED_HAZELNUT_LOG);
		StrippableBlockRegistry.register(ModBlocks.HAZELNUT_WOOD, ModBlocks.STRIPPED_HAZELNUT_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.HAZELNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.HAZELNUT_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_HAZELNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_HAZELNUT_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.HAZELNUT_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.HAZELNUT_LEAVES, 30, 60);

		ModBoats.registerBoats();

		ModWorldGeneration.generateModWorldGen();
	}
}