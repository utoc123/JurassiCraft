package com.rafamv.fossilhunting.client.renderer.model.fossils;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.rafamv.fossilhunting.FossilHunting;

public class ModelFossilPlesiosaurus {
    private IModelCustom modelBase;
	private ResourceLocation modelLocation = new ResourceLocation(FossilHunting.MODID + ":" + "models/fossils/Plesiosaurus.obj");

    public ModelFossilPlesiosaurus() {
    	modelBase = AdvancedModelLoader.loadModel(modelLocation);
    }

    public void render() {
    	modelBase.renderAll();
    }

    public void renderPart(String partName) {
    	modelBase.renderPart(partName);
    }
}
