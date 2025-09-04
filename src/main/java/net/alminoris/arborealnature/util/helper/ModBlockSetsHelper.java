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
            "fig", "viburnum", "wild_cherry", "white_mulberry", "bauhinia", "pine", "fir", "cedar", "araucaria", "juniper",
            "bald_cypress", "thuja", "sequoia", "mountain_hemlock", "cryptomeria", "yew", "larch" };

    public static final String[] FRUITED_WOOD_NAMES = new String[] { "hawthorn", "quince", "plum", "mango", "viburnum",
            "wild_cherry", "white_mulberry", "bauhinia", "juniper", "yew" };

    public static final String[] CONIFER_CONES_NAMES = new String[] { "pine", "fir", "cedar", "araucaria",
            "bald_cypress", "thuja", "sequoia", "mountain_hemlock", "cryptomeria", "larch" };

    public static final String[] COVER_NAMES = new String[] { "hazelnut", "bauhinia", "pine", "fir", "cedar", "araucaria", "juniper",
            "bald_cypress", "thuja", "sequoia", "mountain_hemlock", "cryptomeria", "yew", "larch" };

    public static final String[] FLOWER_NAMES = new String[] { "geranium", "thistle", "xerochrysum", "orchid",
            "bluebell", "red_trillium", "golden_aster"};

    public static final String[] TALL_FLOWER_NAMES = new String[] { "large_celandine", "bluegrass", "large_orchid", "goldenrod" };

    public static final String[] WF_WOOD_NAMES = new String[] { "olive", "tamarisk", "western_serviceberry" };

    public static final String[] ST_WOOD_NAMES = new String[] { "walnut", "silver_maple", "staghorn_sumac", "silverberry" };

    public static final String[] WT_WOOD_NAMES = new String[] { "willow", "poplar", "alder", "aspen" };

    public static final String[] MT_WOOD_NAMES = new String[] { "azalea", "apple", "scots_pine", "swamp_oak" };

    public static final String[] NSS_WOOD_NAMES = new String[] { "aspen_nss", "cedar_nss", "coconut_nss", "cypress_nss", "fir_nss", "ghaf_nss",
            "larch_nss", "mahogany_nss", "maple_nss", "olive_nss", "palo_verde_nss", "redwood_nss", "saxaul_nss", "sugi_nss", "willow_nss", "wisteria_nss" };

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

    public static final Dictionary<String, Block> FLOWERS = new Hashtable<>()
    {{
        for(String name : FLOWER_NAMES)
            put(name, registerFlower(name));
    }};

    public static final Dictionary<String, Block> POTTED_FLOWERS = new Hashtable<>()
    {{
        for(String name : FLOWER_NAMES)
            put(name, registerPottedFlower(name, FLOWERS.get(name)));
    }};

    public static final Dictionary<String, Block> TALL_FLOWERS = new Hashtable<>()
    {{
        for(String name : TALL_FLOWER_NAMES)
            put(name, registerTallFlower(name));
    }};

    public static final Dictionary<String, Block> COVERS = new Hashtable<>()
    {{
        for(String name : COVER_NAMES)
            put(name, registerCover(name));
    }};

    public static final Dictionary<String, Block> COVER_BLOCKS = new Hashtable<>()
    {{
        for(String name : COVER_NAMES)
            put(name, registerCoverBlock(name));
    }};

    public static final Dictionary<String, Item> CONES = new Hashtable<>()
    {{
        for(String name : CONIFER_CONES_NAMES)
            put(name, registerConeItem(name));
    }};

    public static final Dictionary<String, Block> CONE_BLOCKS = new Hashtable<>()
    {{
        for(String name : CONIFER_CONES_NAMES)
            put(name, registerConeBlock(name));
    }};

    public static final Dictionary<String, Block> LEAVES = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerLeavesBlock(name));
    }};

    public static final Dictionary<String, Block> FRUITED_LEAVES = new Hashtable<>()
    {{
        for(String name : FRUITED_WOOD_NAMES)
            put(name, registerFruitedLeavesBlock(name));
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
        for(String name : ST_WOOD_NAMES)
            put(name, registerBurntLogsBlock(name));
        for(String name : WT_WOOD_NAMES)
            put(name, registerBurntLogsBlock(name));
        for(String name : MT_WOOD_NAMES)
            put(name, registerBurntLogsBlock(name));
        for(String name : NSS_WOOD_NAMES)
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
        for(String name : ST_WOOD_NAMES)
            put(name, registerBurntWoodsBlock(name));
        for(String name : WT_WOOD_NAMES)
            put(name, registerBurntWoodsBlock(name));
        for(String name : MT_WOOD_NAMES)
            put(name, registerBurntWoodsBlock(name));
        for(String name : NSS_WOOD_NAMES)
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
        for(String name : ST_WOOD_NAMES)
            put(name, registerChiseledBlock(name));
        for(String name : WT_WOOD_NAMES)
            put(name, registerChiseledBlock(name));
        for(String name : MT_WOOD_NAMES)
            put(name, registerChiseledBlock(name));
        for(String name : NSS_WOOD_NAMES)
            put(name, registerChiseledBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_CHISELED_SLABS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
        for(String name : WF_WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
        for(String name : ST_WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
        for(String name : WT_WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
        for(String name : MT_WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
        for(String name : NSS_WOOD_NAMES)
            put(name, registerChiseledSlabBlock(name));
    }};

    public static final Dictionary<String, Block> WOODEN_CHISELED_STAIRS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, registerChiseledStairsBlock(name, WOODEN_CHISELED.get(name)));
        for(String name : WF_WOOD_NAMES)
            put(name, registerChiseledStairsBlock(name, WOODEN_CHISELED.get(name)));
        for(String name : ST_WOOD_NAMES)
            put(name, registerChiseledStairsBlock(name, WOODEN_CHISELED.get(name)));
        for(String name : WT_WOOD_NAMES)
            put(name, registerChiseledStairsBlock(name, WOODEN_CHISELED.get(name)));
        for(String name : MT_WOOD_NAMES)
            put(name, registerChiseledStairsBlock(name, WOODEN_CHISELED.get(name)));
        for(String name : NSS_WOOD_NAMES)
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
        {
            if (name.equals("sequoia") || name.equals("yew"))
                put(name, registerSaplingBlock(name, ModSaplingGenerators.extendedSaplingGenerators.get(name)));
            else
                put(name, registerSaplingBlock(name, ModSaplingGenerators.saplingGenerators.get(name)));
        }

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
