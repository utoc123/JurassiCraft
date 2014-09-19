package com.rafamv.bygoneage.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.rafamv.bygoneage.registry.BygoneAgeBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class BygoneAgeWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);

			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);

			case 1:
				generateTheEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 12; i++) {
			int randPosX = chunkX + random.nextInt(16);
			int randPosZ = chunkZ + random.nextInt(16);
			int randPosY = random.nextInt(72);
			(new BygoneAgeWorldGenMinable(BygoneAgeBlocks.fossilBlock, 4, Blocks.stone)).generate(world, random, randPosX, randPosY, randPosZ);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {

	}

	private void generateTheEnd(World world, Random random, int i, int j) {

	}

}
