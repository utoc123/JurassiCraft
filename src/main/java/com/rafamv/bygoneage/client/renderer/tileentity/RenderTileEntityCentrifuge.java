package com.rafamv.bygoneage.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.client.renderer.model.ModelCentrifuge;
import com.rafamv.bygoneage.enums.BygoneAgeBlockInformation;
import com.rafamv.bygoneage.tileentity.TileEntityCentrifuge;

public class RenderTileEntityCentrifuge extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeBlockInformation.CENTRIFUGE.getModelTexture());
	private ModelCentrifuge model;

	public RenderTileEntityCentrifuge() {
		this.model = new ModelCentrifuge();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		if (tileEntity instanceof TileEntityCentrifuge) {
			TileEntityCentrifuge tileEntityModel = (TileEntityCentrifuge) tileEntity;
			ForgeDirection direction = null;
			short angle = 180;
			if (tileEntityModel.getWorldObj() != null) {
				direction = tileEntityModel.getForgeDirection();
				if (direction != null) {
					if (direction == ForgeDirection.NORTH) {
						angle = 180;
					} else if (direction == ForgeDirection.SOUTH) {
						angle = 0;
					} else if (direction == ForgeDirection.WEST) {
						angle = 90;
					} else if (direction == ForgeDirection.EAST) {
						angle = -90;
					}
				}
			}
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(angle, 0.0F, 1.0F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}
}