package net.alminoris.arborealnature.world.gen.decorator;

import net.alminoris.arborealnature.world.gen.decorator.custom.LeafCarpetDecorator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecorators
{
    public static final TreeDecoratorType<LeafCarpetDecorator> LEAF_CARPET_DECORATOR = new TreeDecoratorType<>(LeafCarpetDecorator.CODEC);

    public static void register()
    {
        Registry.register(Registries.TREE_DECORATOR_TYPE, "leaf_carpet_decorator", LEAF_CARPET_DECORATOR);
    }
}
