package com.rafamv.fossilhunting.handler;

import java.util.Random;

import net.minecraft.entity.EntityList;

import com.rafamv.fossilhunting.FossilHunting;

import cpw.mods.fml.common.registry.EntityRegistry;

public class FHEntityHandler {
	
	public static void registerDinosaur(Class entityClass, String name) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 16777215;
		int subColor = random.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, FossilHunting.instance, 64, 3, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
	}
	
	/*
	public static void registerSpawnableDinosaur(Class entityClass, String name) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 16777215;
		int subColor = random.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.addSpawn(entityClass, 50, 0, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
		EntityRegistry.registerModEntity(entityClass, name, entityId, FossilHunting.instance, 64, 3, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
	}
	*/
}
