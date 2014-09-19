package com.rafamv.bygoneage.enums;

public enum BygoneAgeAnimationIDs {

	ANIMATION_BITE((byte) 1),
	ANIMATION_HEADBUTT((byte) 2),
	ANIMATION_PECK((byte) 3);
	
	private BygoneAgeAnimationIDs(byte id) {
		this.animationID = (byte) id;
	}
	
	/** Returns the name of the fossil */
	public int getAnimationID() {
		return (int) animationID;
	}
	
	private final byte animationID;
	
}