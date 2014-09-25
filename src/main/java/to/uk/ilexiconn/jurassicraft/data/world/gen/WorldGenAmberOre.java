package to.uk.ilexiconn.jurassicraft.data.world.gen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import to.uk.ilexiconn.jurassicraft.ModBlocks;

import java.util.Random;

public class WorldGenAmberOre implements IWorldGenerator
{
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.dimensionId != 1 && world.provider.dimensionId != -1)
        {
            int x, y, z;

            x = random.nextInt(16) + (chunkX * 16);
            y = random.nextInt(16);
            z = random.nextInt(16) + (chunkZ * 16);

            (new WorldGenMinable(ModBlocks.amberOre, 6 + random.nextInt(3))).generate(world, random, x, y, z);
        }
    }
}
