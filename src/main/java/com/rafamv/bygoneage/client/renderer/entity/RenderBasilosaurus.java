package com.rafamv.bygoneage.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelBasilosaurus;
import com.rafamv.bygoneage.entity.creatures.EntityBasilosaurus;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class RenderBasilosaurus extends RenderLiving {

	protected ModelBasilosaurus model;
	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeMobsInformation.BASILOSAURUS.getTexture() + ".png");
	private static final ResourceLocation textureOverlayer = new ResourceLocation(BygoneAgeMobsInformation.BASILOSAURUS.getTexture() + "Overlayer.png");

	public RenderBasilosaurus(ModelBase model, float shadow) {
		super(model, shadow);
		this.model = ((ModelBasilosaurus) mainModel);
		this.setRenderPassModel(mainModel);
	}

	public void renderModel(EntityBasilosaurus entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderModel((EntityBasilosaurus) entityLiving, x, y, z, u, v);
	}

	protected void preRenderScale(EntityBasilosaurus entityModel, float f) {
		float scale = (float) entityModel.getCreatureScale();
		this.shadowSize = 1.0F * scale;
		GL11.glScalef(scale, scale, scale);
	}

	protected int shouldRenderPass(EntityBasilosaurus entityCreature, int par2, float par3) {
		if (par2 == 0) {
			this.bindTexture(textureOverlayer);
			float color = entityCreature.getCreatureColor();
			if (color <= 0.42F) {
				GL11.glColor3f(0.2F + 0.3F * color, 0.3F + 0.3F * color, 0.8F + 0.2F * color);
			}else if (color <= 0.50F) {
				GL11.glColor3f(0.5F + 0.5F * color, 0.5F + 0.5F * color, 0.5F + 0.5F * color);
			} else if (color <= 1.0F) {
				GL11.glColor3f(0.3F*color, 0.3F*color, 0.3F*color);
			}
			return 1;
		} else {
			return -1;
		}
	}

	protected ResourceLocation getEntityTexture(EntityBasilosaurus entityCreature) {
		return this.texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderModel((EntityBasilosaurus) entity, x, y, z, u, v);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
		this.preRenderScale((EntityBasilosaurus) entityLivingBase, f);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityBasilosaurus) entityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityBasilosaurus) entity);
	}
}
