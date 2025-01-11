package net.alminoris.arborealnature.util.helper;

import net.alminoris.arborealnature.entity.ModBoats;
import net.alminoris.arborealnature.world.tree.ModSaplingGenerators;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Item;

import java.util.Dictionary;
import java.util.Hashtable;

import static net.alminoris.arborealnature.block.ModBlocks.*;
import static net.alminoris.arborealnature.item.ModItems.*;

public class ModBlockSetsHelper
{
    public static final String[] CLASSIC_WOOD_NAMES = new String[] { "acacia", "birch", "dark_oak", "cherry", "bamboo", "jungle",
            "mangrove", "crimson", "warped", "spruce", "oak" };

    public static final String[] WOOD_NAMES = new String[] { "hazelnut", "hornbeam", "hawthorn", "quince", "plum", "mango",
            "fig", "viburnum", "wild_cherry", "white_mulberry", "bauhinia", "pine" };

    public static final String[] WF_WOOD_NAMES = new String[] { "olive", "tamarisk" };

    public static final String[] BUSHES_NAMES = new String[] { "bilberry", "blackberry", "pink_currant", "blueberry" };

    public static final Dictionary<String, Block> BUSHES = new Hashtable<>();
    public static final Dictionary<String, Item> BERRIES = new Hashtable<>();
    static
    {
        for (String name : BUSHES_NAMES)
        {
            BUSHES.put(name, registerBushBlock(name));
            BERRIES.put(name, registerBerryItem(name, 2, 0.4f, BUSHES.get(name)));
        }
    }

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

    public static final Dictionary<String, Block> BURNT_LOGS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerBurntLogsBlock(name));
        for(String name : CLASSIC_WOOD_NAMES)
            put(name, registerBurntLogsBlock(name));
        for(String name : WF_WOOD_NAMES)
            put(name, registerBurntLogsBlock(name));
    }};

    public static final Dictionary<String, Block> BURNT_WOODS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerBurntWoodsBlock(name));
        for(String name : CLASSIC_WOOD_NAMES)
            put(name, registerBurntWoodsBlock(name));
        for(String name : WF_WOOD_NAMES)
            put(name, registerBurntWoodsBlock(name));
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
        for(String name : WF_WOOD_NAMES)
            put(name, registerChiseledBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_CHISELED_SLABS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
        for(String name : WF_WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_CHISELED_STAIRS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChiseledStairsBlock(name, WOODEN_CHISELED.get(name)));
        for(String name : WF_WOOD_NAMES)
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

    public static final Dictionary<String, Block> WOODEN_SIGNS = new Hashtable<>();
    public static final Dictionary<String, Block> WOODEN_WALL_SIGNS = new Hashtable<>();
    public static final Dictionary<String, Block> WOODEN_HANGING_SIGNS = new Hashtable<>();
    public static final Dictionary<String, Block> WOODEN_WALL_HANGING_SIGNS = new Hashtable<>();
    public static final Dictionary<String, Item> WOODEN_SIGN_ITEMS = new Hashtable<>();
    public static final Dictionary<String, Item> WOODEN_HANGING_SIGN_ITEMS = new Hashtable<>();

    static
    {
        for (String name : WOOD_NAMES)
        {
            WOODEN_SIGNS.put(name, registerSignBlock(name));
            WOODEN_WALL_SIGNS.put(name, registerWallSignBlock(name));
            WOODEN_HANGING_SIGNS.put(name, registerHangingSignBlock(name));
            WOODEN_WALL_HANGING_SIGNS.put(name, registerWallHangingSignBlock(name));
            WOODEN_SIGN_ITEMS.put(name, registerSignItem(name, WOODEN_SIGNS.get(name), WOODEN_WALL_SIGNS.get(name)));
            WOODEN_HANGING_SIGN_ITEMS.put(name, registerHangingSignItem(name, WOODEN_HANGING_SIGNS.get(name), WOODEN_WALL_HANGING_SIGNS.get(name)));
        }
    }

    public static final Dictionary<String, Block> WOODEN_SAPLINGS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerSaplingBlock(name, ModSaplingGenerators.saplingGenerators.get(name)));
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
