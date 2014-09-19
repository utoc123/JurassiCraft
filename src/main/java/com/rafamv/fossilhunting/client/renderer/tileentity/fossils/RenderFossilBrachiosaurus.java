package com.rafamv.fossilhunting.client.renderer.tileentity.fossils;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.client.renderer.model.fossils.ModelFossilCoronicerasRotiforme;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCoronicerasRotiforme;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderFossilBrachiosaurus extends TileEntitySpecialRenderer {

	private static final ResourceLocation textureFossil = new ResourceLocation(FossilHunting.MODID + ":" + "textures/models/CoronicerasRotiforme.png");

	private ModelFossilCoronicerasRotiforme modelFossil = new ModelFossilCoronicerasRotiforme();
	
	//HERE

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		if (tileEntity instanceof TileEntityFossilCoronicerasRotiforme) {
			TileEntityFossilCoronicerasRotiforme tileFossil = (TileEntityFossilCoronicerasRotiforme) tileEntity;
			int id = tileFossil.getFossilID();

			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x, (float) y, (float) z);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(textureFossil);
			modelFossil.render();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}

	}
}