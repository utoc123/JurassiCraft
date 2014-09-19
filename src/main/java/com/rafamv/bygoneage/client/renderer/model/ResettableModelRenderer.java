package com.rafamv.bygoneage.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ResettableModelRenderer extends ModelRenderer {
	
	public float firstRotateAngleX;
	public float firstRotateAngleY;
	public float firstRotateAngleZ;

	public float firstRotationPointX;
	public float firstRotationPointY;
	public float firstRotationPointZ;
	
	public float firstOffsetX;
	public float firstOffsetY;
	public float firstOffsetZ;

	public ResettableModelRenderer(ModelBase modelBase, int par1, int par2) {
		super(modelBase, par1, par2);
	}

	public void savefirstParameters() {
		firstRotationPointX = this.rotationPointX;
		firstRotationPointY = this.rotationPointY;
		firstRotationPointZ = this.rotationPointZ;
		firstRotateAngleX = this.rotateAngleX;
		firstRotateAngleY = this.rotateAngleY;
		firstRotateAngleZ = this.rotateAngleZ;
		firstOffsetX = this.offsetX;
		firstOffsetY = this.offsetY;
		firstOffsetZ = this.offsetZ;
	}

	/** Resets all parameters. */
	public void resetAllParameters() {
		this.rotationPointX = this.firstRotationPointX;
		this.rotationPointY = this.firstRotationPointY;
		this.rotationPointZ = this.firstRotationPointZ;
		this.rotateAngleX = this.firstRotateAngleX;
		this.rotateAngleY = this.firstRotateAngleY;
		this.rotateAngleZ = this.firstRotateAngleZ;
		this.offsetX = this.firstOffsetX;
		this.offsetY = this.firstOffsetY;
		this.offsetZ = this.firstOffsetZ;
	}

	/** Resets all rotation points. */
	public void resetAllRotationPoints() {
		this.rotationPointX = this.firstRotationPointX;
		this.rotationPointY = this.firstRotationPointY;
		this.rotationPointZ = this.firstRotationPointZ;
	}

	/** Resets X rotation point. */
	public void resetXRotationPoints() {
		this.rotationPointX = this.firstRotationPointX;
	}

	/** Resets Y rotation point. */
	public void resetYRotationPoints() {
		this.rotationPointY = this.firstRotationPointY;
	}

	/** Resets Z rotation point. */
	public void resetZRotationPoints() {
		this.rotationPointZ = this.firstRotationPointZ;
	}

	/** Resets all rotations. */
	public void resetAllRotations() {
		this.rotateAngleX = this.firstRotateAngleX;
		this.rotateAngleY = this.firstRotateAngleY;
		this.rotateAngleZ = this.firstRotateAngleZ;
	}


	/** Resets X rotation. */
	public void resetXRotations() {
		this.rotateAngleX = this.firstRotateAngleX;
	}


	/** Resets Y rotation. */
	public void resetYRotations() {
		this.rotateAngleY = this.firstRotateAngleY;
	}


	/** Resets Z rotation. */
	public void resetZRotations() {
		this.rotateAngleZ = this.firstRotateAngleZ;
	}

	/** Resets all offsets. */
	public void resetAllOffsets() {
		this.offsetX = this.firstOffsetX;
		this.offsetY = this.firstOffsetY;
		this.offsetZ = this.firstOffsetZ;
	}

	/** Resets X offset. */
	public void resetXOffsets() {
		this.offsetX = this.firstOffsetX;
	}

	/** Resets Y offset. */
	public void resetYOffsets() {
		this.offsetY = this.firstOffsetY;
	}

	/** Resets Z offset. */
	public void resetZOffsets() {
		this.offsetZ = this.firstOffsetZ;
	}
}