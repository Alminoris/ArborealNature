package net.alminoris.arborealnature;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.custom.FigeaterBeetleEntity;
import net.alminoris.arborealnature.entity.custom.OrchidMantisEntity;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.alminoris.arborealnature.entity.custom.WoodMouseEntity;
import net.alminoris.arborealnature.item.ModItemGroups;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.util.ModTags;
import net.alminoris.arborealnature.world.gen.ModWorldGeneration;
import net.alminoris.arborealnature.world.gen.decorator.ModTreeDecorators;
import net.alminoris.arborealnature.world.gen.feature.ModFeatures;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.transformer.Config;

import java.util.Set;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ArborealNature implements ModInitializer
{
	public static final String MOD_ID = "arborealnature";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		LOGGER.info("Initialization MOD");

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

		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
		{
			if (!world.isClient)
			{
				BlockPos blockBelow = pos.down();

				if (world.getBlockState(pos).isOf(Blocks.FIRE))
				{
					if (world.getBlockState(blockBelow).isIn(ModTags.Blocks.LOGS_TO_BE_BURNT))
					{
						Block block = null;
						String name = Registries.BLOCK.getId(world.getBlockState(blockBelow).getBlock()).getPath().split("_")[1];

						block = BURNT_LOGS.get(name);

						if (block != null)
						{
							world.setBlockState(blockBelow, block.getDefaultState());
							world.removeBlock(pos, false);
							return ActionResult.SUCCESS;
						}
					}
				}
			}
			return ActionResult.PASS;
		});

		ModBoats.registerBoats();

		ModItemGroups.registerItemGroups();

		ModFeatures.registerFeatures();

		ModTrunkPlacerTypes.register();
		ModFoliagePlacerTypes.register();
		ModTreeDecorators.register();

		FabricDefaultAttributeRegistry.register(ModEntities.SQUIRREL, SquirrelEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WOOD_MOUSE, WoodMouseEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FIGEATER_BEETLE, FigeaterBeetleEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ORCHID_MANTIS, OrchidMantisEntity.setAttributes());

		ModWorldGeneration.generateModWorldGen();
	}
}