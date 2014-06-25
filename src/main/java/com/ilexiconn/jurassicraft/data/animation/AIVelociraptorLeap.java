package com.ilexiconn.jurassicraft.data.animation;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.AIAnimation;

import com.ilexiconn.jurassicraft.data.entity.entity.EntityVelociraptor;

public class AIVelociraptorLeap extends AIAnimation {
private EntityVelociraptor entityRaptor;
private EntityLivingBase attackTarget;
	
	public AIVelociraptorLeap(EntityVelociraptor raptor) {
		super(raptor);
		entityRaptor = raptor;
	}
	
	public int getAnimID() {
		return 3;
	}
	
	public boolean isAutomatic() {
		return true;
	}
	
	public int getDuration() {
		return 40;
	}
	
	public void startExecuting() {
		super.startExecuting();
		attackTarget = entityRaptor.getAttackTarget();
	}
	
	public void updateTask() {
		if(entityRaptor.getAnimTick() < 25)
			entityRaptor.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
		if(entityRaptor.getAnimTick() == 25) {
            double d0 = attackTarget.posX - entityRaptor.posX;
            double d1 = attackTarget.posZ - entityRaptor.posZ;
            float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
            entityRaptor.motionX = 1.5*(d0 / (double)f2 * 0.5D * 0.800000011920929D + entityRaptor.motionX * 0.20000000298023224D);
            entityRaptor.motionZ = 1.5*(d1 / (double)f2 * 0.5D * 0.800000011920929D + entityRaptor.motionZ * 0.20000000298023224D);
            entityRaptor.motionY = 0.5D;
		}
		if(entityRaptor.getAnimTick() == 39) {
			entityRaptor.leaping = true;
			entityRaptor.timeSinceLeap = 150;
		}
	}
}