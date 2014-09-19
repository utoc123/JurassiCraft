package com.rafamv.fossilhunting.client.renderer.tileentity.fossils;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.rafamv.fossilhunting.FossilHunting;
import com.rafamv.fossilhunting.client.renderer.model.fossils.ModelFossilCoronicerasRotiforme;
import com.rafamv.fossilhunting.tileentity.fossils.TileEntityFossilCoronicerasRotiforme;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderFossilCoronicerasRotiforme extends TileEntitySpecialRenderer {

	private static final ResourceLocation textureFossil = new ResourceLocation(FossilHunting.MODID + ":" + "textures/models/CoronicerasRotiforme.png");

	private ModelFossilCoronicerasRotiforme modelFossil = new ModelFossilCoronicerasRotiforme();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		if (tileEntity instanceof TileEntityFossilCoronicerasRotiforme) {
			TileEntityFossilCoronicerasRotiforme tileFossil = (TileEntityFossilCoronicerasRotiforme) tileEntity;
			ForgeDirection direction = null;
			short angle = 0;
			float translationX = 0.0F;
			float translationZ = 0.0F;
			if (tileFossil.getWorldObj() != null) {
				direction = tileFossil.getForgeDirection();
				if (direction != null) {
					if (direction == ForgeDirection.NORTH) {
						translationX = (float) (x - 0.5F);
						translationZ = (float) (z + 0.5F);
						angle = 0;
					} else if (direction == ForgeDirection.SOUTH) {
						translationX = (float) (x + 0.5F);
						translationZ = (float) (z + 0.5F);
						angle = 180;
					} else if (direction == ForgeDirection.WEST) {
						translationX = (float) (x + 0.5F);
						translationZ = (float) (z + 0.5F);
						angle = 90;
					} else if (direction == ForgeDirection.EAST) {
						translationX = (float) (x + 0.5F);
						translationZ = (float) (z - 0.5F);
						angle = -90;
					}
				}
			}
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) translationX, (float) y, (float) translationZ);
			GL11.glRotatef((float) angle, 0.0F, 1.0F, 0.0F);
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(textureFossil);
			this.bindTexture(textureFossil);
			modelFossil.render();
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}

}