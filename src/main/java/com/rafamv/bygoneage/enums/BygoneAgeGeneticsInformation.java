package com.rafamv.bygoneage.enums;

import java.util.HashMap;
import java.util.Map;

public enum BygoneAgeGeneticsInformation {

	CHICKEN((byte) 0, "Chicken", "Chicken", 2.50F, (byte) 5, 500, 420, 420, 180),
	SHEEP((byte) 1, "Sheep", "Sheep", 4.00F, (byte) 6, 750, 500, 550, 350),
	PIG((byte) 2, "Pig", "Pig", 5.00F, (byte) 8, 800, 500, 500, 1200),
	COW((byte) 3, "Cow", "Cow", 0.50F, (byte) 12, 1000, 600, 650, 850),
	LEPTICTIDIUM((byte) 4, "Leptictidium auderiense", "Pig", 2.50F, (byte) 10, 600, 500, 550, 200),
	MOERITHERIUM((byte) 5, "Moeritherium andrewsi", "Pig", 6.00F, (byte) 24, 850, 600, 650, 1400),
	UINTATHERIUM((byte) 6, "Uintatherium anceps", "Cow", 8.00F, (byte) 32, 1500, 1200, 800, 500),
	ARSINOITHERIUM((byte) 7, "Arsinoitherium zitteli", "Cow", 8.00F, (byte) 32, 1600, 1300, 600, 550),
	TITANISWALLERI((byte) 8, "Titanis walleri", "Chicken", 6.00F, (byte) 24, 700, 1500, 850, 500),
	BASILOSAURUS((byte) 9, "Basilosaurus cetoides", "Cow", 12.00F, (byte) 48, 1000, 1000, 1000, 2000),
	MAMMOTH((byte) 10, "Mammuthus primigenius", "Cow", 13.00F, (byte) 52, 1250, 800, 800, 2250),
	DEINOTHERIUM((byte) 11, "Deinotherium giganteum", "Cow", 13.00F, (byte) 52, 1500, 900, 750, 2000);

	private BygoneAgeGeneticsInformation(byte id, String creatureName, String motherName, float growthInMin, byte nStages, int proximate, int minerals, int vitamins, int lipids) {
		this.creatureDNAName = creatureName;
		this.creatureID = id;
		this.motherDNAName = motherName;
		this.hatchSpeed = (short) (growthInMin * 1200);
		this.numberOfStages = nStages;
		this.minProximate = proximate;
		this.minMinerals = minerals;
		this.minVitamins = vitamins;
		this.minLipids = lipids;
	}

	/** Returns the name of the mother for this creature. */
	public String getMotherName() {
		return motherDNAName;
	}

	/** Returns the id of the creature. */
	public byte getCreatureID() {
		return creatureID;
	}

	/** Returns the name of the creature. */
	public String getCreatureName() {
		return creatureDNAName;
	}

	/** Returns the hatch speed of the creature. */
	public short getHatchSpeed() {
		return hatchSpeed;
	}

	/** Returns the number of stages that an embryo will grow/re-render. */
	public byte getNumberOfStages() {
		return numberOfStages;
	}

	/** Returns the minimum amount of proximate for certain creature. */
	public int getMinimumProximate() {
		return minProximate;
	}

	/** Returns the minimum amount of minerals for certain creature. */
	public int getMinimumMinerals() {
		return minMinerals;
	}

	/** Returns the minimum amount of vitamins for certain creature. */
	public int getMinimumvitamins() {
		return minVitamins;
	}

	/** Returns the minimum amount of lipids for certain creature. */
	public int getMinimumLipids() {
		return minLipids;
	}

	private final String creatureDNAName;
	private final String motherDNAName;
	private final byte creatureID;
	private final short hatchSpeed;
	private final byte numberOfStages;
	private final int minProximate;
	private final int minMinerals;
	private final int minVitamins;
	private final int minLipids;

	public static final Map<Byte, String> CREATURELIST = new HashMap<Byte, String>();
	static {
		for (byte i = 4; i < values().length; i++) {
			CREATURELIST.put(BygoneAgeGeneticsInformation.values()[i].getCreatureID(), BygoneAgeGeneticsInformation.values()[i].getCreatureName());
		}
	}
	
	public static final Map<String, Byte> CREATUREDNALIST = new HashMap<String, Byte>();
	static {
		for (byte i = 0; i < values().length; i++) {
			CREATUREDNALIST.put(BygoneAgeGeneticsInformation.values()[i].getCreatureName(), BygoneAgeGeneticsInformation.values()[i].getCreatureID());
		}
	}

	public static final Map<String, String> MOTHERDNALIST = new HashMap<String, String>();
	static {
		for (byte i = 0; i < values().length; i++) {
			MOTHERDNALIST.put(BygoneAgeGeneticsInformation.values()[i].getCreatureName(), BygoneAgeGeneticsInformation.values()[i].getMotherName());
		}
	}
}