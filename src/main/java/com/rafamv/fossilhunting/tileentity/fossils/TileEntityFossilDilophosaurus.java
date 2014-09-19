package com.rafamv.fossilhunting.tileentity.fossils;

import com.rafamv.fossilhunting.enums.FossilInformation;

public class TileEntityFossilDilophosaurus extends TileEntityFossil {

	public TileEntityFossilDilophosaurus() {
		this.fossilID = -1;
		this.yearOfExistence = -1.0;
		this.sign = false;
	}
	
	public void setFossilInformation(int id) {
		this.fossilID = id;
		this.yearOfExistence = getRandomBetween(FossilInformation.VELOCIRAPTOR.getEndOfExistence(), FossilInformation.VELOCIRAPTOR.getBeginOfExistence());
		this.sign = false;
		this.tilted = false;
		this.weight = getRandomBetween(FossilInformation.STEGOSAURUS.getWeight() * 0.8, FossilInformation.STEGOSAURUS.getWeight());
		this.height = getRandomBetween(FossilInformation.STEGOSAURUS.getHeight() * 0.8, FossilInformation.STEGOSAURUS.getHeight());
		this.length = getRandomBetween(FossilInformation.STEGOSAURUS.getLength() * 0.8, FossilInformation.STEGOSAURUS.getLength());
	}
}
