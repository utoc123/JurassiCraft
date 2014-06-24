package com.ilexiconn.jurassicraft.data.animation;

import thehippomaster.AnimationAPI.AIAnimation;

import com.ilexiconn.jurassicraft.data.entity.entity.EntityVelociraptor;

public class AIVelociraptorRoar extends AIAnimation {
private EntityVelociraptor entityRaptor;
	
	public AIVelociraptorRoar(EntityVelociraptor raptor) {
		super(raptor);
		entityRaptor = raptor;
	}
	
	public int getAnimID() {
		return 2;
	}
	
	public boolean isAutomatic() {
		return true;
	}
	
	public int getDuration() {
		return 20;
	}
}

