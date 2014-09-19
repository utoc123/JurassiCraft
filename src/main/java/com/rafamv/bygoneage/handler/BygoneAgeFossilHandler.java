package com.rafamv.bygoneage.handler;

import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class BygoneAgeFossilHandler {

	/** Consecutive blocks necessary to generate all possible creatures (usually
	 * 5~8 which is multiplied by the number of creatures). */
	public static final int blocksForOneID = 5;

	/** Gets the id of the creature based on a certain location. */
	public static int getCreatureIDFromFossil(int x, int y, int z) {
		int randomID = (int) Math.round((Math.abs(BygoneAgeMobsInformation.values().length * ((Math.sin(x / ((BygoneAgeMobsInformation.values().length * blocksForOneID) / (Math.PI)))) + (Math.sin(y / ((BygoneAgeMobsInformation.values().length * blocksForOneID) / (Math.PI)))) + (Math.sin(z / ((BygoneAgeMobsInformation.values().length * blocksForOneID) / (Math.PI))))) / 3)));
		return randomID;
	}
	
}
