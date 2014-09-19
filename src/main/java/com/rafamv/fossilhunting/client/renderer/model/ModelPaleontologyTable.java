package com.rafamv.fossilhunting.client.renderer.model;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.rafamv.fossilhunting.FossilHunting;

public class ModelPaleontologyTable {
    private IModelCustom modelCLeaningTable;
	private ResourceLocation modelLocation = new ResourceLocation(FossilHunting.MODID + ":" + "models/CleaningTable.obj");

    public ModelPaleontologyTable() {
    	modelCLeaningTable = AdvancedModelLoader.loadModel(modelLocation);
    }

    public void render() {
    	modelCLeaningTable.renderAll();
    }

    public void renderPart(String partName) {
    	modelCLeaningTable.renderPart(partName);
    }
}
