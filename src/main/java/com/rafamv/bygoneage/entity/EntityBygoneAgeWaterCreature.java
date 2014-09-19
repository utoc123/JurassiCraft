package com.rafamv.bygoneage.entity;

import net.minecraft.world.World;

public class EntityBygoneAgeWaterCreature extends EntityBygoneAgeTameable {

	public EntityBygoneAgeWaterCreature(World world, byte id, float maxChildAge) {
		super(world, id, maxChildAge);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

}
