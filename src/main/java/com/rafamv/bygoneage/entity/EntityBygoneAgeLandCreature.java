package com.rafamv.bygoneage.entity;

import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;

public class EntityBygoneAgeLandCreature extends EntityBygoneAgeRidable {

	public EntityBygoneAgeLandCreature(World world, byte id, float maxChildAge) {
		super(world, id, maxChildAge);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return false;
	}

}
