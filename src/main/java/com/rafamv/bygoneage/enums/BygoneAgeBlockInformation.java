package com.rafamv.bygoneage.enums;

import com.rafamv.bygoneage.BygoneAge;

public enum BygoneAgeBlockInformation {

	HATCHERY("Hatchery", BygoneAge.MODID + ":HatcheryParticles", BygoneAge.MODID + ":" + "textures/models/Hatchery.png"),
	HATCHERYGHOSTBLOCK("HatcheryGhostBlock", BygoneAge.MODID + ":HatcheryParticles", ""),
	CENTRIFUGE("Centrifuge", BygoneAge.MODID + ":CentrifugeParticles", BygoneAge.MODID + ":" + "textures/models/Centrifuge.png"),
	DNAEXTRACTOR("DNAExtractor", BygoneAge.MODID + ":DNAExtractorParticles", BygoneAge.MODID + ":" + "textures/models/DNAExtractor.png"),
	FOSSILBLOCK("FossilBlock", BygoneAge.MODID + ":FossilBlock", "");

	private BygoneAgeBlockInformation(String blockUnlocalizedName, String blockParticleTexture, String blockModelTexture) {
		this.unlocalizedName = blockUnlocalizedName;
		this.particleTexture = blockParticleTexture;
		this.modelTexture = blockModelTexture;
	}

	/** Returns the block unlocalized name */
	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	/** Returns the block particles path */
	public String getParticleTexture() {
		return particleTexture;
	}

	/** Returns the block model path */
	public String getModelTexture() {
		return modelTexture;
	}

	private final String unlocalizedName;
	private final String particleTexture;
	private final String modelTexture;
}