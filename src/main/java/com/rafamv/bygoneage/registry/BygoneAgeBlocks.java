package com.rafamv.bygoneage.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.rafamv.bygoneage.blocks.Centrifuge;
import com.rafamv.bygoneage.blocks.DNAExtractor;
import com.rafamv.bygoneage.blocks.FossilBlock;
import com.rafamv.bygoneage.blocks.Hatchery;
import com.rafamv.bygoneage.blocks.HatcheryGhostBlock;
import com.rafamv.bygoneage.enums.BygoneAgeBlockInformation;

import cpw.mods.fml.common.registry.GameRegistry;

public class BygoneAgeBlocks {

	public static Block hatchery;
	public static Block hatcheryGhostBlock;
	public static Block centrifuge;
	public static Block dnaExtractor;
	public static Block fossilBlock;

	public static void registryAll() {
		initBlocks();
		registerBlocks();
	}

	public static void initBlocks() {
		hatchery = new Hatchery(Material.iron).setBlockName(BygoneAgeBlockInformation.HATCHERY.getUnlocalizedName()).setBlockTextureName(BygoneAgeBlockInformation.HATCHERY.getParticleTexture());
		hatcheryGhostBlock = new HatcheryGhostBlock(Material.iron).setBlockName(BygoneAgeBlockInformation.HATCHERYGHOSTBLOCK.getUnlocalizedName()).setBlockTextureName(BygoneAgeBlockInformation.HATCHERYGHOSTBLOCK.getParticleTexture());
		centrifuge = new Centrifuge(Material.iron).setBlockName(BygoneAgeBlockInformation.CENTRIFUGE.getUnlocalizedName()).setBlockTextureName(BygoneAgeBlockInformation.CENTRIFUGE.getParticleTexture());
		dnaExtractor = new DNAExtractor(Material.iron).setBlockName(BygoneAgeBlockInformation.DNAEXTRACTOR.getUnlocalizedName()).setBlockTextureName(BygoneAgeBlockInformation.DNAEXTRACTOR.getParticleTexture());
		fossilBlock = new FossilBlock(Material.rock).setBlockName(BygoneAgeBlockInformation.FOSSILBLOCK.getUnlocalizedName()).setBlockTextureName(BygoneAgeBlockInformation.FOSSILBLOCK.getParticleTexture());
	}

	public static void registerBlocks() {
		GameRegistry.registerBlock(hatchery, BygoneAgeBlockInformation.HATCHERY.getUnlocalizedName());
		GameRegistry.registerBlock(hatcheryGhostBlock, BygoneAgeBlockInformation.HATCHERYGHOSTBLOCK.getUnlocalizedName());
		GameRegistry.registerBlock(centrifuge, BygoneAgeBlockInformation.CENTRIFUGE.getUnlocalizedName());
		GameRegistry.registerBlock(dnaExtractor, BygoneAgeBlockInformation.DNAEXTRACTOR.getUnlocalizedName());
		GameRegistry.registerBlock(fossilBlock, BygoneAgeBlockInformation.FOSSILBLOCK.getUnlocalizedName());
	}

}
