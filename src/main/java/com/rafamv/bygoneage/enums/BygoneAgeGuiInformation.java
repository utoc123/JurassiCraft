package com.rafamv.bygoneage.enums;

import com.rafamv.bygoneage.BygoneAge;

public enum BygoneAgeGuiInformation {
	
	DNAEXTRACTOR(43650, BygoneAge.MODID + ":" + "textures/gui/GuiDNAExtractor.png", ""),
	CENTRIFUGEMACHINE(43651, BygoneAge.MODID + ":" + "textures/gui/GuiCentrifuge.png", ""),
	HATCHERY(43652, BygoneAge.MODID + ":" + "textures/gui/GuiHatcheryLeft.png", BygoneAge.MODID + ":" + "textures/gui/GuiHatcheryRight.png"),
	HATCHERYPROCESS(43653, BygoneAge.MODID + ":" + "textures/gui/GuiHatcheryProgress.png", ""),
	ANALYZER(43654, BygoneAge.MODID + ":" + "textures/gui/GuiAnalyzer.png", "");
	
	private BygoneAgeGuiInformation(int guiID, String pathOne, String pathTwo) {
		this.id = guiID;
		this.guiPrimaryPath = pathOne;
		this.guiSecondaryPath = pathTwo;
	}
	
	/** Returns the GUI id */
	public int getGuiId() {
		return id;
	}

	/** Returns the path for the GUI */
	public String getPrimaryGuiPath() {
		return guiPrimaryPath;
	}

	/** Returns the path for the GUI */
	public String getSecondaryGuiPath() {
		return guiSecondaryPath;
	}
	
	private final int id;
	private final String guiPrimaryPath;
	private final String guiSecondaryPath;
	
}
