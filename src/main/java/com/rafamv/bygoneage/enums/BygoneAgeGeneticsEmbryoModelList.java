package com.rafamv.bygoneage.enums;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.util.ResourceLocation;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoArsinoitherium;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoBase;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoBasilosaurus;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoDeinotherium;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoLeptictidium;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoMammoth;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoMoeritherium;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoTitanisWalleri;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoUintatherium;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoWithArms;
import com.rafamv.bygoneage.client.renderer.model.ModelEmbryoWithArmsAndLegs;

public enum BygoneAgeGeneticsEmbryoModelList {

	BygoneAgeGeneticsEmbryoModelList();

	/** Sets a list of the embryo models in function of growth stage for the
	 * CHICKEN. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> CHICKENMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.CHICKEN.getNumberOfStages(); i++) {
			if (i > 3) {
				CHICKENMODELS.put(i, new ModelChicken());
			} else if ((i >= 0) && (i <= 1)) {
				CHICKENMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 1) && (i <= 2)) {
				CHICKENMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 2) && (i <= 3)) {
				CHICKENMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				CHICKENMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * CHICKEN. */
	public static final HashMap<Byte, ResourceLocation> CHICKENTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.CHICKEN.getNumberOfStages(); i++) {
			if (i > 3) {
				CHICKENTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/creatures/ChickenEmbryo.png"));
			} else {
				CHICKENTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * SHEEP. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> SHEEPMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.SHEEP.getNumberOfStages(); i++) {
			if (i > 6) {
				SHEEPMODELS.put(i, new ModelSheep1());
			} else if ((i >= 0) && (i <= 2)) {
				SHEEPMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 2) && (i <= 4)) {
				SHEEPMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 4) && (i <= 6)) {
				SHEEPMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				SHEEPMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * SHEEP. */
	public static final HashMap<Byte, ResourceLocation> SHEEPTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.SHEEP.getNumberOfStages(); i++) {
			if (i > 6) {
				SHEEPTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/SheepEmbryo.png"));
			} else {
				SHEEPTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the PIG.
	 * HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> PIGMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.PIG.getNumberOfStages(); i++) {
			if (i > 7) {
				PIGMODELS.put(i, new ModelPig());
			} else if ((i >= 0) && (i <= 3)) {
				PIGMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 3) && (i <= 5)) {
				PIGMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 5) && (i <= 7)) {
				PIGMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				PIGMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * PIG. */
	public static final HashMap<Byte, ResourceLocation> PIGTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.PIG.getNumberOfStages(); i++) {
			if (i > 7) {
				PIGTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/PigEmbryo.png"));
			} else {
				PIGTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the COW.
	 * HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> COWMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.COW.getNumberOfStages(); i++) {
			if (i > 3) {
				COWMODELS.put(i, new ModelCow());
			} else if ((i >= 0) && (i <= 1)) {
				COWMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 1) && (i <= 2)) {
				COWMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 2) && (i <= 3)) {
				COWMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				COWMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * COW. */
	public static final HashMap<Byte, ResourceLocation> COWTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (byte i = 0; i <= BygoneAgeGeneticsInformation.COW.getNumberOfStages(); i++) {
			if (i > 3) {
				COWTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/CowEmbryo.png"));
			} else {
				COWTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * LEPTICTIDIUM. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> LEPTICTIDIUMMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.LEPTICTIDIUM.getNumberOfStages(); i++) {
			if (i > 5) {
				LEPTICTIDIUMMODELS.put(i, new ModelEmbryoLeptictidium());
			} else if ((i >= 0) && (i <= 2)) {
				LEPTICTIDIUMMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 2) && (i <= 3)) {
				LEPTICTIDIUMMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 3) && (i <= 5)) {
				LEPTICTIDIUMMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				LEPTICTIDIUMMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * LEPTICTIDIUM. */
	public static final HashMap<Byte, ResourceLocation> LEPTICTIDIUMTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.LEPTICTIDIUM.getNumberOfStages(); i++) {
			if (i > 5) {
				LEPTICTIDIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				LEPTICTIDIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * MOETHERIUM. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> MOERITHERIUMMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.MOERITHERIUM.getNumberOfStages(); i++) {
			if (i > 7) {
				MOERITHERIUMMODELS.put(i, new ModelEmbryoMoeritherium());
			} else if ((i >= 0) && (i <= 3)) {
				MOERITHERIUMMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 3) && (i <= 5)) {
				MOERITHERIUMMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 5) && (i <= 7)) {
				MOERITHERIUMMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				MOERITHERIUMMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * MOETHERIUM. */
	public static final HashMap<Byte, ResourceLocation> MOERITHERIUMTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.MOERITHERIUM.getNumberOfStages(); i++) {
			if (i > 7) {
				MOERITHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				MOERITHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * UINTATHERIUM. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> UINTATHERIUMMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.UINTATHERIUM.getNumberOfStages(); i++) {
			if (i > 10) {
				UINTATHERIUMMODELS.put(i, new ModelEmbryoUintatherium());
			} else if ((i >= 0) && (i <= 4)) {
				UINTATHERIUMMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 4) && (i <= 7)) {
				UINTATHERIUMMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 7) && (i <= 10)) {
				UINTATHERIUMMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				UINTATHERIUMMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * UINTATHERIUM. */
	public static final HashMap<Byte, ResourceLocation> UINTATHERIUMTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.UINTATHERIUM.getNumberOfStages(); i++) {
			if (i > 10) {
				UINTATHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				UINTATHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * ARSINOITHERIUM. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> ARSINOITHERIUMMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.ARSINOITHERIUM.getNumberOfStages(); i++) {
			if (i > 12) {
				ARSINOITHERIUMMODELS.put(i, new ModelEmbryoArsinoitherium());
			} else if ((i >= 0) && (i <= 4)) {
				ARSINOITHERIUMMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 4) && (i <= 7)) {
				ARSINOITHERIUMMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 7) && (i <= 12)) {
				ARSINOITHERIUMMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				ARSINOITHERIUMMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * ARSINOITHERIUM. */
	public static final HashMap<Byte, ResourceLocation> ARSINOITHERIUMTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.ARSINOITHERIUM.getNumberOfStages(); i++) {
			if (i > 12) {
				ARSINOITHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				ARSINOITHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * TITANISWALLERI. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> TITANISWALLERIMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.TITANISWALLERI.getNumberOfStages(); i++) {
			if (i > 10) {
				TITANISWALLERIMODELS.put(i, new ModelEmbryoTitanisWalleri());
			} else if ((i >= 0) && (i <= 4)) {
				TITANISWALLERIMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 4) && (i <= 6)) {
				TITANISWALLERIMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 6) && (i <= 10)) {
				TITANISWALLERIMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				TITANISWALLERIMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * TITANISWALLERI. */
	public static final HashMap<Byte, ResourceLocation> TITANISWALLERITEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.TITANISWALLERI.getNumberOfStages(); i++) {
			if (i > 12) {
				TITANISWALLERITEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				TITANISWALLERITEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * BASILOSAURUS. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> BASILOSAURUSMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.BASILOSAURUS.getNumberOfStages(); i++) {
			if (i > 14) {
				BASILOSAURUSMODELS.put(i, new ModelEmbryoBasilosaurus());
			} else if ((i >= 0) && (i <= 5)) {
				BASILOSAURUSMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 5) && (i <= 8)) {
				BASILOSAURUSMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 8) && (i <= 14)) {
				BASILOSAURUSMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				BASILOSAURUSMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * BASILOSAURUS. */
	public static final HashMap<Byte, ResourceLocation> BASILOSAURUSTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.BASILOSAURUS.getNumberOfStages(); i++) {
			if (i > 14) {
				BASILOSAURUSTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				BASILOSAURUSTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * MAMMOTH. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> MAMMOTHMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.MAMMOTH.getNumberOfStages(); i++) {
			if (i > 18) {
				MAMMOTHMODELS.put(i, new ModelEmbryoMammoth());
			} else if ((i >= 0) && (i <= 5)) {
				MAMMOTHMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 5) && (i <= 10)) {
				MAMMOTHMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 10) && (i <= 18)) {
				MAMMOTHMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				MAMMOTHMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * MAMMOTH. */
	public static final HashMap<Byte, ResourceLocation> MAMMOTHTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.MAMMOTH.getNumberOfStages(); i++) {
			if (i > 14) {
				MAMMOTHTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				MAMMOTHTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of the embryo models in function of growth stage for the
	 * DEINOTHERIUM. HashMap<Byte(Stage), ModelBase(EmbryoModel)> */
	public static final HashMap<Byte, ModelBase> DEINOTHERIUMMODELS = new HashMap<Byte, ModelBase>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.DEINOTHERIUM.getNumberOfStages(); i++) {
			if (i > 18) {
				DEINOTHERIUMMODELS.put(i, new ModelEmbryoDeinotherium());
			} else if ((i >= 0) && (i <= 5)) {
				DEINOTHERIUMMODELS.put(i, new ModelEmbryoBase());
			} else if ((i > 5) && (i <= 10)) {
				DEINOTHERIUMMODELS.put(i, new ModelEmbryoWithArms());
			} else if ((i > 10) && (i <= 18)) {
				DEINOTHERIUMMODELS.put(i, new ModelEmbryoWithArmsAndLegs());
			} else {
				DEINOTHERIUMMODELS.put(i, new ModelEmbryoBase());
			}
		}
	}

	/** Sets a list of the embryo textures in function of growth stage for the
	 * MAMMOTH. */
	public static final HashMap<Byte, ResourceLocation> DEINOTHERIUMTEXTURES = new HashMap<Byte, ResourceLocation>();
	static {
		for (Byte i = 0; i <= BygoneAgeGeneticsInformation.DEINOTHERIUM.getNumberOfStages(); i++) {
			if (i > 14) {
				DEINOTHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			} else {
				DEINOTHERIUMTEXTURES.put(i, new ResourceLocation(BygoneAge.MODID + ":" + "textures/models/creatures/ModelEmbryo.png"));
			}
		}
	}

	/** Sets a list of all lists of embryo models in function of id. */
	public static final HashMap<Byte, HashMap<Byte, ModelBase>> EMBRYOMODELS = new HashMap<Byte, HashMap<Byte, ModelBase>>();
	static {
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.CHICKEN.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.CHICKENMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.SHEEP.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.SHEEPMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.PIG.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.SHEEPMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.COW.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.COWMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.LEPTICTIDIUMMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.MOERITHERIUMMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.UINTATHERIUMMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.ARSINOITHERIUMMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.TITANISWALLERIMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.BASILOSAURUSMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.MAMMOTH.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.MAMMOTHMODELS));
		EMBRYOMODELS.put(BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID(), new HashMap<Byte, ModelBase>(BygoneAgeGeneticsEmbryoModelList.DEINOTHERIUMMODELS));
	}

	public static final HashMap<Byte, HashMap<Byte, ResourceLocation>> EMBRYOTEXTURES = new HashMap<Byte, HashMap<Byte, ResourceLocation>>();
	static {
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.CHICKEN.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.CHICKENTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.SHEEP.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.SHEEPTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.PIG.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.SHEEPTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.COW.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.COWTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.LEPTICTIDIUM.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.LEPTICTIDIUMTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.MOERITHERIUM.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.MOERITHERIUMTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.UINTATHERIUM.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.UINTATHERIUMTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.ARSINOITHERIUM.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.ARSINOITHERIUMTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.TITANISWALLERI.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.TITANISWALLERITEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.BASILOSAURUS.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.BASILOSAURUSTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.MAMMOTH.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.MAMMOTHTEXTURES));
		EMBRYOTEXTURES.put(BygoneAgeGeneticsInformation.DEINOTHERIUM.getCreatureID(), new HashMap<Byte, ResourceLocation>(BygoneAgeGeneticsEmbryoModelList.DEINOTHERIUMTEXTURES));
	}

}
