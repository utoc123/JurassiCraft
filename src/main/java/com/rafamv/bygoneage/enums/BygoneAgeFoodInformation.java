package com.rafamv.bygoneage.enums;

import java.util.HashMap;
import java.util.Map;

import com.rafamv.bygoneage.registry.BygoneAgeItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum BygoneAgeFoodInformation {

	APPLE(Items.apple, 0.060D, 0.065D, 0.100D, 0.010D),
	POTATO(Items.potato, 0.100D, 0.200D, 0.160D, 0.020D),
	BREAD(Items.bread, 0.300D, 0.400D, 0.430D, 0.180D),
	CHICKEN(Items.chicken, 0.390D, 0.350D, 0.280D, 0.450D),
	CHICKENCOOKED(Items.cooked_chicken, 0.490D, 0.425D, 0.335D, 0.555D),
	PORKCHOP(Items.porkchop, 0.460D, 0.310D, 0.390D, 0.380D),
	PORKCHOPCOOKED(Items.cooked_porkchop, 0.580D, 0.390D, 0.490D, 0.470D),
	BEEF(Items.beef, 0.460D, 0.310D, 0.390D, 0.380D),
	BEEFCOOKED(Items.cooked_beef, 0.520D, 0.330D, 0.410D, 0.400D),
	FISH(Items.fish, 0.480D, 0.430D, 0.140D, 0.240D),
	FISHCOOKED(Items.cooked_fished, 0.500D, 0.450D, 0.200D, 0.280D),
	MILK(Items.milk_bucket, 0.180D, 0.260D, 0.220D, 0.600D),
	EGG(Items.egg, 0.050D, 0.030D, 0.050D, 0.250D),
	CARROT(Items.carrot, 0.070D, 0.170D, 0.350D, 0.010D),
	SUGAR(Items.sugar, 0.200D, 0.010D, 0.010D, 0.010D),
	WATERMELON(Items.melon, 0.060D, 0.060D, 0.060D, 0.010D),
	TITANISTHIGHRAW(BygoneAgeItems.titanisThighRaw, 0.390D, 0.350D, 0.280D, 0.450D),
	TITANISTHIGHCOOKED(BygoneAgeItems.titanisThighCooked, 0.490D, 0.425D, 0.335D, 0.555D),
	UINTATHERIUMMEATRAW(BygoneAgeItems.uintatheriumMeatRaw, 0.460D, 0.310D, 0.390D, 0.380D),
	UINTATHERIUMMEATCOOKED(BygoneAgeItems.uintatheriumMeatCooked, 0.580D, 0.390D, 0.490D, 0.470D),
	ARSINOITHERIUMMEATRAW(BygoneAgeItems.arsinoitheriumMeatRaw, 0.460D, 0.310D, 0.390D, 0.380D),
	ARSINOITHERIUMMEATCOOKED(BygoneAgeItems.arsinoitheriumMeatCooked, 0.580D, 0.390D, 0.490D, 0.470D),
	WHEAT(Items.wheat, 0.100D, 0.220D, 0.100D, 0.030D);

	private BygoneAgeFoodInformation(Item foodID, double foodProximates, double foodMinerals, double foodVitamins, double foodLipids) {
		this.food = foodID;
		this.proximates = foodProximates;
		this.minerals = foodMinerals;
		this.vitamins = foodVitamins;
		this.lipids = foodLipids;
	}

	/** Returns the food (Item). */
	public Item getFoodItem() {
		return food;
	}

	/** Returns the proximate value from certain food. */
	public double getProximateValueFrom() {
		return proximates;
	}

	/** Returns the mineral value from certain food. */
	public double getMineralValueFrom() {
		return minerals;
	}

	/** Returns the vitamin value from certain food. */
	public double getVitaminValueFrom() {
		return vitamins;
	}

	/** Returns the lipid value from certain food. */
	public double getLipidValueFrom() {
		return lipids;
	}

	private final double proximates;
	private final double minerals;
	private final double vitamins;
	private final double lipids;
	private final Item food;

	/** Sets a list of all food. Used to check if some food is valid. */
	public static final Map<Item, Integer> FOODLIST = new HashMap<Item, Integer>();
	static {
		for (int i = 0; i < values().length; i++) {
			FOODLIST.put(BygoneAgeFoodInformation.values()[i].getFoodItem(), i);
		}
	}
}