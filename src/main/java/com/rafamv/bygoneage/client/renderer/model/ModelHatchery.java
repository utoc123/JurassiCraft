package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHatchery extends ModelBase {
	ModelRenderer Base1;
	ModelRenderer Base2;
	ModelRenderer Base3;
	ModelRenderer Base4;
	ModelRenderer Base5;
	ModelRenderer Base6;
	ModelRenderer Base7;
	ModelRenderer Base8;

	public ModelHatchery() {
		textureWidth = 128;
		textureHeight = 128;

		Base1 = new ModelRenderer(this, 0, 62);
		Base1.addBox(-13F, -6F, -13F, 26, 6, 26);
		Base1.setRotationPoint(0F, 24F, 0F);
		Base1.setTextureSize(128, 128);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 46, 94);
		Base2.addBox(-10F, -6F, 13F, 20, 6, 3);
		Base2.setRotationPoint(0F, 24F, 0F);
		Base2.setTextureSize(128, 128);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 46, 94);
		Base3.addBox(-10F, -6F, -16F, 20, 6, 3);
		Base3.setRotationPoint(0F, 24F, 0F);
		Base3.setTextureSize(128, 128);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		Base4 = new ModelRenderer(this, 0, 94);
		Base4.addBox(13F, -6F, -10F, 3, 6, 20);
		Base4.setRotationPoint(0F, 24F, 0F);
		Base4.setTextureSize(128, 128);
		Base4.mirror = true;
		setRotation(Base4, 0F, 0F, 0F);
		Base5 = new ModelRenderer(this, 0, 94);
		Base5.addBox(-16F, -6F, -10F, 3, 6, 20);
		Base5.setRotationPoint(0F, 24F, 0F);
		Base5.setTextureSize(128, 128);
		Base5.mirror = true;
		setRotation(Base5, 0F, 0F, 0F);
		Base6 = new ModelRenderer(this, 0, 0);
		Base6.addBox(-12F, -44F, -12F, 24, 38, 24);
		Base6.setRotationPoint(0F, 24F, 0F);
		Base6.setTextureSize(128, 128);
		Base6.mirror = true;
		setRotation(Base6, 0F, 0F, 0F);
		Base7 = new ModelRenderer(this, 46, 103);
		Base7.addBox(-10F, -46F, -10F, 20, 2, 20);
		Base7.setRotationPoint(0F, 24F, 0F);
		Base7.setTextureSize(128, 128);
		Base7.mirror = true;
		setRotation(Base7, 0F, 0F, 0F);
		Base8 = new ModelRenderer(this, 54, 107);
		Base8.addBox(-8F, -47F, -8F, 16, 1, 16);
		Base8.setRotationPoint(0F, 24F, 0F);
		Base8.setTextureSize(128, 128);
		Base8.mirror = true;
		setRotation(Base8, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base1.render(f5);
		Base2.render(f5);
		Base3.render(f5);
		Base4.render(f5);
		Base5.render(f5);
		Base6.render(f5);
		Base7.render(f5);
		Base8.render(f5);
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
