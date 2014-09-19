package com.rafamv.fossilhunting.tileentity.fossils;

import com.rafamv.fossilhunting.enums.FossilInformation;

public class TileEntityFossilAllosaurus extends TileEntityFossil {

	public TileEntityFossilAllosaurus() {
		this.fossilID = -1;
		this.yearOfExistence = -1.0;
		this.sign = false;
	}
	
	public void setFossilInformation(int id) {
		this.fossilID = id;
		this.yearOfExistence = getRandomBetween(FossilInformation.ANKYLOSAURUS.getEndOfExistence(), FossilInformation.ANKYLOSAURUS.getBeginOfExistence());
		this.sign = false;
		this.tilted = false;
		this.weight = getRandomBetween(FossilInformation.CORONICERASROTIFORME.getWeight() * 0.6, FossilInformation.CORONICERASROTIFORME.getWeight()*0.8);
		this.height = getRandomBetween(FossilInformation.CORONICERASROTIFORME.getHeight() * 0.6, FossilInformation.CORONICERASROTIFORME.getHeight()*0.8);
		this.length = getRandomBetween(FossilInformation.CORONICERASROTIFORME.getLength() * 0.6, FossilInformation.CORONICERASROTIFORME.getLength()*0.8);
	}
}
