package com.rafamv.bygoneage.entity;

import net.minecraft.world.World;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public abstract class EntityBygoneAgeAnimated extends EntityBygoneAgeCreature implements IAnimatedEntity {

	protected int animID;
	protected int animTick;

	public EntityBygoneAgeAnimated(World world, byte id, float maxChildAge) {
		super(world, id, maxChildAge);
		animID = 0;
		animTick = 0;
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	public void setAnimID(int id) {
		animID = id;
	}

	@Override
	public void setAnimTick(int tick) {
		animTick = tick;
	}

	@Override
	public int getAnimID() {
		return animID;
	}

	@Override
	public int getAnimTick() {
		return animTick;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (animID != 0) {
			animTick++;
		}
	}

}