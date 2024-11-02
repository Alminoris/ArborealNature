package net.alminoris.arborealnature.util.helper;

import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.world.tree.ModSaplingGenerators;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Dictionary;
import java.util.Hashtable;

import static net.alminoris.arborealnature.block.ModBlocks.*;
import static net.alminoris.arborealnature.item.ModItems.*;
import static net.alminoris.arborealnature.world.ModConfiguredFeautures.registerKey;

public class ModWoodHelper
{
    public static final String[] WOOD_NAMES = new String[] { "hazelnut", "hornbeam", "hawthorn", "quince", "plum", "mango" };

    public static final Dictionary<String, Block> LEAVES = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerLeavesBlock(name));
    }};

    public static final Dictionary<String, Block> LOGS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerLogsBlock(name));
    }};

    public static final Dictionary<String, Block> WOODS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerWoodsBlock(name));
    }};

    public static final Dictionary<String, Block> STRIPPED_LOGS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerStrippedLogsBlock(name));
    }};

    public static final Dictionary<String, Block> STRIPPED_WOODS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerStrippedWoodsBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_PLANKS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerPlanksBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_SLABS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerSlabBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_STAIRS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerStairsBlock(name, WOODEN_PLANKS.get(name)));
    }};

    public static final Dictionary<String, Block> WOODEN_CHISELED = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChiseledBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_CHISELED_SLABS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_CHISELED_STAIRS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChiseledStairsBlock(name, WOODEN_CHISELED.get(name)));
    }};

    public static final Dictionary<String, Block> WOODEN_FENCES = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerFenceBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_FENCE_GATES = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerFenceGateBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_DOORS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerDoorBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_TRAPDOORS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerTrapdoorBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_BUTTONS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerButtonBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_PRESSURE_PLATES = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerPressurePlateBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_SIGNS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerSignBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_WALL_SIGNS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerWallSignBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_HANGING_SIGNS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerHangingSignBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_WALL_HANGING_SIGNS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerWallHangingSignBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_SAPLINGS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerSaplingBlock(name, ModSaplingGenerators.saplingGenerators.get(name)));
    }};

    public static final Dictionary<String, Item> WOODEN_SIGN_ITEMS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerSignItem(name, WOODEN_SIGNS.get(name), WOODEN_WALL_SIGNS.get(name)));
    }};

    public static final Dictionary<String, Item> WOODEN_HANGING_SIGN_ITEMS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerHangingSignItem(name, WOODEN_HANGING_SIGNS.get(name), WOODEN_WALL_HANGING_SIGNS.get(name)));
    }};

    public static final Dictionary<String, Item> WOODEN_BOATS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerBoatItem(ModBoats.boatIDs.get(name), ModBoats.boatKeys.get(name)));
    }};

    public static final Dictionary<String, Item> WOODEN_CHEST_BOATS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChestBoatItem(ModBoats.chestBoatIDs.get(name), ModBoats.boatKeys.get(name)));
    }};

    public static final Dictionary<String, BlockFamily> WOODEN_BLOCK_FAMILIES = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerBlockFamily(WOODEN_PLANKS.get(name), WOODEN_SIGNS.get(name), WOODEN_WALL_SIGNS.get(name)));
    }};
}
