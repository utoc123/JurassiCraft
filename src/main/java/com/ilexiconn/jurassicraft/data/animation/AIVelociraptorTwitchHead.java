package com.ilexiconn.jurassicraft.data.animation;

import com.ilexiconn.jurassicraft.data.entity.EntityVelociraptor;

import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class AIVelociraptorTwitchHead extends AIAnimation {
	private EntityVelociraptor raptor;
	public AIVelociraptorTwitchHead(IAnimatedEntity animraptor) {
		super(animraptor);
		this.raptor = (EntityVelociraptor) animraptor;
	}
	
	public int getAnimID() {
		return 1;
	}
	
	public boolean isAutomatic() {
		return false;
	}
	
	public int getDuration() {
		return 20;
	}
	
	public boolean shouldAnimate() {
		EntityLiving living = getEntity();
		IAnimatedEntity entity = (IAnimatedEntity)living;
		return entity.getAnimID() == 0 && living.getRNG().nextInt(35) == 0;
	}
}
