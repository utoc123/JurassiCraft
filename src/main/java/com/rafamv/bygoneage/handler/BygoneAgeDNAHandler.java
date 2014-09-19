package com.rafamv.bygoneage.handler;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;

import com.rafamv.bygoneage.entity.EntityBygoneAgeAnimated;
import com.rafamv.bygoneage.entity.EntityBygoneAgeCreature;
import com.rafamv.bygoneage.entity.creatures.EntityArsinoitherium;
import com.rafamv.bygoneage.entity.creatures.EntityBasilosaurus;
import com.rafamv.bygoneage.entity.creatures.EntityLeptictidium;
import com.rafamv.bygoneage.entity.creatures.EntityMammoth;
import com.rafamv.bygoneage.entity.creatures.EntityMoeritherium;
import com.rafamv.bygoneage.entity.creatures.EntityTitanisWalleri;
import com.rafamv.bygoneage.entity.creatures.EntityUintatherium;
import com.rafamv.bygoneage.enums.BygoneAgeGeneticsInformation;

public class BygoneAgeDNAHandler {

	private static Random random = new Random();

	public static String createNewRNAFrom(String oldRNA) {
		String newRNA = "";
		for (int i = 0; i < oldRNA.length(); i++) {
			switch (oldRNA.charAt(i)) {
				case 'A':
					newRNA = newRNA + "T";
					break;
				case 'C':
					newRNA = newRNA + "G";
					break;
				case 'G':
					newRNA = newRNA + "C";
					break;
				case 'T':
					newRNA = newRNA + "A";
					break;
				default:
					newRNA = newRNA + "(WRONGSEQUENCE)";
			}
		}
		if (newRNA.length() != oldRNA.length()) {
			newRNA = "AAAAAAAAAAAAAAAAAA";
		}
		return newRNA;
	}

	public static String generateNewRNA(int size) {
		String newRNA = "";
		int rand;
		for (int i = 0; i < size; i++) {
			rand = random.nextInt(4);
			switch (rand) {
				case 0:
					newRNA = newRNA + "A";
					break;
				case 1:
					newRNA = newRNA + "C";
					break;
				case 2:
					newRNA = newRNA + "G";
					break;
				case 3:
					newRNA = newRNA + "T";
					break;
				default:
					newRNA = newRNA + "(WRONGSEQUENCE)";
			}
		}
		if (newRNA.length() != size) {
			newRNA = "AAAAAAAAAAAAAAAAAA";
		}
		return newRNA;
	}

	public static float calculateDNAQuality(String rna1, String rna2) {
		float valueRNA1 = 0;
		float valueRNA2 = 0;
		float finalValue = 0;
		for (int i = 0; i < rna1.length(); i++) {
			switch (rna1.charAt(i)) {
				case 'A':
					valueRNA1 = valueRNA1 + 0.45F;
					break;
				case 'C':
					valueRNA1 = valueRNA1 + 0.70F;
					break;
				case 'G':
					valueRNA1 = valueRNA1 + 1.20F;
					break;
				case 'T':
					valueRNA1 = valueRNA1 + 1.50F;
					break;
			}
		}
		for (int i = 0; i < rna2.length(); i++) {
			switch (rna2.charAt(i)) {
				case 'A':
					valueRNA2 = valueRNA2 + 0.60F;
					break;
				case 'C':
					valueRNA2 = valueRNA2 + 0.45F;
					break;
				case 'G':
					valueRNA2 = valueRNA2 + 1.30F;
					break;
				case 'T':
					valueRNA1 = valueRNA2 + 1.40F;
					break;
			}
		}
		finalValue = Float.valueOf((valueRNA1 / rna1.length()) + (valueRNA2 / rna2.length()));
		finalValue = finalValue * (0.7F + 0.2F * (valueRNA1 / valueRNA2) + 0.1F * random.nextFloat());
		return Float.valueOf(finalValue);
	}

	public static String getAnimalName(EntityLivingBase entity) {
		if (entity instanceof EntityBygoneAgeCreature) {
			return ((EntityBygoneAgeCreature) entity).getCreatureName();
		} else if (entity instanceof EntityChicken) {
			return BygoneAgeGeneticsInformation.CHICKEN.getCreatureName();
		} else if (entity instanceof EntitySheep) {
			return BygoneAgeGeneticsInformation.SHEEP.getCreatureName();
		} else if (entity instanceof EntityPig) {
			return BygoneAgeGeneticsInformation.PIG.getCreatureName();
		} else if (entity instanceof EntityCow) {
			return BygoneAgeGeneticsInformation.COW.getCreatureName();
		}
		return "THIS IS A BUG, PLEASE REPORT TO THE MOD DEVELOPER!";
	}

	public static String getRandomAnimalNameForDNA() {
		String name = BygoneAgeGeneticsInformation.CREATURELIST.get((byte) (4 + random.nextInt(BygoneAgeGeneticsInformation.CREATURELIST.size())));
		if (name == null) {
			return "THIS IS A BUG, PLEASE REPORT TO THE MOD DEV!";
		} else {
			return name;
		}
	}
}
