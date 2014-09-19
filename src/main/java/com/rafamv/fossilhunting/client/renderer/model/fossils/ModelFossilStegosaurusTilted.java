package com.rafamv.fossilhunting.client.renderer.model.fossils;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.rafamv.fossilhunting.FossilHunting;

public class ModelFossilStegosaurusTilted {
    private IModelCustom modelFossil;
	private ResourceLocation modelLocation = new ResourceLocation(FossilHunting.MODID + ":" + "models/fossils/StegosaurusFossilTilted.obj");

    public ModelFossilStegosaurusTilted() {
    	modelFossil = AdvancedModelLoader.loadModel(modelLocation);
    }

    public void render() {
    	modelFossil.renderAll();
    }

    public void renderPart(String partName) {
    	modelFossil.renderPart(partName);
    }
}
