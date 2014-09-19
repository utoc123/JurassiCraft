package com.rafamv.bygoneage.entity;

import io.netty.buffer.ByteBuf;

import java.util.HashSet;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.enums.BygoneAgeGuiInformation;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;
import com.rafamv.bygoneage.handler.BygoneAgeDNAHandler;
import com.rafamv.bygoneage.items.Analyzer;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityBygoneAgeCreature extends EntityCreature implements IEntityAdditionalSpawnData {

	public byte creatureID;
	protected float consideredAdult;
	protected final HashSet<Integer> growthStageList = new HashSet<Integer>();
	public float healthGeneticQuality;
	public float attackGeneticQuality;
	public float speedGeneticQuality;
	public float sizeGeneticQuality;
	public boolean gender;
	public String geneticCode;
	public float height;
	public float length;
	public float bBoxXZ;
	public float bBoxY;
	private static final int KEY_SCALE = 14;
	private static final int KEY_GROWTH_STAGE = 17;
	private static final int KEY_COLOR = 18;

	public EntityBygoneAgeCreature(World world, byte id, float maxChildAge) {
		super(world);
		if (id >= 0) {
			this.creatureID = id;
		} else {
			this.creatureID = 0;
		}
		if (this.getSizeGeneticQuality() <= 0) {
			this.setSizeGeneticQuality(1.0F);
		}
		if (this.getHealthGeneticQuality() <= 0) {
			this.setHealthGeneticQuality(1.0F);
		}
		if (this.getAttackGeneticQuality() <= 0) {
			this.setAttackGeneticQuality(1.0F);
		}
		if (this.getSpeedGeneticQuality() <= 0) {
			this.setSpeedGeneticQuality(1.0F);
		}
		this.consideredAdult = maxChildAge * BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime();
		this.resetGrowthStageList();
		this.setInitCreatureData();
		if (this.worldObj.isRemote) {
			this.setCreatureColor();
			this.setCreatureSize();
			this.setCreatureScale();
		} else {
			this.setHalfOfTheCreatureSize();
		}
	}

	@Override
	public float getRenderSizeModifier() {
		return 1.0F;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(this.KEY_SCALE, Float.valueOf((float) ((((this.length / BygoneAgeMobsInformation.values()[creatureID].getMaxLength()) * (this.height / BygoneAgeMobsInformation.values()[creatureID].getMaxHeight())) / 2))));
		this.dataWatcher.addObject(this.KEY_GROWTH_STAGE, Byte.valueOf((byte) (0)));
		this.dataWatcher.addObject(this.KEY_COLOR, Float.valueOf((float) (0)));
	}

	@Override
	public void onLivingUpdate() {
		if (this.getTotalTicksLived() < (BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime() + 1) && this.growthStageList.contains((int) this.getTotalTicksLived())) {
			if (this.getGrowthStage() < BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth()) {
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
		if (this.getGrowthStage() + growthIncrease < BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth()) {
			if (!player.capabilities.isCreativeMode) {
				itemStack.stackSize--;
				if (itemStack.stackSize <= 0) {
					itemStack = (ItemStack) null;
				}
			}
			this.setGrowthStage((byte) (this.getGrowthStage() + growthIncrease));
			this.setTicksExisted(BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime() * this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth());
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
			this.setGrowthStage((byte) (BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth()));
			this.setTicksExisted(BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime() * this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth());
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
		BygoneAge.creatureToAnalyze = this;
		FMLClientHandler.instance().getClient().thePlayer.openGui(BygoneAge.instance, BygoneAgeGuiInformation.ANALYZER.getGuiId(), this.worldObj, 0, 0, 0);
	}

	/** Updates the creature status, such as health, attack power, speed,
	 * knockback, and sizes. When it is called, the creature increases its
	 * growth stage, which has a maximum value. */
	@SideOnly(Side.CLIENT)
	private void updateCreatureData(int ticks) {
		double oldHealth = this.getCreatureHealth();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((int) ((this.getHealthGeneticQuality() * ticks * (BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxHealth() - BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinHealth()) / BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime()) + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinHealth()));
		double newHealth = this.getCreatureHealth();
		this.heal((float) (newHealth - oldHealth));
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(((this.getAttackGeneticQuality() * ticks * (BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxStrength() - BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinStrength()) / BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime()) + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinStrength()));
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(Double.valueOf(((this.getSpeedGeneticQuality() * ticks * (BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxSpeed() - BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinSpeed()) / BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime()) + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinSpeed())));
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(Double.valueOf(((ticks * (BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxKnockback() - BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinKnockback()) / BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime()) + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinKnockback())));
		this.setCreatureLength();
		this.setCreatureHeight();
		this.setCreatureScale();
		this.setHalfOfTheCreatureSize();
		this.setCreatureColor();
	}

	/** Sets the creature genetic data. */
	public void setGenetics(float healthGene, float attackGene, float speedGene, float sizeGene) {
		this.setHealthGeneticQuality(healthGene);
		this.setAttackGeneticQuality(attackGene);
		this.setSpeedGeneticQuality(speedGene);
		this.setSizeGeneticQuality(sizeGene);
		this.setCreatureColor();
	}

	/** Applies the creature attributes. Since this class extends EntityCreature,
	 * it does not have attack damage attribute. */
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	}

	/** Sets the creature initial status, such as health, attack power, speed,
	 * knockback, and sizes. */
	private void setInitCreatureData() {
		double oldHealth = this.getCreatureHealth();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getHealthGeneticQuality() * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinHealth());
		double newHealth = this.getCreatureHealth();
		this.heal((float) (newHealth - oldHealth));
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((this.getAttackGeneticQuality() * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinStrength()));
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((this.getSpeedGeneticQuality() * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinSpeed()));
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinKnockback());
		this.length = BygoneAgeMobsInformation.values()[creatureID].getMinLength();
		this.height = BygoneAgeMobsInformation.values()[creatureID].getMinHeight();
		this.setCreatureGender(this.rand.nextInt(2) > 0);
	}

	/** Returns the creature ID. */
	public byte getCreatureID() {
		return this.creatureID;
	}

	/** Returns the creature Name. */
	public String getCreatureName() {
		return BygoneAgeMobsInformation.values()[this.creatureID].getCreatureName();
	}

	/** Sets the creature genetic quality of health. Genetic quality is how much
	 * the entity varies in status. 1.0F is the base value. */
	private void setHealthGeneticQuality(float healthGQ) {
		this.healthGeneticQuality = healthGQ;
	}

	/** Returns the creature genetic quality of health. Genetic quality is how
	 * much the entity varies in status. 1.0F is the base value. */
	public float getHealthGeneticQuality() {
		return this.healthGeneticQuality;
	}

	/** Sets the creature genetic quality of attack power. Genetic quality is how
	 * much the entity varies in status. 1.0F is the base value. */
	private void setAttackGeneticQuality(float attackGQ) {
		this.attackGeneticQuality = attackGQ;
	}

	/** Returns the creature genetic quality of attack power. Genetic quality is
	 * how much the entity varies in status. 1.0F is the base value. */
	public float getAttackGeneticQuality() {
		return this.attackGeneticQuality;
	}

	/** Sets the creature genetic quality of speed. Genetic quality is how much
	 * the entity varies in status. 1.0F is the base value. */
	private void setSpeedGeneticQuality(float speedGQ) {
		this.speedGeneticQuality = speedGQ;
	}

	/** Returns the creature genetic quality of speed. Genetic quality is how
	 * much the entity varies in status. 1.0F is the base value. */
	public float getSpeedGeneticQuality() {
		return this.speedGeneticQuality;
	}

	/** Sets the creature genetic quality of size. Genetic quality is how much
	 * the entity varies in status. 1.0F is the base value. */
	public void setSizeGeneticQuality(float gene) {
		this.sizeGeneticQuality = gene;
	}

	/** Returns the creature genetic quality of size. Genetic quality is how much
	 * the entity varies in status. 1.0F is the base value. */
	public float getSizeGeneticQuality() {
		return (float) this.sizeGeneticQuality;
	}

	/** Checks if the creature has a genetic code. */
	public boolean hasGeneticCode() {
		return !(this.getGeneticCode() == null || this.getGeneticCode() == "");
	}

	/** Returns the creature genetic quality of speed. Genetic quality is how
	 * much the entity varies in status. 1.0F is the base value. */
	public String getGeneticCode() {
		return this.geneticCode;
	}

	/** Sets the creature genetic code. Genetic code is composed by an string
	 * (length 18) generated with parts of the original code. */
	public void setGeneticCode(String code) {
		this.geneticCode = code;
	}

	/** generates the creature genetic code from 4 different DNA's. Genetic code
	 * is composed by an string (length 18). */
	public void createGeneticCode(String dna1, String dna2, String dna3, String dna4) {
		if (!this.hasGeneticCode()) {
			String code = "";
			if (dna1.length() > 18) {
				dna1 = dna1.substring(0, 19);
				code = code + dna1.substring(0, 5);
			} else {
				code = code + dna1.substring(0, 5);
			}
			if (dna2.length() > 18) {
				dna2 = dna2.substring(0, 19);
				code = code + dna2.substring(5, 10);
			} else {
				code = code + dna2.substring(5, 10);
			}
			if (dna3.length() > 18) {
				dna3 = dna3.substring(0, 19);
				code = code + dna3.substring(10, 14);
			} else {
				code = code + dna3.substring(10, 14);
			}
			if (dna4.length() > 18) {
				dna4 = dna4.substring(0, 19);
				code = code + dna4.substring(14, 18);
			} else {
				code = code + dna4.substring(14, 18);
			}
			if (code.length() != 18) {
				code = BygoneAgeDNAHandler.generateNewRNA(18);
				System.out.println("Error: DNA created was not in the corrent length. New DNA code was generated: " + code);
				this.geneticCode = code;
			} else {
				this.geneticCode = code;
			}
		}
	}

	/** Returns the percentage of the full growth time which the creature is
	 * considered a child. */
	public float getAdultPercentage() {
		return consideredAdult;
	}

	/** Returns true if the creature is considered an adult. */
	public boolean isCreatureAdult() {
		return this.getTotalTicksLived() >= this.getAdultPercentage();
	}

	/** Returns true if the creature is considered an adolescent (half of the adult time). */
	public boolean isCreatureHalfAdult() {
		return (this.getTotalTicksLived() >= 0.5F * this.getAdultPercentage() && this.getTotalTicksLived() < this.getAdultPercentage());
	}
	
	/** Sets the percentage which the creature is considered a child. Usually 40%
	 * of the ticks for full growth. */
	public void setAdultPercentage(float adultAge) {
		this.consideredAdult = adultAge;
	}

	/** Returns what is the current growth stage of the creature. Used the scale
	 * some parameters, such as size. */
	public byte getGrowthStage() {
		return (byte) this.dataWatcher.getWatchableObjectByte(this.KEY_GROWTH_STAGE);
	}

	/** Sets what is the growth stage of the creature. */
	private void setGrowthStage(byte stage) {
		this.dataWatcher.updateObject(this.KEY_GROWTH_STAGE, Byte.valueOf((byte) (stage)));
	}

	/** Resets the growthStageList. This is a list of values (number of ticks)
	 * that represent when the creature will update its status. It is calculated
	 * depending on the enumeration 'BygoneAgeMobsInformation'. */
	public void resetGrowthStageList() {
		int maximumGrowthTime = BygoneAgeMobsInformation.values()[creatureID].getFullGrowthTime();
		byte timesOfGrowth = BygoneAgeMobsInformation.values()[creatureID].getTimesOfGrowth();
		this.growthStageList.add(1);
		for (byte i = 1; i < timesOfGrowth; i++) {
			this.growthStageList.add((int) ((maximumGrowthTime * i) / timesOfGrowth));
		}
		this.growthStageList.add(maximumGrowthTime);
	}

	/** Sets the scale of the creature depending on the age and genetic quality. */
	public void setCreatureScale() {
		if (this.getTotalTicksLived() < BygoneAgeMobsInformation.values()[creatureID].getFullGrowthTime()) {
			this.dataWatcher.updateObject(this.KEY_SCALE, Float.valueOf((float) (this.getSizeGeneticQuality() * (((BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinHeight() + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinLength()) / 2) + (((BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxHeight() + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxLength()) / 2) - ((BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinHeight() + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMinLength()) / 2)) * (((float) this.getTotalTicksLived()) / ((float) BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime()))) / ((BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxHeight() + BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxLength()) / 2))));
		} else {
			this.dataWatcher.updateObject(this.KEY_SCALE, Float.valueOf((float) (this.getSizeGeneticQuality())));
		}
	}

	/** Returns the scale of the creature depending on the age and genetic
	 * quality. */
	public float getCreatureScale() {
		return (float) this.dataWatcher.getWatchableObjectFloat(this.KEY_SCALE);
	}

	/** Sets the color parameter of the creature depending on the genetic
	 * quality. */
	public void setCreatureColor() {
		float color = (float) ((this.getSizeGeneticQuality() + this.getAttackGeneticQuality() + this.getHealthGeneticQuality() + this.getSpeedGeneticQuality()) / 10.0F);
		if (color > 1.0F) {
			color = 1.0F;
		} else if (color < 0.0F) {
			color = 0.0F;
		}
		this.dataWatcher.updateObject(this.KEY_COLOR, Float.valueOf(color));
	}

	/** Returns the color parameter of the creature depending on the age and
	 * genetic quality. */
	public float getCreatureColor() {
		return (float) this.dataWatcher.getWatchableObjectFloat(this.KEY_COLOR);
	}

	/** Returns the creature hit box. */
	public float getXZBouningBox() {
		return (float) this.bBoxXZ;
	}

	/** Returns the creature hit box. */
	public float getYBouningBox() {
		return (float) this.bBoxY;
	}

	/** Sets the creature xz and y hit box using genetic quality and growth
	 * stage. */
	public void setBouningBox() {
		this.bBoxXZ = this.getSizeGeneticQuality() * (BygoneAgeMobsInformation.values()[this.getCreatureID()].getXZcollisionBoxMin() + BygoneAgeMobsInformation.values()[this.getCreatureID()].getXZcollisionBoxVariation() * (((float) this.getGrowthStage()) / ((float) BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth())));
		this.bBoxY = this.getSizeGeneticQuality() * (BygoneAgeMobsInformation.values()[this.getCreatureID()].getYcollisionBoxMin() + BygoneAgeMobsInformation.values()[this.getCreatureID()].getYcollisionBoxVariation() * (((float) this.getGrowthStage()) / ((float) BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth())));
	}

	/** Returns the height of the creature eyes. */
	@Override
	public float getEyeHeight() {
		return this.getCreatureHeight() * 0.85F;
	}

	/** Returns the current health of the creature. This is just a information for the
	 * user. */
	public double getCreatureCurrentHealth() {
		return (double) ((int) (100 * this.getHealth())) / 100;
	}
	
	/** Returns the health of the creature. This is just a information for the
	 * user. */
	public double getCreatureHealth() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue())) / 100;
	}
	
	public int getCreatureHealthScaled(int i) {
		return (int) ((this.getCreatureHealth() * i) / (1.8F * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxHealth()));
	}

	/** Returns the speed of the creature. This is just a information for the
	 * user. */
	public double getCreatureAttack() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue())) / 100;
	}

	public int getCreatureAttackScaled(int i) {
		return (int) ((this.getCreatureAttack() * i) / (1.8F * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxStrength()));
	}

	/** Returns the speed of the creature. This is just a information for the
	 * user. */
	public double getCreatureSpeed() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue())) / 100;
	}

	/** Returns the speed of the creature. This is just a information for the
	 * user. */
	public double getCreatureKnockback() {
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue())) / 100;
	}

	public int getCreatureSpeedScaled(int i) {
		return (int) ((this.getCreatureSpeed() * i) / (1.8F * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxSpeed()));
	}

	public int getCreatureHeightScaled(int i) {
		return (int) ((this.getCreatureHeight() * i) / (1.8F * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxHeight()));
	}

	public int getCreatureLengthScaled(int i) {
		return (int) ((this.getCreatureLength() * i) / (1.8F * BygoneAgeMobsInformation.values()[this.getCreatureID()].getMaxLength()));
	}

	/** Returns how many ticks this entity has lived. */
	public int getTotalTicksLived() {
		return this.ticksExisted;
	}

	/** Resets the ticks that this entity has lived (Client only). */
	private void setTicksExisted(int ticks) {
		this.ticksExisted = ticks;
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

	/** Sets a new bounding box for the creature depending on its status. */
	protected final void setCreatureSize() {
		this.setBouningBox();
		super.setSize(this.getXZBouningBox(), this.getYBouningBox());
	}

	/** Sets a new bounding box for the creature depending on its status. This is the half of the original BB, to better fit in combat */
	protected final void setHalfOfTheCreatureSize() {
		this.setBouningBox();
		super.setSize(this.getXZBouningBox()/2.0F, this.getYBouningBox()/2.0F);
	}
	
	/** Sets the length of the creature. This is just a information for the user. */
	public void setCreatureLength() {
		if (this.getTotalTicksLived() <= BygoneAgeMobsInformation.values()[creatureID].getFullGrowthTime()) {
			this.length = (float) (this.getSizeGeneticQuality() * (BygoneAgeMobsInformation.values()[creatureID].getMinLength() + (this.getTotalTicksLived() * (BygoneAgeMobsInformation.values()[creatureID].getMaxLength() - BygoneAgeMobsInformation.values()[creatureID].getMinLength()) / BygoneAgeMobsInformation.values()[creatureID].getFullGrowthTime())));
		} else {
			this.length = (float) (this.getSizeGeneticQuality() * (BygoneAgeMobsInformation.values()[creatureID].getMaxLength()));
		}
	}

	/** Returns the length of the creature. This is just a information for the
	 * user. */
	public float getCreatureLength() {
		return (float) ((int) (100 * this.length)) / 100;
	}

	/** Sets the height of the creature. This is just a information for the user. */
	public void setCreatureHeight() {
		if (this.getTotalTicksLived() <= BygoneAgeMobsInformation.values()[creatureID].getFullGrowthTime()) {
			this.height = (float) (this.getSizeGeneticQuality() * (BygoneAgeMobsInformation.values()[creatureID].getMinHeight() + (this.getTotalTicksLived() * (BygoneAgeMobsInformation.values()[creatureID].getMaxHeight() - BygoneAgeMobsInformation.values()[creatureID].getMinHeight()) / BygoneAgeMobsInformation.values()[creatureID].getFullGrowthTime())));
		} else {
			this.height = (float) (this.getSizeGeneticQuality() * (BygoneAgeMobsInformation.values()[creatureID].getMaxHeight()));
		}
	}

	/** Returns the height of the creature. This is just a information for the
	 * user. */
	public float getCreatureHeight() {
		return (float) ((int) (100 * this.height)) / 100;
	}

	protected ItemStack createDNACodeForItemStack(ItemStack itemStack) {
		NBTTagCompound compound = new NBTTagCompound();
		if (this.hasGeneticCode()) {
			compound.setString("RNAHelix1", this.getGeneticCode());
			compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
		} else {
			compound.setString("RNAHelix1", BygoneAgeDNAHandler.generateNewRNA(18));
			compound.setString("RNAHelix2", BygoneAgeDNAHandler.createNewRNAFrom(compound.getString("RNAHelix1")));
		}
		itemStack.setTagCompound(compound);
		return itemStack;
	}

	protected EntityItem dropItemStackWithDNA(ItemStack itemStackWithDNACode) {
		return this.entityDropItem(itemStackWithDNACode, 0.0F);
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

	/** Returns how many days, and/or months, and/or years this entity has lived.
	 * Note: returns string value. */
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
	public int getTalkInterval() {
		return 200;
	}

	@Override
	protected float getSoundPitch() {
		return Float.valueOf(0.7F + 0.3F * this.getSizeGeneticQuality() + 0.3F * (BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth() - this.getGrowthStage()) / BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth());
	}

	@Override
	protected float getSoundVolume() {
		return Float.valueOf(0.7F + 0.3F * this.getGrowthStage() / BygoneAgeMobsInformation.values()[this.getCreatureID()].getTimesOfGrowth());
	}

	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		if (this.getTotalTicksLived() > BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime()) {
			return (int) (1 + (this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue() / 4));
		} else {
			return (int) (1 + (this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue() * this.getTotalTicksLived()) / (4 * BygoneAgeMobsInformation.values()[this.getCreatureID()].getFullGrowthTime()));
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("TicksExisted", this.getTotalTicksLived());
		compound.setString("GeneticCode", this.getGeneticCode());
		compound.setFloat("HealthGeneticQuality", this.getHealthGeneticQuality());
		compound.setFloat("AttackGeneticQuality", this.getAttackGeneticQuality());
		compound.setFloat("SpeedGeneticQuality", this.getSpeedGeneticQuality());
		compound.setFloat("SizeGeneticQuality", this.getSizeGeneticQuality());
		compound.setBoolean("Gender", this.getCreatureGender());
		compound.setByte("Stage", this.getGrowthStage());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setTicksExisted(compound.getInteger("TicksExisted"));
		this.setGeneticCode(compound.getString("GeneticCode"));
		this.setHealthGeneticQuality(compound.getFloat("HealthGeneticQuality"));
		this.setAttackGeneticQuality(compound.getFloat("AttackGeneticQuality"));
		this.setSpeedGeneticQuality(compound.getFloat("SpeedGeneticQuality"));
		this.setSizeGeneticQuality(compound.getFloat("SizeGeneticQuality"));
		this.setCreatureGender(compound.getBoolean("Gender"));
		this.setCreatureColor();
		this.resetGrowthStageList();
		this.setGrowthStage(compound.getByte("Stage"));
		this.setCreatureScale();
		this.setCreatureLength();
		this.setCreatureHeight();
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeInt(this.ticksExisted);
		buffer.writeFloat(this.healthGeneticQuality);
		buffer.writeFloat(this.attackGeneticQuality);
		buffer.writeFloat(this.speedGeneticQuality);
		buffer.writeFloat(this.sizeGeneticQuality);
		buffer.writeFloat(this.consideredAdult);
		buffer.writeFloat(this.bBoxXZ);
		buffer.writeFloat(this.bBoxY);
		buffer.writeBoolean(this.gender);
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		this.ticksExisted = additionalData.readInt();
		this.healthGeneticQuality = additionalData.readFloat();
		this.attackGeneticQuality = additionalData.readFloat();
		this.speedGeneticQuality = additionalData.readFloat();
		this.sizeGeneticQuality = additionalData.readFloat();
		this.consideredAdult = additionalData.readFloat();
		this.bBoxXZ = additionalData.readFloat();
		this.bBoxY = additionalData.readFloat();
		this.gender = additionalData.readBoolean();
		this.setCreatureSize();
	}
}