package net.alminoris.arborealnature;

import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.entity.ModEntities;
import net.alminoris.arborealnature.entity.custom.*;
import net.alminoris.arborealnature.item.ModItemGroups;
import net.alminoris.arborealnature.item.ModItems;
import net.alminoris.arborealnature.particle.ModParticles;
import net.alminoris.arborealnature.sound.ModSounds;
import net.alminoris.arborealnature.util.ModTags;
import net.alminoris.arborealnature.world.gen.ModWorldGeneration;
import net.alminoris.arborealnature.world.gen.decorator.ModTreeDecorators;
import net.alminoris.arborealnature.world.gen.feature.ModFeatures;
import net.alminoris.arborealnature.world.tree.ModFoliagePlacerTypes;
import net.alminoris.arborealnature.world.tree.ModTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.FoliageColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static net.alminoris.arborealnature.util.helper.ModBlockSetsHelper.*;

public class ArborealNature implements ModInitializer
{
	public static final String MOD_ID = "arborealnature";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		LOGGER.info("Initialization Arboreal Nature MOD");

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ModParticles.registerParticles();

		FuelRegistry.INSTANCE.add(ModItems.HAZELNUT_SPOILED, 150);

		FuelRegistry.INSTANCE.add(ModItems.PINE_RESIN, 800);

		for (String name : WOOD_NAMES)
		{
			StrippableBlockRegistry.register(LOGS.get(name), STRIPPED_LOGS.get(name));
			StrippableBlockRegistry.register(WOODS.get(name), STRIPPED_WOODS.get(name));

			FlammableBlockRegistry.getDefaultInstance().add(LOGS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_LOGS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(WOODS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WOODS.get(name), 5, 5);

			FlammableBlockRegistry.getDefaultInstance().add(WOODEN_PLANKS.get(name), 5, 20);
			FlammableBlockRegistry.getDefaultInstance().add(WOODEN_CHISELED.get(name), 5, 20);
			FlammableBlockRegistry.getDefaultInstance().add(LEAVES.get(name), 30, 60);
		}

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OAK_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BIRCH_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SPRUCE_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.JUNGLE_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACACIA_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DARK_OAK_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MANGROVE_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHERRY_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WARPED_CHISELED, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRIMSON_CHISELED, 5, 20);

		for (String name : WF_WOOD_NAMES)
			FlammableBlockRegistry.getDefaultInstance().add(WOODEN_CHISELED.get(name), 5, 20);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.HAZELNUT_COVER, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAUHINIA_COVER, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAUHINIA_COVER_BLOCK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_COVER, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_COVER_BLOCK, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAUHINIA_VINES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_RESIN, 60, 30);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_RESIN_BLOCK, 60, 30);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_RESIN_BRICKS, 60, 30);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_RESIN_CHISELED, 60, 30);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_RESIN_BRICKS_SLAB, 60, 30);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PINE_RESIN_BRICKS_STAIRS, 60, 30);

		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
		{
			if (!world.isClient)
			{
				BlockPos blockBelow = pos.down();

				if (world.getBlockState(pos).isOf(Blocks.FIRE))
				{
					if (world.getBlockState(blockBelow).isIn(ModTags.Blocks.LOGS_TO_BE_BURNT) ||
							world.getBlockState(blockBelow).isIn(ModTags.Blocks.INTEGRATION_LOGS_TO_BE_BURNT))
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

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) ->
		{
			if (!world.isClient && entity instanceof LivingEntity target)
			{
				ItemStack heldItem = player.getStackInHand(hand);
				Random random = new Random();

				if (heldItem.isOf(ModItems.HUNTING_KNIFE))
				{
					if (entity.getType().isIn(ModTags.Entities.LEATHER_DROPPERS))
						target.dropStack(new ItemStack(Items.LEATHER, random.nextInt(2, 4)));
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
		FabricDefaultAttributeRegistry.register(ModEntities.MOOSE, MooseEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LYNX, LynxEntity.setAttributes());

		ModWorldGeneration.generateModWorldGen();
	}
}