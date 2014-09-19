package com.rafamv.fossilhunting.handler;

import com.rafamv.fossilhunting.enums.FossilInformation;

public class FHFossilIDHandler {
	
	public static final int blocksForOneID = 5; //Consecutive blocks necessary to generate all fossil id's (usually 5~8 time number of fossils);
	
	public FHFossilIDHandler() {
		
	}
	
	/** Get the id based on a certain location */
	public static int getID(int x, int y, int z) {
		int randomID = (int) Math.round((Math.abs(FossilInformation.values().length*((Math.sin(x/((FossilInformation.values().length*blocksForOneID)/(Math.PI))))+(Math.sin(y/((FossilInformation.values().length*blocksForOneID)/(Math.PI))))+(Math.sin(z/((FossilInformation.values().length*blocksForOneID)/(Math.PI)))))/3)));		
		return randomID;
	}
}
