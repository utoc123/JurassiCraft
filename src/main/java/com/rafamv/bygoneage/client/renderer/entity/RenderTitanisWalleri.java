package com.rafamv.bygoneage.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelTitanisWalleri;
import com.rafamv.bygoneage.entity.creatures.EntityTitanisWalleri;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class RenderTitanisWalleri extends RenderLiving {

	protected ModelTitanisWalleri model;
	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeMobsInformation.TITANISWALLERI.getTexture() + ".png");
	private static final ResourceLocation textureOverlayer = new ResourceLocation(BygoneAgeMobsInformation.TITANISWALLERI.getTexture() + "Overlayer.png");

	public RenderTitanisWalleri(ModelBase model, float shadow) {
		super(model, shadow);
		this.model = ((ModelTitanisWalleri) mainModel);
		this.setRenderPassModel(mainModel);
	}

	public void renderModel(EntityTitanisWalleri entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderModel((EntityTitanisWalleri) entityLiving, x, y, z, u, v);
	}

	protected void preRenderScale(EntityTitanisWalleri entityModel, float f) {
		float scale = (float) entityModel.getCreatureScale();
		this.shadowSize = 0.5F * scale;
		GL11.glScalef(scale, scale, scale);
	}

	protected int shouldRenderPass(EntityTitanisWalleri entityCreature, int par2, float par3) {
		if (par2 == 0) {
			this.bindTexture(textureOverlayer);
			float color = entityCreature.getCreatureColor();
			if (color <= 0.38F) {
				GL11.glColor3f(color, 0.1F, 0.1F);
			} else if (color <= 0.43F) {
				GL11.glColor3f(0.2F + 0.3F * color, 0.3F + 0.3F * color, 0.8F + 0.2F * color);
			} else if (color <= 0.48F) {
				GL11.glColor3f(0.5F + 0.5F * color, color, 0.5F + 0.5F * color);
			} else if (color <= 0.50F) {
				GL11.glColor3f(0.2F, 0.2F, 0.2F);
			} else if (color <= 1.0F) {
				GL11.glColor3f(0.5F + 0.5F * color, 0.5F + 0.5F * color, 0.5F + 0.5F * color);
			}
			return 1;
		} else {
			return -1;
		}
	}

	protected ResourceLocation getEntityTexture(EntityTitanisWalleri entityCreature) {
		return this.texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderModel((EntityTitanisWalleri) entity, x, y, z, u, v);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
		this.preRenderScale((EntityTitanisWalleri) entityLivingBase, f);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityTitanisWalleri) entityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityTitanisWalleri) entity);
	}
}
