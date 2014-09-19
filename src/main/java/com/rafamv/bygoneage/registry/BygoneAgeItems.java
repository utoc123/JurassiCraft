package com.rafamv.bygoneage.registry;

import net.minecraft.item.Item;

import com.rafamv.bygoneage.enums.BygoneAgeItemInformation;
import com.rafamv.bygoneage.items.Analyzer;
import com.rafamv.bygoneage.items.BygoneAgeSpawnEgg;
import com.rafamv.bygoneage.items.Microchip;
import com.rafamv.bygoneage.items.dnaitems.DNASample;
import com.rafamv.bygoneage.items.dnaitems.EmptyVial;
import com.rafamv.bygoneage.items.dnaitems.PrehistoricBristles;
import com.rafamv.bygoneage.items.dnaitems.PrehistoricFeather;
import com.rafamv.bygoneage.items.dnaitems.PrehistoricFur;
import com.rafamv.bygoneage.items.dnaitems.PrehistoricSkin;
import com.rafamv.bygoneage.items.dnaitems.SalivaSample;
import com.rafamv.bygoneage.items.drops.ArsinoitheriumMeatCooked;
import com.rafamv.bygoneage.items.drops.ArsinoitheriumMeatRaw;
import com.rafamv.bygoneage.items.drops.BasilosaurusMeatCooked;
import com.rafamv.bygoneage.items.drops.BasilosaurusMeatRaw;
import com.rafamv.bygoneage.items.drops.LeptictidiumHide;
import com.rafamv.bygoneage.items.drops.TitanisThighCooked;
import com.rafamv.bygoneage.items.drops.TitanisThighRaw;
import com.rafamv.bygoneage.items.drops.UintatheriumMeatCooked;
import com.rafamv.bygoneage.items.drops.UintatheriumMeatRaw;
import com.rafamv.bygoneage.items.ridingitems.AppleOnAStick;
import com.rafamv.bygoneage.items.ridingitems.BeefOnAStick;
import com.rafamv.bygoneage.items.ridingitems.CarrotOnAStick;
import com.rafamv.bygoneage.items.ridingitems.FishOnAStick;
import com.rafamv.bygoneage.items.ridingitems.PorkOnAStick;
import com.rafamv.bygoneage.items.ridingitems.PotatoOnAStick;
import com.rafamv.bygoneage.items.ridingitems.WheatOnAStick;

import cpw.mods.fml.common.registry.GameRegistry;

public class BygoneAgeItems {

	//General Items;
	public static Item spawnEgg;
	public static Item microship;

	//DNA related;
	public static Item emptyVial;
	public static Item salivaSample;
	public static Item dnaSample;
	public static Item prehistoricSkin;
	public static Item prehistoricFur;
	public static Item prehistoricBristles;
	public static Item prehistoricFeather;

	//Riding Items;
	public static Item appleOnStick;
	public static Item carrotOnStick;
	public static Item potatoOnStick;
	public static Item wheatOnStick;
	public static Item beefOnStick;
	public static Item fishOnStick;
	public static Item porkOnStick;

	//Mob related;
	public static Item analyzer;
	public static Item leptictidiumHide;
	public static Item arsinoitheriumMeatRaw;
	public static Item arsinoitheriumMeatCooked;
	public static Item uintatheriumMeatRaw;
	public static Item uintatheriumMeatCooked;
	public static Item titanisThighRaw;
	public static Item titanisThighCooked;
	public static Item basilosaurusMeatRaw;
	public static Item basilosaurusMeatCooked;

	/*//Armors;
	public static Item armorLeptictidiumHelmet;
	public static Item armorLeptictidiumChestplate;
	public static Item armorLeptictidiumLeggings;
	public static Item armorLeptictidiumBoots;
	*/

	public static void registryAll() {
		initItems();
		registerItems();
	}

	public static void initItems() {
		emptyVial = new EmptyVial().setUnlocalizedName(BygoneAgeItemInformation.EMPTYVIAL.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.EMPTYVIAL.getTexture());
		salivaSample = new SalivaSample().setUnlocalizedName(BygoneAgeItemInformation.SALIVASAMPLE.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.SALIVASAMPLE.getTexture());
		dnaSample = new DNASample().setUnlocalizedName(BygoneAgeItemInformation.DNASAMPLE.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.DNASAMPLE.getTexture());
		prehistoricSkin = new PrehistoricSkin().setUnlocalizedName(BygoneAgeItemInformation.PREHISTORICSKIN.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.PREHISTORICSKIN.getTexture());
		prehistoricFur = new PrehistoricFur().setUnlocalizedName(BygoneAgeItemInformation.PREHISTORICFUR.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.PREHISTORICFUR.getTexture());
		prehistoricBristles = new PrehistoricBristles().setUnlocalizedName(BygoneAgeItemInformation.PREHISTORICBRISTLES.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.PREHISTORICBRISTLES.getTexture());
		prehistoricFeather = new PrehistoricFeather().setUnlocalizedName(BygoneAgeItemInformation.PREHISTORICFEATHER.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.PREHISTORICFEATHER.getTexture());
		microship = new Microchip().setUnlocalizedName(BygoneAgeItemInformation.MICROCHIP.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.MICROCHIP.getTexture());
		analyzer = new Analyzer().setUnlocalizedName(BygoneAgeItemInformation.ANALYZER.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.ANALYZER.getTexture());
		spawnEgg = new BygoneAgeSpawnEgg().setUnlocalizedName(BygoneAgeItemInformation.SPAWNEGGS.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.SPAWNEGGS.getTexture());
		appleOnStick = new AppleOnAStick().setUnlocalizedName(BygoneAgeItemInformation.APPLEONSTICK.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.APPLEONSTICK.getTexture());
		carrotOnStick = new CarrotOnAStick().setUnlocalizedName(BygoneAgeItemInformation.CARROTONSTICK.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.CARROTONSTICK.getTexture());
		potatoOnStick = new PotatoOnAStick().setUnlocalizedName(BygoneAgeItemInformation.POTATOONSTICK.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.POTATOONSTICK.getTexture());
		wheatOnStick = new WheatOnAStick().setUnlocalizedName(BygoneAgeItemInformation.WHEATONSTICK.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.WHEATONSTICK.getTexture());
		beefOnStick = new BeefOnAStick().setUnlocalizedName(BygoneAgeItemInformation.BEEFONSTICK.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.BEEFONSTICK.getTexture());
		fishOnStick = new FishOnAStick().setUnlocalizedName(BygoneAgeItemInformation.FISHONSTICK.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.FISHONSTICK.getTexture());
		porkOnStick = new PorkOnAStick().setUnlocalizedName(BygoneAgeItemInformation.PORKONSTICK.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.PORKONSTICK.getTexture());
		leptictidiumHide = new LeptictidiumHide().setUnlocalizedName(BygoneAgeItemInformation.LEPTICTIDIUMHIDE.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.LEPTICTIDIUMHIDE.getTexture());
		arsinoitheriumMeatRaw = new ArsinoitheriumMeatRaw(3, 2.2F, true).setUnlocalizedName(BygoneAgeItemInformation.ARSINOITHERIUMMEATRAW.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.ARSINOITHERIUMMEATRAW.getTexture());
		arsinoitheriumMeatCooked = new ArsinoitheriumMeatCooked(8, 13.0F, true).setUnlocalizedName(BygoneAgeItemInformation.ARSINOITHERIUMMEATCOOKED.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.ARSINOITHERIUMMEATCOOKED.getTexture());
		uintatheriumMeatRaw = new UintatheriumMeatRaw(3, 2.2F, true).setUnlocalizedName(BygoneAgeItemInformation.UINTATHERIUMMEATRAW.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.UINTATHERIUMMEATRAW.getTexture());
		uintatheriumMeatCooked = new UintatheriumMeatCooked(8, 13.0F, true).setUnlocalizedName(BygoneAgeItemInformation.UINTATHERIUMMEATCOOKED.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.UINTATHERIUMMEATCOOKED.getTexture());
		titanisThighRaw = new TitanisThighRaw(2, 1.6F, true).setUnlocalizedName(BygoneAgeItemInformation.TITANISMEATRAW.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.TITANISMEATRAW.getTexture());
		titanisThighCooked = new TitanisThighCooked(6, 8.5F, true).setUnlocalizedName(BygoneAgeItemInformation.TITANISMEATCOOKED.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.TITANISMEATCOOKED.getTexture());
		basilosaurusMeatRaw = new BasilosaurusMeatRaw(3, 1.8F, true).setUnlocalizedName(BygoneAgeItemInformation.BASILOSAURUSMEATRAW.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.BASILOSAURUSMEATRAW.getTexture());
		basilosaurusMeatCooked = new BasilosaurusMeatCooked(7, 12.0F, true).setUnlocalizedName(BygoneAgeItemInformation.BASILOSAURUSMEATCOOKED.getUnlocalizedName()).setTextureName(BygoneAgeItemInformation.BASILOSAURUSMEATCOOKED.getTexture());
		//armorLeptictidiumHelmet = new ItemArmor(ItemArmor.ArmorMaterial.CLOTH, 0, 0).setUnlocalizedName(BygoneAgeItemInformation.ARMORLEPTICTIDIUMHELMET.getUnlocalizedName());
		//armorLeptictidiumChestplate = new ItemArmor(ItemArmor.ArmorMaterial.CLOTH, 0, 1).setUnlocalizedName(BygoneAgeItemInformation.ARMORLEPTICTIDIUMCHESTPLATE.getUnlocalizedName());
		//armorLeptictidiumLeggings = new ItemArmor(ItemArmor.ArmorMaterial.CLOTH, 0, 2).setUnlocalizedName(BygoneAgeItemInformation.ARMORLEPTICTIDIUMLEGGINGS.getUnlocalizedName());
		//armorLeptictidiumBoots = new ItemArmor(ItemArmor.ArmorMaterial.CLOTH, 0, 3).setUnlocalizedName(BygoneAgeItemInformation.ARMORLEPTICTIDIUMBOOTS.getUnlocalizedName());
	}

	public static void registerItems() {
		GameRegistry.registerItem(microship, BygoneAgeItemInformation.MICROCHIP.getUnlocalizedName());
		GameRegistry.registerItem(spawnEgg, BygoneAgeItemInformation.SPAWNEGGS.getUnlocalizedName());
		GameRegistry.registerItem(emptyVial, BygoneAgeItemInformation.EMPTYVIAL.getUnlocalizedName());
		GameRegistry.registerItem(salivaSample, BygoneAgeItemInformation.SALIVASAMPLE.getUnlocalizedName());
		GameRegistry.registerItem(dnaSample, BygoneAgeItemInformation.DNASAMPLE.getUnlocalizedName());
		GameRegistry.registerItem(prehistoricSkin, BygoneAgeItemInformation.PREHISTORICSKIN.getUnlocalizedName());
		//GameRegistry.registerItem(prehistoricFur, BygoneAgeItemInformation.PREHISTORICFUR.getUnlocalizedName());
		//GameRegistry.registerItem(prehistoricBristles, BygoneAgeItemInformation.PREHISTORICBRISTLES.getUnlocalizedName());
		//GameRegistry.registerItem(prehistoricFeather, BygoneAgeItemInformation.PREHISTORICFEATHER.getUnlocalizedName());
		GameRegistry.registerItem(analyzer, BygoneAgeItemInformation.ANALYZER.getUnlocalizedName());
		GameRegistry.registerItem(leptictidiumHide, BygoneAgeItemInformation.LEPTICTIDIUMHIDE.getUnlocalizedName());
		GameRegistry.registerItem(arsinoitheriumMeatRaw, BygoneAgeItemInformation.ARSINOITHERIUMMEATRAW.getUnlocalizedName());
		GameRegistry.registerItem(arsinoitheriumMeatCooked, BygoneAgeItemInformation.ARSINOITHERIUMMEATCOOKED.getUnlocalizedName());
		GameRegistry.registerItem(uintatheriumMeatRaw, BygoneAgeItemInformation.UINTATHERIUMMEATRAW.getUnlocalizedName());
		GameRegistry.registerItem(uintatheriumMeatCooked, BygoneAgeItemInformation.UINTATHERIUMMEATCOOKED.getUnlocalizedName());
		GameRegistry.registerItem(titanisThighRaw, BygoneAgeItemInformation.TITANISMEATRAW.getUnlocalizedName());
		GameRegistry.registerItem(titanisThighCooked, BygoneAgeItemInformation.TITANISMEATCOOKED.getUnlocalizedName());
		GameRegistry.registerItem(basilosaurusMeatRaw, BygoneAgeItemInformation.BASILOSAURUSMEATRAW.getUnlocalizedName());
		GameRegistry.registerItem(basilosaurusMeatCooked, BygoneAgeItemInformation.BASILOSAURUSMEATCOOKED.getUnlocalizedName());
		GameRegistry.registerItem(appleOnStick, BygoneAgeItemInformation.APPLEONSTICK.getUnlocalizedName());
		GameRegistry.registerItem(carrotOnStick, BygoneAgeItemInformation.CARROTONSTICK.getUnlocalizedName());
		GameRegistry.registerItem(potatoOnStick, BygoneAgeItemInformation.POTATOONSTICK.getUnlocalizedName());
		GameRegistry.registerItem(wheatOnStick, BygoneAgeItemInformation.WHEATONSTICK.getUnlocalizedName());
		GameRegistry.registerItem(beefOnStick, BygoneAgeItemInformation.BEEFONSTICK.getUnlocalizedName());
		GameRegistry.registerItem(porkOnStick, BygoneAgeItemInformation.PORKONSTICK.getUnlocalizedName());
		//GameRegistry.registerItem(fishOnStick, BygoneAgeItemInformation.FISHONSTICK.getUnlocalizedName());
		//GameRegistry.registerItem(armorLeptictidiumHelmet, BygoneAgeItemInformation.ARMORLEPTICTIDIUMHELMET.getUnlocalizedName());
		//GameRegistry.registerItem(armorLeptictidiumChestplate, BygoneAgeItemInformation.ARMORLEPTICTIDIUMCHESTPLATE.getUnlocalizedName());
		//GameRegistry.registerItem(armorLeptictidiumLeggings, BygoneAgeItemInformation.ARMORLEPTICTIDIUMLEGGINGS.getUnlocalizedName());
		//GameRegistry.registerItem(armorLeptictidiumBoots, BygoneAgeItemInformation.ARMORLEPTICTIDIUMBOOTS.getUnlocalizedName());
	}

}
