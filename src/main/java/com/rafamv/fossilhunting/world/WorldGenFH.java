package com.rafamv.fossilhunting.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.rafamv.fossilhunting.blocks.FHBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenFH implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX*16, chunkZ*16);
		
		case 0:
			generateSurface(world, random, chunkX*16, chunkZ*16);
		
		case 1:
			generateTheEnd(world, random, chunkX*16, chunkZ*16);
		}
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		
		for (int i = 0; i < 15; i++) { 
			int randPosX = chunkX + random.nextInt(16);
			int randPosZ = chunkZ + random.nextInt(16);
			int randPosY =  8 + random.nextInt(64);
			
			(new WorldGenFHMinable(FHBlocks.blockFHFossilBlock, 4, Blocks.stone)).generate(world, random, randPosX, randPosY, randPosZ);
		
		}

		for (int i = 0; i < 6; i++) {
			int randPosX = chunkX + random.nextInt(16);
			int randPosZ = chunkZ + random.nextInt(16);
			int randPosY = random.nextInt(128);
			
			(new WorldGenFHMinable(FHBlocks.blockFHGypsumBlock, 16, Blocks.stone)).generate(world, random, randPosX, randPosY, randPosZ);
		}
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		
	}	

	private void generateTheEnd(World world, Random random, int i, int j) {
		
	}

}
