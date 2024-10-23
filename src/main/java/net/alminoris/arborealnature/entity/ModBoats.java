package net.alminoris.arborealnature.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.util.helper.ModWoodHelper;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.Dictionary;
import java.util.Hashtable;


public class ModBoats
{
    public static Dictionary<String, Identifier> boatIDs = new Hashtable<>()
    {{
        for(String name : ModWoodHelper.WOOD_NAMES)
            put(name, Identifier.of(ArborealNature.MOD_ID, name+"_boat"));
    }};

    public static Dictionary<String, Identifier> chestBoatIDs = new Hashtable<>()
    {{
        for(String name : ModWoodHelper.WOOD_NAMES)
            put(name, Identifier.of(ArborealNature.MOD_ID, name+"_chest_boat"));
    }};

    public static Dictionary<String, RegistryKey<TerraformBoatType>> boatKeys = new Hashtable<>()
    {{
        for(String name : ModWoodHelper.WOOD_NAMES)
            put(name, TerraformBoatTypeRegistry.createKey(boatIDs.get(name)));
    }};

    public static void registerBoats()
    {
        for (String name : ModWoodHelper.WOOD_NAMES)
        {
            TerraformBoatType hazelnutBoat = new TerraformBoatType.Builder()
                    .item(ModWoodHelper.WOODEN_BOATS.get(name))
                    .chestItem(ModWoodHelper.WOODEN_CHEST_BOATS.get(name))
                    .planks(ModWoodHelper.WOODEN_PLANKS.get(name).asItem())
                    .build();

            Registry.register(TerraformBoatTypeRegistry.INSTANCE, boatKeys.get(name), hazelnutBoat);
        }
    }
}
