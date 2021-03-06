package com.rafamv.bygoneage.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.rafamv.bygoneage.client.renderer.model.ModelMammoth;
import com.rafamv.bygoneage.entity.creatures.EntityMammoth;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

public class RenderMammoth extends RenderLiving {

	protected ModelMammoth model;
	private static final ResourceLocation texture = new ResourceLocation(BygoneAgeMobsInformation.MAMMOTH.getTexture() + ".png");
	private static final ResourceLocation textureOverlayer = new ResourceLocation(BygoneAgeMobsInformation.MAMMOTH.getTexture() + "Overlayer.png");

	public RenderMammoth(ModelBase model, float shadow) {
		super(model, shadow);
		this.model = ((ModelMammoth) mainModel);
		this.setRenderPassModel(mainModel);
	}

	public void renderModel(EntityMammoth entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}

	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderModel((EntityMammoth) entityLiving, x, y, z, u, v);
	}

	protected void preRenderScale(EntityMammoth entityModel, float f) {
		float scale = (float) entityModel.getCreatureScale();
		this.shadowSize = 2.0F * scale;
		GL11.glScalef(scale, scale, scale);
	}

	protected int shouldRenderPass(EntityMammoth entityCreature, int par2, float par3) {
		if (par2 == 0) {
			this.bindTexture(textureOverlayer);
			float color = entityCreature.getCreatureColor();
			if (color <= 0.35F) {
				GL11.glColor3f(color, 0.1F, 0.1F);
			} else if (color <= 0.5F) {
				GL11.glColor3f(0.4F + 0.6F * color, 0.3F + 0.6F * color, 0.3F + 0.6F * color);
			} else if (color <= 1.0F) {
				GL11.glColor3f(0.2F, 0.2F, 0.2F);
			}
			return 1;
		} else {
			return -1;
		}
	}

	protected ResourceLocation getEntityTexture(EntityMammoth entityCreature) {
		return this.texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderModel((EntityMammoth) entity, x, y, z, u, v);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
		this.preRenderScale((EntityMammoth) entityLivingBase, f);
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase entityLivingBase, int par2, float par3) {
		return this.shouldRenderPass((EntityMammoth) entityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityMammoth) entity);
	}
}
