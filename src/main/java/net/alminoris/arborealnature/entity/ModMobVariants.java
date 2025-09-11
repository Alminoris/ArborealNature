package net.alminoris.arborealnature.entity;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.world.biome.ModBiomes;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import java.util.Optional;

public class ModMobVariants
{
    public static final Identifier BOREAL_FROG_ID = Identifier.of(ArborealNature.MOD_ID, "boreal_frog");
    public static final Identifier BOREAL_FROG_TEXTURE = Identifier.of(ArborealNature.MOD_ID, "textures/entity/frog/boreal_frog.png");

    public static void register()
    {
        Registry.register(Registries.FROG_VARIANT, BOREAL_FROG_ID, new FrogVariant(BOREAL_FROG_TEXTURE));

        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) ->
        {
            if (entity instanceof FrogEntity frog)
            {
                setFrogVariantIfInBoreal(frog, serverWorld);
            }
        });
    }

    private static void setFrogVariantIfInBoreal(FrogEntity frog, ServerWorld serverWorld)
    {
        BlockPos pos = frog.getBlockPos();

        RegistryEntry<Biome> biomeEntry = serverWorld.getBiome(pos);
        Optional<RegistryKey<Biome>> biomeKey = biomeEntry.getKey();

        if (biomeKey.isPresent() && biomeKey.get().equals(ModBiomes.BOREAL_MARSH)) {
            var frogVariantRegistry = serverWorld.getRegistryManager().get(RegistryKeys.FROG_VARIANT);
            RegistryKey<FrogVariant> ourVarKey = RegistryKey.of(RegistryKeys.FROG_VARIANT, BOREAL_FROG_ID);

            Optional<RegistryEntry.Reference<FrogVariant>> maybeVariant = frogVariantRegistry.getEntry(ourVarKey);
            maybeVariant.ifPresent(entry -> frog.setVariant(entry.value()));
        }
    }
}