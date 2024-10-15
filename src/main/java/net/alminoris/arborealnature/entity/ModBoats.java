package net.alminoris.arborealnature.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.block.ModBlocks;
import net.alminoris.arborealnature.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats
{
    public static final Identifier HAZELNUT_BOAT_ID = Identifier.of(ArborealNature.MOD_ID, "hazelnut_boat");
    public static final Identifier HAZELNUT_CHEST_BOAT_ID = Identifier.of(ArborealNature.MOD_ID, "hazelnut_chest_boat");

    public static final RegistryKey<TerraformBoatType> HAZELNUT_BOAT_KEY = TerraformBoatTypeRegistry.createKey(HAZELNUT_BOAT_ID);

    public static void registerBoats()
    {
        TerraformBoatType hazelnutBoat = new TerraformBoatType.Builder()
                .item(ModItems.HAZELNUT_BOAT)
                .chestItem(ModItems.HAZELNUT_CHEST_BOAT)
                .planks(ModBlocks.HAZELNUT_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, HAZELNUT_BOAT_KEY, hazelnutBoat);
    }
}
