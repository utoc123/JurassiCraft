package com.rafamv.fossilhunting.client.renderer.model.fossils;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.rafamv.fossilhunting.FossilHunting;

public class ModelFossilCoronicerasRotiforme {
	private IModelCustom modelCoronicerasRotiforme;

	private ResourceLocation modelLocation = new ResourceLocation(FossilHunting.MODID + ":" + "models/fossils/CoronicerasRotiformeFossil.obj");
	
	public ModelFossilCoronicerasRotiforme() {
		modelCoronicerasRotiforme = AdvancedModelLoader.loadModel(modelLocation);
	}

	public void render() {
		modelCoronicerasRotiforme.renderAll();
	}

	public void renderPart(String partName) {
		modelCoronicerasRotiforme.renderPart(partName);
	}
}
