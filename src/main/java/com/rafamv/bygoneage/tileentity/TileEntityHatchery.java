package com.rafamv.bygoneage.tileentity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.rafamv.bygoneage.entity.EntityBygoneAgeCreature;
import com.rafamv.bygoneage.entity.creatures.EntityArsinoitherium;
import com.rafamv.bygoneage.entity.creatures.EntityBasilosaurus;
import com.rafamv.bygoneage.entity.creatures.EntityDeinotherium;
import com.rafamv.bygoneage.entity.creatures.EntityLeptictidium;
import com.rafamv.bygoneage.entity.creatures.EntityMammoth;
import com.rafamv.bygoneage.entity.creatures.EntityMoeritherium;
import com.rafamv.bygoneage.entity.creatures.EntityTitanisWalleri;
import com.rafamv.bygoneage.entity.creatures.EntityUintatherium;
import com.rafamv.bygoneage.enums.BygoneAgeFoodInformation;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;
import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;
import com.rafamv.bygoneage.handler.BygoneAgeDNAHandler;

public class TileEntityHatchery extends TileEntity implements ISidedInventory, IInventory {

	private Random random;
	private ItemStack[] slots = new ItemStack[8];
	private short hatcheryTime;
	private short hatcherySpeed;
	private byte embryoStage;
	private byte creatureID;
	private byte waterStored;
	private short proximateValue;
	private short mineralValue;
	private short vitaminValue;
	private short lipidValue;
	private final short maxValue = 3000;
	public final Map<Short, Byte> growthRateList = new HashMap<Short, Byte>();
	private float creatureSize;
	private boolean shouldUpdate;

	public TileEntityHatchery() {
		this.random = new Random();
		this.hatcherySpeed = 100;
		this.creatureID = -1;
		this.waterStored = 0;
		this.hatcheryTime = 0;
		this.proximateValue = 0;
		this.mineralValue = 0;
		this.vitaminValue = 0;
		this.lipidValue = 0;
		this.creatureSize = 0.0F;
		this.embryoStage = 0;
	}

	/** Returns the id for the rendering. */
	public byte getEmbryoID() {
		return this.creatureID;
	}

	/** Returns the current hatchery time. */
	public void setHatcheryTime(short time) {
		this.hatcheryTime = time;
	}

	/** Returns the current hatchery time. */
	public int getHatcheryTime() {
		return this.hatcheryTime;
	}

	public float getCreatureSize() {
		return this.creatureSize;
	}

	public void setCreatureSize(float time, float speed) {
		if (speed > 0) {
			this.creatureSize = time / speed;
		} else {
			this.creatureSize = 0.0F;
		}
	}

	/** Sets which stage the creature is. It is used to render the right model. */
	public void setEmbryoStage(short time) {
		this.embryoStage = growthRateList.get(time);
	}

	/** Returns the current stage of the creature. */
	public byte getEmbryoStage() {
		return this.embryoStage;
	}

	/** Returns the current water stored. */
	public byte getWaterStored() {
		return this.waterStored;
	}

	/** Returns true if there is water stored. */
	public boolean hasWater() {
		return (this.waterStored > 0);
	}

	/** Returns the current proximate value. */
	public int getProximateValue() {
		return this.proximateValue;
	}

	/** Returns true if there is proximate stored. */
	public boolean hasProximate() {
		return (this.proximateValue > 0);
	}

	/** Returns the current minerals value. */
	public int getMineralValue() {
		return this.mineralValue;
	}

	/** Returns true if there is mineral stored. */
	public boolean hasMineral() {
		return (this.mineralValue > 0);
	}

	/** Returns the current vitamin value. */
	public int getVitaminValue() {
		return this.vitaminValue;
	}

	/** Returns true if there is vitamin stored. */
	public boolean hasVitamin() {
		return (this.vitaminValue > 0);
	}

	/** Returns the current lipid value. */
	public int getLipidValue() {
		return this.lipidValue;
	}

	/** Returns true if there is lipid stored. */
	public boolean hasLipid() {
		return (this.lipidValue > 0);
	}

	/** Sets the water value. */
	public void setWaterStored(byte water) {
		this.waterStored = water;
	}

	/** Sets the current proximate value. */
	public void setProximateValue(short proximate) {
		this.proximateValue = proximate;
	}

	/** Sets the current mineral value. */
	public void setMineralValue(short mineral) {
		this.mineralValue = mineral;
	}

	/** Sets the current vitamin value. */
	public void setVitaminValue(short vitamin) {
		this.vitaminValue = vitamin;
	}

	/** Sets the current lipid value. */
	public void setLipidValue(short lipid) {
		this.lipidValue = lipid;
	}

	/** Returns a percentage of the water stored scaled for X value. */
	public int getWaterStoredProgressScaled(int i) {
		return (this.waterStored * i) / 3;
	}

	/** Returns a percentage of the hatchery process scaled for X value. */
	public int getHatcheryTimeProgressScaled(int i) {
		if (this.hatcherySpeed <= 0) {
			this.hatcherySpeed = 100;
		}
		return (this.hatcheryTime * i) / this.hatcherySpeed;
	}

	/** Returns a percentage of the proximate value scaled for X value. */
	public int getProximateBarScaled(int i) {
		return (this.proximateValue * i) / this.maxValue;
	}

	/** Returns a percentage of the mineral value scaled for X value. */
	public int getMineralBarScaled(int i) {
		return (this.mineralValue * i) / this.maxValue;
	}

	/** Returns a percentage of vitamins scaled for X value. */
	public int getVitaminBarScaled(int i) {
		return (this.vitaminValue * i) / this.maxValue;
	}

	/** Returns a percentage of lipids scaled for X value. */
	public int getLipidBarScaled(int i) {
		return (this.lipidValue * i) / this.maxValue;
	}

	/** Returns true if the hatchery time is larger than 0. */
	public boolean isHatching() {
		return (this.hatcheryTime > 0);
	}

	/** Returns true if the machine can consume the water bucket at slot[0]. */
	private boolean canCansumeWaterBucket() {
		if (this.slots[0] != (ItemStack) null) {
			if (this.slots[0].getItem() == Items.water_bucket) {
				if (this.slots[1] == (ItemStack) null) {
					return true;
				} else if (this.slots[1].getItem() == Items.bucket) {
					return true;
				}
			}
		}
		return false;
	}

	/** Consumes water bucket from slot[0] if there is space for more water. */
	private void consumeWaterBucket() {
		if (!this.worldObj.isRemote) {
			if ((this.getWaterStored() + 1) > 3) {
				return;
			} else {
				this.slots[0].stackSize--;
				if (this.slots[0].stackSize <= 0) {
					this.slots[0] = (ItemStack) null;
				}
				this.setWaterStored((byte) (this.getWaterStored() + 1));
				if (this.slots[1] == (ItemStack) null) {
					ItemStack waterBucket = new ItemStack(Items.bucket);
					this.slots[1] = waterBucket;
				} else {
					this.slots[1].stackSize++;
				}
			}
		}
	}

	/** Returns true if the machine can consume food. */
	private boolean canCansumeFood() {
		if (this.slots[7] == (ItemStack) null) {
			return false;
		} else {
			if ((proximateValue < maxValue) || (mineralValue < maxValue) || (vitaminValue < maxValue) || (lipidValue < maxValue)) {
				if (BygoneAgeFoodInformation.FOODLIST.containsKey(this.slots[7].getItem())) {
					return true;
				}
			}
			return false;
		}
	}

	/** Consumes food from slot[7] if it is valid. */
	private void consumeFood() {
		if (!worldObj.isRemote) {
			int id = BygoneAgeFoodInformation.FOODLIST.get(this.slots[7].getItem());
			if (this.slots[7].getItem() instanceof ItemBucketMilk) {
				this.slots[7] = (ItemStack) null;
				this.slots[7] = new ItemStack(Items.bucket);
			} else {
				this.slots[7].stackSize--;
				if (this.slots[7].stackSize <= 0) {
					this.slots[7] = (ItemStack) null;
				}
			}
			if (proximateValue < maxValue) {
				proximateValue = (short) (proximateValue + (800 + random.nextInt(201)) * (BygoneAgeFoodInformation.values()[id].getProximateValueFrom()));
				if (proximateValue > maxValue) {
					proximateValue = maxValue;
				}
			}
			if (mineralValue < maxValue) {
				mineralValue = (short) (mineralValue + (900 + random.nextInt(101)) * (BygoneAgeFoodInformation.values()[id].getMineralValueFrom()));
				if (mineralValue > maxValue) {
					mineralValue = maxValue;
				}
			}
			if (vitaminValue < maxValue) {
				vitaminValue = (short) (vitaminValue + (900 + random.nextInt(101)) * (BygoneAgeFoodInformation.values()[id].getVitaminValueFrom()));
				if (vitaminValue > maxValue) {
					vitaminValue = maxValue;
				}
			}
			if (lipidValue < maxValue) {
				lipidValue = (short) (lipidValue + (980 + random.nextInt(101)) * (BygoneAgeFoodInformation.values()[id].getLipidValueFrom()));
				if (lipidValue > maxValue) {
					lipidValue = maxValue;
				}
			}
		}
	}

	/** Returns true if the machine can hatch certain creature. */
	private boolean canHatch() {
		if (this.slots[2] != null && this.slots[3] != null && this.slots[4] != null && this.slots[5] != null && this.slots[6] != null) {
			if (this.slots[3].hasTagCompound() && this.slots[4].hasTagCompound() && this.slots[5].hasTagCompound() && this.slots[6].hasTagCompound()) {
				if (this.slots[2].getTagCompound().hasKey("CreatureName") && this.slots[3].getTagCompound().hasKey("CreatureName") && this.slots[4].getTagCompound().hasKey("CreatureName") && this.slots[5].getTagCompound().hasKey("CreatureName") && this.slots[6].getTagCompound().hasKey("CreatureName")) {
					if (this.slots[2].getTagCompound().hasKey("Centrifugated") && this.slots[3].getTagCompound().hasKey("Centrifugated") && this.slots[4].getTagCompound().hasKey("Centrifugated") && this.slots[5].getTagCompound().hasKey("Centrifugated") && this.slots[6].getTagCompound().hasKey("Centrifugated")) {
						if (this.slots[2].getTagCompound().hasKey("RNAHelix1") && this.slots[3].getTagCompound().hasKey("RNAHelix1") && this.slots[4].getTagCompound().hasKey("RNAHelix1") && this.slots[5].getTagCompound().hasKey("RNAHelix1") && this.slots[6].getTagCompound().hasKey("RNAHelix1")) {
							if (this.slots[2].getTagCompound().hasKey("RNAHelix2") && this.slots[3].getTagCompound().hasKey("RNAHelix2") && this.slots[4].getTagCompound().hasKey("RNAHelix2") && this.slots[5].getTagCompound().hasKey("RNAHelix2") && this.slots[6].getTagCompound().hasKey("RNAHelix2")) {
								HashSet dnaNames = new HashSet<String>();
								String dnaMotherCreature = "";
								String dnaMother = this.slots[2].getTagCompound().getString("CreatureName");
								for (int i = 0; i < 4; i++) {
									dnaNames.add(this.slots[3 + i].getTagCompound().getString("CreatureName"));
								}
								if (dnaNames.size() == 1) {
									dnaMotherCreature = BygoneAgeGeneticsInformation.MOTHERDNALIST.get(dnaNames.toString().substring(1, (dnaNames.toString().length() - 1)));
									creatureID = (byte) BygoneAgeGeneticsInformation.CREATUREDNALIST.get(dnaNames.toString().substring(1, (dnaNames.toString().length() - 1)));
								} else {
									return false;
								}
								if (dnaMother.equals(dnaMotherCreature) || dnaMother.equals(dnaNames.toString().substring(1, (dnaNames.toString().length() - 1)))) {
									if (proximateValue < BygoneAgeGeneticsInformation.values()[creatureID].getMinimumProximate()) {
										return false;
									}
									if (mineralValue < BygoneAgeGeneticsInformation.values()[creatureID].getMinimumMinerals()) {
										return false;
									}
									if (vitaminValue < BygoneAgeGeneticsInformation.values()[creatureID].getMinimumvitamins()) {
										return false;
									}
									if (lipidValue < BygoneAgeGeneticsInformation.values()[creatureID].getMinimumLipids()) {
										return false;
									}
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	/** Creates the specific creature for the current DNA setup. */
	private void hatchCreature() {
		if (!canHatch()) {
			return;
		} else {
			if (this.slots[3].hasTagCompound()) {
				if (this.slots[3].getTagCompound().hasKey("CreatureName")) {
					String creatureName = this.slots[3].getTagCompound().getString("CreatureName");
					if ((creatureName.equals(BygoneAgeGeneticsInformation.CHICKEN.getCreatureName())) || (creatureName.equals(BygoneAgeGeneticsInformation.SHEEP.getCreatureName())) || (creatureName.equals(BygoneAgeGeneticsInformation.PIG.getCreatureName())) || (creatureName.equals(BygoneAgeGeneticsInformation.COW.getCreatureName()))) {
						EntityLiving creatureVanilla = (EntityLiving) selectCreatureVanilla(this.worldObj);
						selectValidPosition(creatureVanilla);
						creatureVanilla.rotationYawHead = creatureVanilla.rotationYaw;
						creatureVanilla.renderYawOffset = creatureVanilla.rotationYaw;
						this.worldObj.spawnEntityInWorld(creatureVanilla);
						creatureVanilla.playLivingSound();
					} else {
						EntityBygoneAgeCreature creature = (EntityBygoneAgeCreature) selectCreatureBygoneAge(this.worldObj);
						selectValidPosition(creature);
						creature.rotationYawHead = creature.rotationYaw;
						creature.renderYawOffset = creature.rotationYaw;
						this.worldObj.spawnEntityInWorld(creature);
						creature.playLivingSound();
					}
				}
			}
			this.setHatcheryTime((short) 0);
			this.setWaterStored((byte) 0);
			this.proximateValue = (short) (proximateValue - BygoneAgeGeneticsInformation.values()[creatureID].getMinimumProximate());
			this.mineralValue = (short) (mineralValue - BygoneAgeGeneticsInformation.values()[creatureID].getMinimumMinerals());
			this.vitaminValue = (short) (vitaminValue - BygoneAgeGeneticsInformation.values()[creatureID].getMinimumvitamins());
			this.lipidValue = (short) (lipidValue - BygoneAgeGeneticsInformation.values()[creatureID].getMinimumLipids());

			for (int i = 2; i < 7; i++) {
				this.slots[i].stackSize--;
				if (this.slots[i].stackSize <= 0) {
					this.slots[i] = (ItemStack) null;
				}
			}
		}
	}

	/** Returns a vanilla creature, such as chicken, sheep, pig, or cow. */
	private Entity selectCreatureVanilla(World world) {
		Entity creature = null;
		String mobName = this.slots[2].getTagCompound().getString("CreatureName");
		if (mobName.equals(BygoneAgeGeneticsInformation.CHICKEN.getCreatureName())) {
			creature = new EntityChicken(world);
		} else if (mobName.equals(BygoneAgeGeneticsInformation.SHEEP.getCreatureName())) {
			creature = new EntitySheep(world);
		} else if (mobName.equals(BygoneAgeGeneticsInformation.PIG.getCreatureName())) {
			creature = new EntityPig(world);
		} else if (mobName.equals(BygoneAgeGeneticsInformation.COW.getCreatureName())) {
			creature = new EntityCow(world);
		} else {
			creature = new EntityChicken(world);
		}
		return creature;
	}

	/** Returns a bygone age creature, and sets its genetic code. */
	private EntityBygoneAgeCreature selectCreatureBygoneAge(World world) {
		EntityBygoneAgeCreature creature = null;
		float dnaQualityMother = BygoneAgeDNAHandler.calculateDNAQuality(slots[2].getTagCompound().getString("RNAHelix1"), slots[2].getTagCompound().getString("RNAHelix2"));
		float dnaQualityCreature1 = BygoneAgeDNAHandler.calculateDNAQuality(slots[3].getTagCompound().getString("RNAHelix1"), slots[3].getTagCompound().getString("RNAHelix2"));
		float dnaQualityCreature2 = BygoneAgeDNAHandler.calculateDNAQuality(slots[4].getTagCompound().getString("RNAHelix1"), slots[4].getTagCompound().getString("RNAHelix2"));
		float dnaQualityCreature3 = BygoneAgeDNAHandler.calculateDNAQuality(slots[5].getTagCompound().getString("RNAHelix1"), slots[5].getTagCompound().getString("RNAHelix2"));
		float dnaQualityCreature4 = BygoneAgeDNAHandler.calculateDNAQuality(slots[6].getTagCompound().getString("RNAHelix1"), slots[6].getTagCompound().getString("RNAHelix2"));
		float dnaMother = mixDNAQualities(dnaQualityMother, 6, dnaQualityCreature1, 1, dnaQualityCreature2, 1, dnaQualityCreature3, 1, dnaQualityCreature4, 1);
		float dna1 = mixDNAQualities(dnaQualityMother, 2, dnaQualityCreature1, 5, dnaQualityCreature2, 2, dnaQualityCreature3, 2, dnaQualityCreature4, 2);
		float dna2 = mixDNAQualities(dnaQualityMother, 2, dnaQualityCreature1, 2, dnaQualityCreature2, 5, dnaQualityCreature3, 2, dnaQualityCreature4, 2);
		float dna3 = mixDNAQualities(dnaQualityMother, 2, dnaQualityCreature1, 2, dnaQualityCreature2, 2, dnaQualityCreature3, 5, dnaQualityCreature4, 2);
		float dna4 = mixDNAQualities(dnaQualityMother, 2, dnaQualityCreature1, 2, dnaQualityCreature2, 2, dnaQualityCreature3, 2, dnaQualityCreature4, 5);
		float rand = 1.0F;
		rand = 0.8F + 0.2F * this.random.nextFloat();
		dna1 = dna1 * (rand + dnaMother * (1.0F - rand));
		rand = 0.8F + 0.2F * this.random.nextFloat();
		dna2 = dna2 * (rand + dnaMother * (1.0F - rand));
		rand = 0.8F + 0.2F * this.random.nextFloat();
		dna3 = dna3 * (rand + dnaMother * (1.0F - rand));
		rand = 0.8F + 0.2F * this.random.nextFloat();
		dna4 = dna4 * (rand + dnaMother * (1.0F - rand));
		String mobName = BygoneAgeMobsInformation.values()[this.creatureID].getCreatureName();
		if (mobName == BygoneAgeMobsInformation.LEPTICTIDIUM.getCreatureName()) {
			creature = new EntityLeptictidium(world);
		} else if (mobName == BygoneAgeMobsInformation.MOERITHERIUM.getCreatureName()) {
			creature = new EntityMoeritherium(world);
		} else if (mobName == BygoneAgeMobsInformation.UINTATHERIUM.getCreatureName()) {
			creature = new EntityUintatherium(world);
		} else if (mobName == BygoneAgeMobsInformation.ARSINOITHERIUM.getCreatureName()) {
			creature = new EntityArsinoitherium(world);
		} else if (mobName == BygoneAgeMobsInformation.TITANISWALLERI.getCreatureName()) {
			creature = new EntityTitanisWalleri(world);
		} else if (mobName == BygoneAgeMobsInformation.BASILOSAURUS.getCreatureName()) {
			creature = new EntityBasilosaurus(world);
		} else if (mobName == BygoneAgeMobsInformation.MAMMOTH.getCreatureName()) {
			creature = new EntityMammoth(world);
		} else if (mobName == BygoneAgeMobsInformation.DEINOTHERIUM.getCreatureName()) {
			creature = new EntityDeinotherium(world);
		} else {
			creature = new EntityLeptictidium(world);
		}
		String motherCode = slots[2].getTagCompound().getString("RNAHelix1");
		creature.createGeneticCode(motherCode.substring(0, 10) + slots[3].getTagCompound().getString("RNAHelix1").substring(10, 18), motherCode.substring(0, 10) + slots[4].getTagCompound().getString("RNAHelix1").substring(10, 18), motherCode.substring(0, 10) + slots[5].getTagCompound().getString("RNAHelix1").substring(10, 18), motherCode.substring(0, 10) + slots[6].getTagCompound().getString("RNAHelix1").substring(10, 18));
		creature.setGenetics(dna1, dna2, dna3, dna4);
		return creature;
	}

	private void selectValidPosition(Entity creature) {
		if (this.worldObj.isAirBlock(this.xCoord + 1, this.yCoord, this.zCoord)) {
			creature.setLocationAndAngles(this.xCoord + 1.5D, this.yCoord, this.zCoord + 0.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord - 1, this.yCoord, this.zCoord)) {
			creature.setLocationAndAngles(this.xCoord - 1.5D, this.yCoord, this.zCoord + 0.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord, this.yCoord, this.zCoord + 1)) {
			creature.setLocationAndAngles(this.xCoord + 0.5D, this.yCoord, this.zCoord + 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord, this.yCoord, this.zCoord - 1)) {
			creature.setLocationAndAngles(this.xCoord + 0.5D, this.yCoord, this.zCoord - 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord + 1, this.yCoord, this.zCoord + 1)) {
			creature.setLocationAndAngles(this.xCoord + 1.5D, this.yCoord, this.zCoord + 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord + 1, this.yCoord, this.zCoord - 1)) {
			creature.setLocationAndAngles(this.xCoord + 1.5D, this.yCoord, this.zCoord - 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord - 1, this.yCoord, this.zCoord + 1)) {
			creature.setLocationAndAngles(this.xCoord - 1.5D, this.yCoord, this.zCoord + 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord - 1, this.yCoord, this.zCoord - 1)) {
			creature.setLocationAndAngles(this.xCoord - 1.5D, this.yCoord, this.zCoord - 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord + 1, this.yCoord + 2, this.zCoord)) {
			creature.setLocationAndAngles(this.xCoord + 1.5D, this.yCoord + 2, this.zCoord + 0.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord - 1, this.yCoord + 2, this.zCoord)) {
			creature.setLocationAndAngles(this.xCoord - 1.5D, this.yCoord + 2, this.zCoord + 0.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord, this.yCoord + 2, this.zCoord + 1)) {
			creature.setLocationAndAngles(this.xCoord + 0.5D, this.yCoord + 2, this.zCoord + 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord, this.yCoord + 2, this.zCoord - 1)) {
			creature.setLocationAndAngles(this.xCoord + 0.5D, this.yCoord + 2, this.zCoord - 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord + 1, this.yCoord + 2, this.zCoord + 1)) {
			creature.setLocationAndAngles(this.xCoord + 1.5D, this.yCoord + 2, this.zCoord + 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord + 1, this.yCoord + 2, this.zCoord - 1)) {
			creature.setLocationAndAngles(this.xCoord + 1.5D, this.yCoord + 2, this.zCoord - 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord - 1, this.yCoord + 2, this.zCoord + 1)) {
			creature.setLocationAndAngles(this.xCoord - 1.5D, this.yCoord + 2, this.zCoord + 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else if (this.worldObj.isAirBlock(this.xCoord - 1, this.yCoord + 2, this.zCoord - 1)) {
			creature.setLocationAndAngles(this.xCoord - 1.5D, this.yCoord + 2, this.zCoord - 1.5D, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		} else {
			creature.setLocationAndAngles(this.xCoord, this.yCoord + 2, this.zCoord, MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 0.0F);
		}
	}

	private float mixDNAQualities(float DNA1, int priority1, float DNA2, int priority2, float DNA3, int priority3, float DNA4, int priority4, float DNA5, int priority5) {
		float maxPriority = priority1 + priority2 + priority3 + priority4 + priority5;
		return Float.valueOf((DNA1 * priority1 / maxPriority) + (DNA2 * priority2 / maxPriority) + (DNA3 * priority3 / maxPriority) + (DNA4 * priority4 / maxPriority) + (DNA5 * priority5 / maxPriority));
	}

	/** Returns true if there is an empty DNA slot. */
	private boolean hasFourEmptyDNASlots() {
		if ((this.slots[2] == null) || (this.slots[3] == null) || (this.slots[4] == null) || (this.slots[5] == null) || (this.slots[6] == null)) {
			return true;
		} else {
			return false;
		}
	}

	/** Resets a list of values to update the size of the creature for rendering. */
	private void recalculateGrowthRate(int id) {
		if (id >= 0) {
			short stages = BygoneAgeGeneticsInformation.values()[id].getNumberOfStages();
			short speed = BygoneAgeGeneticsInformation.values()[id].getHatchSpeed();
			for (Byte i = 0; i <= stages - 1; i++) {
				if (i > 0) {
					this.growthRateList.put((short) ((i * speed) / stages), i);
				} else {
					this.growthRateList.put((short) 2, (byte) 0);
				}
			}
		}
	}

	/** Resets hatcheryTime and creatureID, and updates render. */
	private void resetBaseValues() {
		this.hatcheryTime = 0;
		this.hatcherySpeed = 100;
		this.creatureID = -1;
		this.growthRateList.clear();
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	/** Check for any item stacks in all slots. */
	public boolean hasItems() {
		if (this.slots[0] != null || this.slots[1] != null || this.slots[2] != null || this.slots[3] != null || this.slots[4] != null || this.slots[5] != null || this.slots[6] != null || this.slots[7] != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			if (!this.isHatching()) {
				if (this.canCansumeWaterBucket()) {
					this.consumeWaterBucket();
				}
				if (canCansumeFood()) {
					this.consumeFood();
				}
				if (this.getWaterStored() >= 3) {
					if ((this.proximateValue > 0) && (this.mineralValue > 0) && (this.vitaminValue > 0) && (this.lipidValue > 0)) {
						if (this.canHatch()) {
							this.hatcherySpeed = BygoneAgeGeneticsInformation.values()[creatureID].getHatchSpeed();
							this.embryoStage = 0;
							this.recalculateGrowthRate(this.creatureID);
							this.hatcheryTime = 1;
							this.creatureSize = 0.0F;
							this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
						}
					}
				}
			} else {
				this.hatcheryTime++;
				if (this.growthRateList.containsKey(hatcheryTime)) {
					this.setCreatureSize(this.hatcheryTime, this.hatcherySpeed);
					this.setEmbryoStage(this.hatcheryTime);
					this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
				} else if (shouldUpdate) {
					this.setCreatureSize(this.hatcheryTime, this.hatcherySpeed);
					this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
					this.shouldUpdate = false;
				}
				if (this.hatcheryTime >= this.hatcherySpeed) {
					this.hatchCreature();
					this.resetBaseValues();
				} else {
					if (this.hasFourEmptyDNASlots()) {
						this.resetBaseValues();
					}
				}
			}
		}
	}

	public void cancelHatching(float progress) {
		this.setProximateValue((short) (this.getProximateValue() - (int) (progress * BygoneAgeGeneticsInformation.values()[this.getEmbryoID()].getMinimumProximate())));
		this.setMineralValue((short) (this.getMineralValue() - (int) (progress * BygoneAgeGeneticsInformation.values()[this.getEmbryoID()].getMinimumMinerals())));
		this.setVitaminValue((short) (this.getVitaminValue() - (int) (progress * BygoneAgeGeneticsInformation.values()[this.getEmbryoID()].getMinimumvitamins())));
		this.setLipidValue((short) (this.getLipidValue() - (int) (progress * BygoneAgeGeneticsInformation.values()[this.getEmbryoID()].getMinimumLipids())));
		if (progress >= 0.75F) {
			this.setWaterStored((byte) 0);
		} else if (progress >= 0.5F) {
			this.setWaterStored((byte) 1);
		} else {
			this.setWaterStored((byte) 2);
		}
		this.hatcheryTime = 0;
		this.hatcherySpeed = 100;
		this.creatureID = -1;
		this.growthRateList.clear();
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int stackSize) {
		if (this.slots[i] != null) {
			ItemStack splitedStack;
			if (this.slots[i].stackSize <= stackSize) {
				splitedStack = this.slots[i];
				this.slots[i] = null;
				return splitedStack;
			} else {
				splitedStack = this.slots[i].splitStack(stackSize);
				if (this.slots[i].stackSize == 0) {
					this.slots[i] = null;
				}
				return splitedStack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack itemStack = this.slots[i];
			this.slots[i] = null;
			return itemStack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		this.slots[i] = itemStack;
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return "Hatchery";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return ((this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D) && !this.isHatching());
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return new int[] { 0 };
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setByte("CreatureID", creatureID);
		nbt.setByte("Water", waterStored);
		nbt.setShort("Proximate", proximateValue);
		nbt.setShort("Mineral", mineralValue);
		nbt.setShort("Vitamin", vitaminValue);
		nbt.setShort("Lipid", lipidValue);
		nbt.setShort("HatcheryTime", hatcheryTime);
		nbt.setFloat("CreatureSize", creatureSize);
		nbt.setFloat("EmbryoStage", embryoStage);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		nbt.setTag("Items", list);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.shouldUpdate = true;
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte k = compound.getByte("Slot");

			if (k >= 0 && k < this.slots.length) {
				this.slots[k] = ItemStack.loadItemStackFromNBT(compound);
			}
		}
		this.creatureID = nbt.getByte("CreatureID");
		this.creatureSize = nbt.getShort("CreatureSize");
		this.waterStored = nbt.getByte("Water");
		this.hatcheryTime = nbt.getShort("HatcheryTime");
		this.proximateValue = nbt.getShort("Proximate");
		this.mineralValue = nbt.getShort("Mineral");
		this.vitaminValue = nbt.getShort("Vitamin");
		this.lipidValue = nbt.getShort("Lipid");
		this.embryoStage = nbt.getByte("EmbryoStage");
		if (creatureID >= 0) {
			this.hatcherySpeed = BygoneAgeGeneticsInformation.values()[creatureID].getHatchSpeed();
			recalculateGrowthRate(creatureID);
		}
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound compound = new NBTTagCompound();
		this.writeToNBT(compound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		NBTTagCompound compound = packet.func_148857_g();
		this.readFromNBT(compound);
	}
}