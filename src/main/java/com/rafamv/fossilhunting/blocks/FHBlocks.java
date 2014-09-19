package com.rafamv.fossilhunting.blocks;

import net.minecraft.block.Block;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.blocks.fossils.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class FHBlocks {

	public static Block blockFHGypsumBlock;
	public static Block blockFHGypsumCobblestoneBlock;
	public static Block blockFHGypsumBrick;
	public static Block blockFHFossilBlock;
	public static Block blockFHPetrifiedTree;
	public static Block blockFHEncasedFossilBlock;
	public static Block blockFHCleaningTableBlock;
	public static Block blockFHPaleontologyTableBlock;
	public static Block blockFHBarrelBlock;
	public static final int guiIDFHCleaningTableBlock = 63506;
	public static final int guiIDFHPaleontologyTableBlock = 63507;
	public static final int guiIDFHBarrelBlock = 63508;
	public static final int guiIDFHDisplay = 63509;

	public static Block blockFHFossilGhost;
	public static Block blockFHFossilModelAnkylosaurus;
	public static Block blockFHFossilModelArchaeopteryx;
	public static Block blockFHFossilModelAllosaurus;
	public static Block blockFHFossilModelBrachiosaurus;
	public static Block blockFHFossilModelCompsognathus;
	public static Block blockFHFossilModelCoronicerasRotiforme;
	public static Block blockFHFossilModelDilophosaurus;
	public static Block blockFHFossilModelParasaurolophus;
	public static Block blockFHFossilModelPlesiosaurus;
	public static Block blockFHFossilModelSpinosaurus;
	public static Block blockFHFossilModelStegosaurus;
	public static Block blockFHFossilModelTyrannosaurusRex;
	public static Block blockFHFossilModelTriceratops;
	public static Block blockFHFossilModelVelociraptor;

	public static void mainRegistry() {
		initBlocks();
		registerBlocks();
	}

	public static void initBlocks() {
		blockFHGypsumBlock = new GypsumBlock().setBlockName("GypsumBlock");
		blockFHGypsumCobblestoneBlock = new GypsumCobblestone().setBlockName("GypsumCobblestone");
		blockFHGypsumBrick = new GypsumBrick().setBlockName("GypsumBrick");
		blockFHPetrifiedTree = new PetrifiedTree().setBlockName("PetrifiedTree");
		blockFHCleaningTableBlock = new CleaningTable().setBlockName("CleaningTableBlock").setBlockTextureName(FossilHunting.MODID + ":DEXWood");
		blockFHPaleontologyTableBlock = new PaleontologyTable().setBlockName("PaleontologyTableBlock").setBlockTextureName(FossilHunting.MODID + ":DEXWood");
		blockFHBarrelBlock = new Barrel().setBlockName("BarrelBlock").setBlockTextureName(FossilHunting.MODID + ":DEXWood");
		blockFHFossilBlock = new FossilBlock().setBlockName("FossilBlock");
		blockFHEncasedFossilBlock = new EncasedFossilBlock().setBlockName("EncasedFossilBlock");

		blockFHFossilGhost = new FossilGhostBlock().setBlockName("FossilGhostBlock").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelAnkylosaurus = new FossilModelAnkylosaurus().setBlockName("FossilModelAnkylosaurus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelArchaeopteryx = new FossilModelArchaeopteryx().setBlockName("FossilModelArchaeopteryx").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelAllosaurus = new FossilModelAllosaurus().setBlockName("FossilModelAllosaurus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelBrachiosaurus = new FossilModelBrachiosaurus().setBlockName("FossilModelBrachiosaurus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelCompsognathus = new FossilModelCompsognathus().setBlockName("FossilModelCompsognathus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelDilophosaurus = new FossilModelCoronicerasRotiforme().setBlockName("FossilModelCoronicerasRotiforme").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelCoronicerasRotiforme = new FossilModelCoronicerasRotiforme().setBlockName("FossilModelCoronicerasRotiforme").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelParasaurolophus = new FossilModelParasaurolophus().setBlockName("FossilModelParasaurolophus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelPlesiosaurus = new FossilModelPlesiosaurus().setBlockName("FossilModelPlesiosaurus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelSpinosaurus = new FossilModelSpinosaurus().setBlockName("FossilModelSpinosaurus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelStegosaurus = new FossilModelStegosaurus().setBlockName("FossilModelStegosaurus").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelTyrannosaurusRex = new FossilModelTyrannosaurusRex().setBlockName("FossilModelTyrannosaurusRex").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelTriceratops = new FossilModelTriceratops().setBlockName("FossilModelTriceratops").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
		blockFHFossilModelVelociraptor = new FossilModelVelociraptor().setBlockName("FossilModelVelociraptor").setBlockTextureName(FossilHunting.MODID + ":BoneParticles");
	}

	public static void registerBlocks() {
		GameRegistry.registerBlock(blockFHGypsumBlock, "GypsumBlock");
		GameRegistry.registerBlock(blockFHGypsumCobblestoneBlock, "GypsumCobblestone");
		GameRegistry.registerBlock(blockFHGypsumBrick, "GypsumBrick");
		GameRegistry.registerBlock(blockFHPetrifiedTree, "PetrifiedTree");
		GameRegistry.registerBlock(blockFHCleaningTableBlock, "CleaningTableBlock");
		GameRegistry.registerBlock(blockFHPaleontologyTableBlock, "PaleontologyTableBlock");
		GameRegistry.registerBlock(blockFHBarrelBlock, "BarrelBlock");
		GameRegistry.registerBlock(blockFHFossilBlock, "FossilBlock");
		GameRegistry.registerBlock(blockFHEncasedFossilBlock, "EncasedFossilBlock");

		GameRegistry.registerBlock(blockFHFossilGhost, "FossilGhostBlock");
		GameRegistry.registerBlock(blockFHFossilModelAnkylosaurus, "FossilModelAnkylosaurus");
		GameRegistry.registerBlock(blockFHFossilModelArchaeopteryx, "FossilModelArchaeopteryx");
		GameRegistry.registerBlock(blockFHFossilModelAllosaurus, "FossilModelAllosaurus");
		GameRegistry.registerBlock(blockFHFossilModelBrachiosaurus, "FossilModelBrachiosaurus");
		GameRegistry.registerBlock(blockFHFossilModelCompsognathus, "FossilModelCompsognathus");
		GameRegistry.registerBlock(blockFHFossilModelCoronicerasRotiforme, "FossilModelCoronicerasRotiforme");
		GameRegistry.registerBlock(blockFHFossilModelParasaurolophus, "FossilModelParasaurolophus");
		GameRegistry.registerBlock(blockFHFossilModelPlesiosaurus, "FossilModelPlesiosaurus");
		GameRegistry.registerBlock(blockFHFossilModelSpinosaurus, "FossilModelSpinosaurus");
		GameRegistry.registerBlock(blockFHFossilModelStegosaurus, "FossilModelStegosaurus");
		GameRegistry.registerBlock(blockFHFossilModelTyrannosaurusRex, "FossilModelTyrannosaurusRex");
		GameRegistry.registerBlock(blockFHFossilModelTriceratops, "FossilModelTriceratops");
		GameRegistry.registerBlock(blockFHFossilModelVelociraptor, "FossilModelVelociraptor");
	}

}
