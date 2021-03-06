package com.rafamv.bygoneage.entity;

import java.util.List;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.rafamv.bygoneage.ai.BygoneAgeEntityAIOwnerHurtByTarget;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAIOwnerHurtTarget;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAITargetIfNonTamed;

public class EntityBygoneAgeLandAggressive extends EntityBygoneAgeLandCreature {

	public EntityBygoneAgeLandAggressive(World world, byte id, float maxChildAge) {
		super(world, id, maxChildAge);
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.targetTasks.addTask(1, new BygoneAgeEntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new BygoneAgeEntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new BygoneAgeEntityAITargetIfNonTamed(this, EntityPlayer.class, 0));
	}

	/** Sets the attack target if it is adult. If it is also tamed, this will
	 * check if the target is tamed by the player. */
	private void becomeAngryAt(EntityBygoneAgeLandAggressive creature, Entity target) {
		if (creature.isCreatureAdult()) {
			if (creature.isTamed()) {
				if (this.checkTarget(target)) {
					creature.setAttackTarget((EntityLivingBase) target);
				}
			} else {
				creature.setAttackTarget((EntityLivingBase) target);
			}
		}
	}

	@Override
	protected Entity findPlayerToAttack() {
		if (this.isCreatureAdult() && !this.isTamed()) {
			EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
			return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
		} else {
			return null;
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float damage) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity attacker = damageSource.getEntity();
			if (attacker != (Entity) null && this.checkTarget(attacker)) {
				this.becomeAngryAt(this, attacker);
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0D, 16.0D, 16.0D));
				for (int i = 0; i < list.size(); ++i) {
					Entity entityNeighbor = (Entity) list.get(i);
					if (entityNeighbor.getClass() == this.getClass()) {
						EntityBygoneAgeLandAggressive entityNeighborAngry = (EntityBygoneAgeLandAggressive) entityNeighbor;
						if (entityNeighborAngry.checkTarget(attacker)) {
							becomeAngryAt(entityNeighborAngry, attacker);
						}
					}
				}
				return super.attackEntityFrom(damageSource, damage);
			} else {
				return damageSource.getEntity() != this.getOwner() ? super.attackEntityFrom(damageSource, damage) : false;
			}
		}
	}

	@Override
	protected void attackEntity(Entity entity, float par2) {
		if (this.attackTime <= 0 && par2 < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(entity);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		float f = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		int i = 0;
		if (entity instanceof EntityLivingBase) {
			f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) entity);
			i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) entity);
		}
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		if (flag) {
			if (i > 0) {
				entity.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			int j = EnchantmentHelper.getFireAspectModifier(this);
			if (j > 0) {
				entity.setFire(j * 4);
			}
			if (entity instanceof EntityLivingBase) {
				EnchantmentHelper.func_151384_a((EntityLivingBase) entity, this);
			}
			EnchantmentHelper.func_151385_b(this, entity);
		}
		return flag;
	}
}
