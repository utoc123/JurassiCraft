package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEmbryoWithArms extends ModelBase {

	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer tail;
	ModelRenderer head;
	ModelRenderer hand1;
	ModelRenderer hand2;

	public ModelEmbryoWithArms() {
		textureWidth = 32;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2F, -4F, -6F, 4, 4, 6);
		head.setRotationPoint(0F, 13.5F, 1F);
		head.setTextureSize(32, 32);
		head.mirror = true;
		setRotation(head, 0.3222146F, 0F, 0F);
		body1 = new ModelRenderer(this, 0, 12);
		body1.addBox(-2F, -2F, 0F, 4, 4, 4);
		body1.setRotationPoint(0F, 12.5F, -2F);
		body1.setTextureSize(32, 32);
		body1.mirror = true;
		setRotation(body1, -0.7853982F, 0F, 0F);
		body2 = new ModelRenderer(this, 0, 22);
		body2.addBox(-2F, 0F, -2F, 4, 6, 4);
		body2.setRotationPoint(0F, 13.8F, 0.2F);
		body2.setTextureSize(32, 32);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 3, 32);
		tail.addBox(-1F, -0.5F, -1F, 2, 6, 2);
		tail.setRotationPoint(0F, 19F, 1F);
		tail.setTextureSize(32, 32);
		tail.mirror = true;
		setRotation(tail, -1.047198F, 0F, 0F);
		hand1 = new ModelRenderer(this, 10, 45);
		hand1.addBox(1.3F, -1.5F, 0.5F, 2, 4, 2);
		hand1.setRotationPoint(0F, 14.5F, -1F);
		hand1.setTextureSize(32, 32);
		hand1.mirror = true;
		setRotation(hand1, -1.134464F, 0.3490659F, 0F);
		hand2 = new ModelRenderer(this, 0, 45);
		hand2.addBox(-3.2F, -1.5F, 0.5F, 2, 4, 2);
		hand2.setRotationPoint(0F, 14.5F, -1F);
		hand2.setTextureSize(32, 32);
		hand2.mirror = true;
		setRotation(hand2, -1.134464F, -0.3490659F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body1.render(f5);
		body2.render(f5);
		tail.render(f5);
		head.render(f5);
		hand1.render(f5);
		hand2.render(f5);
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
