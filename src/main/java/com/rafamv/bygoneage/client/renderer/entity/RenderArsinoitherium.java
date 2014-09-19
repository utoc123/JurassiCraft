package com.rafamv.bygoneage.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelArsinoitherium;
import com.rafamv.bygoneage.entity.creatures.EntityArsinoitherium;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class RenderArsinoitherium extends RenderLiving {

	protected ModelArsinoitherium model;
	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeMobsInformation.ARSINOITHERIUM.getTexture() + ".png");
	private static final ResourceLocation textureOverlayer = new ResourceLocation(BygoneAgeMobsInformation.ARSINOITHERIUM.getTexture() + "Overlayer.png");

	public RenderArsinoitherium(ModelBase model, float shadow) {
		super(model, shadow);
		this.model = ((ModelArsinoitherium) mainModel);
		this.setRenderPassModel(mainModel);
	}

	public void renderModel(EntityArsinoitherium entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderModel((EntityArsinoitherium) entityLiving, x, y, z, u, v);
	}

	protected void preRenderScale(EntityArsinoitherium entityModel, float f) {
		float scale = (float) entityModel.getCreatureScale();
		this.shadowSize = 0.85F * scale;
		GL11.glScalef(scale, scale, scale);
	}

	protected int shouldRenderPass(EntityArsinoitherium entityCreature, int par2, float par3) {
		if (par2 == 0) {
			this.bindTexture(textureOverlayer);
			float color = entityCreature.getCreatureColor();
			if (color <= 0.47F) {
				GL11.glColor3f(0.3F + 0.7F * color, 0.3F + 0.7F * color, 0.3F + 0.7F * color);
			} else if (color <= 1.0F) {
				GL11.glColor3f(color / 2.5F, color / 2.5F, color / 2.5F);
			}
			return 1;
		} else {
			return -1;
		}
	}

	protected ResourceLocation getEntityTexture(EntityArsinoitherium entityCreature) {
		return this.texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderModel((EntityArsinoitherium) entity, x, y, z, u, v);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
		this.preRenderScale((EntityArsinoitherium) entityLivingBase, f);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityArsinoitherium) entityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityArsinoitherium) entity);
	}
}
