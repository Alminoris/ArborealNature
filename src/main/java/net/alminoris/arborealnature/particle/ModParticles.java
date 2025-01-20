package net.alminoris.arborealnature.particle;

import net.alminoris.arborealnature.ArborealNature;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles
{
    public static final SimpleParticleType BAUHINIA_PETALS = FabricParticleTypes.simple();
    public static final SimpleParticleType PINE_NEEDLES = FabricParticleTypes.simple();
    public static final SimpleParticleType FIR_NEEDLES = FabricParticleTypes.simple();
    public static final SimpleParticleType CEDAR_NEEDLES = FabricParticleTypes.simple();
    public static final SimpleParticleType HAZELNUT_LEAVES = FabricParticleTypes.simple();
    public static final SimpleParticleType HORNBEAM_LEAVES = FabricParticleTypes.simple();
    public static final SimpleParticleType HAWTHORN_PETALS = FabricParticleTypes.simple();
    public static final SimpleParticleType FIG_LEAVES = FabricParticleTypes.simple();

    public static void registerParticles()
    {
        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "bauhinia_petals"),
                BAUHINIA_PETALS
        );

        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "pine_needles"),
                PINE_NEEDLES
        );

        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "fir_needles"),
                FIR_NEEDLES
        );

        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "cedar_needles"),
                CEDAR_NEEDLES
        );

        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "hazelnut_leaves"),
                HAZELNUT_LEAVES
        );

        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "hornbeam_leaves"),
                HORNBEAM_LEAVES
        );

        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "hawthorn_petals"),
                HAWTHORN_PETALS
        );

        Registry.register(
                Registries.PARTICLE_TYPE,
                Identifier.of(ArborealNature.MOD_ID, "fig_leaves"),
                FIG_LEAVES
        );
    }
}
