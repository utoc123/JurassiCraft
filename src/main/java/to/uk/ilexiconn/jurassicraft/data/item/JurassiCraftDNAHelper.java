package to.uk.ilexiconn.jurassicraft.data.item;

import java.util.Random;

public class JurassiCraftDNAHelper {

	private static Random random = new Random();

	/** Returns a new DNA code (String) with size 15. */
	public static String createDefaultDNA() {
		String newDNA = "";
		for (int i = 0; i < 15; i++) {
			switch (random.nextInt(4)) {
				case 0:
					newDNA = newDNA + "A";
					break;
				case 1:
					newDNA = newDNA + "C";
					break;
				case 2:
					newDNA = newDNA + "G";
					break;
				case 3:
					newDNA = newDNA + "T";
					break;
				default:
					newDNA = newDNA + "_FAIL_";
			}
		}
		if (newDNA.length() != 15) {
			newDNA = "FAIL";
		}
		return newDNA;
	}

	/** Returns a new DNA code with a certain size. */
	public static String createDNA(int size) {
		String newDNA = "";
		for (int i = 0; i < size; i++) {
			switch (random.nextInt(4)) {
				case 0:
					newDNA = newDNA + "A";
					break;
				case 1:
					newDNA = newDNA + "C";
					break;
				case 2:
					newDNA = newDNA + "G";
					break;
				case 3:
					newDNA = newDNA + "T";
					break;
				default:
					newDNA = newDNA + "_FAIL_";
			}
		}
		if (newDNA.length() != size) {
			newDNA = "FAIL";
		}
		return newDNA;
	}

	/** Returns a modified DNA code depending on the quality. */
	public static String reviseDNA(String dna, int quality) {
		if (dna.length() > 0) {
			int changes = (int) (dna.length() * (100 - quality) / 100);
			for (int i = 0; i < changes; i++) {
				int charAt = random.nextInt(dna.length());
				String dna1 = dna.substring(0, charAt);
				String dna2 = dna.substring(charAt + 1, dna.length());
				String chatChanged = String.valueOf(dna.charAt(charAt));				
				while (chatChanged.equals(String.valueOf(dna.charAt(charAt)))) {
					switch (random.nextInt(4)) {
						case 0:
							chatChanged = "A";
							break;
						case 1:
							chatChanged = "C";
							break;
						case 2:
							chatChanged = "G";
							break;
						case 3:
							chatChanged = "T";
							break;
						default:
							chatChanged = "_FAIL_";
					}
				}
				dna = dna1 + chatChanged + dna2;
			}
		} else {
			dna = JurassiCraftDNAHelper.createDefaultDNA();
		}
		return dna;
	}

	/**
	 * Returns a float value depending on the DNA string from char at i = 0 to
	 * char at i = 3.
	 */
	public static float getDefaultGenderDNAQuality(String dna) {
		float quality = 0.5F;
		for (int i = 0; i < 3; i++) {
			switch (dna.charAt(i)) {
				case 'A':
					quality = quality - 0.10F;
					break;
				case 'C':
					quality = quality - 0.05F;
					break;
				case 'G':
					quality = quality + 0.05F;
					break;
				case 'T':
					quality = quality + 0.10F;
					break;
			}
		}
		return quality;
	}

	/** Returns a float value depending on the DNA string. */
	public static float getGenderDNAQuality(String dna, int fromChar, int toChar) {
		float quality = 0.5F;
		for (int i = fromChar; i < toChar + 1; i++) {
			switch (dna.charAt(i)) {
				case 'A':
					quality = quality - 0.10F;
					break;
				case 'C':
					quality = quality - 0.05F;
					break;
				case 'G':
					quality = quality + 0.05F;
					break;
				case 'T':
					quality = quality + 0.10F;
					break;
			}
		}
		return quality;
	}

	/**
	 * Returns a float value depending on the DNA string from char at i = 3 to
	 * char at i = 6.
	 */
	public static float getDefaultTextureDNAQuality(String dna) {
		float quality = 0.5F;
		for (int i = 3; i < 7; i++) {
			switch (dna.charAt(i)) {
				case 'A':
					quality = quality - 0.10F;
					break;
				case 'C':
					quality = quality - 0.05F;
					break;
				case 'G':
					quality = quality + 0.05F;
					break;
				case 'T':
					quality = quality + 0.10F;
					break;
			}
		}
		return quality;
	}

	/** Returns a float value depending on the DNA string. */
	public static float getTextureDNAQuality(String dna, int fromChar, int toChar) {
		float quality = 0.5F;
		for (int i = fromChar; i < toChar + 1; i++) {
			switch (dna.charAt(i)) {
				case 'A':
					quality = quality - 0.10F;
					break;
				case 'C':
					quality = quality - 0.05F;
					break;
				case 'G':
					quality = quality + 0.05F;
					break;
				case 'T':
					quality = quality + 0.10F;
					break;
			}
		}
		return quality;
	}

	/**
	 * Returns a float value depending on the DNA string from char at i = 7 to
	 * char at i = 14.
	 */
	public static float getDefaultGeneticDNAQuality(String dna) {
		float quality = 1.0F;
		for (int i = 7; i < 15; i++) {
			switch (dna.charAt(i)) {
				case 'A':
					quality = quality - 0.05F;
					break;
				case 'C':
					quality = quality - 0.025F;
					break;
				case 'G':
					quality = quality + 0.025F;
					break;
				case 'T':
					quality = quality + 0.05F;
					break;
			}
		}
		return quality;
	}

	/** Returns a float value depending on the DNA string. */
	public static float getGeneticDNAQuality(String dna, int fromChar, int toChar) {
		float quality = 1.0F;
		for (int i = fromChar; i < toChar + 1; i++) {
			switch (dna.charAt(i)) {
				case 'A':
					quality = quality - 0.05F;
					break;
				case 'C':
					quality = quality - 0.025F;
					break;
				case 'G':
					quality = quality + 0.025F;
					break;
				case 'T':
					quality = quality + 0.05F;
					break;
			}
		}
		return quality;
	}
}
