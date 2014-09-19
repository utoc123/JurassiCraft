package com.rafamv.bygoneage.registry;

import com.rafamv.bygoneage.BygoneAge;
import com.rafamv.bygoneage.entity.creatures.EntityArsinoitherium;
import com.rafamv.bygoneage.entity.creatures.EntityBasilosaurus;
import com.rafamv.bygoneage.entity.creatures.EntityDeinotherium;
import com.rafamv.bygoneage.entity.creatures.EntityLeptictidium;
import com.rafamv.bygoneage.entity.creatures.EntityMammoth;
import com.rafamv.bygoneage.entity.creatures.EntityMoeritherium;
import com.rafamv.bygoneage.entity.creatures.EntityTitanisWalleri;
import com.rafamv.bygoneage.entity.creatures.EntityUintatherium;

import cpw.mods.fml.common.registry.EntityRegistry;

public class BygoneAgeEntities {

	public static void registryAll() {
		registerEntity(EntityLeptictidium.class, "EntityLeptictidium");
		registerEntity(EntityMoeritherium.class, "EntityMoetherium");
		registerEntity(EntityUintatherium.class, "EntityUintatherium");
		registerEntity(EntityArsinoitherium.class, "EntityArsinoitherium");
		registerEntity(EntityTitanisWalleri.class, "EntityTitanisWalleri");
		registerEntity(EntityBasilosaurus.class, "EntityBasilosaurus");
		registerEntity(EntityMammoth.class, "EntityMammoth");
		registerEntity(EntityDeinotherium.class, "EntityDeinotherium");
	}

	public static void registerEntity(Class entityClass, String name) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, BygoneAge.instance, 96, 3, false);
	}
}
