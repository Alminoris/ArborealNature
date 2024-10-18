package net.alminoris.arborealnature.world.gen;

public class ModWorldGeneration
{
    public static void generateModWorldGen()
    {
        ModTreeGeneration.generateTrees();

        ModEntityGeneration.addSpawns();
    }
}
