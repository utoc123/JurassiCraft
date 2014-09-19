package com.rafamv.bygoneage.enums;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.registry.BygoneAgeItems;

public enum BygoneAgeRidingInformation {

	CHICKEN(BygoneAgeGeneticsInformation.CHICKEN.getCreatureID(), BygoneAgeGeneticsInformation.CHICKEN.getCreatureName(), 
			false, 0.0F, new Item[] { null }),

	SHEEP(BygoneAgeGeneticsInformation.SHEEP.getCreatureID(), BygoneAgeGeneticsInformation.SHEEP.getCreatureName(), 
			false, 0.0F, new Item[] { null }),

	PIG(BygoneAgeGeneticsInformation.PIG.getCreatureID(), BygoneAgeGeneticsInformation.PIG.getCreatureName(), 
			false, 0.0F, new Item[] { null }),

	COW(BygoneAgeGeneticsInformation.COW.getCreatureID(), BygoneAgeGeneticsInformation.COW.getCreatureName(), 
			false, 0.0F, new Item[] { null }),

	LEPTICTIDIUM(BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(), BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureName(), 
			false, 0.0F, new Item[] { BygoneAgeItems.carrotOnStick, BygoneAgeItems.potatoOnStick }),

	MOERITHERIUM(BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureName(), 
			true, 0.35F, new Item[] { BygoneAgeItems.wheatOnStick, BygoneAgeItems.appleOnStick }),

	UINTATHERIUM(BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureName(), 
			true, 0.5F, new Item[] { BygoneAgeItems.wheatOnStick, BygoneAgeItems.appleOnStick }),

	ARSINOITHERIUM(BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureName(), 
			true, 0.5F, new Item[] { BygoneAgeItems.wheatOnStick, BygoneAgeItems.appleOnStick }),

	TITANISWALLERI(BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID(), BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureName(), 
			true, 0.7F, new Item[] { BygoneAgeItems.beefOnStick, BygoneAgeItems.porkOnStick }),

	BASILOSAURUS(BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureID(), BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureName(), 
			false, 0.0F, new Item[] { BygoneAgeItems.fishOnStick }),

	MAMMOTH(BygoneAgeGeneticsInformation.MAMMOTH.getCreatureID(), BygoneAgeGeneticsInformation.MAMMOTH.getCreatureName(), 
			true, 0.6F, new Item[] { BygoneAgeItems.wheatOnStick }),

	DEINOTHERIUM(BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID(), BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureName(), 
			true, 0.6F, new Item[] { BygoneAgeItems.wheatOnStick });

	private BygoneAgeRidingInformation(byte id, String name, boolean isCreatureRidable, float creatureRidingSpeed, Item[] ridingItems) {
		this.mobID = id;
		this.mobName = name;
		this.isRidable = isCreatureRidable;
		this.ridingSpeed = creatureRidingSpeed;
		this.ridingItemList = ridingItems;
	}

	/** Returns true if the creature is ridable. */
	public boolean isRidable() {
		return isRidable;
	}

	/** Returns how fast the creature can move when a player is riding it. */
	public float getRidingSpeed() {
		return ridingSpeed;
	}

	/** Returns the favorite food of the creature as a Item[]. */
	public Item[] getRidingItemList() {
		return ridingItemList;
	}

	/** Returns if the list of riding items contains certain item. */
	public static boolean isRidingItem(byte i, Item item) {
		for (int n = 0; n < BygoneAgeRidingInformation.values()[i].getRidingItemList().length; n++) {
			if (item.equals(BygoneAgeRidingInformation.values()[i].getRidingItemList()[n])) {
				return true;
			}
		}
		return false;
	}

	private byte mobID;
	private final String mobName;
	private final boolean isRidable;
	private final float ridingSpeed;
	private final Item[] ridingItemList;

}