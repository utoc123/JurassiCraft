package com.rafamv.fossilhunting.client.renderer.model.fossils;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.rafamv.fossilhunting.FossilHunting;

public class ModelFossilCompsognathus {
    private IModelCustom modelFossilCompsognathus;
	private ResourceLocation modelLocation = new ResourceLocation(FossilHunting.MODID + ":" + "models/fossils/CompsognathusFossil.obj");

    public ModelFossilCompsognathus() {
    	modelFossilCompsognathus = AdvancedModelLoader.loadModel(modelLocation);
    }

    public void render() {
    	modelFossilCompsognathus.renderAll();
    }

    public void renderPart(String partName) {
    	modelFossilCompsognathus.renderPart(partName);
    }
}
