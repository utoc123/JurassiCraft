package com.rafamv.fossilhunting.enums;

public enum DinosaurInformation {

	COMPSOGNATHUS("Compsognathus longipes",		(byte) 0,	20.0D,	0.40D, 	5.0D,	1.0F,	0.55F);

	private DinosaurInformation(String name, byte id, double dinoHeath, double dinoSpeed, double dinoWeight, float dinoLength, float dinoHeight) {
		this.species = name;
		this.dinosaurID = (int) id;
		this.health = dinoHeath;
		this.speed = dinoSpeed;
		this.weight = dinoWeight;
		this.length = dinoLength;
		this.height = dinoHeight;
	}

	/** Returns the species of the dinosaur */
	public String getSpecies() {
		return species;
	}
	
	/** Returns the id of the dinosaur */
	public double getDinosaurID() {
		return dinosaurID;
	}

	/** Returns the health of the dinosaur */
	public double getHealth() {
		return health;
	}

	/** Returns the speed of the dinosaur */
	public double getSpeed() {
		return speed;
	}

	/** Returns the weight of the dinosaur */
	public double getWeight() {
		return weight;
	}

	/** Returns the length of the dinosaur */
	public float getLength() {
		return length;
	}

	/** Returns the height of the dinosaur */
	public float getHeight() {
		return height;
	}
	
	private final String species;
	private final double dinosaurID;
	private final double health;
	private final double speed;
	private final double weight;
	private final float length;
	private final float height;
}