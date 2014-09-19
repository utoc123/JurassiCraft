package com.rafamv.bygoneage.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.item.Item;

import com.rafamv.bygoneage.registry.BygoneAgeItems;

public enum BygoneAgeFossilDrops {

	BygoneAgeFossilDrops();

	/** Returns a random item depending on the creature id. */
	public static final Byte[] getDropFromFossil(Item item) {
		return BygoneAgeFossilDrops.FOSSILDROPS.get(item);
	}

	/** This is a list of all possible drops from the fossil of any creature.
	 * HashMap<Byte(creature id), Items[] (possible drops)> */
	public static final Map<Item, Byte[]> FOSSILDROPS = new HashMap<Item, Byte[]>();
	static {
		FOSSILDROPS.put(BygoneAgeItems.prehistoricSkin, new Byte[] { 
				BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(),
				BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureID(),
				BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureID(),
				BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureID(),
				BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID(),
				BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureID(),
				BygoneAgeGeneticsInformation.MAMMOTH.getCreatureID(),
				BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.prehistoricFur, new Byte[] { 
				BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(),
				BygoneAgeGeneticsInformation.MAMMOTH.getCreatureID(),
				BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.prehistoricBristles, new Byte[] { 
				BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(),
				BygoneAgeGeneticsInformation.MAMMOTH.getCreatureID(),
				BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.prehistoricFeather, new Byte[] { 
				BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.leptictidiumHide, new Byte[] { 
				BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.titanisThighRaw, new Byte[] { 
				BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.basilosaurusMeatRaw, new Byte[] { 
				BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.arsinoitheriumMeatRaw, new Byte[] { 
				BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureID()
				});
		FOSSILDROPS.put(BygoneAgeItems.uintatheriumMeatRaw, new Byte[] { 
				BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureID()
				});
	}

}
