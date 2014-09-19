package com.rafamv.bygoneage.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

import com.rafamv.bygoneage.entity.EntityBygoneAgeTameable;

public class BygoneAgeEntityAISit extends EntityAIBase {

	private EntityBygoneAgeTameable creature;
	private boolean isSitting;

	public BygoneAgeEntityAISit(EntityBygoneAgeTameable entityTameable) {
		this.creature = entityTameable;
		this.setMutexBits(5);
	}

	public boolean shouldExecute() {
		if (!this.creature.isTamed()) {
			return false;
		} else if (this.creature.isInWater()) {
			return false;
		} else if (!this.creature.onGround) {
			return false;
		} else {
			EntityLivingBase entitylivingbase = this.creature.getOwner();
			return entitylivingbase == null ? true : (this.creature.getDistanceSqToEntity(entitylivingbase) < 144.0D && entitylivingbase.getAITarget() != null ? false : this.isSitting);
		}
	}

	public void startExecuting() {
		this.creature.getNavigator().clearPathEntity();
		this.creature.setSitting(true);
	}

	public void resetTask() {
		this.creature.setSitting(false);
	}

	public void setSitting(boolean par1) {
		this.isSitting = par1;
	}
}