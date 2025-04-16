package net.alminoris.arborealnature.entity;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.*;
import net.alminoris.arborealnature.entity.custom.projectile.CaribouSpearEntity;
import net.alminoris.arborealnature.entity.custom.projectile.SilentArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities
{
    public static final EntityType<SquirrelEntity> SQUIRREL = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "squirrel"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SquirrelEntity::new)
                            .dimensions(EntityDimensions.fixed(0.5f, 0.8125f)).build());

    public static final EntityType<WoodMouseEntity> WOOD_MOUSE = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "wood_mouse"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WoodMouseEntity::new)
                    .dimensions(EntityDimensions.fixed(0.625f, 0.3125f)).build());

    public static final EntityType<FigeaterBeetleEntity> FIGEATER_BEETLE = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "figeater_beetle"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FigeaterBeetleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6875f, 0.25f)).build());

    public static final EntityType<OrchidMantisEntity> ORCHID_MANTIS = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "orchid_mantis"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OrchidMantisEntity::new)
                    .dimensions(EntityDimensions.fixed(0.625f, 1.5625f)).build());

    public static final EntityType<MooseEntity> MOOSE = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "moose"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MooseEntity::new)
                    .dimensions(EntityDimensions.fixed(2.025f, 2.4f)).build());

    public static final EntityType<LynxEntity> LYNX = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "lynx"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LynxEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.1875f)).build());

    public static final EntityType<CaribouEntity> CARIBOU = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "caribou"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CaribouEntity::new)
                    .dimensions(EntityDimensions.fixed(1.25f, 1.6875f)).build());

    public static final EntityType<WolverineEntity> WOLVERINE = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "wolverine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WolverineEntity::new)
                    .dimensions(EntityDimensions.fixed(1.375f, 0.625f)).build());

    public static final EntityType<SilentArrowEntity> SILENT_ARROW = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "silent_arrow"),
            FabricEntityTypeBuilder.<SilentArrowEntity>create(SpawnGroup.MISC, SilentArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<CaribouSpearEntity> CARIBOU_SPEAR = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "caribou_spear"),
            FabricEntityTypeBuilder.<CaribouSpearEntity>create(SpawnGroup.MISC, CaribouSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackable(4, 20).build());

    public static final EntityType<TenrecEntity> TENREC = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "tenrec"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TenrecEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 0.625f)).build());
}
