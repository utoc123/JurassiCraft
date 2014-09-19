package com.rafamv.bygoneage.client.renderer;

public class ModelRendererExtraMethods {
	public float movementX(ResettableModelRenderer box, float movement1) {
		return movement1 + box.firstRotateAngleX;
	}

	public float movementX(ResettableModelRenderer box, float movement1, float movement2) {
		return movement1 + movement2 + box.firstRotateAngleX;
	}

	public float movementX(ResettableModelRenderer box, float movement1, float movement2, float movement3) {
		return movement1 + movement2 + movement3 + box.firstRotateAngleX;
	}

	public float movementY(ResettableModelRenderer box, float movement1) {
		return movement1 + box.firstRotateAngleY;
	}

	public float movementY(ResettableModelRenderer box, float movement1, float movement2) {
		return movement1 + movement2 + box.firstRotateAngleY;
	}

	public float movementY(ResettableModelRenderer box, float movement1, float movement2, float movement3) {
		return movement1 + movement2 + movement3 + box.firstRotateAngleY;
	}

	public float movementZ(ResettableModelRenderer box, float movement1) {
		return movement1 + box.firstRotateAngleZ;
	}

	public float movementZ(ResettableModelRenderer box, float movement1, float movement2) {
		return movement1 + movement2 + box.firstRotateAngleZ;
	}

	public float movementZ(ResettableModelRenderer box, float movement1, float movement2, float movement3) {
		return movement1 + movement2 + movement3 + box.firstRotateAngleZ;
	}
}
