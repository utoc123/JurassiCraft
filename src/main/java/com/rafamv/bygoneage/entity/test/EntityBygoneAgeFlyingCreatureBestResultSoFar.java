package com.rafamv.bygoneage.entity.test;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.rafamv.bygoneage.entity.EntityBygoneAgeTameable;
import com.rafamv.bygoneage.enums.BygoneAgeRidingInformation;

public class EntityBygoneAgeFlyingCreatureBestResultSoFar extends EntityBygoneAgeTameable {

	private float prevRearingAmount;
	protected float flyingSpeed;
	private static final int MAX_TAKEOFF_TIME = 150;
	private static final int KEY_TAKEOFF_TIME = 22;

	public EntityBygoneAgeFlyingCreatureBestResultSoFar(World world, byte id, float maxChildAge) {
		super(world, id, maxChildAge);
		this.setFlyingSpeed();
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(KEY_TAKEOFF_TIME, Integer.valueOf((int) this.MAX_TAKEOFF_TIME));
	}

	/** Returns the current takeoffTime. */
	public int getTakeoffTime() {
		return (int) this.dataWatcher.getWatchableObjectInt(this.KEY_TAKEOFF_TIME);
	}

	/** Increases or decreases the takeoffTime by a specific time. */
	private void addValueToTakeoffTime(int time) {
		if (this.getTakeoffTime() + time < this.MAX_TAKEOFF_TIME) {
			this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (this.getTakeoffTime() + time)));
		} else {
			this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (this.MAX_TAKEOFF_TIME)));
		}
	}

	/** Increases the takeoffTime by 1. */
	private void increseTakeoffTime() {
		if (this.getTakeoffTime() + 1 < this.MAX_TAKEOFF_TIME) {
			this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (this.getTakeoffTime() + 1)));
		} else {
			this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (this.MAX_TAKEOFF_TIME)));
		}
	}

	/** Decreases the takeoffTime by 1. */
	private void decreseTakeoffTime() {
		this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (this.getTakeoffTime() - 1)));
	}

	/**
	 * Sets a specific time for the takeoffTime. I must be lower than the
	 * maximum takeoffTime, otherwise it will sets the maximum.
	 */
	private void setTakeoffTime(int time) {
		if (this.getTakeoffTime() < this.MAX_TAKEOFF_TIME) {
			this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (time)));
		} else {
			this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (this.MAX_TAKEOFF_TIME)));
		}
	}

	/** Sets the maximum takeoffTime. */
	private void resetTakeoffTime() {
		this.dataWatcher.updateObject(this.KEY_TAKEOFF_TIME, Integer.valueOf((int) (this.MAX_TAKEOFF_TIME)));
	}

	public double getTakeoffProcess() {
		return ((double) (this.MAX_TAKEOFF_TIME - this.getTakeoffTime()) / (double) this.MAX_TAKEOFF_TIME);
	}

	public boolean isCreatureFlyable() {
		return BygoneAgeRidingInformation.values()[this.getCreatureID()].isRidable();
	}

	public float getFlyingSpeed() {
		return this.flyingSpeed;
	}

	private void setFlyingSpeed() {
		this.flyingSpeed = 1.0F; // BygoneAgeRidingInformation.values()[this.getCreatureID()].getRidingSpeed();
	}

	public boolean isFlying() {
		return (this.getTakeoffTime() < 0 && !this.isCollidedVertically && !this.isCollidedHorizontally && !this.inWater) ? true : false;
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack playerItemStack = player.inventory.getCurrentItem();
		if (!this.worldObj.isRemote && playerItemStack != (ItemStack) null && BygoneAgeRidingInformation.isRidingItem(this.getCreatureID(), playerItemStack.getItem())) {
			if (this.isCreatureFlyable() && this.isTamed() && this.isCreatureAdult() && this.riddenByEntity == null && player.getCommandSenderName().equals(this.getOwnerName())) {
				this.setSitting(false);
				this.setRidingPlayer(player);
			} else {
				if (!this.isCreatureFlyable()) {
					player.addChatMessage(new ChatComponentText("This creature is not flyable."));
				} else if (!this.isTamed()) {
					player.addChatMessage(new ChatComponentText("This creature is not tamed yet."));
				} else if (!this.isCreatureAdult()) {
					player.addChatMessage(new ChatComponentText("This creature is not an adult yet."));
				} else if (this.riddenByEntity != null) {
					player.addChatMessage(new ChatComponentText("There is someone already riding this creature."));
				}
			}
		}
		return super.interact(player);
	}

	@Override
	public void updateRiderPosition() {
		super.updateRiderPosition();
		if (this.prevRearingAmount > 0.0F) {
			float f = MathHelper.sin(this.renderYawOffset * (float) Math.PI / 180.0F);
			float f1 = MathHelper.cos(this.renderYawOffset * (float) Math.PI / 180.0F);
			float f2 = 0.7F * this.prevRearingAmount;
			float f3 = 0.15F * this.prevRearingAmount;
			this.riddenByEntity.setPosition(this.posX + (double) (f2 * f), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + (double) f3, this.posZ - (double) (f2 * f1));
			if (this.riddenByEntity instanceof EntityLivingBase) {
				((EntityLivingBase) this.riddenByEntity).renderYawOffset = this.renderYawOffset;
			}
		}
	}

	@Override
	public boolean allowLeashing() {
		return !this.getLeashed() && this.isTamed() && !this.isFlying();
	}

	@Override
	public boolean isOnLadder() {
		return false;
	}

	public void setRidingPlayer(EntityPlayer player) {
		player.mountEntity(this);
	}

	private boolean checkPlayerRidingItem(EntityPlayer player) {
		return ((player.getHeldItem() != (ItemStack) null && BygoneAgeRidingInformation.isRidingItem(this.getCreatureID(), player.getHeldItem().getItem())) ? true : false);
	}

	private void consumeHeldItem() {
		// To do
	}

	private void handleRotationsOnFlight() {
		float adjustPitch = 0.0F;
		float adjustYaw = 0.0F;
		this.stepHeight = 0.0F;
		if (Minecraft.getMinecraft().gameSettings.keyBindRight.getIsKeyPressed()) {
			adjustYaw = adjustYaw + 1.0F;
		}
		if (Minecraft.getMinecraft().gameSettings.keyBindLeft.getIsKeyPressed()) {
			adjustYaw = adjustYaw - 1.0F;
		}
		if (this.rotationPitch <= 60.0F && Minecraft.getMinecraft().gameSettings.keyBindBack.getIsKeyPressed()) {
			adjustPitch = adjustPitch + 1.0F;
		}
		if (this.rotationPitch >= -60.0F && Minecraft.getMinecraft().gameSettings.keyBindForward.getIsKeyPressed()) {
			adjustPitch = adjustPitch - 1.0F;
		}
		this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjustYaw);
		this.rotationPitch = MathHelper.wrapAngleTo180_float(this.rotationPitch + adjustPitch);
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
		this.setRotation(this.rotationYaw, this.rotationPitch);
	}

	private void handleRotationsOnGround(boolean tryingToFly) {
		if (tryingToFly) {
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
			this.rotationYaw = this.prevRotationYaw;
			this.rotationPitch = this.prevRotationPitch;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
		} else {
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
			float adjust = MathHelper.wrapAngleTo180_float(((EntityLivingBase) this.riddenByEntity).rotationYaw - this.rotationYaw) * 0.5F;
			if (adjust > 3.0F) {
				adjust = 3.0F;
			} else if (adjust < -3.0F) {
				adjust = -3.0F;
			}
			this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjust);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		}
	}

	private void handleMovementOnFlight(float movementForward, float movementStrafing) {
		// this.motionY = -0.005D;
	}

	private void handleMovementOnGround(float movementForward, float movementStrafing, boolean tryingToFly) {
		if (tryingToFly) {
			if (Minecraft.getMinecraft().gameSettings.keyBindForward.getIsKeyPressed()) {
				this.decreseTakeoffTime();
				if (this.getTakeoffTime() < 0.5D * this.MAX_TAKEOFF_TIME) {
					this.motionY = 0.1D * Math.pow((2.0D * this.getTakeoffProcess()), 3.0D) / (Math.pow((2.0D * this.getTakeoffProcess()), 5.0D) + 0.18D);
				}
			}
		} else {
			this.addValueToTakeoffTime(2);
			this.motionY = -0.08D;
		}
	}

	private void handleLimbMovement() {
		this.prevLimbSwingAmount = this.limbSwingAmount;
		double point1 = this.posX - this.prevPosX;
		double point2 = this.posZ - this.prevPosZ;
		float distance = MathHelper.sqrt_double(point1 * point1 + point2 * point2) * 4.0F;
		if (distance > 1.0F) {
			distance = 1.0F;
		}
		this.limbSwingAmount += (distance - this.limbSwingAmount) * 0.4F;
		this.limbSwing += this.limbSwingAmount;
	}

	@Override
	public void moveEntityWithHeading(float movementStrafing, float movementForward) {
		System.out.println("=========================================================================================================================================================");
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer) {
			EntityPlayer playerFlying = (EntityPlayer) this.riddenByEntity;
			if (playerFlying.getHeldItem() != (ItemStack) null && BygoneAgeRidingInformation.isRidingItem(this.getCreatureID(), playerFlying.getHeldItem().getItem())) {
				if (this.isFlying()) {
					if (this.worldObj.isRemote) {
						System.out.println("Client: Flying " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					} else {
						System.out.println("Server: Flying " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					}
					this.decreseTakeoffTime();
					this.handleRotationsOnFlight();
					this.handleMovementOnFlight(movementForward, movementStrafing);
					movementForward = 1.0F + this.getFlyingSpeed();
					movementStrafing = 0.0F;
					if (!checkPlayerRidingItem(playerFlying)) {
						this.motionY = -0.08D;
					}
					if (!this.worldObj.isRemote) {
						this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
						this.motionY = 0.6F * MathHelper.sin((float)Math.PI + this.rotationPitch * (float)Math.PI / 180.0F);
						this.motionX = (double) (0.3F * MathHelper.cos(this.rotationPitch * (float)Math.PI / 180.0F) * MathHelper.sin((float)Math.PI + this.rotationYaw * (float)Math.PI / 180.0F));
			            this.motionZ = (double) (0.3F * MathHelper.cos(this.rotationPitch * (float)Math.PI / 180.0F) * MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F));
			            System.out.println("rotationYaw: " + this.rotationYaw);
						System.out.println("rotationPitch: " + this.rotationPitch);
						System.out.println("rotationYawHead: " + this.rotationYawHead);
			            this.moveEntity(this.motionX, this.motionY - 0.005D, this.motionZ);
					}
					this.handleLimbMovement();
				} else if (Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed() && !this.isFlying()) {
					if (this.worldObj.isRemote) {
						System.out.println("Client: Trying Flying " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					} else {
						System.out.println("Server: Trying Flying " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					}
					this.isJumping = false;
					this.handleRotationsOnGround(true);
					this.handleMovementOnGround(movementForward, movementStrafing, true);
					movementForward = (float) ((playerFlying.moveForward * 0.5F * this.getFlyingSpeed() + 1.0F * this.getTakeoffProcess()) * this.getFlyingSpeed());
					movementStrafing = 0.0F;
					this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
					super.moveEntityWithHeading(movementStrafing, movementForward);
					this.handleLimbMovement();
				} else {
					if (this.worldObj.isRemote) {
						System.out.println("Client: Walking " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					} else {
						System.out.println("Server: Walking " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					}
					this.resetTakeoffTime();
					this.handleRotationsOnGround(false);
					this.handleMovementOnGround(movementForward, movementStrafing, false);
					movementForward = (float) (playerFlying.moveForward * 0.5F * this.getFlyingSpeed());
					movementStrafing = playerFlying.moveStrafing * 0.125F * this.getFlyingSpeed();
					if (!this.worldObj.isRemote) {
						this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
						super.moveEntityWithHeading(movementStrafing, movementForward);
					}
					this.handleLimbMovement();
				}
			}
		} else {
			if (this.isFlying()) {
				if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer) {
					EntityPlayer playerFlying = (EntityPlayer) this.riddenByEntity;
					if (this.worldObj.isRemote) {
						System.out.println("Client: Falling smoothly " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					} else {
						System.out.println("Server: Falling smoothly " + this.getTakeoffTime() + " this.isFlying(): " + this.isFlying() + " this.isCollidedVertically: " + this.isCollidedVertically + " this.onGround: " + this.onGround + " this.inWater: " + this.inWater);
					}
					this.resetTakeoffTime();
					this.handleRotationsOnGround(false);
					this.handleMovementOnGround(movementForward, movementStrafing, false);
					movementForward = (float) (playerFlying.moveForward * 0.5F * this.getFlyingSpeed());
					movementStrafing = playerFlying.moveStrafing * 0.125F * this.getFlyingSpeed();
					if (!this.worldObj.isRemote) {
						this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
						super.moveEntityWithHeading(movementStrafing, movementForward);
					}
					this.handleLimbMovement();
				} else {
					System.out.println("Normal behavior - this.riddenByEntity: " + this.riddenByEntity + " this.ridingEntity: " + this.ridingEntity);
					this.stepHeight = 0.5F;
					this.jumpMovementFactor = 0.02F;
					this.resetTakeoffTime();
					super.moveEntityWithHeading(movementStrafing, movementForward);
				}
			} else {
				System.out.println("Normal behavior - this.riddenByEntity: " + this.riddenByEntity + " this.ridingEntity: " + this.ridingEntity);
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				this.resetTakeoffTime();
				super.moveEntityWithHeading(movementStrafing, movementForward);
			}
		}
	}

	public boolean isInvulnerable(DamageSource damageSource) {
		Entity entity = (Entity) damageSource.getEntity();
		if (entity != null) {
			if (entity == riddenByEntity || entity == this || entity == this.getOwner()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("TakeoffTime", this.getTakeoffTime());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setTakeoffTime(compound.getInteger("TakeoffTime"));
		this.setFlyingSpeed();
	}
}
