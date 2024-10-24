package net.alminoris.arborealnature;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.alminoris.arborealnature.item.ModItemGroups;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.world.gen.ModWorldGeneration;
import net.alminoris.arborealnature.world.gen.decorator.ModTreeDecorators;
import net.alminoris.arborealnature.world.gen.feature.ModFeatures;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.alminoris.arborealnature.util.helper.ModWoodHelper.*;

public class ArborealNature implements ModInitializer
{
	public static final String MOD_ID = "arborealnature";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		FuelRegistry.INSTANCE.add(ModItems.HAZELNUT_SPOILED, 150);

		for (String name : WOOD_NAMES)
		{
			StrippableBlockRegistry.register(LOGS.get(name), STRIPPED_LOGS.get(name));
			StrippableBlockRegistry.register(WOODS.get(name), STRIPPED_WOODS.get(name));

			FlammableBlockRegistry.getDefaultInstance().add(LOGS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_LOGS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(WOODS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WOODS.get(name), 5, 5);

			FlammableBlockRegistry.getDefaultInstance().add(WOODEN_PLANKS.get(name), 5, 20);
			FlammableBlockRegistry.getDefaultInstance().add(LEAVES.get(name), 30, 60);
		}

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.HAZELNUT_COVER, 30, 60);

		ModBoats.registerBoats();

		ModItemGroups.registerItemGroups();

		ModFeatures.registerFeatures();

		ModTrunkPlacerTypes.register();
		ModFoliagePlacerTypes.register();
		ModTreeDecorators.register();

		FabricDefaultAttributeRegistry.register(ModEntities.SQUIRREL, SquirrelEntity.setAttributes());

		ModWorldGeneration.generateModWorldGen();
	}
}