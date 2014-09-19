package com.rafamv.bygoneage.client.renderer.tileentity;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelHatcheryBase;
import com.rafamv.bygoneage.client.renderer.model.ModelHatcheryGlass;
import com.rafamv.bygoneage.enums.BygoneAgeBlockInformation;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsEmbryoModelList;
import com.rafamv.bygoneage.tileentity.TileEntityHatchery;

public class RenderTileEntityHatchery extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeBlockInformation.HATCHERY.getModelTexture());
	private ModelHatcheryBase modelBase;
	private ModelHatcheryGlass modelGlass;
	private ModelBase modelEmbryo;
	private ResourceLocation textureEmbryo;
	private float translation;
	private HashMap<Integer, ModelBase> modelMap;
	private FontRenderer fontRenderer;

	public RenderTileEntityHatchery() {
		this.modelBase = new ModelHatcheryBase();
		this.modelGlass = new ModelHatcheryGlass();
		this.translation = 0.001F;
		this.fontRenderer = (Minecraft.getMinecraft()).fontRenderer;
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		if (tileEntity instanceof TileEntityHatchery) {
			TileEntityHatchery tileEntityHatchery = (TileEntityHatchery) tileEntity;
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			this.modelBase.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			if (tileEntityHatchery.getWorldObj() != null) {
				if (tileEntityHatchery.getEmbryoID() >= 0) {
					float creatureSize = (float) (0.2 + 0.3 * tileEntityHatchery.getCreatureSize());
					translation = translation + 0.0025F;
					double movementX = 0.12 * Math.sin(translation);
					double movementY = 0.22 * Math.sin(translation + 1);
					double movementZ = 0.12 * Math.sin(translation + 2);
					GL11.glTranslated(movementX, (movementY - 0.3F), movementZ);
					GL11.glScalef(creatureSize, creatureSize, creatureSize);
					GL11.glRotated(10 * translation, 0.0D, 1.0D, 0.0D);
					modelEmbryo = BygoneAgeGeneticsEmbryoModelList.EMBRYOMODELS.get(tileEntityHatchery.getEmbryoID()).get(tileEntityHatchery.getEmbryoStage());
					textureEmbryo = BygoneAgeGeneticsEmbryoModelList.EMBRYOTEXTURES.get(tileEntityHatchery.getEmbryoID()).get(tileEntityHatchery.getEmbryoStage());
					Minecraft.getMinecraft().renderEngine.bindTexture(textureEmbryo);
					this.modelEmbryo.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
					creatureSize = 1 / creatureSize;
					GL11.glRotated(-10 * translation, 0.0D, 1.0D, 0.0D);
					GL11.glScalef(creatureSize, creatureSize, creatureSize);
					GL11.glTranslated(-movementX, -(movementY - 0.3F), -movementZ);
				}
			}
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.55F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			this.modelGlass.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
	}

}