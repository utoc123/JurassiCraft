package to.uk.ilexiconn.jurassicraft.data.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.Util;

public class EntityJurassiCraftRidable extends EntityJurassiCraftTameable {

	private float prevRearingAmount;
	float mountingSpeed;

	public EntityJurassiCraftRidable(World world, byte id) {
		super(world, id);
		this.setMountingSpeed((float) (this.getCreatureSpeed() + 0.5D));
	}

	public boolean isCreatureRidable() {
		return Util.getDinoByID(this.getCreatureID()).isRidable;
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack playerItemStack = player.inventory.getCurrentItem();
		//if (!this.worldObj.isRemote && playerItemStack != (ItemStack) null && Util.isRidingItem(this.getCreatureID(), playerItemStack.getItem())) { CHECK LATER
		if (!this.worldObj.isRemote && playerItemStack != (ItemStack) null && playerItemStack.getItem().equals(Items.carrot_on_a_stick)) {
			System.out.println("Click 2 " + this.isCreatureRidable() + " tamed " + this.isTamed() + " ridden " + this.riddenByEntity == null + " owner " + player.getCommandSenderName().equals(this.getOwnerName()));
			if (this.isCreatureRidable() && this.isTamed() && this.isCreatureAdult() && this.riddenByEntity == null && player.getCommandSenderName().equals(this.getOwnerName())) {
				this.setSitting(false);
				this.setRidingPlayer(player);
			} else {
				if (!this.isCreatureRidable()) {
					player.addChatMessage(new ChatComponentText("This creature is not ridable."));
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

	public float getMountingSpeed() {
		return this.mountingSpeed;
	}

	public void setMountingSpeed(float speed) {
		this.mountingSpeed = speed;
	}

	@Override
	public boolean allowLeashing() {
		return !this.getLeashed() && !(this instanceof IMob) && this.isTamed();
	}

	public void setRidingPlayer(EntityPlayer player) {
		player.rotationYaw = this.rotationYaw;
		player.rotationPitch = this.rotationPitch;
		player.mountEntity(this);
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

	/** Sets the mob rotation depending on the item position (pig style). */
	private void handleItemControlledRiding() {
		this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
		float adjust = MathHelper.wrapAngleTo180_float(((EntityLivingBase) this.riddenByEntity).rotationYaw - this.rotationYaw) * 0.5F;
		if (adjust > 2.0F) {
			adjust = 2.0F;
		} else if (adjust < -2.0F) {
			adjust = -2.0F;
		}
		this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjust);
		this.setRotation(this.rotationYaw, this.rotationPitch);
	}

	/** Sets the mob rotation depending on where the player is looking (horse style). */
	private void handleMouseControlledRiding() {
		this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
		this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
		this.setRotation(this.rotationYaw, this.rotationPitch);
		this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
		this.setRotation(this.rotationYaw, this.rotationPitch);
	}

	/** Sets the mob rotation depending on A and D keys. */
	private void handleKeyboardControlledRiding(float adjustment) {
		float adjustPitch = 0.0F;
		float adjustYaw = 0.0F;
		if (Minecraft.getMinecraft().gameSettings.keyBindRight.getIsKeyPressed()) {
			adjustYaw = adjustYaw + adjustment;
		}
		if (Minecraft.getMinecraft().gameSettings.keyBindLeft.getIsKeyPressed()) {
			adjustYaw = adjustYaw - adjustment;
		}
		this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw + adjustYaw);
		this.rotationPitch = MathHelper.wrapAngleTo180_float(this.rotationPitch + adjustPitch);
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
		this.setRotation(this.rotationYaw, this.rotationPitch);
	}

	@Override
	public void moveEntityWithHeading(float movementStrafing, float movementForward) {
		// CHECK LATER
		// if (this.riddenByEntity != null && this.riddenByEntity instanceof
		// EntityPlayer && ((EntityPlayer) this.riddenByEntity).getHeldItem() !=
		// (ItemStack) null && Util.isRidingItem(this.getCreatureID(),
		// ((EntityPlayer) this.riddenByEntity).getHeldItem().getItem())) {
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && ((EntityPlayer) this.riddenByEntity).getHeldItem() != (ItemStack) null && ((EntityPlayer) this.riddenByEntity).getHeldItem().getItem().equals(Items.carrot_on_a_stick)) {
			switch (Util.getDinoByID(this.getCreatureID()).ridingStyle) {
				case 0:
					this.handleMouseControlledRiding();
					break;
				case 1:
					this.handleKeyboardControlledRiding((float) (7.0F * this.getCreatureSpeed()));
					break;
				case 2:
					this.handleItemControlledRiding();
					break;
				default:
					this.handleItemControlledRiding();
			}
			this.stepHeight = 1.0F; // CHECK: Should change with height!!!
			movementStrafing = ((EntityLivingBase) this.riddenByEntity).moveStrafing * 0.5F * this.getMountingSpeed();
			if (Minecraft.getMinecraft().gameSettings.keyBindBack.getIsKeyPressed()) {
				movementForward = ((EntityLivingBase) this.riddenByEntity).moveForward * 0.3F * this.getMountingSpeed();
			} else {
				movementForward = ((EntityLivingBase) this.riddenByEntity).moveForward * this.getMountingSpeed();
			}
			if (Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed() && this.onGround && !this.isJumping && ((EntityPlayer) this.riddenByEntity).getHeldItem().getItemDamage() < ((EntityPlayer) this.riddenByEntity).getHeldItem().getMaxDamage() - 20) {
				//((EntityPlayer) this.riddenByEntity).getHeldItem().setItemDamage(((EntityPlayer) this.riddenByEntity).getHeldItem().getItemDamage() + 20); CHECK LATER
				this.jump();
			}
			//this.decreaseHeldItemDurability(); CHECK LATER
			if (!this.worldObj.isRemote) {
				this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
				super.moveEntityWithHeading(movementStrafing, movementForward);
			}
			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = this.posX - this.prevPosX;
			double d0 = this.posZ - this.prevPosZ;
			float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;
			if (f4 > 1.0F) {
				f4 = 1.0F;
			}
			this.limbSwingAmount = this.limbSwingAmount + (f4 - this.limbSwingAmount) * 0.4F;
			this.limbSwing = this.limbSwing + this.limbSwingAmount;
		} else {
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.moveEntityWithHeading(movementStrafing, movementForward);
		}
	}

	/** Decreases the held item durability and destroys the item if stack size is 0 or less. */
	private void decreaseHeldItemDurability() {
		if (((EntityPlayer) this.riddenByEntity).getHeldItem().getItemDamage() > ((EntityPlayer) this.riddenByEntity).getHeldItem().getMaxDamage()) {
			((EntityPlayer) this.riddenByEntity).getHeldItem().stackSize--;
			if (((EntityPlayer) this.riddenByEntity).getHeldItem().stackSize <= 0) {
				((EntityPlayer) this.riddenByEntity).inventory.setInventorySlotContents(((EntityPlayer) this.riddenByEntity).inventory.currentItem, (ItemStack) null);
			}
		} else {
			((EntityPlayer) this.riddenByEntity).getHeldItem().setItemDamage(((EntityPlayer) this.riddenByEntity).getHeldItem().getItemDamage() + 1);
		}
	}

	@Override
	public boolean isOnLadder() {
		return false;
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
		compound.setFloat("MountingSpeed", this.getMountingSpeed());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setMountingSpeed(compound.getFloat("MountingSpeed"));
	}

}