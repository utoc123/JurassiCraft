package com.rafamv.fossilhunting.tileentity.fossils;

import com.rafamv.fossilhunting.enums.FossilInformation;

public class TileEntityFossilTriceratops extends TileEntityFossil {

	public TileEntityFossilTriceratops() {
		this.fossilID = -1;
		this.yearOfExistence = -1.0;
		this.sign = false;
	}
	
	public void setFossilInformation(int id) {
		this.fossilID = id;
		this.yearOfExistence = getRandomBetween(FossilInformation.VELOCIRAPTOR.getEndOfExistence(), FossilInformation.VELOCIRAPTOR.getBeginOfExistence());
		this.sign = false;
		this.tilted = false;
		this.weight = getRandomBetween(FossilInformation.VELOCIRAPTOR.getWeight() * 0.8, FossilInformation.VELOCIRAPTOR.getWeight());
		this.height = getRandomBetween(FossilInformation.VELOCIRAPTOR.getHeight() * 0.8, FossilInformation.VELOCIRAPTOR.getHeight());
		this.length = getRandomBetween(FossilInformation.VELOCIRAPTOR.getLength() * 0.8, FossilInformation.VELOCIRAPTOR.getLength());
	}
}
