package com.ilexiconn.jurassicraft.data.animation;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;

import com.ilexiconn.jurassicraft.data.entity.EntityAnkylosaur;

import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.AnimationAPI;

public class AIAnkylosaurTailWhip extends AIAnimation {
		
	private EntityAnkylosaur entityAnkylosaur;
	private EntityLiving attackTarget;
	
	public AIAnkylosaurTailWhip(EntityAnkylosaur ankylosaur) {
		super(ankylosaur);
		entityAnkylosaur = ankylosaur;
		attackTarget = null;
	}
		
	public int getAnimID() {
		return 1;
	}
	
	public boolean isAutomatic() {
		return true;
	}
	
	public int getDuration() {
		return 30;
	}
	
	public void startExecuting() {
		super.startExecuting();
		attackTarget = (EntityLiving) entityAnkylosaur.getAttackTarget();
	}
	
	public void updateTask() {
		if(entityAnkylosaur.getAnimTick() < 14)
			entityAnkylosaur.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
		if(entityAnkylosaur.getAnimTick() == 14 && attackTarget != null)
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityAnkylosaur), 1);
	}
}
