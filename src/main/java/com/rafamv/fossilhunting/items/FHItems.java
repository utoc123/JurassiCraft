package com.rafamv.fossilhunting.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.rafamv.fossilhunting.items.fossils.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class FHItems {
	public static ToolMaterial FOSSILBREAKERSLOW = EnumHelper.addToolMaterial("FOSSILBREAKER", 0, 16, 1.0f, 0.0f, 22);
	public static ToolMaterial FOSSILBREAKERFAST = EnumHelper.addToolMaterial("FOSSILBREAKER", 1, 16, 2.0f, 2.0f, 22);
	
	public static Item itemDEXBrush;
	public static Item itemDEXChisel;
	public static Item itemDEXRockPick;
	public static Item itemDEXSledgeHammer;
	
	public static Item itemDEXMagnifier;
	public static Item itemDEXGypsumPowder;
	public static Item itemDEXPlasterPowder;
	public static Item itemDEXBucketWithPlaster;
	public static Item itemDEXPlasterAndBandage;
	//public static Item itemDEXWaterBowl;			ADD LATER
	//public static Item itemDEXBowlWithPlaster;	ADD LATER
	
	public static Item itemDEXEncasedFossil;
	public static Item itemDEXCoveredFossil;
	public static Item itemFHFossil;
	public static Item itemDEXDinosaurEncyclopedia;
	
	public static Item itemDEXFossilCoronicerasRotiforme;
	public static Item itemDEXFossilCompsognathus;
	public static Item itemDEXFossilVelociraptor;
	public static Item itemDEXFossilStegosaurus;
	public static Item itemDEXFossilTyrannosaurusRex;
	public static Item itemDEXFossilTriceratops;
	public static Item itemDEXFossilBrachiosaurus;
	public static Item itemDEXFossilParasaurolophus;
	public static Item itemDEXFossilPlesiosaurus;
	public static Item itemDEXFossilAllosaurus;
	public static Item itemDEXFossilSpinosaurus;
	public static Item itemDEXFossilDilophosaurus;
	public static Item itemDEXFossilArchaeopteryx;
	// public static Item itemDEXFossilAnkylosaurus;
	
	public static void mainRegistry() {
		initItems();
		registerItems();
	}
	
	public static void initItems() {
		itemDEXEncasedFossil = new EncasedFossil().setUnlocalizedName("EncasedFossil");
		itemDEXCoveredFossil = new CoveredFossil().setUnlocalizedName("CoveredFossil");
		itemFHFossil = new Fossil().setUnlocalizedName("Fossil");
		itemDEXDinosaurEncyclopedia = new DinosaurEncyclopedia().setUnlocalizedName("DinosaurEncyclopedia");

		itemDEXMagnifier = new Magnifier().setUnlocalizedName("Magnifier");
		itemDEXGypsumPowder = new GypsumPowder().setUnlocalizedName("GypsumPowder");
		itemDEXPlasterPowder = new PlasterPowder().setUnlocalizedName("PlasterPowder");
		itemDEXBucketWithPlaster = new BucketWithPlaster().setUnlocalizedName("BucketWithPlaster");
		itemDEXPlasterAndBandage = new PlasterAndBandage().setUnlocalizedName("PlasterAndBandage");
		
		itemDEXRockPick = new RockPick(FOSSILBREAKERFAST).setUnlocalizedName("RockPick");
		itemDEXSledgeHammer = new SledgeHammer(FOSSILBREAKERFAST).setUnlocalizedName("SledgeHammer");
		itemDEXChisel = new Chisel(FOSSILBREAKERSLOW).setUnlocalizedName("Chisel");
		itemDEXBrush = new Brush(FOSSILBREAKERSLOW).setUnlocalizedName("Brush");

		itemDEXFossilCoronicerasRotiforme = new FossilCoronicerasRotiforme().setUnlocalizedName("FossilCoronicerasRotiforme");
		itemDEXFossilCompsognathus = new FossilCompsognathus().setUnlocalizedName("FossilCompsognathus");
		itemDEXFossilVelociraptor = new FossilVelociraptor().setUnlocalizedName("FossilVelociraptor");
		itemDEXFossilStegosaurus = new FossilStegosaurus().setUnlocalizedName("FossilStegosaurus");
		itemDEXFossilTriceratops = new FossilTriceratops().setUnlocalizedName("FossilTriceratops");
		itemDEXFossilTyrannosaurusRex = new FossilTyrannosaurusRex().setUnlocalizedName("FossilTyrannosaurusRex");
		itemDEXFossilBrachiosaurus = new FossilBrachiosaurus().setUnlocalizedName("FossilBrachiosaurus");
		itemDEXFossilParasaurolophus = new FossilParasaurolophus().setUnlocalizedName("FossilParasaurolophus");
		itemDEXFossilPlesiosaurus = new FossilPlesiosaurus().setUnlocalizedName("FossilPlesiosaurus");
		itemDEXFossilAllosaurus = new FossilAllosaurus().setUnlocalizedName("FossilAllosaurus");
		itemDEXFossilSpinosaurus = new FossilSpinosaurus().setUnlocalizedName("FossilSpinosaurus");
		itemDEXFossilDilophosaurus = new FossilDilophosaurus().setUnlocalizedName("FossilDilophosaurus");
		itemDEXFossilArchaeopteryx = new FossilArchaeopteryx().setUnlocalizedName("FossilArchaeopteryx");
		// itemDEXFossilAnkylosaurus = new FossilAnkylosaurus().setUnlocalizedName("FossilAnkylosaurus");
		
	}
	
	public static void registerItems() {
		GameRegistry.registerItem(itemDEXEncasedFossil, "EncasedFossil");
		GameRegistry.registerItem(itemDEXCoveredFossil, "CoveredFossil");
		GameRegistry.registerItem(itemFHFossil, "Fossil");
		GameRegistry.registerItem(itemDEXDinosaurEncyclopedia, "DinosaurEncyclopedia");

		GameRegistry.registerItem(itemDEXMagnifier, "Magnifier");
		GameRegistry.registerItem(itemDEXGypsumPowder, "GypsumPowder");
		GameRegistry.registerItem(itemDEXPlasterPowder, "PlasterPowder");
		GameRegistry.registerItem(itemDEXBucketWithPlaster, "BucketWithPlaster");
		GameRegistry.registerItem(itemDEXPlasterAndBandage, "PlasterAndBandage");
		
		GameRegistry.registerItem(itemDEXRockPick, "RockPick");
		GameRegistry.registerItem(itemDEXSledgeHammer, "SledgeHammer");
		GameRegistry.registerItem(itemDEXChisel, "Chisel");
		GameRegistry.registerItem(itemDEXBrush, "Brush");

		GameRegistry.registerItem(itemDEXFossilCoronicerasRotiforme, "FossilCoronicerasRotiforme");
		GameRegistry.registerItem(itemDEXFossilCompsognathus, "FossilCompsognathus");
		GameRegistry.registerItem(itemDEXFossilVelociraptor, "FossilVelociraptor");
		GameRegistry.registerItem(itemDEXFossilStegosaurus, "FossilStegosaurus");
		//GameRegistry.registerItem(itemDEXFossilTriceratops, "FossilTriceratops");
		GameRegistry.registerItem(itemDEXFossilTyrannosaurusRex, "FossilTyrannosaurusRex");
		//GameRegistry.registerItem(itemDEXFossilBrachiosaurus, "FossilBrachiosaurus");
		//GameRegistry.registerItem(itemDEXFossilParasaurolophus, "FossilParasaurolophus");
		GameRegistry.registerItem(itemDEXFossilPlesiosaurus, "FossilPlesiosaurus");
		//GameRegistry.registerItem(itemDEXFossilAllosaurus, "FossilAllosaurus");
		//GameRegistry.registerItem(itemDEXFossilSpinosaurus, "FossilSpinosaurus");
		//GameRegistry.registerItem(itemDEXFossilDilophosaurus, "FossilDilophosaurus");
		//GameRegistry.registerItem(itemDEXFossilArchaeopteryx, "FossilArchaeopteryx");
		// GameRegistry.registerItem(itemDEXFossilAnkylosaurus, "FossilAnkylosaurus");
	}

}
