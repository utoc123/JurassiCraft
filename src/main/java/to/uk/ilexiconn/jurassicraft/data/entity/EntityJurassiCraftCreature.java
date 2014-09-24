package to.uk.ilexiconn.jurassicraft.data.entity;

import io.netty.buffer.ByteBuf;

import java.util.HashSet;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import to.uk.ilexiconn.jurassicraft.Util;

import com.rafamv.bygoneage.items.Analyzer;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityJurassiCraftCreature extends EntityCreature implements IAnimatedEntity, IEntityAdditionalSpawnData {

	public byte creatureID;
	public float geneticQuality;
	public boolean gender;
	public byte texture;
	public float height;
	public float length;
	public float bBoxXZ;
	public float bBoxY;
	protected final HashSet<Integer> growthStageList = new HashSet<Integer>();

	protected int animID;
	protected int animTick;
	public int frame;

	public EntityJurassiCraftCreature(World world, byte id) {
		super(world);
		if (id >= 0 && id < Util.getDinos().size()) {
			this.creatureID = id;
		} else {
			this.creatureID = 0;
		}
		this.resetGrowthStageList();
		this.setCreatureGender(this.rand.nextInt(2) > 0);
		this.setCreatureTexture((byte) this.rand.nextInt(Util.getDinoByID(creatureID).numberOfTextures));
		if (this.worldObj.isRemote) {
			this.setCreatureSize();
			this.setCreatureScale();
		} else {
			this.setHalfOfTheCreatureSize();
		}
		this.animID = 0;
		this.animTick = 0;
	}

	/**
	 * Sets the creature genetic quality. Genetic quality is how much the
	 * creature varies in status. 1.0F is the base value.
	 */
	private void setGeneticQuality(float quality) {
		this.geneticQuality = quality;
	}

	/** Returns the creature genetic quality. */
	public float getGeneticQuality() {
		return this.geneticQuality;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(12, Float.valueOf((float) ((((this.length / Util.getDinoByID(this.creatureID).maxLength) * (this.height / Util.getDinoByID(this.creatureID).maxHeight)) / 2))));
		this.dataWatcher.addObject(13, Byte.valueOf((byte) (0)));
	}

	/** Updates the creature status. */
	private void updateCreatureData(int ticks) {
		double oldHealth = this.getCreatureHealth();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((int) (this.getGeneticQuality() * (ticks * (Util.getDinoByID(this.creatureID).maxHealth - Util.getDinoByID(this.creatureID).minHealth) / Util.getDinoByID(this.creatureID).ticksToAdulthood + Util.getDinoByID(this.creatureID).minHealth)));
		double newHealth = this.getCreatureHealth();
		this.heal((float) (newHealth - oldHealth));
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((float) (this.getGeneticQuality() * (ticks * (Util.getDinoByID(this.creatureID).maxStrength - Util.getDinoByID(this.creatureID).minStrength) / Util.getDinoByID(this.creatureID).ticksToAdulthood + Util.getDinoByID(this.creatureID).minStrength)));
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((float) (this.getGeneticQuality() * (ticks * (Util.getDinoByID(this.creatureID).maxSpeed - Util.getDinoByID(this.creatureID).minSpeed) / Util.getDinoByID(this.creatureID).ticksToAdulthood + Util.getDinoByID(this.creatureID).minSpeed)));
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue((float) (this.getGeneticQuality() * (ticks * (Util.getDinoByID(this.creatureID).maxKnockback - Util.getDinoByID(this.creatureID).minKnockback) / Util.getDinoByID(this.creatureID).ticksToAdulthood + Util.getDinoByID(this.creatureID).minKnockback)));
		this.setCreatureLength();
		this.setCreatureHeight();
		this.setHalfOfTheCreatureSize();
		this.setCreatureScale();
		/*
		System.out.println("=============== UPDATE DATA ===============");
		if (this.worldObj.isRemote) {
			System.out.println("=============== Client ===============");
			System.out.println("getCreatureHealth: " + this.getCreatureHealth());
			System.out.println("getCreatureAttack: " + this.getCreatureAttack());
			System.out.println("getCreatureSpeed: " + this.getCreatureSpeed());
			System.out.println("getCreatureKnockback: " + this.getCreatureKnockback());
			System.out.println("getCreatureTexture: " + this.getCreatureTexture());
			System.out.println("getCreatureLength: " + this.getCreatureLength());
			System.out.println("getCreatureHeight: " + this.getCreatureHeight());
			System.out.println("getCreatureScale: " + this.getCreatureScale());
			System.out.println("getCreatureGenderString: " + this.getCreatureGenderString());
			System.out.println("getCreatureGenderString: " + this.getCreatureTexture());
			System.out.println("======================================");
		} else {
			System.out.println("=============== Server ===============");
			System.out.println("getCreatureHealth: " + this.getCreatureHealth());
			System.out.println("getCreatureAttack: " + this.getCreatureAttack());
			System.out.println("getCreatureSpeed: " + this.getCreatureSpeed());
			System.out.println("getCreatureKnockback: " + this.getCreatureKnockback());
			System.out.println("getCreatureTexture: " + this.getCreatureTexture());
			System.out.println("getCreatureLength: " + this.getCreatureLength());
			System.out.println("getCreatureHeight: " + this.getCreatureHeight());
			System.out.println("getCreatureScale: " + this.getCreatureScale());
			System.out.println("getCreatureGenderString: " + this.getCreatureGenderString());
			System.out.println("getCreatureGenderString: " + this.getCreatureTexture());
			System.out.println("======================================");
		}
		*/
	}

	/**
	 * Resets the growthStageList. This is a list of values (number of ticks)
	 * that represent when the creature will update its status.
	 */
	private void resetGrowthStageList() {
		int ticks = Util.getDinoByID(this.creatureID).ticksToAdulthood;
		this.growthStageList.add(1);
		for (byte i = 1; i < (byte) 120; i++) {
			this.growthStageList.add((int) ((ticks * i) / (byte) 120));
		}
		this.growthStageList.add(ticks);
	}

	/**
	 * Returns the current growth stage of the creature. In order words, how
	 * many times this creature has updated.
	 */
	public byte getGrowthStage() {
		return (byte) this.dataWatcher.getWatchableObjectByte(13);
	}

	/** Sets what is the growth stage of the creature. */
	private void setGrowthStage(byte stage) {
		this.dataWatcher.updateObject(13, Byte.valueOf((byte) (stage)));
	}

	/**
	 * Sets the creature xz and y hit box using genetic quality and growth
	 * stage.
	 */
	public void setBouningBox() {
		this.bBoxXZ = this.getGeneticQuality() * (Util.getDinoByID(this.creatureID).xzBoxMin + Util.getDinoByID(this.creatureID).xzBoxDelta * (((float) this.getGrowthStage()) / 120));
		this.bBoxY = this.getGeneticQuality() * (Util.getDinoByID(this.creatureID).yBoxMin + Util.getDinoByID(this.creatureID).yBoxDelta * (((float) this.getGrowthStage()) / 120));
	}

	/** Sets a new bounding box for the creature depending on its status. */
	protected final void setCreatureSize() {
		this.setBouningBox();
		super.setSize(this.getXZBouningBox(), this.getYBouningBox());
	}

	/**
	 * Sets a new bounding box for the creature depending on its status. This is
	 * the half of the original BB, to better fit in combat
	 */
	protected final void setHalfOfTheCreatureSize() {
		this.setBouningBox();
		super.setSize(this.getXZBouningBox() / 2.0F, this.getYBouningBox() / 2.0F);
	}

	/** Returns the scale of the creature. */
	public float getCreatureScale() {
		return (float) this.dataWatcher.getWatchableObjectFloat(12) * Util.getDinoByID(this.creatureID).scaleAdjustment;
	}

	/** Sets the scale of the creature depending on the age and genetic quality. */
	private void setCreatureScale() {
		if (this.getTotalTicksLived() < Util.getDinoByID(this.creatureID).ticksToAdulthood) {
			this.dataWatcher.updateObject(12,
					Float.valueOf((float) (this.getGeneticQuality() * (((Util.getDinoByID(this.creatureID).minHeight + Util.getDinoByID(this.creatureID).minLength) / 2) + (((Util.getDinoByID(this.creatureID).maxHeight + Util.getDinoByID(this.creatureID).maxLength) / 2) - ((Util.getDinoByID(this.creatureID).minHeight + Util.getDinoByID(this.creatureID).minLength) / 2)) * (((float) this.getTotalTicksLived()) / ((float) Util.getDinoByID(this.creatureID).ticksToAdulthood))) / ((Util.getDinoByID(this.creatureID).maxHeight + Util.getDinoByID(this.creatureID).maxLength) / 2))));
		} else {
			this.dataWatcher.updateObject(12, Float.valueOf((float) (this.getGeneticQuality())));
		}
	}

	/** Returns how many ticks this entity has lived. */
	public int getTotalTicksLived() {
		return this.ticksExisted;
	}

	/** Resets the ticks that this entity has lived (Client only). */
	private void setTicksExisted(int ticks) {
		this.ticksExisted = ticks;
	}

	@Override
	public void onLivingUpdate() {
		// System.out.println("Test: ");
		if (this.getTotalTicksLived() < (Util.getDinoByID(this.creatureID).ticksToAdulthood + 1) && this.growthStageList.contains((int) this.getTotalTicksLived())) {
			if (this.getGrowthStage() < 120) {
				this.setGrowthStage((byte) (this.getGrowthStage() + 1));
			}
			this.setBouningBox();
			if (!this.worldObj.isRemote) {
				this.updateCreatureData(this.getTotalTicksLived());
			} else {
				this.setCreatureSize();
			}
		}
		super.onLivingUpdate();
	}

	/** Force the creature to grow a specific value if it is possible. */
	public void forceCreatureGrowth(EntityPlayer player, ItemStack itemStack, byte growthIncrease) {
		if (this.getGrowthStage() + growthIncrease <= 120) {
			if (!player.capabilities.isCreativeMode) {
				itemStack.stackSize--;
				if (itemStack.stackSize <= 0) {
					itemStack = (ItemStack) null;
				}
			}
			this.setGrowthStage((byte) (this.getGrowthStage() + growthIncrease));
			this.setTicksExisted(Util.getDinoByID(this.creatureID).ticksToAdulthood * this.getGrowthStage() / 120);
			if (!this.worldObj.isRemote) {
				this.updateCreatureData(this.getTotalTicksLived());
			} else {
				this.setCreatureSize();
			}
		} else {
			if (!this.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText("This creature cannot grow anymore."));
			}
		}
	}

	/** Force the creature to grow to its maximum size. */
	public void setFullGrowth() {
		if (!this.isCreatureAdult()) {
			this.setGrowthStage((byte) (120));
			this.setTicksExisted(Util.getDinoByID(this.creatureID).ticksToAdulthood * this.getGrowthStage() / 120);
			if (!this.worldObj.isRemote) {
				this.updateCreatureData(this.getTotalTicksLived());
			} else {
				this.setCreatureSize();
			}
		}
	}

	@Override
	public boolean interact(EntityPlayer player) {
		if (player.getHeldItem() != (ItemStack) null) {
			if (player.getHeldItem().getItem() instanceof Analyzer) {
				this.showStatus();
			} else if (player.getHeldItem().getItem().equals(Items.golden_carrot)) {
				this.forceCreatureGrowth(player, player.getHeldItem(), (byte) 5);
			}
		}
		return super.interact(player);
	}

	/** Sets the creature into the analyzer and show its status. */
	@SideOnly(Side.CLIENT)
	private void showStatus() {
		// FMLClientHandler.instance().getClient().thePlayer.openGui(BygoneAge.instance,
		// BygoneAgeGuiInformation.ANALYZER.getGuiId(), this.worldObj, 0, 0, 0);
	}

	/** Returns the creature ID. */
	public byte getCreatureID() {
		return this.creatureID;
	}

	/** Returns the creature Name. */
	public String getCreatureName() {
		return Util.getDinoByID(this.creatureID).creatureName;
	}

	/** Sets the creature genetic data. */
	public void setGenetics(int dnaQuality) {
		switch (dnaQuality) {
			case 50:
				this.setGeneticQuality(0.8F + 0.15F * this.rand.nextFloat());
				break;
			case 75:
				this.setGeneticQuality(0.95F + 0.10F * this.rand.nextFloat());
				break;
			case 100:
				this.setGeneticQuality(1.05F + 0.15F * this.rand.nextFloat());
				break;
			default:
				this.setGeneticQuality(0.8F + 0.4F * this.rand.nextFloat());
		}
	}

	/** Sets the creature genetic data. */
	public void setRandomGenetics() {
		switch (this.rand.nextInt(3)) {
			case 0:
				this.setGeneticQuality(0.8F + 0.15F * this.rand.nextFloat());
				break;
			case 1:
				this.setGeneticQuality(0.95F + 0.10F * this.rand.nextFloat());
				break;
			case 2:
				this.setGeneticQuality(1.05F + 0.15F * this.rand.nextFloat());
				break;
			default:
				this.setGeneticQuality(0.8F + 0.4F * this.rand.nextFloat());
		}
	}

	/** Returns how many ticks this creature requires to reach adulthood. */
	public float getAdultAge() {
		return Util.getDinoByID(this.creatureID).ticksToAdulthood;
	}

	/** Returns true if the creature is considered an adult. */
	public boolean isCreatureAdult() {
		return this.getTotalTicksLived() >= Util.getDinoByID(this.creatureID).adultAge * this.getAdultAge();
	}

	/**
	 * Returns true if the creature is older than a certain percentage of the
	 * ticks for adulthood.
	 */
	public boolean isCreatureOlderThan(float percentage) {
		return this.getTotalTicksLived() >= percentage * Util.getDinoByID(this.creatureID).ticksToAdulthood;
	}

	/** Returns the creature hit box. */
	public float getXZBouningBox() {
		return (float) this.bBoxXZ;
	}

	/** Returns the creature hit box. */
	public float getYBouningBox() {
		return (float) this.bBoxY;
	}

	/**
	 * Returns the current health of the creature. This is just a information
	 * for the user.
	 */
	public double getCreatureCurrentHealth() {
		return (double) ((int) (100 * this.getHealth())) / 100;
	}

	/**
	 * Returns the health of the creature. This is just a information for the
	 * user.
	 */
	public double getCreatureHealth() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue())) / 100;
	}

	public int getCreatureHealthScaled(int i) {
		return (int) ((this.getCreatureHealth() * i) / (1.2F * Util.getDinoByID(this.creatureID).maxHealth));
	}

	/**
	 * Returns the speed of the creature. This is just a information for the
	 * user.
	 */
	public double getCreatureAttack() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue())) / 100;
	}

	public int getCreatureAttackScaled(int i) {
		return (int) ((this.getCreatureAttack() * i) / (1.2F * Util.getDinoByID(this.creatureID).maxStrength));
	}

	/**
	 * Returns the speed of the creature. This is just a information for the
	 * user.
	 */
	public double getCreatureSpeed() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue())) / 100;
	}

	public int getCreatureSpeedScaled(int i) {
		return (int) ((this.getCreatureSpeed() * i) / (1.2F * Util.getDinoByID(this.creatureID).maxSpeed));
	}

	/**
	 * Returns the speed of the creature. This is just a information for the
	 * user.
	 */
	public double getCreatureKnockback() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue())) / 100;
	}

	/**
	 * Returns the knock back of the creature. This is just a information for
	 * the user.
	 */
	public int getCreatureKnockbackScaled(int i) {
		return (int) ((this.getCreatureKnockback() * i) / (1.2F * Util.getDinoByID(this.creatureID).maxKnockback));
	}

	/**
	 * Returns the length of the creature. This is just a information for the
	 * user.
	 */
	public float getCreatureLength() {
		return (float) ((int) (100 * this.length)) / 100;
	}

	public int getCreatureLengthScaled(int i) {
		return (int) ((this.getCreatureLength() * i) / (1.2F * Util.getDinoByID(this.creatureID).maxLength));
	}

	/**
	 * Returns the height of the creature. This is just a information for the
	 * user.
	 */
	public float getCreatureHeight() {
		return (float) ((int) (100 * this.height)) / 100;
	}

	public int getCreatureHeightScaled(int i) {
		return (int) ((this.getCreatureHeight() * i) / (1.2F * Util.getDinoByID(this.creatureID).maxHeight));
	}

	/** Returns true if the creature is a male. */
	public boolean isMale() {
		if (this.getCreatureGender()) {
			return true;
		} else {
			return false;
		}
	}

	/** Returns the creature gender as String. */
	public String getCreatureGenderString() {
		if (this.getCreatureGender()) {
			return "Male";
		} else {
			return "Female";
		}
	}

	/** Returns the creature gender as a number. 0 is female and 1 is male. */
	public boolean getCreatureGender() {
		return this.gender;
	}

	/** Sets the creature gender. 0 is female and 1 is male. */
	public void setCreatureGender(boolean sex) {
		this.gender = sex;
	}

	/** Sets the creature texture. */
	private void setCreatureTexture(byte textureID) {
		this.texture = textureID;
	}

	/** Sets the creature texture. */
	public byte getCreatureTexture() {
		return this.texture;
	}

	/**
	 * Sets the length of the creature. This is just a information for the user.
	 */
	public void setCreatureLength() {
		if (this.getTotalTicksLived() <= Util.getDinoByID(this.creatureID).ticksToAdulthood) {
			this.length = (float) (this.getGeneticQuality() * (Util.getDinoByID(this.creatureID).minLength + (this.getTotalTicksLived() * (Util.getDinoByID(this.creatureID).maxLength - Util.getDinoByID(this.creatureID).minLength) / Util.getDinoByID(this.creatureID).ticksToAdulthood)));
		} else {
			this.length = (float) (this.getGeneticQuality() * (Util.getDinoByID(this.creatureID).maxLength));
		}
	}

	/**
	 * Sets the height of the creature. This is just a information for the user.
	 */
	public void setCreatureHeight() {
		if (this.getTotalTicksLived() <= Util.getDinoByID(this.creatureID).ticksToAdulthood) {
			this.height = (float) (this.getGeneticQuality() * (Util.getDinoByID(this.creatureID).minHeight + (this.getTotalTicksLived() * (Util.getDinoByID(this.creatureID).maxHeight - Util.getDinoByID(this.creatureID).minHeight) / Util.getDinoByID(this.creatureID).ticksToAdulthood)));
		} else {
			this.height = (float) (this.getGeneticQuality() * (Util.getDinoByID(this.creatureID).maxHeight));
		}
	}

	/** Returns how many days this entity has lived. */
	public int getCreatureAgeInDays() {
		return this.getTotalTicksLived() / 24000;
	}

	/** Returns how many months this entity has lived. */
	public int getCreatureAgeInMonths() {
		return this.getTotalTicksLived() / (720000);
	}

	/** Returns how many years this entity has lived. */
	public int getCreatureAgeInYears() {
		return this.getTotalTicksLived() / (8640000);
	}

	/**
	 * Returns how many days, and/or months, and/or years this entity has lived.
	 * Note: returns string value.
	 */
	public String getCreatureAgeString() {
		byte years = (byte) getCreatureAgeInYears();
		byte months = (byte) (getCreatureAgeInMonths() - 12 * this.getCreatureAgeInYears());
		byte days = (byte) (getCreatureAgeInDays() - 30 * this.getCreatureAgeInMonths());
		String yearString = " years, ";
		String monthString = " months, ";
		String dayString = " days";
		if (years <= 1) {
			yearString = " year, ";
		}
		if (months <= 1) {
			monthString = " month, ";
		}
		if (days <= 1) {
			dayString = " day";
		}
		if (years <= 0) {
			if (months <= 0) {
				return (String.valueOf(days) + dayString);
			} else {
				return (String.valueOf(months) + monthString + String.valueOf(days) + dayString);
			}
		} else {
			if (months <= 0) {
				return (String.valueOf(years) + yearString + String.valueOf(days) + dayString);
			} else {
				return (String.valueOf(years) + yearString + String.valueOf(months) + monthString + String.valueOf(days) + dayString);
			}
		}
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	public float getEyeHeight() {
		return this.getCreatureHeight() * 0.85F;
	}

	@Override
	public int getTalkInterval() {
		return 200;
	}

	@Override
	protected float getSoundPitch() {
		return Float.valueOf(1.0F + 0.8F * (120 - this.getGrowthStage()) / 120);
	}

	@Override
	protected float getSoundVolume() {
		return Float.valueOf(0.7F + 0.3F * this.getGrowthStage() / 120);
	}

	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return (int) (1000 * this.getGrowthStage() / 120);
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
		if (animID != 0)
			animTick++;
		frame++;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("TicksExisted", this.getTotalTicksLived());
		compound.setFloat("GeneticQuality", this.getGeneticQuality());
		compound.setByte("Stage", this.getGrowthStage());
		compound.setBoolean("Gender", this.getCreatureGender());
		compound.setByte("Texture", this.getCreatureTexture());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setTicksExisted(compound.getInteger("TicksExisted"));
		this.setGeneticQuality(compound.getFloat("GeneticQuality"));
		this.resetGrowthStageList();
		this.setGrowthStage(compound.getByte("Stage"));
		this.setCreatureGender(compound.getBoolean("Gender"));
		this.setCreatureTexture(compound.getByte("Texture"));
		this.setCreatureLength();
		this.setCreatureHeight();
		this.setCreatureScale();
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeInt(this.ticksExisted);
		buffer.writeFloat(this.geneticQuality);
		buffer.writeFloat(this.bBoxXZ);
		buffer.writeFloat(this.bBoxY);
		buffer.writeBoolean(this.gender);
		buffer.writeByte(this.texture);
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		this.ticksExisted = additionalData.readInt();
		this.geneticQuality = additionalData.readFloat();
		this.bBoxXZ = additionalData.readFloat();
		this.bBoxY = additionalData.readFloat();
		this.gender = additionalData.readBoolean();
		this.texture = additionalData.readByte();
		this.setCreatureSize();
	}
}