package net.alminoris.arborealnature.entity;

import net.alminoris.arborealnature.ArborealNature;
import net.alminoris.arborealnature.entity.custom.FigeaterBeetleEntity;
import net.alminoris.arborealnature.entity.custom.SquirrelEntity;
import net.alminoris.arborealnature.entity.custom.WoodMouseEntity;
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
                            .dimensions(EntityDimensions.fixed(0.8f, 0.9f)).build());

    public static final EntityType<WoodMouseEntity> WOOD_MOUSE = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "wood_mouse"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WoodMouseEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<FigeaterBeetleEntity> FIGEATER_BEETLE = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "figeater_beetle"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FigeaterBeetleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<SilentArrowEntity> SILENT_ARROW = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(ArborealNature.MOD_ID, "silent_arrow"),
            FabricEntityTypeBuilder.<SilentArrowEntity>create(SpawnGroup.MISC, SilentArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
}
