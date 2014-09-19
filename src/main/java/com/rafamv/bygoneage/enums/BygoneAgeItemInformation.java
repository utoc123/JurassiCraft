package com.rafamv.bygoneage.enums;

public enum BygoneAgeItemInformation {

	ARMORLEPTICTIDIUMHELMET("LeptictidiumHelmet", "LeptictidiumHelmet"),
	ARMORLEPTICTIDIUMCHESTPLATE("LeptictidiumChestplate", "LeptictidiumChestplate"),
	ARMORLEPTICTIDIUMLEGGINGS("LeptictidiumLeggings", "LeptictidiumLeggings"),
	ARMORLEPTICTIDIUMBOOTS("LeptictidiumBoots", "LeptictidiumBoots"),

	MICROCHIP("Microchip", "Microchip"),
	SPAWNEGGS("SpawnEgg", "SpawnEgg"),

	EMPTYVIAL("EmptyVial", "EmptyVial"),
	SALIVASAMPLE("SalivaSample", "SalivaSample"),
	DNASAMPLE("DnaSample", "DnaSample"),
	PREHISTORICBRISTLES("PrehistoricBristles", "PrehistoricBristles"),
	PREHISTORICFUR("PrehistoricFur", "PrehistoricFur"),
	PREHISTORICSKIN("PrehistoricSkin", "PrehistoricSkin"),
	PREHISTORICFEATHER("PrehistoricFeather", "PrehistoricFeather"),

	ANALYZER("Analyzer", "Analyzer"),
	LEPTICTIDIUMHIDE("LeptictidiumHide", "LeptictidiumHide"),
	ARSINOITHERIUMMEATRAW("ArsinoitheriumMeatRaw", "ArsinoitheriumMeatRaw"),
	ARSINOITHERIUMMEATCOOKED("ArsinoitheriumMeatCooked", "ArsinoitheriumMeatCooked"),
	UINTATHERIUMMEATRAW("UintatheriumMeatRaw", "UintatheriumMeatRaw"),
	UINTATHERIUMMEATCOOKED("UintatheriumMeatCooked", "UintatheriumMeatCooked"),
	TITANISMEATRAW("TitanisThighRaw", "TitanisThighRaw"),
	TITANISMEATCOOKED("TitanisThighCooked", "TitanisThighCooked"),
	BASILOSAURUSMEATRAW("BasilosaurusMeatRaw", "BasilosaurusMeatRaw"),
	BASILOSAURUSMEATCOOKED("BasilosaurusMeatCooked", "BasilosaurusMeatCooked"),

	APPLEONSTICK("AppleOnAStick", "AppleOnAStick"),
	CARROTONSTICK("CarrotOnAStick", "CarrotOnAStick"),
	POTATOONSTICK("PotatoOnAStick", "PotatoOnAStick"),
	WHEATONSTICK("WheatOnAStick", "WheatOnAStick"),
	BEEFONSTICK("BeefOnAStick", "BeefOnAStick"),
	FISHONSTICK("FishOnAStick", "FishOnAStick"),
	PORKONSTICK("PorkOnAStick", "PorkOnAStick");

	private BygoneAgeItemInformation(String itemUnlocalizedName, String itemTexture) {
		this.unlocalizedName = itemUnlocalizedName;
		this.texture = itemTexture;
	}

	/** Returns the item unlocalized name */
	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	/** Returns the item texture path */
	public String getTexture() {
		return unlocalizedName;
	}

	private final String unlocalizedName;
	private final String texture;
}