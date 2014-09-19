package com.rafamv.fossilhunting.enums;

import com.rafamv.fossilhunting.items.FHItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public enum FossilInformation {

	CORONICERASROTIFORME("Coroniceras rotiforme", 	(byte) 0, "Arietitidae", 		(short) 199, 	(short) 191, 	"Carnivorous", 	1.00000D, 0.50D, 0.50D, "IconCoronicerasRotiforme", 	(byte) 1, (byte) 1, 	"Dinosaur"),
	COMPSOGNATHUS("Compsognathus longipes", 		(byte) 1, "Compsognathidae", 	(short) 151, 	(short) 147, 	"Carnivorous", 	4.00000D, 1.00D, 0.55D, "IconCompsognathus", 			(byte) 1, (byte) 2, 	"Dinosaur"),
	VELOCIRAPTOR("Velociraptor mongoliensis", 		(byte) 2, "Dromaeosauridae",	(short) 75, 	(short) 71, 	"Carnivorous", 	15.0000D, 2.00D, 0.80D, "IconVelociraptor", 			(byte) 1, (byte) 2, 	"Dinosaur"),
	TYRANNOSAURUSREX("Tyrannosaurus rex", 			(byte) 3, "Tyrannosauridae", 	(short) 67, 	(short) 65, 	"Carnivorous", 	6800.00D, 12.3D, 4.00D, "IconTyrannosaurusRex", 		(byte) 3, (byte) 5, 	"Dinosaur"),
	STEGOSAURUS("Stegosaurus armatus",				(byte) 4, "Stegosauridae", 		(short) 156, 	(short) 149, 	"Herbivorous", 	4500.00D, 8.50D, 4.20D, "IconStegosaurus", 				(byte) 2, (byte) 4, 	"Dinosaur"),
	ANKYLOSAURUS("Ankylosaurus magniventris", 		(byte) 5, "Ankylosauridae", 	(short) 67, 	(short) 65, 	"Herbivorous", 	6000.00D, 6.25D, 1.70D, "IconAnkylosaurus", 			(byte) 2, (byte) 4, 	"Dinosaur"),
	PLESIOSAURUS("Plesiosaurus dolichodeirus", 		(byte) 6, "Plesiosauridae", 	(short) 200, 	(short) 194, 	"Piscivorous", 	480.000D, 3.60D, 1.20D, "IconPlesiosaurus", 			(byte) 2, (byte) 4, 	"Dinosaur");
	
	/*
	TRICERATOPS("Triceratops horridus",				5, 		"Herbivore",	67, 	65,		9000.0,		9.0,	3.2,	"SmallCarnivore");
	BRACHIOSAURUS("Brachiosaurus altithorax",		6, 		"Herbivore",	156, 	145,	35000.0,	26.0,	6.5,	"SmallCarnivore");
	PARASAUROLOPHUS("Parasaurolophus walkeri",		7, 		"Herbivore",	77, 	72,		2500.0,		9.5,	3.8,	"SmallCarnivore");
	ALLOSAURUS("Allosaurus fragilis",				8, 		"Carnivore",	156, 	150,		2200.0,		11.0,	3.5,	"SmallCarnivore");
	SPINOSAURUS("Spinosaurus aegyptiacus",			9,	 	"Carnivore",	111, 	93,		8500.0,		17,		5.5,	"SmallCarnivore");
	DILOPHOSAURUS("Dilophosaurus wetherilli",		10, 	"Carnivore",	196, 	191,	500.0,		6.5,	1.9,	"SmallCarnivore");
	ARCHAEOPTERYX("Archaeopteryx lithographica",	11, 	"Carnivore",	152, 	145,	1.0,		0.5,	0.3,	"SmallCarnivore");
	*/
	//EXAMPLE("Species", id, "era", "year");

	private FossilInformation(String name, byte id, String dinoFamily, short maxYear, short minYear, String dinoDiet, double dinoWeight, double dinoLength, double dinoHeight, String icon, byte xB, byte zB, String creature) {
		this.fossilName = name;
		this.fossilID = id;
		this.family = dinoFamily;
		this.diet = dinoDiet;
		this.beginOfExistence = maxYear;
		this.endOfExistence = minYear;
		this.weight = dinoWeight;
		this.height = dinoHeight;
		this.length = dinoLength;
		this.iconName = icon;
		this.boundX = xB;
		this.boundZ = zB;
		this.typeOfCreature = creature;
	}

	/** Returns the era and period of the fossil based on its year of existence */
	public static String getEraFromExistence(double year) {
		if (year <= 252.7 && year > 251.2) {
			return "Induan period of the Early Triassic";
		} else if (year <= 251.2 && year > 247.2) {
			return "Olenekian period of the Early Triassic";
		} else if (year <= 247.2 && year > 242.0) {
			return "Anisian period of the Middle Triassic";
		} else if (year <= 242.0 && year > 235.0) {
			return "Ladinian period of the Middle Triassic";
		} else if (year <= 235.0 && year > 228.0) {
			return "Carnian period of the Middle Triassic";
		} else if (year <= 228.0 && year > 208.5) {
			return "Norian period of the Late Triassic";
		} else if (year <= 208.5 && year > 201.3) {
			return "Rhaetian period of the Late Triassic";
		} else if (year <= 201.3 && year > 199.3) {
			return "Hettangian period of the Early Jurassic";
		} else if (year <= 199.3 && year > 190.8) {
			return "Sinemurian period of the Early Jurassic";
		} else if (year <= 190.8 && year > 182.7) {
			return "Pliensbachian period of the Early Jurassic";
		} else if (year <= 182.7 && year > 174.1) {
			return "Toarcian period of the Early Jurassic";
		} else if (year <= 174.1 && year > 170.3) {
			return "Aalenian period of the Middle Jurassic";
		} else if (year <= 170.3 && year > 168.3) {
			return "Bajocian period of the Middle Jurassic";
		} else if (year <= 168.3 && year > 166.1) {
			return "Bathonian period of the Middle Jurassic";
		} else if (year <= 166.1 && year > 163.5) {
			return "Callovian period of the Middle Jurassic";
		} else if (year <= 163.5 && year > 157.3) {
			return "Oxfordian period of the Late Jurassic";
		} else if (year <= 157.3 && year > 152.1) {
			return "Kimmeridgian period of the Late Jurassic";
		} else if (year <= 152.1 && year > 145.0) {
			return "Tithonian period of the Late Jurassic";
		} else if (year <= 145.0 && year > 139.8) {
			return "Berriasian period of the Early Cretaceous";
		} else if (year <= 139.8 && year > 132.9) {
			return "Valanginian period of the Early Cretaceous";
		} else if (year <= 132.9 && year > 129.4) {
			return "Hauterivian period of the Early Cretaceous";
		} else if (year <= 129.4 && year > 125.0) {
			return "Barremian period of the Early Cretaceous";
		} else if (year <= 125.0 && year > 113.0) {
			return "Aptian period of the Early Cretaceous";
		} else if (year <= 113.0 && year > 100.5) {
			return "Albian period of the Early Cretaceous";
		} else if (year <= 100.5 && year > 93.9) {
			return "Cenomanian period of the Late Cretaceous";
		} else if (year <= 93.9 && year > 89.8) {
			return "Turonian period of the Late Cretaceous";
		} else if (year <= 89.8 && year > 86.3) {
			return "Coniacian period of the Late Cretaceous";
		} else if (year <= 86.3 && year > 83.3) {
			return "Santonian period of the Late Cretaceous";
		} else if (year <= 83.3 && year > 72.1) {
			return "Campanian period of the Late Cretaceous";
		} else if (year <= 72.1 && year >= 65.0) {
			return "Maastrichtian period of the Late Cretaceous";
		} else {
			return "Not Defined";
		}
	}

	/** Returns the itemstack that created the fossil based in its id. */
	public static ItemStack getItemStackFromFossil(int id) {
		ItemStack fossil;
		if (id == FossilInformation.ANKYLOSAURUS.getFossilID()) {
			fossil = new ItemStack(FHItems.itemDEXFossilAnkylosaurus, 1);
			return fossil;
		} else if (id == FossilInformation.CORONICERASROTIFORME.getFossilID()) {
			fossil = new ItemStack(FHItems.itemDEXFossilCoronicerasRotiforme, 1);
			return fossil;
		} else if (id == FossilInformation.COMPSOGNATHUS.getFossilID()) {
			fossil = new ItemStack(FHItems.itemDEXFossilCompsognathus, 1);
			return fossil;
		} else if (id == FossilInformation.PLESIOSAURUS.getFossilID()) {
			fossil = new ItemStack(FHItems.itemDEXFossilPlesiosaurus, 1);
			return fossil;
		} else if (id == FossilInformation.STEGOSAURUS.getFossilID()) {
			fossil = new ItemStack(FHItems.itemDEXFossilStegosaurus, 1);
			return fossil;
		} else if (id == FossilInformation.TYRANNOSAURUSREX.getFossilID()) {
			fossil = new ItemStack(FHItems.itemDEXFossilTyrannosaurusRex, 1);
			return fossil;
		} else if (id == FossilInformation.VELOCIRAPTOR.getFossilID()) {
			fossil = new ItemStack(FHItems.itemDEXFossilVelociraptor, 1);
			return fossil;
		} else {
			return fossil = new ItemStack(Blocks.stone, 1);
		}
	}

	/** Returns the right EnumChatFormatting color depending on the diet */
	public static EnumChatFormatting getChatColor(String string) {
		if (string == "Carnivorous") {
			return EnumChatFormatting.RED;
		} else if (string == "Herbivorous") {
			return EnumChatFormatting.GREEN;
		} else if (string == "Piscivorous") {
			return EnumChatFormatting.BLUE;
		} else {
			return EnumChatFormatting.GRAY;
		}
	}

	/** Returns the name of the fossil */
	public String getFossilName() {
		return fossilName;
	}

	/** Returns the id of the fossil */
	public int getFossilID() {
		return fossilID;
	}

	/** Returns the diet of the dinosaur */
	public String getDiet() {
		return diet;
	}

	/** Returns the family of the dinosaur */
	public String getFamily() {
		return family;
	}

	/** Returns the icon URL. */
	public String getIconName() {
		return iconName;
	}

	/** Returns the initial year of existence. */
	public int getBeginOfExistence() {
		return beginOfExistence;
	}

	/** Returns the final year of existence. */
	public int getEndOfExistence() {
		return endOfExistence;
	}

	/** Returns the length of the dinosaur. */
	public double getLength() {
		return length;
	}

	/** Returns the length of the dinosaur. */
	public double getHeight() {
		return height;
	}

	/** Returns the length of the dinosaur. */
	public double getWeight() {
		return weight;
	}

	/** Returns the x bound of the fossil. */
	public int getXBound() {
		return boundX;
	}

	/** Returns the z bound of the fossil. */
	public int getZBound() {
		return boundZ;
	}

	/** Returns the type of creature. Dinosaur, mammal, reptile. */
	public String getTypeOfCreature() {
		return typeOfCreature;
	}

	private final String fossilName;
	private final String diet;
	private final String iconName;
	private final String family;
	private final byte fossilID;
	private final double weight;
	private final double height;
	private final double length;
	private final short beginOfExistence;
	private final short endOfExistence;
	private final byte boundX;
	private final byte boundZ;
	private final String typeOfCreature;
}