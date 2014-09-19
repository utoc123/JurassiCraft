package com.rafamv.bygoneage.enums;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

public enum BygoneAgeMobsInformation {
	
	CHICKEN(BygoneAgeGeneticsInformation.CHICKEN.getCreatureID(), "Chicken", 
			2.0D, 0.0D, 0.35D, 0.10F, 0.15F, 0.1D,
			8.0D, 0.0D, 0.30D, 0.20F, 0.50F, 0.3D,
			0.15F, 0.25F, 0.3F, 0.5F, 
			24000, (byte) 12,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelChicken.png",
			new Item[]{Items.wheat_seeds}),

	SHEEP(BygoneAgeGeneticsInformation.SHEEP.getCreatureID(), "Sheep", 
			8.0D, 0.0D, 0.35D, 0.30F, 0.30F, 0.25D,
			18.0D, 0.0D, 0.30D, 1.6F, 1.2F, 0.5D,
			0.3F, 0.3F, 0.5F, 0.8F, 
			24000, (byte) 12,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelSheep.png",
			new Item[]{Items.wheat}),

	PIG(BygoneAgeGeneticsInformation.PIG.getCreatureID(), "Pig", 
			8.0D, 0.0D, 0.35D, 0.30F, 0.30F, 0.25D,
			18.0D, 0.0D, 0.30D, 1.5F, 1.0F, 0.5D,
			0.3F, 0.3F, 0.5F, 0.8F, 
			24000, (byte) 12,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelPig.png",
			new Item[]{Items.carrot}),
			
	COW(BygoneAgeGeneticsInformation.COW.getCreatureID(), "Cow", 
			10.0D, 0.0D, 0.30D, 0.45F, 0.4F, 0.25D,
			20.0D, 0.0D, 0.25D, 1.8F, 1.4F, 0.5D,
			0.3F, 0.3F, 0.5F, 0.8F, 
			24000, (byte) 12,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelCow.png",
			new Item[]{Items.wheat}),
			
	LEPTICTIDIUM(BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(), BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureName(), 
			8.0D, 1.0D, 0.40D, 0.3F, 0.3F, 0.1D,
			24.0D, 3.0D, 0.32D, 1.0F, 0.7F, 0.3D,
			0.2F, 0.3F, 0.4F, 0.5F, 
			168000, (byte) 80,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelLeptictidium",
			new Item[]{Items.potato, Items.baked_potato, Items.carrot, Items.cookie}),

	MOERITHERIUM(BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureName(), 
			16.0D, 1.0D, 0.32D, 0.6F, 0.35F, 0.2D,
			26.0D, 4.0D, 0.28D, 2.0F, 1.0F, 0.6D,
			0.30F, 0.30F, 0.40F, 0.6F, 
			240000, (byte) 90,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelMoeritherium",
			new Item[]{Items.apple, Items.melon}),

	UINTATHERIUM(BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureName(), 
			18.0D, 3.0D, 0.35D, 0.6F, 0.4F, 0.3D,
			36.0D, 8.0D, 0.285D, 3.8F, 1.6F, 0.7D,
			0.30F, 0.30F, 0.8F, 1.15F, 
			288000, (byte) 100,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelUintatherium",
			new Item[]{Items.wheat, Items.apple}),

	ARSINOITHERIUM(BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureName(), 
			18.0D, 3.0D, 0.325D, 0.64F, 0.42F, 0.3D,
			38.0D, 10.0D, 0.275D, 4.0F, 2.0F, 0.7D,
			0.325F, 0.325F, 0.95F, 1.15F, 
			288000, (byte) 100,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelArsinoitherium",
			new Item[]{Items.wheat, Items.apple}),

	TITANISWALLERI(BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID(), BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureName(), 
			12.0D, 3.0D, 0.40D, 0.4F, 0.4F, 0.2D,
			25.0D, 12.0D, 0.325D, 1.5F, 2.5F, 0.5D,
			0.35F, 0.45F, 0.9F, 1.35F, 
			240000, (byte) 85,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelTitanisWalleri",
			new Item[]{Items.beef, Items.porkchop, BygoneAgeItems.arsinoitheriumMeatRaw, BygoneAgeItems.arsinoitheriumMeatCooked, BygoneAgeItems.uintatheriumMeatRaw, BygoneAgeItems.uintatheriumMeatCooked, Items.cooked_beef, Items.cooked_porkchop}),

	BASILOSAURUS(BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureID(), BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureName(), 
			20.0D, 3.0D, 0.40D, 1.5F, 0.5F, 0.6D,
			60.0D, 18.0D, 0.35D, 18.0F, 2.5F, 1.0D,
			0.40F, 0.40F, 2.0F, 1.8F, 
			384000, (byte) 120,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelBasilosaurus",
			new Item[]{Items.fish, Items.cooked_fished}),
			
	MAMMOTH(BygoneAgeGeneticsInformation.MAMMOTH.getCreatureID(), BygoneAgeGeneticsInformation.MAMMOTH.getCreatureName(), 
			22.0D, 2.0D, 0.30D, 1.2F, 0.8F, 0.5D,
			64.0D, 18.0D, 0.22D, 4.0F, 3.5F, 1.0D,
			0.80F, 0.80F, 2.25F, 2.4F, 
			400000, (byte) 120,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelMammoth",
			new Item[]{Items.wheat, Items.apple, Items.sugar}),
			
	DEINOTHERIUM(BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureName(), 
			22.0D, 2.0D, 0.30D, 1.2F, 0.8F, 0.5D,
			58.0D, 15.0D, 0.23D, 4.8F, 3.0F, 1.0D,
			0.80F, 0.80F, 2.0F, 2.0F, 
			400000, (byte) 120,
			BygoneAge.MODID + ":" + "textures/models/creatures/ModelDeinotherium",
			new Item[]{Items.wheat, Items.apple, Items.sugar});
	
	private BygoneAgeMobsInformation(byte id, String name, 
			double minCreatureHealth, double minCreatureStrenght, double minCreatureSpeed, float minCreatureLength, float minCreatureHeight, double minCreatureKnockback,
			double maxCreatureHealth, double maxCreatureStrength, double maxCreatureSpeed, float maxCreatureLength, float maxCreatureHeight, double maxCreatureKnockback, 
			float xzCollisionBoxMin, float yCollisionBoxMin, float xzCollisionBoxVariation, float yCollisionBoxVariation, int fullGrowthTicks, 
			byte creatureTimesOfGrowth, String mobTexture, Item[] favoriteFood) {
		this.mobID = id;
		this.mobName = name;
		this.minHealth = minCreatureHealth;
		this.minStrength = minCreatureStrenght;
		this.minSpeed = minCreatureSpeed;
		this.minLength = minCreatureLength;
		this.minHeight = minCreatureHeight;
		this.minKnockback = minCreatureKnockback;
		this.maxHealth = maxCreatureHealth;
		this.maxStrength = maxCreatureStrength;
		this.maxSpeed = maxCreatureSpeed;
		this.maxLength = maxCreatureLength;
		this.maxHeight = maxCreatureHeight;
		this.maxKnockback = maxCreatureKnockback;
		this.xzBoxMin = xzCollisionBoxMin;
		this.yBoxMin = yCollisionBoxMin;
		this.xzBoxDelta = xzCollisionBoxVariation;
		this.yBoxDelta = yCollisionBoxVariation;
		this.fullGrowthTime = fullGrowthTicks;
		this.timesOfGrowth = creatureTimesOfGrowth;
		this.texture = mobTexture;
		this.favoriteFoodList = favoriteFood;
	}

	/** Returns the creature name. */
	public String getCreatureName() {
		return mobName;
	}

	/** Returns the creature id. */
	public byte getCreatureID() {
		return mobID;
	}

	/** Returns the maximum creature health. */
	public double getMaxHealth() {
		return maxHealth;
	}

	/** Returns the maximum creature strength. */
	public double getMaxStrength() {
		return maxStrength;
	}

	/** Returns the maximum creature speed. */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/** Returns the maximum height of the creature. */
	public float getMaxHeight() {
		return maxHeight;
	}

	/** Returns the maximum length of the creature. */
	public float getMaxLength() {
		return maxLength;
	}

	/** Returns the maximum knock back of the creature. */
	public double getMaxKnockback() {
		return maxKnockback;
	}

	/** Returns the minimum creature health. */
	public double getMinHealth() {
		return minHealth;
	}

	/** Returns the minimum creature strength. */
	public double getMinStrength() {
		return minStrength;
	}

	/** Returns the minimum creature speed. */
	public double getMinSpeed() {
		return minSpeed;
	}

	/** Returns the minimum height of the creature. */
	public float getMinHeight() {
		return minHeight;
	}

	/** Returns the minimum length of the creature. */
	public float getMinLength() {
		return minLength;
	}

	/** Returns the minimum knock back of the creature. */
	public double getMinKnockback() {
		return minKnockback;
	}
	
	/** Returns the initial xz collision box of the creature. */
	public float getXZcollisionBoxMin() {
		return xzBoxMin;
	}

	/** Returns the variation of xz collision box of the creature when full grown. */
	public float getXZcollisionBoxVariation() {
		return xzBoxDelta;
	}

	/** Returns the initial y collision box of the creature. */
	public float getYcollisionBoxMin() {
		return yBoxMin;
	}

	/** Returns the variation of y collision box of the creature when full grown. */
	public float getYcollisionBoxVariation() {
		return yBoxDelta;
	}

	/** Returns how many ticks to reach the maximum size of the creature. */
	public int getFullGrowthTime() {
		return fullGrowthTime;
	}

	/** Returns how many times this creature will update is data. */
	public byte getTimesOfGrowth() {
		return timesOfGrowth;
	}

	/** Returns the texture of the creature. */
	public String getTexture() {
		return texture;
	}
	
	/** Returns the default texture of the creature, which is a grey layer. */
	public String getDefaultTexture() {
		return BygoneAge.MODID + ":" + "textures/models/creatures/ModelDeinotherium";
	}
	
	/** Returns the favorite food of the creature as a Item[]. */
	public Item[] getFavoriteFoodList() {
		return favoriteFoodList;
	}

	/** Returns true if the item is the favorite food of a certain creature. */
	public static boolean isFavoriteFood(byte i, Item item) {
		for (int n = 0; n < BygoneAgeMobsInformation.values()[i].getFavoriteFoodList().length; n++) {
			if (item.equals(BygoneAgeMobsInformation.values()[i].getFavoriteFoodList()[n])) {
				return true;
			}
		}
		return false;
	}

	private byte mobID;
	private final String mobName;
	private final String texture;
	private final double minHealth;
	private final double minStrength;
	private final double minSpeed;
	private final float minHeight;
	private final float minLength;
	private final double minKnockback;
	private final double maxHealth;
	private final double maxStrength;
	private final double maxSpeed;
	private final float maxHeight;
	private final float maxLength;
	private final double maxKnockback;
	private final float xzBoxMin;
	private final float yBoxMin;
	private final float xzBoxDelta;
	private final float yBoxDelta;
	private final int fullGrowthTime;
	private final byte timesOfGrowth;
	private final Item[] favoriteFoodList;
	
}