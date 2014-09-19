package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCentrifuge extends ModelBase {
	ModelRenderer Base1;
	ModelRenderer Base2;
	ModelRenderer Base3;
	ModelRenderer Base4;

	public ModelCentrifuge() {
		textureWidth = 64;
		textureHeight = 64;

		Base1 = new ModelRenderer(this, 0, 0);
		Base1.addBox(-7F, -5F, -7F, 14, 5, 14);
		Base1.setRotationPoint(0F, 24F, 0F);
		Base1.setTextureSize(64, 64);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 0, 19);
		Base2.addBox(-7F, -9F, -3F, 14, 4, 10);
		Base2.setRotationPoint(0F, 24F, 0F);
		Base2.setTextureSize(64, 64);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 0, 33);
		Base3.addBox(-7F, -1F, -10F, 14, 1, 10);
		Base3.setRotationPoint(0F, 15F, 7F);
		Base3.setTextureSize(64, 64);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		Base4 = new ModelRenderer(this, 0, 44);
		Base4.addBox(-6.5F, -4F, -8F, 13, 5, 3);
		Base4.setRotationPoint(0F, 24F, 0F);
		Base4.setTextureSize(64, 64);
		Base4.mirror = true;
		setRotation(Base4, -0.7853982F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base1.render(f5);
		Base2.render(f5);
		Base3.render(f5);
		Base4.render(f5);
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
