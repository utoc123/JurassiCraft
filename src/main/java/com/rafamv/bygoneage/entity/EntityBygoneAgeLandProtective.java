package com.rafamv.bygoneage.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.rafamv.bygoneage.ai.BygoneAgeEntityAIAngerProtective;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAIOwnerHurtByTarget;
import com.rafamv.bygoneage.ai.BygoneAgeEntityAIOwnerHurtTarget;
import com.rafamv.bygoneage.ai.BygoneAgeLandEntityAIPanicIfNotAnger;

public class EntityBygoneAgeLandProtective extends EntityBygoneAgeLandCreature {

	private short angerLevel;
	private int numberOfAllies;

	public EntityBygoneAgeLandProtective(World world, byte id, int alliesToAttack, float maxChildAge) {
		super(world, id, maxChildAge);
		this.numberOfAllies = alliesToAttack;
		this.tasks.addTask(1, new BygoneAgeLandEntityAIPanicIfNotAnger(this, 1.2D));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.targetTasks.addTask(1, new BygoneAgeEntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new BygoneAgeEntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new BygoneAgeEntityAIAngerProtective(this));
	}

	/** Sets the anger level of the creature. This is a short that is reduced to
	 * zero if it is positive. */
	public void setAngerLevel(short count) {
		this.angerLevel = count;
	}

	/** Returns the anger level of the creature. Higher than zero means that the
	 * creature was attacked. */
	public short getAngerLevel() {
		return angerLevel;
	}

	/** Sets the fleeing tick value of the creature. When it is positive, it is
	 * reduced each tick until zero. */
	public void setFleeingTick(int value) {
		this.fleeingTick = value;
	}

	/** Returns the fleeing ticks of the creature. Higher than zero means that
	 * the creature was attacked. */
	public int getFleeingTick() {
		return fleeingTick;
	}

	/** Sets the target of the creature. */
	private void cancelAngryBehavior(EntityBygoneAgeLandProtective howWasAttacking) {
		howWasAttacking.setAngerLevel((short) 0);
		howWasAttacking.setAttackTarget((EntityLivingBase) null);
	}

	/** Sets the target of the creature. */
	private void becomeAngryAt(EntityBygoneAgeLandProtective creature, Entity target) {
		if (creature.isCreatureAdult()) {
			if (creature.isTamed()) {
				if (this.checkTarget(target)) {
					creature.setAngerLevel((short) (300 + rand.nextInt(200)));
					creature.setAttackTarget((EntityLivingBase) target);
				}
			} else {
				creature.setAngerLevel((short) (300 + rand.nextInt(200)));
				creature.setAttackTarget((EntityLivingBase) target);
			}
		}
	}

	/** Increases the fleeing ticks by 50 ticks (2 seconds) plus a random number
	 * of ticks between 0 and 70. */
	private void becomePanic(EntityBygoneAgeLandProtective fleeingCreature) {
		fleeingCreature.setFleeingTick(50 + rand.nextInt(71));
		fleeingCreature.entityToAttack = null;
	}

	/** Returns true if the creature is angry, angry level higher than zero. */
	public boolean isAngry() {
		return getAngerLevel() > 0;
	}

	/** Returns true if the creature is fleeing, fleeing ticks higher than zero. */
	public boolean isPanicking() {
		return getFleeingTick() > 0;
	}

	@Override
	protected Entity findPlayerToAttack() {
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		return this.isAngry() && entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float damage) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity attacker = damageSource.getEntity();
			int count = 0;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0D, 16.0D, 16.0D));
			ArrayList<EntityBygoneAgeLandProtective> listChildren = new ArrayList<EntityBygoneAgeLandProtective>();
			ArrayList<EntityBygoneAgeLandProtective> listAdult = new ArrayList<EntityBygoneAgeLandProtective>();
			if (this.isCreatureAdult()) {
				listAdult.add(this);
			} else {
				listChildren.add(this);
				count++;
			}
			for (int i = 0; i < list.size(); ++i) {
				Entity entityNeighbor = (Entity) list.get(i);
				if (entityNeighbor.getClass() == this.getClass()) {
					EntityBygoneAgeLandProtective validEntityNeighbor = (EntityBygoneAgeLandProtective) entityNeighbor;
					if (validEntityNeighbor.isCreatureAdult()) {
						listAdult.add(validEntityNeighbor);
						count++;
					} else {
						listChildren.add(validEntityNeighbor);
					}
				}
			}
			if (this.checkTarget(attacker)) {
				if (this.isCreatureAdult()) {
					if (!listChildren.isEmpty()) {
						for (int i = 0; i < listChildren.size(); ++i) {
							becomePanic(listChildren.get(i));
						}
					}
					if (!listAdult.isEmpty()) {
						for (int i = 0; i < listAdult.size(); ++i) {
							becomeAngryAt(listAdult.get(i), attacker);
						}
					}
				} else {
					if (count >= this.numberOfAllies) {
						if (!listChildren.isEmpty()) {
							for (int i = 0; i < listChildren.size(); ++i) {
								becomePanic(listChildren.get(i));
							}
						}
						if (!listAdult.isEmpty()) {
							for (int i = 0; i < listAdult.size(); ++i) {
								becomeAngryAt(listAdult.get(i), attacker);
							}
						}
					} else {
						if (!listChildren.isEmpty()) {
							for (int i = 0; i < listChildren.size(); ++i) {
								becomePanic(listChildren.get(i));
							}
						}
						if (!listChildren.isEmpty()) {
							for (int i = 0; i < listAdult.size(); ++i) {
								cancelAngryBehavior(listAdult.get(i));
								becomePanic(listAdult.get(i));
							}
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
	public boolean attackEntityAsMob(Entity target) {
		if (this.attackTime <= 0 && target.boundingBox.maxY > this.boundingBox.minY && target.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			float attackDamage = (float) this.getCreatureAttack();
			int i = 0;
			if (target instanceof EntityLivingBase) {
				attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) target);
				i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) target);
			}
			boolean flag = target.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);
			if (flag) {
				if (i > 0) {
					target.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F));
					this.motionX *= 0.6D;
					this.motionZ *= 0.6D;
				}
				int j = EnchantmentHelper.getFireAspectModifier(this);
				if (j > 0) {
					target.setFire(j * 4);
				}
				if (target instanceof EntityLivingBase) {
					EnchantmentHelper.func_151384_a((EntityLivingBase) target, this);
				}
				EnchantmentHelper.func_151385_b(this, target);
			}
			return flag;
		} else {
			return false;
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setShort("AngerLevel", this.angerLevel);
		compound.setShort("FleeingTick", (short) this.getFleeingTick());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.angerLevel = compound.getShort("AngerLevel");
		this.setFleeingTick(compound.getShort("FleeingTick"));
	}
}
