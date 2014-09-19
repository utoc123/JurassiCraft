package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEmbryoBasilosaurus extends ModelBase {

	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer tail;
	ModelRenderer head;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer flippers1;
	ModelRenderer flippers;

	public ModelEmbryoBasilosaurus() {
		textureWidth = 32;
		textureHeight = 64;

		body1 = new ModelRenderer(this, 0, 12);
		body1.addBox(-2F, -5F, 0.1F, 4, 4, 4);
		body1.setRotationPoint(0F, 13.8F, 1F);
		body1.setTextureSize(32, 32);
		body1.mirror = true;
		setRotation(body1, 0.8179294F, 0F, 0F);
		body2 = new ModelRenderer(this, 0, 22);
		body2.addBox(-2F, -4.5F, 0F, 4, 4, 4);
		body2.setRotationPoint(0F, 16F, 2F);
		body2.setTextureSize(32, 32);
		body2.mirror = true;
		setRotation(body2, 0.5793667F, 0F, 0F);
		tail = new ModelRenderer(this, 3, 31);
		tail.addBox(-1F, 0F, -1.5F, 2, 6, 2);
		tail.setRotationPoint(0F, 14F, 3.5F);
		tail.setTextureSize(32, 32);
		tail.mirror = true;
		setRotation(tail, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.011111F, -4F, -5F, 4, 4, 6);
		head.setRotationPoint(0F, 11F, -0.5F);
		head.setTextureSize(32, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		leg1 = new ModelRenderer(this, 3, 33);
		leg1.addBox(-1F, 0F, -1F, 2, 4, 2);
		leg1.setRotationPoint(0F, 19.5F, 3F);
		leg1.setTextureSize(32, 32);
		leg1.mirror = true;
		setRotation(leg1, -0.3490659F, 0F, 0F);
		leg2 = new ModelRenderer(this, 20, 0);
		leg2.addBox(-2F, 0F, -1F, 4, 4, 2);
		leg2.setRotationPoint(0F, 13.5F, 4F);
		leg2.setTextureSize(32, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		flippers1 = new ModelRenderer(this, 3, 0);
		flippers1.addBox(-1F, -2.5F, -1F, 2, 4, 2);
		flippers1.setRotationPoint(0F, 12F, 0.5F);
		flippers1.setTextureSize(32, 32);
		flippers1.mirror = true;
		setRotation(flippers1, 0.3490659F, 0F, 1.570796F);
		flippers = new ModelRenderer(this, 3, 0);
		flippers.addBox(-1F, -1.5F, -1F, 2, 4, 2);
		flippers.setRotationPoint(0F, 12F, 0.5F);
		flippers.setTextureSize(32, 32);
		flippers.mirror = true;
		setRotation(flippers, -0.3490659F, 0F, 1.570796F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body1.render(f5);
		body2.render(f5);
		tail.render(f5);
		head.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		flippers1.render(f5);
		flippers.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
